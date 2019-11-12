package de.numpy.plantaryorbital.planetaryorbital.ui;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Size;

import de.numpy.plantaryorbital.planetaryorbital.main.MainActivity;
import de.numpy.plantaryorbital.planetaryorbital.rocket.Rocket;

/**
 *
 * Created by Marvin on 08.12.2017.
 */

public class FuelLevelBar
{
    private Rocket rocket;
    private Paint paint;
    
    private Rect border;
    private Rect background;
    private Rect bar;
    
    private int max;
    private int min;
    
    public FuelLevelBar ( Rocket rocket )
    {
        this.rocket = rocket;
        paint = new Paint();
        paint.setStrokeWidth( 10 );
        paint.setColor( Color.WHITE );
        Size screen = MainActivity.getScreenSize();
    
        int padding = (int) ( screen.getWidth() * 0.01 );
        max = (int) (screen.getHeight() * 0.2 + padding );
        min = (int) (screen.getHeight() * 0.6 - padding );
       
        border = new Rect(
            (int) ( screen.getWidth() * 0.05 ),
            (int) ( screen.getHeight() * 0.2 ),
            (int) ( screen.getWidth() * 0.1 ),
            (int) ( screen.getHeight() * 0.6 ) );
       
        background = new Rect(
            (int) ( screen.getWidth() * 0.05 + padding ),
            max,
            (int) ( screen.getWidth() * 0.1 - padding ),
            min );
        
        bar = new Rect(
            (int) ( screen.getWidth() * 0.05 + padding ),
            max,
            (int) ( screen.getWidth() * 0.1 - padding ),
            min );
    }
    
    public void update()
    {
        bar.top = (int) ( min - ( min - max ) * rocket.fuelLevel );
    }
    
    public void draw( Canvas canvas )
    {
        paint.setColor( Color.WHITE );
        canvas.drawRect( border, paint );
        paint.setColor( Color.BLACK );
        canvas.drawRect( background, paint );
        paint.setColor( Color.YELLOW );
        canvas.drawRect( bar, paint );
    }
}
