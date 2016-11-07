package br.com.unip.garage.dados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;

import br.com.unip.garage.model.Motor;

/**
 * Created by caique on 09/10/16.
 */

public class MotorDAO extends PecaDAO<Motor> {

    //Nome da tabela
    public static final String TABELA = "MOTOR";

    //Colunas da tabela freio
    public static final String COLUNA_ACELERACAO = "ACELERACAO";
    public static final String COLUNA_VELOCIDADE = "VELOCIDADE";

    //SQL para criar a tabela
    private static final String CREATE_TABLE = "create table " +
            TABELA + " ( " +
            COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUNA_IMAGEM + " TEXT NOT NULL, " +
            COLUNA_IMAGEM_PEQUENA + " TEXT NOT NULL, " +
            COLUNA_NIVEL_DESBLOQUEIO + " INTEGER NOT NULL, " +
            COLUNA_PRECO + " INTEGER NOT NULL, " +
            COLUNA_ACELERACAO + " INTEGER NOT NULL, " +
            COLUNA_VELOCIDADE + " INTEGER NOT NULL " +
            ")";

    public MotorDAO() {
        super(TABELA, CREATE_TABLE);
        colunas.add(COLUNA_ACELERACAO);
        colunas.add(COLUNA_VELOCIDADE);
    }

    @NonNull
    @Override
    protected Motor preenche(Cursor c) {
        Integer velocidade = c.getInt(c.getColumnIndex(COLUNA_VELOCIDADE));
        Integer aceleracao = c.getInt(c.getColumnIndex(COLUNA_ACELERACAO));
        Motor motor = new Motor(getImagemByCursor(c), getImagemPeqByCursor(c), getNivelDesbloqueioByCursor(c), getPrecoByCursor(c), velocidade, aceleracao);
        motor.setId(getIdByCursor(c));
        return motor;
    }

    @NonNull
    @Override
    protected ContentValues getContentValues(Motor motor) {
        ContentValues dadosMotor = super.getContentValuesPeca(motor);
        dadosMotor.put(COLUNA_VELOCIDADE, motor.getVelocidade());
        dadosMotor.put(COLUNA_ACELERACAO, motor.getAceleracao());
        return dadosMotor;
    }




}
