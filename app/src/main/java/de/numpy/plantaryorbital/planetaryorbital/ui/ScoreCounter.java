package de.numpy.plantaryorbital.planetaryorbital.ui;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Size;

import de.numpy.plantaryorbital.planetaryorbital.Controller.Store.SavedSettings;
import de.numpy.plantaryorbital.planetaryorbital.Model.Position;
import de.numpy.plantaryorbital.planetaryorbital.main.MainActivity;

/**
 * Created by Marvin on 28.11.2017.
 */

public class ScoreCounter
{
    private final String HIGHSCORE = "Highscore: " ;

    private int score;
    
    private Paint scorePaint;
    private Paint menuScorePaint;
    private Paint highscorePaint;
    
    private Position ingameScore;
    private Position menuScore;
    private Position highscore;
    
    public ScoreCounter()
    {
        score = 0;
        scorePaint = new Paint();
        scorePaint.setColor( Color.WHITE );
        scorePaint.setTextSize( 100f );
        
        menuScorePaint = new Paint( scorePaint );
        menuScorePaint.setTextSize( 200f );

        highscorePaint = new Paint( scorePaint );
        highscorePaint.setTextSize( 50f );
        
        Size screen = MainActivity.getScreenSize();
        
        ingameScore = new Position(
            screen.getWidth() / 2 - 30f,
            screen.getHeight() * 0.1 );
        
        menuScore = new Position(
            screen.getWidth() / 2 - 60f,
            screen.getHeight() * 0.15 );

        highscore = new Position(
            screen.getWidth() / 2 - 160f,
            screen.getHeight() * 0.2 );
    }
    
    public void setScore( int score )
    {
        this.score = score;
    }
    
    public void draw ( Canvas canvas )
    {
        canvas.drawText( Integer.toString( score ), (float) ingameScore.x, (float) ingameScore.y , scorePaint );
    }
    
    public void drawMenuScore( Canvas canvas )
    {
        canvas.drawText( Integer.toString( score ), (float) menuScore.x, (float) menuScore.y, menuScorePaint );
        canvas.drawText( HIGHSCORE + Integer.toString(SavedSettings.getHighscore()), (float) highscore.x, (float) highscore.y, highscorePaint);
    }
    
    public int getScore ()
    {
        return score;
    }
}
