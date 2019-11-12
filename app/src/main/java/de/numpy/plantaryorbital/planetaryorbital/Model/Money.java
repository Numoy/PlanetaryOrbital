package de.numpy.plantaryorbital.planetaryorbital.Model;

import de.numpy.plantaryorbital.planetaryorbital.Controller.Store.SavedSettings;

/**
 * Created by Marvin on 09.12.2017.
 */

public class Money {
    private int money;

    public void Money()
    {
        this.money = SavedSettings.getMoney();
    }

    public void setMoney(int money)
    {
        SavedSettings.setMoney(SavedSettings.getMoney() + money);
    }

    public int getMoney()
    {
        return SavedSettings.getMoney();
    }
}
