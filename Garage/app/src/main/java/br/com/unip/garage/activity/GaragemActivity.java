package br.com.unip.garage.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

import br.com.unip.garage.R;
import br.com.unip.garage.controller.GaragemController;
import br.com.unip.garage.enumeration.TipoPeca;
import br.com.unip.garage.model.PecaLoja;

public class GaragemActivity extends Activity implements View.OnClickListener {

    private GaragemController garagemController = new GaragemController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_garagem);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.botaoHome) {
            Intent startHome = new Intent(GaragemActivity.this, MainActivity.class);
            startActivity(startHome);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        } else if (v.getId() == R.id.botaoPneuGaragem) {
            alterarVisibilidade(findViewById(R.id.pneusPecas));
        }else if (v.getId() == R.id.botaoPistaoGaragem) {
            alterarVisibilidade(findViewById(R.id.pistoesPecas));
        }else if (v.getId() == R.id.botaoMotorGaragem) {
            alterarVisibilidade(findViewById(R.id.motoresPecas));
        }else if (v.getId() == R.id.botaoTurboGaragem) {
            alterarVisibilidade(findViewById(R.id.turbosPecas));
        }else if (v.getId() == R.id.botaoFreioGaragem) {
            alterarVisibilidade(findViewById(R.id.freiosPecas));
        }else if(v.getId() == R.id.botaoFreioBasic){
            alterarVisibilidade(findViewById(R.id.freiosPecas));
            ImageButton botao = (ImageButton)findViewById(R.id.botaoFreioGaragem);
            botao.setImageDrawable(v.getBackground());
        }

    }

    private void alterarVisibilidade(View view) {
        if(view.getVisibility() == View.GONE) {
            view.setVisibility(View.VISIBLE);
        }else{
            view.setVisibility(View.GONE);
        }
    }
}
