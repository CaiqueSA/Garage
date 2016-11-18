package br.com.unip.garage.util;

import android.content.Context;

import java.util.List;

import br.com.unip.garage.dados.CarroDAO;
import br.com.unip.garage.dados.PecaDAO;
import br.com.unip.garage.dados.UsuarioDAO;
import br.com.unip.garage.model.Carro;
import br.com.unip.garage.model.Peca;
import br.com.unip.garage.model.Usuario;

/**
 * Created by caique on 08/10/16.
 */
public class UtilGarage {

    public static Carro getCarroPlayer(Context context) {
        UsuarioDAO usuarioDAO = new UsuarioDAO(context);
        Usuario usuario = usuarioDAO.buscaPorId("1");
        CarroDAO carroDAO = new CarroDAO(context);
        return carroDAO.buscaPorId(String.valueOf(usuario.getIdCarro()));
    }


    public static List<Peca> getListaPecaByDAO(PecaDAO pecaDAO) {
        return pecaDAO.busca();
    }

}
