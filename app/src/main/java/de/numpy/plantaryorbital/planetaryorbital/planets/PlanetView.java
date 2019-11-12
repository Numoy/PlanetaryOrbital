package de.numpy.plantaryorbital.planetaryorbital.planets;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import de.numpy.plantaryorbital.planetaryorbital.main.DisplayArea;
import de.numpy.plantaryorbital.planetaryorbital.Model.Position;

/**
 *
 * Created by Marvin on 16.10.2017.
 */

public class PlanetView
{
    private Paint planetPaint;

    public PlanetView()
    {
        planetPaint = new Paint();
        planetPaint.setColor( Color.RED );
    }

    public void draw( Planet planet, Canvas canvas )
    {
        //Log.i( "DEBUG", "Draw Planet" );
        Position offset = DisplayArea.getOffset();
        //drawDummy( planet, canvas );
        canvas.drawBitmap( planet.bitmap,
            (float) ( planet.position.x - planet.bitmap.getWidth() / 2 - offset.x ),
            (float) ( planet.position.y - planet.bitmap.getHeight() / 2 -offset.y ),
            null );
    }
    
    private void drawDummy( Planet planet, Canvas canvas )
    {
        Position offset = DisplayArea.getOffset();
        canvas.drawCircle(
            (float) ( planet.position.x - offset.x ),
            (float) ( planet.position.y - offset.y ),
            (float) planet.radius,
            planetPaint );
    }
}
