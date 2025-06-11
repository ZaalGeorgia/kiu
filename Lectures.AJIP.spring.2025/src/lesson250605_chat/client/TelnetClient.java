package lesson250605_chat.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TelnetClient {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("usage: TelnetClient <host> <port>");
			System.exit(1);
		}

		String host = args[0];
		int port = Integer.parseInt(args[1]);
		System.out.println("Connecting to " + host + ":" + port);

		try (Socket socket = new Socket(host, port);
			 PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
			 Scanner userInput = new Scanner(System.in)) {

			InputStream inputStream = socket.getInputStream();

			Thread.startVirtualThread(() -> {
				try (Scanner reader = new Scanner(inputStream)) {
					while (reader.hasNextLine()) {
						System.out.println(reader.nextLine());
					}
				}
			});

			while (userInput.hasNextLine()) {
				String message = userInput.nextLine();
				writer.println(message);
				if ("bye".equals(message)) {
					break;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}