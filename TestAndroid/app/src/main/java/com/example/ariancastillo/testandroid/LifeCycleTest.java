package com.example.ariancastillo.testandroid;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class LifeCycleTest extends Activity {

	StringBuilder builder = new StringBuilder();
	TextView textView;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    	textView = new TextView(this);
    	textView.setText(builder.toString());
    	setContentView(textView);
    	log("created");
    }
    
    protected void onResume() {
    	super.onResume();
    	log("resumed");
    }
    
    protected void onPause() {
    	super.onPause();
    	log("paused");
    	if (isFinishing())  log("finishing");
    }
    
    private void log(String text){
    	Log.d("LifeCyclesTest", text);
    	builder.append(text);
    	builder.append('\n');
    	textView.setText(builder.toString());
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.test_android, menu);
        return true;
    }
    
}
