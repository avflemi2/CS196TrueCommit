package solvethecube;

import openglcube.OpenGLActivity;
import rubik.cs196.R;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class FaceSix extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.face1);

		RelativeLayout rel = (RelativeLayout) findViewById(R.id.rel1);
		rel.setBackgroundColor(Color.BLACK);

		final Button button1 = (Button) findViewById(R.id.button1);

		Button next = (Button) findViewById(R.id.next);

		next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), OpenGLActivity.class);
				startActivity(intent);
			}
		});

		final Button buttonR = (Button) findViewById(R.id.buttonred);
		buttonR.setBackgroundColor(Color.RED);

		final Button buttonB = (Button) findViewById(R.id.buttonblue);
		buttonB.setBackgroundColor(Color.BLUE);

		final Button buttonG = (Button) findViewById(R.id.buttongreen);
		buttonG.setBackgroundColor(Color.GREEN);

		final Button buttonP = (Button) findViewById(R.id.buttonpink);
		buttonP.setBackgroundColor(FaceOne.ORANGE);

		final Button buttonY = (Button) findViewById(R.id.buttonyellow);
		buttonY.setBackgroundColor(Color.YELLOW);

		final Button buttonW = (Button) findViewById(R.id.buttonwhite);
		buttonW.setBackgroundColor(Color.WHITE);

		// Flag 0 is red, 1 is pink, 2 is yellow, 3 is green, 4 is blue, 5 is
		// white
		final boolean[] flags = new boolean[6];

		buttonR.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				flags[0] = new Boolean(true);
				flags[1] = new Boolean(false);
				flags[2] = new Boolean(false);
				flags[3] = new Boolean(false);
				flags[4] = new Boolean(false);
				flags[5] = new Boolean(false);

			}
		});

		buttonP.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				flags[0] = new Boolean(false);
				flags[1] = new Boolean(true);
				flags[2] = new Boolean(false);
				flags[3] = new Boolean(false);
				flags[4] = new Boolean(false);
				flags[5] = new Boolean(false);

			}
		});

		buttonY.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				flags[0] = new Boolean(false);
				flags[1] = new Boolean(false);
				flags[2] = new Boolean(true);
				flags[3] = new Boolean(false);
				flags[4] = new Boolean(false);
				flags[5] = new Boolean(false);

			}
		});

		buttonG.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				flags[0] = new Boolean(false);
				flags[1] = new Boolean(false);
				flags[2] = new Boolean(false);
				flags[3] = new Boolean(true);
				flags[4] = new Boolean(false);
				flags[5] = new Boolean(false);

			}
		});

		buttonB.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				flags[0] = new Boolean(false);
				flags[1] = new Boolean(false);
				flags[2] = new Boolean(false);
				flags[3] = new Boolean(false);
				flags[4] = new Boolean(true);
				flags[5] = new Boolean(false);

			}
		});

		buttonW.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				flags[0] = new Boolean(false);
				flags[1] = new Boolean(false);
				flags[2] = new Boolean(false);
				flags[3] = new Boolean(false);
				flags[4] = new Boolean(false);
				flags[5] = new Boolean(true);

			}
		});

		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				int i = 45;
				if (flags[0]) {
					button1.setBackgroundColor(Color.RED);
					Cube.setColor(i, 'R');
				} else if (flags[1]) {
					button1.setBackgroundColor(FaceOne.ORANGE);
					Cube.setColor(i, 'O');
				} else if (flags[2]) {
					button1.setBackgroundColor(Color.YELLOW);
					Cube.setColor(i, 'Y');
				} else if (flags[3]) {
					button1.setBackgroundColor(Color.GREEN);
					Cube.setColor(i, 'G');
				} else if (flags[4]) {
					button1.setBackgroundColor(Color.BLUE);
					Cube.setColor(i, 'B');
				} else {
					button1.setBackgroundColor(Color.WHITE);
					Cube.setColor(i, 'W');
				}
				Toast toast = Toast.makeText(getApplicationContext(),
						"Choose A Color", Toast.LENGTH_SHORT);
				toast.show();
			}
		});

		final Button button2 = (Button) findViewById(R.id.button2);
		button2.setBackgroundColor(Color.YELLOW);
		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast toast = Toast.makeText(getApplicationContext(),
						"Choose A Color", Toast.LENGTH_SHORT);
				toast.show();
			}
		});

		final Button button3 = (Button) findViewById(R.id.button3);
		button3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				int i = 47;
				if (flags[0]) {
					button3.setBackgroundColor(Color.RED);
					Cube.setColor(i, 'R');
				} else if (flags[1]) {
					button3.setBackgroundColor(FaceOne.ORANGE);
					Cube.setColor(i, 'O');
				} else if (flags[2]) {
					button3.setBackgroundColor(Color.YELLOW);
					Cube.setColor(i, 'Y');
				} else if (flags[3]) {
					button3.setBackgroundColor(Color.GREEN);
					Cube.setColor(i, 'G');
				} else if (flags[4]) {
					button3.setBackgroundColor(Color.BLUE);
					Cube.setColor(i, 'B');
				} else {
					button3.setBackgroundColor(Color.WHITE);
					Cube.setColor(i, 'W');
				}
				Toast toast = Toast.makeText(getApplicationContext(),
						"Choose A Color", Toast.LENGTH_SHORT);
				toast.show();
			}
		});

		final Button button4 = (Button) findViewById(R.id.button4);
		button4.setBackgroundColor(Color.YELLOW);
		button4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast toast = Toast.makeText(getApplicationContext(),
						"Choose A Color", Toast.LENGTH_SHORT);
				toast.show();
			}
		});

		final Button button5 = (Button) findViewById(R.id.button5);
		button5.setBackgroundColor(Color.YELLOW);
		button5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast toast = Toast.makeText(getApplicationContext(),
						"Choose A Color", Toast.LENGTH_SHORT);
				toast.show();
			}
		});

		final Button button6 = (Button) findViewById(R.id.button6);
		button6.setBackgroundColor(Color.YELLOW);
		button6.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast toast = Toast.makeText(getApplicationContext(),
						"Choose A Color", Toast.LENGTH_SHORT);
				toast.show();
			}
		});

		final Button button7 = (Button) findViewById(R.id.button7);
		button7.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				int i = 51;
				if (flags[0]) {
					button7.setBackgroundColor(Color.RED);
					Cube.setColor(i, 'R');
				} else if (flags[1]) {
					button7.setBackgroundColor(FaceOne.ORANGE);
					Cube.setColor(i, 'O');
				} else if (flags[2]) {
					button7.setBackgroundColor(Color.YELLOW);
					Cube.setColor(i, 'Y');
				} else if (flags[3]) {
					button7.setBackgroundColor(Color.GREEN);
					Cube.setColor(i, 'G');
				} else if (flags[4]) {
					button7.setBackgroundColor(Color.BLUE);
					Cube.setColor(i, 'B');
				} else {
					button7.setBackgroundColor(Color.WHITE);
					Cube.setColor(i, 'W');
				}
				Toast toast = Toast.makeText(getApplicationContext(),
						"Choose A Color", Toast.LENGTH_SHORT);
				toast.show();
			}
		});

		final Button button8 = (Button) findViewById(R.id.button8);
		button8.setBackgroundColor(Color.YELLOW);
		button8.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast toast = Toast.makeText(getApplicationContext(),
						"Choose A Color", Toast.LENGTH_SHORT);
				toast.show();
			}
		});

		final Button button9 = (Button) findViewById(R.id.button9);
		button9.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				int i = 53;
				if (flags[0]) {
					button9.setBackgroundColor(Color.RED);
					Cube.setColor(i, 'R');
				} else if (flags[1]) {
					button9.setBackgroundColor(FaceOne.ORANGE);
					Cube.setColor(i, 'O');
				} else if (flags[2]) {
					button9.setBackgroundColor(Color.YELLOW);
					Cube.setColor(i, 'Y');
				} else if (flags[3]) {
					button9.setBackgroundColor(Color.GREEN);
					Cube.setColor(i, 'G');
				} else if (flags[4]) {
					button9.setBackgroundColor(Color.BLUE);
					Cube.setColor(i, 'B');
				} else {
					button9.setBackgroundColor(Color.WHITE);
					Cube.setColor(i, 'W');
				}
				Toast toast = Toast.makeText(getApplicationContext(),
						"Choose A Color", Toast.LENGTH_SHORT);
				toast.show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}
}
