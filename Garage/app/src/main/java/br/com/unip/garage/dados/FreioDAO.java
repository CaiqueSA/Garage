package br.com.unip.garage.dados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;

import br.com.unip.garage.model.Freio;

/**
 * Created by caique on 09/10/16.
 */

public class FreioDAO extends PecaDAO<Freio> {

    //Nome da tabela
    private static final String TABELA = "FREIO";

    //Colunas da tabela freio
    private static final String COLUNA_FRENAGEM = "FRENAGEM";
    private static final String COLUNA_ESTABILIDADE = "ESTABILIDADE";

    //SQL para criar a tabela
    private static final String CREATE_TABLE = "create table " +
            TABELA + " ( " +
            COLUNA_ID + " integer primary key autoincrement, " +
            COLUNA_IMAGEM + " text not null, " +
            COLUNA_NIVEL_DESBLOQUEIO + " integer not null, " +
            COLUNA_PRECO + " integer not null, " +
            COLUNA_FRENAGEM + " integer not null, " +
            COLUNA_ESTABILIDADE + " integer not null " +
            ")";

    public FreioDAO() {
        super(TABELA, CREATE_TABLE);
        colunas.add(COLUNA_FRENAGEM);
        colunas.add(COLUNA_ESTABILIDADE);
    }

    @NonNull
    @Override
    protected Freio preenche(Cursor c) {
        Integer frenagem = c.getInt(c.getColumnIndex(COLUNA_FRENAGEM));
        Integer estabilidade = c.getInt(c.getColumnIndex(COLUNA_ESTABILIDADE));
        Freio freio = new Freio(getImagemByCursor(c), getNivelDesbloqueioByCursor(c), getPrecoByCursor(c), frenagem, estabilidade);
        freio.setId(getIdByCursor(c));
        return freio;
    }

    @NonNull
    @Override
    protected ContentValues getContentValues(Freio freio) {
        ContentValues dadosFreio = super.getContentValuesPeca(freio);
        dadosFreio.put(COLUNA_FRENAGEM, freio.getFrenagem());
        dadosFreio.put(COLUNA_ESTABILIDADE, freio.getEstabilidade());
        return dadosFreio;
    }
}