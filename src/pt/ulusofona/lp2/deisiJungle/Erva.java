package pt.ulusofona.lp2.deisiJungle;

public class Erva extends Alimentos {
    Erva(char identificador, String nomeAlimento, String iconAlimento) {
        super(identificador, nomeAlimento, iconAlimento);
    }

    @Override
    public char getIdentificador() {
        return identificador = 'e';
    }

    @Override
    public String getNomeAlimento() {
        return nomeAlimento = "Erva";
    }

    @Override
    public String getIconAlimento() {
        return iconAlimento = "grass.png";
    }
}
