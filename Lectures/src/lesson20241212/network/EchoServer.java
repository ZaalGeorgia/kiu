package lesson20241212.network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.util.Scanner;

public class EchoServer {
	
	public static void main(String[] args) {
		
		try {
			ServerSocket serverSocket = new ServerSocket(10000);
			System.out.println(serverSocket);
			
			Socket socket = serverSocket.accept();
			
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			
			pw.println(LocalDate.now());
			pw.flush();
			
			Scanner scanner = new Scanner(socket.getInputStream());
			
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				System.out.println(line);
				pw.println(line);
				pw.flush();
				if (line.equals("bye")) {
					break;
				}
			}
			
			socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
