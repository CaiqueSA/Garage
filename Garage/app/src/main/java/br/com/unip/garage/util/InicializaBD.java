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
import br.com.unip.garage.enumeration.NivelPeca;
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
        inicializaFreio(context);
        inicializaMotor(context);
        inicializaPistao(context);
        inicializaPneu(context);
        inicializaTurbina(context);
        inicializaCarros(context);
        inicializaUsuario(context);
    }

    private void inicializaUsuario(Context context) {
        UsuarioDAO usuarioDAO = new UsuarioDAO(context);
        if (isListNull(usuarioDAO)) {
            Usuario usuario = new Usuario();
            usuario.setNivel(1);
            usuario.setDinheiro(1000);
            usuarioDAO.insere(usuario);
        }
    }

    private void inicializaCarros(Context context) {
        CarroDAO carroDAO = new CarroDAO(context);
        if (isListNull(carroDAO)) {

            Carro carro1 = new BuilderCarro().icone("icone_azul")
                    .carroImagem("carro_azul")
                    .velocidade(70)
                    .capacidadeCombustivel(80)
                    .build();

            Carro carro2 = new BuilderCarro().icone("icone_amarelo")
                    .carroImagem("carro_amarelo")
                    .velocidade(120)
                    .capacidadeCombustivel(60)
                    .build();

            Carro carro3 = new BuilderCarro().icone("icone_verde")
                    .carroImagem("carro_verde")
                    .velocidade(90)
                    .capacidadeCombustivel(70)
                    .build();

            Carro carro4 = new BuilderCarro().icone("icone_vermelho")
                    .carroImagem("carro_vermelho")
                    .velocidade(140)
                    .capacidadeCombustivel(50)
                    .build();

            carroDAO.insere(carro1);
            carroDAO.insere(carro2);
            carroDAO.insere(carro3);
            carroDAO.insere(carro4);
        }
    }

    private void inicializaFreio(Context context) {
        FreioDAO freioDAO = new FreioDAO(context);
        if (isListNull(freioDAO)) {
            Freio freioAmador = new Freio("freio_basic", 1, 149, -10, 5, NivelPeca.AMADOR);
            Freio freioIntermediario = new Freio("freio_silver", 5, 279, -15, 7, NivelPeca.INTERMEDIARIO);
            Freio freioProfissional = new Freio("freio_gold", 8, 500, -20, 8, NivelPeca.PROFISSIONAL);
            freioDAO.insere(freioAmador);
            freioDAO.insere(freioIntermediario);
            freioDAO.insere(freioProfissional);
        }
    }

    private void inicializaMotor(Context context) {
        MotorDAO motorDAO = new MotorDAO(context);
        if (isListNull(motorDAO)) {
            Motor motorAmador = new Motor("motor_basic", 1, 399, 13, 20, NivelPeca.AMADOR);
            Motor motorIntermediario = new Motor("motor_silver", 6, 675, 16, 30, NivelPeca.INTERMEDIARIO);
            Motor motorProfissional = new Motor("motor_gold", 10, 900, 20, 50, NivelPeca.PROFISSIONAL);
            motorDAO.insere(motorAmador);
            motorDAO.insere(motorIntermediario);
            motorDAO.insere(motorProfissional);
        }
    }

    private void inicializaPistao(Context context) {
        PistaoDAO pistaoDAO = new PistaoDAO(context);
        if (isListNull(pistaoDAO)) {
            Pistao pistaoAmador = new Pistao("pistao_basic", 1, 119, 10, NivelPeca.AMADOR);
            Pistao pistaoIntermediario = new Pistao("pistao_silver", 4, 249, 15, NivelPeca.INTERMEDIARIO);
            Pistao pistaoProfissional = new Pistao("pistao_gold", 8, 330, 25, NivelPeca.PROFISSIONAL);
            pistaoDAO.insere(pistaoAmador);
            pistaoDAO.insere(pistaoIntermediario);
            pistaoDAO.insere(pistaoProfissional);
        }
    }

    private void inicializaPneu(Context context) {
        PneuDAO pneuDAO = new PneuDAO(context);
        if (isListNull(pneuDAO)) {
            Pneu pneuAmador = new Pneu("pneu_basic", 1, 499, 50, 15, 10, NivelPeca.AMADOR);
            Pneu pneuIntermediario = new Pneu("pneu_silver", 6, 799, 65, 20, 15, NivelPeca.INTERMEDIARIO);
            Pneu pneuProfissional = new Pneu("pneu_gold", 10, 999, 85, 25, 20, NivelPeca.PROFISSIONAL);
            pneuDAO.insere(pneuAmador);
            pneuDAO.insere(pneuIntermediario);
            pneuDAO.insere(pneuProfissional);
        }
    }

    private void inicializaTurbina(Context context) {
        TurboDAO turboDAO = new TurboDAO(context);
        if (isListNull(turboDAO)) {
            Turbo turboAmador = new Turbo("turbo_basic", 3, 299, 30, -20, 3, NivelPeca.AMADOR);
            Turbo turboIntermediario = new Turbo("turbo_silver", 7, 599, 45, -22, 6, NivelPeca.INTERMEDIARIO);
            Turbo turboProfissional = new Turbo("turbo_gold", 14, 1200, 90, -28, 8, NivelPeca.PROFISSIONAL);
            turboDAO.insere(turboAmador);
            turboDAO.insere(turboIntermediario);
            turboDAO.insere(turboProfissional);
        }
    }

    private boolean isListNull(TemplateDAO templateDAO) {
        return templateDAO.busca().isEmpty();
    }
}
