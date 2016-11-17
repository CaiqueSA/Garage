package br.com.unip.garage.model;

public class Freio extends Peca{

	private final Integer frenagem;
	private final Integer estabilidade;
	
	public Freio(String imagem, Integer nivelDesbloqueio, Integer preco, Integer frenagem, Integer estabilidade) {
		super(imagem, nivelDesbloqueio, preco);
		this.frenagem = frenagem;
        this.estabilidade = estabilidade;
	}

    public Integer getFrenagem() {
        return frenagem;
    }

    public Integer getEstabilidade() {
        return estabilidade;
    }
}
