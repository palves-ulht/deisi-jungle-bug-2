package pt.ulusofona.lp2.deisiJungle;


import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class GameManager {


    private int tamanhoMapa;

    public void setTamanhoMapa(int tamanhoMapa) {
        this.tamanhoMapa = tamanhoMapa;
    }

    public int getTamanhoMapa() {
        return this.tamanhoMapa;
    }

    ArrayList<Especies> minhasEspecies = new ArrayList<>();
    ArrayList<Player> meusJogadores = new ArrayList<>();

    public String[][] getSpecies() {

        String[][] especies = new String[5][3];

        especies[0][0] = "E";
        especies[0][1] = "Elefante";
        especies[0][2] = "elephant.png";
        minhasEspecies.add(new Especies(especies[0][0].charAt(0), especies[0][1], especies[0][2]));

        especies[1][0] = "L";
        especies[1][1] = "Leão";
        especies[1][2] = "lion.png";
        minhasEspecies.add(new Especies(especies[1][0].charAt(0), especies[1][1], especies[1][2]));

        especies[2][0] = "T";
        especies[2][1] = "Tartaruga";
        especies[2][2] = "turtle.png";
        minhasEspecies.add(new Especies(especies[2][0].charAt(0), especies[2][1], especies[2][2]));

        especies[3][0] = "P";
        especies[3][1] = "Passaro";
        especies[3][2] = "bird.png";
        minhasEspecies.add(new Especies(especies[3][0].charAt(0), especies[3][1], especies[3][2]));

        especies[4][0] = "Z";
        especies[4][1] = "Tarzan";
        especies[4][2] = "tarzan.png";
        minhasEspecies.add(new Especies(especies[4][0].charAt(0), especies[4][1], especies[4][2]));

        return especies;
    }

    public boolean createInitialJungle(int jungleSize, int initialEnergy, String[][] playersInfo) {
        setTamanhoMapa(jungleSize);
        int cont = 0;
        for (String[] strings : playersInfo) {
            if (Integer.parseInt(strings[0]) < 0) {
                return false;
            }
            for (Player jogador : meusJogadores) {
                if (Integer.parseInt(strings[0]) == jogador.getIdentificador()) {
                    return false;
                }
            }
            if (strings[1] == null || strings[1].equals("")) {
                return false;
            }

            for (Especies especie : minhasEspecies) {
                if (strings[2].charAt(0) != especie.getIdentificador()) {
                    cont++;
                }
                if (cont == minhasEspecies.size()) {
                    return false;
                }
                meusJogadores.add(new Player(Integer.parseInt(strings[0]), strings[1], strings[0].charAt(0), initialEnergy));
            }
        }
        return true;
    }

    public int[] getPlayerIds(int squareNr) {
        int contador = 0;
        if (squareNr < 1 || squareNr > 6) {
            return new int[1];
        }
        for (Player jogadores : meusJogadores) {
            if (jogadores.getEtapa() > 0) {
                contador++;
            }
        }
        int[] arrayReturn = new int[contador];
        contador = 0;
        for (Player jogadores : meusJogadores) {
            if (jogadores.getEtapa() > 0) {
                arrayReturn[contador] = jogadores.getIdentificador();
            }
            contador++;
        }
        return arrayReturn;
    }

    public String[] getSquareInfo(int squareNr) {
        if (squareNr < 1 || squareNr > 6) {
            return null;
        }
        FileMapa[] minhasInformacao = new FileMapa[getTamanhoMapa()];
        for (int contador = 0; contador < minhasInformacao.length; contador++) {
            if (contador == minhasInformacao.length - 1) {
                minhasInformacao[contador] = new FileMapa("finish.png", "Meta", "");
            } else {
                minhasInformacao[contador] = new FileMapa("blank.png", "Vazio", "");
            }
        }
        return new String[]{Arrays.toString(minhasInformacao)};
    }

    public String[] getPlayerInfo(int playerId) {
        String[] getInformationPlayer = new String[4];
        if (meusJogadores != null) {
            for (Player players : meusJogadores) {
                if (playerId == players.getIdentificador()) {
                    getInformationPlayer[0] = String.valueOf(players.getIdentificador());
                    getInformationPlayer[1] = players.getNome();
                    getInformationPlayer[2] = String.valueOf(players.getIdEspecie());
                    getInformationPlayer[3] = String.valueOf(players.getEnergia());
                    return getInformationPlayer;
                }
            }
        }
        return null;
    }

    public String[] getCurrentPlayerInfo() {
        String[] info = new String[4];
        for (Player jogador : meusJogadores) {
            if (jogador.getEtapa() == 1) {
                info[0] = String.valueOf(jogador.getIdentificador());
                info[1] = jogador.getNome();
                info[2] = String.valueOf(jogador.getIdEspecie());
                info[3] = String.valueOf(jogador.getEnergia());
                break;
            }
        }
        return info;
    }

    public String[][] getPlayersInfo() {
        int contador = 0;
        String[][] arrayRetornar = new String[meusJogadores.size()][4];
        for (Player jogador : meusJogadores) {
            arrayRetornar[contador][0] = String.valueOf(jogador.getIdentificador());
            arrayRetornar[contador][1] = jogador.getNome();
            arrayRetornar[contador][2] = String.valueOf(jogador.getIdEspecie());
            arrayRetornar[contador][3] = String.valueOf(jogador.getEnergia());
        }
        return arrayRetornar;
    }

    public boolean moveCurrentPlayer(int nrSquares, boolean bypassValidations) {
        if (!bypassValidations) {
            return nrSquares >= 1 && nrSquares <= 6;
        }


        return true;
    }

    public String[] getWinnerInfo() {
        return null;
    }

    public ArrayList<String> getGameResults() {
        return null;
    }

    public JPanel getAuthorsPanel() {
        return null;
    }

    public String whoIsTaborda() {
        return "Wrestling";
    }
}