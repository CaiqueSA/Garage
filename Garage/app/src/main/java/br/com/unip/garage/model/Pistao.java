package br.com.unip.garage.model;

public class Pistao extends Peca{

	private final Integer velocidade;
	
	public Pistao(String imagem, Integer nivelDesbloqueio, Integer preco,Integer velocidade) {
		super(imagem, nivelDesbloqueio, preco);
		this.velocidade = velocidade;
	}

	public Integer getVelocidade() {
		return velocidade;
	}
	
	
}
