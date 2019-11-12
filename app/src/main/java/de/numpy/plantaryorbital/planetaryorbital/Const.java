package de.numpy.plantaryorbital.planetaryorbital;

import de.numpy.plantaryorbital.planetaryorbital.main.MainActivity;

/**
 * Created by Marvin on 23.01.2018.
 */

public class Const
{
    public static final double AVG_DISTANCE = MainActivity.getScreenSize().getHeight() * 2 / 5;
    
    public static final double HORI_SCATTERING = MainActivity.getScreenSize().getWidth() * 3 / 5;
    public static final double VERT_SCATTERING = AVG_DISTANCE / 4;
    
    public static final double MIN_RADIUS = 64.0;
    public static final double MAX_RADIUS = 100.0;
    
    public static final int TRAJECTORY_DRAW_NTH_POINT = 5;
    public static final int TRAJECTORY_POINT_SIZE = 5;
    public static final float TRAJECTORY_POINT_DIST = MainActivity.getScreenSize().getWidth() * 0.01f;
    
}
