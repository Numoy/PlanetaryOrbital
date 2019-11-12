package de.numpy.plantaryorbital.planetaryorbital.Controller.Menu.UI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import de.numpy.plantaryorbital.planetaryorbital.Controller.Store.SavedSettings;
import de.numpy.plantaryorbital.planetaryorbital.R;

/**
 * Created by Marvin on 01.01.2018.
 */

public class SoundButton extends UIElement implements View.OnClickListener {

    Button sound;

    public SoundButton(Context context) {
        super(context);
        page = 1;
        setButtonAttributes();
        viewElements.add(sound);
    }

    private void setButtonAttributes()
    {
        setSize(44,44 );
        setPosition(0, (int) (screenSize.getHeight() * 0.25));
        sound = (Button) LayoutInflater.from(context).inflate(R.layout.sound_button,null);
        sound.setVisibility(View.GONE);
        sound.setLayoutParams(new FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        sound.setX(x);
        sound.setY(y);

        sound.setWidth(width);
        sound.setHeight(height);

        sound.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(SavedSettings.isSound())
        {
            SavedSettings.setSound(false);
            sound.setBackgroundResource(R.drawable.sound_mute_button);
        }
        else
        {
            SavedSettings.setSound(true);
            sound.setBackgroundResource(R.drawable.sound_button);
        }
    }
}
