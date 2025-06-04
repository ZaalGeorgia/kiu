package lesson250603_network;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;

public class TimeServer {
	
	public static void main(String[] args) {
		
		System.out.println("start listening for incoming connection");
		
		try {
			ServerSocket serverSocket = new ServerSocket(10000);
			Socket socket = serverSocket.accept(); // blocking IO operation
			OutputStream outputStream = socket.getOutputStream();
			PrintWriter printWriter = new PrintWriter(outputStream, true);
			printWriter.println(LocalTime.now());
//			printWriter.flush();  no need anymore because of auto-flush
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
