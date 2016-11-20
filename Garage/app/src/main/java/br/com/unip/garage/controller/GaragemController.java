package br.com.unip.garage.controller;

import android.app.Activity;
import android.view.View;

import java.util.Iterator;
import java.util.List;

import br.com.unip.garage.R;
import br.com.unip.garage.dados.FreioDAO;
import br.com.unip.garage.dados.MotorDAO;
import br.com.unip.garage.dados.PistaoDAO;
import br.com.unip.garage.dados.PneuDAO;
import br.com.unip.garage.dados.TurboDAO;
import br.com.unip.garage.enumeration.NivelPeca;
import br.com.unip.garage.enumeration.TipoPeca;
import br.com.unip.garage.model.Freio;
import br.com.unip.garage.model.Motor;
import br.com.unip.garage.model.PecaLoja;
import br.com.unip.garage.model.Pistao;
import br.com.unip.garage.model.Pneu;
import br.com.unip.garage.model.Turbo;

/**
 * Created by caique on 05/11/16.
 */

public class GaragemController {

    private Activity activity;

    public GaragemController(Activity activity) {
        this.activity = activity;
    }

    public PecaLoja possuiPecaAmadora(TipoPeca peca) {
        if (peca.equals(TipoPeca.PNEU)) {
            return new PecaLoja(R.drawable.pneu_basic, null, true);
        } else if (peca.equals(TipoPeca.TURBO)) {
            return new PecaLoja(R.drawable.turbo_basic, null, true);
        } else if (peca.equals(TipoPeca.MOTOR)) {
            return new PecaLoja(R.drawable.motor_basic, null, true);
        } else if (peca.equals(TipoPeca.FREIO)) {
            return new PecaLoja(R.drawable.freio_basic, null, true);
        } else if (peca.equals(TipoPeca.PISTAO)) {
            return new PecaLoja(R.drawable.pistao_basic, null, true);
        }
        return null;
    }

    private void verificarPossuiFreios() {
        FreioDAO freioDAO = new FreioDAO(activity);
        for (Freio freio : freioDAO.busca()) {
            if (freio.getPossui() == Boolean.FALSE) {
                if (freio.getNivelPeca() == NivelPeca.AMADOR) {
                    activity.findViewById(R.id.garagem_freio_amador).setVisibility(View.GONE);
                } else if (freio.getNivelPeca() == NivelPeca.INTERMEDIARIO) {
                    activity.findViewById(R.id.garagem_freio_intermediario).setVisibility(View.GONE);
                } else {
                    activity.findViewById(R.id.garagem_freio_profissional).setVisibility(View.GONE);
                }
            }
        }
    }

}
