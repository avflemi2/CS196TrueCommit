package solvethecube;

import openglcube.OpenGLActivity;

import com.threed.jpct.Logger;

public class Message {
	private String message;
	private final int maxLineLength = 80;

	public Message(boolean print, String msg) {
		message = msg;
		/** _use only for textIO_ */
		// message = "> " + message;
		// wordWrap();
		if (print)
			print();
	}

	public String print() {
		Logger.log(message);
		OpenGLActivity.msg = message;
		pause();
		return message;
	}
	
	public void append(String str){
		message+="\n"+str;
	}

	public void pause() {
		OpenGLActivity.paused = true;
		Logger.log("paused");
		while (OpenGLActivity.paused) {
		}
	}

	public void wordWrap() {
		int i = 0;
		while (i + maxLineLength < message.length()
				&& (i = message.lastIndexOf(" ", i + maxLineLength)) != -1) {
			String prt1 = message.substring(0, i);
			String prt2 = message.substring(i + 1, message.length());
			message = prt1 + '\n' + prt2;
		}
	}

	public String getMessage() {
		return message;
	}
	
	public String toString(){
		return getMessage();
	}
}
