package lesson20240815;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MyTelnet {

	private static Thread thread;

	public static void main(String[] args) {
		if (args.length < 2 || args.length > 2) {
			System.err.println("wrong number of parameters:\nUsage: MyTelnet <host> <port>");
			System.exit(1);
		}
		int port = 0;
		try {
			port = Integer.parseInt(args[1]);
		} catch (Exception e) {
			System.err.println("wrong port format");
			System.exit(2);
		}

		try (Socket socket = new Socket(args[0], port)) {
			System.out.println(socket);
			processSocketOutput(socket);
			processSocketInput(socket);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void processSocketOutput(Socket socket) {
		try {
			PrintWriter printer = new PrintWriter(socket.getOutputStream());
			Scanner scanner = new Scanner(System.in);
			thread = new Thread(() -> {
				System.out.println("OutputProcessor at thread " + Thread.currentThread());
				System.out.println("enter command:");
				while (scanner.hasNextLine()) {
					String line = scanner.nextLine();
					printer.println(line);
					printer.flush();
				}
			});
			thread.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void processSocketInput(Socket socket) {
		System.out.println("InputProcessor at thread " + Thread.currentThread());
		try (Scanner scanner = new Scanner(socket.getInputStream())) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("finished listening for server input");
		System.exit(0);
	}

}
