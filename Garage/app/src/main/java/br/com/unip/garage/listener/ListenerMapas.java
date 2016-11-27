package br.com.unip.garage.listener;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import br.com.unip.garage.R;
import br.com.unip.garage.activity.CorridaMapa1Activity;
import br.com.unip.garage.activity.GaragemActivity;

/**
 * Created by caique on 18/11/16.
 */

public class ListenerMapas implements View.OnClickListener {

    private ImageButton jogar;
    private ImageButton voltar;
    private ImageButton mapa_treis;
    private ImageButton mapa_um;
    private ImageButton mapa_dois;
    private ImageButton mapa_quatro;
    private Activity activity;
    private Integer mapa;

    public ListenerMapas(Activity activity) {
        this.activity = activity;
        mapa_um = (ImageButton) activity.findViewById(R.id.mapa_mapa_um);
        mapa_dois = (ImageButton) activity.findViewById(R.id.mapa_mapa_dois);
        mapa_treis = (ImageButton) activity.findViewById(R.id.mapa_mapa_treis);
        mapa_quatro = (ImageButton) activity.findViewById(R.id.mapa_mapa_quatro);
        voltar = (ImageButton) activity.findViewById(R.id.mapa_voltar);
        jogar = (ImageButton) activity.findViewById(R.id.mapa_jogar);
    }

    @Override
    public void onClick(View v) {
        removerSelecaoMapas();
        if (v.getId() == R.id.mapa_mapa_um) {
            mapa_um.setBackgroundResource(R.drawable.mapa_um_select);
            mapa = 1;
        } else if (v.getId() == R.id.mapa_mapa_dois) {
            mapa_dois.setBackgroundResource(R.drawable.mapa_dois_select);
            mapa = 2;
        } else if (v.getId() == R.id.mapa_mapa_treis) {
            mapa_treis.setBackgroundResource(R.drawable.mapa_tres_select);
            mapa = 3;
        } else if (v.getId() == R.id.mapa_mapa_quatro) {
            mapa_quatro.setBackgroundResource(R.drawable.mapa_quatro_select);
            mapa = 4;
        } else if (v.getId() == R.id.mapa_voltar) {
            Intent startGaragem = new Intent(activity, GaragemActivity.class);
            activity.startActivity(startGaragem);
            activity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        } else if (v.getId() == R.id.mapa_jogar) {
            if (mapa == 1) {
                Intent startCorrida = new Intent(activity, CorridaMapa1Activity.class);
                startCorrida.putExtra("mapa_selecionado", mapa);
                activity.startActivity(startCorrida);
                activity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            } else {
                Toast.makeText(activity, "Selecione um mapa válido!", Toast.LENGTH_SHORT);
            }
        }
    }

    private void removerSelecaoMapas() {
        mapa_um.setBackgroundResource(R.drawable.mapa_um);
        mapa_um.setTag(null);
        mapa_dois.setBackgroundResource(R.drawable.mapa_dois);
        mapa_dois.setTag(null);
        mapa_treis.setBackgroundResource(R.drawable.mapa_tres);
        mapa_treis.setTag(null);
        mapa_quatro.setBackgroundResource(R.drawable.mapa_quatro);
        mapa_quatro.setTag(null);
    }


}

