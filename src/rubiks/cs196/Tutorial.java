package rubiks.cs196;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Looper;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Tutorial extends Activity {
	public static String msg = "";
	public static boolean paused = true;
	public static boolean useTestCube = false;
	
	protected void onCreate(Bundle savedInstanceState) {

		/** SOLVECUBE in another thread **/
		new Thread(new Runnable() {
			public void run() {
				solveCube.main();
			}
		}).start();

		super.onCreate(savedInstanceState);
		setContentView(R.layout.tutorial);

		RelativeLayout rel = (RelativeLayout) findViewById(R.id.rel1);
		rel.setBackgroundColor(Color.BLACK);
		
		final TextView instructionBox = (TextView) findViewById(R.id.textView1);
		instructionBox.setMovementMethod(new ScrollingMovementMethod());
		
		final Button button1 = (Button) findViewById(R.id.button2);
		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				paused = false;
				instructionBox.setText(msg);
				button1.setText("Next");
				//dialog.show();
			}
		});

		/**
		AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
		builder3.setTitle("Step x");
		builder3.setMessage(msg);
		final AlertDialog dialog3 = builder3.create();

		AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
		builder2.setTitle("Step x");
		builder2.setMessage(msg);
		final AlertDialog dialog2 = builder2.create();

		dialog3.setButton(DialogInterface.BUTTON_POSITIVE, "continue",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						paused = false;
						dialog2.setMessage(msg);
						dialog2.show();
					}
				});
		dialog3.setButton(DialogInterface.BUTTON_NEGATIVE, "___",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						// cancel
					}
				});
		dialog2.setButton(DialogInterface.BUTTON_POSITIVE, "continue",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						paused = false;
						dialog3.setMessage(msg);
						dialog3.show();
					}
				});
		dialog2.setButton(DialogInterface.BUTTON_NEGATIVE, "___",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						// cancel
					}
				});

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Solve");
		builder.setMessage("Follow the instructions on your cube");
		builder.setPositiveButton(R.string.contin,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						paused = false;
						dialog2.setMessage(msg);
						dialog2.show();
					}
				});
		builder.setNegativeButton(R.string.cancel,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
					}
				});

		final AlertDialog dialog = builder.create();
		*/

	}

}
