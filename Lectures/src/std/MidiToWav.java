// java MidiToWav in.mid out.wav

// Written by Kevin Wayne (with help from ChatGPT)
package std;

import javax.sound.midi.*;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class MidiToWav {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java MidiToWav <input midi file> <output wav file>");
            System.exit(1);
        }

        File midiFile = new File(args[0]);
        File wavFile = new File(args[1]);
        if (!midiFile.exists()) {
            System.err.println("could not open MIDI file " + midiFile + " for reading");
            System.exit(1);
        }

        try {

            // Open synthesizer
            Synthesizer synthesizer = MidiSystem.getSynthesizer();
            synthesizer.open();

            // Use custom soundfont (if available)
            String soundfont = "/usr/local/lift/Soundfonts/FluidR3_GM2-2.sf2";
            File soundfontFile = new File(soundfont);
            if (soundfontFile.exists()) {
                Soundbank originalSoundbank = synthesizer.getDefaultSoundbank();
                Soundbank updatedSoundbank = MidiSystem.getSoundbank(soundfontFile);
                synthesizer.unloadAllInstruments(originalSoundbank);
                synthesizer.loadAllInstruments(updatedSoundbank);
            }
            else {
                 System.err.println("could not read soundfont " + soundfont);
                 System.err.println("using default soundfont");
            }

            // Read MIDI sequence from file
            Sequence sequence = MidiSystem.getSequence(midiFile);

            // Open a sequencer and set the sequence
            Sequencer sequencer = MidiSystem.getSequencer(false);
            sequencer.open();
            sequencer.setSequence(sequence);

            // Connect the sequencer to the synthesizer
            Transmitter transmitter = sequencer.getTransmitter();
            Receiver receiver = synthesizer.getReceiver();
            transmitter.setReceiver(receiver);

            // Define the audio format
            AudioFormat format = new AudioFormat(44100, 16, 2, true, false);

            // Create a line to capture the audio
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
            TargetDataLine line = (TargetDataLine) AudioSystem.getLine(info);
            line.open(format);
            line.start();

            // Create a thread to read the audio data
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            Thread captureThread = new Thread(() -> {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((sequencer.isRunning() ||  line.available() > 0) && (bytesRead = line.read(buffer, 0, buffer.length)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            });

            // Start the capture thread and sequencer
            captureThread.start();
            sequencer.start();

            // Wait for the sequencer to finish
            while (sequencer.isRunning()) {
                Thread.sleep(1000);
            }

            // Stop and close resources
            sequencer.stop();
            sequencer.close();
            synthesizer.close();
            line.stop();
            line.close();

            // Write captured audio data to WAV file
            byte[] audioData = out.toByteArray();
            ByteArrayInputStream bais = new ByteArrayInputStream(audioData);
            AudioInputStream audioInputStream = new AudioInputStream(bais, format, audioData.length / format.getFrameSize());
            AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, wavFile);
        }
        catch (InvalidMidiDataException | IOException | MidiUnavailableException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

