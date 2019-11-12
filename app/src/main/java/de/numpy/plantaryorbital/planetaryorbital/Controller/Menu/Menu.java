package de.numpy.plantaryorbital.planetaryorbital.Controller.Menu;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import de.numpy.plantaryorbital.planetaryorbital.Controller.Menu.UI.ControlButton;
import de.numpy.plantaryorbital.planetaryorbital.Controller.Menu.UI.RateButton;
import de.numpy.plantaryorbital.planetaryorbital.Controller.Menu.UI.RestartButton;
import de.numpy.plantaryorbital.planetaryorbital.Controller.Menu.UI.Settings;
import de.numpy.plantaryorbital.planetaryorbital.Controller.Menu.UI.SettingsButton;
import de.numpy.plantaryorbital.planetaryorbital.Controller.Menu.UI.SoundButton;
import de.numpy.plantaryorbital.planetaryorbital.Controller.Menu.UI.SpaceShipChooseButton;
import de.numpy.plantaryorbital.planetaryorbital.Controller.Menu.UI.SpaceShipListView;
import de.numpy.plantaryorbital.planetaryorbital.Controller.Menu.UI.UIElement;
import de.numpy.plantaryorbital.planetaryorbital.Controller.Store.SavedSettings;

/**
 * Created by Marvin on 28.11.2017.
 */

public class Menu {
    ArrayList<UIElement> uiElements = new ArrayList<>();



    public Menu(Context context)
    {
        uiElements.add(new RestartButton(context));
        SettingsButton settingsButton = new SettingsButton(context);
        uiElements.add(settingsButton);
        SoundButton soundButton = new SoundButton(context);
        uiElements.add(soundButton);
        RateButton rateButton = new RateButton(context);
        uiElements.add(rateButton);
        ControlButton controlButton = new ControlButton(context);
        uiElements.add(controlButton);
        SpaceShipChooseButton chooseButton = new SpaceShipChooseButton(context);
        uiElements.add(chooseButton);
        uiElements.add(chooseButton.spaceShipListView);
        uiElements.add(settingsButton.settingsView);


    }

    public void makeMainMenuVisible()
    {
        for(UIElement uiElement : uiElements)
        {
            if(uiElement.page == 1) {
                uiElement.makeVisible();
            }
        }
    }

    public void makeMainMenuInvisible()
    {
        for(UIElement uiElement : uiElements)
        {
            if(uiElement.page == 1) {
                uiElement.makeInvisible();
            }
        }
    }

    public void makeInvisible()
    {
        for(UIElement uiElement : uiElements)
        {
            uiElement.makeInvisible();
        }
    }

    public ArrayList<UIElement> getUiElements()
    {
        return uiElements;
    }
}
