package std;
import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Soundbank;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.Track;

import java.io.File;
import java.io.IOException;


/**
 *  The {@code StdMidi} class provides easy-to-use static methods for playing
 *  musical notes in real time using MIDI. It also supports reading and writing
 *  audio files in the MIDI format.
 *  The <em>Musical Instrument Digital Interface</em> (MIDI) standard
 *  is a communication protocol that allows computers, musical instruments, and
 *  other hardware to communicate.
 *  {@code StdMidi} is built on top of
 *  <a href = "https://www.oracle.com/java/technologies/java-sound-api.html">Java's Sound API</a>,
 *  a powerful framework for audio playback, recording, mixing, MIDI synthesis, and more.
 *  The goal is to make real-time MIDI synthesis accessible to novice programmers.
 *  Advanced features of MIDI (such as sequencing or multiple instruments at the same time)
 *  are beyond the scope of this library.
 *  <p>
 *  <b>Getting started.</b>
 *  To use this class, you must have {@code StdMidi} in your Java classpath.
 *  Here are three possible ways to do this:
 *  <ul>
 *  <li> If you ran our autoinstaller, use the commands
 *  {@code javac-introcs} and {@code java-introcs} (or {@code javac-algs4}
 *  and {@code java-algs4}) when compiling and executing. These commands
 *  add {@code stdlib.jar} (or {@code algs4.jar}) to the Java classpath, which
 *  provides access to {@code StdMidi}.
 *  <li> Download <a href = "https://introcs.cs.princeton.edu/java/code/stdlib.jar">stdlib.jar</a>
 *  (or <a href = "https://algs4.cs.princeton.edu/code/algs4.jar">algs4.jar</a>)
 *  and add it to the Java classpath.
 *  <li> Download <a href = "https://introcs.cs.princeton.edu/java/stdlib/StdMidi.java">StdMidi.java</a>
 *  and put it in the working directory.
 *  </ul>
 *  <p>
 *  As a test, cut-and-paste the following short program into your editor:
 *  <pre>
 *  public class AxelF {
        StdMidi.setInstrument(StdMidi.SYNTH_BASS_1);
        StdMidi.setTempo(220);

        int[] pitches1  = { F4, REST, AF4, REST,  F4,  F4, BF4, F4, EF4 };
        double[] beats1 = { QN,   QN,  QN,   EN,  QN,  EN,  QN, QN,  QN };
        int[] pitches2  = { F4, REST,  C5, REST,  F4,  F4, DF5, C5, AF4 };
        double[] beats2 = { QN,   QN,  QN,   EN,  QN,  EN,  QN, QN,  QN };
        int[] pitches3  = { F4,   C5,  F5,   F4, EF4, EF4,  C4, G4,  F4, REST };
        double[] beats3 = { QN,   QN,  QN,   EN,  QN,  EN,  QN, QN, DQN, WN   };

        for (int i = 0; i &lt; pitches1.length; i++)
            StdMidi.playNote(pitches1[i], beats1[i]);
        for (int i = 0; i &lt; pitches2.length; i++)
            StdMidi.playNote(pitches2[i], beats2[i]);
        for (int i = 0; i &lt; pitches3.length; i++)
            StdMidi.playNote(pitches3[i], beats3[i]);
 *      }
 *  }
 *  </pre>
 *  <p>
 *  If you compile and execute the program, you should hear the first few notes of
 *  the electronic instrumental track <em>Axel F</em> by Harold Faltermeyer.
 *
 *  <p>
 *  <b>Playing pitched instruments.</b>
 *  You can use the following method to play an individual MIDI note with a given pitch::
 *  <ul>
 *  <li> {@link #playNote(int note, double beats)}
 *  </ul>
 *  <p>
 *  The MIDI note number is an integer between 0 and 127 (60 = Middle C)
 *  that specifies the pitch.
 *  The method plays the specified note for the specified duration (measured in beats).
 *  The special pitch {@code StdMidi.REST} corresponds to a <em>rest</em>.
 *  A rest has a duration but produces no sound.
 *
 *  <p>
 *  <b>Playing unpitched percussion instruments.</b>
 *  Unpitched instruments are not tuned to identifiable frequencies.
 *  You can use the following method to play unpitched percussion instruments
 *  (such as drums and cymbals):
 *  <ul>
 *  <li> {@link #playPercussion(int percussionInstrument, double beats)}
 *  </ul>
 *  <p>
 *  The method plays the specified percussive instrument for the specified
 *  duration (measured in beats).
 *  The {@code percussionInstrument} is an integer between 35 (acoustic bass drum)
 *  and 81 (open triangle).
 *
 *  <p>
 *  <b>Durations.</b>
 *  The durations are measured in <em>beats</em>, with one beat corresponding to a quarter note.
 *  The length of a beat is determined by the <em>tempo</em>, which is measured in
 *  beats per minute. The default tempo is 120 beats per minute,
 *  so each beat (or quarter note) lasts 0.5 seconds.
 *  <p>
 *  There are a number of predefined constants for common tempos, ranging from
 *  {@code StdMidi.LARGHISSIMO} (20 beats per minute) to
 *  {@code StdMidi.PRESTISSIMO} (200 beats per minute).
 *  You can set the tempo using the method:
 *  <ul>
 *  <li> {@link #setTempo(int beatsPerMinute)}
 *  </ul>
 *  <p>
 *  The {@code StdMidi} class provides predefined constants for
 *  standard musical durations (measured in beats), including
 *  {@code StdMidi.QUARTER_NOTE} (1 beat),
 *  {@code StdMidi.HALF_NOTE} (2 beats),
 *  {@code StdMidi.WHOLE_NOTE} (4 beats),
 *  {@code StdMidi.EIGHTH_NOTE} (1/2 beat), and
 *  {@code StdMidi.SIXTEENTH_NOTE} (1/4 beat).
 *  For brevity, you can also use
 *  {@code StdMidi.QN},
 *  {@code StdMidi.HN},
 *  {@code StdMidi.WN},
 *  {@code StdMidi.EN}, and
 *  {@code StdMidi.SN}.
 *
 *  <p>
 *  <b>Key velocities.</b>
 *  The key-down velocity indiciates the force with which a note is played.
 *  It controls the note's volume and/or brightness.
 *  Velocities range from 0 (silent) to 127 (loudest).
 *  The default MIDI velocity is 96.
 *  You can use change the key-down velocity using the method:
 *  <ul>
 *  <li> {@link #setVelocity(int velocity)}
 *  </ul>
 *
 *  <p>
 *  <b>Instruments.</b>
 *  The default MIDI instrument is an <em>Acousic Grand Piano</em>.
 *  You can use change the instrument using the method:
 *  <ul>
 *  <li> {@link #setInstrument(int instrument)}
 *  </ul>
 *  <p>
 *  Subsequent notes will be synthesized using that instrument.
 *  The {@code instrument} argument must be an integer between 1 and 128.
 *  The instrument is identified using the
 *  <a href = "https://en.wikipedia.org/wiki/General_MIDI">General MIDI</a> standard, which
 *  specifies 128 individual instruments and numbers them from 1 (<em>Acoustic Grand Piano</em>)
 *  to 128 (<em>Gunshot</em>).
 *  The {@code StdMidi} class provides pre-defined constants for these instruments,
 *  such as {@code StdMidi.ACOUSTIC_GRAND_PIANO} and {@code StdMidi.GUNSHOT}.
 *  Depending on the soundfont, each instrument may sound different.
 *
 *  <p>
 *  <b>Playing multiple notes at the same time.</b>
 *  For added control, you can use the following methods to play
 *  several notes (of different durations) at the same time.
 *  <ul>
 *  <li> {@link #noteOn(int note)}
 *  <li> {@link #pause(double duration)}
 *  <li> {@link #noteOff(int note)}
 *  <li> {@link #percussionOn(int instrument)}
 *  <li> {@link #percussionOff(int instrument)}
 *  </ul>
 *  <p>
 *  If a note has a natural decay (such as a piano or bass drum), it is not strictly
 *  necessary to call {@code noteOff()} or {@code percussionOff()}.
 *  Nevertheless, it is good practice to do so in order to avoid allocating
 *  unnecessary resources for a note that is no longer making sound.
 *  Also, some instruments have limited <em>polyphony</em> (number of notes you can
 *  play at the same time), so you may exceed this limit if you don't explicitly
 *  turn off the notes.
 *
 *  <p>
 *  <b>Playing MIDI files.</b>
 *  You can use the following method to play a MIDI file:
 *  <ul>
 *  <li> {@link #play(String filename)}
 *  <li> {@link #playInBackground(String filename)}
 *  </ul>
 *  <p>
 *  The {@code play()} method plays the MIDI file and waits until the
 *  audio file finishes playing before continuing.
 *  The {@code playInBackground()} method plays the MIDI file in a background thread
 *  (e.g., as a background score in your program).

 *  The {@code filename} must have the extension {@code .mid} or {@code .midi}.
 *
 *  <p>
 *  <b>Saving MIDI files.</b>
 *  You can use the following method to save the sequence of notes to a MIDI file:
 *  <ul>
 *  <li> {@link #save(String filename)}
 *  </ul>
 *  <p>
 *  The {@code filename} must have the extension {@code .mid} or {@code .midi}.
 *
 *
 *  <p>
 *  <b>Soundfonts.</b>
 *  A <em>soundfont</em> stores samples of musical instruments for MIDI playback.
 *  This determines how each musical instruments sounds.
 *  We recommend <a href = "https://member.keymusician.com/Member/FluidR3_GM/index.html">FluidR3</a>,
 *  pro-quality soundfont developed by Frank Wen and released under an
 *  <a href = "https://member.keymusician.com/Member/FluidR3_GM/README.html">open-source license</a>.
 *  If you ran our autoinstaller, it should be installed and configured automatically.
 *  If not, Java will default to an internal soundfont, known as Gervill.
 *  (On OS X, it is located in <code>~/.gervill/soundbank-emg.sf2</code>.)
 *  Alternatively, you can download
 *  {@code FluidR3_GM2-2.sf2} and install it at {@code /usr/local/lift/Soundfonts/FluidR3_GM2-2.sf2}.
 *
 *  @author Kevin Wayne
 */

