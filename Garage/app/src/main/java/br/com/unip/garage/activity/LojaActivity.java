package br.com.unip.garage.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

import br.com.unip.garage.R;
import br.com.unip.garage.controller.LojaController;
import br.com.unip.garage.enumeration.TipoPeca;
import br.com.unip.garage.model.PecaLoja;

public class LojaActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_loja);
    }

    private void definirPecas(TipoPeca peca) {
        LojaController controller = new LojaController(this);
        PecaLoja pecaAmadora = controller.getPecaAmadora(peca);
        PecaLoja pecaIntermediaria = controller.getPecaIntermediaria(peca);
        PecaLoja pecaProfissional = controller.getPecaProfissional(peca);

        ImageButton botaoPecaAmadora = (ImageButton) findViewById(R.id.pecaAmadora);
        botaoPecaAmadora.setBackgroundResource(pecaAmadora.getIdBackground());
        botaoPecaAmadora.setImageResource(pecaAmadora.getIdImagem());
        botaoPecaAmadora.setVisibility(View.VISIBLE);
        botaoPecaAmadora.setClickable(pecaAmadora.getClicavel());


        ImageButton botaoPecaIntermediaria = (ImageButton) findViewById(R.id.pecaIntermediaria);
        botaoPecaIntermediaria.setBackgroundResource(pecaIntermediaria.getIdBackground());
        botaoPecaIntermediaria.setImageResource(pecaIntermediaria.getIdImagem());
        botaoPecaIntermediaria.setVisibility(View.VISIBLE);
        botaoPecaIntermediaria.setClickable(pecaIntermediaria.getClicavel());

        ImageButton botaoPecaProfissional = (ImageButton) findViewById(R.id.pecaProfissional);
        botaoPecaProfissional.setBackgroundResource(pecaProfissional.getIdBackground());
        botaoPecaProfissional.setImageResource(pecaProfissional.getIdImagem());
        botaoPecaProfissional.setVisibility(View.VISIBLE);
        botaoPecaProfissional.setClickable(pecaProfissional.getClicavel());
    }

    private void removerSelecaoBotoes() {
        ImageButton botaoPneu = (ImageButton) findViewById(R.id.botaoPneuLoja);
        ImageButton botaoTurbo = (ImageButton) findViewById(R.id.botaoTurboLoja);
        ImageButton botaoMotor = (ImageButton) findViewById(R.id.botaoMotorLoja);
        ImageButton botaoFreio = (ImageButton) findViewById(R.id.botaoFreioLoja);
        ImageButton botaoPistao = (ImageButton) findViewById(R.id.botaoPistaoLoja);

        botaoPneu.setBackgroundResource(R.drawable.botao_pneu);
        botaoTurbo.setBackgroundResource(R.drawable.botao_turbo);
        botaoMotor.setBackgroundResource(R.drawable.botao_motor);
        botaoFreio.setBackgroundResource(R.drawable.botao_freio);
        botaoPistao.setBackgroundResource(R.drawable.botao_pistao);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.botaoVoltarLoja) {
            Intent startCreditos = new Intent(LojaActivity.this, MainActivity.class);
            startActivity(startCreditos);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        } else if (v.getId() == R.id.botaoPneuLoja) {
            removerSelecaoBotoes();
            ImageButton botaoPPneu = (ImageButton) findViewById(v.getId());
            botaoPPneu.setBackgroundResource(R.drawable.botao_pneu_select);
            definirPecas(TipoPeca.PNEU);
        } else if (v.getId() == R.id.botaoTurboLoja) {
            removerSelecaoBotoes();
            ImageButton botaoTurbo = (ImageButton) findViewById(v.getId());
            botaoTurbo.setBackgroundResource(R.drawable.botao_turbo_select);
            definirPecas(TipoPeca.TURBO);
        } else if (v.getId() == R.id.botaoMotorLoja) {
            removerSelecaoBotoes();
            ImageButton botaoMotor = (ImageButton) findViewById(v.getId());
            botaoMotor.setBackgroundResource(R.drawable.botao_motor_select);
            definirPecas(TipoPeca.MOTOR);
        } else if (v.getId() == R.id.botaoFreioLoja) {
            removerSelecaoBotoes();
            ImageButton botaoFreio = (ImageButton) findViewById(v.getId());
            botaoFreio.setBackgroundResource(R.drawable.botao_freio_select);
            definirPecas(TipoPeca.FREIO);
        } else if (v.getId() == R.id.botaoPistaoLoja) {
            removerSelecaoBotoes();
            ImageButton botaoPistao = (ImageButton) findViewById(v.getId());
            botaoPistao.setBackgroundResource(R.drawable.botao_pistao_select);
            definirPecas(TipoPeca.PISTAO);
        }
    }
}
