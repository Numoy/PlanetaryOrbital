package de.numpy.plantaryorbital.planetaryorbital.trajectory;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

import de.numpy.plantaryorbital.planetaryorbital.Const;
import de.numpy.plantaryorbital.planetaryorbital.main.DisplayArea;
import de.numpy.plantaryorbital.planetaryorbital.Model.Position;

/**
 * Created by Marvin on 21.10.2017.
 */

public class TrajectoryView
{
    private Paint trajectoryPaint;
    private float circleRadius;
    
    public TrajectoryView ()
    {
        trajectoryPaint = new Paint();
        trajectoryPaint.setARGB( 255, 137, 247, 29 );
        trajectoryPaint.setStrokeWidth( 6 );
        circleRadius = 5f;
    }
    
    public void draw ( Trajectory model, Canvas canvas )
    {
        model.startPoint %= Const.TRAJECTORY_DRAW_NTH_POINT;
        //Log.i("DEBUG", "" + positions.size());
        for ( int i = 1; i < model.positionsOnTrajectory.size() - 1; i++ )
        {
            if ( ( i + model.startPoint ) % Const.TRAJECTORY_DRAW_NTH_POINT == 0 )
            {
                Position posOnScreen = DisplayArea.offsetPosition( model.positionsOnTrajectory.get( i ) );
                //canvas.drawRect(
                    //(float) ( posOnScreen.x - Const.TRAJECTORY_POINT_SIZE ),
                    //(float) ( posOnScreen.y - Const.TRAJECTORY_POINT_SIZE ),
                    //(float) ( posOnScreen.x + Const.TRAJECTORY_POINT_SIZE ),
                    //(float) ( posOnScreen.y + Const.TRAJECTORY_POINT_SIZE ),
                    //trajectoryPaint );
                canvas.drawCircle((float)posOnScreen.x,(float)posOnScreen.y, 5, trajectoryPaint);
            }
        }
    }
    
    public Paint getPaint ()
    {
        return trajectoryPaint;
    }
}
