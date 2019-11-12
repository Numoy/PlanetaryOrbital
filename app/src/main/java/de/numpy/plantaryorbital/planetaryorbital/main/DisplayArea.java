package de.numpy.plantaryorbital.planetaryorbital.main;

import android.graphics.Rect;
import android.util.Size;

import de.numpy.plantaryorbital.planetaryorbital.planets.Planet;
import de.numpy.plantaryorbital.planetaryorbital.Model.Position;
import de.numpy.plantaryorbital.planetaryorbital.rocket.Rocket;

/**
 *
 * Created by Marvin on 18.10.2017.
 */

public class DisplayArea
{
  private Rect displayedArea;
  
  private int halfWidth;
    
    private int rocketYPosInDisplay;
  
  private static DisplayArea instance;
  public static boolean dont_move_x = false;
  private int oldRocketX;

  private final float SCROLLING_RIGHT_MAX = 0.65f * MainActivity.getScreenSize().getWidth();
    private final float SCROLLING_LEFT_MAX =  -0.65f * MainActivity.getScreenSize().getWidth();
  
  private DisplayArea ()
  {
    Size screenSize = MainActivity.getScreenSize();
    halfWidth = screenSize.getWidth() / 2;
    int halfHeight = screenSize.getHeight() / 2;
    
    rocketYPosInDisplay = halfHeight * 4 / 3;
    
    displayedArea = new Rect( -halfWidth, -halfHeight, halfWidth, halfHeight );
  }
  
  public void update( Rocket rocket )
  {
      if(rocket.position.x < SCROLLING_RIGHT_MAX && rocket.position.x > SCROLLING_LEFT_MAX )
      {
          dont_move_x = false;
          displayedArea.offsetTo(
              (int) rocket.position.x - halfWidth, (int) rocket.position.y - rocketYPosInDisplay );
          oldRocketX = (int) rocket.position.x - halfWidth;
      }
      else
      {
          dont_move_x = true;
          displayedArea.offsetTo(
               oldRocketX, (int) rocket.position.y - rocketYPosInDisplay );
      }
  }
  
  public static boolean insideDisplayArea( Planet planet )
  {
      Rect planetBox = new Rect(
          (int) ( planet.position.x - planet.bitmap.getWidth() / 2 ),
          (int) ( planet.position.y - planet.bitmap.getHeight() / 2 ),
          (int) ( planet.position.x + planet.bitmap.getWidth() / 2 ),
          (int) ( planet.position.y + planet.bitmap.getHeight() / 2 ) );
      return ( getInstance().displayedArea.contains( planetBox ) ||
          Rect.intersects( getInstance().displayedArea, planetBox ) );
  }
  
  public static Position getOffset()
  {
    return new Position( getInstance().displayedArea.left, getInstance().displayedArea.top );
  }
  
  public static Position offsetPosition( Position pos )
  {
      return new Position(
          pos.x - getInstance().displayedArea.left,
          pos.y - getInstance().displayedArea.top );
  }
  
  static DisplayArea getInstance()
  {
    if( instance == null )
    {
      instance = new DisplayArea();
    }
    return instance;
  }
}
