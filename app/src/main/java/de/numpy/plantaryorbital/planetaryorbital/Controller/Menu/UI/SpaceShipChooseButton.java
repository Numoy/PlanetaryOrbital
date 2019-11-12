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

public class SpaceShipChooseButton extends UIElement implements View.OnClickListener {

    private Button spaceShipChooserButton;
    public SpaceShipListView spaceShipListView;



    public SpaceShipChooseButton(Context context)
    {
        super(context);
        page = 1;

        setButtonAttributes();
        setListView();

        viewElements.add(spaceShipChooserButton);

    }

    private void setButtonAttributes()
    {
        setSize((int)80, 80);
        setPosition(screenSize.getWidth() - 4 * width, (int) (screenSize.getHeight() * 0.3));

        spaceShipChooserButton = (Button) LayoutInflater.from(context).inflate(R.layout.spaceship_chooser_button,null);
        spaceShipChooserButton.setVisibility(View.GONE);
        spaceShipChooserButton.setLayoutParams(new FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        spaceShipChooserButton.setX(x);
        spaceShipChooserButton.setY(y);

        spaceShipChooserButton.setWidth(width);
        spaceShipChooserButton.setHeight(height);

        spaceShipChooserButton.setOnClickListener(this);

    }

    private void setListView()
    {
        spaceShipListView = new SpaceShipListView(context);
    }

    public void onClick(View v)
    {
        spaceShipListView.spaceShipListView.setVisibility(View.VISIBLE);
    }

}