public class StdMidi {

    /**
     *  The default MIDI tempo (120 beats per minute).
     */
    public static final int DEFAULT_TEMPO = 120;

    /**
     *  The default MIDI velocity (96).
     */
    public static final int DEFAULT_VELOCITY = 96;

    /**
     *  The default MIDI instrument (<em>Acoustic Grand Piano</em>).
     */
    public static final int DEFAULT_INSTRUMENT = 1;


    // private static final String SOUNDFONT_FILENAME = "/usr/local/lift/Soundfonts/MuseScore_General.sf2";
    // private static final String SOUNDFONT_FILENAME = "/usr/local/lift/Soundfonts/MuseScore_General.sf3";
    // private static final String SOUNDFONT_FILENAME = "/usr/local/lift/Soundfonts/MuseScore_General_HQ.sf3";
    private static final String SOUNDFONT_FILENAME = "/usr/local/lift/Soundfonts/FluidR3_GM2-2.sf2";

    private static MidiChannel channel;               // for real-time pitched instruments
    private static MidiChannel percussionChannel;     // for real-time unpitched percussion instruments
    private static int tempo;                         // current tempo
    private static int velocity;                      // current velocity

    // the synthesizer for playing MIDI files
    private static Synthesizer synthesizer;


    /* for playing MIDI files */
    // for playing MIDI files and blocking
    private static Object lock = new Object();

    // play in background thread
    private static final boolean BACKGROUND = true;


    /* for saving to file */
    private static final int MIDI_MESSAGE_IGNORE_BYTE = -1;
    private static final int MIDI_TICKS_PER_QUARTER_NOTE = 48;

    // MIDI channel number
    private static int channelNumber = -1;

    // MIDI file types
    private static final int ONE_TRACK = 0;
    private static final int SYNCHRONOUS = 1;
    private static final int ASYNCHRONOUS = 2;

    private static long tick;
    private static Sequence sequence;
    private static Track track;


    // tempo in beats per minute (quarter note = 1 beat)

    /**
     *  The tempo <em>larghissimo</em> (20 beats per minute).
     */
    public static final int LARGHISSIMO = 20;

    /**
     *  The tempo <em>grave</em> (40 beats per minute).
     */
    public static final int GRAVE = 40;

    /**
     *  The tempo <em>largo</em> (50 beats per minute).
     */
    public static final int LARGO = 50;

    /**
     *  The tempo <em>larghetto</em> (60 beats per minute).
     */
    public static final int LARGHETTO = 60;

    /**
     *  The tempo <em>adagio</em> (70 beats per minute).
     */
    public static final int ADAGIO = 70;

    /**
     *  The tempo <em>adagietto</em> (74 beats per minute).
     */
    public static final int ADAGIETTO = 74;

    /**
     *  The tempo <em>andante</em> (90 beats per minute).
     */
    public static final int ANDANTE = 90;

    /**
     *  The tempo <em>andantino</em> (96 beats per minute).
     */
    public static final int ANDANTINO = 96;

    /**
     *  The tempo <em>moderato</em> (110 beats per minute).
     */
    public static final int MODERATO = 110;

    /**
     *  The tempo <em>allegro</em> (140 beats per minute).
     */
    public static final int ALLEGRO = 140;

    /**
     *  The tempo <em>vivace</em> (166 beats per minute).
     */
    public static final int VIVACE = 166;

    /**
     *  The tempo <em>vivacissimo</em> (174 beats per minute).
     */
    public static final int VIVACISSIMO = 174;

    /**
     *  The tempo <em>presto</em> (180 beats per minute).
     */
    public static final int PRESTO = 180;

    /**
     *  The tempo <em>prestissimo</em> (200 beats per minute).
     */
    public static final int PRESTISSIMO = 200;

    // dynamic or volumes of notes (MIDI velocity)
    // https://jythonmusic.me/api/midi-constants/dynamic/

    /**
     *  The velocity 0. Playing a note with this velocity is equivalent to turning it off.
     */
    public static final int SILENT =  0;

    /**
     *  The velocity <em>pianississimo</em> (10).
     */
    public static final int PIANISSISSIMO =  10;

    /**
     *  The velocity <em>pianissimo</em> (25).
     */
    public static final int PIANISSIMO =  25;

    /**
     *  The velocity <em>piano</em> (50).
     */
    public static final int PIANO = 50;

    /**
     *  The velocity <em>mezzo piano</em> (60).
     */
    public static final int MEZZO_PIANO = 60;

    /**
     *  The velocity <em>mezzo forte</em> (70).
     */
    public static final int MEZZO_FORTE = 70;

    /**
     *  The velocity <em>forte</em> (85).
     */
    public static final int FORTE = 85;

    /**
     *  The velocity <em>fortissimo</em> (100).
     */
    public static final int FORTISSIMO = 100;

    /**
     *  The velocity <em>fortississimo</em> (120).
     */
    public static final int FORTISSISSIMO = 120;


    // MIDI note pitches (0 to 127)
    // https://jythonmusic.me/api/midi-constants/pitch/

    /**
     *  The note <em>A</em> in octave 4, also known as <em>Concert A</em> and <em>A440</em>.
     */
    public static final int CONCERT_A = 69;

    /**
     *  The note <em>C</em> in octave 4, also known as <em>Middle C</em>.
     */
    public static final int MIDDLE_C = 60;

    /**
     *  The note number corresponding to a rest.
     */
    public static final int REST = -1;

    /**
     *  The note <em>C</em> in octave -1.
     */
    public static final int C_1 = 0;

    /**
     *  The note <em>C</em>♯ in octave -1.
     */
    public static final int CS_1 = 1;

    /**
     *  The note <em>D</em>♭ in octave -1.
     */
    public static final int DF_1 = 1;

    /**
     *  The note <em>D</em> in octave -1.
     */
    public static final int D_1 = 2;

    /**
     *  The note <em>D</em>♯ in octave -1.
     */
    public static final int DS_1 = 3;

    /**
     *  The note <em>E</em>♭ in octave -1.
     */
    public static final int EF_1 = 3;

    /**
     *  The note <em>E</em> in octave -1.
     */
    public static final int E_1 = 4;

    /**
     *  The note <em>F</em> in octave -1.
     */
    public static final int F_1 = 5;

    /**
     *  The note <em>F</em>♯ in octave -1.
     */
    public static final int FS_1 = 6;

    /**
     *  The note <em>G</em>♭ in octave -1.
     */
    public static final int GF_1 = 6;

    /**
     *  The note <em>G</em> in octave -1.
     */
    public static final int G_1 = 7;

    /**
     *  The note <em>G</em>♯ in octave -1.
     */
    public static final int GS_1 = 8;

    /**
     *  The note <em>A</em>♭ in octave -1.
     */
    public static final int AF_1 = 8;

    /**
     *  The note <em>A</em> in octave -1.
     */
    public static final int A_1 = 9;

    /**
     *  The note <em>A</em>♯ in octave -1.
     */
    public static final int AS_1 = 10;

    /**
     *  The note <em>B</em>♭ in octave -1.
     */
    public static final int BF_1 = 10;

    /**
     *  The note <em>B</em> in octave -1.
     */
    public static final int B_1 = 11;

    /**
     *  The note <em>C</em> in octave 0.
     */
    public static final int C0 = 12;

    /**
     *  The note <em>C</em>♯ in octave 0.
     */
    public static final int CS0 = 13;

    /**
     *  The note <em>D</em>♭ in octave 0.
     */
    public static final int DF0 = 13;

    /**
     *  The note <em>D</em> in octave 0.
     */
    public static final int D0 = 14;

    /**
     *  The note <em>D</em>♯ in octave 0.
     */
    public static final int DS0 = 15;

    /**
     *  The note <em>E</em>♭ in octave 0.
     */
    public static final int EF0 = 15;

    /**
     *  The note <em>E</em> in octave 0.
     */
    public static final int E0 = 16;

    /**
     *  The note <em>F</em> in octave 0.
     */
    public static final int F0 = 17;

    /**
     *  The note <em>F</em>♯ in octave 0.
     */
    public static final int FS0 = 18;

    /**
     *  The note <em>G</em>♭ in octave 0.
     */
    public static final int GF0 = 18;

    /**
     *  The note <em>G</em> in octave 0.
     */
    public static final int G0 = 19;

    /**
     *  The note <em>G</em>♯ in octave 0.
     */
    public static final int GS0 = 20;

    /**
     *  The note <em>A</em>♭ in octave 0.
     */
    public static final int AF0 = 20;

    /**
     *  The note <em>A</em> in octave 0.
     */
    public static final int A0 = 21;

    /**
     *  The note <em>A</em>♯ in octave 0.
     */
    public static final int AS0 = 22;

    /**
     *  The note <em>B</em>♭ in octave 0.
     */
    public static final int BF0 = 22;

    /**
     *  The note <em>B</em> in octave 0.
     */
    public static final int B0 = 23;

    /**
     *  The note <em>C</em> in octave 1.
     */
    public static final int C1 = 24;

