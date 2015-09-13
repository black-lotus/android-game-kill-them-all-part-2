package com.donny.killthemall;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

/**
 * Created by donny on 9/13/15.
 */
public class SpaceDust {

    private int x;
    private int y;

    private int maxWidth;
    private int maxHeight;

    private Paint paint;

    public SpaceDust(int maxWidth, int maxHeight) {
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;

        Random rnd = new Random();
        x = rnd.nextInt(this.maxWidth);
        y = rnd.nextInt(this.maxHeight);

        paint = new Paint();
    }

    public void onDraw(Canvas canvas) {
        // White specs of dust
        paint.setColor(Color.argb(255, 255, 255, 255));
        paint.setStrokeWidth(3);
        canvas.drawPoint(x, y, paint);
    }


}
