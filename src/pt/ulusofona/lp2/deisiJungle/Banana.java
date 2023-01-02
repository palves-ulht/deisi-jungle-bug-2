package pt.ulusofona.lp2.deisiJungle;

public class Banana extends Alimentos {

    Banana(char identificador, String nomeAlimento, String iconAlimento) {
        super(identificador, nomeAlimento, iconAlimento);
    }

    @Override
    public String getInfo(int jogadas) {
        return "Bananas : " + getContaBananas() + " : + 40 energia";
    }

    @Override
    public int getPosicaoNoMapa() {
        return super.getPosicaoNoMapa();
    }

    Banana() {
    }

    @Override
    public int getContaBananas() {
        return super.getContaBananas();
    }

    @Override
    public void setContaBananas() {
        super.setContaBananas();
    }

    @Override
    public char getIdentificador() {
        return identificador = 'b';
    }


    @Override
    public String getNomeAlimento() {
        return nomeAlimento = "Bananas";
    }

    @Override
    public String getIconAlimento() {
        return iconAlimento = "bananas.png";
    }

    @Override
    public int getEfeitoEnergia(char especie, int energia, int jogadas, int nrQuare) {
        if (getContaBananas() > 0) {
            energia = energia + 40;
            if (energia >= 200) {
                energia = 200;
            }
            return energia;
        }
        return energia;
    }
}
