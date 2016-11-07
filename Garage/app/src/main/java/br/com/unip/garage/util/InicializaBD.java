package br.com.unip.garage.util;

import android.content.Context;
import android.content.res.Resources;

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
        inicializaTurbo();
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

            Carro carro1 = new BuilderCarro().icone()
                    .carroImagem(ImagensCarros.CARRO_VERMELHO)
                    .velocidade(140)
                    .capacidadeCombustivel(50)
                    .build();

            Carro carro2 = new BuilderCarro().icone(ImagensCarros.ICONE_AMARELO)
                    .carroImagem(ImagensCarros.CARRO_AMARELO)
                    .velocidade(120)
                    .capacidadeCombustivel(60)
                    .build();

            Carro carro3 = new BuilderCarro().icone(ImagensCarros.ICONE_VERDE)
                    .carroImagem(ImagensCarros.CARRO_VERDE)
                    .velocidade(90)
                    .capacidadeCombustivel(70)
                    .build();

            Carro carro4 = new BuilderCarro().icone(ImagensCarros.ICONE_AZUL)
                    .carroImagem(ImagensCarros.CARRO_AZUL)
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
            Freio freioAmador = new Freio(ImagensPecas.FREIO_AMADOR, ImagensPecas.FREIO_AMADOR_PEQ, 1, 149, -10, 5);
            Freio freioIntermediario = new Freio(ImagensPecas.FREIO_INTERMEDIARIO, ImagensPecas.FREIO_INTERMEDIARIO_PEQ, 5, 279, -15, 7);
            Freio freioProfissional = new Freio(ImagensPecas.FREIO_PROFISSIONAL, ImagensPecas.FREIO_PROFISSIONAL_PEQ, 8, 500, -20, 8);
            freioDAO.insere(freioAmador);
            freioDAO.insere(freioIntermediario);
            freioDAO.insere(freioProfissional);
        }
    }

    private void inicializaMotor() {
        MotorDAO motorDAO = new MotorDAO();
        if (isListNull(motorDAO)) {
            Motor motorAmador = new Motor(ImagensPecas.MOTOR_AMADOR, ImagensPecas.MOTOR_AMADOR_PEQ, 1, 399, 13, 20);
            Motor motorIntermediario = new Motor(ImagensPecas.MOTOR_INTERMEDIARIO, ImagensPecas.MOTOR_INTERMEDIARIO_PEQ, 6, 675, 16, 30);
            Motor motorProfissional = new Motor(ImagensPecas.MOTOR_PROFISSIONAL, ImagensPecas.MOTOR_PROFISSIONAL_PEQ, 10, 900, 20, 50);
            motorDAO.insere(motorAmador);
            motorDAO.insere(motorIntermediario);
            motorDAO.insere(motorProfissional);
        }
    }

    private void inicializaPistao() {
        PistaoDAO pistaoDAO = new PistaoDAO();
        if (isListNull(pistaoDAO)) {
            Pistao pistaoAmador = new Pistao(ImagensPecas.PISTAO_AMADOR, ImagensPecas.PISTAO_AMADOR_PEQ, 1, 119, 10);
            Pistao pistaoIntermediario = new Pistao(ImagensPecas.PISTAO_INTERMEDIARIO, ImagensPecas.PISTAO_INTERMEDIARIO_PEQ, 4, 249, 15);
            Pistao pistaoProfissional = new Pistao(ImagensPecas.PISTAO_PROFISSIONAL, ImagensPecas.PISTAO_PROFISSIONAL_PEQ, 8, 330, 25);
            pistaoDAO.insere(pistaoAmador);
            pistaoDAO.insere(pistaoIntermediario);
            pistaoDAO.insere(pistaoProfissional);
        }
    }

    private void inicializaPneu() {
        PneuDAO pneuDAO = new PneuDAO();
        if (isListNull(pneuDAO)) {
            Pneu pneuAmador = new Pneu(ImagensPecas.PNEU_AMADOR, ImagensPecas.PNEU_AMADOR_PEQ, 1, 499, 50, 15, 10);
            Pneu pneuIntermediario = new Pneu(ImagensPecas.PNEU_INTERMEDIARIO, ImagensPecas.PNEU_INTERMEDIARIO_PEQ, 6, 799, 65, 20, 15);
            Pneu pneuProfissional = new Pneu(ImagensPecas.PNEU_PROFISSIONAL, ImagensPecas.PNEU_PROFISSIONAL_PEQ, 10, 999, 85, 25, 20);
            pneuDAO.insere(pneuAmador);
            pneuDAO.insere(pneuIntermediario);
            pneuDAO.insere(pneuProfissional);
        }
    }

    private void inicializaTurbo() {
        TurboDAO turboDAO = new TurboDAO();
        if (isListNull(turboDAO)) {
            Turbo turboAmador = new Turbo(ImagensPecas.TURBO_AMADOR, ImagensPecas.TURBO_AMADOR_PEQ, 3, 299, 30, -20, 3);
            Turbo turboIntermediario = new Turbo(ImagensPecas.TURBO_INTERMEDIARIO, ImagensPecas.TURBO_INTERMEDIARIO_PEQ, 7, 599, 45, -22, 6);
            Turbo turboProfissional = new Turbo(ImagensPecas.TURBO_PROFISSIONAL, ImagensPecas.TURBO_PROFISSIONAL_PEQ, 14, 1200, 90, -28, 8);
            turboDAO.insere(turboAmador);
            turboDAO.insere(turboIntermediario);
            turboDAO.insere(turboProfissional);
        }
    }

    private boolean isListNull(TemplateDAO templateDAO) {
        return templateDAO.busca().isEmpty();
    }
}
