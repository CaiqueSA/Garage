package br.com.unip.garage.model;

import br.com.unip.garage.enumeration.NivelPeca;

public class Pneu extends Peca {

	private Integer resistenciaPneu;
	private final Integer estabilidade;
	private final Integer velocidade;

	public Pneu(String imagem, Integer nivelDesbloqueio, Integer preco, Integer resistenciaPneu,
                Integer estabilidade, Integer velocidade,  Integer possui, NivelPeca nivelPeca) {
		super(imagem, nivelDesbloqueio, preco, possui, nivelPeca);
		this.resistenciaPneu = resistenciaPneu;
		this.estabilidade = estabilidade;
		this.velocidade = velocidade;
	}

    public Integer getResistenciaPneu() {
        return resistenciaPneu;
    }

    public void setResistenciaPneu(Integer resistenciaPneu) {
        this.resistenciaPneu = resistenciaPneu;
    }

    public Integer getEstabilidade() {
        return estabilidade;
    }

    public Integer getVelocidade() {
        return velocidade;
    }

}
