package br.com.unip.garage.listener;

import android.animation.Animator;

/**
 * Created by caique on 30/11/16.
 */

public class AnimatorListenerMapas implements Animator.AnimatorListener {

    private boolean end = false;


    @Override
    public void onAnimationStart(Animator animation) {

    }

    @Override
    public void onAnimationEnd(Animator animation) {
        end = true;
    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }

    public boolean isEnd() {
        return end;
    }
}
