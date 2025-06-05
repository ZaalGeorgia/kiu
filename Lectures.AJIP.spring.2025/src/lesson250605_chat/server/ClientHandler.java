package lesson250605_chat.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

import utils.Utils;

public class ClientHandler {

	private PrintWriter printWriter;
	private InputStream inputStream;
	private Random random = new Random();

	public ClientHandler(Socket socket) {
		try {
			printWriter = new PrintWriter(socket.getOutputStream(), true);
			inputStream = socket.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void handleConnection() {
		Scanner scanner = new Scanner(inputStream);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			if (line.equals("bye")) {
				break;
			}
			ChatServer.broadCast(line);
		}
		printWriter.close();
		scanner.close();
		return;
	}

	public void sendMessage(String line) {
		new Thread(() -> {
			printWriter.println(line);
		}).start();
	}

}
