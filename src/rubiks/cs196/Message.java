package rubiks.cs196;

import com.threed.jpct.Logger;

public class Message extends Tutorial{
	private String message;
	private final int maxLineLength = 80;

	public Message(String msg) {
		message = msg;
		message = "> " + message;
		wordWrap();
		print();
	}

	public String print() {
		Logger.log(message);
		Tutorial.msg = message;
		pause();
		return message;
	}

	public void pause(){
		Tutorial.paused = true;
		Logger.log("paused");
		while (Tutorial.paused){
		}
	}
	
	public void wordWrap() {
		int i = 0;
		while (i + maxLineLength < message.length() && (i = message.lastIndexOf(" ", i + maxLineLength)) != -1){
			String prt1 = message.substring(0, i);
			String prt2 = message.substring(i+1, message.length());
			message = prt1 + '\n' + prt2;
		}
	}

	public String getMessage() {
		return message;
	}
}
