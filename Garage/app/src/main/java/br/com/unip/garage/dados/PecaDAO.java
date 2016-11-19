package br.com.unip.garage.dados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.text.BoringLayout;

import java.util.ArrayList;
import java.util.List;

import br.com.unip.garage.enumeration.NivelPeca;
import br.com.unip.garage.model.Peca;
import br.com.unip.garage.model.Pneu;

/**
 * Created by caique on 16/10/16.
 */

public abstract class PecaDAO<P extends Peca> extends TemplateDAO<P> {

    public static final String COLUNA_IMAGEM = "IMAGEM";
    public static final String COLUNA_NIVEL_DESBLOQUEIO = "NIVEL_DESBLOQUEIO";
    public static final String COLUNA_PRECO = "PRECO";
    public static final String COLUNA_POSSUI = "POSSUI";
    public static final String COLUNA_NIVEL = "NIVEL";

    public PecaDAO(final String tabela, final String sqlCreateTable, Context context) {
        super(tabela, sqlCreateTable, context);
        colunas.add(COLUNA_IMAGEM);
        colunas.add(COLUNA_NIVEL_DESBLOQUEIO);
        colunas.add(COLUNA_PRECO);
        colunas.add(COLUNA_POSSUI);
        colunas.add(COLUNA_NIVEL);
    }

    protected String getImagemByCursor(final Cursor c) {
        return c.getString(c.getColumnIndex(COLUNA_IMAGEM));
    }

    protected Integer getNivelDesbloqueioByCursor(final Cursor c) {
        return c.getInt(c.getColumnIndex(COLUNA_NIVEL_DESBLOQUEIO));
    }

    protected Integer getPrecoByCursor(final Cursor c) {
        return c.getInt(c.getColumnIndex(COLUNA_PRECO));
    }

    protected Boolean getPossuiByCursor(final Cursor c) {
        return Boolean.valueOf(c.getString(c.getColumnIndex(COLUNA_POSSUI)));
    }

    protected NivelPeca getNivelByCursor(final Cursor c) {
        return NivelPeca.valueOf(c.getString(c.getColumnIndex(COLUNA_NIVEL)));
    }

    @Override
    public void insere(Peca peca) {
        open();
        ContentValues dadosPeca = getContentValues((P) peca);
        db.insert(TABELA, null, dadosPeca);
        close();
    }

    @Override
    public void deleta(Peca peca) {
        open();
        String[] params = {peca.getId().toString()};
        db.delete(TABELA, COLUNA_ID + " = ?", params);
        close();
    }

    @Override
    public void altera(Peca peca) {
        open();
        ContentValues dadosMotor = getContentValues((P) peca);
        String[] params = {peca.getId().toString()};
        db.update(TABELA, dadosMotor, COLUNA_ID + " = ?", params);
        close();
    }

    @Override
    public P buscaPorId(String id) {
        Peca peca = null;
        Cursor c = null;
        try {
            open();
            String[] columns = new String[colunas.size()];
            columns = colunas.toArray(columns);
            c = db.query(TABELA, columns, COLUNA_ID + "=?", new String[]{id}, null, null, null, null);
            if (c != null) {
                c.moveToFirst();
                peca = preenche(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
            c.close();
        }
        return (P) peca;
    }

    @NonNull
    protected ContentValues getContentValuesPeca(Peca peca) {
        ContentValues dadosPeca = new ContentValues();
        dadosPeca.put(COLUNA_ID, peca.getId());
        dadosPeca.put(COLUNA_IMAGEM, peca.getImagem());
        dadosPeca.put(COLUNA_NIVEL_DESBLOQUEIO, peca.getNivelDesbloqueio());
        dadosPeca.put(COLUNA_PRECO, peca.getPreco());
        dadosPeca.put(COLUNA_POSSUI, peca.getPossui());
        dadosPeca.put(COLUNA_NIVEL_DESBLOQUEIO, peca.getNivelPeca().toString());
        return dadosPeca;
    }

    @Override
    public List<P> busca() {
        open();
        String sql = "SELECT * FROM " + TABELA + ";";
        Cursor c = db.rawQuery(sql, null);
        List<Peca> pecas = new ArrayList<>();
        while (c.moveToNext()) {
            Peca peca = preenche(c);
            pecas.add(peca);
        }
        c.close();
        close();
        return (List<P>) pecas;
    }

}