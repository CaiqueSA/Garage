package br.com.unip.garage.model;

import br.com.unip.garage.enumeration.NivelPeca;

public class Pistao extends Peca{

	private final Integer velocidade;
	
	public Pistao(String imagem, Integer nivelDesbloqueio, Integer preco, Integer velocidade,  Integer possui, NivelPeca nivelPeca) {
		super(imagem, nivelDesbloqueio, preco, possui, nivelPeca);
		this.velocidade = velocidade;
	}

	public Integer getVelocidade() {
		return velocidade;
	}
	
	
}
