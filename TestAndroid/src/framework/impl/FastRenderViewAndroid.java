package framework.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Arian Castillo on 24/09/2014.
 */
public class FastRenderViewAndroid extends SurfaceView implements Runnable {
    GameAndroid game;
    Bitmap frameBuffer;
    Thread renderThread = null;
    SurfaceHolder holder;
    volatile boolean running = false;

    public FastRenderViewAndroid(GameAndroid game, Bitmap frameBuffer){
        super(game);
        this.game = game;
        this.frameBuffer = frameBuffer;
        this.holder = getHolder();
    }

    public void resume() {
        running = true;
        renderThread = new Thread(this);
        renderThread.start();
    }

    public void pause() {
    	running = false;                        
        while(true) {
            try {
                renderThread.join();
                return;
            } catch (InterruptedException e) {
                // retry
            }
        }
    }

    @Override
    public void run() {
        Rect dstRect = new Rect();
        long startTime = System.nanoTime();
        while(running) {

            //Verificar si la vista esta desbloqueada y lista para dibujar
            if (!holder.getSurface().isValid())
                continue;

            //Calcular la diferencia entre el ultimo ciclo iterativo y este
            float deltaTime = (System.nanoTime() - startTime) / 1000000000.0f;
            startTime = System.nanoTime();

            //Actualiza y dibuja la pantalla actual
            game.getCurrentScreen().update(deltaTime);
            game.getCurrentScreen().present(deltaTime);

            //Bloquear canvas para dibujo
            Canvas canvas = holder.lockCanvas();
            //Obtener las dimensiones de la pantalla
            canvas.getClipBounds(dstRect);
            //Dibujar frameBuffer
            canvas.drawBitmap(frameBuffer, null, dstRect, null);
            //Desbloquear canvas
            holder.unlockCanvasAndPost(canvas);
        }
    }
}
