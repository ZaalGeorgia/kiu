package lesson250611.virtual_threads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {

	private static final int PORT = 10000;
	private static final List<ClientHandler> clients = new ArrayList<>();

	public static void main(String[] args) {
		System.out.println("Start listening for incoming connections on port " + PORT);
		try (ServerSocket serverSocket = new ServerSocket(PORT)) {
			while (true) {
				Socket socket = serverSocket.accept(); // blocking IO operation
				ClientHandler client = new ClientHandler(socket);
				addClient(client);
				Thread.startVirtualThread(client::handleConnection);
			}
		} catch (IOException e) {
			System.err.println("Server error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private static synchronized void addClient(ClientHandler client) {
		clients.add(client);
	}

	static void broadCast(String message) {
		Thread.startVirtualThread(() -> {
			for (ClientHandler clientHandler : getClientsSnapshot()) {
				clientHandler.sendMessage(message);
			}
		});
	}

	private static synchronized List<ClientHandler> getClientsSnapshot() {
		return new ArrayList<>(clients);
	}

}