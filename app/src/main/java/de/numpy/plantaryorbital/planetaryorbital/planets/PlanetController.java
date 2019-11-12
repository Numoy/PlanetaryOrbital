package de.numpy.plantaryorbital.planetaryorbital.planets;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;

import java.util.ArrayList;

import de.numpy.plantaryorbital.planetaryorbital.main.DisplayArea;
import de.numpy.plantaryorbital.planetaryorbital.rocket.Rocket;

/**
 * Created by Marvin on 16.10.2017.
 */

public class PlanetController
{
    private ArrayList<Planet> planets;
    private int currentPlanetNumber;
    
    private PlanetView planetView;
    
    private PlanetFactory planetFactory;
    
    private int points = 0;

    public PlanetController( Context context )
    {
        planetView = new PlanetView();
        planets = new ArrayList<>();
        planetFactory = new PlanetFactory( context );
        currentPlanetNumber = 0;
        for ( int i = 0; i < 11; i ++ )
        {
            addPlanet( i );
        }
    }

    public void addPlanet( int num )
    {
        planets.add( planetFactory.getPlanetAt( num ) );
    }
    
    public ArrayList<Planet> getPlanets()
    {
        return planets;
    }
    
    public void update ( Rocket rocket )
    {
        //Log.i( "PLCONT", "Planets:" + planets.size() + " " + currentPlanetNumber );
        if ( rocket.closestPlanet.planetNumber < currentPlanetNumber )
        {
            currentPlanetNumber--;
            if ( currentPlanetNumber > 2 )
            {
                planets.remove( 4 );
                planets.add( 0, planetFactory.getPlanetAt( currentPlanetNumber - 2 ) );
            }
        }
        if ( rocket.closestPlanet.planetNumber > currentPlanetNumber )
        {
            currentPlanetNumber++;
            if ( currentPlanetNumber > 2 )
            {
                planets.remove( 0 );
                planets.add( 4, planetFactory.getPlanetAt( currentPlanetNumber + 2 ) );
            }
        }
        if ( currentPlanetNumber > points )
        {
            points = currentPlanetNumber;
            Log.i( "POINTS", "Punkte: " + points );
        }
        
    }
    
    public void draw ( Canvas canvas )
    {
        for ( Planet planet : planets )
        {
            if ( DisplayArea.insideDisplayArea( planet ) )
            {
                planetView.draw( planet, canvas );
            }
        }
    }
    
    private Planet getPlanetAt( int num )
    {
        for ( Planet planet : planets )
        {
            if ( planet.planetNumber == num )
                return planet;
        }
        return null;
    }
    
    public int getPoints ()
    {
        return points;
    }
    
    public void setPoints ( int points )
    {
        this.points = points;
    }
}