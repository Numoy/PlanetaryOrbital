package de.numpy.plantaryorbital.planetaryorbital.trajectory;

import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;

import java.util.ArrayList;

import de.numpy.plantaryorbital.planetaryorbital.Const;
import de.numpy.plantaryorbital.planetaryorbital.Controller.Gravity;
import de.numpy.plantaryorbital.planetaryorbital.Utility.Intersect;
import de.numpy.plantaryorbital.planetaryorbital.planets.Planet;
import de.numpy.plantaryorbital.planetaryorbital.Model.Position;
import de.numpy.plantaryorbital.planetaryorbital.rocket.Rocket;

/**
 *
 * Created by Marvin on 21.10.2017.
 */

public class TrajectoryController
{
  private Trajectory trajectory;
  private TrajectoryView trajectoryView;

  private ArrayList<Planet> planets;
  private double timeSteps;
   
  public TrajectoryController( ArrayList<Planet> planets )
  {
    trajectoryView = new TrajectoryView();
    trajectory = new Trajectory( 300 );
    timeSteps = 1000.0 / 60.0;
    this.planets = planets;
  }
  
  public void update( Rocket rocket )
  {
    PhantomController phantomController = new PhantomController( rocket );
    trajectory.setCrash( false );
    trajectory.positionsOnTrajectory.clear();
    trajectory.positionsOnTrajectory.add( phantomController.getRocket().position );
    trajectory.startPoint++;
    
    for ( int i = 1; i < trajectory.getNumberOfPositions(); i++ )
    {
        phantomController.update( timeSteps );
        phantomController.calculateDistanceToPlanets( planets );
        Planet closestPlanet = phantomController.getClosestPlanet();
        Gravity.applyGravityToRocket( closestPlanet, phantomController.getRocket(), timeSteps );
        if ( phantomController.checkCollisionWith( closestPlanet ) ||
            !phantomController.checkPath() )
        {
            trajectory.crashed();
            break;
        }
        if ( i > 50 && Intersect.calcDist(
            rocket.position,
            trajectory.positionsOnTrajectory.get( i - 1 ) ) < Const.TRAJECTORY_POINT_DIST )
        {
            break;
        }
        trajectory.positionsOnTrajectory.add( new Position( phantomController.getRocket().position ) );
    }
  }
  
  public void draw( Canvas canvas )
  {
      if ( trajectory.getCrash() )
      {
          trajectoryView.getPaint().setColor(Color.RED);
      }
      else
      {
          trajectoryView.getPaint().setColor(Color.GREEN);
      }
      trajectoryView.draw( trajectory, canvas );
  }
}
