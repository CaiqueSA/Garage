package br.com.unip.garage.model;

import br.com.unip.garage.enumeration.NivelPeca;

public class Freio extends Peca{

	private final Integer frenagem;
	private final Integer estabilidade;
	
	public Freio(String imagem, Integer nivelDesbloqueio, Integer preco, Integer frenagem, Integer estabilidade, NivelPeca nivelPeca) {
		super(imagem, nivelDesbloqueio, preco, nivelPeca);
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
