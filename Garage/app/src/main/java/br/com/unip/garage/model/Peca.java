package br.com.unip.garage.model;

public abstract class Peca {

	private final Integer nivelDesbloqueio;
	private final Integer preco;
	private final String imagem;
	private final String imagemPequena;
	private Integer id;

	public Peca(String imagem, String imagemPequena, Integer nivelDesbloqueio, Integer preco) {
		super();
		this.imagem = imagem;
		this.imagemPequena = imagemPequena;
		this.nivelDesbloqueio = nivelDesbloqueio;
		this.preco = preco;
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

	public String getImagemPequena() {
		return imagemPequena;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
