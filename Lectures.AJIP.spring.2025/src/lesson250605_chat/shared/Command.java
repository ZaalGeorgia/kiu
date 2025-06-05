package lesson250605_chat.shared;

import java.io.Serializable;

public class Command implements Serializable {
	
	public static final int JOIN = 0;
	public static final int LEAVE = 1;
	public static final int MESSAGE = 2;
	
	public Command(int code, String text) {
		super();
		this.code = code;
		this.text = text;
	}
	int code;
	String text;

	@Override
	public String toString() {
		return code + " " + text;
	}
}
