package br.com.unip.garage.controller;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import br.com.unip.garage.R;
import br.com.unip.garage.dados.FreioDAO;
import br.com.unip.garage.dados.MotorDAO;
import br.com.unip.garage.dados.PecaDAO;
import br.com.unip.garage.dados.PistaoDAO;
import br.com.unip.garage.dados.PneuDAO;
import br.com.unip.garage.dados.TurboDAO;
import br.com.unip.garage.dados.UsuarioDAO;
import br.com.unip.garage.enumeration.TipoPeca;
import br.com.unip.garage.model.Peca;
import br.com.unip.garage.model.PecaLoja;
import br.com.unip.garage.model.Usuario;

/**
 * Created by caique on 05/11/16.
 * Esta classe é responsavél pela lógica da loja {@link br.com.unip.garage.activity.LojaActivity}
 */

public class LojaController {

    private UsuarioDAO dao;
    private Activity activity;

    public LojaController(Activity activity) {
        this.activity = activity;
        this.dao = new UsuarioDAO(activity);
    }

    public PecaLoja getPecaAmadora(TipoPeca peca) {
        if (peca.equals(TipoPeca.PNEU)) {
            return new PecaLoja(R.drawable.campo_loja, R.drawable.pneu_basic, true);
        } else if (peca.equals(TipoPeca.TURBO)) {
            return new PecaLoja(R.drawable.campo_loja, R.drawable.turbo_basic, true);
        } else if (peca.equals(TipoPeca.MOTOR)) {
            return new PecaLoja(R.drawable.campo_loja, R.drawable.motor_basic, true);
        } else if (peca.equals(TipoPeca.FREIO)) {
            return new PecaLoja(R.drawable.campo_loja, R.drawable.freio_basic, true);
        } else if (peca.equals(TipoPeca.PISTAO)) {
            return new PecaLoja(R.drawable.campo_loja, R.drawable.pistao_basic, true);
        }
        return null;
    }

    public PecaLoja getPecaIntermediaria(TipoPeca peca) {
        if (peca.equals(TipoPeca.PNEU)) {
            return new PecaLoja(R.drawable.campo_loja, R.drawable.pneu_silver, true);
        } else if (peca.equals(TipoPeca.TURBO)) {
            return new PecaLoja(R.drawable.campo_loja, R.drawable.turbo_silver, true);
        } else if (peca.equals(TipoPeca.MOTOR)) {
            return new PecaLoja(R.drawable.campo_loja, R.drawable.motor_silver, true);
        } else if (peca.equals(TipoPeca.FREIO)) {
            return new PecaLoja(R.drawable.campo_loja, R.drawable.freio_silver, true);
        } else if (peca.equals(TipoPeca.PISTAO)) {
            return new PecaLoja(R.drawable.campo_loja, R.drawable.pistao_silver, true);
        }
        return null;
    }

    public PecaLoja getPecaProfissional(TipoPeca peca) {
        if (peca.equals(TipoPeca.PNEU)) {
            return new PecaLoja(R.drawable.campo_loja, R.drawable.pneu_gold, true);
        } else if (peca.equals(TipoPeca.TURBO)) {
            return new PecaLoja(R.drawable.campo_loja, R.drawable.turbo_gold, true);
        } else if (peca.equals(TipoPeca.MOTOR)) {
            return new PecaLoja(R.drawable.campo_loja, R.drawable.motor_gold, true);
        } else if (peca.equals(TipoPeca.FREIO)) {
            return new PecaLoja(R.drawable.campo_loja, R.drawable.freio_gold, true);
        } else if (peca.equals(TipoPeca.PISTAO)) {
            return new PecaLoja(R.drawable.campo_loja, R.drawable.pistao_gold, true);
        }
        return null;
    }

    private void comprarPeca(Peca peca, TipoPeca tipoPeca) {
        Usuario usuario = dao.buscaPorId("1");
        if (peca.getPreco() <= usuario.getDinheiro()) {
            dao.altera(usuario);
            peca.setPossui(true);
            getPecaDAO(tipoPeca).altera(peca);
            usuario.setDinheiro(usuario.getDinheiro() - peca.getPreco());
            dao.altera(usuario);
        } else {
            Toast.makeText(activity, "Você não possui dinheito para comprar esta peça!", Toast.LENGTH_LONG).show();
        }
    }

    private PecaDAO getPecaDAO(TipoPeca peca) {
        if (TipoPeca.FREIO == peca)
            return new FreioDAO(activity);
        if (TipoPeca.MOTOR == peca)
            return new MotorDAO(activity);
        if (TipoPeca.TURBO == peca)
            return new TurboDAO(activity);
        if (TipoPeca.PISTAO == peca)
            return new PistaoDAO(activity);
        if (TipoPeca.PNEU == peca)
            return new PneuDAO(activity);
        return null;
    }


}
