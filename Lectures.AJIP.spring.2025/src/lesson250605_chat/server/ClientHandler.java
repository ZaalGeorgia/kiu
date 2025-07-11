package lesson250605_chat.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientHandler {

	private PrintWriter printWriter;
	private InputStream inputStream;
	private final ExecutorService sendExecutor = Executors.newSingleThreadExecutor(Thread.ofVirtual().factory());

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
		try (Scanner scanner = new Scanner(inputStream)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if ("bye".equals(line)) {
					break;
				}
				ChatServer.broadCast(line);
			}
		} finally {
			printWriter.close();
		}
	}

	public void sendMessage(String line) {
		sendExecutor.submit(() -> printWriter.println(line));
	}

}