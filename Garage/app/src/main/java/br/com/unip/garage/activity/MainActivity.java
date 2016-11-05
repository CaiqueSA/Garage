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

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.botaoMenu) {
            Intent startCreditos = new Intent(MainActivity.this, CreditosActivity.class);
            startActivity(startCreditos);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        } else if (v.getId() == R.id.botaoJogar) {
            Intent startJogar = new Intent(MainActivity.this, GaragemActivity.class);
            startActivity(startJogar);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        } else if (v.getId() == R.id.botaoLoja) {
            Intent startLoja = new Intent(MainActivity.this, LojaActivity.class);
            startActivity(startLoja);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }
}
