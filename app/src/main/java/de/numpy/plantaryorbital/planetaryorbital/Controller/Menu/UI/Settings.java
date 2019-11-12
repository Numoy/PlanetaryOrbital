package de.numpy.plantaryorbital.planetaryorbital.Controller.Menu.UI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import de.numpy.plantaryorbital.planetaryorbital.Controller.Menu.UI.UIElement;
import de.numpy.plantaryorbital.planetaryorbital.Controller.Store.SavedSettings;
import de.numpy.plantaryorbital.planetaryorbital.R;

/**
 * Created by Marvin on 05.12.2017.
 */

public class Settings extends UIElement implements View.OnClickListener {

    public LinearLayout settingsView;

    public Settings(Context context) {
        super(context);
        buildLayout();

        settingsView.setVisibility(View.GONE);
        viewElements.add(settingsView);
    }

    private void buildLayout() {
        settingsView = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.settings_view, null);

        settingsView.setVisibility(View.GONE);
        settingsView.setLayoutParams(new FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        setSize((int) (screenSize.getWidth() * 0.6),(int) (screenSize.getHeight() * 0.5));
        setPosition(screenSize.getWidth() / 2 - width / 2, (int) (screenSize.getHeight() * 0.1) / 2);

        settingsView.setLayoutParams(new FrameLayout.LayoutParams(
            width,
            height
        ));

        settingsView.setX(x);
        settingsView.setY(y);

        settingsView.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.settingsView:
                settingsView.setVisibility(View.GONE);
                break;
        }

    }


}
