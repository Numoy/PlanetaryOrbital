package de.numpy.plantaryorbital.planetaryorbital.stars;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 *
 * Created by Marvin on 22.10.2017.
 */

public class StarView
{
  private Paint starPaint;
  
  public StarView()
  {
    starPaint = new Paint();
    starPaint.setARGB( 255, 229, 244, 255 );
  }
  
  public void draw( Canvas canvas, Star star )
  {

      canvas.drawCircle(star.x, star.y, star.getRadius(),starPaint);
    //canvas.drawRect(
        //star.x - star.getRadius() ,
       // star.y - star.getRadius(),
       // star.x + star.getRadius(),
        //star.y + star.getRadius(),
       // starPaint );
  }
}
