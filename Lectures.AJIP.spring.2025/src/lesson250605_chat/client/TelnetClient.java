package lesson250605_chat.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TelnetClient {
	
	public static void main(String[] args) {
		
		if (args.length != 2) {
			System.out.println("usage: TelnetClient <host> <port>");
			System.exit(1);
		}
		
		Scanner userInput = new Scanner(System.in);
		
		String host = args[0];
		int port = Integer.parseInt(args[1]);
		
		System.out.println("Connecting to " + host + ":" + port);
		
		try {
			Socket socket = new Socket(host, port);
			System.out.println(socket);
			
			OutputStream outputStream = socket.getOutputStream();
			InputStream inputStream = socket.getInputStream();
			
			new Thread(() -> {
				try (Scanner reader = new Scanner(inputStream)) {
					while (reader.hasNextLine()) {
						System.out.println(reader.nextLine());
					}
				}
			}).start();
			
			PrintWriter	writer = new PrintWriter(outputStream, true);
			
			while (userInput.hasNextLine()) {
				String message = userInput.nextLine();
				writer.println(message);
				if (message.equals("bye")) {
					break;
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
