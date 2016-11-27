package br.com.unip.garage.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import br.com.unip.garage.R;
import br.com.unip.garage.dados.CarroDAO;
import br.com.unip.garage.model.Carro;

public class CorridaMapa1Activity extends AppCompatActivity {

    private ImageView imageCarro = null;
    private Integer INICIAL_X = 200;
    private Integer INICIAL_Y = 150;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corrida_mapa1);

    }

    private void addCarroUsuario() {
        CarroDAO carroDAO = new CarroDAO(getApplicationContext());
        Carro carroUsuario = carroDAO.buscaPorId("1");
        int idImage = getResources().getIdentifier(carroUsuario.getIcone(), "drawable", getPackageName());
        imageCarro = new ImageView(this);
        imageCarro.setBackgroundResource(idImage);
        imageCarro.setX(toDps(INICIAL_X));
        imageCarro.setY(toDps(INICIAL_Y));
    }

    private Integer toDps(int position){
        return (int)(position * getResources().getDisplayMetrics().density);
    }
}
