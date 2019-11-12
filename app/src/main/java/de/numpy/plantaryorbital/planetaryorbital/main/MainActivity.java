package de.numpy.plantaryorbital.planetaryorbital.main;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Size;
import android.view.Display;
import android.view.View;
import android.widget.FrameLayout;

import de.numpy.plantaryorbital.planetaryorbital.Controller.Menu.Menu;
import de.numpy.plantaryorbital.planetaryorbital.Controller.Menu.UI.UIElement;
import de.numpy.plantaryorbital.planetaryorbital.Controller.Store.SavedSettings;
import de.numpy.plantaryorbital.planetaryorbital.Controller.Store.SpaceShipListSave;

public class MainActivity extends Activity
{
    
    private GameThread gameThread;
    private Thread thread;
    
    private static Size screenSize;
    //TODO Memory Leak ?!
    public static Activity activity;
    private static Context context;
    
    private Menu menu;
    
    
    @Override
    protected void onCreate ( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        activity = this;
        setScreenSize();
        context = this.getApplicationContext();
        SpaceShipListSave spaceShips = new SpaceShipListSave(true);
        SavedSettings.setMoney(100000);
        setContentView( buildLayout() );
    }
    
    @Override
    protected void onStart ()
    {
        super.onStart();
    }
    
    @Override
    protected void onRestart ()
    {
        super.onRestart();
    }
    
    @Override
    protected void onResume ()
    {
        super.onResume();
        gameThread.init();
        thread = new Thread( gameThread );
        thread.start();
    }
    
    @Override
    protected void onPause ()
    {
        super.onPause();
        try
        {
            gameThread.showMenu();
            gameThread.stopGame();
            thread.join();
        }
        catch ( InterruptedException e )
        {
            // TODO was bessers überlegen
        }
    }
    
    @Override
    protected void onStop ()
    {
        super.onStop();
    }
    
    public void setScreenSize ()
    {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize( size );
        screenSize = new Size( size.x, size.y );
    }
    
    @Override
    protected void onDestroy ()
    {
        super.onDestroy();
    }
    
    public View buildLayout ()
    {
        FrameLayout game = new FrameLayout( this );
        menu = new Menu( this);
        gameThread = new GameThread( this, menu );
        GameView gameView = gameThread.getGameView();
        game.addView( gameView );
        addMenu(game);
        
        return game;
    }

    private void addMenu(FrameLayout game)
    {
        for(UIElement uiElement : menu.getUiElements())
        {
            for(View viewElement :  uiElement.getViewElements())
            {
                game.addView(viewElement);
            }
        }
    }
    
    public static Context getContext ()
    {
        return context;
    }
    
    public static Size getScreenSize ()
    {
        return screenSize;
    }
    
    public GameThread getGameThread ()
    {
        return gameThread;
    }
    
}
