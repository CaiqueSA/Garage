package br.com.unip.garage.dados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;

import br.com.unip.garage.model.Pistao;

/**
 * Created by caique on 09/10/16.
 */

public class PistaoDAO extends PecaDAO<Pistao> {

    //Nome da tabela
    private static final String TABELA = "PISTAO";

    //Colunas da tabela freio
    private static final String COLUNA_VELOCIDADE = "VELOCIDADE";

    //SQL para criar a tabela
    private static final String CREATE_TABLE = "create table  " +
            TABELA + " (  " +
            COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUNA_IMAGEM + " TEXT NOT NULL, " +
            COLUNA_NIVEL_DESBLOQUEIO + " INTEGER NOT NULL," +
            COLUNA_PRECO + " INTEGER NOT NULL, " +
            COLUNA_VELOCIDADE + " INTEGER NOT NULL  " +
            ")";

    public PistaoDAO(Context context) {
        super(TABELA, CREATE_TABLE, context);
        colunas.add(COLUNA_VELOCIDADE);
    }

    @NonNull
    @Override
    protected Pistao preenche(Cursor c) {
        Integer velocidade = c.getInt(c.getColumnIndex(COLUNA_VELOCIDADE));
        Pistao pistao = new Pistao(getImagemByCursor(c), getNivelDesbloqueioByCursor(c), getPrecoByCursor(c), velocidade);
        pistao.setId(getIdByCursor(c));
        return pistao;
    }


    @NonNull
    @Override
    protected ContentValues getContentValues(Pistao pistao) {
        ContentValues dadosPistao = super.getContentValuesPeca(pistao);
        dadosPistao.put(PistaoDAO.COLUNA_VELOCIDADE, pistao.getVelocidade());
        return dadosPistao;
    }
}
