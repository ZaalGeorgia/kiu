package lesson250605_chat.client;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUIChatClient {
	
	private static PrintWriter writer;

	public static void main(String[] args) {
		
		if (args.length != 2) {
			System.out.println("usage: TelnetClient <host> <port>");
			System.exit(1);
		}
		
		String host = args[0];
		int port = Integer.parseInt(args[1]);
		
		JFrame frame = new JFrame("Chat");
		
		JTextArea area = new JTextArea(20, 40);
		area.setEditable(false);
		JTextField field = new JTextField(30);
		
		field.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String message = field.getText();
				field.setText("");
				sendMessage(message);
			}
		});
		
		
		try {
			Socket socket = new Socket(host, port);
			System.out.println(socket);
			
			OutputStream outputStream = socket.getOutputStream();
			InputStream inputStream = socket.getInputStream();
			
			new Thread(() -> {
				try (Scanner reader = new Scanner(inputStream)) {
					while (reader.hasNextLine()) {
						area.append(reader.nextLine() + "\n");
					}
				}
			}).start();
			
			writer = new PrintWriter(outputStream, true);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		
		JPanel panel = new JPanel();
		panel.add(area);
		panel.add(field);
		frame.getContentPane().add(panel);
		frame.pack();
//		frame.setPreferredSize(new Dimension(600, 500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

	protected static void sendMessage(String message) {
		writer.println(message);
	}

}
