package com.astrotalk.blinklibrary;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.view.View;
import android.view.animation.Animation;
import android.animation.ArgbEvaluator;

public class BlinkEffect {

    public static void blink(View view) {
        // adding the color to be shown

        ObjectAnimator animator = ObjectAnimator.ofInt(
                view, "backgroundColor", Color.YELLOW,
                Color.RED, Color.GREEN
        );
        // duration of one color
        animator.setDuration(500);
//        animator.setEvaluator(ArgbEvaluator());
        // color will be shown in reverse manner
        animator.setRepeatCount(Animation.REVERSE);
        // Repeat up to infinite time
        animator.setRepeatCount(Animation.INFINITE);
        animator.start();
    }

}
