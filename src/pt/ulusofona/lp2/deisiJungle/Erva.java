package pt.ulusofona.lp2.deisiJungle;

public class Erva extends Alimentos {
    Erva(char identificador, String nomeAlimento, String iconAlimento) {
        super(identificador, nomeAlimento, iconAlimento);
    }

    String info;


    Erva() {
    }

    @Override
    public int getEfeitoEnergia(char especie, int energia, int jogadas, int nrSquare) {
        if (especie == 'L') {
            energia = energia - 20;
            if (energia >= 200) {
                energia = 200;
            }
            return energia;
        } else {
            energia = energia + 20;
            if (energia >= 200) {
                energia = 200;
            }
            return energia;
        }
    }

    @Override
    public int getPosicaoNoMapa() {
        return super.getPosicaoNoMapa();
    }

    @Override
    public String getInfo(int jogadas) {
        return "Erva : +- 20 energia";
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
