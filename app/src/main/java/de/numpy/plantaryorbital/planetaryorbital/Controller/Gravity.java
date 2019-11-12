package de.numpy.plantaryorbital.planetaryorbital.Controller;

import de.numpy.plantaryorbital.planetaryorbital.planets.Planet;
import de.numpy.plantaryorbital.planetaryorbital.rocket.Rocket;

/**
 *
 * Created by Marvin on 16.10.2017.
 */

public class Gravity
{
    private Planet planet;
    private Rocket rocket;
    
    private double xDist;
    private double yDist;
    private double distance;
    
    private double xAcc;
    private double yAcc;
    
    private double elapsedMillis;
    
    private double angle;
    
    private static Gravity instance;
    
    public static void applyGravityToRocket ( Planet planet, Rocket rocket, double elapsedMillis )
    {
        Gravity gravity = Gravity.getInstance();
        gravity.setPlanet( planet );
        gravity.setElapsedMillis( elapsedMillis );
        gravity.applyToRocket( rocket );
    }
    
    private Gravity ()
    {
    }
    
    
    private static Gravity getInstance ()
    {
        if ( instance == null )
        {
            instance = new Gravity();
        }
        return instance;
    }
    
    private void applyToRocket ( Rocket rocket )
    {
        this.rocket = rocket;
        calculateDistance();
        calculateAngle();
        calculateAcceleration();
        applyGravity();
    }
    
    private void calculateAngle ()
    {
        angle = (float) Math.atan2( yDist, xDist );
        angle += Math.PI / 2;
    }
    
    private void calculateDistance ()
    {
        xDist = rocket.position.x - planet.position.x;
        yDist = rocket.position.y - planet.position.y;
        distance = rocket.position.calculateDistanceTo( planet.position );
    }
    
    private void calculateAcceleration ()
    {
        //Log.i("ANGLE","" + angle);
        double acceleration = planet.mass / ( distance * distance );
        xAcc = (float) -Math.sin( angle ) * acceleration;
        yAcc = (float) Math.cos( angle ) * acceleration;
    }
    
    private void applyGravity ()
    {
        if ( distance < planet.getRadius() )
        {
            rocket.velocity.x = 0;
            rocket.velocity.y = 0;
        }
        rocket.velocity.x += xAcc * elapsedMillis;
        rocket.velocity.y += yAcc * elapsedMillis;
    }
    
    public void setPlanet ( Planet planet )
    {
        this.planet = planet;
    }
    
    private void setElapsedMillis ( double elapsedMillis )
    {
        this.elapsedMillis = elapsedMillis;
    }
}
