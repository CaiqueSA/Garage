package br.com.unip.garage.modelo;

/**
 * Created by caique on 05/11/16.
 */

public class PecaLoja {

    private final int idBackground;
    private final int idImagem;

    public PecaLoja(int idBackground, int idImagem) {
        this.idBackground = idBackground;
        this.idImagem = idImagem;
    }

    public int getIdBackground() {
        return idBackground;
    }

    public int getIdImagem() {
        return idImagem;
    }
}
