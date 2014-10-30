package framework.impl;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;

import java.util.List;

import framework.Input;

/**
 * Created by Arian Castillo on 24/09/2014.
 */
public class InputAndroid implements Input{
    AccelerometerHandler accelerometerHandler;
    KeyboardHandler keyboard;
    TouchHandler touchHandler;

    public InputAndroid(Context context, View view, float scaleX, float scaleY){
    	accelerometerHandler = new AccelerometerHandler(context);
    	keyboard = new KeyboardHandler(view);               
        if (Integer.parseInt(VERSION.SDK) < 5) 
            touchHandler = new SingleTouchHandler(view, scaleX, scaleY);
        else
            touchHandler = new MultiTouchHandler(view, scaleX, scaleY);
    }

    @Override
    public boolean isKeyPressed(int keyCode) {
        return keyboard.isKeyPressed(keyCode);
    }

    @Override
    public boolean isTouchDown(int pointer) {
        return false;
    }

    @Override
    public int getTouchX(int pointer) {
        return 0;
    }

    @Override
    public int getTouchY(int pointer) {
        return 0;
    }

    @Override
    public float getAccelX() {
        return accelerometerHandler.aX;
    }

    @Override
    public float getAccelY() {
        return accelerometerHandler.aY;
    }

    @Override
    public float getAccelZ() {
        return accelerometerHandler.aZ;
    }

    @Override
    public List<KeyEvent> getKeyEvents() {
    	return keyboard.getKeyEvents();
    }

    @Override
    public List<TouchEvent> getTouchEvents() {
        return touchHandler.getTouchEvents();
    }
}
