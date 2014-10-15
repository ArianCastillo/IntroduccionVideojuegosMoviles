package framework.impl;

import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.view.View.OnKeyListener;

import framework.Input.KeyEvent;
import framework.impl.Pool;
import framework.impl.Pool.PoolObjectFactory;

/**
 * Created by Arian Castillo on 29/09/2014.
 */
public class KeyboardHandler implements OnKeyListener {

    boolean[] pressedKeys = new boolean[128];
    Pool<KeyEvent> keyEventPool;
    List<KeyEvent> keyEventsBuffer = new ArrayList<KeyEvent>();
    List<KeyEvent> keyEvents = new ArrayList<KeyEvent>();

    public KeyboardHandler(View view){
        PoolObjectFactory<KeyEvent> factory = new PoolObjectFactory<KeyEvent>() {
            public KeyEvent createObject() {
                return new KeyEvent();
            }
        };
        keyEventPool = new Pool<KeyEvent>(factory, 100);

        view.setOnKeyListener(this);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
    }

    @Override
    public boolean onKey(View v, int keyCode, android.view.KeyEvent event) {
        KeyEvent keyEvent = keyEventPool.newObject();
        keyEvent.keyCode = keyCode;
        keyEvent.keyChar = (char) event.getUnicodeChar();

        if (event.getAction() == android.view.KeyEvent.ACTION_DOWN){
            pressedKeys[event.getKeyCode()]=true;
        }

        if (event.getAction() == android.view.KeyEvent.ACTION_DOWN){
            pressedKeys[event.getKeyCode()]=true;
        }

        keyEventsBuffer.add(keyEvent);
        return false;
    }

    public boolean isKeyPressed(int keyCode){
        if(keyCode<0) return false;
        if (keyCode>127) return false;
        return pressedKeys[keyCode];
    }

    public List<framework.Input.KeyEvent> getKeyEvents(){
        int len = keyEvents.size();
        for (int i=0; i<len; i++){
            keyEventPool.free(keyEvents.get(i));
        }
        keyEvents.clear();
        keyEvents.addAll(keyEventsBuffer);
        keyEventsBuffer.clear();
        return keyEvents;
    }
}