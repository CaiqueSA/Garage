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

public class CreditosActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_creditos);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.botaoVoltarCreditos) {
            Intent startHome = new Intent(CreditosActivity.this, MainActivity.class);
            startActivity(startHome);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }
}
