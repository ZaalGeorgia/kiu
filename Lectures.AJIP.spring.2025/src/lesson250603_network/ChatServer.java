package lesson250603_network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	
	static List<ClientHandler> clients = new ArrayList<ClientHandler>();

	public static void main(String[] args) {

		System.out.println("start listening for incoming connection");

		try {
			ServerSocket serverSocket = new ServerSocket(10000);
			while (true) {
				Socket socket = serverSocket.accept(); // blocking IO operation
				ClientHandler client = new ClientHandler(socket);
				clients.add(client);
				new Thread(() -> {
					client.handleConnection();
				}).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	static void broadCast(String message) {
		new Thread(()-> {
			for (ClientHandler clientHandler : clients) {
				clientHandler.sendMessage(message);
			}
		}).start();
	}

}
