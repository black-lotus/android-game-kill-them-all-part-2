package com.donny.killthemall;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by donny on 9/16/15.
 */
public class GameOverView {

    private int screenWidth;
    private int screenHeight;

    private Paint paint;
    private int score = 0;

    public GameOverView(int screenWidth, int screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;

        paint = new Paint();
    }

    public void onDraw(Canvas canvas) {
        paint.setColor(Color.WHITE);
        paint.setTextSize(52);
        paint.setTextAlign(Paint.Align.CENTER);
        if (score == 0) {
            canvas.drawText("TOO BAD", screenWidth/2, (screenHeight/2) - (52/2), paint);
        } else if (score > 0 && score <= 50) {
            canvas.drawText("NOT BAD", screenWidth/2, (screenHeight/2) - (52/2), paint);
        } else if (score > 50 && score <= 70) {
            canvas.drawText("PRETTY GOD", screenWidth/2, (screenHeight/2) - (52/2), paint);
        } else if (score > 70 && score <= 80) {
            canvas.drawText("GREAT", screenWidth/2, (screenHeight/2) - (52/2), paint);
        } else if (score > 80 && score <= 99) {
            canvas.drawText("EXCELENT", screenWidth/2, (screenHeight/2) - (52/2), paint);
        } else {
            canvas.drawText("AMAZING", screenWidth/2, (screenHeight/2) - (52/2), paint);
        }
        canvas.drawText(score +"", screenWidth/2, (screenHeight/2) + (52/2), paint);

        paint.setTextSize(28);
        canvas.drawText("Tap anywhere to restart", screenWidth/2, screenHeight - 100, paint);
    }

    public void setScore(int goodGuy, int badGuy, int numberOfGuy) {
        // if (score == 0) {
            int num = (numberOfGuy * 2) - (numberOfGuy - goodGuy) - (numberOfGuy - badGuy);
            this.score = (num * 100) / numberOfGuy;
        // }
    }

}
