package com.donny.killthemall;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by donny on 9/13/15.
 */
public class BarView {

    private int x;
    private int y;
    private int width;
    private int height;
    private Paint paint;
    private int score = 0;
    private int goodGuy = 0;
    private int badGuy = 0;
    private int time = 0;

    public BarView(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        paint = new Paint();
    }

    public void onDraw(Canvas canvas) {
        update();

        int alpha = 255/2;
        paint.setColor(Color.argb(alpha, 255, 255, 255));
        RectF rf = new RectF(x, y, width, height);
        canvas.drawRect(rf, paint);

        paint.setColor(Color.BLACK);
        paint.setTextSize(42);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(getTime(), width / 2, height - 42, paint);
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.drawText("ANGEL : " + goodGuy, 10, height - 42, paint);
        paint.setTextAlign(Paint.Align.RIGHT);
        canvas.drawText("EVIL : " + badGuy, width-10, height - 42, paint);
    }

    private void update() {
        time = ++time;
    }

    private String getTime() {
        int tm = Math.round(time / GameView.FPS);
        String tmMinute = "00";
        String tmSecond = "00";
        if (tm > 60) {
            int tmpMinute = Math.round(tm / 60);
            if (tmpMinute < 10) {
                tmMinute = "0" + tmpMinute;
            } else {
                tmMinute = tmpMinute + "";
            }

            int tmpSecond = tm % 60;
            if (tmpSecond < 10) {
                tmSecond = "0" + tmpSecond;
            } else {
                tmSecond = tmpSecond + "";
            }
        } else {
            if (tm < 10) {
                tmSecond = "0" + tm;
            } else {
                tmSecond = tm + "";
            }
        }
        return tmMinute +":"+ tmSecond;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getGoodGuy() {
        return goodGuy;
    }

    public void setGoodGuy(int goodGuy) {
        this.goodGuy = goodGuy;
    }

    public int getBadGuy() {
        return badGuy;
    }

    public void setBadGuy(int badGuy) {
        this.badGuy = badGuy;
    }

}
