package br.com.unip.garage.dados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import br.com.unip.garage.builder.BuilderCarro;
import br.com.unip.garage.model.Carro;
import br.com.unip.garage.model.Freio;
import br.com.unip.garage.model.Motor;
import br.com.unip.garage.model.Pistao;
import br.com.unip.garage.model.Pneu;
import br.com.unip.garage.model.Turbo;


/**
 * Created by caique on 09/10/16.
 */

public class CarroDAO extends TemplateDAO<Carro> {

    private Context context;

    //Nome da tabela
    public static final String TABELA = "CARRO";
    //Colunas da tabrla carro
    public static final String COLUNA_ICONE = "ICONE";
    public static final String COLUNA_CARRO_IMAGEM = "CARRO_IMAGEM";
    public static final String COLUNA_VELOCIDADE = "VELOCIDADE";
    public static final String COLUNA_CAPACIDADE_COMBUSTIVEL = "CAPACIDADE_COMBUSTIVEL";
    public static final String COLUNA_IDMOTOR = "ID_MOTOR";
    public static final String COLUNA_IDFREIO = "ID_FREIO";
    public static final String COLUNA_IDPISTAO = "ID_PISTAO";
    public static final String COLUNA_IDTURBO = "ID_TURBO";

    public static final String COLUNA_IDPNEU = "ID_PNEU";
    //SQL para criar a tabela
    private static final String CREATE_TABLE = "CREATE TABLE " +
            TABELA + " (" +
            COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUNA_ICONE + " TEXT NOT NULL," +
            COLUNA_CARRO_IMAGEM + " TEXT NOT NULL," +
            COLUNA_VELOCIDADE + " INTEGER NOT NULL," +
            COLUNA_CAPACIDADE_COMBUSTIVEL + " INTEGER NOT NULL," +
            COLUNA_IDMOTOR + " INTEGER," +
            COLUNA_IDFREIO + " INTEGER," +
            COLUNA_IDPISTAO + " INTEGER," +
            COLUNA_IDTURBO + " INTEGER," +
            COLUNA_IDPNEU + " INTEGER" +
            ")";

    public CarroDAO(Context context) {
        super(TABELA, CREATE_TABLE, context);
        this.context = context;
        colunas.add(COLUNA_ICONE);
        colunas.add(COLUNA_CARRO_IMAGEM);
        colunas.add(COLUNA_VELOCIDADE);
        colunas.add(COLUNA_CAPACIDADE_COMBUSTIVEL);
        colunas.add(COLUNA_IDMOTOR);
        colunas.add(COLUNA_IDFREIO);
        colunas.add(COLUNA_IDPISTAO);
        colunas.add(COLUNA_IDTURBO);
        colunas.add(COLUNA_IDPNEU);
    }
    @Override
    public void insere(Carro carro) {
        open();
        ContentValues dadosCarro = getContentValues(carro);
        db.insert(TABELA, null, dadosCarro);
        close();
    }

    @NonNull
    @Override
    protected ContentValues getContentValues(Carro carro) {
        ContentValues dadosCarro = new ContentValues();
        dadosCarro.put(COLUNA_ICONE, carro.getIcone());
        dadosCarro.put(COLUNA_CARRO_IMAGEM, carro.getCarroImagem());
        dadosCarro.put(COLUNA_VELOCIDADE, carro.getVelocidade());
        dadosCarro.put(COLUNA_CAPACIDADE_COMBUSTIVEL, carro.getCapacidadeCombustivel());
        if (carro.getMotor() != null) {
            dadosCarro.put(COLUNA_IDMOTOR, carro.getMotor().getId());
        }
        if (carro.getFreio() != null) {
            dadosCarro.put(COLUNA_IDFREIO, carro.getFreio().getId());
        }
        if (carro.getPistao() != null) {
            dadosCarro.put(COLUNA_IDPISTAO, carro.getPistao().getId());
        }
        if (carro.getTurbo() != null) {
            dadosCarro.put(COLUNA_IDTURBO, carro.getTurbo().getId());
        }
        if (carro.getPneu() != null) {
            dadosCarro.put(COLUNA_IDPNEU, carro.getPneu().getId());
        }
        return dadosCarro;
    }

