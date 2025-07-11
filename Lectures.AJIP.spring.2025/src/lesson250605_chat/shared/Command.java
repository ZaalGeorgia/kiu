package lesson250605_chat.shared;

import java.io.Serializable;

public class Command implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static final int JOIN = 0;
	public static final int LEAVE = 1;
	public static final int MESSAGE = 2;

	private final int code;
	private final String text;

	public Command(int code, String text) {
		this.code = code;
		this.text = text;
	}

	public int getCode() {
		return code;
	}

	public String getText() {
		return text;
	}

	@Override
	public String toString() {
		return code + " " + text;
	}
}