package pt.ulusofona.lp2.deisiJungle;

public class Agua extends Alimentos {
    Agua(char identificador, String nomeAlimento, String iconAlimento) {
        super(identificador, nomeAlimento, iconAlimento);
    }

    @Override
    public char getIdentificador() {
        return identificador = 'a';
    }
    @Override
    public String getNomeAlimento() {
        return nomeAlimento = "Agua";
    }

    @Override
    public String getIconAlimento() {
        return iconAlimento = "water.png";
    }
}