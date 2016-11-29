package br.com.unip.garage.interpolator;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

import br.com.unip.garage.model.Carro;

/**
 * Created by caique on 29/11/16.
 */

public class CustomInterpolator implements Interpolator {

    private float metadeDoTempo;
    private AccelerateInterpolator accelerateInterpolator;
    private DecelerateInterpolator decelerateInterpolator;

    public CustomInterpolator(Carro carro) {
        //TODO: Rever calculo
        accelerateInterpolator = new AccelerateInterpolator(carro.getVelocidade());
        decelerateInterpolator = new DecelerateInterpolator(carro.getFreio().getFrenagem());
        this.metadeDoTempo = metadeDoTempo;
    }

    @Override
    public float getInterpolation(float tempo) {
        if (tempo < metadeDoTempo) {
            return accelerateInterpolator.getInterpolation(tempo);
        } else {
            return decelerateInterpolator.getInterpolation(tempo);
        }
    }
}
