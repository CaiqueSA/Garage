package br.com.unip.garage.model;

/**
 * Created by caique on 05/11/16.
 */

public class PecaLoja {

    private final Integer idBackground;
    private final Integer idImagem;
    private final Boolean clicavel;

    public PecaLoja(Integer idBackground, Integer idImagem, Boolean clicavel) {
        this.idBackground = idBackground;
        this.idImagem = idImagem;
        this.clicavel = clicavel;
    }

    public Integer getIdBackground() {
        return idBackground;
    }

    public Integer getIdImagem() {
        return idImagem;
    }

    public Boolean getClicavel() {
        return clicavel;
    }
}
