package de.numpy.plantaryorbital.planetaryorbital.rocket;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;

import de.numpy.plantaryorbital.planetaryorbital.main.DisplayArea;
import de.numpy.plantaryorbital.planetaryorbital.Model.Position;
import de.numpy.plantaryorbital.planetaryorbital.Utility.BitmapUtility;

/**
 *
 * Created by Marvin on 16.10.2017.
 */

public class RocketView
{
  private Paint rocketPaint;
  
  public RocketView()
  {
    rocketPaint = new Paint();
    rocketPaint.setColor( Color.GREEN );
  }

  
  public void draw ( Rocket rocket, Canvas canvas )
  {
    //TEST R
    Position offset = DisplayArea.getOffset();
    Matrix transformation = BitmapUtility.getTransformationMatrix(rocket,offset);
    canvas.drawBitmap(rocket.bitmap,transformation ,null );
    //drawCenterAndVel( rocket, canvas, offset );
  }
  
  private void drawCenterAndVel( Rocket rocket, Canvas canvas, Position offset )
  {
      canvas.drawCircle(
          (float) ( rocket.position.x - offset.x ),
          (float) ( rocket.position.y - offset.y ),
          10f,
          rocketPaint );
    
      canvas.drawLine(
          (float) ( rocket.position.x - offset.x ),
          (float) ( rocket.position.y - offset.y ),
          (float) ( rocket.position.x - offset.x + 0.5f * rocket.velocity.x ),
          (float) ( rocket.position.y - offset.y + 0.5f * rocket.velocity.y ),
          rocketPaint );
  }
}
