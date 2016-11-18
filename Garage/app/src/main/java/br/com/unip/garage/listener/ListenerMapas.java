package br.com.unip.garage.listener;

import android.app.Activity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by caique on 18/11/16.
 */

public class ListenerMapas implements View.OnClickListener {

    private ImageButton jogar;
    private ImageButton voltar;
    private ImageButton mapa3;
    private ImageButton mapa1;
    private ImageButton mapa2;
    private ImageButton mapa4;
    private Activity activity;

    public ListenerMapas(Activity activity) {
        this.activity = activity;
        mapa1 = (ImageButton) activity.findViewById(R.id.mapa_mapa1);
        mapa2 = (ImageButton) activity.findViewById(R.id.mapa_mapa2);
        mapa3 = (ImageButton) activity.findViewById(R.id.mapa_mapa3);
        mapa4 = (ImageButton) activity.findViewById(R.id.mapa_mapa4);
        voltar = (ImageButton) activity.findViewById(R.id.mapa_voltar);
        jogar = (ImageButton) activity.findViewById(R.id.mapa_jogar);
    }

    @Override
    public void onClick(View v) {
        removerSelecaoMapas();
        if (v.getId() == R.id.mapa_mapa1) {
            mapa1.setBackgroundResource(R.drawable.mapa_1_select);
            mapa1.setTag(1);
        } else if (v.getId() == R.id.mapa_mapa2) {
            mapa2.setBackgroundResource(R.drawable.mapa_2_select);
            mapa1.setTag(2);
        } else if (v.getId() == R.id.mapa_mapa3) {
            mapa3.setBackgroundResource(R.drawable.mapa_3_select);
            mapa1.setTag(3);
        } else if (v.getId() == R.id.mapa_mapa4) {
            mapa4.setBackgroundResource(R.drawable.mapa_4_select);
            mapa1.setTag(4);
        }
    }

    private void removerSelecaoMapas() {
        mapa1.setBackgroundResource(R.drawable.mapa_1);
        mapa1.setTag(null);
        mapa2.setBackgroundResource(R.drawable.mapa_2);
        mapa2.setTag(null);
        mapa3.setBackgroundResource(R.drawable.mapa_3);
        mapa3.setTag(null);
        mapa4.setBackgroundResource(R.drawable.mapa_4);
        mapa4.setTag(null);
    }

    private Integer getMapaSelecionado() {
        if (mapa1.getTag() != null) {
            return (Integer) mapa1.getTag();
        } else if (mapa2.getTag() != null) {
            return (Integer) mapa2.getTag();
        } else if (mapa3.getTag() != null) {
            return (Integer) mapa3.getTag();
        } else if (mapa4.getTag() != null) {
            return (Integer) mapa4.getTag();
        }
    }
}

