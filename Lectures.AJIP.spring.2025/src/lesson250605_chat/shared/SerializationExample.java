package lesson250605_chat.shared;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class SerializationExample {
	
	public static void main(String[] args) {
		
		Command command = new Command(Command.MESSAGE, "hi!");
		
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(command);
			byte[] byteArray = baos.toByteArray();
			System.out.println(Arrays.toString(byteArray));
			System.out.println(baos.toString());
			
			ByteArrayInputStream bais = new ByteArrayInputStream(byteArray);
			
			ObjectInputStream ois = new ObjectInputStream(bais);
			
			try {
				Command command2 = (Command) ois.readObject();
				System.out.println(command2);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
