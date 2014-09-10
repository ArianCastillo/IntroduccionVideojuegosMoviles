package com.example.ariancastillo.testandroid;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;

public class AndroidBasicStarter extends ListActivity{
	String test[] = {  "LifeCycleTest", "SingleTouchTest", "MultiTouchTest", "NewMultiTouchTest",
            "KeyTest", "AccelerometerTest", "CompassTest", "AssetsTest", "ExternalStorageTest",
            "SoundPoolTest", "MediaPlayerTest", "FullScreenTest", "WakeLockTest", "RenderViewTest",
            "ShapeTest", "BitmapTest", "FontTest", "SurfaceViewTest" };
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, test));
	}
	
	protected void onListItemClick(ListView list, View view, int position, long id){
		super.onListItemClick(list,view,position,id);
		String testName = test[position];
		try{
			Class clazz = Class.forName("com.example.ariancastillo.testandroid." + testName);
			Intent intent = new Intent(this, clazz);
			startActivity(intent);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
}
