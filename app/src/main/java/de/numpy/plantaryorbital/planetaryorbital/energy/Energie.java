package de.numpy.plantaryorbital.planetaryorbital.energy;

import android.graphics.Bitmap;

import java.util.Random;

import de.numpy.plantaryorbital.planetaryorbital.Model.Circle;
import de.numpy.plantaryorbital.planetaryorbital.Model.Position;
import de.numpy.plantaryorbital.planetaryorbital.planets.Planet;

/**
 * Created by Marvin on 08.12.2017.
 */

public class Energie
{
    public Position position;
    public float posDeg;
    
    private float radiusOrbit;
    public boolean direction;
    
    public Planet inOrbitOf;
    
    public Circle hitBox;
    
    private boolean depleted;
    
    public static final int RADIUS = 40;

    public Bitmap bitmap;
    public int drawable;
    
    public Energie( Planet inOrbitOf )
    {
        depleted = false;
        this.inOrbitOf = inOrbitOf;
        radiusOrbit = (float) ( inOrbitOf.radius * 2 );
        posDeg = 0;
        Random rnd = new Random( inOrbitOf.planetNumber );
        direction = rnd.nextBoolean();
        position = new Position();
        calcPosition();
        hitBox = new Circle( position, RADIUS );
    }

    
    public void calcPosition()
    {
        double x = Math.sin( posDeg ) * radiusOrbit + inOrbitOf.position.x;
        double y = Math.cos( posDeg ) * radiusOrbit + inOrbitOf.position.y;
        position.offsetTo( x, y );
    }
    
    public boolean isDepleted()
    {
        return depleted;
    }
    
    public void deplete()
    {
        depleted = true;
    }
}
