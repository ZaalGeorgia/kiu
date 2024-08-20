package lesson20240820;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer {
	
	static ExecutorService service = Executors.newCachedThreadPool();
	
	public static void main(String[] args) {
		try (ServerSocket serverSocket = new ServerSocket(8080)) {
			System.out.println("listening for incoming connections at port 8080");
			while (true) {
				Socket socket = serverSocket.accept();
				handleConnection(socket);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void handleConnection(Socket socket) throws IOException {
		service.submit(() -> {
			System.out.println("got a connection! thread: " + Thread.currentThread());
			try (Scanner scanner = new Scanner(socket.getInputStream());
					PrintWriter printer = new PrintWriter(socket.getOutputStream())) {
				while (scanner.hasNextLine()) {
					String line = scanner.nextLine();
					printer.println(line);
					printer.flush();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

}
