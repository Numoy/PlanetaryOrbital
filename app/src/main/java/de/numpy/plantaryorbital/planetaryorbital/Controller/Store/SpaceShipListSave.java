package de.numpy.plantaryorbital.planetaryorbital.Controller.Store;

import java.util.ArrayList;

import de.numpy.plantaryorbital.planetaryorbital.Controller.Menu.UI.SpaceShipListViewElements.SpaceShipItem;
import de.numpy.plantaryorbital.planetaryorbital.R;

/**
 * Created by Marvin on 30.12.2017.
 */

public class SpaceShipListSave {

    public  static ArrayList<SpaceShipItem> spaceshipList = new ArrayList<>();

    public SpaceShipListSave(boolean firstStart)
    {
        if(firstStart)
        {
            firstInit();
        }
        else
        {
            spaceshipList = SavedSettings.getSpaceShipList();
        }
    }

    public void firstInit()
    {
        spaceshipList.add(new SpaceShipItem(R.drawable.spaceship1_vector,R.drawable.energy_vector,"The Rocket", true, R.drawable.spaceship1_shadow_vector, 0f));
        spaceshipList.add(new SpaceShipItem(R.drawable.spaceship2_vector,R.drawable.energy_spaceship2_vector,"Paper Plane", false, R.drawable.spaceship2_shadow_vector, 20f));
        spaceshipList.add(new SpaceShipItem(R.drawable.spaceship3_vector,R.drawable.energy_sharpener_vector,"The Pen", false, R.drawable.spaceship3_shadow_vector, 50f));
        //spaceshipList.add(new SpaceShipItem(R.drawable.spaceship4_vector,R.drawable.energy_vector,"The UFO", false, R.drawable.spaceship4_shadow_vector, 150f));
        spaceshipList.add(new SpaceShipItem(R.drawable.spaceship5_vector,R.drawable.energy_salami_vector,"Pizza Slice", false, R.drawable.spaceship5_shadow_vector, 300f));
        spaceshipList.add(new SpaceShipItem(R.mipmap.shuttle_bit,R.drawable.energy_vector,"The Space Shuttle", false, R.drawable.spaceship6_shadow_vector, 700f));
        spaceshipList.add(new SpaceShipItem(R.mipmap.falcon_heavy_xxxhdpi, R.drawable.energy_vector, "Falcon Heavy", false, R.mipmap.falcon_heavy_shadow_xxxhdpi, 1000f));
        SavedSettings.saveSpaceShipList(spaceshipList);
    }
}
