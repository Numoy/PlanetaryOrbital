package de.numpy.plantaryorbital.planetaryorbital.Controller.Menu.UI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.ArrayList;

import de.numpy.plantaryorbital.planetaryorbital.Controller.Menu.UI.SpaceShipListViewElements.SpaceShipAdapter;
import de.numpy.plantaryorbital.planetaryorbital.Controller.Menu.UI.SpaceShipListViewElements.SpaceShipItem;
import de.numpy.plantaryorbital.planetaryorbital.Controller.Store.SavedSettings;
import de.numpy.plantaryorbital.planetaryorbital.Controller.Store.SpaceShipListSave;
import de.numpy.plantaryorbital.planetaryorbital.R;

/**
 * Created by Marvin on 29.11.2017.
 */

public class SpaceShipListView extends UIElement implements AdapterView.OnItemClickListener, View.OnClickListener {

    public ListView spaceShipListView;
    ArrayList<SpaceShipItem> spaceShipItems;
    SpaceShipAdapter adapter;

    Button cancle;



    public SpaceShipListView(Context context) {
        super(context);
        page = 2;
        spaceShipListView = (ListView) LayoutInflater.from(context).inflate(R.layout.spaceship_listview, null);

        setListView();
        setList();

        spaceShipListView.setVisibility(View.GONE);
        viewElements.add(spaceShipListView);

    }

    private void setListView()
    {

        setSize((int) (screenSize.getWidth() * 0.3),(int) (screenSize.getHeight() * 0.9));
        setPosition(screenSize.getWidth()  - width , (int) (screenSize.getHeight() * 0.1) / 2);
        spaceShipListView.setLayoutParams(new FrameLayout.LayoutParams(
            width,
            height
        ));

        spaceShipListView.setX(x);
        spaceShipListView.setY(y);
    }

    public void setList()
    {


        spaceShipItems = new ArrayList<>();

        for(SpaceShipItem spaceShipItem : SpaceShipListSave.spaceshipList)
        {
            spaceShipItems.add(spaceShipItem);
        }


        adapter = new SpaceShipAdapter(spaceShipItems,context);
        cancle = adapter.addHeader(spaceShipListView);
        cancle.setOnClickListener(this);

        spaceShipListView.setAdapter(adapter);

        spaceShipListView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
       //ImageView shipImage = (ImageView) view.findViewById(R.id.spaceShipImage);
       //ImageView energyImage = (ImageView) view.findViewById(R.id.imageEnergy);
        SpaceShipItem spaceShipItem = spaceShipItems.get((int) id);
        if(!spaceShipItem.isUnlocked)
        {
            if(SavedSettings.getMoney() - spaceShipItem.price > 0)
            {
                spaceShipItems.get((int) id).isUnlocked = true;
                SavedSettings.saveSpaceShipList(spaceShipItems);
                SavedSettings.setMoney((int) (SavedSettings.getMoney() - spaceShipItem.price));
            }
            else
            {

            }
        }
        else
        {
            SavedSettings.setRocketImageResource(spaceShipItem.getSpaceShipResourceID());
            SavedSettings.setEnergyImageResource(spaceShipItem.getSpaceShipEnergyResourceID());
            makeInvisible();
        }
        adapter.notifyDataSetChanged();


    }

    @Override
    public void onClick(View v) {
        makeInvisible();
    }
}
