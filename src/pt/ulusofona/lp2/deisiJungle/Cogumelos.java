package pt.ulusofona.lp2.deisiJungle;

import java.util.Random;

public class Cogumelos extends Alimentos {
    int numero;

    Cogumelos(char identificador, String nomeAlimento, String iconAlimento) {
        super(identificador, nomeAlimento, iconAlimento);
    }

    Cogumelos() {
    }

    public int getNumero() {
        Random valor = new Random();
        do {
            numero = valor.nextInt(50) + 1;
        } while (numero >= 10);
        return numero;
    }

    @Override
    public char getIdentificador() {
        return identificador = 'm';
    }

    @Override
    public String getNomeAlimento() {
        return nomeAlimento = "Cogumelos magicios";
    }

    @Override
    public String getIconAlimento() {
        return iconAlimento = "mushroom.png";
    }
}
