package rubiks.cs196;

//import com.threed.jpct.example.HelloWorld;

import rubikcubeanimationexample.RubikCubeAnimationExampleActivity;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;

public class Menu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);

		RelativeLayout rel = (RelativeLayout) findViewById(R.id.rel1);
		rel.setBackgroundColor(Color.BLACK);

		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				RubikCubeAnimationExampleActivity.useTestCube = false;
				Intent intent = new Intent(getApplicationContext(), Home.class);
				startActivity(intent);

			}
		});
		
		Button button3 = (Button) findViewById(R.id.button3);
		button3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				RubikCubeAnimationExampleActivity.useTestCube = true;
				Intent intent = new Intent(getApplicationContext(), RubikCubeAnimationExampleActivity.class);
				startActivity(intent);
				
			}
		});
		
		Button button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), RubikCubeAnimationExampleActivity.class);
				startActivity(intent);
			}
		});
		
	}

}
