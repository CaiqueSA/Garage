package br.com.unip.garage.model;

import br.com.unip.garage.enumeration.NivelPeca;

public abstract class Peca {

    private final Integer nivelDesbloqueio;
    private final Integer preco;
    private final String imagem;
    private Integer possui;
    private Integer id;
    private NivelPeca nivelPeca;

    public Peca(String imagem, Integer nivelDesbloqueio, Integer preco, Integer possui, NivelPeca nivelPeca) {
        super();
        this.imagem = imagem;
        this.nivelDesbloqueio = nivelDesbloqueio;
        this.preco = preco;
        this.possui = possui;
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
        if (possui == 0) {
            return Boolean.FALSE;
        } else {
            return Boolean.TRUE;
        }
    }

    public void setPossui(Boolean possui) {
        if (possui == Boolean.TRUE) {
            this.possui = 1;
        } else {
            this.possui = 0;
        }
    }

    public NivelPeca getNivelPeca() {
        return nivelPeca;
    }

    public void setNivelPeca(NivelPeca nivelPeca) {
        this.nivelPeca = nivelPeca;
    }
}
