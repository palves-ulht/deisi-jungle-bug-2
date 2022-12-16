package pt.ulusofona.lp2.deisiJungle;

public class Cogumelos extends Alimentos {
    Cogumelos(char identificador, String nomeAlimento, String iconAlimento) {
        super(identificador, nomeAlimento, iconAlimento);
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