    @Override
    public List<Carro> busca() {
        open();
        String sql = "SELECT * FROM " + TABELA + ";";
        Cursor c = db.rawQuery(sql, null);
        List<Carro> carros = new ArrayList<>();
        while (c.moveToNext()) {
            Carro carro = preenche(c);
            carros.add(carro);
        }
        c.close();
        close();
        return carros;
    }

    @Override
    protected Carro preenche(Cursor c) {
        BuilderCarro builderCarro = new BuilderCarro();
        builderCarro.id(c.getInt(c.getColumnIndex(COLUNA_ID)))
                .icone(c.getString(c.getColumnIndex(COLUNA_ICONE)))
                .carroImagem(c.getString(c.getColumnIndex(COLUNA_CARRO_IMAGEM)))
                .velocidade(c.getInt(c.getColumnIndex(COLUNA_VELOCIDADE)))
                .capacidadeCombustivel(c.getInt(c.getColumnIndex(COLUNA_CAPACIDADE_COMBUSTIVEL)))
                .freio(getFreioById(c))
                .motor(getMotorById(c))
                .pistao(getPistaoById(c))
                .pneu(getPneuById(c))
                .turbo(getTurboById(c));
        Carro carro = null;
        try{
            carro =builderCarro.build();
        }catch (Exception e ){
            e.printStackTrace();
        }
        return carro;
    }

    public void deleta(Carro carro) {
        open();
        String[] params = {carro.getId().toString()};
        db.delete(TABELA, COLUNA_ID + " = ?", params);
        close();
    }

    public void altera(Carro carro) {
        open();
        ContentValues dadosCarro = getContentValues(carro);
        String[] params = {carro.getId().toString()};
        db.update(TABELA, dadosCarro, COLUNA_ID + " = ?", params);
        close();
    }

    private Pneu getPneuById(Cursor c) {
        PneuDAO pneuDAO = new PneuDAO(context);
        Integer pneuId = c.getInt(c.getColumnIndex(COLUNA_IDPNEU));
        if(pneuId == 0){
            return null;
        }
        return pneuDAO.buscaPorId(String.valueOf(pneuId));
    }

    private Turbo getTurboById(Cursor c) {
        TurboDAO turboDAO = new TurboDAO(context);
        Integer turboId = c.getInt(c.getColumnIndex(COLUNA_IDTURBO));
        if(turboId == 0){
            return null;
        }
        return turboDAO.buscaPorId(String.valueOf(turboId));
    }

    private Freio getFreioById(Cursor c) {
        FreioDAO freioDAO = new FreioDAO(context);
        Integer freioId = c.getInt(c.getColumnIndex(COLUNA_IDFREIO));
        if(freioId == 0){
            return null;
        }
        return freioDAO.buscaPorId(String.valueOf(freioId));
    }

    private Motor getMotorById(Cursor c) {
        MotorDAO motorDAO = new MotorDAO(context);
        Integer motorId = c.getInt(c.getColumnIndex(COLUNA_IDMOTOR));
        if(motorId == 0){
            return null;
        }
        return motorDAO.buscaPorId(String.valueOf(motorId));
    }

    private Pistao getPistaoById(Cursor c) {
        PistaoDAO pistaoDAO = new PistaoDAO(context);
        Integer pistaoId = c.getInt(c.getColumnIndex(COLUNA_IDPISTAO));
        if(pistaoId == 0){
            return null;
        }
        return pistaoDAO.buscaPorId(String.valueOf(pistaoId));
    }

    @Override
    public Carro buscaPorId(String id) {
        Cursor c = null;
        Carro carro = null;
        try{
            open();
            String[] columns = new String[colunas.size()];
            columns = colunas.toArray(columns);
            c = db.query(TABELA, columns, COLUNA_ID + "=?", new String[]{id}, null, null, null, null);
            if (c != null) {
                c.moveToFirst();
                carro = preenche(c);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close();
            c.close();
        }
        return carro;
    }
}

