package br.com.unip.garage.controller;

import android.content.Context;

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

    private Context context;

    public LojaController(Context context) {
        this.context = context;
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
        UsuarioDAO dao = new UsuarioDAO(context);
        Usuario usuario = dao.buscaPorId("1");
        if (usuario.getDinheiro() >= peca.getPreco()) {
            usuario.setDinheiro(usuario.getDinheiro() - peca.getPreco());
            dao.altera(usuario);
            peca.setPossui(true);
            getPecaDAO(tipoPeca).altera(peca);
        } else {
            //TODO: Não possui dinheiro para compra
        }
    }

    private PecaDAO getPecaDAO(TipoPeca peca) {
        if (TipoPeca.FREIO == peca)
            return new FreioDAO(context);
        if (TipoPeca.MOTOR == peca)
            return new MotorDAO(context);
        if (TipoPeca.TURBO == peca)
            return new TurboDAO(context);
        if (TipoPeca.PISTAO == peca)
            return new PistaoDAO(context);
        if (TipoPeca.PNEU == peca)
            return new PneuDAO(context);
        return null;
    }


}
