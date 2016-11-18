package br.com.unip.garage.listener;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;

import br.com.unip.garage.R;
import br.com.unip.garage.dados.CarroDAO;
import br.com.unip.garage.model.Carro;

/**
 * Created by caique on 17/11/16.
 * Classe reponsavel por realizar as mudanças de layout referentes ao carro
 */

public class ListenerCarrosGaragem implements View.OnClickListener {

    private Activity activity;
    private Integer indexCarro = 1;
    private CarroDAO carroDAO;
    private ImageView imagemCarro;

    public ListenerCarrosGaragem(Activity activity) {
        this.activity = activity;
        this.carroDAO = new CarroDAO(activity.getApplicationContext());
        this.imagemCarro = (ImageView) activity.findViewById(R.id.garagem_carro);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.garagem_seta_direita) {
            if (indexCarro < 4) {
                indexCarro++;
                definirImagemCarro();
            }
        }
        if (v.getId() == R.id.garagem_seta_esquerda) {
            if (indexCarro > 1) {
                indexCarro--;
                definirImagemCarro();
            }
        }
    }

    private void definirImagemCarro() {
        Carro carro = carroDAO.buscaPorId(String.valueOf(indexCarro));
        if (carro != null) {
            imagemCarro.setBackgroundResource(Integer.valueOf(carro.getCarroImagem()));
        }
    }
}
