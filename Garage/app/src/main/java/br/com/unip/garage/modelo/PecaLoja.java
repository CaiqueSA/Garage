package br.com.unip.garage.modelo;

/**
 * Created by caique on 05/11/16.
 */

public class PecaLoja {

    private final String background;
    private final String imagem;

    public PecaLoja(String background, String imagem) {
        this.background = background;
        this.imagem = imagem;
    }

    public String getBackground() {
        return background;
    }

    public String getImagem() {
        return imagem;
    }
}
