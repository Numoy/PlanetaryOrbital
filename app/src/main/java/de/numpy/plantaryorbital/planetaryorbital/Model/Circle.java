package de.numpy.plantaryorbital.planetaryorbital.Model;

/**
 * Created by Marvin on 26.11.2017.
 */

public class Circle
{
    public Position center;
    public double radius;

    public Circle( Position position, double radius )
    {
        this.radius = radius;
    }

    public void moveTo( Position pos )
    {
        center = pos;
    }

    public Circle( Circle circ )
    {
        center = new Position( circ.center );
        radius = circ.radius;
    }
}
