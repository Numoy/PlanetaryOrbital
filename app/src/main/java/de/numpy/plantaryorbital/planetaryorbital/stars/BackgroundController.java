package de.numpy.plantaryorbital.planetaryorbital.stars;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Size;

import java.util.Random;

import de.numpy.plantaryorbital.planetaryorbital.main.DisplayArea;
import de.numpy.plantaryorbital.planetaryorbital.main.MainActivity;
import de.numpy.plantaryorbital.planetaryorbital.rocket.Rocket;

/**
 *
 * Created by Marvin on 21.10.2017.
 */

public class BackgroundController
{
  private Background background;
  private BackgroundView backgroundView;
  private StarView starView;
  
  private Star[] closeStars;
  private Star[] farStars;
  
  private Size screenSize;
  
  public BackgroundController( Context context )
  {
    background = new Background( context );
    backgroundView = new BackgroundView();
    starView = new StarView();
    
    screenSize = MainActivity.getScreenSize();
    
    closeStars = new Star[ 20 ];
    farStars = new Star[ 20 ];
    
    createStars();
  }
  
  private void createStars()
  {
    Random rnd = new Random();
    for ( int i = 0; i < closeStars.length; i++ )
    {
      closeStars[ i ] = new Star
              ( screenSize.getWidth() * rnd.nextFloat(),
                screenSize.getHeight() * rnd.nextFloat(),
                rnd.nextFloat() / 4 + 0.75f );
    }
  
    for ( int i = 0; i < farStars.length; i++ )
    {
      farStars[ i ] = new Star
              ( screenSize.getWidth() * rnd.nextFloat(),
                      screenSize.getHeight() * rnd.nextFloat(),
                      rnd.nextFloat() / 4 + 0.25f );
    }
  }
  
  public void update ( Rocket rocket, double elapsedMillis )
  {
          for (Star star : closeStars) {
              moveStar(star, rocket, elapsedMillis);
          }

          for (Star star : farStars) {
              moveStar(star, rocket, elapsedMillis / 2);
          }
  }
  
  private void moveStar( Star star, Rocket rocket, double elapsedMillis )
  {
      if(!DisplayArea.dont_move_x) {
          star.x -= rocket.velocity.x * elapsedMillis;
      }
    star.y -= rocket.velocity.y * elapsedMillis;
    
    if ( star.x < - Star.STAR_SIZE * screenSize.getWidth() )
    {
      star.x = ( Star.STAR_SIZE + 1 ) * screenSize.getWidth();
    }
    else if ( star.x > ( Star.STAR_SIZE + 1 ) * screenSize.getWidth() )
    {
      star.x = - Star.STAR_SIZE * screenSize.getWidth();
    }
  
    if ( star.y < - Star.STAR_SIZE * screenSize.getWidth() )
    {
      star.y = ( Star.STAR_SIZE + 1 ) * screenSize.getHeight();
    }
    else if ( star.y > ( Star.STAR_SIZE + 1 ) * screenSize.getHeight() )
    {
      star.y = - Star.STAR_SIZE * screenSize.getWidth();
    }
  }
  
  public void draw( Canvas canvas )
  {
    backgroundView.draw( canvas, background );
    for ( Star star : closeStars )
    {
      starView.draw( canvas, star );
    }
  
    for ( Star star : farStars )
    {
      starView.draw( canvas, star );
    }
  }
}
