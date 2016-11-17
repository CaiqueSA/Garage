package br.com.unip.garage.model;

public class Pneu extends Peca {

	private Integer resistenciaPneu;
	private final Integer estabilidade;
	private final Integer velocidade;

	public Pneu(String imagem, Integer nivelDesbloqueio,  Integer preco, Integer resistenciaPneu,
				Integer estabilidade, Integer velocidade) {
		super(imagem, nivelDesbloqueio, preco);
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
