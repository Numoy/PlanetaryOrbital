package de.numpy.plantaryorbital.planetaryorbital.Utility;

import android.graphics.Rect;
import android.util.Log;

/**
 * Created by Marvin on 28.11.2017.
 */

public class LogRect
{
    public static String rectToString( Rect rect )
    {
        String returnVal =
            "WIDTH:" + ( rect.right - rect.left )
            + " HEIGHT:" + ( rect.bottom - rect.top )
            + " P1:" + rect.left + "." + rect.top
            + " P2:" + rect.right + "." + rect.bottom;
        return returnVal;
    }
}
