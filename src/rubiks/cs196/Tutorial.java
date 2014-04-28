package rubiks.cs196;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Tutorial extends Activity {
	public static String msg = "";
	public static boolean paused = true;

	protected void onCreate(Bundle savedInstanceState) {
		new Thread(new Runnable() {
			public void run() {
				solveCube.main(null);
			}
		}).start();

		super.onCreate(savedInstanceState);
		setContentView(R.layout.tutorial);

		RelativeLayout rel = (RelativeLayout) findViewById(R.id.rel1);
		rel.setBackgroundColor(Color.BLACK);

		AlertDialog.Builder builder5 = new AlertDialog.Builder(this);
		builder5.setTitle("Step 5");
		builder5.setMessage("Rotate face x5 in x5 direction");
		builder5.setPositiveButton(R.string.contin,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						Intent intent = new Intent(getApplicationContext(),
								SolveComplete.class);
						startActivity(intent);
					}
				});
		builder5.setNegativeButton(R.string.cancel,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
					}
				});

		final AlertDialog dialog5 = builder5.create();

		AlertDialog.Builder builder4 = new AlertDialog.Builder(this);
		builder4.setTitle("Step 4");
		builder4.setMessage("Rotate face x4 in x4 direction");
		builder4.setPositiveButton(R.string.contin,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						paused = false;
						dialog5.show();
					}
				});
		builder4.setNegativeButton(R.string.cancel,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
					}
				});

		final AlertDialog dialog4 = builder4.create();

		AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
		builder3.setTitle("Step 3");
		builder3.setMessage(msg);
		builder3.setPositiveButton(R.string.contin,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						paused = false;
						dialog4.show();
					}
				});
		builder3.setNegativeButton(R.string.cancel,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
					}
				});

		final AlertDialog dialog3 = builder3.create();

		AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
		builder2.setTitle("Step 2");
		builder2.setMessage(msg);
		builder2.setPositiveButton(R.string.contin,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						paused = false;
						dialog3.setMessage(msg);
						dialog3.show();
					}
				});
		builder2.setNegativeButton(R.string.cancel,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
					}
				});

		final AlertDialog dialog2 = builder2.create();

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Step 1");
		builder.setMessage(msg);
		// builder.setMessage("Rotate face x in x direction");
		// Add the buttons
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
		Button button1 = (Button) findViewById(R.id.button2);

		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				paused = false;
				dialog.setMessage(msg);
				dialog.show();
			}
		});
	}

}
