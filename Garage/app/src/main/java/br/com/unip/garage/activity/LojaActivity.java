package br.com.unip.garage.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import br.com.unip.garage.R;

public class LojaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_loja);

        Button botaoVoltar = (Button) findViewById(R.id.botaoVoltarLoja);
        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startCreditos = new Intent(LojaActivity.this, MainActivity.class);
                startActivity(startCreditos);
            }
        });
    }
}
