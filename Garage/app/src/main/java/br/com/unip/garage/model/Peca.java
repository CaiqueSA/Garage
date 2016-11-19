package br.com.unip.garage.model;

import br.com.unip.garage.enumeration.NivelPeca;

public abstract class Peca {

	private final Integer nivelDesbloqueio;
	private final Integer preco;
	private final String imagem;
	private Integer id;
	private Boolean possui;
    private NivelPeca nivelPeca;

	public Peca(String imagem, Integer nivelDesbloqueio, Integer preco, NivelPeca nivelPeca) {
		super();
		this.imagem = imagem;
		this.nivelDesbloqueio = nivelDesbloqueio;
		this.preco = preco;
        this.nivelPeca = nivelPeca;
	}

    public Integer getNivelDesbloqueio() {
        return nivelDesbloqueio;
    }

    public Integer getPreco() {
        return preco;
    }

	public String getImagem() {
		return imagem;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getPossui() {
		return possui;
	}

	public void setPossui(Boolean possui) {
		this.possui = possui;
	}

    public NivelPeca getNivelPeca() {
        return nivelPeca;
    }

    public void setNivelPeca(NivelPeca nivelPeca) {
        this.nivelPeca = nivelPeca;
    }
}
