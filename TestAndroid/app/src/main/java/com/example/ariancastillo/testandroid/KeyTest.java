package com.example.ariancastillo.testandroid;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

/**
 * Created by Arian Castillo on 03/09/2014.
 */
public class KeyTest extends Activity implements OnKeyListener {

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        return false;
    }
}
