package br.com.unip.garage.corrida;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.Path;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;

import java.io.Serializable;

import br.com.unip.garage.listener.AnimatorListenerMapas;

/**
 * Created by caique on 29/11/16.
 */

public class PercursoUm implements Runnable, Serializable {

    private AnimatorListenerMapas listenerSecao1 = new AnimatorListenerMapas();
    private AnimatorListenerMapas listenerSecao2 = new AnimatorListenerMapas();
    private ValueAnimator primeiraSecao;
    private ValueAnimator segundaSecao;
    private ImageView imageView;
    private float density;
    private Integer tempoSecao = null;


    public PercursoUm(float density, ImageView imageView) {
        this.density = density;
        this.imageView = imageView;
        tempoSecao = 5000;
        this.primeiraSecao = primeiraSecao(imageView);
        this.primeiraSecao.addListener(listenerSecao1);
        this.segundaSecao = segundaSecao(imageView);
        this.segundaSecao.addListener(listenerSecao2);
    }

    private ValueAnimator segundaSecao(ImageView imageView) {
        Path path = new Path();
        path.moveTo(toDps(120), toDps(40));
        path.lineTo(toDps(105), toDps(150));
        return addAnimator(path, imageView);
    }


    private ValueAnimator primeiraSecao(ImageView imageView) {
        Path path = new Path();
        path.moveTo(imageView.getTranslationX(), imageView.getTranslationY());
        path.lineTo(toDps(120), toDps(40));
        return addAnimator(path, imageView);
    }

    @SuppressLint("NewApi")
    private ValueAnimator addAnimator(Path path, ImageView imageView) {
        ValueAnimator animator = ObjectAnimator.ofFloat(imageView, "x", "y", path);
        animator.setDuration(tempoSecao);
        animator.setInterpolator(new AccelerateInterpolator(2f));
        return animator;
    }

    @Override
    public void run() {
        synchronized (this) {
            if (!primeiraSecao.isStarted() && !listenerSecao1.isEnd()) {
                primeiraSecao.start();
            } else if (!segundaSecao.isStarted() && !listenerSecao2.isEnd()) {
                segundaSecao.start();
            }
        }
    }


    private Integer toDps(int position) {
        return (int) (position * density);
    }

}
