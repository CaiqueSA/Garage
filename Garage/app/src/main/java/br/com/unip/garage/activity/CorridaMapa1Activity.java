package br.com.unip.garage.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.graphics.Path;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

import br.com.unip.garage.R;
import br.com.unip.garage.corrida.PercursoUm;
import br.com.unip.garage.dados.CarroDAO;
import br.com.unip.garage.model.Carro;

public class CorridaMapa1Activity extends AppCompatActivity {

    private FrameLayout frameCorrida = null;
    private ImageView carroUsuarioIcone = null;
    private Integer INICIAL_X = null;
    private Integer INICIAL_Y = null;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_corrida_mapa1);
        INICIAL_X = toDps(190);
        INICIAL_Y = toDps(102);
        addCarroUsuario();

        final PercursoUm percursoUm = new PercursoUm(getResources().getDisplayMetrics().density, carroUsuarioIcone);
        Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(percursoUm);
            }
        }, 0, 5000);

    }


    private void addCarroUsuario() {
        CarroDAO carroDAO = new CarroDAO(getApplicationContext());
        Carro carroUsuario = carroDAO.buscaPorId("1");
        frameCorrida = (FrameLayout) findViewById(R.id.pista1_frame);
        int idImage = getResources().getIdentifier(carroUsuario.getIcone(), "drawable", getPackageName());
        this.carroUsuarioIcone = new ImageView(frameCorrida.getContext());
        frameCorrida.addView(carroUsuarioIcone);
        carroUsuarioIcone.setBackgroundResource(idImage);
        carroUsuarioIcone.getLayoutParams().height = toDps(20);
        carroUsuarioIcone.getLayoutParams().width = toDps(20);
        carroUsuarioIcone.setTranslationX(INICIAL_X);
        carroUsuarioIcone.setTranslationY(INICIAL_Y);
        carroUsuarioIcone.setVisibility(View.VISIBLE);
        carroUsuarioIcone.requestLayout();
    }

    private Integer toDps(int position) {
        return (int) (position * getResources().getDisplayMetrics().density);
    }


}
