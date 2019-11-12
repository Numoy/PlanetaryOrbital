package de.numpy.plantaryorbital.planetaryorbital.energy;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import de.numpy.plantaryorbital.planetaryorbital.main.MainActivity;
import de.numpy.plantaryorbital.planetaryorbital.Controller.Store.SavedSettings;
import de.numpy.plantaryorbital.planetaryorbital.planets.Planet;
import de.numpy.plantaryorbital.planetaryorbital.rocket.Rocket;
import de.numpy.plantaryorbital.planetaryorbital.Utility.BitmapUtility;

/**
 *
 * Created by Marvin on 08.12.2017.
 */

public class EnergieController
{
    private EnergieView view;
    private Map<Planet, Energie> energies;
    
    private Rocket rocket;
    private ArrayList<Planet> planets;

    private int energyDrawableID;
    
    public EnergieController (Rocket rocket, ArrayList<Planet> planets)
    {
        energyDrawableID = SavedSettings.getEnergyImageResource();
        view = new EnergieView();
        energies = new HashMap<>();
        this.planets = planets;
        this.rocket = rocket;
        for ( Planet planet : planets )
        {
            Energie energie = new Energie( planet );
            energie.bitmap = BitmapUtility.getBitmapFromDrawable(
                MainActivity.getContext(),
                energyDrawableID,
                Energie.RADIUS,
                Energie.RADIUS );
            energies.put( planet, energie );
        }
    }
    
    public void update( double elapsedMillis )
    {
        updateList();
        moveEnergie( elapsedMillis );
        checkCollision();
    }
    
    private void checkCollision ()
    {
        for ( Energie energie : energies.values() )
        {
            if ( energie.isDepleted() )
                continue;
            if ( rocket.hitBox.radius + energie.hitBox.radius > rocket.position.calculateDistanceTo( energie.position ) )
            {
                rocket.fuelLevel += 0.25f;
                energie.deplete();
                if ( rocket.fuelLevel > 1 )
                    rocket.fuelLevel = 1.0f;
                
            }
        }
    }
    
    private void updateList()
    {
        for ( Planet planet : planets )
        {
            if ( !energies.containsKey( planet ) )
            {
                Energie energie = new Energie( planet );
                energie.bitmap = BitmapUtility.getBitmapFromDrawable(
                    MainActivity.getContext(),
                    energyDrawableID,
                    Energie.RADIUS,
                    Energie.RADIUS );
                energies.put( planet, energie );
            }
        }
        Planet removeKey = null;
        for ( Planet planet : energies.keySet() )
        {
            if ( !planets.contains( planet ) )
            {
                removeKey = planet;
            }
        }
        if ( removeKey != null )
        {
            energies.remove( removeKey );
        }
    }
    
    private void moveEnergie( double elapsedMillis )
    {
        for ( Energie energie : energies.values() )
        {
            if ( energie == null )
                continue;
    
            float rotationSpeed = 0.0008f;
            if( energie.direction )
            {
                energie.posDeg = (float) ( ( energie.posDeg + rotationSpeed * elapsedMillis ) % ( 2 * Math.PI ) );
            }
            else
            {
                energie.posDeg = (float) ( ( energie.posDeg - rotationSpeed * elapsedMillis ) % ( 2 * Math.PI ) );
            }
            energie.calcPosition();
        }
    }

    public void changeEnergy(int drawableID)
    {
        energyDrawableID = drawableID;
        for(Energie energie : energies.values())
        {
            energie.bitmap  = BitmapUtility.getBitmapFromDrawable(
                MainActivity.getContext(),
                energyDrawableID,
                Energie.RADIUS,
                Energie.RADIUS );
        }
    }
    
    public void draw( Canvas canvas )
    {
        for ( Energie energie : energies.values() )
        {
            view.draw( canvas, energie );
        }
    }
}
