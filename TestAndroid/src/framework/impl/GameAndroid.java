package framework.impl;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.Window;
import android.view.WindowManager;

import framework.Audio;
import framework.FileIO;
import framework.Game;
import framework.Graphics;
import framework.Input;
import framework.Screen;

/**
 * Created by Arian Castillo on 24/09/2014.
 */
public class GameAndroid extends Activity implements Game {
    FastRenderViewAndroid renderView;
    Graphics graphics;
    Audio audio;
    Input input;
    FileIO fileIO;
    Screen screen;
    WakeLock wakeLock;

    public void onCreate(Bundle savedInstanceState){
        //Fullscreen
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        boolean isLandscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
        int frameBufferWidth = isLandscape ? 480 : 320;
        int frameBufferHeight = isLandscape ? 320 : 480;
        Bitmap frameBuffer = Bitmap.createBitmap(frameBufferWidth,
                frameBufferHeight, Config.RGB_565);

        //float scaleX = (float) frameBufferWidth / getWindowManager().getDefaultDisplay().getWidth();
        //float scaleY = (float) frameBufferHeight / getWindowManager().getDefaultDisplay().getHeight();

        renderView = new FastRenderViewAndroid(this, frameBuffer);
        graphics = new GraphicsAndroid(getAssets(), frameBuffer);
        fileIO = new FileIOAndroid(getAssets());
        audio = new AudioAndroid(getAssets());
        input = new InputAndroid(this,renderView);
        screen = getStartScreen();
        setContentView(renderView);

        //Avoid screen protection
        PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK, "GLGame");
    }

    @Override
    public void onResume(){
        super.onResume();
        wakeLock.acquire();
        screen.resume();
        renderView.resume();
    }

    @Override
    public void onPause(){
        super.onPause();
        wakeLock.release();
        screen.pause();
        renderView.pause();
    }

    @Override
    public Input getInput() {
    	return input;
    }

    @Override
    public FileIO getFileIO() {
    	return fileIO;
    }

    @Override
    public Graphics getGraphics() {
    	return graphics;
    }

    @Override
    public Audio getAudio() {
    	return audio;
    }

    @Override
    public void setScreen(Screen screen) {
        if(screen == null)return;
        this.screen.pause();
        this.screen.dispose();
        screen.resume();
        screen.update(0);
        this.screen = screen;
    }

    @Override
    public Screen getCurrentScreen() {
        return screen;
    }

    @Override
    public Screen getStartScreen() {
        return null;
    }
}
