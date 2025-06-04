package lesson250603_network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;
import java.util.Scanner;

public class EchoServer {

	public static void main(String[] args) {

		System.out.println("start listening for incoming connection");

		try {
			ServerSocket serverSocket = new ServerSocket(10000);
			while (true) {
				Socket socket = serverSocket.accept(); // blocking IO operation
				new Thread(() -> {
					try {
						handleClientConnection(socket);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void handleClientConnection(Socket socket) throws IOException {
		OutputStream outputStream = socket.getOutputStream();
		PrintWriter printWriter = new PrintWriter(outputStream, true);
		printWriter.println(LocalTime.now());
		InputStream inputStream = socket.getInputStream();
		Scanner scanner = new Scanner(inputStream);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			if (line.equals("bye")) {
				break;
			}
			printWriter.println(line);
		}
		printWriter.close();
		scanner.close();
	}

}
