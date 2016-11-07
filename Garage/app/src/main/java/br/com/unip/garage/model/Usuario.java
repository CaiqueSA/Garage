package br.com.unip.garage.model;

/**
 * Created by caique on 08/10/16.
 * Informações relacionadas ao usuário
 */
public class Usuario {

    private Integer id;
    private Integer dinheiro;
    private Integer nivel;
    private Integer idCarro;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(Integer dinheiro) {
        this.dinheiro = dinheiro;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Integer getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(Integer idCarro) {
        this.idCarro = idCarro;
    }
}
