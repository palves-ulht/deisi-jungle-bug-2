package pt.ulusofona.lp2.deisiJungle;

public class Carne extends Alimentos {
    Carne(char identificador, String nomeAlimento, String iconAlimento) {
        super(identificador, nomeAlimento, iconAlimento);
    }

    Carne() {
    }

    @Override
    public char getIdentificador() {
        return identificador = 'c';
    }

    @Override
    public String getNomeAlimento() {
        return nomeAlimento = "Carne";
    }

    @Override
    public String getIconAlimento() {
        return iconAlimento = "meat.png";
    }
}
