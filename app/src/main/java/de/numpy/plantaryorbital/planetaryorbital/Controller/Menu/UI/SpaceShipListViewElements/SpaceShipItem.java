package de.numpy.plantaryorbital.planetaryorbital.Controller.Menu.UI.SpaceShipListViewElements;

/**
 * Created by Marvin on 29.11.2017.
 */

public class SpaceShipItem {

     public int spaceShipResourceID;
     public int spaceShipEnergyResourceID;
     public String name;
     public boolean isUnlocked;
     public int spaceShipShadowID;
     public float price;

    public SpaceShipItem(int spaceShipResourceID,int spaceShipEnergyResrouceID, String name) {
        this.spaceShipResourceID = spaceShipResourceID;
        this.spaceShipEnergyResourceID = spaceShipEnergyResrouceID;
        this.name = name;
    }

    public SpaceShipItem(int spaceShipResourceID,int spaceShipEnergyResrouceID, String name, boolean isUnlocked, int spaceShipShadowID, float price) {
        this.spaceShipResourceID = spaceShipResourceID;
        this.spaceShipEnergyResourceID = spaceShipEnergyResrouceID;
        this.name = name;
        this.isUnlocked = isUnlocked;
        this.spaceShipShadowID = spaceShipShadowID;
        this.price = price;
    }

    public int getSpaceShipResourceID() {
        return spaceShipResourceID;
    }

    public void setSpaceShipResourceID(int spaceShipResourceID) {
        this.spaceShipResourceID = spaceShipResourceID;
    }

    public int getSpaceShipEnergyResourceID()
    {
        return spaceShipEnergyResourceID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