    /**
     *  The note <em>C</em>♯ in octave 1.
     */
    public static final int CS1 = 25;

    /**
     *  The note <em>D</em>♭ in octave 1.
     */
    public static final int DF1 = 25;

    /**
     *  The note <em>D</em> in octave 1.
     */
    public static final int D1 = 26;

    /**
     *  The note <em>D</em>♯ in octave 1.
     */
    public static final int DS1 = 27;

    /**
     *  The note <em>E</em>♭ in octave 1.
     */
    public static final int EF1 = 27;

    /**
     *  The note <em>E</em> in octave 1.
     */
    public static final int E1 = 28;

    /**
     *  The note <em>F</em> in octave 1.
     */
    public static final int F1 = 29;

    /**
     *  The note <em>F</em>♯ in octave 1.
     */
    public static final int FS1 = 30;

    /**
     *  The note <em>G</em>♭ in octave 1.
     */
    public static final int GF1 = 30;

    /**
     *  The note <em>G</em> in octave 1.
     */
    public static final int G1 = 31;

    /**
     *  The note <em>G</em>♯ in octave 1.
     */
    public static final int GS1 = 32;

    /**
     *  The note <em>A</em>♭ in octave 1.
     */
    public static final int AF1 = 32;

    /**
     *  The note <em>A</em> in octave 1.
     */
    public static final int A1 = 33;

    /**
     *  The note <em>A</em>♯ in octave 1.
     */
    public static final int AS1 = 34;

    /**
     *  The note <em>B</em>♭ in octave 1.
     */
    public static final int BF1 = 34;

    /**
     *  The note <em>B</em> in octave 1.
     */
    public static final int B1 = 35;

    /**
     *  The note <em>C</em> in octave 2.
     */
    public static final int C2 = 36;

    /**
     *  The note <em>C</em>♯ in octave 2.
     */
    public static final int CS2 = 37;

    /**
     *  The note <em>D</em>♭ in octave 2.
     */
    public static final int DF2 = 37;

    /**
     *  The note <em>D</em> in octave 2.
     */
    public static final int D2 = 38;

    /**
     *  The note <em>D</em>♯ in octave 2.
     */
    public static final int DS2 = 39;

    /**
     *  The note <em>E</em>♭ in octave 2.
     */
    public static final int EF2 = 39;

    /**
     *  The note <em>E</em> in octave 2.
     */
    public static final int E2 = 40;

    /**
     *  The note <em>F</em> in octave 2.
     */
    public static final int F2 = 41;

    /**
     *  The note <em>F</em>♯ in octave 2.
     */
    public static final int FS2 = 42;

    /**
     *  The note <em>G</em>♭ in octave 2.
     */
    public static final int GF2 = 42;

    /**
     *  The note <em>G</em> in octave 2.
     */
    public static final int G2 = 43;

    /**
     *  The note <em>G</em>♯ in octave 2.
     */
    public static final int GS2 = 44;

    /**
     *  The note <em>A</em>♭ in octave 2.
     */
    public static final int AF2 = 44;

    /**
     *  The note <em>A</em> in octave 2.
     */
    public static final int A2 = 45;

    /**
     *  The note <em>A</em>♯ in octave 2.
     */
    public static final int AS2 = 46;

    /**
     *  The note <em>B</em>♭ in octave 2.
     */
    public static final int BF2 = 46;

    /**
     *  The note <em>B</em> in octave 2.
     */
    public static final int B2 = 47;

    /**
     *  The note <em>C</em> in octave 3.
     */
    public static final int C3 = 48;

    /**
     *  The note <em>C</em>♯ in octave 3.
     */
    public static final int CS3 = 49;

    /**
     *  The note <em>D</em>♭ in octave 3.
     */
    public static final int DF3 = 49;

    /**
     *  The note <em>D</em> in octave 3.
     */
    public static final int D3 = 50;

    /**
     *  The note <em>D</em>♯ in octave 3.
     */
    public static final int DS3 = 51;

    /**
     *  The note <em>E</em>♭ in octave 3.
     */
    public static final int EF3 = 51;

    /**
     *  The note <em>E</em> in octave 3.
     */
    public static final int E3 = 52;

    /**
     *  The note <em>F</em> in octave 3.
     */
    public static final int F3 = 53;

    /**
     *  The note <em>F</em>♯ in octave 3.
     */
    public static final int FS3 = 54;

    /**
     *  The note <em>G</em>♭ in octave 3.
     */
    public static final int GF3 = 54;

    /**
     *  The note <em>G</em> in octave 3.
     */
    public static final int G3 = 55;

    /**
     *  The note <em>G</em>♯ in octave 3.
     */
    public static final int GS3 = 56;

    /**
     *  The note <em>A</em>♭ in octave 3.
     */
    public static final int AF3 = 56;

    /**
     *  The note <em>A</em> in octave 3.
     */
    public static final int A3 = 57;

    /**
     *  The note <em>A</em>♯ in octave 3.
     */
    public static final int AS3 = 58;

    /**
     *  The note <em>B</em>♭ in octave 3.
     */
    public static final int BF3 = 58;

    /**
     *  The note <em>B</em> in octave 3.
     */
    public static final int B3 = 59;

    /**
     *  The note <em>C</em> in octave 4.
     */
    public static final int C4 = 60;

    /**
     *  The note <em>C</em>♯ in octave 4.
     */
    public static final int CS4 = 61;

    /**
     *  The note <em>D</em>♭ in octave 4.
     */
    public static final int DF4 = 61;

    /**
     *  The note <em>D</em> in octave 4.
     */
    public static final int D4 = 62;

    /**
     *  The note <em>D</em>♯ in octave 4.
     */
    public static final int DS4 = 63;

    /**
     *  The note <em>E</em>♭ in octave 4.
     */
    public static final int EF4 = 63;

    /**
     *  The note <em>E</em> in octave 4.
     */
    public static final int E4 = 64;

    /**
     *  The note <em>F</em> in octave 4.
     */
    public static final int F4 = 65;

    /**
     *  The note <em>F</em>♯ in octave 4.
     */
    public static final int FS4 = 66;

    /**
     *  The note <em>G</em>♭ in octave 4.
     */
    public static final int GF4 = 66;

    /**
     *  The note <em>G</em> in octave 4.
     */
    public static final int G4 = 67;

    /**
     *  The note <em>G</em>♯ in octave 4.
     */
    public static final int GS4 = 68;

    /**
     *  The note <em>A</em>♭ in octave 4.
     */
    public static final int AF4 = 68;

    /**
     *  The note <em>A</em> in octave 4.
     */
    public static final int A4 = 69;

    /**
     *  The note <em>A</em>♯ in octave 4.
     */
    public static final int AS4 = 70;

    /**
     *  The note <em>B</em>♭ in octave 4.
     */
    public static final int BF4 = 70;

    /**
     *  The note <em>B</em> in octave 4.
     */
    public static final int B4 = 71;

    /**
     *  The note <em>C</em> in octave 5.
     */
    public static final int C5 = 72;

    /**
     *  The note <em>C</em>♯ in octave 5.
     */
    public static final int CS5 = 73;

    /**
     *  The note <em>D</em>♭ in octave 5.
     */
    public static final int DF5 = 73;

    /**
     *  The note <em>D</em> in octave 5.
     */
    public static final int D5 = 74;

    /**
     *  The note <em>D</em>♯ in octave 5.
     */
    public static final int DS5 = 75;

    /**
     *  The note <em>E</em>♭ in octave 5.
     */
    public static final int EF5 = 75;

    /**
     *  The note <em>E</em> in octave 5.
     */
    public static final int E5 = 76;

    /**
     *  The note <em>F</em> in octave 5.
     */
    public static final int F5 = 77;

    /**
     *  The note <em>F</em>♯ in octave 5.
     */
    public static final int FS5 = 78;

    /**
     *  The note <em>G</em>♭ in octave 5.
     */
    public static final int GF5 = 78;

    /**
     *  The note <em>G</em> in octave 5.
     */
    public static final int G5 = 79;

    /**
     *  The note <em>G</em>♯ in octave 5.
     */
    public static final int GS5 = 80;

    /**
     *  The note <em>A</em>♭ in octave 5.
     */
    public static final int AF5 = 80;

    /**
     *  The note <em>A</em> in octave 5.
     */
    public static final int A5 = 81;

    /**
     *  The note <em>A</em>♯ in octave 5.
     */
    public static final int AS5 = 82;

    /**
     *  The note <em>B</em>♭ in octave 5.
     */
    public static final int BF5 = 82;

    /**
     *  The note <em>B</em> in octave 5.
     */
    public static final int B5 = 83;

    /**
     *  The note <em>C</em> in octave 6.
     */
    public static final int C6 = 84;

    /**
     *  The note <em>C</em>♯ in octave 6.
     */
    public static final int CS6 = 85;

    /**
     *  The note <em>D</em>♭ in octave 6.
     */
    public static final int DF6 = 85;

    /**
     *  The note <em>D</em> in octave 6.
     */
    public static final int D6 = 86;

    /**
     *  The note <em>D</em>♯ in octave 6.
     */
    public static final int DS6 = 87;

    /**
     *  The note <em>E</em>♭ in octave 6.
     */
    public static final int EF6 = 87;

    /**
     *  The note <em>E</em> in octave 6.
     */
    public static final int E6 = 88;

    /**
     *  The note <em>F</em> in octave 6.
     */
    public static final int F6 = 89;

    /**
     *  The note <em>F</em>♯ in octave 6.
     */
    public static final int FS6 = 90;

    /**
     *  The note <em>G</em>♭ in octave 6.
     */
    public static final int GF6 = 90;

