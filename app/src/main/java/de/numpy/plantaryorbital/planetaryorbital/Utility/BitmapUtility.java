package de.numpy.plantaryorbital.planetaryorbital.Utility;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;

import de.numpy.plantaryorbital.planetaryorbital.main.MainActivity;
import de.numpy.plantaryorbital.planetaryorbital.Model.Position;
import de.numpy.plantaryorbital.planetaryorbital.rocket.Rocket;

/**
 * Created by Marvin on 18.10.2017.
 */

public abstract class BitmapUtility {

    public static Bitmap getBitmapFromVectorDrawable(Context context, int drawableId) {
        Drawable drawable = ContextCompat.getDrawable(context, drawableId);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            drawable = (DrawableCompat.wrap(drawable)).mutate();
        }
        float shipHeightNew = MainActivity.getScreenSize().getHeight() * Rocket.PART_OF_SCREEN;
        double drawableRatio = (float)drawable.getIntrinsicWidth() / (float)drawable.getIntrinsicHeight();
        float shipWidthNew = (float) (shipHeightNew * drawableRatio);


        Bitmap bitmap = Bitmap.createBitmap((int)shipWidthNew,
                (int)shipHeightNew, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }
    
    public static Bitmap get8BitBitmapFromVectorDrawable(Context context, int drawableId) {
        int pixelWidth = 17;
        Drawable drawable = ContextCompat.getDrawable(context, drawableId);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            drawable = (DrawableCompat.wrap(drawable)).mutate();
        }
        float shipHeightNew = MainActivity.getScreenSize().getHeight() * Rocket.PART_OF_SCREEN;
        double drawableRatio = (float)drawable.getIntrinsicWidth() / (float)drawable.getIntrinsicHeight();
        float shipWidthNew = (float) (shipHeightNew * drawableRatio);
        
        
        Bitmap bitmap = Bitmap.createBitmap(pixelWidth,
            (int) (pixelWidth * drawableRatio), Bitmap.Config.ARGB_8888);
        
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        
        return getResizedBitmap( bitmap, (int) shipWidthNew, (int) shipHeightNew );
    }
    
    public static Bitmap getBitmapFromDrawable(Context context, int drawableId, int xSize, int ySize) {
        Drawable drawable = ContextCompat.getDrawable(context, drawableId);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            drawable = (DrawableCompat.wrap(drawable)).mutate();
        }
        
        Bitmap bitmap = Bitmap.createBitmap(
            xSize,
            ySize,
            Bitmap.Config.ARGB_4444 );
        
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }

    public static Bitmap getResizedBitmap(Bitmap source, int newWidth, int newHeight) {
        int width = source.getWidth();
        int height = source.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // Matrix for Manipulation
        Matrix matrix = new Matrix();
        // Resize Bitmap
        matrix.postScale(scaleWidth, scaleHeight);
        // Recreate new Bitmap
        Bitmap resizedBitmap = Bitmap.createBitmap(
                source, 0, 0, width, height, matrix, false);
        source.recycle();
        return resizedBitmap;
    }

    public static Matrix getTransformationMatrix(Rocket rocket,Position offset )
    {
        Matrix transformation = new Matrix();
        //Move Bitmap to right Position
        transformation.setTranslate(
            (float) ( rocket.position.x - offset.x - rocket.width / 2 ),
            (float) (rocket.position.y - offset.y - rocket.height / 2 ) );
        //Rotate for facing
        transformation.postRotate(
            (float) Math.toDegrees(rocket.facing),
            (float) (rocket.position.x - offset.x ),
            (float) (rocket.position.y - offset.y ));
        return transformation;
    }
}