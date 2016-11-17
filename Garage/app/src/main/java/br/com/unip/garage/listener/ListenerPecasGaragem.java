package br.com.unip.garage.listener;

import android.databinding.BaseObservable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import br.com.unip.garage.R;

/**
 * Created by caique on 15/11/16.
 */

public class ListenerPecasGaragem implements View.OnClickListener {

    private AppCompatActivity activity;
    private ImageButton botaoFreio;
    private ImageButton botaoPneu;
    private ImageButton botaoMotor;
    private ImageButton botaoTurbina;
    private ImageButton botaoPistao;

    public ListenerPecasGaragem(AppCompatActivity activity) {
        this.activity = activity;
        this.botaoFreio = (ImageButton) activity.findViewById(R.id.garagem_freio);
        this.botaoPneu = (ImageButton) activity.findViewById(R.id.garagem_pneu);
        this.botaoMotor = (ImageButton) activity.findViewById(R.id.garagem_motor);
        this.botaoTurbina = (ImageButton) activity.findViewById(R.id.garagem_turbo);
        this.botaoPistao = (ImageButton) activity.findViewById(R.id.garagem_pistao);
    }

    @Override
    public void onClick(View v) {
        //FREIOS
        if (v.getId() == R.id.garagem_freio_amador) {
            botaoFreio.setBackgroundResource(R.drawable.garagem_freio_amador);
        } else if (v.getId() == R.id.garagem_freio_intermediario) {
            botaoFreio.setBackgroundResource(R.drawable.garagem_freio_intermediario);
        } else if (v.getId() == R.id.garagem_freio_profissional) {
            botaoFreio.setBackgroundResource(R.drawable.garagem_freio_profissional);
        }
        //PNEUS
        else if (v.getId() == R.id.garagem_pneu_amador) {
            ImageButton botao = (ImageButton) v;
            Drawable background = botao.getBackground();
            botaoPneu.setImageResource(R.drawable.pneu_basic);
        } else if (v.getId() == R.id.garagem_pneu_intermediario) {
            Drawable background = v.getBackground();
            botaoPneu.setImageDrawable(background);
        } else if (v.getId() == R.id.garagem_pneu_profissional) {
            Drawable background = v.getBackground();
            botaoPneu.setImageDrawable(background);
        }
        //MOTORES
        else if (v.getId() == R.id.garagem_motor_amador) {
            Drawable background = v.getBackground();
            botaoMotor.setImageDrawable(background);
        } else if (v.getId() == R.id.garagem_motor_intermediario) {
            Drawable background = v.getBackground();
            botaoMotor.setImageDrawable(background);
        } else if (v.getId() == R.id.garagem_motor_profissional) {
            Drawable background = v.getBackground();
            botaoMotor.setImageDrawable(background);
        }
        //PISTOES
        else if (v.getId() == R.id.garagem_pistao_amador) {
            Drawable background = v.getBackground();
            botaoPneu.setImageDrawable(background);
        } else if (v.getId() == R.id.garagem_pneu_intermediario) {
            Drawable background = v.getBackground();
            botaoPneu.setImageDrawable(background);
        } else if (v.getId() == R.id.garagem_pneu_profissional) {
            Drawable background = v.getBackground();
            botaoPneu.setImageDrawable(background);
        }
        //TURBINA
        else if (v.getId() == R.id.garagem_turbo_amador) {
            Drawable background = v.getBackground();
            botaoTurbina.setImageDrawable(background);
        } else if (v.getId() == R.id.garagem_turbo_intermediario) {
            Drawable background = v.getBackground();
            botaoTurbina.setImageDrawable(background);
        } else if (v.getId() == R.id.garagem_turbo_profissional) {
            Drawable background = v.getBackground();
            botaoTurbina.setImageDrawable(background);
        }
    }
}
