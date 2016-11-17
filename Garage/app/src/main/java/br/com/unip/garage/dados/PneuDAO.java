package br.com.unip.garage.dados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import br.com.unip.garage.model.Peca;
import br.com.unip.garage.model.Pneu;

/**
 * Created by caique on 09/10/16.
 */

public class PneuDAO extends PecaDAO<Pneu> {

    //Nome da tabela
    private static final String TABELA = "PNEU";

    //Colunas da tabela freio
    private static final String COLUNA_RESISTENCIA = "RESISTENCIA_PNEU";
    private static final String COLUNA_ESTABILIDADE = "ESTABILIDADE";
    private static final String COLUNA_VELOCIDADE = "VELOCIDADE";


    //SQL para criar a tabela
    private static final String CREATE_TABLE = "create table " +
            TABELA + " ( " +
            COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUNA_IMAGEM + " TEXT NOT NULL, " +
            COLUNA_NIVEL_DESBLOQUEIO + " INTEGER NOT NULL, " +
            COLUNA_PRECO + " INTEGER NOT NULL, " +
            COLUNA_RESISTENCIA + " INTEGER NOT NULL," +
            COLUNA_ESTABILIDADE + " INTEGER NOT NULL," +
            COLUNA_VELOCIDADE + " INTEGER NOT NULL" +
            ")";

    public PneuDAO(Context context) {
        super(TABELA, CREATE_TABLE, context);
        colunas.add(COLUNA_RESISTENCIA);
        colunas.add(COLUNA_ESTABILIDADE);
        colunas.add(COLUNA_VELOCIDADE);
    }


    @NonNull
    @Override
    protected Pneu preenche(Cursor c) {
        Integer resistenciaPneu = c.getInt(c.getColumnIndex(PneuDAO.COLUNA_RESISTENCIA));
        Integer estabilidade = c.getInt(c.getColumnIndex(PneuDAO.COLUNA_ESTABILIDADE));
        Integer velocidade = c.getInt(c.getColumnIndex(PneuDAO.COLUNA_VELOCIDADE));
        Pneu pneu = new Pneu(getImagemByCursor(c), getNivelDesbloqueioByCursor(c), getPrecoByCursor(c), resistenciaPneu, estabilidade, velocidade);
        pneu.setId(getIdByCursor(c));
        return pneu;
    }

    @NonNull
    @Override
    protected ContentValues getContentValues(Pneu peca) {
        ContentValues dadosPneu = super.getContentValuesPeca(peca);
        dadosPneu.put(COLUNA_RESISTENCIA, peca.getResistenciaPneu());
        dadosPneu.put(COLUNA_ESTABILIDADE, peca.getEstabilidade());
        dadosPneu.put(COLUNA_VELOCIDADE, peca.getVelocidade());
        return dadosPneu;
    }

}
