package de.numpy.plantaryorbital.planetaryorbital.Model;

/**
 * Created by Marvin on 26.11.2017.
 */

public class Velocity
{
    public double x;
    public double y;

    public Velocity( double x, double y )
    {
        this.x = x;
        this.y = y;
    }

    public Velocity( Velocity vel )
    {
        x = vel.x;
        y = vel.y;
    }
}
