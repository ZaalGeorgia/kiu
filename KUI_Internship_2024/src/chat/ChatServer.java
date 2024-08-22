package chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {
	
	static ExecutorService service = Executors.newCachedThreadPool();
	
	List<ChatMember> members = new ArrayList<>();
	
	public static void main(String[] args) {
		ChatServer server = new ChatServer();
		server.start();
	}

	private void start() {
		try (ServerSocket serverSocket = new ServerSocket(8080)) {
			System.out.println("listening for incoming connections at port 8080");
			while (true) {
				Socket socket = serverSocket.accept();
				ChatMember member = new ChatMember(this);
				members.add(member);
				service.submit(() -> {
					member.handleConnection(socket);
				});
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void publish(String message) {
		for (ChatMember chatMember : members) {
			service.submit(()-> {
				chatMember.send(message);
			});
		}
	}

}
