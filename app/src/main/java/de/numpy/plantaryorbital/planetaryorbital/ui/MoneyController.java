package de.numpy.plantaryorbital.planetaryorbital.ui;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import de.numpy.plantaryorbital.planetaryorbital.Model.Money;

/**
 * Created by Marvin on 09.12.2017.
 */

public class MoneyController {

    public Money money;
    private Paint moneyPaint;

    private int x;
    private int y;

    public MoneyController()
    {
        money = new Money();
        moneyPaint = new Paint();
        moneyPaint.setColor(Color.WHITE);
        moneyPaint.setTextSize(30);

        x = 200;
        y = 50;
    }


    public void draw( Canvas canvas )
    {
        canvas.drawText( "Money:",x,y,moneyPaint);
        canvas.drawText( String.valueOf(money.getMoney()) + "S$",x + 100,y,moneyPaint);
    }
}