    /**
     *  The note <em>G</em> in octave 6.
     */
    public static final int G6 = 91;

    /**
     *  The note <em>G</em>♯ in octave 6.
     */
    public static final int GS6 = 92;

    /**
     *  The note <em>A</em>♭ in octave 6.
     */
    public static final int AF6 = 92;

    /**
     *  The note <em>A</em> in octave 6.
     */
    public static final int A6 = 93;

    /**
     *  The note <em>A</em>♯ in octave 6.
     */
    public static final int AS6 = 94;

    /**
     *  The note <em>B</em>♭ in octave 6.
     */
    public static final int BF6 = 94;

    /**
     *  The note <em>B</em> in octave 6.
     */
    public static final int B6 = 95;

    /**
     *  The note <em>C</em> in octave 7.
     */
    public static final int C7 = 96;

    /**
     *  The note <em>C</em>♯ in octave 7.
     */
    public static final int CS7 = 97;

    /**
     *  The note <em>D</em>♭ in octave 7.
     */
    public static final int DF7 = 97;

    /**
     *  The note <em>D</em> in octave 7.
     */
    public static final int D7 = 98;

    /**
     *  The note <em>D</em>♯ in octave 7.
     */
    public static final int DS7 = 99;

    /**
     *  The note <em>E</em>♭ in octave 7.
     */
    public static final int EF7 = 99;

    /**
     *  The note <em>E</em> in octave 7.
     */
    public static final int E7 = 100;

    /**
     *  The note <em>F</em> in octave 7.
     */
    public static final int F7 = 101;

    /**
     *  The note <em>F</em>♯ in octave 7.
     */
    public static final int FS7 = 102;

    /**
     *  The note <em>G</em>♭ in octave 7.
     */
    public static final int GF7 = 102;

    /**
     *  The note <em>G</em> in octave 7.
     */
    public static final int G7 = 103;

    /**
     *  The note <em>G</em>♯ in octave 7.
     */
    public static final int GS7 = 104;

    /**
     *  The note <em>A</em>♭ in octave 7.
     */
    public static final int AF7 = 104;

    /**
     *  The note <em>A</em> in octave 7.
     */
    public static final int A7 = 105;

    /**
     *  The note <em>A</em>♯ in octave 7.
     */
    public static final int AS7 = 106;

    /**
     *  The note <em>B</em>♭ in octave 7.
     */
    public static final int BF7 = 106;

    /**
     *  The note <em>B</em> in octave 7.
     */
    public static final int B7 = 107;

    /**
     *  The note <em>C</em> in octave 8.
     */
    public static final int C8 = 108;

    /**
     *  The note <em>C</em>♯ in octave 8.
     */
    public static final int CS8 = 109;

    /**
     *  The note <em>D</em>♭ in octave 8.
     */
    public static final int DF8 = 109;

    /**
     *  The note <em>D</em> in octave 8.
     */
    public static final int D8 = 110;

    /**
     *  The note <em>D</em>♯ in octave 8.
     */
    public static final int DS8 = 111;

    /**
     *  The note <em>E</em>♭ in octave 8.
     */
    public static final int EF8 = 111;

    /**
     *  The note <em>E</em> in octave 8.
     */
    public static final int E8 = 112;

    /**
     *  The note <em>F</em> in octave 8.
     */
    public static final int F8 = 113;

    /**
     *  The note <em>F</em>♯ in octave 8.
     */
    public static final int FS8 = 114;

    /**
     *  The note <em>G</em>♭ in octave 8.
     */
    public static final int GF8 = 114;

    /**
     *  The note <em>G</em> in octave 8.
     */
    public static final int G8 = 115;

    /**
     *  The note <em>G</em>♯ in octave 8.
     */
    public static final int GS8 = 116;

    /**
     *  The note <em>A</em>♭ in octave 8.
     */
    public static final int AF8 = 116;

    /**
     *  The note <em>A</em> in octave 8.
     */
    public static final int A8 = 117;

    /**
     *  The note <em>A</em>♯ in octave 8.
     */
    public static final int AS8 = 118;

    /**
     *  The note <em>B</em>♭ in octave 8.
     */
    public static final int BF8 = 118;

    /**
     *  The note <em>B</em> in octave 8.
     */
    public static final int B8 = 119;

    /**
     *  The note <em>C</em> in octave 9.
     */
    public static final int C9 = 120;

    /**
     *  The note <em>C</em>♯ in octave 9.
     */
    public static final int CS9 = 121;

    /**
     *  The note <em>D</em>♭ in octave 9.
     */
    public static final int DF9 = 121;

    /**
     *  The note <em>D</em> in octave 9.
     */
    public static final int D9 = 122;

    /**
     *  The note <em>D</em>♯ in octave 9.
     */
    public static final int DS9 = 123;

    /**
     *  The note <em>E</em>♭ in octave 9.
     */
    public static final int EF9 = 123;

    /**
     *  The note <em>E</em> in octave 9.
     */
    public static final int E9 = 124;

    /**
     *  The note <em>F</em> in octave 9.
     */
    public static final int F9 = 125;

    /**
     *  The note <em>F</em>♯ in octave 9.
     */
    public static final int FS9 = 126;

    /**
     *  The note <em>G</em>♭ in octave 9.
     */
    public static final int GF9 = 126;

    /**
     *  The note <em>G</em> in octave 9.
     */
    public static final int G9 = 127;



    // duration constants (quarter note = 1 beat)
    // https://jythonmusic.me/api/midi-constants/duration/

    /**
     *  The duration of a whole note (4 beats).
     */
    public static final double WN = 4.0;

    /**
     *  The duration of a double dotted half note (7/2 beats).
     */
    public static final double DDHN = 3.5;
    /**
     *  The duration of a dotted half note (3 beats).
     */
    public static final double DHN = 3.0;

    /**
     *  The duration of a half note (2 beats).
     */
    public static final double HN = 2.0;

    /**
     *  The duration of a double dotted quarter note (7/4 beats).
     */
    public static final double DDQN = 1.75;

    /**
     *  The duration of a dotted quarter note (3/2 beats).
     */
    public static final double DQN = 1.5;

    /**
     *  The duration of a half note triplet (4/3 beats).
     */
    public static final double HNT = 4.0/3.0;

    /**
     *  The duration of a quarter note (1 beat).
     */
    public static final double QN = 1.0;

    /**
     *  The duration of a double dotted eighth note (7/8 beat).
     */
    public static final double DDEN = 0.875;

    /**
     *  The duration of a quarter note triplet (2/3 beat).
     */
    public static final double QNT = 2.0/3.0;

    /**
     *  The duration of a double dotted eighth note (3/4 beats).
     */
    public static final double DEN = 0.75;

    /**
     *  The duration of an eighth note (1/2 beat).
     */
    public static final double EN = 0.5;

    /**
     *  The duration of a dotted sixteenth note (3/8 beat).
     */
    public static final double DSN = 0.375;

    /**
     *  The duration of an eighth note triplet (1/3 beat).
     */
    public static final double ENT = 1.0/3.0;

    /**
     *  The duration of a sixteenth note (1/4 beat).
     */
    public static final double SN = 0.25;

    /**
     *  The duration of a thirty-second note (1/8 beat).
     */
    public static final double TN = 0.125;

    /**
     *  The duration of a sixteenth note triplet (1/6 beat).
     */
    public static final double SNT = 1.0/6.0;

    /**
     *  The duration of a thirty-second note (1/8 beat).
     */
    public static final double TNT = 1.0/12.0;

    /**
     *  The duration of a whole note (4 beats).
     */
    public static final double WHOLE_NOTE = 4.0;

    /**
     *  The duration of a dotted half note (3 beats).
     */
    public static final double DOTTED_HALF_NOTE = 3.0;

    /**
     *  The duration of a double dotted half note (7/2 beats).
     */
    public static final double DOUBLE_DOTTED_HALF_NOTE = 3.5;

    /**
     *  The duration of a half note (2 beats).
     */
    public static final double HALF_NOTE = 2.0;

    /**
     *  The duration of a double dotted quarter note (7/4 beats).
     */
    public static final double DOUBLE_DOTTED_QUARTER_NOTE = 1.75;

    /**
     *  The duration of a dotted quarter note (3/2 beats).
     */
    public static final double DOTTED_QUARTER_NOTE = 1.5;

    /**
     *  The duration of a half note triplet (4/3 beats).
     */
    public static final double HALF_NOTE_TRIPLET = 4.0 / 3.0;

    /**
     *  The duration of a quarter note (1 beat).
     */
    public static final double QUARTER_NOTE = 1.0;

    /**
     *  The duration of a double dotted eighth note (7/8 beat).
     */
    public static final double DOUBLE_DOTTED_EIGHTH_NOTE = 0.875;

    /**
     *  The duration of a double dotted eighth note (3/4 beats).
     */
    public static final double DOTTED_EIGHTH_NOTE = 0.75;

    /**
     *  The duration of a quarter note triplet (2/3 beat).
     */
    public static final double QUARTER_NOTE_TRIPLET = 2.0 / 3.0;

    /**
     *  The duration of an eighth note (1/2 beat).
     */
    public static final double EIGHTH_NOTE = 0.5;

    /**
     *  The duration of a dotted sixteenth note (3/8 beat).
     */
    public static final double DOTTED_SIXTEENTH_NOTE = 0.375;

    /**
     *  The duration of an eighth note triplet (1/3 beat).
     */
    public static final double EIGHTH_NOTE_TRIPLET = 1.0 / 3.0;

    /**
     *  The duration of a sixteenth note (1/4 beat).
     */
    public static final double SIXTEENTH_NOTE = 0.25;

