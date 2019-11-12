package de.numpy.plantaryorbital.planetaryorbital.Model;

/**
 *
 * Created by Marvin on 20.10.2017.
 */

public class Position
{
  public double x;
  public double y;
  
  public Position( double xPos, double yPos )
  {
    this.x = xPos;
    this.y = yPos;
  }
  
  public Position()
  {
    this( 0.0, 0.0 );
  }
  
  public void offsetTo( double x, double y )
  {
    this.x = x;
    this.y = y;
  }
  public Position( Position srcPos )
  {
      x = srcPos.x;
      y = srcPos.y;
  }

  public double calculateDistanceTo( Position pos )
  {
      double distX = x - pos.x;
      double distY = y - pos.y;
      return Math.sqrt( distX * distX + distY * distY );
  }
  
  public String toString()
  {
      return "X:" + x + " Y:" + y;
  }
}
