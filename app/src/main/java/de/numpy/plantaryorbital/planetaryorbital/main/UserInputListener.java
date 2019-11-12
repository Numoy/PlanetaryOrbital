package de.numpy.plantaryorbital.planetaryorbital.main;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import de.numpy.plantaryorbital.planetaryorbital.Controller.Store.SavedSettings;
import de.numpy.plantaryorbital.planetaryorbital.Model.Position;
import de.numpy.plantaryorbital.planetaryorbital.main.MainActivity;

/**
 *
 * Created by Marvin on 20.10.2017.
 */

public class UserInputListener implements View.OnTouchListener
{
  
  private Position startTouchEvent;
  
  private double acceleration;
  public static boolean controlAlt = SavedSettings.isControlAlt();
  
  @Override
  public boolean onTouch ( View v, MotionEvent event )
  {
    int action = event.getActionMasked();
    Log.i("TochEvent","Action:" + action );
    switch ( action )
    {
      case MotionEvent.ACTION_DOWN:
          if(controlAlt)
          {
              touchDownAlt(event);
          }
          else
          {
              touchDown( event );
          }
        return true;
      case MotionEvent.ACTION_UP:
          touchUp();
        break;
      case MotionEvent.ACTION_MOVE:
          if(!controlAlt)
          {
              touchMove( event );
          }
    }
    return false;
  }
  
  private void touchUp()
  {
    startTouchEvent = null;
    acceleration = 0f;
  }

  
  private void touchDown( MotionEvent event )
  {
    if ( startTouchEvent == null )
    {
      startTouchEvent = new Position( event.getX(), event.getY() );
    }
  }

  private void touchDownAlt( MotionEvent event)
  {
      if(event.getX() < MainActivity.getScreenSize().getWidth() / 2)
      {
          acceleration -= 0.5;
      }
      else
      {
          acceleration += 0.5;
      }
  }
  
  private void touchMove( MotionEvent event )
  {
    double scrollHeight = calcScrollHeight( event );
    acceleration = scrollHeight / MainActivity.getScreenSize().getHeight();
  }
  
  private double calcScrollHeight( MotionEvent event )
  {
    return event.getY() - startTouchEvent.y;
  }
  
  public double getAcceleration()
  {
    return acceleration;
  }
}