    /**
     *  The duration of a sixteenth note triplet (1/6 beat).
     */
    public static final double SIXTEENTH_NOTE_TRIPLET = 1.0/6.0;

    /**
     *  The duration of a thirty-second note (1/8 beat).
     */
    public static final double THIRTYSECOND_NOTE = 0.125;

    /**
     *  The duration of a thirty-second note triplet (1/12 beat).
     */
    public static final double THIRTYSECOND_NOTE_TRIPLET = 1.0/12.0;


    /***************************************************************************
     *  The instrument names, as reported by FluidR3 GM2-2.SF2.
     ***************************************************************************/

    /**
     *  The instrument <em>Acoustic Grand Piano</em>.
     */
    public static final int ACOUSTIC_GRAND_PIANO = 1;

    /**
     *  The instrument <em>Bright Acoustic Piano</em>.
     */
    public static final int BRIGHT_ACOUSTIC_PIANO = 2;

    /**
     *  The instrument <em>Electric Grand Piano</em>.
     */
    public static final int ELECTRIC_GRAND_PIANO = 3;

    /**
     *  The instrument <em>Honky Tonk Piano</em>.
     */
    public static final int HONKY_TONK_PIANO = 4;

    /**
     *  The instrument <em>Electric Piano 1</em>.
     */
    public static final int ELECTRIC_PIANO_1 = 5;

    /**
     *  The instrument <em>Electric Piano 2</em>.
     */
    public static final int ELECTRIC_PIANO_2 = 6;

    /**
     *  The instrument <em>Harpsichord</em>.
     */
    public static final int HARPSICHORD = 7;

    /**
     *  The instrument <em>Clavinet</em>.
     */
    public static final int CLAVINET = 8;

    /**
     *  The instrument <em>Celesta</em>.
     */
    public static final int CELESTA = 9;

    /**
     *  The instrument <em>Glockenspiel</em>.
     */
    public static final int GLOCKENSPIEL = 10;

    /**
     *  The instrument <em>Music Box</em>.
     */
    public static final int MUSIC_BOX = 11;

    /**
     *  The instrument <em>Vibraphone</em>.
     */
    public static final int VIBRAPHONE = 12;

    /**
     *  The instrument <em>Marimba</em>.
     */
    public static final int MARIMBA = 13;

    /**
     *  The instrument <em>Xylophone</em>.
     */
    public static final int XYLOPHONE = 14;

    /**
     *  The instrument <em>Tubular Bells</em>.
     */
    public static final int TUBULAR_BELLS = 15;

    /**
     *  The instrument <em>Dulcimer</em>.
     */
    public static final int DULCIMER = 16;

    /**
     *  The instrument <em>Drawbar Organ</em>.
     */
    public static final int DRAWBAR_ORGAN = 17;

    /**
     *  The instrument <em>Percussive Organ</em>.
     */
    public static final int PERCUSSIVE_ORGAN = 18;

    /**
     *  The instrument <em>Rock Organ</em>.
     */
    public static final int ROCK_ORGAN = 19;

    /**
     *  The instrument <em>Church Organ</em>.
     */
    public static final int CHURCH_ORGAN = 20;

    /**
     *  The instrument <em>Reed Organ</em>.
     */
    public static final int REED_ORGAN = 21;

    /**
     *  The instrument <em>Accordion</em>.
     */
    public static final int ACCORDION = 22;

    /**
     *  The instrument <em>Harmonica</em>.
     */
    public static final int HARMONICA = 23;

    /**
     *  The instrument <em>Bandoneon</em>.
     */
    public static final int BANDONEON = 24;

    /**
     *  The instrument <em>Nylon String Guitar</em>.
     */
    public static final int NYLON_STRING_GUITAR = 25;

    /**
     *  The instrument <em>Steel String Guitar</em>.
     */
    public static final int STEEL_STRING_GUITAR = 26;

    /**
     *  The instrument <em>Jazz Guitar</em>.
     */
    public static final int JAZZ_GUITAR = 27;

    /**
     *  The instrument <em>Clean Guitar</em>.
     */
    public static final int CLEAN_GUITAR = 28;

    /**
     *  The instrument <em>Palm Muted Guitar</em>.
     */
    public static final int PALM_MUTED_GUITAR = 29;

    /**
     *  The instrument <em>Overdrive Guitar</em>.
     */
    public static final int OVERDRIVE_GUITAR = 30;

    /**
     *  The instrument <em>Distortion Guitar</em>.
     */
    public static final int DISTORTION_GUITAR = 31;

    /**
     *  The instrument <em>Guitar Harmonics</em>.
     */
    public static final int GUITAR_HARMONICS = 32;

    /**
     *  The instrument <em>Acoustic Bass</em>.
     */
    public static final int ACOUSTIC_BASS = 33;

    /**
     *  The instrument <em>Fingered Bass</em>.
     */
    public static final int FINGERED_BASS = 34;

    /**
     *  The instrument <em>Picked Bass</em>.
     */
    public static final int PICKED_BASS = 35;

    /**
     *  The instrument <em>Fretless Bass</em>.
     */
    public static final int FRETLESS_BASS = 36;

    /**
     *  The instrument <em>Slap Bass</em>.
     */
    public static final int SLAP_BASS = 37;

    /**
     *  The instrument <em>Pop Bass</em>.
     */
    public static final int POP_BASS = 38;

    /**
     *  The instrument <em>Synth Bass 1</em>.
     */
    public static final int SYNTH_BASS_1 = 39;

    /**
     *  The instrument <em>Synth Bass 2</em>.
     */
    public static final int SYNTH_BASS_2 = 40;

    /**
     *  The instrument <em>Violin</em>.
     */
    public static final int VIOLIN = 41;

    /**
     *  The instrument <em>Viola</em>.
     */
    public static final int VIOLA = 42;

    /**
     *  The instrument <em>Cello</em>.
     */
    public static final int CELLO = 43;

    /**
     *  The instrument <em>Contrabass</em>.
     */
    public static final int CONTRABASS = 44;

    /**
     *  The instrument <em>Tremolo Strings</em>.
     */
    public static final int TREMOLO_STRINGS = 45;

    /**
     *  The instrument <em>Pizzicato Strings</em>.
     */
    public static final int PIZZICATO_STRINGS = 46;

    /**
     *  The instrument <em>Harp</em>.
     */
    public static final int HARP = 47;

    /**
     *  The instrument <em>Timpani</em>.
     */
    public static final int TIMPANI = 48;

    /**
     *  The instrument <em>Strings</em>.
     */
    public static final int STRINGS = 49;

    /**
     *  The instrument <em>Slow Strings</em>.
     */
    public static final int SLOW_STRINGS = 50;

    /**
     *  The instrument <em>Synth Strings 1</em>.
     */
    public static final int SYNTH_STRINGS_1 = 51;

    /**
     *  The instrument <em>Synth Strings 2</em>.
     */
    public static final int SYNTH_STRINGS_2 = 52;

    /**
     *  The instrument <em>Ahh Choir</em>.
     */
    public static final int AHH_CHOIR = 53;

    /**
     *  The instrument <em>Ohh Voices</em>.
     */
    public static final int OHH_VOICES = 54;

    /**
     *  The instrument <em>Synth Voice</em>.
     */
    public static final int SYNTH_VOICE = 55;

    /**
     *  The instrument <em>Orchestra Hit</em>.
     */
    public static final int ORCHESTRA_HIT = 56;

    /**
     *  The instrument <em>Trumpet</em>.
     */
    public static final int TRUMPET = 57;

    /**
     *  The instrument <em>Trombone</em>.
     */
    public static final int TROMBONE = 58;

    /**
     *  The instrument <em>Tuba</em>.
     */
    public static final int TUBA = 59;

    /**
     *  The instrument <em>Muted Trumpet</em>.
     */
    public static final int MUTED_TRUMPET = 60;

    /**
     *  The instrument <em>French Horn</em>.
     */
    public static final int FRENCH_HORN = 61;

    /**
     *  The instrument <em>Brass Section</em>.
     */
    public static final int BRASS_SECTION = 62;

    /**
     *  The instrument <em>Synth Brass 1</em>.
     */
    public static final int SYNTH_BRASS_1 = 63;

    /**
     *  The instrument <em>Synth Brass 2</em>.
     */
    public static final int SYNTH_BRASS_2 = 64;

    /**
     *  The instrument <em>Soprano Sax</em>.
     */
    public static final int SOPRANO_SAX = 65;

    /**
     *  The instrument <em>Alto Sax</em>.
     */
    public static final int ALTO_SAX = 66;

    /**
     *  The instrument <em>Tenor Sax</em>.
     */
    public static final int TENOR_SAX = 67;

    /**
     *  The instrument <em>Baritone Sax</em>.
     */
    public static final int BARITONE_SAX = 68;

    /**
     *  The instrument <em>Oboe</em>.
     */
    public static final int OBOE = 69;

    /**
     *  The instrument <em>English Horn</em>.
     */
    public static final int ENGLISH_HORN = 70;

    /**
     *  The instrument <em>Bassoon</em>.
     */
    public static final int BASSOON = 71;

    /**
     *  The instrument <em>Clarinet</em>.
     */
    public static final int CLARINET = 72;

    /**
     *  The instrument <em>Piccolo</em>.
     */
    public static final int PICCOLO = 73;

    /**
     *  The instrument <em>Flute</em>.
     */
    public static final int FLUTE = 74;

    /**
     *  The instrument <em>Recorder</em>.
     */
    public static final int RECORDER = 75;

    /**
     *  The instrument <em>Pan Flute</em>.
     */
    public static final int PAN_FLUTE = 76;

