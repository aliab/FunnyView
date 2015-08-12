package info.abdolahi.transition;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class SmileFace extends View {

    private int faceStatus = 1;

    //vars
    Canvas mCanvas;
    Paint paint;
    int centerX;
    int centerY;
    int headRadius;


    public SmileFace(Context context) {
        super(context, null, 0);
    }


    public SmileFace(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public SmileFace(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mCanvas = canvas;

        int x = getWidth();
        int y = getHeight();

        centerX = x / 2;
        centerY = y / 2;

        headRadius = (x > y) ? ((41 * (y)) / 100) : ((41 * (x)) / 100);

        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        mCanvas.drawPaint(paint);

        paint.setColor(Color.GRAY);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);
        mCanvas.drawCircle(centerX, centerY, headRadius, paint);

        int eyesHeight = centerY - ((65 * (headRadius)) / 100);
        int leftEyeX = centerX - ((65 * (headRadius)) / 100);
        int rightEyeX = centerX + ((65 * (headRadius)) / 100);

        int eyesRadius = (47 * (headRadius)) / 100; //46%
        mCanvas.drawArc(leftEyeX, eyesHeight, leftEyeX + eyesRadius, eyesHeight + eyesRadius, 0, 180, false, paint);
        mCanvas.drawArc(rightEyeX - eyesRadius, eyesHeight, rightEyeX, eyesHeight + eyesRadius, 0, 180, false, paint);

        switch (faceStatus) {
            case 1:
                makeHimSmile();
                faceStatus++;
                break;
            case 2:
                makeHimSad();
                faceStatus++;
                break;
            case 3:
                makeHimPokerFace();
                faceStatus = 1;
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                this.invalidate();
                break;
        }

        return false;
    }

    private void makeHimSmile() {
        int lipsRadius = headRadius + ((20 * (headRadius)) / 100);
        int smileLipsLeft = centerX - ((70 * (headRadius)) / 100);
        int smileLipsRight = centerX + ((70 * (headRadius)) / 100);
        int lipsY = (centerY - ((45 * (headRadius)) / 100));
        mCanvas.drawArc(smileLipsLeft, lipsY, smileLipsRight, lipsY + lipsRadius, 0, 180, false, paint);
    }

    private void makeHimSad() {
        int lipsRadius = headRadius + ((20 * (headRadius)) / 100);
        int smileLipsLeft = centerX - ((65 * (headRadius)) / 100);
        int smileLipsRight = centerX + ((65 * (headRadius)) / 100);
        int lipsY = (centerY + ((14 * (headRadius)) / 100));
        mCanvas.drawArc(smileLipsLeft, lipsY, smileLipsRight, lipsY + lipsRadius, 0, -180, false, paint);
    }

    private void makeHimPokerFace() {
        int lipsLeft = centerX - ((45 * (headRadius)) / 100);
        int lipsRight = centerX + ((45 * (headRadius)) / 100);
        int lipsY = (centerY + ((35 * (headRadius)) / 100));
        mCanvas.drawLine(lipsLeft, lipsY, lipsRight, lipsY, paint);
    }

}
