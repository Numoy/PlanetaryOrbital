package de.numpy.plantaryorbital.planetaryorbital.Model;

import android.util.Size;

import de.numpy.plantaryorbital.planetaryorbital.main.MainActivity;


/**
 *
 * Created by Marvin on 21.10.2017.
 */

public class FourPositions
{
  public Position topLeft;
  public Position topRight;
  public Position bottomLeft;
  public Position bottomRight;
  
  private int halfWidth;
  private int halfHeight;
  
  private Size size;
  
  public FourPositions ( Position viewPosition )
  {
    size = MainActivity.getScreenSize();
    halfHeight = size.getHeight() / 2;
    halfWidth = size.getWidth() / 2;
  
    topLeft = new Position( viewPosition.x - halfWidth, viewPosition.y - halfHeight );
    topRight = new Position( viewPosition.x + halfWidth, viewPosition.y - halfHeight );
    bottomLeft = new Position( viewPosition.x - halfWidth, viewPosition.y + halfHeight );
    bottomRight = new Position( viewPosition.x + halfWidth, viewPosition.y + halfHeight );
  }
  
  public void offsetTo( int x, int y )
  {
    int modX = x % size.getWidth();
    int modY = y % size.getHeight();
    
    if( modX < 0 )
    {
      modX += size.getWidth();
    }
    if ( modY < 0 )
    {
      modY += size.getHeight();
    }
    topLeft.offsetTo( modX - size.getWidth(), modY - size.getHeight() );
    topRight.offsetTo( modX, modY - size.getHeight() );
    bottomLeft.offsetTo( modX - size.getWidth(), modY );
    bottomRight.offsetTo( modX, modY );
  }
}
