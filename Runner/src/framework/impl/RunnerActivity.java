package framework.impl;

import framework.Audio;
import framework.FileIO;
import framework.Game;
import framework.Graphics;
import framework.Input;
import framework.Screen;
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

public abstract class RunnerActivity extends Activity implements Game {
	FastRenderViewAndroid renderView;
    Graphics graphics;
    Audio audio;
    Input input;
    FileIO fileIO;
    Screen screen;
    WakeLock wakeLock;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	//Fullscreen
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        boolean isLandscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
        int frameBufferWidth = isLandscape ? 480 : 320;
        int frameBufferHeight = isLandscape ? 320 : 480;
        Bitmap frameBuffer = Bitmap.createBitmap(frameBufferWidth, frameBufferHeight, Config.RGB_565);

        float scaleX = (float) frameBufferWidth / getWindowManager().getDefaultDisplay().getWidth();
        float scaleY = (float) frameBufferHeight / getWindowManager().getDefaultDisplay().getHeight();

        renderView = new FastRenderViewAndroid(this, frameBuffer);
        graphics = new GraphicsAndroid(getAssets(), frameBuffer);
        fileIO = new FileIOAndroid(this);
        audio = new AudioAndroid(this);
        input = new InputAndroid(this, renderView, scaleX, scaleY);
        screen = getStartScreen();
        setContentView(renderView);

        //Avoid screen protection
        PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK, "GLGame");
    }

    public void onResume(){
        super.onResume();
        wakeLock.acquire();
        screen.resume();
        renderView.resume();
    }

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
		if (screen == null)
            throw new IllegalArgumentException("Screen must not be null");

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
}
