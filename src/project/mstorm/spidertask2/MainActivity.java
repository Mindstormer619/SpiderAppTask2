package project.mstorm.spidertask2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
//import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;
//import android.graphics.Color;
import android.graphics.Typeface;


public class MainActivity extends Activity implements OnClickListener{
	Button b;
	//TextView tB;
	EditText eB;
	int boldTog=0;
	int italTog=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //tB = (TextView)findViewById(R.id.textBox1);
        eB = (EditText)findViewById(R.id.editText1);
        b = (Button)findViewById(R.id.boldB);
        b.setOnClickListener(this);
        b = (Button)findViewById(R.id.italB);
        b.setOnClickListener(this);
        b = (Button)findViewById(R.id.normB);
        b.setOnClickListener(this);
        b = (Button)findViewById(R.id.button1);
        b.setOnClickListener(this);
    }
    
    @Override
    protected void onSaveInstanceState(Bundle outState) {
    	// TODO Auto-generated method stub
    	super.onSaveInstanceState(outState);
    	outState.putInt("isBold", boldTog);
    	outState.putInt("isItal", italTog);
    }
    
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onRestoreInstanceState(savedInstanceState);
    	boldTog = savedInstanceState.getInt("isBold");
    	italTog = savedInstanceState.getInt("isItal");
    	if(boldTog==1) {
    		eB.setTypeface(null,Typeface.BOLD);
    	}
    	else if(italTog==1){
    		eB.setTypeface(null,Typeface.ITALIC);
    	}
    }
    
	@Override
	public void onClick(View v) {
		// do the intent stuff or the font changes
		Button testB = (Button)v;
		try {
			if(testB.getId()==R.id.boldB) {
				//do something
				//tB.setTypeface(null, Typeface.BOLD);
				//tB.setTextColor(Color.BLUE);
				//EditText 
				//Log.d("SPIDER",Integer.toString(eB.getTypeface().getStyle()));
				//if(eB.getTypeface().getStyle()==1) eB.setTypeface(null, Typeface.NORMAL);
				//else if(eB.getTypeface().getStyle()==3) eB.setTypeface(null, Typeface.ITALIC);
				//else 
				eB.setTypeface(null,Typeface.BOLD);
				boldTog = 1;
				italTog = 0;
				
			}
			else if (testB.getId()==R.id.italB){
				//if(eB.getTypeface().getStyle()==2) eB.setTypeface(null, Typeface.NORMAL);
				//else if(eB.getTypeface().getStyle()==3) eB.setTypeface(null, Typeface.BOLD);
				//else 
				eB.setTypeface(null,Typeface.ITALIC);
				italTog = 1;
				boldTog = 0;
				
			}
			else if (testB.getId()==R.id.normB){
				eB.setTypeface(null,Typeface.NORMAL);
				italTog = 0;
				boldTog = 0;
			}
			else {
				Intent intent = new Intent(MainActivity.this,Activity2.class);
				EditText nameHolder = (EditText) findViewById(R.id.editText1);
		    	String message1 = nameHolder.getText().toString();
		    	intent.putExtra("messageParam", message1);
		    	intent.putExtra("isBold", boldTog);
		    	intent.putExtra("isItal", italTog);
		    	startActivity(intent);
			}
		}
		catch (Exception e) {
			Log.e("SPIDER",e.getLocalizedMessage());
		}
	}
        
}
