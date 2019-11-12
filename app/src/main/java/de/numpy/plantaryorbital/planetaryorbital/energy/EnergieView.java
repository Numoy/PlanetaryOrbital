package de.numpy.plantaryorbital.planetaryorbital.energy;

import android.graphics.Canvas;

import de.numpy.plantaryorbital.planetaryorbital.main.DisplayArea;
import de.numpy.plantaryorbital.planetaryorbital.Model.Position;

/**
 * Created by Marvin on 08.12.2017.
 */

public class EnergieView
{
    
    public EnergieView()
    {
    }
    
    public void draw( Canvas canvas, Energie energie )
    {
        if ( energie.isDepleted() )
            return;
        
        Position offset = DisplayArea.getOffset();
        canvas.drawBitmap(
            energie.bitmap,
            (float) ( energie.position.x - offset.x - energie.bitmap.getWidth() / 2 ),
            (float) ( energie.position.y - offset.y - energie.bitmap.getHeight() / 2 ),
            null );
    }
}
