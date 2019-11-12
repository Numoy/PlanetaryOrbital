package de.numpy.plantaryorbital.planetaryorbital.main;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 *
 * Created by Marvin on 16.10.2017.
 */

public class GameView extends SurfaceView
{
  private SurfaceHolder surfaceHolder;
  private Canvas canvas;
  
  public GameView( Context context, OnTouchListener listener )
  {
    super( context );
    surfaceHolder = getHolder();
    setOnTouchListener( listener );
  }
  
  public void drawGame( GameObjects gameObjects )
  {
    if ( surfaceHolder.getSurface().isValid() )
    {
      canvas = surfaceHolder.lockCanvas();
      canvas.drawColor( Color.BLACK );
      gameObjects.draw ( canvas );
      surfaceHolder.unlockCanvasAndPost( canvas );
    }
  }
}
