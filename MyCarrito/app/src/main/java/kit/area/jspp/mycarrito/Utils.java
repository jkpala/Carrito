package kit.area.jspp.mycarrito;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

import kit.area.jspp.mycarrito.main.ui.Icons.CarritoDraw;

/**
 * Created by PEPE on 21/09/2016.
 */

public class Utils {
    public static void setCarritoCantidad(Context context,
                                          LayerDrawable icon,
                                          int count){
        CarritoDraw mCarritoDraw;

        Drawable mDrawable = icon.findDrawableByLayerId(R.id.action_shopping);

        if (mDrawable != null && mDrawable instanceof CarritoDraw) {
            mCarritoDraw = (CarritoDraw) mDrawable;
        } else {
            mCarritoDraw = new CarritoDraw(context);
        }

        mCarritoDraw.setCount(count);
        icon.mutate();
        icon.setDrawableByLayerId(R.id.ic_badge, mCarritoDraw);
    }
}
