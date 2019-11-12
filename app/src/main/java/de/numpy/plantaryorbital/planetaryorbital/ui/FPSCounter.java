package de.numpy.plantaryorbital.planetaryorbital.ui;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 *
 * Created by Marvin on 21.10.2017.
 */

public class FPSCounter
{
  private int fps;
  private int framesThisSecond;
  private double timer;
  
  private Paint textPaint;
  
  public FPSCounter ()
  {
    textPaint = new Paint();
    textPaint.setColor( Color.WHITE );
    textPaint.setTextSize( 40f );
  }
  
  public void update( double elapsedMillis )
  {
    timer += elapsedMillis;
    if ( timer >= 1000 )
    {
      fps = framesThisSecond;
      framesThisSecond = 0;
      timer = 0;
    }
    else
    {
      framesThisSecond ++;
    }
  }
  
  public void draw( Canvas canvas )
  {
    canvas.drawText( "" + fps, 50, 50, textPaint );
  }
}
