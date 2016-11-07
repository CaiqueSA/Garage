package br.com.unip.garage.builder;

import br.com.unip.garage.model.Carro;
import br.com.unip.garage.model.Freio;
import br.com.unip.garage.model.Motor;
import br.com.unip.garage.model.Pistao;
import br.com.unip.garage.model.Pneu;
import br.com.unip.garage.model.Turbo;


/**
 * Created by caique on 08/10/16.
 * This is a builder for class {@link Carro}, for create without error, utilize of all methods
 */

public class BuilderCarro {

    private Integer id;
    private String icone;
    private String carroImagem;
    private Integer velocidade;
    private Integer capacidadeCombustivel;
    private Freio freio;
    private Motor motor;
    private Pistao pistao;
    private Pneu pneu;
    private Turbo turbo;

    public BuilderCarro id(Integer id){
        this.id = id;
        return this;
    }

    public BuilderCarro icone(String icone){
        this.icone = icone;
        return this;
    }

    public BuilderCarro carroImagem(String carroImagem){
        this.carroImagem = carroImagem;
        return this;
    }

    public BuilderCarro velocidade(Integer velocidade){
        this.velocidade = velocidade;
        return this;
    }

    public BuilderCarro capacidadeCombustivel(Integer capacidadeCombustivel){
        this.capacidadeCombustivel = capacidadeCombustivel;
        return this;
    }

    public BuilderCarro freio(Freio freio){
        this.freio = freio;
        return this;
    }

    public BuilderCarro motor(Motor motor){
        this.motor = motor;
        return this;
    }

    public BuilderCarro pistao(Pistao pistao){
        this.pistao = pistao;
        return this;
    }

    public BuilderCarro pneu(Pneu pneu){
        this.pneu = pneu;
        return this;
    }

    public BuilderCarro turbo(Turbo turbo){
        this.turbo = turbo;
        return this;
    }

    public Carro build(){
        Carro carro = new Carro(icone, carroImagem, velocidade, capacidadeCombustivel, freio, motor, pistao, pneu, turbo);
        carro.setId(id);
        return carro;
    }
}
