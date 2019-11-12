package de.numpy.plantaryorbital.planetaryorbital.stars;

import de.numpy.plantaryorbital.planetaryorbital.main.MainActivity;

/**
 * Created by Marvin on 21.10.2017.
 */

public class Star
{
  public float x;
  public float y;
  
  private float radius;
  
  public static final float STAR_SIZE = 0.01f;
  
  public Star( float x, float y, float radius )
  {
    this.x = x;
    this.y = y;
    this.radius = radius * STAR_SIZE * MainActivity.getScreenSize().getWidth();
  }
  
  public float getRadius ()
  {
    return radius;
  }
}
