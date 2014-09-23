package framework;

import android.provider.MediaStore;

public interface Game {
	public Input getInput();
	public FileIO getFileIO();
	public Graphics getGraphics();
	public MediaStore.Audio getAudio();
	public void setScreen(Screen screen);
	public Screen getCurrentScreen();
	public Screen getStartScreen();
}
