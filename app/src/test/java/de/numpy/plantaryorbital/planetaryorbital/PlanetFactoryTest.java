package de.numpy.plantaryorbital.planetaryorbital;

import org.junit.Test;

import de.numpy.plantaryorbital.planetaryorbital.planets.PlanetFactory;
import de.numpy.plantaryorbital.planetaryorbital.planets.Planet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Marvin on 27.11.2017.
 */

public class PlanetFactoryTest
{
    @Test
    public void createPlanetsByNumberTest() throws Exception {
        PlanetFactory pFac = new PlanetFactory(null);
    
        Planet p1 = pFac.getPlanetAt( 1 );
        Planet p2 = pFac.getPlanetAt( 1 );
        Planet p3 = pFac.getPlanetAt( 2 );
    
        logPlanet( p1 );
        logPlanet( p2 );
        logPlanet( p3 );
        
        
        assertEquals( p1 , p2 );
        assertNotEquals( p1, p3 );
    }
    
    private void logPlanet( Planet p )
    {
        System.out.println( "X:" + p.position.x );
        System.out.println( "Y:" + p.position.y );
        System.out.println( "Radius:" + p.radius );
    }
}
