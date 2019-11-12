package de.numpy.plantaryorbital.planetaryorbital.Utility;

import android.graphics.RectF;

import de.numpy.plantaryorbital.planetaryorbital.Model.Circle;
import de.numpy.plantaryorbital.planetaryorbital.Model.Position;

/**
 * Created by Marvin on 26.11.2017.
 */

public class Intersect
{
    public static boolean circleAndRect(Circle circle, RectF rect )
    {
        // Circle above Rect
        if ( circle.center.y < rect.top )
        {
            // Top Left
            if ( circle.center.x < rect.left )
            {
                return circle.radius < calcDist( circle.center, new Position( rect.left, rect.top ) );
            }
            // Top Right
            if ( circle.center.x > rect.right )
            {
                return circle.radius < calcDist( circle.center, new Position( rect.right, rect.top ) );
            }
            // Top Center
            return circle.radius < rect.top - circle.center.y;
        }
        // Circle below Rect
        if ( circle.center.y > rect.bottom )
        {
            // Bottom Left
            if ( circle.center.x < rect.left )
            {
                return circle.radius < calcDist( circle.center, new Position( rect.left, rect.bottom ) );
            }
            // Bottom Right
            if ( circle.center.x > rect.right )
            {
                return circle.radius < calcDist( circle.center, new Position( rect.right, rect.bottom ) );
            }
            // Bottom Center
            return circle.radius < circle.center.y - rect.top;
        }
        // Center Left
        if ( circle.center.x < rect.left )
        {
            return circle.radius < rect.left - circle.center.x;
        }
        // Center Right
        if ( circle.center.x > rect.right )
        {
            return circle.radius < circle.center.x - rect.right;
        }
        //Center
        return true;
    }

    public static double calcDist(Position pos1, Position pos2)
    {
        double distX = pos1.x - pos2.x;
        double distY = pos1.y - pos2.y;
        return Math.sqrt( distX * distX + distY * distY );
    }
}
