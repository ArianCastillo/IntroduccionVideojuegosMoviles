package framework.impl;

import java.io.IOException;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;

import framework.Audio;
import framework.Music;
import framework.Sound;

/**
 * Created by Arian Castillo on 24/09/2014.
 */
public class AudioAndroid implements Audio {
	AssetManager assets;
    SoundPool soundPool;

    public AudioAndroid(Activity activity){
    	activity.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        this.assets = activity.getAssets();
        this.soundPool = new SoundPool(20, AudioManager.STREAM_MUSIC, 0);
    }

    @Override
    public Music newMusic(String filename) {
        try{
        	AssetFileDescriptor assetDescriptor = assets.openFd(filename);
            return new MusicAndroid(assetDescriptor);
        } catch (IOException e){
        	throw new RuntimeException("No se puede cargar la musica '"+filename+"'");
        }
    }

    @Override
    public Sound newSound(String filename) {
    	try {
            AssetFileDescriptor assetDescriptor = assets.openFd(filename);
            int soundId = soundPool.load(assetDescriptor, 0);
            return new SoundAndroid(soundPool, soundId);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't load sound '" + filename + "'");
        }
    }
}
