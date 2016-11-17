package br.com.unip.garage.model;

public class Turbo extends Peca {

    private final Integer velocidade;
    private final Integer estabilidade;
    private final Integer tempoTurbo;

    public Turbo(String imagem, Integer nivelDesbloqueio,
                 Integer preco, Integer velocidade, Integer estabilidade, Integer tempoTurbo) {
        super(imagem, nivelDesbloqueio, preco);
        this.velocidade = velocidade;
        this.estabilidade = estabilidade;
        this.tempoTurbo = tempoTurbo;
    }

    public Integer getVelocidade() {
        return velocidade;
    }

    public Integer getEstabilidade() {
        return estabilidade;
    }

    public Integer getTempoTurbo() {
        return tempoTurbo;
    }
}
