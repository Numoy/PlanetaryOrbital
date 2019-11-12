package de.numpy.plantaryorbital.planetaryorbital.Controller.Menu.UI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import de.numpy.plantaryorbital.planetaryorbital.R;

/**
 * Created by Marvin on 28.11.2017.
 */

public class SettingsButton extends UIElement implements View.OnClickListener {

    public Button settings;
    public Settings settingsView;


    public SettingsButton(Context context)
    {
        super(context);
        page = 1;
        setButtonAttributes();
        setSettingsView();
        viewElements.add(settings);
    }

    private void setButtonAttributes()
    {
        setSize(20,20 );
        setPosition(10, (int) 10);
        settings = (Button) LayoutInflater.from(context).inflate(R.layout.settings_button,null);
        settings.setVisibility(View.GONE);
        settings.setLayoutParams(new FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        settings.setX(x);
        settings.setY(y);

        settings.setWidth(width);
        settings.setHeight(height);

        settings.setOnClickListener(this);
    }

    private void setSettingsView()
    {
        settingsView = new Settings(context);
    }


    public void onClick(View v)
    {
        settingsView.settingsView.setVisibility(View.VISIBLE);
    }
}
