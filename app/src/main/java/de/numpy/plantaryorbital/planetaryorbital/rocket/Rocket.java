package de.numpy.plantaryorbital.planetaryorbital.rocket;


import android.graphics.Bitmap;
import android.graphics.RectF;

import java.util.HashMap;
import java.util.Map;

import de.numpy.plantaryorbital.planetaryorbital.Model.Circle;
import de.numpy.plantaryorbital.planetaryorbital.planets.Planet;
import de.numpy.plantaryorbital.planetaryorbital.Model.Position;
import de.numpy.plantaryorbital.planetaryorbital.Model.Velocity;

/**
 *
 * Created by Marvin on 16.10.2017.
 */

public class Rocket
{
  public static final float PART_OF_SCREEN = 0.06f;

  public double facing;
  public double thrust;

  public Position position;
  public Velocity velocity;

  public double width;
  public double height;

  public Circle hitBox;
  public Bitmap bitmap;
  public RectF hitbox;
  
  public float fuelLevel;

  public Map<Planet, Double> dist;
  public Planet closestPlanet;


  public Rocket()
  {
    //TESTWERTE
      position = new Position( 0, 300 );
      velocity = new Velocity( 0.4, 0 );
    thrust = 0.0002f;
    hitBox = new Circle( position, width );
    dist = new HashMap<>();
    fuelLevel = 1.0f;
  }
  
  public Rocket( Rocket srcRocket )
  {
    position = new Position( srcRocket.position );
    velocity = new Velocity( srcRocket.velocity );
    hitBox = new Circle( srcRocket.hitBox );
    dist = srcRocket.dist;
  }
}
