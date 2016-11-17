package br.com.unip.garage.util;

import android.content.Context;

import br.com.unip.garage.R;
import br.com.unip.garage.builder.BuilderCarro;
import br.com.unip.garage.dados.CarroDAO;
import br.com.unip.garage.dados.FreioDAO;
import br.com.unip.garage.dados.MotorDAO;
import br.com.unip.garage.dados.PistaoDAO;
import br.com.unip.garage.dados.PneuDAO;
import br.com.unip.garage.dados.TemplateDAO;
import br.com.unip.garage.dados.TurboDAO;
import br.com.unip.garage.dados.UsuarioDAO;
import br.com.unip.garage.model.Carro;
import br.com.unip.garage.model.Freio;
import br.com.unip.garage.model.Motor;
import br.com.unip.garage.model.Pistao;
import br.com.unip.garage.model.Pneu;
import br.com.unip.garage.model.Turbo;
import br.com.unip.garage.model.Usuario;

/**
 * Created by caique on 10/10/16.
 */

public class InicializaBD {

    public void inicializaBanco(Context context) {
        inicializaFreio();
        inicializaMotor();
        inicializaPistao();
        inicializaPneu();
        inicializaTurbina();
        inicializaCarros();
        inicializaUsuario();
    }

    private void inicializaUsuario() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        if (isListNull(usuarioDAO)) {
            Usuario usuario = new Usuario();
            usuario.setNivel(1);
            usuario.setDinheiro(1000);
            usuarioDAO.insere(usuario);
        }
    }

    private void inicializaCarros() {
        CarroDAO carroDAO = new CarroDAO();
        if (isListNull(carroDAO)) {

            Carro carro1 = new BuilderCarro().icone(String.valueOf(R.drawable.icone_vermelho))
                    .carroImagem(String.valueOf(R.drawable.carro_vermelho))
                    .velocidade(140)
                    .capacidadeCombustivel(50)
                    .build();

            Carro carro2 = new BuilderCarro().icone(String.valueOf(R.drawable.icone_amarelo))
                    .carroImagem(String.valueOf(R.drawable.carro_amarelo))
                    .velocidade(120)
                    .capacidadeCombustivel(60)
                    .build();

            Carro carro3 = new BuilderCarro().icone(String.valueOf(R.drawable.icone_verde))
                    .carroImagem(String.valueOf(R.drawable.carro_verde))
                    .velocidade(90)
                    .capacidadeCombustivel(70)
                    .build();

            Carro carro4 = new BuilderCarro().icone(String.valueOf(R.drawable.icone_azul))
                    .carroImagem(String.valueOf(R.drawable.carro_azul))
                    .velocidade(70)
                    .capacidadeCombustivel(80)
                    .build();

            carroDAO.insere(carro1);
            carroDAO.insere(carro2);
            carroDAO.insere(carro3);
            carroDAO.insere(carro4);
        }
    }

    private void inicializaFreio() {
        FreioDAO freioDAO = new FreioDAO();
        if (isListNull(freioDAO)) {
            Freio freioAmador = new Freio(String.valueOf(R.drawable.freio_basic), 1, 149, -10, 5);
            Freio freioIntermediario = new Freio(String.valueOf(R.drawable.freio_silver), 5, 279, -15, 7);
            Freio freioProfissional = new Freio(String.valueOf(R.drawable.freio_gold), 8, 500, -20, 8);
            freioDAO.insere(freioAmador);
            freioDAO.insere(freioIntermediario);
            freioDAO.insere(freioProfissional);
        }
    }

    private void inicializaMotor() {
        MotorDAO motorDAO = new MotorDAO();
        if (isListNull(motorDAO)) {
            Motor motorAmador = new Motor(String.valueOf(R.drawable.motor_basic), 1, 399, 13, 20);
            Motor motorIntermediario = new Motor(String.valueOf(R.drawable.motor_silver), 6, 675, 16, 30);
            Motor motorProfissional = new Motor(String.valueOf(R.drawable.motor_gold), 10, 900, 20, 50);
            motorDAO.insere(motorAmador);
            motorDAO.insere(motorIntermediario);
            motorDAO.insere(motorProfissional);
        }
    }

    private void inicializaPistao() {
        PistaoDAO pistaoDAO = new PistaoDAO();
        if (isListNull(pistaoDAO)) {
            Pistao pistaoAmador = new Pistao(String.valueOf(R.drawable.pistao_basic), 1, 119, 10);
            Pistao pistaoIntermediario = new Pistao(String.valueOf(R.drawable.pistao_silver), 4, 249, 15);
            Pistao pistaoProfissional = new Pistao(String.valueOf(R.drawable.pistao_gold), 8, 330, 25);
            pistaoDAO.insere(pistaoAmador);
            pistaoDAO.insere(pistaoIntermediario);
            pistaoDAO.insere(pistaoProfissional);
        }
    }

    private void inicializaPneu() {
        PneuDAO pneuDAO = new PneuDAO();
        if (isListNull(pneuDAO)) {
            Pneu pneuAmador = new Pneu(String.valueOf(R.drawable.pneu_basic), 1, 499, 50, 15, 10);
            Pneu pneuIntermediario = new Pneu(String.valueOf(R.drawable.pneu_silver), 6, 799, 65, 20, 15);
            Pneu pneuProfissional = new Pneu(String.valueOf(R.drawable.pneu_gold), 10, 999, 85, 25, 20);
            pneuDAO.insere(pneuAmador);
            pneuDAO.insere(pneuIntermediario);
            pneuDAO.insere(pneuProfissional);
        }
    }

    private void inicializaTurbina() {
        TurboDAO turboDAO = new TurboDAO();
        if (isListNull(turboDAO)) {
            Turbo turboAmador = new Turbo(String.valueOf(R.drawable.turbo_basic), 3, 299, 30, -20, 3);
            Turbo turboIntermediario = new Turbo(String.valueOf(R.drawable.turbo_silver), 7, 599, 45, -22, 6);
            Turbo turboProfissional = new Turbo(String.valueOf(R.drawable.turbo_gold), 14, 1200, 90, -28, 8);
            turboDAO.insere(turboAmador);
            turboDAO.insere(turboIntermediario);
            turboDAO.insere(turboProfissional);
        }
    }

    private boolean isListNull(TemplateDAO templateDAO) {
        return templateDAO.busca().isEmpty();
    }
}
