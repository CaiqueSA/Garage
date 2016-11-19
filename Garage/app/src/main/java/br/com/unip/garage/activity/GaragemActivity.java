package br.com.unip.garage.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import br.com.unip.garage.R;
import br.com.unip.garage.controller.GaragemController;
import br.com.unip.garage.dados.FreioDAO;
import br.com.unip.garage.listener.ListenerCarrosGaragem;
import br.com.unip.garage.listener.ListenerPecasGaragem;
import br.com.unip.garage.model.Freio;

public class GaragemActivity extends AppCompatActivity implements View.OnClickListener {

    private GaragemController garagemController = new GaragemController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_garagem);

        setListenerPecas();
        setListenerCarro();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.garagem_home) {
            Intent startHome = new Intent(GaragemActivity.this, MainActivity.class);
            startActivity(startHome);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }else if (v.getId() == R.id.garagem_mapas){
            Intent startMapas = new Intent(GaragemActivity.this, MapaActivity.class);
            startActivity(startMapas);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
        else if (v.getId() == R.id.garagem_pneu) {
            alterarVisibilidade(findViewById(R.id.garagem_frame_pneu));
        } else if (v.getId() == R.id.garagem_pistao) {
            alterarVisibilidade(findViewById(R.id.garagem_frame_pistao));
        } else if (v.getId() == R.id.garagem_motor) {
            alterarVisibilidade(findViewById(R.id.garagem_frame_motor));
        } else if (v.getId() == R.id.garagem_turbo) {
            alterarVisibilidade(findViewById(R.id.garagem_frame_turbo));
        } else if (v.getId() == R.id.garagem_freio) {
            alterarVisibilidade(findViewById(R.id.garagem_frame_freio));
        }
    }


    private void alterarVisibilidade(View view) {
        if (view.getVisibility() == View.GONE) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
        }
    }

    private void setListenerPecas() {
        ListenerPecasGaragem listenerPecas = new ListenerPecasGaragem(this);
        findViewById(R.id.garagem_pneu_amador).setOnClickListener(listenerPecas);
        findViewById(R.id.garagem_pneu_intermediario).setOnClickListener(listenerPecas);
        findViewById(R.id.garagem_pneu_profissional).setOnClickListener(listenerPecas);

        findViewById(R.id.garagem_freio_amador).setOnClickListener(listenerPecas);
        findViewById(R.id.garagem_freio_intermediario).setOnClickListener(listenerPecas);
        findViewById(R.id.garagem_freio_profissional).setOnClickListener(listenerPecas);

        findViewById(R.id.garagem_motor_amador).setOnClickListener(listenerPecas);
        findViewById(R.id.garagem_motor_intermediario).setOnClickListener(listenerPecas);
        findViewById(R.id.garagem_motor_profissional).setOnClickListener(listenerPecas);

        findViewById(R.id.garagem_turbo_amador).setOnClickListener(listenerPecas);
        findViewById(R.id.garagem_turbo_intermediario).setOnClickListener(listenerPecas);
        findViewById(R.id.garagem_turbo_profissional).setOnClickListener(listenerPecas);

        findViewById(R.id.garagem_pistao_amador).setOnClickListener(listenerPecas);
        findViewById(R.id.garagem_pistao_intermediario).setOnClickListener(listenerPecas);
        findViewById(R.id.garagem_pistao_profissional).setOnClickListener(listenerPecas);
    }

    private void setListenerCarro() {
        ListenerCarrosGaragem listenerCarros = new ListenerCarrosGaragem(this);
        findViewById(R.id.garagem_seta_direita).setOnClickListener(listenerCarros);
        findViewById(R.id.garagem_seta_esquerda).setOnClickListener(listenerCarros);
    }


}
