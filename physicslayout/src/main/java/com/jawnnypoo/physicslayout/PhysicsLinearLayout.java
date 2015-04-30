package com.jawnnypoo.physicslayout;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Typical LinearLayout with some physics added on. Call getPhysicsHelper() to get the
 * physics component.
 * Created by Jawn on 4/9/2015.
 */
public class PhysicsLinearLayout extends LinearLayout {

    private Physics physics;

    public PhysicsLinearLayout(Context context) {
        super(context);
        init();
    }

    public PhysicsLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PhysicsLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(21)
    public PhysicsLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        setWillNotDraw(false);
        physics = new Physics(this);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        physics.onSizeChanged(w, h);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        physics.onLayout();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        physics.onDraw(canvas);
    }

    public Physics getPhysics() {
        return physics;
    }
}