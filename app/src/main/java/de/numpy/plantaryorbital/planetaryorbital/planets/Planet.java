package de.numpy.plantaryorbital.planetaryorbital.planets;

import android.graphics.Bitmap;
import android.graphics.Point;

import de.numpy.plantaryorbital.planetaryorbital.Model.Circle;
import de.numpy.plantaryorbital.planetaryorbital.Model.Position;
import de.numpy.plantaryorbital.planetaryorbital.Utility.BitmapUtility;

/**
 * Created by Marvin on 16.10.2017.
 */

public class Planet
{
    public int planetNumber;

    public Position position;

    public int mass;

    public double radius;

    public Circle hitBox;

    public Bitmap bitmap;


    public Planet( double radius, Position position, int planetNumber, Bitmap source )
    {
        mass = 50; // TESTWERT
        this.radius = radius;
        this.position = position;
        this.planetNumber = planetNumber;
        bitmap = source;
        
        hitBox = new Circle( position, radius );
    }

    public double getRadius()
    {
        return radius;
    }
    
}
