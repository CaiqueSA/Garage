package br.com.unip.garage.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.unip.garage.R;
import br.com.unip.garage.enumeration.TipoPeca;
import br.com.unip.garage.modelo.PecaLoja;

/**
 * Created by caique on 05/11/16.
 */

public class GaragemController {

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
}
