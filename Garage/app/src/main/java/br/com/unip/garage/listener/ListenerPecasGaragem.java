package br.com.unip.garage.listener;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import br.com.unip.garage.R;
import br.com.unip.garage.controller.LojaController;
import br.com.unip.garage.enumeration.NivelPeca;
import br.com.unip.garage.enumeration.TipoPeca;
import br.com.unip.garage.model.Peca;

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
    private LojaController lojaController;


    public ListenerPecasGaragem(AppCompatActivity activity) {
        this.activity = activity;
        this.botaoFreio = (ImageButton) activity.findViewById(R.id.garagem_freio);
        this.botaoPneu = (ImageButton) activity.findViewById(R.id.garagem_pneu);
        this.botaoMotor = (ImageButton) activity.findViewById(R.id.garagem_motor);
        this.botaoTurbo = (ImageButton) activity.findViewById(R.id.garagem_turbo);
        this.botaoPistao = (ImageButton) activity.findViewById(R.id.garagem_pistao);
        lojaController = new LojaController(activity);
    }

    @Override
    public void onClick(View v) {
        //FREIOS
        if (v.getId() == R.id.garagem_freio_amador) {
            botaoFreio.setBackgroundResource(R.drawable.garagem_freio_amador);
            Peca pecaAmadora = lojaController.getPecaAmadora(TipoPeca.FREIO);
            botaoFreio.setTag(pecaAmadora);
            alterarVisibilidade(activity.findViewById(R.id.garagem_frame_freio));
        } else if (v.getId() == R.id.garagem_freio_intermediario) {
            botaoFreio.setBackgroundResource(R.drawable.garagem_freio_intermediario);
            Peca pecaIntermediaria = lojaController.getPecaIntermediaria(TipoPeca.FREIO);
            botaoFreio.setTag(pecaIntermediaria);
            alterarVisibilidade(activity.findViewById(R.id.garagem_frame_freio));
        } else if (v.getId() == R.id.garagem_freio_profissional) {
            botaoFreio.setBackgroundResource(R.drawable.garagem_freio_profissional);
            Peca pecaProfissional = lojaController.getPecaProfissional(TipoPeca.FREIO);
            botaoFreio.setTag(pecaProfissional);
            alterarVisibilidade(activity.findViewById(R.id.garagem_frame_freio));
        }
        //PNEUS
        else if (v.getId() == R.id.garagem_pneu_amador) {
            botaoPneu.setBackgroundResource(R.drawable.garagem_pneu_amador);
            Peca pecaAmadora = lojaController.getPecaAmadora(TipoPeca.PNEU);
            botaoPneu.setTag(pecaAmadora);
            alterarVisibilidade(activity.findViewById(R.id.garagem_frame_pneu));
        } else if (v.getId() == R.id.garagem_pneu_intermediario) {
            botaoPneu.setBackgroundResource(R.drawable.garagem_pneu_intermediario);
            Peca pecaIntermediaria = lojaController.getPecaIntermediaria(TipoPeca.PNEU);
            botaoPneu.setTag(pecaIntermediaria);
            alterarVisibilidade(activity.findViewById(R.id.garagem_frame_pneu));
        } else if (v.getId() == R.id.garagem_pneu_profissional) {
            botaoPneu.setBackgroundResource(R.drawable.garagem_pneu_profissional);
            Peca pecaProfissional = lojaController.getPecaProfissional(TipoPeca.PNEU);
            botaoPneu.setTag(pecaProfissional);
            alterarVisibilidade(activity.findViewById(R.id.garagem_frame_pneu));
        }
        //MOTORES
        else if (v.getId() == R.id.garagem_motor_amador) {
            botaoMotor.setBackgroundResource(R.drawable.garagem_motor_amador);
            Peca pecaAmadora = lojaController.getPecaAmadora(TipoPeca.MOTOR);
            botaoMotor.setTag(pecaAmadora);
            alterarVisibilidade(activity.findViewById(R.id.garagem_frame_motor));
        } else if (v.getId() == R.id.garagem_motor_intermediario) {
            botaoMotor.setBackgroundResource(R.drawable.garagem_motor_intermediario);
            Peca pecaIntermediaria = lojaController.getPecaIntermediaria(TipoPeca.MOTOR);
            botaoMotor.setTag(pecaIntermediaria);
            alterarVisibilidade(activity.findViewById(R.id.garagem_frame_motor));
        } else if (v.getId() == R.id.garagem_motor_profissional) {
            botaoMotor.setBackgroundResource(R.drawable.garagem_motor_profissional);
            Peca pecaProfissional = lojaController.getPecaProfissional(TipoPeca.MOTOR);
            botaoMotor.setTag(pecaProfissional);
            alterarVisibilidade(activity.findViewById(R.id.garagem_frame_motor));
        }
        //PISTOES
        else if (v.getId() == R.id.garagem_pistao_amador) {
            botaoPistao.setBackgroundResource(R.drawable.garagem_pistao_amador);
            Peca pecaAmadora = lojaController.getPecaAmadora(TipoPeca.PISTAO);
            botaoPistao.setTag(pecaAmadora);
            alterarVisibilidade(activity.findViewById(R.id.garagem_frame_pistao));
        } else if (v.getId() == R.id.garagem_pistao_intermediario) {
            botaoPistao.setBackgroundResource(R.drawable.garagem_pistao_intermediario);
            Peca pecaIntermediaria = lojaController.getPecaIntermediaria(TipoPeca.PISTAO);
            botaoPistao.setTag(pecaIntermediaria);
            alterarVisibilidade(activity.findViewById(R.id.garagem_frame_pistao));
        } else if (v.getId() == R.id.garagem_pistao_profissional) {
            botaoPistao.setBackgroundResource(R.drawable.garagem_pistao_profissional);
            Peca pecaProfissional = lojaController.getPecaProfissional(TipoPeca.PISTAO);
            botaoPistao.setTag(pecaProfissional);
            alterarVisibilidade(activity.findViewById(R.id.garagem_frame_pistao));
        }
        //TURBO
        else if (v.getId() == R.id.garagem_turbo_amador) {
            botaoTurbo.setBackgroundResource(R.drawable.garagem_turbo_amador);
            Peca pecaAmadora = lojaController.getPecaAmadora(TipoPeca.TURBO);
            botaoTurbo.setTag(pecaAmadora);
            alterarVisibilidade(activity.findViewById(R.id.garagem_frame_turbo));
        } else if (v.getId() == R.id.garagem_turbo_intermediario) {
            botaoTurbo.setBackgroundResource(R.drawable.garagem_turbo_intermediario);
            Peca pecaIntermediaria = lojaController.getPecaIntermediaria(TipoPeca.TURBO);
            botaoTurbo.setTag(pecaIntermediaria);
            alterarVisibilidade(activity.findViewById(R.id.garagem_frame_turbo));
        } else if (v.getId() == R.id.garagem_turbo_profissional) {
            botaoTurbo.setBackgroundResource(R.drawable.garagem_turbo_profissional);
            Peca pecaProfissional = lojaController.getPecaProfissional(TipoPeca.TURBO);
            botaoTurbo.setTag(pecaProfissional);
            alterarVisibilidade(activity.findViewById(R.id.garagem_frame_turbo));
        }
        //BOTOES PRINCIPAIS
        else if (v.getId() == R.id.garagem_pneu) {
            alterarVisibilidade(activity.findViewById(R.id.garagem_frame_pneu));
            visibilidadePneu();
        } else if (v.getId() == R.id.garagem_pistao) {
            alterarVisibilidade(activity.findViewById(R.id.garagem_frame_pistao));
            visibilidadePistoes();
        } else if (v.getId() == R.id.garagem_motor) {
            alterarVisibilidade(activity.findViewById(R.id.garagem_frame_motor));
            visibilidadeMotor();
        } else if (v.getId() == R.id.garagem_turbo) {
            alterarVisibilidade(activity.findViewById(R.id.garagem_frame_turbo));
            visibilidadeTurbo();
        } else if (v.getId() == R.id.garagem_freio) {
            alterarVisibilidade(activity.findViewById(R.id.garagem_frame_freio));
            visibilidadeFreio();
        }
    }

    private void visibilidadePistoes() {
        if (!lojaController.getPecaAmadora(TipoPeca.PISTAO).getPossui()) {
            alterarVisibilidade(activity.findViewById(R.id.garagem_pistao_amador));
        }
        if (!lojaController.getPecaIntermediaria(TipoPeca.PISTAO).getPossui()) {
            alterarVisibilidade(activity.findViewById(R.id.garagem_pistao_intermediario));
        }
        if (!lojaController.getPecaProfissional(TipoPeca.PISTAO).getPossui()) {
            alterarVisibilidade(activity.findViewById(R.id.garagem_pistao_profissional));
        }
    }

    private void visibilidadeTurbo() {
        if (!lojaController.getPecaAmadora(TipoPeca.TURBO).getPossui()) {
            alterarVisibilidade(activity.findViewById(R.id.garagem_turbo_amador));
        }
        if (!lojaController.getPecaIntermediaria(TipoPeca.TURBO).getPossui()) {
            alterarVisibilidade(activity.findViewById(R.id.garagem_turbo_intermediario));
        }
        if (!lojaController.getPecaProfissional(TipoPeca.TURBO).getPossui()) {
            alterarVisibilidade(activity.findViewById(R.id.garagem_turbo_profissional));
        }
    }

    private void visibilidadeFreio() {
        if (!lojaController.getPecaAmadora(TipoPeca.FREIO).getPossui()) {
            alterarVisibilidade(activity.findViewById(R.id.garagem_freio_amador));
        }
        if (!lojaController.getPecaIntermediaria(TipoPeca.FREIO).getPossui()) {
            alterarVisibilidade(activity.findViewById(R.id.garagem_freio_intermediario));
        }
        if (!lojaController.getPecaProfissional(TipoPeca.FREIO).getPossui()) {
            alterarVisibilidade(activity.findViewById(R.id.garagem_freio_profissional));
        }
    }


    private void visibilidadeMotor() {
        if (!lojaController.getPecaAmadora(TipoPeca.MOTOR).getPossui()) {
            alterarVisibilidade(activity.findViewById(R.id.garagem_motor_amador));
        }
        if (!lojaController.getPecaIntermediaria(TipoPeca.MOTOR).getPossui()) {
            alterarVisibilidade(activity.findViewById(R.id.garagem_motor_intermediario));
        }
        if (!lojaController.getPecaProfissional(TipoPeca.MOTOR).getPossui()) {
            alterarVisibilidade(activity.findViewById(R.id.garagem_motor_profissional));
        }
    }


    private void visibilidadePneu() {
        if (!lojaController.getPecaAmadora(TipoPeca.PNEU).getPossui()) {
            alterarVisibilidade(activity.findViewById(R.id.garagem_pneu_amador));
        }
        if (!lojaController.getPecaIntermediaria(TipoPeca.PNEU).getPossui()) {
            alterarVisibilidade(activity.findViewById(R.id.garagem_pneu_intermediario));
        }
        if (!lojaController.getPecaProfissional(TipoPeca.PNEU).getPossui()) {
            alterarVisibilidade(activity.findViewById(R.id.garagem_pneu_profissional));
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
