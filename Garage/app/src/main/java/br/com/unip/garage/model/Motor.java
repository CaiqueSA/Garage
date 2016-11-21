package br.com.unip.garage.model;

import br.com.unip.garage.enumeration.NivelPeca;

public class Motor extends Peca {

    private final Integer aceleracao;
    private final Integer velocidade;

    public Motor(String imagem, Integer nivelDesbloqueio, Integer preco, Integer aceleracao, Integer velocidade, Integer possui,  NivelPeca nivelPeca) {
        super(imagem, nivelDesbloqueio, preco, possui, nivelPeca);
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
