package project.mstorm.spidertask2;

import project.mstorm.spidertask2.R;

import android.os.Bundle;
import android.widget.TextView;
import android.app.Activity;
import android.graphics.Typeface;

public class Activity2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity2);
		String messageRecd = this.getIntent().getExtras().getString("messageParam");
		TextView textHolder = (TextView) findViewById(R.id.textBoxOut);
		textHolder.setText(messageRecd);
		int isBold = this.getIntent().getExtras().getInt("isBold");
		int isItal = this.getIntent().getExtras().getInt("isItal");
		if (isBold==1) textHolder.setTypeface(null,Typeface.BOLD);
		else if (isItal==1) textHolder.setTypeface(null,Typeface.ITALIC);
	}

}
