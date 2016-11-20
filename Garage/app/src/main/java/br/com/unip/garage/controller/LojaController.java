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

    public void comprarPeca(Peca peca, TipoPeca tipoPeca) {
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

    public PecaDAO getPecaDAO(TipoPeca peca) {
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
