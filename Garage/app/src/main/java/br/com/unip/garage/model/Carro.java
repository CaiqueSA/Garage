package br.com.unip.garage.model;

/**
 * Created by caique on 08/10/16.
 * Create object for builder {@link br.com.unip.garage.builder.BuilderCarro}
 */
public class Carro {

    //Representacao do carro
    private final String icone;
    private final String carroImagem;
    private Integer id;

    //Atributos gerais de carro
    private final Integer velocidade;
    private final Integer capacidadeCombustivel;

    //Pecas do carro
    private final Freio freio;
    private final Motor motor;
    private final Pistao pistao;
    private final Pneu pneu;
    private final Turbo turbo;

    public Carro(String icone, String carroImagem, Integer velocidade, Integer capacidadeCombustivel, Freio freio, Motor motor, Pistao pistao, Pneu pneu, Turbo turbo) {
        this.icone = icone;
        this.carroImagem = carroImagem;
        this.velocidade = velocidade;
        this.capacidadeCombustivel = capacidadeCombustivel;
        this.freio = freio;
        this.motor = motor;
        this.pistao = pistao;
        this.pneu = pneu;
        this.turbo = turbo;
    }

    public String getIcone() {
        return icone;
    }

    public String getCarroImagem() {
        return carroImagem;
    }

    public Integer getVelocidade() {
        return velocidade;
    }

    public Integer getCapacidadeCombustivel() {
        return capacidadeCombustivel;
    }

    public Freio getFreio() {
        return freio;
    }

    public Motor getMotor() {
        return motor;
    }

    public Pistao getPistao() {
        return pistao;
    }

    public Pneu getPneu() {
        return pneu;
    }

    public Turbo getTurbo() {
        return turbo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVelocidadeTotal() {
        Integer velocidadeTotal = null;
        velocidadeTotal = this.velocidade;

        if (this.freio != null) {
            velocidadeTotal -= freio.getFrenagem();
        }
        if (this.motor != null) {
            velocidadeTotal += motor.getVelocidade();
        }
        if (this.pistao != null) {
            velocidadeTotal += pistao.getVelocidade();
        }
        if (this.pneu != null) {
            velocidadeTotal += pneu.getVelocidade();
        }
        if (this.turbo != null) {
            velocidadeTotal += turbo.getVelocidade();
        }
        return velocidadeTotal;
    }
}

