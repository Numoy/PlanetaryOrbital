package de.numpy.plantaryorbital.planetaryorbital.trajectory;

import android.util.Size;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

import de.numpy.plantaryorbital.planetaryorbital.main.MainActivity;
import de.numpy.plantaryorbital.planetaryorbital.planets.Planet;
import de.numpy.plantaryorbital.planetaryorbital.rocket.Rocket;

/**
 * Created by Marvin on 26.11.2017.
 */

public class PhantomController
{
    public Rocket phantom;

    public PhantomController ( Rocket rocket )
    {
        phantom = new Rocket( rocket );
    }

    public void update ( double elapsedSeconds )
    {
        phantom.position.x += phantom.velocity.x * elapsedSeconds;
        phantom.position.y += phantom.velocity.y * elapsedSeconds;
        phantom.hitBox.moveTo( phantom.position );
    }

    public void calculateDistanceToPlanets( ArrayList<Planet> planets )
    {
        phantom.dist.clear();
        for ( Planet planet : planets )
        {
            phantom.dist.put( planet, phantom.position.calculateDistanceTo( planet.position ) );
            //Log.i("Dist", planet.toString() + " " + rocket.dist.get( planet ));
        }
    }

    public Planet getClosestPlanet()
    {
        Map.Entry<Planet, Double> min =
            Collections.min(
                phantom.dist.entrySet(),
                new Comparator<Map.Entry<Planet, Double>>()
                {
                    public int compare(Map.Entry<Planet, Double> entry1, Map.Entry<Planet, Double> entry2)
                    {
                        return entry1.getValue().compareTo(entry2.getValue());
                    }
                });
        //Log.i("Closest", min.getKey().toString() + " " + min.getValue());
        return min.getKey();
    }

    public boolean checkCollisionWith( Planet planet )
    {
        //Log.i("DEBUG", "CrashDist: " + ( rocket.hitBox.radius + planet.hitBox.radius) );
        //Log.i("DEBUG", "Dist: " + rocket.position.calculateDistanceTo( planet.position ) );
        return phantom.hitBox.radius + planet.hitBox.radius > phantom.position.calculateDistanceTo( planet.position );
    }
    
    public boolean checkPath()
    {
        Size screenSize = MainActivity.getScreenSize();
        return phantom.position.x < screenSize.getWidth() * 1.17 &&
            phantom.position.x > screenSize.getWidth() * -1.17;
    }

    public Rocket getRocket()
    {
        return phantom;
    }
}
