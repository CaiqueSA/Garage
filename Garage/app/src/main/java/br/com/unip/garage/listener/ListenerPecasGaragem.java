package br.com.unip.garage.listener;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
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
    private ImageButton botaoTurbo;
    private ImageButton botaoPistao;

    public ListenerPecasGaragem(AppCompatActivity activity) {
        this.activity = activity;
        this.botaoFreio = (ImageButton) activity.findViewById(R.id.garagem_freio);
        this.botaoPneu = (ImageButton) activity.findViewById(R.id.garagem_pneu);
        this.botaoMotor = (ImageButton) activity.findViewById(R.id.garagem_motor);
        this.botaoTurbo = (ImageButton) activity.findViewById(R.id.garagem_turbo);
        this.botaoPistao = (ImageButton) activity.findViewById(R.id.garagem_pistao);
    }

    @Override
    public void onClick(View v) {
        //FREIOS
        if (v.getId() == R.id.garagem_freio_amador) {
            botaoFreio.setBackgroundResource(R.drawable.garagem_freio_amador);
            alterarVisibilidade(activity.findViewById(R.id.garagem_frame_freio));
        } else if (v.getId() == R.id.garagem_freio_intermediario) {
            botaoFreio.setBackgroundResource(R.drawable.garagem_freio_intermediario);
            alterarVisibilidade(activity.findViewById(R.id.garagem_frame_freio));
        } else if (v.getId() == R.id.garagem_freio_profissional) {
            botaoFreio.setBackgroundResource(R.drawable.garagem_freio_profissional);
            alterarVisibilidade(activity.findViewById(R.id.garagem_frame_freio));
        }
        //PNEUS
        else if (v.getId() == R.id.garagem_pneu_amador) {
            botaoPneu.setBackgroundResource(R.drawable.garagem_pneu_amador);
            alterarVisibilidade(activity.findViewById(R.id.garagem_frame_pneu));
        } else if (v.getId() == R.id.garagem_pneu_intermediario) {
            botaoPneu.setBackgroundResource(R.drawable.garagem_pneu_intermediario);
            alterarVisibilidade(activity.findViewById(R.id.garagem_frame_pneu));
        } else if (v.getId() == R.id.garagem_pneu_profissional) {
            botaoPneu.setBackgroundResource(R.drawable.garagem_pneu_profissional);
            alterarVisibilidade(activity.findViewById(R.id.garagem_frame_pneu));
        }
        //MOTORES
        else if (v.getId() == R.id.garagem_motor_amador) {
            botaoMotor.setBackgroundResource(R.drawable.garagem_motor_amador);
            alterarVisibilidade(activity.findViewById(R.id.garagem_frame_motor));
        } else if (v.getId() == R.id.garagem_motor_intermediario) {
            botaoMotor.setBackgroundResource(R.drawable.garagem_motor_intermediario);
            alterarVisibilidade(activity.findViewById(R.id.garagem_frame_motor));
        } else if (v.getId() == R.id.garagem_motor_profissional) {
            botaoMotor.setBackgroundResource(R.drawable.garagem_motor_profissional);
            alterarVisibilidade(activity.findViewById(R.id.garagem_frame_motor));
        }
        //PISTOES
        else if (v.getId() == R.id.garagem_pistao_amador) {
            botaoPistao.setBackgroundResource(R.drawable.garagem_pistao_amador);
            alterarVisibilidade(activity.findViewById(R.id.garagem_frame_pistao));
        } else if (v.getId() == R.id.garagem_pistao_intermediario) {
            botaoPistao.setBackgroundResource(R.drawable.garagem_pistao_intermediario);
            alterarVisibilidade(activity.findViewById(R.id.garagem_frame_pistao));
        } else if (v.getId() == R.id.garagem_pistao_profissional) {
            botaoPistao.setBackgroundResource(R.drawable.garagem_pistao_profissional);
            alterarVisibilidade(activity.findViewById(R.id.garagem_frame_pistao));
        }
        //TURBO
        else if (v.getId() == R.id.garagem_turbo_amador) {
            botaoTurbo.setBackgroundResource(R.drawable.garagem_turbo_amador);
            alterarVisibilidade(activity.findViewById(R.id.garagem_frame_turbo));
        } else if (v.getId() == R.id.garagem_turbo_intermediario) {
            botaoTurbo.setBackgroundResource(R.drawable.garagem_turbo_intermediario);
            alterarVisibilidade(activity.findViewById(R.id.garagem_frame_turbo));
        } else if (v.getId() == R.id.garagem_turbo_profissional) {
            botaoTurbo.setBackgroundResource(R.drawable.garagem_turbo_profissional);
            alterarVisibilidade(activity.findViewById(R.id.garagem_frame_turbo));
        }
    }

    private void alterarVisibilidade(View view) {
        if (view.getVisibility() == View.GONE) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
        }
    }
}
