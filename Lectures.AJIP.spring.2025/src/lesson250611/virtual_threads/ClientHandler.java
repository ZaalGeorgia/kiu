package lesson250611.virtual_threads;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientHandler {

	private PrintWriter printWriter;
	private InputStream inputStream;
	private final ExecutorService sendExecutor = 
			Executors.newSingleThreadExecutor(Thread.ofVirtual().factory());

	public ClientHandler(Socket socket) {
		try {
			printWriter = new PrintWriter(socket.getOutputStream(), true);
			inputStream = socket.getInputStream();
		} catch (IOException e) {
			System.err.println("ClientHandler error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void handleConnection() {
		for (int i = 0; i < 20; i++) {
			sendMessage(Integer.toString(i));
		}
	}

	public void sendMessage(String line) {
		sendExecutor.submit(() -> printWriter.println(line));

//		new Thread(() -> printWriter.println(line)).start();

	}

}