    /**
     *  The instrument <em>Bottle Chiff</em>.
     */
    public static final int BOTTLE_CHIFF = 77;

    /**
     *  The instrument <em>Shakuhachi</em>.
     */
    public static final int SHAKUHACHI = 78;

    /**
     *  The instrument <em>Whistle</em>.
     */
    public static final int WHISTLE = 79;

    /**
     *  The instrument <em>Ocarina</em>.
     */
    public static final int OCARINA = 80;

    /**
     *  The instrument <em>Square Lead</em>.
     */
    public static final int SQUARE_LEAD = 81;

    /**
     *  The instrument <em>Saw Wave</em>.
     */
    public static final int SAW_WAVE = 82;

    /**
     *  The instrument <em>Calliope Lead</em>.
     */
    public static final int CALLIOPE_LEAD = 83;

    /**
     *  The instrument <em>Chiffer Lead</em>.
     */
    public static final int CHIFFER_LEAD = 84;

    /**
     *  The instrument <em>Charang</em>.
     */
    public static final int CHARANG = 85;

    /**
     *  The instrument <em>Solo Vox</em>.
     */
    public static final int SOLO_VOX = 86;

    /**
     *  The instrument <em>Fifth Sawtooth Wave</em>.
     */
    public static final int FIFTH_SAWTOOTH_WAVE = 87;

    /**
     *  The instrument <em>Bass and Lead</em>.
     */
    public static final int BASS_AND_LEAD = 88;

    /**
     *  The instrument <em>Fantasia</em>.
     */
    public static final int FANTASIA = 89;

    /**
     *  The instrument <em>Warm Pad</em>.
     */
    public static final int WARM_PAD = 90;

    /**
     *  The instrument <em>Polysynth</em>.
     */
    public static final int POLYSYNTH = 91;

    /**
     *  The instrument <em>Space Voice</em>.
     */
    public static final int SPACE_VOICE = 92;

    /**
     *  The instrument <em>Bowed Glass</em>.
     */
    public static final int BOWED_GLASS = 93;

    /**
     *  The instrument <em>Metal Pad</em>.
     */
    public static final int METAL_PAD = 94;

    /**
     *  The instrument <em>Halo Pad</em>.
     */
    public static final int HALO_PAD = 95;

    /**
     *  The instrument <em>Sweep Pad</em>.
     */
    public static final int SWEEP_PAD = 96;

    /**
     *  The instrument <em>Ice Rain</em>.
     */
    public static final int ICE_RAIN = 97;

    /**
     *  The instrument <em>Soundtrack</em>.
     */
    public static final int SOUNDTRACK = 98;

    /**
     *  The instrument <em>Crystal</em>.
     */
    public static final int CRYSTAL = 99;

    /**
     *  The instrument <em>Atmosphere</em>.
     */
    public static final int ATMOSPHERE = 100;

    /**
     *  The instrument <em>Brightness</em>.
     */
    public static final int BRIGHTNESS = 101;

    /**
     *  The instrument <em>Goblin</em>.
     */
    public static final int GOBLIN = 102;

    /**
     *  The instrument <em>Echo Drops</em>.
     */
    public static final int ECHO_DROPS = 103;

    /**
     *  The instrument <em>Star Theme</em>.
     */
    public static final int STAR_THEME = 104;

    /**
     *  The instrument <em>Sitar</em>.
     */
    public static final int SITAR = 105;

    /**
     *  The instrument <em>Banjo</em>.
     */
    public static final int BANJO = 106;

    /**
     *  The instrument <em>Shamisen</em>.
     */
    public static final int SHAMISEN = 107;

    /**
     *  The instrument <em>Koto</em>.
     */
    public static final int KOTO = 108;

    /**
     *  The instrument <em>Kalimba</em>.
     */
    public static final int KALIMBA = 109;

    /**
     *  The instrument <em>Bagpipe</em>.
     */
    public static final int BAGPIPE = 110;

    /**
     *  The instrument <em>Fiddle</em>.
     */
    public static final int FIDDLE = 111;

    /**
     *  The instrument <em>Shehnai</em>.
     */
    public static final int SHEHNAI = 112;

    /**
     *  The instrument <em>Tinkle Bell</em>.
     */
    public static final int TINKLE_BELL = 113;

    /**
     *  The instrument <em>Agogô</em>.
     */
    public static final int AGOGÔ = 114;

    /**
     *  The instrument <em>Steel Drums</em>.
     */
    public static final int STEEL_DRUMS = 115;

    /**
     *  The instrument <em>Woodblock</em>.
     */
    public static final int WOODBLOCK = 116;

    /**
     *  The instrument <em>Taiko Drum</em>.
     */
    public static final int TAIKO_DRUM = 117;

    /**
     *  The instrument <em>Melodic Tom</em>.
     */
    public static final int MELODIC_TOM = 118;

    /**
     *  The instrument <em>Synth Drum</em>.
     */
    public static final int SYNTH_DRUM = 119;

    /**
     *  The instrument <em>Reverse Cymbal</em>.
     */
    public static final int REVERSE_CYMBAL = 120;

    /**
     *  The instrument <em>Fret Noise</em>.
     */
    public static final int FRET_NOISE = 121;

    /**
     *  The instrument <em>Breath Noise</em>.
     */
    public static final int BREATH_NOISE = 122;

    /**
     *  The instrument <em>Sea Shore</em>.
     */
    public static final int SEA_SHORE = 123;

    /**
     *  The instrument <em>Bird Tweet</em>.
     */
    public static final int BIRD_TWEET = 124;

    /**
     *  The instrument <em>Telephone</em>.
     */
    public static final int TELEPHONE = 125;

    /**
     *  The instrument <em>Helicopter</em>.
     */
    public static final int HELICOPTER = 126;

    /**
     *  The instrument <em>Applause</em>.
     */
    public static final int APPLAUSE = 127;

    /**
     *  The instrument <em>Gunshot</em>.
     */
    public static final int GUNSHOT = 128;


    /***************************************************************************
     *  The percussion instruments.
     *  See https://en.wikipedia.org/wiki/General_MIDI
     ***************************************************************************/

    /**
     *  The percussion instrument <em>Acoustic Bass Drum</em>.
     */
    public static final int ACOUSTIC_BASS_DRUM = 35;

    /**
     *  The percussion instrument <em>Electric Bass Drum</em>.
     */
    public static final int ELECTRIC_BASS_DRUM = 36;

    /**
     *  The percussion instrument <em>Side Stick</em>.
     */
    public static final int SIDE_STICK = 37;

    /**
     *  The percussion instrument <em>Acoustic Snare</em>.
     */
    public static final int ACOUSTIC_SNARE = 38;

    /**
     *  The percussion instrument <em>Hand Clap</em>.
     */
    public static final int HAND_CLAP = 39;

    /**
     *  The percussion instrument <em>Electric Snare</em>.
     */
    public static final int ELECTRIC_SNARE = 40;

    /**
     *  The percussion instrument <em>Low Floor Tom</em>.
     */
    public static final int LOW_FLOOR_TOM = 41;

    /**
     *  The percussion instrument <em>Closed Hi Hat</em>.
     */
    public static final int CLOSED_HI_HAT = 42;

    /**
     *  The percussion instrument <em>High Floor Tom</em>.
     */
    public static final int HIGH_FLOOR_TOM = 43;

    /**
     *  The percussion instrument <em>Pedal Hi Hat</em>.
     */
    public static final int PEDAL_HI_HAT = 44;

    /**
     *  The percussion instrument <em>Low Tom</em>.
     */
    public static final int LOW_TOM = 45;

    /**
     *  The percussion instrument <em>Open Hi Hat</em>.
     */
    public static final int OPEN_HI_HAT = 46;

    /**
     *  The percussion instrument <em>Low Mid Tom</em>.
     */
    public static final int LOW_MID_TOM = 47;

    /**
     *  The percussion instrument <em>High Mid Tom</em>.
     */
    public static final int HIGH_MID_TOM = 48;

    /**
     *  The percussion instrument <em>Crash Cymbal 1</em>.
     */
    public static final int CRASH_CYMBAL_1 = 49;

    /**
     *  The percussion instrument <em>High Tom</em>.
     */
    public static final int HIGH_TOM = 50;

    /**
     *  The percussion instrument <em>Ride Cymbal 1</em>.
     */
    public static final int RIDE_CYMBAL_1 = 51;

    /**
     *  The percussion instrument <em>Chinese Cymbal</em>.
     */
    public static final int CHINESE_CYMBAL = 52;

    /**
     *  The percussion instrument <em>Ride Bell</em>.
     */
    public static final int RIDE_BELL = 53;

    /**
     *  The percussion instrument <em>Tambourine</em>.
     */
    public static final int TAMBOURINE = 54;

    /**
     *  The percussion instrument <em>Splash Cymbal</em>.
     */
    public static final int SPLASH_CYMBAL = 55;

    /**
     *  The percussion instrument <em>Cowbell</em>.
     */
    public static final int COWBELL = 56;

    /**
     *  The percussion instrument <em>Crash Cymbal 2</em>.
     */
    public static final int CRASH_CYMBAL_2 = 57;

    /**
     *  The percussion instrument <em>Vibraslap</em>.
     */
    public static final int VIBRASLAP = 58;

    /**
     *  The percussion instrument <em>Ride Cymbal 2</em>.
     */
    public static final int RIDE_CYMBAL_2 = 59;

    /**
     *  The percussion instrument <em>High Bongo</em>.
     */
    public static final int HIGH_BONGO = 60;

    /**
     *  The percussion instrument <em>Low Bongo</em>.
     */
    public static final int LOW_BONGO = 61;

