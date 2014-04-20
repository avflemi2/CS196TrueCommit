package rubiks.cs196;

//import com.threed.jpct.example.HelloWorld;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;

public class Model extends Activity {
//	
//	TextView welcome = (TextView) findViewById(R.id.textView1);
//	welcome.setTextColor(Color.WHITE);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.model);

		RelativeLayout rel = (RelativeLayout) findViewById(R.id.rel1);
		rel.setBackgroundColor(Color.BLACK);

		Button button2 = (Button) findViewById(R.id.button2);

		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent intent = new Intent(getApplicationContext(), HelloWorld.class);
				startActivity(intent);

			}
		});
	}

}


