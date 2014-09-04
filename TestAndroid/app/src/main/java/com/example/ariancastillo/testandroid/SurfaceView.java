package com.example.ariancastillo.testandroid;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;


/**
 * Created by Arian Castillo on 03/09/2014.
 */
public class SurfaceView extends Activity {

    class FastRenderView extends SurfaceView implements Runnable{
        Thread renderThread = null;
        SurfaceHolder holder;
        volatile boolean running = false;

        public FastRenderView(Context context){
            super(context);
            holder = getHolder();
        }

        public void resume(){
            running = true;
            renderThread = new Thread(this);
            renderThread.start();
        }

        public void pause(){
            running = false;
            while(true){
                try{
                    renderThread.join();
                    break;
                }catch(InterruptedException e){
                    //retry
                }
            }
            renderThread = null;
        }

        public void run() {
            while (running) {
                if (!holder.getSurface().isValid())
                   continue;
                Canvas canvas = holder.lockCanvas();
                drawSurface(canvas);
                holder.unlockCanvasAndPost(canvas);
            }
        }

        private void dreamSurface(Canvas canvas){
            canvas.drawRGB(255,0,0);
        }
    }
}