    /**
     *  The percussion instrument <em>Mute Hi Conga</em>.
     */
    public static final int MUTE_HI_CONGA = 62;

    /**
     *  The percussion instrument <em>Open Hi Conga</em>.
     */
    public static final int OPEN_HI_CONGA = 63;

    /**
     *  The percussion instrument <em>Low Conga</em>.
     */
    public static final int LOW_CONGA = 64;

    /**
     *  The percussion instrument <em>High Timbale</em>.
     */
    public static final int HIGH_TIMBALE = 65;

    /**
     *  The percussion instrument <em>Low Timbale</em>.
     */
    public static final int LOW_TIMBALE = 66;

    /**
     *  The percussion instrument <em>High Agogô</em>.
     */
    public static final int HIGH_AGOGÔ = 67;

    /**
     *  The percussion instrument <em>Low Agogô</em>.
     */
    public static final int LOW_AGOGÔ = 68;

    /**
     *  The percussion instrument <em>Cabasa</em>.
     */
    public static final int CABASA = 69;

    /**
     *  The percussion instrument <em>Maracas</em>.
     */
    public static final int MARACAS = 70;

    /**
     *  The percussion instrument <em>Short Whistle</em>.
     */
    public static final int SHORT_WHISTLE = 71;

    /**
     *  The percussion instrument <em>Long Whistle</em>.
     */
    public static final int LONG_WHISTLE = 72;

    /**
     *  The percussion instrument <em>Short Guiro</em>.
     */
    public static final int SHORT_GUIRO = 73;

    /**
     *  The percussion instrument <em>Long Guiro</em>.
     */
    public static final int LONG_GUIRO = 74;

    /**
     *  The percussion instrument <em>Claves</em>.
     */
    public static final int CLAVES = 75;

    /**
     *  The percussion instrument <em>High Woodblock</em>.
     */
    public static final int HIGH_WOODBLOCK = 76;

    /**
     *  The percussion instrument <em>Low Woodblock</em>.
     */
    public static final int LOW_WOODBLOCK = 77;

    /**
     *  The percussion instrument <em>Mute Cuica</em>.
     */
    public static final int MUTE_CUICA = 78;

    /**
     *  The percussion instrument <em>Open Cuica</em>.
     */
    public static final int OPEN_CUICA = 79;

    /**
     *  The percussion instrument <em>Mute Triangle</em>.
     */
    public static final int MUTE_TRIANGLE = 80;

    /**
     *  The percussion instrument <em>Open Triangle</em>.
     */
    public static final int OPEN_TRIANGLE = 81;


    // singleton pattern: client can't instantiate
    private StdMidi() { }

    static {
        tempo = DEFAULT_TEMPO;
        velocity = DEFAULT_VELOCITY;
        try {
            synthesizer = MidiSystem.getSynthesizer();
            synthesizer.open();
            MidiChannel[] channels = synthesizer.getChannels();
            channel = channels[0];
            percussionChannel = channels[9];  // MIDI channel 10 is for percussion
        }
        catch (MidiUnavailableException e) {
            System.err.println("Couldn't open a MIDI device");
        }

        setSoundbank(synthesizer, SOUNDFONT_FILENAME);
        startRecording();
    }

    private static void startRecording() {
        try {
            // use tempo-based timing: pulses per quarter note (Sequence.PPQ)
            sequence = new Sequence(Sequence.PPQ, MIDI_TICKS_PER_QUARTER_NOTE);
            // track = sequence.createTrack();
            tick = 0;
            setInstrument(DEFAULT_INSTRUMENT);
            tick++;
        }
        catch(InvalidMidiDataException e) {
             System.out.println(e);
        }
        catch(Exception e) {
             System.out.println(e);
        }
    }


    private static void setSoundbank(Synthesizer synthesizer, String filename) {
        // use better soundbank, if available
        try {
            // look in specified location
            File file = new File(filename);
            if (file.exists()) {
                Soundbank originalSoundbank = synthesizer.getDefaultSoundbank();
                Soundbank updatedSoundbank = MidiSystem.getSoundbank(file);
                synthesizer.unloadAllInstruments(originalSoundbank);
                synthesizer.loadAllInstruments(updatedSoundbank);
            }
        }
        catch (IOException e) {
            System.err.println("Couldn't read soundfont from " + filename);
            System.err.println("Reverting to default soundfont.");
            System.err.println(e);
        }
        catch (InvalidMidiDataException e) {
            System.err.println("Couldn't read MIDI data from " + filename);
        }
    }

    private static void validateVelocity(int val) {
        if (val < 0 || val > 127)
            throw new IllegalArgumentException("MIDI velocity must be between 0 and 127: " + val);
    }

    private static void validateTempo(int val) {
        if (val <= 0)
            throw new IllegalArgumentException("the tempo (beats per minute) must be a positive integer: " + val);
    }

    private static void validateNote(int val) {
        if (val < -1 || val > 127)
            throw new IllegalArgumentException("the pitch must be between 0 and 127: " + val);
    }

    private static void validateDuration(double val) {
        if (val < 0.0)
            throw new IllegalArgumentException("the number of beats must be non-negative: " + val);
    }

    private static void validateInstrument(int val) {
        if (val <= 0 || val > 128)
            throw new IllegalArgumentException("the MIDI instrument number must be between 1 and 128: " + val);
    }

    private static void validatePercussionInstrument(int val) {
        if (val != -1 && (val < 35 || val > 81))
            throw new IllegalArgumentException("the percussion instrument number must be between 35 and 81: " + val);
    }


    /**
     * Sets the MIDI instrument to the specified value.
     * For example 1 corresponds to an acoustic grand piano and 39 corresponds to a synthetic bass.
     * You can specify the instrument numbers using predefined constants, such as
     * {@code StdMidi.ACOUSTIC_GRAND_PIANO} and {@code StdMidi.SYNTH_BASS_1}.
     *
     * @param  instrument the integer corresponding to the MIDI instrument
     * @throws IllegalArgumentException unless {@code instrument} is between 1 and 128
     */
    public static void setInstrument(int instrument) {
        validateInstrument(instrument);
        channel.programChange(instrument);

        /* for recording */
        try {
            // create a separate track for each instrument change
            // each instrument is in its own channel (max = 16 channels and channel 9 typically for percussion)
            track = sequence.createTrack();
            channelNumber++;
            ShortMessage instrumentChange = new ShortMessage(ShortMessage.PROGRAM_CHANGE, channelNumber, instrument, MIDI_MESSAGE_IGNORE_BYTE);
            track.add(new MidiEvent(instrumentChange, tick));
        }
        catch(InvalidMidiDataException e) {
             System.out.println(e);
        }
    }

    /**
     * Returns the MIDI instrument number (between 1 and 128).
     *
     * @return the integer corresponding to the MIDI instrument
     */
    public static int getInstrument() {
        return channel.getProgram();
    }

    /**
     * Sets the velocity to the specified value between 0 (silent) and 127 (loudest).
     * The key-down velocity indicates the force with which a note is played.
     * It controls the note's volume and/or brightness.
     *
     * @param val the velocity of the note
     * @throws IllegalArgumentException unless {@code velocity} is between 0 and 127
     */
    public static void setVelocity(int val) {
        validateVelocity(val);
        velocity = val;
    }

    /**
     * Sets the tempo to the specified number of beats per minute.
     *
     * @param  beatsPerMinute the number of beats per minute
     * @throws IllegalArgumentException unless {@code beatsPerMinute} is a positive integer
     */
    public static void setTempo(int beatsPerMinute) {
        validateTempo(beatsPerMinute);
        tempo = beatsPerMinute;

        /* for saving */
        // Convert beats per minute to microseconds per quarter note
        int mpqn = 60000000 / beatsPerMinute;
        byte[] data = new byte[3];
        data[0] = (byte) ((mpqn >> 16) & 0xFF);
        data[1] = (byte) ((mpqn >> 8) & 0xFF);
        data[2] = (byte) (mpqn & 0xFF);

        try {
            // Create a MetaMessage for the tempo change (0x51 is tempo)
            MetaMessage tempoChange = new MetaMessage();
            tempoChange.setMessage(0x51, data, data.length);

            // Add the MetaMessage to the track
            track.add(new MidiEvent(tempoChange, tick));
        }
        catch(InvalidMidiDataException e) {
            System.out.println(e);
        }
    }


    /**
     * Plays the specified note for the given duration (measured in beats).
     * Uses the current instrument, velocity, and tempo.
     * The call {@code playNote(note, beats)} is equivalent to the sequence
     * of calls {@code noteOn(note)}, {@code pause(beats)},
     * and {@code noteOff(note)}.
     *
     * @param  note the MIDI note number (between 0 and 127)
     * @param  beats the duration, measured in beats (quarter note = 1 beat)
     * @throws IllegalArgumentException unless {@code note} is between 0 and 127
     * @throws IllegalArgumentException unless {@code beats} is non-negative
     */
    public static void playNote(int note, double beats) {
        noteOn(note);
        pause(beats);
        noteOff(note);
    }

    /**
     * Turns the specified note on.
     *
     * @param  note the MIDI note number (between 0 and 127)
     * @throws IllegalArgumentException unless {@code note} is between 0 and 127
     */
    public static void noteOn(int note) {
        validateNote(note);
        if (note == REST) return;

        channel.noteOn(note, velocity);

        /* for recording */
        try {
            ShortMessage on = new ShortMessage(ShortMessage.NOTE_ON, channelNumber, note, velocity);
            track.add(new MidiEvent(on, tick));
        }
        catch(InvalidMidiDataException e) {
            System.out.println(e);
        }
    }

