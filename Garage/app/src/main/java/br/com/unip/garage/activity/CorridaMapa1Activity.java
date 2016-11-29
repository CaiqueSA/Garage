package br.com.unip.garage.activity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import br.com.unip.garage.R;
import br.com.unip.garage.dados.CarroDAO;
import br.com.unip.garage.model.Carro;

public class CorridaMapa1Activity extends AppCompatActivity {

    private ImageView imageCarro = null;
    private Integer INICIAL_X = null;
    private Integer INICIAL_Y = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_corrida_mapa1);
        addCarroUsuario();
        INICIAL_X = toDps(170);
        INICIAL_Y = toDps(80);

        /**
         TranslateAnimation translateAnimation = new TranslateAnimation(INICIAL_X, toDps(INICIAL_X + 100), INICIAL_Y, toDps(INICIAL_Y + 100));
         translateAnimation.setDuration(5000);
         translateAnimation.setInterpolator(new AccelerateInterpolator(2.f));
         imageCarro.setAnimation(translateAnimation);
         */

    }


    private void addCarroUsuario() {
        CarroDAO carroDAO = new CarroDAO(getApplicationContext());
        Carro carroUsuario = carroDAO.buscaPorId("1");
        imageCarro = (ImageView) findViewById(R.id.icone_corrida_1_usuario);
        int idImage = getResources().getIdentifier(carroUsuario.getIcone(), "drawable", getPackageName());
        imageCarro.setVisibility(View.VISIBLE);
    }

    private Integer toDps(int position) {
        return (int) (position * getResources().getDisplayMetrics().density);
    }

}
