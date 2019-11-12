package de.numpy.plantaryorbital.planetaryorbital.Controller.Menu.UI;

import android.content.Context;
import android.util.Size;
import android.view.View;

import java.util.ArrayList;

import de.numpy.plantaryorbital.planetaryorbital.main.MainActivity;

/**
 * Created by Marvin on 28.11.2017.
 */

public class UIElement {

    //Which View -  first Main Menu
    public int page;

    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Context context;

    protected Size screenSize;

    public  ArrayList<View> viewElements = new ArrayList<>();

    public UIElement(Context context)
    {
        this.context = context;
        screenSize = MainActivity.getScreenSize();
    }

    protected void setSize(int width, int height)
    {
        this.width = width;
        this.height = height;
    }

    protected void setPosition(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public void makeVisible()
    {
        for(View viewElement :  viewElements)
        {
            viewElement.setVisibility(View.VISIBLE);
        }
    }

    public void makeInvisible()
    {
        for(View viewElement :  viewElements)
        {
            viewElement.setVisibility(View.GONE);
        }
    }

    public ArrayList<View> getViewElements()
    {
        return viewElements;
    }
}
