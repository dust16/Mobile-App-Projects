package com.example.dustin.lab94_11798_dustin;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class Ball extends View {

    private final float FACTOR_BOUNCEBACK = 0.75f;
    private float mVx, mVy;
    private int mWidthScreen, mHeightScreen;
    private float x, y, radius;
    Paint paint;

    public Ball (Context context, float x, float y, float r, int mWidthScreen, int mHeightScreen)
    {
        super(context);
        this.x=x;
        this.y=y;
        this.radius=r;
        this.mWidthScreen=mWidthScreen;
        this.mHeightScreen=mHeightScreen;

        paint = new Paint();

        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);

    }

    public void move(float mAx, float mAy, float mDeltaT) {

        mVx -= mAx * mDeltaT;
        mVy += mAy * mDeltaT;

        x += (int)(mDeltaT * (mVx + 0.5 * mAx * mDeltaT));
        y += (int)(mDeltaT * (mVy + 0.5 * mAy * mDeltaT));

        if(x < radius/4)
        {
            x = radius/4;
            mVx = -mVx * FACTOR_BOUNCEBACK;
        }

        if(y < radius/4) {
            y = radius/4;
            mVy = -mVy * FACTOR_BOUNCEBACK;  }


        if(x > mWidthScreen - radius/4)
        {
            x= mWidthScreen - radius/4;
            mVx = -mVx * FACTOR_BOUNCEBACK;
        }

        if(y > mHeightScreen - 18 * radius/4)
        {
            y = mHeightScreen - 18 * radius/4;
            mVy = -mVy * FACTOR_BOUNCEBACK;
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(x, y, 50, paint);
        canvas.drawText("Koordinat X : "+x, 500, 500, paint);
        canvas.drawText("Koordinat Y : "+y, 500, 550, paint);
    }
}
