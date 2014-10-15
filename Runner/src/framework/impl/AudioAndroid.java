package framework.impl;

import java.io.IOException;

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
    AssetManager manager;
    SoundPool soundPool;

    public AudioAndroid(AssetManager manager){
        this.manager = manager;
        this.soundPool = new SoundPool(20,AudioManager.STREAM_MUSIC,0);
    }

    @Override
    public Music newMusic(String filename) {
        try{
        	AssetFileDescriptor assetDecriptor = manager.openFd(filename);
        	return new MusicAndroid(assetDecriptor);
        } catch (IOException e){
        	throw new RuntimeException("No se puede cargar la musica '"+filename+"'");
        }
    }

    @Override
    public Sound newSound(String filename) {
        return null;
    }
}
