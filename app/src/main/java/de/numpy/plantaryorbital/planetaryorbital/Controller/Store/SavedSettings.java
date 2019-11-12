package de.numpy.plantaryorbital.planetaryorbital.Controller.Store;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.numpy.plantaryorbital.planetaryorbital.main.MainActivity;
import de.numpy.plantaryorbital.planetaryorbital.Controller.Menu.UI.SpaceShipListViewElements.SpaceShipItem;
import de.numpy.plantaryorbital.planetaryorbital.R;


/**
 * Created by Marvin on 03.12.2017.
 */

public final class SavedSettings {

    public static void setRocketImageResource(int resourceID)
    {
        SharedPreferences.Editor editor = MainActivity.activity.getSharedPreferences("settings", Context.MODE_PRIVATE).edit();
        editor.putInt(MainActivity.activity.getString(R.string.rocket_drawable), resourceID);
        editor.commit();
    }

    public static int getRocketImageResource()
    {
        SharedPreferences prefs = MainActivity.activity.getSharedPreferences("settings", Context.MODE_PRIVATE);
        return  prefs.getInt(MainActivity.activity.getString(R.string.rocket_drawable), R.drawable.spaceship1_vector);
    }

    public static void setEnergyImageResource(int resourceID)
    {
        SharedPreferences.Editor editor = MainActivity.activity.getSharedPreferences("settings", Context.MODE_PRIVATE).edit();
        editor.putInt(MainActivity.activity.getString(R.string.energy_drawable), resourceID);
        editor.commit();
    }

    public static int getEnergyImageResource()
    {
        SharedPreferences prefs = MainActivity.activity.getSharedPreferences("settings", Context.MODE_PRIVATE);
        return  prefs.getInt(MainActivity.activity.getString(R.string.energy_drawable), R.drawable.energy_vector);
    }

    public static void setHighscore(int score)
    {
        SharedPreferences.Editor editor = MainActivity.activity.getSharedPreferences("settings", Context.MODE_PRIVATE).edit();
        editor.putInt(MainActivity.activity.getString(R.string.highscore), score);
        editor.commit();
    }

    public static int getHighscore() {
        SharedPreferences prefs = MainActivity.activity.getSharedPreferences("settings", Context.MODE_PRIVATE);
        return prefs.getInt(MainActivity.activity.getString(R.string.highscore), 0);
    }

    public static void setSoundMuted(boolean mute)
    {
        SharedPreferences.Editor editor = MainActivity.activity.getSharedPreferences("settings", Context.MODE_PRIVATE).edit();
        editor.putBoolean(MainActivity.activity.getString(R.string.sound), mute);
        editor.commit();
    }

    public static boolean getSoundMuted() {
        SharedPreferences prefs = MainActivity.activity.getSharedPreferences("settings", Context.MODE_PRIVATE);
        return prefs.getBoolean(MainActivity.activity.getString(R.string.sound), true);
    }

    public static void setMoney(int money)
    {
        SharedPreferences.Editor editor = MainActivity.activity.getSharedPreferences("settings", Context.MODE_PRIVATE).edit();
        editor.putInt(MainActivity.activity.getString(R.string.money), money);
        editor.commit();
    }

    public static int getMoney() {
        SharedPreferences prefs = MainActivity.activity.getSharedPreferences("settings", Context.MODE_PRIVATE);
        return prefs.getInt(MainActivity.activity.getString(R.string.money), 0);
    }

    public static void setFirstTime()
    {
        SharedPreferences.Editor editor = MainActivity.activity.getSharedPreferences("settings", Context.MODE_PRIVATE).edit();
        editor.putBoolean(MainActivity.activity.getString(R.string.firsttime), false);
        editor.commit();
    }

    public static boolean isFirstTime()
    {
        SharedPreferences prefs = MainActivity.activity.getSharedPreferences("settings", Context.MODE_PRIVATE);
        return prefs.getBoolean(MainActivity.activity.getString(R.string.firsttime), true);
    }

    public static void setControlAlt(boolean alt)
    {
        SharedPreferences.Editor editor = MainActivity.activity.getSharedPreferences("settings", Context.MODE_PRIVATE).edit();
        editor.putBoolean(MainActivity.activity.getString(R.string.control), alt);
        editor.commit();
    }

    public static boolean isControlAlt()
    {
        SharedPreferences prefs = MainActivity.activity.getSharedPreferences("settings", Context.MODE_PRIVATE);
        return prefs.getBoolean(MainActivity.activity.getString(R.string.control), true);
    }

    public static void setSound(boolean sound)
    {
        SharedPreferences.Editor editor = MainActivity.activity.getSharedPreferences("settings", Context.MODE_PRIVATE).edit();
        editor.putBoolean(MainActivity.activity.getString(R.string.sound), sound);
        editor.commit();
    }

    public static boolean isSound()
    {
        SharedPreferences prefs = MainActivity.activity.getSharedPreferences("settings", Context.MODE_PRIVATE);
        return prefs.getBoolean(MainActivity.activity.getString(R.string.sound), true);
    }

    public static void saveSpaceShipList(List<SpaceShipItem> spaceShips)
    {
        SharedPreferences.Editor editor = MainActivity.activity.getSharedPreferences("settings", Context.MODE_PRIVATE).edit();
        Gson gson = new Gson();
        String jsonList = gson.toJson(spaceShips);

        editor.putString("SpaceShipList", jsonList);
        editor.commit();
    }

    public static ArrayList<SpaceShipItem> getSpaceShipList()
    {
        SharedPreferences prefs = MainActivity.activity.getSharedPreferences("settings", Context.MODE_PRIVATE);

        List<SpaceShipItem> spaceShips;

        if(prefs.contains("SpaceShipList")) {
            String jsonSpaceships = prefs.getString("SpaceShipList",null);
            Gson gson = new Gson();
            SpaceShipItem[] spaceShipItems = gson.fromJson(jsonSpaceships, SpaceShipItem[].class);

            spaceShips = Arrays.asList(spaceShipItems);
            spaceShips = new ArrayList<SpaceShipItem>(spaceShips);
        } else { return null; }

        return (ArrayList<SpaceShipItem>) spaceShips;
    }


}