    /**
     * Turns the specified note off.
     *
     * @param  note the MIDI note number (between 0 and 127)
     * @throws IllegalArgumentException unless {@code note} is between 0 and 127
     */
    public static void noteOff(int note) {
        validateNote(note);
        if (note == REST) return;

        channel.noteOff(note, velocity);

        /* for recording */
        try {
            ShortMessage off = new ShortMessage(ShortMessage.NOTE_OFF, channelNumber, note, 0);
            track.add(new MidiEvent(off, tick));
        }
        catch(InvalidMidiDataException e) {
            System.out.println(e);
        }
    }

    /**
     * Pauses for the specified duration. The duration is measured in beats,
     * where a quarter note is one beat.
     *
     * @param  beats the duration, measured in beats (quarter note = 1 beat)
     * @throws IllegalArgumentException unless {@code beats} is non-negative
     */
    public static void pause(double beats) {
        validateDuration(beats);
        try {
             Thread.sleep((int) (60.0 / tempo * beats * 1000));
        }
        catch (InterruptedException e) {
            System.out.println("Error sleeping");
        }
        tick += MIDI_TICKS_PER_QUARTER_NOTE * beats;
    }

    /**
     * Plays the specified notes for the given duration (measured in beats).
     * All notes must have the same duration.
     * Uses the current instrument, velocity, and tempo.
     *
     * @param  notes the MIDI note numbers (between 0 and 127)
     * @param  beats the duration, measured in beats (quarter note = 1 beat)
     * @throws IllegalArgumentException unless {@code note} is between 0 and 127
     * @throws IllegalArgumentException unless {@code beats} is non-negative
     */
    public static void playNotes(int[] notes, double beats) {
        validateDuration(beats);
        for (int note : notes) {
            noteOn(note);
        }

        pause(beats);

        for (int note : notes) {
            noteOff(note);
        }
    }


    /**
     * Plays the specified percussion instrument for the given duration
     * (measured in beats). Uses the current velocity and tempo.
     *
     * @param  instrument the MIDI percussion instrument number (between 35 and 81)
     * @param  beats the duration, measured in beats (quarter note = 1 beat)
     * @throws IllegalArgumentException unless {@code instrument} is between 35 and 81
     * @throws IllegalArgumentException unless {@code beats} is non-negative
     */
    public static void playPercussion(int instrument, double beats) {
        validatePercussionInstrument(instrument);
        validateDuration(beats);
        if (instrument != REST) {
            percussionChannel.noteOn(instrument, velocity);
        }

        pause(beats);

        if (instrument != REST) {
            percussionChannel.noteOff(instrument);
        }
    }

    public static void percussionOn(int instrument) {
        validatePercussionInstrument(instrument);
        if (instrument != REST) {
            percussionChannel.noteOn(instrument, velocity);
        }
    }

    public static void percussionOn(int instrument, int velocity) {
        validatePercussionInstrument(instrument);
        validateVelocity(velocity);
        if (instrument != REST) {
            percussionChannel.noteOn(instrument, velocity);
        }
    }

    public static void percussionOff(int instrument) {
        validatePercussionInstrument(instrument);
        if (instrument != REST) {
            percussionChannel.noteOff(instrument);
        }
    }

    /**
     * Turns all notes off, but allows decaying notes to complete.
     */
    public static void allNotesOff() {
        channel.allNotesOff();
    }

    /**
     * Turns all notes off immediately.
     */
    public static void allSoundOff() {
        channel.allSoundOff();
    }


    /**
     * Plays the specified MIDI file and waits until the audio file finishes
     * playing before continuing.
     *
     * @param  filename the name of the MIDI file
     * @throws IllegalArgumentException if {@code filename} is {@code null}
     * @throws IllegalArgumentException if {@code filename} is not a MIDI file
     * @throws IllegalArgumentException if {@code filename} cannot be read
     */
    public static void play(String filename) {
        play(filename, !BACKGROUND);
    }

    /**
     * Plays the specified MIDI file in a background thread.
     * It is possible to play multiple MIDI files at the same time, e.g., a background
     * musical score and sound effects.
     *
     * @param  filename the name of the MIDI file
     * @throws IllegalArgumentException if {@code filename} is {@code null}
     * @throws IllegalArgumentException if {@code filename} is not a MIDI file
     * @throws IllegalArgumentException if {@code filename} cannot be read
     */
    public static void playInBackground(String filename) {
        play(filename, BACKGROUND);
    }

    // helper method to player a MIDI file, either in background thread or not
    private static void play(String filename, boolean playInBackground) {
        try {

            // Get and open a sequencer
            // (false to not auto-connect to the default synthesizer)
            Sequencer sequencer = MidiSystem.getSequencer(false);
            sequencer.open();

            // Connect the sequencer to the synthesizer
            sequencer.getTransmitter().setReceiver(synthesizer.getReceiver());

            // Load the MIDI sequence from file
            File file = new File(filename);
            if (!file.exists()) {
                throw new IllegalArgumentException("MIDI file not found: " + filename);
            }
            Sequence sequence = MidiSystem.getSequence(file);

            // Set the sequence to the sequencer
            sequencer.setSequence(sequence);

            // Add a listener to stop the sequencer when playback is done
            sequencer.addMetaEventListener(new MetaEventListener() {
                @Override
                public void meta(MetaMessage meta) {
                    if (meta.getType() == 47) { // 47 is the end-of-track meta event
                        System.out.println("End of track.");
                        if (!playInBackground) {
                            synchronized (lock) {
                                lock.notify();
                            }
                        }
                        // Use a separate thread to close the sequencer after a delay
                        new Thread(() -> {
                            try {
                                // 1 second delay (to help ensure the last note finishes playing)
                                Thread.sleep(1000);
                            }
                            catch (InterruptedException e) {
                                System.out.println(e);
                            }
                            finally {
                                sequencer.close();
                                System.out.println("Sequencer closed.");
                            }
                        }).start();
                    }
                }
            });


            // Start the sequencer
            sequencer.start();
            System.out.println("Playback started.");

            // Wait for playback to complete
            if (!playInBackground) {
                synchronized (lock) {
                    while (sequencer.isRunning()) {
                        lock.wait();
                    }
                }
            }
        }

        catch (MidiUnavailableException e) {
            System.out.println(e);
            System.out.println("MIDI device unavailable.");
        }
        catch (InvalidMidiDataException e) {
            System.out.println(e);
            System.out.println("Invalid MIDI data.");
        }
        catch (IOException e) {
            System.out.println(e);
            System.out.println("Error reading MIDI file.");
        }
        catch (InterruptedException e) {
            System.out.println(e);
            System.out.println("Playback interrupted.");
        }
    }


    /**
     * Saves the sequence of notes to the specified MIDI file.
     * The file extension must be {@code .mid} or {@code .midi}.
     *
     * @param  filename the filename
     * @throws IllegalArgumentException if {@code filename} is {@code null}
     * @throws IllegalArgumentException if {@code filename} is the empty string
     * @throws IllegalArgumentException if {@code filename} has wrong extension
     * @throws IllegalArgumentException if {@code filename} cannot be written
     */
    public static void save(String filename) {
        if (filename == null) {
            throw new IllegalArgumentException("filename is null");
        }
        if (filename.length() == 0) {
            throw new IllegalArgumentException("argument to save() is the empty string");
        }

        try {
            File file = new File(filename);

            // handle MIDI file format first
            if (filename.endsWith(".mid") || filename.endsWith(".MID") || filename.endsWith(".midi") || filename.endsWith(".MIDI")) {
                MidiSystem.write(sequence, SYNCHRONOUS, file);
            }
            else {
                throw new IllegalArgumentException("file extension for saving must be .mid");
            }
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("unable to save file '" + filename + "'", ioe);
        }
    }


    /**
     * Test client - plays the first few notes from Axel F by Harold Faltermeyer.
     *
     * @param args the command-line arguments (none should be specified)
     */
    public static void main(String[] args) {
        StdMidi.setTempo(220);
        StdMidi.setInstrument(SYNTH_BASS_1);

        int[] pitches1  = { F4, REST, AF4, REST,  F4,  F4, BF4, F4, EF4 };
        double[] beats1 = { QN,   QN,  QN,   EN,  QN,  EN,  QN, QN,  QN };
        int[] pitches2  = { F4, REST,  C5, REST,  F4,  F4, DF5, C5, AF4 };
        double[] beats2 = { QN,   QN,  QN,   EN,  QN,  EN,  QN, QN,  QN };
        int[] pitches3  = { F4,   C5,  F5,   F4, EF4, EF4,  C4, G4,  F4, REST };
        double[] beats3 = { QN,   QN,  QN,   EN,  QN,  EN,  QN, QN, DQN, WN   };

        for (int i = 0; i < pitches1.length; i++)
            StdMidi.playNote(pitches1[i], beats1[i]);
        for (int i = 0; i < pitches2.length; i++)
            StdMidi.playNote(pitches2[i], beats2[i]);
        for (int i = 0; i < pitches3.length; i++)
            StdMidi.playNote(pitches3[i], beats3[i]);

        StdMidi.save("axelf.mid");

        StdMidi.play("axelf.mid");

        StdMidi.setInstrument(StdMidi.SPACE_VOICE);
        for (int i = 0; i < pitches1.length; i++)
            StdMidi.playNote(pitches1[i], beats1[i]);
        for (int i = 0; i < pitches2.length; i++)
            StdMidi.playNote(pitches2[i], beats2[i]);
        for (int i = 0; i < pitches3.length; i++)
            StdMidi.playNote(pitches3[i], beats3[i]);
    }

}
