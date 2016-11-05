package br.com.unip.garage.modelo;

/**
 * Created by caique on 05/11/16.
 */

public class PecaLoja {

    private final int idBackground;
    private final int idImagem;
    private final Boolean clicavel;

    public PecaLoja(int idBackground, int idImagem, Boolean clicavel) {
        this.idBackground = idBackground;
        this.idImagem = idImagem;
        this.clicavel = clicavel;
    }

    public int getIdBackground() {
        return idBackground;
    }

    public int getIdImagem() {
        return idImagem;
    }

    public Boolean getClicavel() {
        return clicavel;
    }
}
