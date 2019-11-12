package de.numpy.plantaryorbital.planetaryorbital.main;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import de.numpy.plantaryorbital.planetaryorbital.ui.FPSCounter;
import de.numpy.plantaryorbital.planetaryorbital.ui.FuelLevelBar;
import de.numpy.plantaryorbital.planetaryorbital.Controller.Gravity;
import de.numpy.plantaryorbital.planetaryorbital.ui.MoneyController;
import de.numpy.plantaryorbital.planetaryorbital.ui.ScoreCounter;
import de.numpy.plantaryorbital.planetaryorbital.R;
import de.numpy.plantaryorbital.planetaryorbital.Utility.BitmapUtility;
import de.numpy.plantaryorbital.planetaryorbital.energy.EnergieController;
import de.numpy.plantaryorbital.planetaryorbital.planets.PlanetController;
import de.numpy.plantaryorbital.planetaryorbital.rocket.RocketController;
import de.numpy.plantaryorbital.planetaryorbital.stars.BackgroundController;
import de.numpy.plantaryorbital.planetaryorbital.trajectory.TrajectoryController;

/**
 *
 * Created by Marvin on 26.11.2017.
 */

public class GameObjects
{
    RocketController rocketController;
    private PlanetController planetController;
    EnergieController energieController;
    private TrajectoryController trajectoryController;
    private DisplayArea displayAreaController;
    private BackgroundController backgroundController;
    private MoneyController moneyController;

    private FPSCounter fpsCounter;
    private FuelLevelBar fuelLevelBar;
    private ScoreCounter scoreCounter;
    
    private boolean acceptUserInput;
    
    private Bitmap test;

    GameObjects ( Context context )
    {
        rocketController = new RocketController( context );
        fuelLevelBar = new FuelLevelBar( rocketController.getRocket() );
        displayAreaController = DisplayArea.getInstance();
        planetController = new PlanetController( context );
        energieController = new EnergieController( rocketController.getRocket(), planetController.getPlanets() );
        backgroundController = new BackgroundController( context );
        trajectoryController = new TrajectoryController( planetController.getPlanets() );

        fpsCounter = new FPSCounter();
        scoreCounter = new ScoreCounter();
        moneyController = new MoneyController();
        acceptUserInput = true;
        test = BitmapUtility.getBitmapFromDrawable( context, R.drawable.hp_entwurf, 600, 150 );
    }

    public boolean update( double elapsedMillis, double swipeDistance )
    {
        fpsCounter.update( elapsedMillis );

        rocketController.update( elapsedMillis );
        if( acceptUserInput )
        {
            rocketController.applyThrust( swipeDistance, elapsedMillis );
            displayAreaController.update( rocketController.getRocket() );
            backgroundController.update( rocketController.getRocket(), elapsedMillis );
        }
        fuelLevelBar.update();
        rocketController.calculateDistanceToPlanets( planetController.getPlanets() );
        planetController.update( rocketController.getRocket() );
        energieController.update( elapsedMillis );
        scoreCounter.setScore( planetController.getPoints() );
        
        if ( rocketController.checkCollisionWith( rocketController.getClosestPlanet() ) ||
            !rocketController.checkPath() )
        {
            return true;
        }
        
        Gravity.applyGravityToRocket(
            rocketController.getClosestPlanet(),
            rocketController.getRocket(),
            elapsedMillis );

        //trajectory
        trajectoryController.update( rocketController.getRocket() );
        return false;
    }

    public void draw(Canvas canvas)
    {
        backgroundController.draw( canvas );
        planetController.draw( canvas );
        trajectoryController.draw( canvas );
        energieController.draw( canvas );
        rocketController.draw( canvas );
        
        if( acceptUserInput )
        {
            fuelLevelBar.draw( canvas );
            scoreCounter.draw( canvas );
        }
        else
        {
            // Größer
            scoreCounter.drawMenuScore( canvas );
            moneyController.draw( canvas );

        }
        
        fpsCounter.draw( canvas );
        /*canvas.drawBitmap( test,
            (float) ( 10 ),
            (float) ( 10 ),
            null );*/
    }
    
    int getScore ()
    {
        return scoreCounter.getScore();
    }
    
    void setScore ( int score )
    {
        scoreCounter.setScore( score );
        planetController.setPoints( score );
        setMoney(score);
    }

    void setMoney(int score)
    {
        moneyController.money.setMoney(score);
    }

    
    void setAcceptUserInput ( boolean acceptUserInput )
    {
        this.acceptUserInput = acceptUserInput;
    }
}
