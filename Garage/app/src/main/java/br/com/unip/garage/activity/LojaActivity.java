package br.com.unip.garage.activity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.TextView;

import br.com.unip.garage.R;
import br.com.unip.garage.dados.UsuarioDAO;
import br.com.unip.garage.listener.ListenerLoja;

import static br.com.unip.garage.R.drawable.dinheiro;

public class LojaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_loja);
        setListenerLojaClick();
        setListenerLojaLongClick();
        TextView dinheiro = (TextView) findViewById(R.id.loja_dinheiro);
        dinheiro.setText(Integer.toString(new UsuarioDAO(this).buscaPorId("1").getDinheiro()));
    }

    private void setListenerLojaClick() {
        ListenerLoja listenerLoja = new ListenerLoja(this);
        findViewById(R.id.loja_voltar).setOnClickListener(listenerLoja);
        findViewById(R.id.loja_pneu).setOnClickListener(listenerLoja);
        findViewById(R.id.loja_turbo).setOnClickListener(listenerLoja);
        findViewById(R.id.loja_motor).setOnClickListener(listenerLoja);
        findViewById(R.id.loja_freio).setOnClickListener(listenerLoja);
        findViewById(R.id.loja_pistao).setOnClickListener(listenerLoja);
        findViewById(R.id.loja_peca_profissional).setOnClickListener(listenerLoja);
        findViewById(R.id.loja_peca_intermediaria).setOnClickListener(listenerLoja);
        findViewById(R.id.loja_peca_amadora).setOnClickListener(listenerLoja);
    }

    private void setListenerLojaLongClick() {
        ListenerLoja listenerLoja = new ListenerLoja(this);
        findViewById(R.id.loja_peca_profissional).setOnLongClickListener(listenerLoja);
        findViewById(R.id.loja_peca_intermediaria).setOnLongClickListener(listenerLoja);
        findViewById(R.id.loja_peca_amadora).setOnLongClickListener(listenerLoja);
    }

}
