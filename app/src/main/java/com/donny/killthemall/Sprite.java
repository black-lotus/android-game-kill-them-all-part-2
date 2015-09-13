package com.donny.killthemall;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import java.util.Random;

/**
 * Created by donny on 9/12/15.
 */
public class Sprite {

    private static final int BMP_ROWS = 4;
    private static final int BMP_COLUMNS = 3;
    private int x;
    private int y;
    private int xSpeed;
    private int ySpeed;
    private GameView gameView;
    private Bitmap bmp;
    private int currentFrame = 0;
    private int width;
    private int height;
    private boolean isGoodGuy = false;

    // direction = 0 up, 1 left, 2 down, 3 right,
    // animation = 3 up, 1 left, 0 down, 2 right
    int[] DIRECTION_TO_ANIMATION_MAP = { 3, 1, 0, 2 };

    public Sprite(GameView gameView, Bitmap bmp, boolean isGoodGuy) {
        this.gameView = gameView;
        this.bmp = bmp;
        this.width = bmp.getWidth() / BMP_COLUMNS;
        this.height = bmp.getHeight() / BMP_ROWS;

        Random rnd = new Random();
        // create random speed
        xSpeed = rnd.nextInt(10)-5;
        ySpeed = rnd.nextInt(10)-5;

        // create random position
        x = rnd.nextInt(gameView.getWidth() - width);
        y = rnd.nextInt(gameView.getHeight() - height - gameView.BAR_HEIGHT) + gameView.BAR_HEIGHT;

        this.isGoodGuy = isGoodGuy;
    }

    private int getAnimationRow() {
        double math = Math.atan2(xSpeed, ySpeed);
        System.out.println("1. math ("+ xSpeed +", "+ ySpeed +") => " + math);
        double pi = Math.PI / 2;
        System.out.println("2. pi => " + pi);
        double dirDouble = (math / pi + 2);
        System.out.println("3. dirDouble => " + dirDouble);
        int direction = (int) Math.round(dirDouble) % BMP_ROWS;
        System.out.println("4. direction => " + direction);
        return DIRECTION_TO_ANIMATION_MAP[direction];
    }

    private void update() {
        if (x > gameView.getWidth() - width - xSpeed || x + xSpeed < 0) {
            xSpeed = -xSpeed;
        }
        x = x + xSpeed;

        if (y > gameView.getHeight() - height - ySpeed || y + ySpeed < gameView.BAR_HEIGHT) {
            ySpeed = -ySpeed;
        }
        y = y + ySpeed;

        // System.out.println("1. cf => " + currentFrame);
        currentFrame = ++currentFrame;
        // System.out.println("2. cf => " + currentFrame);
        currentFrame = currentFrame % BMP_COLUMNS;
        // System.out.println("3. cf => " + currentFrame);
    }

    public void onDraw(Canvas canvas) {
        update();
        int srcX = currentFrame * width;
        int animationRow = getAnimationRow();
        int srcY = animationRow * height;
        System.out.println("5. srcY ("+ animationRow +", "+ height +") => " + srcY);
        Rect src = new Rect(srcX, srcY, srcX + width, srcY + height);
        Rect dst = new Rect(x, y, x + width, y + height);
        canvas.drawBitmap(bmp, src, dst, null);
    }

    public boolean isCollition(float x2, float y2) {
        System.out.println("("+ x2 +" > "+ x +") && ("+ x2 +" < "+ (x + width) +") && ("+ y2 +" > "+ y +") && ("+ y2 +" < "+ (y + height) +")");
        boolean res = (x2 > x) && (x2 < x + width) && (y2 > y) && (y2 < y + height);
        System.out.println("res => " + res);
        return res;
    }

    public boolean isGoodGuy() {
        return this.isGoodGuy;
    }
}
