package com.povilas.sid.ktu.views;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class DropDownAnimation extends Animation {
    int targetHeight;
    int startHeight;
    View view;
    boolean down;

    public DropDownAnimation(View view, int targetHeight, boolean down) {
        this.view = view;
        this.targetHeight = targetHeight;
        this.down = down;
        startHeight = view.getHeight();
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        int newHeight;
        
        if (down) {
        	newHeight = (int) (((targetHeight-startHeight) * interpolatedTime) + startHeight);
        } else {
        	newHeight = (int) (((targetHeight-startHeight)* (1 - interpolatedTime)) + startHeight);
        }
        
        view.getLayoutParams().height = newHeight;
        view.requestLayout();
    }

    @Override
    public void initialize(int width, int height, int parentWidth,
            int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
    }

    @Override
    public boolean willChangeBounds() {
        return true;
    }
}
