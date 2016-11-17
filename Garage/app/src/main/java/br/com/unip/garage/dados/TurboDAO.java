package br.com.unip.garage.dados;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.NonNull;

import br.com.unip.garage.model.Turbo;

/**
 * Created by caique on 09/10/16.
 */

public class TurboDAO extends PecaDAO<Turbo> {

    //Nome da tabela
    private static final String TABELA = "TURBO";

    //Colunas da tabela freio
    private static final String COLUNA_VELOCIDADE = "VELOCIDADE";
    private static final String COLUNA_ESTABILIDADE = "ESTABILIDADE";
    private static final String COLUNA_TEMPO_TURBO = "TEMPO_TURBO";

    //SQL para criar a tabela
    private static final String CREATE_TABLE = "CREATE TABLE " +
            TABELA + " ( " +
            COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUNA_IMAGEM + " TEXT NOT NULL, " +
            COLUNA_NIVEL_DESBLOQUEIO + " INTEGER NOT NULL," +
            COLUNA_PRECO + " INTEGER NOT NULL, " +
            COLUNA_VELOCIDADE + " INTEGER NOT NULL, " +
            COLUNA_ESTABILIDADE + " INTEGER NOT NULL, " +
            COLUNA_TEMPO_TURBO + " INTEGER NOT NULL" +
            ")";

    public TurboDAO() {
        super(TABELA, CREATE_TABLE);
        colunas.add(COLUNA_VELOCIDADE);
        colunas.add(COLUNA_ESTABILIDADE);
        colunas.add(COLUNA_TEMPO_TURBO);
    }

    @NonNull
    @Override
    protected Turbo preenche(Cursor c) {
        Integer velocidade = c.getInt(c.getColumnIndex(COLUNA_VELOCIDADE));
        Integer estabilidade = c.getInt(c.getColumnIndex(COLUNA_ESTABILIDADE));
        Integer tempoTurbo = c.getInt(c.getColumnIndex(COLUNA_TEMPO_TURBO));
        Turbo turbo = new Turbo(getImagemByCursor(c), getNivelDesbloqueioByCursor(c), getPrecoByCursor(c), velocidade, estabilidade, tempoTurbo);
        turbo.setId(getIdByCursor(c));
        return turbo;
    }

    @Override
    public ContentValues getContentValues(Turbo turbo) {
        ContentValues dadosTurbo = super.getContentValuesPeca(turbo);
        dadosTurbo.put(COLUNA_VELOCIDADE, turbo.getVelocidade());
        dadosTurbo.put(COLUNA_ESTABILIDADE, turbo.getEstabilidade());
        dadosTurbo.put(COLUNA_TEMPO_TURBO, turbo.getTempoTurbo());
        return dadosTurbo;
    }
}
