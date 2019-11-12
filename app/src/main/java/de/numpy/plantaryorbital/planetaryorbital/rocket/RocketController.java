package de.numpy.plantaryorbital.planetaryorbital.rocket;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Size;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

import de.numpy.plantaryorbital.planetaryorbital.main.MainActivity;
import de.numpy.plantaryorbital.planetaryorbital.Controller.Store.SavedSettings;
import de.numpy.plantaryorbital.planetaryorbital.planets.Planet;
import de.numpy.plantaryorbital.planetaryorbital.Utility.BitmapUtility;

/**
 *
 * Created by Marvin on 16.10.2017.
 */

public class RocketController
{
    private Rocket rocket;
    
    private RocketView rocketView;
    
    private Context context;
    
    
    public RocketController (Context context)
    {
        this.context = context;
        rocket = new Rocket();
        //TODO: Aufräumen
        float shipWidth = MainActivity.getScreenSize().getWidth() * Rocket.PART_OF_SCREEN;
        rocket.bitmap = ( BitmapUtility.getBitmapFromVectorDrawable( context, SavedSettings.getRocketImageResource() ) );
        rocket.width = rocket.bitmap.getWidth();
        rocket.height = rocket.bitmap.getHeight();
        rocket.hitBox.radius = rocket.width * 0.5f;
        rocketView = new RocketView();
    }
    
    public RocketController ( Rocket rocket )
    {
        this.rocket = rocket;
    }
    
    public void update ( double elapsedMillis )
    {
        rocket.position.x += rocket.velocity.x * elapsedMillis;
        rocket.position.y += rocket.velocity.y * elapsedMillis;
        rocket.hitBox.moveTo( rocket.position );
        calculateAngle();
    }
    
    public void draw ( Canvas canvas )
    {
        rocketView.draw( rocket, canvas );
    }
    
    private void calculateAngle ()
    {
        rocket.facing = (float) Math.atan2( rocket.velocity.y, rocket.velocity.x );
        rocket.facing += Math.PI / 2;
    }
    
    public void applyThrust ( double percent, double elapsedMillis )
    {
        if ( rocket.fuelLevel <= 0 )
            return;
        // Bremsen
        if ( percent > 0.1f )
        {
            double xAcc = - Math.sin( rocket.facing ) * rocket.thrust * elapsedMillis;
            double yAcc = Math.cos( rocket.facing ) * rocket.thrust * elapsedMillis;
            if ( Math.abs( rocket.velocity.x ) > Math.abs( xAcc ) && Math.abs( rocket.velocity.y ) > Math.abs( yAcc ) )
            {
                rocket.velocity.x += xAcc;
                rocket.velocity.y += yAcc;
                rocket.fuelLevel -= 0.0001 * elapsedMillis;
            }
        }
        // Beschleunigen
        if ( percent < -0.1f )
        {
            double xAcc = Math.sin( rocket.facing ) * rocket.thrust * elapsedMillis;
            double yAcc = - Math.cos( rocket.facing ) * rocket.thrust * elapsedMillis;
            rocket.velocity.x += xAcc;
            rocket.velocity.y += yAcc;
            rocket.fuelLevel -= 0.0001 * elapsedMillis;
        }
    }
    
    public void calculateDistanceToPlanets ( ArrayList<Planet> planets )
    {
        rocket.dist.clear();
        for ( Planet planet : planets )
        {
            rocket.dist.put( planet, rocket.position.calculateDistanceTo( planet.position ) );
        }
        
        Map.Entry<Planet, Double> min = Collections.min( rocket.dist.entrySet(), new Comparator<Map.Entry<Planet, Double>>()
        {
            public int compare ( Map.Entry<Planet, Double> entry1, Map.Entry<Planet, Double> entry2 )
            {
                return entry1.getValue().compareTo( entry2.getValue() );
            }
        } );
        
        rocket.closestPlanet = min.getKey();
    }
    
    public Planet getClosestPlanet ()
    {
        return rocket.closestPlanet;
    }
    
    public boolean checkCollisionWith ( Planet planet )
    {
        //Log.i("DEBUG", "CrashDist: " + ( rocket.hitBox.radius + planet.hitBox.radius) );
        //Log.i("DEBUG", "Dist: " + rocket.position.calculateDistanceTo( planet.position ) );
        return rocket.hitBox.radius + planet.hitBox.radius > rocket.position.calculateDistanceTo( planet.position );
    }
    
    public boolean checkPath ()
    {
        Size screenSize = MainActivity.getScreenSize();
        return rocket.position.x < screenSize.getWidth() * 1.2 && rocket.position.x > screenSize.getWidth() * -1.2;
    }
    
    
    public void loadRocketBitmap ( int drawableId )
    {
        float shipWidth = MainActivity.getScreenSize().getWidth() * Rocket.PART_OF_SCREEN;
        rocket.bitmap = ( BitmapUtility.getBitmapFromVectorDrawable( context, drawableId ) );
        rocket.width = rocket.bitmap.getWidth();
        rocket.height = rocket.bitmap.getHeight();
        rocket.hitBox.radius = rocket.width * 0.5f;
    }
    
    public Rocket getRocket ()
    {
        return rocket;
    }
}
