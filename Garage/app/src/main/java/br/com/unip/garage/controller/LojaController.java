package br.com.unip.garage.controller;

import br.com.unip.garage.R;
import br.com.unip.garage.enumeration.TipoPeca;
import br.com.unip.garage.modelo.PecaLoja;

/**
 * Created by caique on 05/11/16.
 * Esta classe é responsavél pela lógica da loja {@link br.com.unip.garage.activity.LojaActivity}
 */

public class LojaController {

    public PecaLoja getPecaAmadora(TipoPeca peca) {
        if (peca.equals(TipoPeca.PNEU)) {
            return new PecaLoja(R.drawable.campo_loja, R.drawable.pneu_basic, true);
        } else if (peca.equals(TipoPeca.TURBO)) {
            return new PecaLoja(R.drawable.campo_loja, R.drawable.turbo_basic, true);
        } else if (peca.equals(TipoPeca.MOTOR)) {
            return new PecaLoja(R.drawable.campo_loja, R.drawable.motor_basic, true);
        } else if (peca.equals(TipoPeca.FREIO)) {
            return new PecaLoja(R.drawable.campo_loja, R.drawable.freio_basic, true);
        }  else if (peca.equals(TipoPeca.PISTAO)) {
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
        }  else if (peca.equals(TipoPeca.PISTAO)) {
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
        }  else if (peca.equals(TipoPeca.PISTAO)) {
            return new PecaLoja(R.drawable.campo_loja, R.drawable.pistao_gold, true);
        }
        return null;
    }

}
