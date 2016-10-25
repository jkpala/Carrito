package kit.area.jspp.mycarrito.main.ui.Icons;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntegerRes;
import android.util.Log;

import kit.area.jspp.mycarrito.R;

/**
 * Created by PEPE on 21/09/2016.
 */

public class CarritoDraw
    extends Drawable
{
    private float mTxtSize;
    private Paint mCarPaint,mTxtPaint;
    private Rect mTxtRect = new Rect();

    private String mCantida = "";
    private boolean mValiteDraw = false;

    public CarritoDraw(Context context)
    {
        mTxtSize = context.getResources().getDimension(R.dimen.car_text_size);

        mCarPaint = new Paint();
        mCarPaint.setColor(Color.RED);
        mCarPaint.setAntiAlias(true);
        mCarPaint.setStyle(Paint.Style.FILL);

        mTxtPaint = new Paint();
        mTxtPaint.setColor(Color.WHITE);
        mTxtPaint.setTypeface(Typeface.DEFAULT_BOLD);
        mTxtPaint.setTextSize(mTxtSize);
        mTxtPaint.setAntiAlias(true);
        mTxtPaint.setTextAlign(Paint.Align.CENTER);
    }
    @Override
    public void draw(Canvas canvas) {
        if(!mValiteDraw){
            return;
        }
        Rect mRect = getBounds();
        float width = mRect.right - mRect.left;
        float height = mRect.bottom - mRect.top;

        //posicion
        float radius = ((Math.min(width,height)/2)-1)/2;
        float centerX = width - radius - 1;
        float centerY = radius + 1;
        Log.d("radius:",String.valueOf(radius));
        Log.d("centerX:",String.valueOf(centerX));
        Log.d("centerY:",String.valueOf(centerY));

        //Creamos un circulo
        canvas.drawCircle(centerX,centerY,radius,mCarPaint);

        mTxtPaint.getTextBounds(mCantida,0,mCantida.length(),mTxtRect);

        float textHeight =  mTxtRect.bottom - mTxtRect.top;
        float textY = centerY + (textHeight/2f);
        canvas.drawText(mCantida,centerX,textY,mTxtPaint);
    }

    public void setCount(int count){
        mCantida = Integer.toString(count);

        mValiteDraw = count > 0;
        invalidateSelf();
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.UNKNOWN;
    }
}
