package br.com.unip.garage.activity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import br.com.unip.garage.R;
import br.com.unip.garage.util.InicializaBD;
import br.com.unip.garage.util.UtilGarage;

public class SplashScreenActivity extends AppCompatActivity implements Runnable{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ImageView animationImageView = (ImageView) findViewById(R.id.splashscreen_view);
        animationImageView.setBackgroundResource(R.drawable.splash_screen);
        final AnimationDrawable frameAnimation = (AnimationDrawable) animationImageView.getBackground();
        animationImageView.post(new Runnable() {
            @Override
            public void run() {
                frameAnimation.start();
            }
        });

        new SplashScreenTask().execute();
        Handler h = new Handler();
        h.postDelayed(this, 8300);
    }

    public void run() {
        Intent i = new Intent(SplashScreenActivity.this, MainActivity.class);
        startActivity(i);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        // close this activity
        finish();
    }

    private class SplashScreenTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            InicializaBD inicializaBD = new InicializaBD();
            inicializaBD.inicializaBanco(SplashScreenActivity.this);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

        }
    }
}
