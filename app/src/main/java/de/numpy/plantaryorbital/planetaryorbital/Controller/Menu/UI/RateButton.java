package de.numpy.plantaryorbital.planetaryorbital.Controller.Menu.UI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import de.numpy.plantaryorbital.planetaryorbital.R;

/**
 * Created by Marvin on 01.01.2018.
 */

public class RateButton extends UIElement implements View.OnClickListener {

    private Button rate;

    public RateButton(Context context) {
        super(context);
        page = 1;
        setButtonAttributes();
        viewElements.add(rate);
    }

    private void setButtonAttributes()
    {
        setSize(44,44 );
        setPosition(0, (int) (screenSize.getHeight() * 0.4));
        rate = (Button) LayoutInflater.from(context).inflate(R.layout.rate_button,null);
        rate.setVisibility(View.GONE);
        rate.setLayoutParams(new FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        rate.setX(x);
        rate.setY(y);

        rate.setWidth(width);
        rate.setHeight(height);

        rate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
