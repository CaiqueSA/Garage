package br.com.unip.garage.dados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import br.com.unip.garage.model.Usuario;

/**
 * Created by caique on 09/10/16.
 */

public class UsuarioDAO extends TemplateDAO<Usuario> {

    //Nome da tabela
    public static final String TABELA = "USUARIO";

    //Colunas da tabela usuario
    public static final String COLUNA_DINHEIRO = "DINHEIRO";
    public static final String COLUNA_NIVEL = "NIVEL";
    public static final String COLUNA_IDCARRO = "ID_CARRO";

    //SQL para criar a tabela
    private static final String CREATE_TABLE = "CREATE TABLE " +
            TABELA + " ( " +
            COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,  " +
            COLUNA_DINHEIRO + " INTEGER NOT NULL, " +
            COLUNA_NIVEL + " INTEGER NOT NULL, " +
            COLUNA_IDCARRO + " INTEGER" +
            ")";

    public UsuarioDAO() {
        super(TABELA, CREATE_TABLE);
        colunas.add(COLUNA_DINHEIRO);
        colunas.add(COLUNA_NIVEL);
        colunas.add(COLUNA_IDCARRO);
    }


    @Override
    public void insere(Usuario usuario) {
        open();
        ContentValues dadosUsuario = getContentValues(usuario);
        db.insert(TABELA, null, dadosUsuario);
        close();
    }

    @NonNull
    @Override
    protected ContentValues getContentValues(Usuario usuario) {
        ContentValues dadosUsuario = new ContentValues();
        dadosUsuario.put(COLUNA_DINHEIRO, usuario.getDinheiro());
        dadosUsuario.put(COLUNA_NIVEL, usuario.getNivel());
        dadosUsuario.put(COLUNA_IDCARRO, usuario.getIdCarro());
        return dadosUsuario;
    }

    @Override
    public List<Usuario> busca() {
        open();
        String sql = "SELECT * FROM " + TABELA + ";";
        Cursor c = db.rawQuery(sql, null);
        List<Usuario> usuarios = new ArrayList<>();
        while (c.moveToNext()) {
            Usuario usuario = preenche(c);
            usuarios.add(usuario);
        }
        c.close();
        close();
        return usuarios;
    }

    @NonNull
    @Override
    protected Usuario preenche(Cursor c) {
        Usuario usuario = new Usuario();
        usuario.setId(c.getInt(c.getColumnIndex(COLUNA_ID)));
        usuario.setDinheiro(c.getInt(c.getColumnIndex(COLUNA_DINHEIRO)));
        usuario.setNivel(c.getInt(c.getColumnIndex(COLUNA_NIVEL)));
        usuario.setIdCarro(c.getInt(c.getColumnIndex(COLUNA_IDCARRO)));
        return usuario;
    }

    @Override
    public void deleta(Usuario usuario) {
        open();
        String[] params = {usuario.getId().toString()};
        db.delete(TABELA, COLUNA_ID + " = ?", params);
        close();
    }

    @Override
    public void altera(Usuario usuario) {
        open();
        ContentValues dadosUsuario = getContentValues(usuario);
        String[] params = {usuario.getId().toString()};
        db.update(TABELA, dadosUsuario, COLUNA_ID + " = ?", params);
        close();
    }

    @Override
    public Usuario buscaPorId(String id) {
        open();
        String[] columns = new String[colunas.size()];
        columns = colunas.toArray(columns);
        Cursor c = db.query(TABELA, columns, COLUNA_ID + "=?", new String[]{id}, null, null, null, null);
        if (c != null) {
            c.moveToFirst();
            close();
            return preenche(c);
        }
        close();
        return null;
    }
}
