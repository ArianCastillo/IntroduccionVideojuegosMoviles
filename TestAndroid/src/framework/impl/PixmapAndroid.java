package framework.impl;

import android.graphics.Bitmap;

import framework.Pixmap;
import framework.PixmapFormat;

/**
 * Created by Arian Castillo on 24/09/2014.
 */
public class PixmapAndroid implements Pixmap {
    Bitmap bitmap;
    PixmapFormat format;

    public PixmapAndroid(Bitmap bitmap, PixmapFormat format) {
        this.bitmap = bitmap;
        this.format = format;
    }

    @Override
    public int getWidth() {
        return bitmap.getWidth();
    }

    @Override
    public int getHeight() {
        return bitmap.getHeight();
    }

    @Override
    public PixmapFormat getFormat() {
        return format;
    }

    @Override
    public void dispose() {
        bitmap.recycle();
    }
}
