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
import br.com.unip.garage.modelo.PecaLoja;

public class LojaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_loja);

        ImageButton botaoVoltar = (ImageButton) findViewById(R.id.botaoVoltarLoja);
        final ImageButton botaoPneu = (ImageButton) findViewById(R.id.botaoPneuLoja);
        final ImageButton botaoTurbo = (ImageButton) findViewById(R.id.botaoTurboLoja);
        final ImageButton botaoMotor = (ImageButton) findViewById(R.id.botaoMotorLoja);
        final ImageButton botaoFreio = (ImageButton) findViewById(R.id.botaoFreioLoja);
        final ImageButton botaoPistao = (ImageButton) findViewById(R.id.botaoPistaoLoja);


        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startCreditos = new Intent(LojaActivity.this, MainActivity.class);
                startActivity(startCreditos);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        botaoPneu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removerSelecaoBotoes();
                botaoPneu.setBackgroundResource(R.drawable.botao_pneu_select);
                definirPecas(TipoPeca.PNEU);
            }
        });

        botaoTurbo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removerSelecaoBotoes();
                botaoTurbo.setBackgroundResource(R.drawable.botao_turbo_select);
                definirPecas(TipoPeca.TURBO);
            }
        });

        botaoMotor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removerSelecaoBotoes();
                botaoMotor.setBackgroundResource(R.drawable.botao_motor_select);
                definirPecas(TipoPeca.MOTOR);
            }
        });

        botaoFreio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removerSelecaoBotoes();
                botaoFreio.setBackgroundResource(R.drawable.botao_freio_select);
                definirPecas(TipoPeca.FREIO);
            }
        });

        botaoPistao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removerSelecaoBotoes();
                botaoPistao.setBackgroundResource(R.drawable.botao_pistao_select);
                definirPecas(TipoPeca.PISTAO);
            }
        });


    }

    private void definirPecas(TipoPeca peca) {
        LojaController controller = new LojaController();
        PecaLoja pecaAmadora = controller.getPecaAmadora(peca);
        PecaLoja pecaIntermediaria = controller.getPecaIntermediaria(peca);
        PecaLoja pecaProfissional = controller.getPecaProfissional(peca);

        ImageButton botaoPecaAmadora = (ImageButton)findViewById(R.id.pecaAmadora);
        botaoPecaAmadora.setBackgroundResource(pecaAmadora.getIdBackground());
        botaoPecaAmadora.setImageResource(pecaAmadora.getIdImagem());
        botaoPecaAmadora.setVisibility(View.VISIBLE);

        ImageButton botaoPecaIntermediaria = (ImageButton)findViewById(R.id.pecaIntermediaria);
        botaoPecaIntermediaria.setBackgroundResource(pecaIntermediaria.getIdBackground());
        botaoPecaIntermediaria.setImageResource(pecaIntermediaria.getIdImagem());
        botaoPecaIntermediaria.setVisibility(View.VISIBLE);

        ImageButton botaoPecaProfissional = (ImageButton)findViewById(R.id.pecaProfissional);
        botaoPecaProfissional.setBackgroundResource(pecaProfissional.getIdBackground());
        botaoPecaProfissional.setImageResource(pecaProfissional.getIdImagem());
        botaoPecaProfissional.setVisibility(View.VISIBLE);
    }

    private void removerSelecaoBotoes(){
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
}
