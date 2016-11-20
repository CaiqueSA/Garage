package br.com.unip.garage.enumeration;

/**
 * Created by caique on 18/11/16.
 */

public enum NivelPeca {

    AMADOR, INTERMEDIARIO, PROFISSIONAL;

    public static NivelPeca getNivelPecaByString(String nivelPecaString) {
        for (NivelPeca nivelPeca : NivelPeca.values()) {
            if (nivelPeca.toString().equals(nivelPecaString)) {
                return nivelPeca;
            }
        }
        return null;
    }
}
