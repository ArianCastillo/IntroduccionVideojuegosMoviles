package com.example.ariancastillo.testandroid;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
/**
 * Created by Arian Castillo on 03/09/2014.
 */
public class FullScreenTest extends TouchActivity {
    public void onCreate(Bundle savedInstanceState){
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
    }
}
