package rubiks.cs196;

import android.content.Context;
import android.widget.Toast;

public class Message {
	private String message;
	private Context context;
	
	public Message (String _msg, Context _cntxt ){
		message = _msg;
		context = _cntxt;
		print();
	}
	
	public String print(){
		//print to android here
		return message;
	}
	
	public String getMessage(){
		return message;
	}
}
