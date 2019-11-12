package de.numpy.plantaryorbital.planetaryorbital.stars;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Size;

import de.numpy.plantaryorbital.planetaryorbital.main.MainActivity;
import de.numpy.plantaryorbital.planetaryorbital.R;
import de.numpy.plantaryorbital.planetaryorbital.Utility.BitmapUtility;

/**
 * Created by Marvin on 21.10.2017.
 */

public class Background
{
  private Bitmap background;
  
  public Background( Context context )
  {
    loadSizedBitmapsFromDrawables( context );
  }
  
  private void loadSizedBitmapsFromDrawables( Context context )
  {
    Size screenSize = MainActivity.getScreenSize();
    background = BitmapUtility.getBitmapFromDrawable(context,R.drawable.back_layer,screenSize.getWidth(),screenSize.getHeight());
  }

  
  public Bitmap getBack()
  {
    return background;
  }
}
