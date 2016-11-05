package br.com.unip.garage.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import br.com.unip.garage.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        ImageButton botaoCreditos = (ImageButton) findViewById(R.id.botaoMenu);
        botaoCreditos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startCreditos = new Intent(MainActivity.this, CreditosActivity.class);
                startActivity(startCreditos);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        ImageButton botaoLoja = (ImageButton) findViewById(R.id.botaoLoja);
        botaoLoja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startLoja = new Intent(MainActivity.this, LojaActivity.class);
                startActivity(startLoja);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        ImageButton botaoJogar = (ImageButton) findViewById(R.id.botaoJogar);
        botaoJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startJogar = new Intent(MainActivity.this, GaragemActivity.class);
                startActivity(startJogar);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
    }
}
