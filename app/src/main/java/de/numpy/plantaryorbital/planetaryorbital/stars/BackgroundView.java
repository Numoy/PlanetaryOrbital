package de.numpy.plantaryorbital.planetaryorbital.stars;

import android.graphics.Canvas;
import android.util.Size;

import de.numpy.plantaryorbital.planetaryorbital.main.MainActivity;

/**
 *
 * Created by Marvin on 21.10.2017.
 */

public class BackgroundView
{
  private Size screenSize;
  
  public BackgroundView()
  {
    screenSize = MainActivity.getScreenSize();
  }
  
  public void draw( Canvas canvas, Background background )
  {
    canvas.drawBitmap( background.getBack(), 0f, 0f, null );
  }
  
}
