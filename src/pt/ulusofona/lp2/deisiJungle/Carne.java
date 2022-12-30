package pt.ulusofona.lp2.deisiJungle;

public class Carne extends Alimentos {
    
    @Override
    public String getInfo(int jogadas) {
        if (jogadas > 12) {
            return "Carne toxica";
        } else {
            return "Carne : + 50 energia : " + jogadas + " jogadas";
        }
    }

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
    public int getPosicaoNoMapa() {
        return super.getPosicaoNoMapa();
    }

    @Override
    public String getIconAlimento() {
        return iconAlimento = "meat.png";
    }

    @Override
    public int getEfeitoEnergia(char especie, int energia, int jogadas,int nrSquare) {
        if (jogadas <= 12) {
            if (especie == 'L' || especie == 'Z' || especie == 'P' || especie == 'T') {
                energia += 50;
                return energia;
            }
        } else {
            if (especie == 'L' || especie == 'Z' || especie == 'P' || especie == 'T') {
                energia /= 2;
                return energia;
            }
        }
        return energia;
    }
}
