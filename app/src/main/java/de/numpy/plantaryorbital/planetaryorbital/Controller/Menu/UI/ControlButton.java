package de.numpy.plantaryorbital.planetaryorbital.Controller.Menu.UI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import de.numpy.plantaryorbital.planetaryorbital.Controller.Store.SavedSettings;
import de.numpy.plantaryorbital.planetaryorbital.main.UserInputListener;
import de.numpy.plantaryorbital.planetaryorbital.R;

/**
 * Created by Marvin on 04.01.2018.
 */

public class ControlButton extends UIElement implements View.OnClickListener {

    private Button control;

    public ControlButton(Context context) {
        super(context);
        page = 1;
        setButtonAttributes();
        viewElements.add(control);
    }

    private void setButtonAttributes()
    {
        setSize(44,44 );
        setPosition(0, (int) (screenSize.getHeight() * 0.55));
        control = (Button) LayoutInflater.from(context).inflate(R.layout.control_button,null);
        control.setVisibility(View.GONE);
        control.setLayoutParams(new FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        control.setX(x);
        control.setY(y);

        control.setWidth(width);
        control.setHeight(height);

        if(SavedSettings.isControlAlt())
        {
            control.setBackgroundResource(R.drawable.control_alt_button);
        }
        else
        {
            control.setBackgroundResource(R.drawable.control_button);
        }

        control.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(SavedSettings.isControlAlt())
        {
            control.setBackgroundResource(R.drawable.control_button);
            UserInputListener.controlAlt = false;
            SavedSettings.setControlAlt(false);
        }
        else
        {
            control.setBackgroundResource(R.drawable.control_alt_button);
            UserInputListener.controlAlt = true;
            SavedSettings.setControlAlt(true);
        }
    }
}
