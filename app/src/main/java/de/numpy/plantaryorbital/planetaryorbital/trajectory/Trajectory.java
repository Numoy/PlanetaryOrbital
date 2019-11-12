package de.numpy.plantaryorbital.planetaryorbital.trajectory;

import java.util.ArrayList;

import de.numpy.plantaryorbital.planetaryorbital.Model.Position;

/**
 *
 * Created by Marvin on 21.10.2017.
 */

public class Trajectory
{
  public ArrayList<Position> positionsOnTrajectory;
  private int numberOfPositions;
  private boolean crash;
  public int startPoint = 0;
  
  public Trajectory( int numberOfPositions )
  {
    this.numberOfPositions = numberOfPositions;
    positionsOnTrajectory = new ArrayList<>();
  }

  public void crashed()
  {
      crash = true;
  }
  
  public int getNumberOfPositions()
  {
    return numberOfPositions;
  }

    public boolean getCrash() {
        return crash;
    }

    public void setCrash(boolean crash) {
        this.crash = crash;
    }
}
