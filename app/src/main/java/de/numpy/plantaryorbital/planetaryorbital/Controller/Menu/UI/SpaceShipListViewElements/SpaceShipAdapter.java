package de.numpy.plantaryorbital.planetaryorbital.Controller.Menu.UI.SpaceShipListViewElements;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import de.numpy.plantaryorbital.planetaryorbital.R;

/**
 * Created by Marvin on 29.11.2017.
 */

public class SpaceShipAdapter extends BaseAdapter implements View.OnClickListener {

    private ArrayList<SpaceShipItem> spaceShips;
    private static LayoutInflater inflater  = null;
    Context context;

    public SpaceShipAdapter(ArrayList<SpaceShipItem> spaceShips, Context context)
    {
        this.context = context;
        this.spaceShips = spaceShips;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public Button addHeader(ListView listView)
    {
        ViewGroup header = (ViewGroup)inflater.inflate(R.layout.spaceship_listview_header,listView,false);
        Button cancel =(Button) header.findViewById(R.id.cancelButton);
        listView.addHeaderView(header);
        return  cancel;
    }

    @Override
    public void onClick(View v) {
        v.getId();
    }

    @Override
    public int getCount() {
        return spaceShips.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View view = convertView;
        if(convertView == null)
        {
            view = inflater.inflate(R.layout.spaceship_listview_item, null);
        }
        ImageView spaceShip = (ImageView) view.findViewById(R.id.spaceShipImage);
        TextView spaceShipLabel = (TextView) view.findViewById(R.id.textViewRow);

        spaceShip.setImageResource(setSpaceShipImage(position));
        spaceShipLabel.setText(setSpaceShipText(position));

        return view;
    }

    private int setSpaceShipImage(int position)
    {
        SpaceShipItem spaceShipItem = spaceShips.get(position);
        if(spaceShipItem.isUnlocked)
        {
            return spaceShipItem.spaceShipResourceID;
        }
        return spaceShipItem.spaceShipShadowID;
    }

    private String setSpaceShipText(int position)
    {
        SpaceShipItem spaceShipItem = spaceShips.get(position);
        if(spaceShipItem.isUnlocked)
        {
            return spaceShipItem.name;
        }
        return String.valueOf(spaceShipItem.price) + " S$";
    }

}
