package br.com.unip.garage.listener;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import br.com.unip.garage.R;
import br.com.unip.garage.activity.GaragemActivity;
import br.com.unip.garage.activity.MainActivity;
import br.com.unip.garage.activity.MapaActivity;
import br.com.unip.garage.builder.BuilderCarro;
import br.com.unip.garage.dados.CarroDAO;
import br.com.unip.garage.dados.UsuarioDAO;
import br.com.unip.garage.model.Carro;
import br.com.unip.garage.model.Freio;
import br.com.unip.garage.model.Motor;
import br.com.unip.garage.model.Pistao;
import br.com.unip.garage.model.Pneu;
import br.com.unip.garage.model.Turbo;
import br.com.unip.garage.model.Usuario;

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
        } else if (v.getId() == R.id.garagem_home) {
            Intent startHome = new Intent(activity, MainActivity.class);
            activity.startActivity(startHome);
            activity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        } else if (v.getId() == R.id.garagem_mapas) {
            atualizaPecasCarroUsuario();
            Intent startMapas = new Intent(activity, MapaActivity.class);
            activity.startActivity(startMapas);
            activity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }

    private void definirImagemCarro() {
        Carro carro = carroDAO.buscaPorId(Integer.toString(indexCarro));
        if (carro != null) {
            Integer idImagem = activity.getResources().getIdentifier(carro.getCarroImagem(), "drawable", activity.getPackageName());
            imagemCarro.setImageResource(idImagem);
            imagemCarro.setTag(carro);
        }
    }

    private void atualizaPecasCarroUsuario() {
        Carro carro = (Carro) imagemCarro.getTag();
        if (carro == null) {
            definirImagemCarro();
            carro = (Carro) imagemCarro.getTag();
        }
        Turbo turbo = (Turbo) activity.findViewById(R.id.garagem_turbo).getTag();
        Motor motor = (Motor) activity.findViewById(R.id.garagem_motor).getTag();
        Freio freio = (Freio) activity.findViewById(R.id.garagem_freio).getTag();
        Pneu pneu = (Pneu) activity.findViewById(R.id.garagem_pneu).getTag();
        Pistao pistao = (Pistao) activity.findViewById(R.id.garagem_pistao).getTag();

        BuilderCarro builderCarro = new BuilderCarro();
        builderCarro.id(carro.getId())
                .icone(carro.getIcone())
                .carroImagem(carro.getCarroImagem())
                .velocidade(carro.getVelocidade())
                .capacidadeCombustivel(carro.getCapacidadeCombustivel())
                .turbo(turbo)
                .motor(motor)
                .freio(freio)
                .pneu(pneu)
                .pistao(pistao);
        carroDAO.altera(builderCarro.build());

        UsuarioDAO usuarioDAO = new UsuarioDAO(activity);
        Usuario usuario = usuarioDAO.buscaPorId("1");
        usuario.setIdCarro(carro.getId());
        usuarioDAO.altera(usuario);
    }
}
