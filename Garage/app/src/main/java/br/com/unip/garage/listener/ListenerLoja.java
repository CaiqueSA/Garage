package br.com.unip.garage.listener;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import br.com.unip.garage.R;
import br.com.unip.garage.activity.LojaActivity;
import br.com.unip.garage.activity.MainActivity;
import br.com.unip.garage.controller.LojaController;
import br.com.unip.garage.dados.UsuarioDAO;
import br.com.unip.garage.enumeration.NivelPeca;
import br.com.unip.garage.enumeration.TipoPeca;
import br.com.unip.garage.model.Peca;

/**
 * Created by caique on 20/11/16.
 */

public class ListenerLoja implements View.OnClickListener, View.OnLongClickListener {


    private final UsuarioDAO dao;
    private TextView dinheiro;
    private ImageButton botaoPecaAmadora;
    private ImageButton botaoPecaIntermediaria;
    private ImageButton botaoPecaProfissional;
    private ImageButton botaoPneu;
    private ImageButton botaoTurbo;
    private ImageButton botaoMotor;
    private ImageButton botaoFreio;
    private ImageButton botaoPistao;
    private AppCompatActivity activity;

    public ListenerLoja(AppCompatActivity activity) {
        this.activity = activity;
        this.dao = new UsuarioDAO(activity);
        botaoPneu = (ImageButton) activity.findViewById(R.id.loja_pneu);
        botaoTurbo = (ImageButton) activity.findViewById(R.id.loja_turbo);
        botaoMotor = (ImageButton) activity.findViewById(R.id.loja_motor);
        botaoFreio = (ImageButton) activity.findViewById(R.id.loja_freio);
        botaoPistao = (ImageButton) activity.findViewById(R.id.loja_pistao);
        botaoPecaProfissional = (ImageButton) activity.findViewById(R.id.loja_peca_profissional);
        botaoPecaIntermediaria = (ImageButton) activity.findViewById(R.id.loja_peca_intermediaria);
        botaoPecaAmadora = (ImageButton) activity.findViewById(R.id.loja_peca_amadora);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.loja_voltar) {
            Intent startHome = new Intent(activity, MainActivity.class);
            activity.startActivity(startHome);
            activity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        } else if (v.getId() == R.id.loja_pneu) {
            removerSelecaoBotoes();
            botaoPneu.setBackgroundResource(R.drawable.botao_pneu_select);
            definirPecas(TipoPeca.PNEU);
        } else if (v.getId() == R.id.loja_turbo) {
            removerSelecaoBotoes();
            botaoTurbo.setBackgroundResource(R.drawable.botao_turbo_select);
            definirPecas(TipoPeca.TURBO);
        } else if (v.getId() == R.id.loja_motor) {
            removerSelecaoBotoes();
            botaoMotor.setBackgroundResource(R.drawable.botao_motor_select);
            definirPecas(TipoPeca.MOTOR);
        } else if (v.getId() == R.id.loja_freio) {
            removerSelecaoBotoes();
            botaoFreio.setBackgroundResource(R.drawable.botao_freio_select);
            definirPecas(TipoPeca.FREIO);
        } else if (v.getId() == R.id.loja_pistao) {
            removerSelecaoBotoes();
            botaoPistao.setBackgroundResource(R.drawable.botao_pistao_select);
            definirPecas(TipoPeca.PISTAO);
        } else if (v.getId() == botaoPecaAmadora.getId()) {
            Peca peca = (Peca) botaoPecaAmadora.getTag();
            definirFundoSelect(v, peca);
        } else if (v.getId() == botaoPecaIntermediaria.getId()) {
            Peca peca = (Peca) botaoPecaIntermediaria.getTag();
            definirFundoSelect(v, peca);
        } else if (v.getId() == botaoPecaProfissional.getId()) {
            Peca peca = (Peca) botaoPecaProfissional.getTag();
            definirFundoSelect(v, peca);
        }
    }

    private void definirFundoSelect(View v, Peca peca) {
        if (peca.getPossui() != null && peca.getPossui()) {
            v.setBackgroundResource(R.drawable.campo_loja_possui_select);
        } else {
            if (peca.getNivelDesbloqueio() <= dao.buscaPorId("1").getNivel()) {
                v.setBackgroundResource(R.drawable.campo_loja_select);
            }
        }
    }

    private void removerSelecaoBotoes() {
        botaoPneu.setBackgroundResource(R.drawable.botao_pneu);
        botaoTurbo.setBackgroundResource(R.drawable.botao_turbo);
        botaoMotor.setBackgroundResource(R.drawable.botao_motor);
        botaoFreio.setBackgroundResource(R.drawable.botao_freio);
        botaoPistao.setBackgroundResource(R.drawable.botao_pistao);
    }

    private void definirPecas(final TipoPeca tipoPeca) {
        LojaController controller = new LojaController(activity);
        Peca pecaAmadora = controller.getPecaDAO(tipoPeca).buscaPorNivelPeca(NivelPeca.AMADOR.toString());
        Peca pecaIntermediaria = controller.getPecaDAO(tipoPeca).buscaPorNivelPeca(NivelPeca.INTERMEDIARIO.toString());
        Peca pecaProfissional = controller.getPecaDAO(tipoPeca).buscaPorNivelPeca(NivelPeca.PROFISSIONAL.toString());

        botaoPecaAmadora = definirImagemPeca(pecaAmadora, botaoPecaAmadora);
        botaoPecaAmadora.setVisibility(View.VISIBLE);
        botaoPecaAmadora.setTag(pecaAmadora);

        botaoPecaIntermediaria = definirImagemPeca(pecaIntermediaria, botaoPecaIntermediaria);
        botaoPecaIntermediaria.setVisibility(View.VISIBLE);
        botaoPecaIntermediaria.setTag(pecaIntermediaria);

        botaoPecaProfissional = definirImagemPeca(pecaProfissional, botaoPecaProfissional);
        botaoPecaProfissional.setVisibility(View.VISIBLE);
        botaoPecaProfissional.setTag(pecaProfissional);

    }

    private ImageButton definirImagemPeca(final Peca peca, ImageButton botaoPeca) {
        if (peca.getNivelDesbloqueio() <= dao.buscaPorId("1").getNivel()) {
            Integer idImagem = activity.getResources().getIdentifier(peca.getImagem(), "drawable", activity.getPackageName());
            if (peca.getPossui() == Boolean.TRUE) {
                botaoPeca.setBackgroundResource(R.drawable.campo_loja_possui);
            } else {
                botaoPeca.setBackgroundResource(R.drawable.campo_loja);
            }
            botaoPeca.setImageResource(idImagem);
        } else {
            Integer idImagem = activity.getResources().getIdentifier(peca.getImagem() + "_bloc", "drawable", activity.getPackageName());
            botaoPeca.setImageResource(R.drawable.campo_loja_bloc);
            botaoPeca.setBackgroundResource(idImagem);
        }
        return botaoPeca;
    }

    @Override
    public boolean onLongClick(View v) {
        if (v.getId() == botaoPecaAmadora.getId()) {
            LojaController controller = new LojaController(activity);
            Peca peca = (Peca) botaoPecaAmadora.getTag();
            boolean comprou = controller.comprarPeca(peca, nivelPecaByName(peca.getImagem()));
            if (comprou) {
                definirImagemPeca(peca, botaoPecaAmadora);
                peca.setPossui(Boolean.TRUE);
                botaoPecaAmadora.setTag(peca);
            }
        }
        return false;
    }

    private TipoPeca nivelPecaByName(String nomeImagem) {
        if (nomeImagem.contains("freio")) {
            return TipoPeca.FREIO;
        } else if (nomeImagem.contains("motor")) {
            return TipoPeca.MOTOR;
        } else if (nomeImagem.contains("pistao")) {
            return TipoPeca.PISTAO;
        } else if (nomeImagem.contains("pneu")) {
            return TipoPeca.PNEU;
        } else if (nomeImagem.contains("turbo")) {
            return TipoPeca.TURBO;
        }
        return null;
    }
}
