package com.example.dyslexiahelpinshona;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.abs;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class TouchListener implements View.OnTouchListener{
    private float xDelta;
    private float yDelta;
    private PuzzleActivity activity;

    public TouchListener(PuzzleActivity activity) {
        this.activity = activity;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        float x = event.getRawX();
        float y = event.getRawY();
        final double tolerance = sqrt(pow(v.getWidth(), 2) + pow(v.getHeight(), 2)) / 10;
        PuzzlePiece piece = (PuzzlePiece) v;
        if (!piece.canMove) {
            return true;
        }
        RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) v.getLayoutParams();
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                xDelta = x - lParams.leftMargin;
                yDelta = y - lParams.topMargin;
                piece.bringToFront();
                break;
            case MotionEvent.ACTION_MOVE:
                lParams.leftMargin = (int) (x - xDelta);
                lParams.topMargin = (int) (y - yDelta);
                v.setLayoutParams(lParams);
                break;
            case MotionEvent.ACTION_UP:
                int xDiff = abs(piece.xCoord - lParams.leftMargin);
                int yDiff = abs(piece.yCoord - lParams.topMargin);
                if (xDiff <= tolerance && yDiff <= tolerance) {
                    lParams.leftMargin = piece.xCoord;
                    lParams.topMargin = piece.yCoord;
                    piece.setLayoutParams(lParams);
                    piece.canMove = false;
                    sendViewToBack(piece);
                    activity.checkGameOver();
                }
                break;
        }

        return true;
    }
    public void sendViewToBack(final View child) {
        final ViewGroup parent = (ViewGroup)child.getParent();
        if (null != parent) {
            parent.removeView(child);
            parent.addView(child, 0);
        }
    }
}
