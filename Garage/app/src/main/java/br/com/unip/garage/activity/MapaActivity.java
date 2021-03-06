package br.com.unip.garage.activity;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import br.com.unip.garage.R;
import br.com.unip.garage.listener.ListenerMapas;

public class MapaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_mapa);

        setListenerMapas();
    }

    private void setListenerMapas(){
        ListenerMapas listenerMapas = new ListenerMapas(this);
        findViewById(R.id.mapa_mapa_um).setOnClickListener(listenerMapas);
        findViewById(R.id.mapa_mapa_dois).setOnClickListener(listenerMapas);
        findViewById(R.id.mapa_mapa_treis).setOnClickListener(listenerMapas);
        findViewById(R.id.mapa_mapa_quatro).setOnClickListener(listenerMapas);
        findViewById(R.id.mapa_voltar).setOnClickListener(listenerMapas);
        findViewById(R.id.mapa_jogar).setOnClickListener(listenerMapas);
    }
}
