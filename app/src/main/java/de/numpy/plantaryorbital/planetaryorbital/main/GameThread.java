package de.numpy.plantaryorbital.planetaryorbital.main;

import android.app.Activity;

import de.numpy.plantaryorbital.planetaryorbital.Controller.Menu.Menu;
import de.numpy.plantaryorbital.planetaryorbital.Controller.Store.SavedSettings;

/**
 *
 * Created by Marvin on 16.10.2017.
 */

public class GameThread implements Runnable
{
  private volatile boolean gameRunning;

  private GameObjects gameObjects;
  private GameView gameView;
  
  private UserInputListener userInputListener;
    
    private Activity activity;
  private Menu menu;

  private int spaceShipResourceID;
  private int energyResourceID;
  
  GameThread ( Activity activity, Menu menu )
  {
    this.activity = activity;
    this.menu = menu;
    spaceShipResourceID = SavedSettings.getRocketImageResource();
    energyResourceID = SavedSettings.getEnergyImageResource();
    gameObjects = new GameObjects( activity.getApplicationContext() );
    
    userInputListener = new UserInputListener();
    this.gameView= new GameView( activity.getApplicationContext(), userInputListener );
  }
  
  void init ()
  {
    gameRunning = true;
  }
  
  @Override
  public void run ()
  {
      long lastUpdate = System.nanoTime();
    while ( gameRunning )
    {
        long currentTime = System.nanoTime();
      update( currentTime - lastUpdate );
      lastUpdate = currentTime;
      gameView.drawGame( gameObjects );
    }
  }
  
  private void update ( long elapsedNanos )
  {
    double elapsedMillis = elapsedNanos / 1000000.0;
    changeSpaceShipImageIfChanged();
    if ( gameObjects.update( elapsedMillis, userInputListener.getAcceleration() ) )
    {
        showMenu();
    }
  }
  
  void showMenu ()
  {
      setToIdle( gameObjects.getScore() );
      activity.runOnUiThread(new Runnable() {
          @Override
          public void run() {
              menu.makeMainMenuVisible();
          }
      });
  }
  
  private void setToIdle ( int score )
  {
      newHighscore(score);
      gameObjects = new GameObjects( activity.getApplicationContext());
      gameObjects.setAcceptUserInput( false );
      gameObjects.setScore( score );
  }
  
  public void returnFromIdle ()
  {
      menu.makeInvisible();
      gameObjects.setScore( 0 );
      gameObjects.setAcceptUserInput( true );
      //Do Camera stuff
  }

  private boolean hasSpaceShipImageChanged()
  {
      return spaceShipResourceID != SavedSettings.getRocketImageResource();
  }

  private boolean hasEnergyImageChanged()
  {
      return energyResourceID != SavedSettings.getEnergyImageResource();
  }

  private void changeSpaceShipImageIfChanged()
  {
      if(hasSpaceShipImageChanged())
      {
          spaceShipResourceID = SavedSettings.getRocketImageResource();
          gameObjects.rocketController.loadRocketBitmap(spaceShipResourceID);
      }

      if(hasEnergyImageChanged())
      {
          energyResourceID = SavedSettings.getEnergyImageResource();
          gameObjects.energieController.changeEnergy(energyResourceID);
      }
  }

  private void newHighscore(int score)
  {
      if(score > SavedSettings.getHighscore())
      {
          SavedSettings.setHighscore(score);
      }
  }
  
  void stopGame ()
  {
      gameRunning = false;
  }
  
  GameView getGameView ()
  {
    return gameView;
  }
}
