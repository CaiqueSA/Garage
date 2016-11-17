package br.com.unip.garage.model;

public class Motor extends Peca {

    private final Integer aceleracao;
    private final Integer velocidade;

    public Motor(String imagem, Integer nivelDesbloqueio, Integer preco, Integer aceleracao, Integer velocidade) {
        super(imagem, nivelDesbloqueio, preco);
        this.aceleracao = aceleracao;
        this.velocidade = velocidade;
    }

    public Integer getAceleracao() {
        return aceleracao;
    }

    public Integer getVelocidade() {
        return velocidade;
    }
}
