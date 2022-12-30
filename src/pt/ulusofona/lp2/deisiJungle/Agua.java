package pt.ulusofona.lp2.deisiJungle;

public class Agua extends Alimentos {
    protected String info;


    Agua(char identificador, String nomeAlimento, String iconAlimento) {
        super(identificador, nomeAlimento, iconAlimento);
    }

    Agua() {
    }

    @Override
    public int getPosicaoNoMapa() {
        return super.getPosicaoNoMapa();
    }

    @Override
    public int getEfeitoEnergia(char especie, int energia, int jogadas, int nrSquare) {
        if (especie == 'L' || especie == 'T' || especie == 'E') {
            energia = energia + 15;
        } else {
            energia = (int) (energia + energia * 0.2);
        }
        return energia;
    }

    @Override
    public String getInfo(int jogadas) {
        return "Agua : + 15U|20% energia";
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