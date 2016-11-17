package br.com.unip.garage.listener;

import android.app.Activity;
import android.view.View;

import br.com.unip.garage.R;

/**
 * Created by caique on 17/11/16.
 * Classe reponsavel por realizar as mudanças de layout referentes ao carro
 */

public class ListenerCarrosGaragem implements View.OnClickListener {

    private Activity activity;

    public ListenerCarrosGaragem(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.garagem_seta_direita){
            
        }
    }
}
