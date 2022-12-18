package pt.ulusofona.lp2.deisiJungle;

public class Banana extends Alimentos {

    int contadorBananas;

    Banana(char identificador, String nomeAlimento, String iconAlimento) {
        super(identificador, nomeAlimento, iconAlimento);
    }

    Banana(int contadorBananas) {
        this.contadorBananas = contadorBananas;
    }

    @Override
    public char getIdentificador() {
        return identificador = 'b';
    }

    @Override
    public String getNomeAlimento() {
        return nomeAlimento = "Banana";
    }

    @Override
    public String getIconAlimento() {
        return iconAlimento = "bananas.png";
    }
}
