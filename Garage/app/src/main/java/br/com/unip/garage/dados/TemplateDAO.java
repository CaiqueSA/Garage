package br.com.unip.garage.dados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by caique on 10/10/16.
 */

public abstract class TemplateDAO<Object> extends SQLiteOpenHelper {

    public static final String COLUNA_ID = "ID";
    private static String CREATE_TABLE = null;
    protected final String TABELA;
    protected List<String> colunas = new ArrayList<String>();

    // Versao atual do banco de dados (Utilizada para controle e atualizacao de
    // bancos posteriormente)
    private static final int DATABASE_VERSION = 1;

    protected SQLiteDatabase db;

    public TemplateDAO(final String tabela, String sqlCreateTable, Context context) {
        super(context, tabela, null, DATABASE_VERSION);
        colunas.add(COLUNA_ID);
        this.CREATE_TABLE = sqlCreateTable;
        TABELA = tabela;
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versaoAntiga, int novaVersao) {
        db.execSQL("DROP TABLE IF EXISTS  " + TABELA);
        onCreate(db);
    }

    protected Integer getIdByCursor(Cursor c) {
        return c.getInt(c.getColumnIndex(COLUNA_ID));
    }

    /**
     * Inicia conexao com o banco de dados
     *
     * @throws SQLException
     */
    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    /**
     * Finaliza a conexao com o banco de dados
     */
    public void close() {
        db.close();
    }

    /**
     * Este metodo é implementado pelos filhos
     * Percorre cursor retornando Objeto, de acordo com a classe
     *
     * @param c
     * @return
     */
    @NonNull
    protected abstract Object preenche(Cursor c);

    /**
     * Este metodo é implementado pelos filhos
     * Retorna ContentValues do objeto passado
     *
     * @param obj
     * @return {@link ContentValues}
     */
    @NonNull
    protected abstract ContentValues getContentValues(Object obj);

    /**
     * Este metodo é implementado pelos filhos
     * Deleta objeto informado do banco
     *
     * @param obj
     */
    public abstract void insere(Object obj);

    /**
     * Este metodo é implementado pelos filhos
     * Deleta objeto informado do banco
     *
     * @param obj
     */
    public abstract void deleta(Object obj);

    /**
     * Este metodo é implementado pelos filhos
     * Altera objeto informado no banco
     *
     * @param obj
     */
    public abstract void altera(Object obj);

    /**
     * Este metodo é implementado pelos filhos
     * Busca objeto de acordo com o id informado
     *
     * @param {@link {@link Object}}
     */
    public abstract Object buscaPorId(String id);

    /**
     * Este metodo é implementado pelos filhos
     * Devendo retornar uma lista de objetos de acordo com a classe
     *
     * @return {@link List}
     */
    public abstract List<Object> busca();
}
