package de.numpy.plantaryorbital.planetaryorbital.Controller.Menu.UI;

import android.content.Context;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import de.numpy.plantaryorbital.planetaryorbital.main.MainActivity;
import de.numpy.plantaryorbital.planetaryorbital.R;

/**
 * Created by Marvin on 28.11.2017.
 */

public class RestartButton extends UIElement implements View.OnClickListener {

    public Button restartButton;


    public RestartButton(Context context)
    {
        super(context);
        page = 1;
        setButtonAttributes();
        viewElements.add(restartButton);
    }

    private void setButtonAttributes()
    {
        setSize();
        setPosition();
        restartButton = (Button) LayoutInflater.from(context).inflate(R.layout.restart_button,null);
        restartButton.setVisibility(View.GONE);
        restartButton.setLayoutParams(new FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        restartButton.setX(x);
        restartButton.setY(y);

        restartButton.setWidth(width);
        restartButton.setHeight(height);

        restartButton.setOnClickListener(this);
    }

    private void setSize()
    {
        Size size = MainActivity.getScreenSize();
        //Button Diameter is 1/4 of Screen Width
        width = size.getWidth() / 4;
        height = width;
    }

    private  void setPosition()
    {
        Size size = MainActivity.getScreenSize();
        //Button is in lower Center;
        x =  size.getWidth() / 2 - width / 2;
        y = (int) (size.getHeight() * 0.85 - height / 2);
    }


   public void onClick(View v)
   {
       makeInvisible();
       ((MainActivity) context).getGameThread().returnFromIdle();
   }
}
