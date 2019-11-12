package de.numpy.plantaryorbital.planetaryorbital.planets;

import android.content.Context;
import android.graphics.Bitmap;

import java.util.Random;

import de.numpy.plantaryorbital.planetaryorbital.Const;
import de.numpy.plantaryorbital.planetaryorbital.planets.Planet;
import de.numpy.plantaryorbital.planetaryorbital.Model.Position;
import de.numpy.plantaryorbital.planetaryorbital.R;
import de.numpy.plantaryorbital.planetaryorbital.Utility.BitmapUtility;

/**
 * Created by Marvin on 27.11.2017.
 */

public class PlanetFactory
{
    private final long seed;
    private Context context;
    
    private Bitmap[] bitmaps;
    
    public PlanetFactory( Context context )
    {
        Random rnd = new Random();
        seed = rnd.nextLong();
        this.context = context;
        bitmaps = new Bitmap[ 11 ];
    }
    
    public Planet getPlanetAt( int num )
    {
        if ( num == 0 )
        {
            return startPlanet();
        }
        
        Random rnd = new Random( seed );
        
        for ( int i = 0; i < num; i++ )
        {
            rnd.nextDouble();
        }
        
        double x = Const.HORI_SCATTERING * ( rnd.nextDouble() - 0.5 );
        double y = - num * Const.AVG_DISTANCE + Const.VERT_SCATTERING * ( rnd.nextDouble() - 0.5 );
        double radius = Const.MIN_RADIUS + ( rnd.nextDouble() ) * ( Const.MAX_RADIUS - Const.MIN_RADIUS );
        int skinID = rnd.nextInt( 11 ) + 1;
        return new Planet( radius, new Position( x, y ), num, loadPlanetBitmapNum( skinID, radius ) );
    }
    
    private Planet startPlanet()
    {
        double radius = Const.MIN_RADIUS + ( Const.MAX_RADIUS - Const.MIN_RADIUS ) / 4;
        return new Planet(
            radius,
            new Position( 0, 0 ),
            0,
            loadPlanetBitmapNum( 1, radius ) );
    }
    
    private Bitmap loadPlanetBitmapNum( int num, double radius )
    {
        switch ( num )
        {
            case 1:
                return loadPlanetBitmap( radius, R.drawable.planet1_vector, 1.0, 1.0 );
            case 2:
                return loadPlanetBitmap( radius, R.drawable.planet2_vector, 1.9, 1.0 );
            case 3:
                return loadPlanetBitmap( radius, R.drawable.planet3_vector, 1.85, 1.3 );
            case 4:
                return loadPlanetBitmap( radius, R.drawable.planet4_vector, 1.0, 1.0 );
            case 5:
                return loadPlanetBitmap( radius, R.drawable.planet5_vector, 1.0, 1.0 );
            case 6:
                return loadPlanetBitmap( radius, R.drawable.planet6_vector, 1.0, 1.0 );
            case 7:
                return loadPlanetBitmap( radius, R.drawable.planet7_vector, 1.0, 1.0 );
            case 8:
                return loadPlanetBitmap( radius, R.drawable.planet8_vector, 1.0, 1.0 );
            case 9:
                return loadPlanetBitmap( radius, R.drawable.planet9_vector, 1.0, 1.0 );
            case 10:
                return loadPlanetBitmap( radius, R.drawable.planet10_vector, 1.0, 1.0 );
            case 11:
                return loadPlanetBitmap( radius, R.drawable.planet11_vector, 1.0, 1.0 );
            default:
                return null;
        }
    }
    
    private Bitmap loadPlanetBitmap( double radius, int drawableId, double xFac, double yFac )
    {
        Bitmap bmp = BitmapUtility.getBitmapFromDrawable( context,
            drawableId,
            (int) ( xFac * radius * 2 ),
            (int) ( yFac * radius * 2 ) );
        
        //return BitmapUtility.getResizedBitmap( bmp, (int) ( 2 * xFac * radius ), (int) ( 2 * yFac * radius ) );
        return bmp;
    }
}
