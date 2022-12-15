package pt.ulusofona.lp2.deisiJungle;

import javax.swing.*;
import java.io.File;
import java.util.*;

public class GameManager {
    private int tamanhoMapa;
    private int jogadorActual;

    public void setTamanhoMapa(int tamanhoMapa) {
        this.tamanhoMapa = tamanhoMapa;
    }

    public int getTamanhoMapa() {
        return this.tamanhoMapa;
    }

    public int getJogadorActual() {
        return this.jogadorActual;
    }

    int jogadas = 0;
    int valorParaColgumelos = 0;
    Random numerosAleatorios = new Random();
    HashMap<Character, String> minhasComidas = new HashMap<>();
    ArrayList<Alimentos> meusAlimentos = new ArrayList<>();
    HashMap<Integer, String> meuMapa = new HashMap<>();

    void setJogadorActual(int play) {
        jogadorActual = meusJogadores.get(play).getIdentificador();
    }

    public GameManager() {
    }

    boolean existeDuplicado(String[][] playersInfo) {
        for (int i = 0; i < playersInfo.length; i++) {
            for (int j = i + 1; j < playersInfo.length; j++) {
                try {
                    if (Integer.parseInt(playersInfo[i][0]) == Integer.parseInt(playersInfo[j][0])) {
                        return true;
                    }
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return false;
    }

    HashMap<Character, Especies> minhasEspecies = new HashMap<>();
    HashMap<Integer, Player> minhaListaPlayers = new HashMap<>();
    ArrayList<Player> meusJogadores = new ArrayList<>();

    public String[][] getSpecies() {
        String[][] especies = new String[5][7];
        especies[0][0] = "E";
        especies[0][1] = "Elefante";
        especies[0][2] = "elephant.png";
        especies[0][3] = "180";
        especies[0][4] = "4";
        especies[0][5] = "10";
        especies[0][6] = "1..6";
        Especies especies1 = new Especies();
        especies1.construtorSetando(especies[0][0].charAt(0), especies[0][1], Integer.parseInt(especies[0][3]));
        minhasEspecies.put('E', especies1);

        especies[1][0] = "L";
        especies[1][1] = "Leão";
        especies[1][2] = "lion.png";
        especies[1][3] = "80";
        especies[1][4] = "2";
        especies[1][5] = "10";
        especies[1][6] = "4..6";
        Especies especies2 = new Especies();
        especies2.construtorSetando(especies[1][0].charAt(0), especies[1][1], Integer.parseInt(especies[1][3]));
        minhasEspecies.put('L', especies2);

        especies[2][0] = "T";
        especies[2][1] = "Tartaruga";
        especies[2][2] = "turtle.png";
        especies[2][3] = "150";
        especies[2][4] = "1";
        especies[2][5] = "5";
        especies[2][6] = "1..3";
        Especies especies3 = new Especies();
        especies3.construtorSetando(especies[2][0].charAt(0), especies[2][1], Integer.parseInt(especies[2][3]));
        minhasEspecies.put('T', especies3);

        especies[3][0] = "P";
        especies[3][1] = "Passaro";
        especies[3][2] = "bird.png";
        especies[3][3] = "70";
        especies[3][4] = "4";
        especies[3][5] = "50";
        especies[3][6] = "5..6";
        Especies especies4 = new Especies();
        especies4.construtorSetando(especies[3][0].charAt(0), especies[3][1], Integer.parseInt(especies[3][3]));
        minhasEspecies.put('P', especies4);

        especies[4][0] = "Z";
        especies[4][1] = "Tarzan";
        especies[4][2] = "tarzan.png";
        especies[4][3] = "70";
        especies[4][4] = "2";
        especies[4][5] = "20";
        especies[4][6] = "1..6";
        Especies especies5 = new Especies();
        especies5.construtorSetando(especies[4][0].charAt(0), especies[4][1], Integer.parseInt(especies[4][3]));
        minhasEspecies.put('Z', especies5);

        return especies;
    }

    public String[][] getFoodTypes() {

        String[][] foods = new String[5][3];

        foods[0][0] = "b";
        foods[0][1] = "Banana";
        foods[0][2] = "bananas.png";
        Banana banana = new Banana(foods[0][0].charAt(0), foods[0][1], foods[0][2]);
        meusAlimentos.add(banana);
        minhasComidas.put(foods[0][0].charAt(0), foods[0][2]);

        foods[1][0] = "e";
        foods[1][1] = "Erva";
        foods[1][2] = "grass.png";
        Erva erva = new Erva(foods[1][0].charAt(0), foods[1][1], foods[1][2]);
        meusAlimentos.add(erva);
        minhasComidas.put(foods[1][0].charAt(0), foods[1][2]);

        foods[2][0] = "a";
        foods[2][1] = "Agua";
        foods[2][2] = "water.png";
        Agua agua = new Agua(foods[2][0].charAt(0), foods[2][1], foods[2][2]);
        meusAlimentos.add(agua);
        minhasComidas.put(foods[2][0].charAt(0), foods[2][2]);

        foods[3][0] = "c";
        foods[3][1] = "Carne";
        foods[3][2] = "meat.png";
        Carne carne = new Carne(foods[3][0].charAt(0), foods[3][1], foods[3][2]);
        meusAlimentos.add(carne);
        minhasComidas.put(foods[3][0].charAt(0), foods[3][2]);

        foods[4][0] = "m";
        foods[4][1] = "Cogumelos magicos";
        foods[4][2] = "mushroom.png";
        Cogumelos cogumelos = new Cogumelos(foods[4][0].charAt(0), foods[4][1], foods[4][2]);
        meusAlimentos.add(cogumelos);
        minhasComidas.put(foods[4][0].charAt(0), foods[4][2]);

        return foods;
    }

    public InitializationError createInitialJungle(int jungleSize, String[][] playersInfo, String[][] foodsInfo) {
        setTamanhoMapa(jungleSize);
        InitializationError error = new InitializationError();
        InitializationError secondFunction = createInitialJungle(jungleSize, playersInfo);
        if (secondFunction != null) {
            return secondFunction;
        }
        for (String[] value : foodsInfo) {
            if (value[0].charAt(0) != 'b' && value[0].charAt(0) != 'e' && value[0].charAt(0) != 'a' && value[0].charAt(0) != 'c' && value[0].charAt(0) != 'm') {
                error.setMessage("O id do alimento tem que ser um dos que foi retornado pela função getFoodTypes()");
                return error;
            }
        }
        for (String[] strings : foodsInfo) {
            try {
                if (Integer.parseInt(strings[1]) <= 1 || Integer.parseInt(strings[1]) >= tamanhoMapa) {
                    error.setMessage("Os alimentos têm que estar posicionados dentro dos limites do terreno");
                    return error;
                }
            } catch (Exception e) {
                error.setMessage("String fora do formato");
                return error;
            }
            meuMapa.put(Integer.parseInt(strings[1]), strings[0]);
        }
        return null;
    }

    int energiaRetornar(Player jogador) {
        if (jogador.getIdEspecie() == 'E') {
            return 180;
        } else if (jogador.getIdEspecie() == 'L') {
            return 80;
        } else if (jogador.getIdEspecie() == 'T') {
            return 150;
        } else if (jogador.getIdEspecie() == 'P') {
            return 70;
        } else {
            return 180;
        }
    }

    int perdaEnergia(Player jogador) {
        if (jogador.getIdEspecie() == 'E') {
            return 4;
        } else if (jogador.getIdEspecie() == 'L') {
            return 2;
        } else if (jogador.getIdEspecie() == 'T') {
            return 1;
        } else if (jogador.getIdEspecie() == 'P') {
            return 4;
        } else {
            return 2;
        }
    }

    int ganhoEnergia(Player jogador) {
        if (jogador.getIdEspecie() == 'E') {
            return 10;
        } else if (jogador.getIdEspecie() == 'L') {
            return 10;
        } else if (jogador.getIdEspecie() == 'T') {
            return 5;
        } else if (jogador.getIdEspecie() == 'P') {
            return 50;
        } else {
            return 20;
        }
    }

    String velocidades(Player jogador) {
        if (jogador.getIdEspecie() == 'E') {
            return "1..6";
        } else if (jogador.getIdEspecie() == 'L') {
            return "4..6";
        } else if (jogador.getIdEspecie() == 'T') {
            return "1..3";
        } else if (jogador.getIdEspecie() == 'P') {
            return "5..6";
        } else {
            return "1..6";
        }
    }

    public InitializationError createInitialJungle(int jungleSize, String[][] playersInfo) {
        int contadorTarzan = 0;
        InitializationError error = new InitializationError();
        setTamanhoMapa(jungleSize);
        if (existeDuplicado(playersInfo)) {
            error.setMessage("Não Podemos Ter Jogadores Com ID Iguais");
            return error;
        }
        if (playersInfo.length < 2 || playersInfo.length > 4) {
            error.setMessage("Não Podemos Ter Menos de 2 Jogadores, Nem Mais de 4");
            return error;
        }
        if (jungleSize < playersInfo.length * 2) {
            error.setMessage("O mapa tem de ter, pelo menos, duas posições por cada jogador que esteja em jogo.");
            return error;
        }
        for (String[] jogador : playersInfo) {
            Player players = new Player();
            try {
                players.setIdentificador(Integer.parseInt(jogador[0]));
            } catch (Exception e) {
                error.setMessage("Formato do ID Inesperado");
                return error;
            }
            players.setNome(jogador[1]);
            players.setIdEspecie(jogador[2].charAt(0));
            players.setEnergiaInicial(energiaRetornar(players));
            players.setConsumoEnergia(String.valueOf(perdaEnergia(players)));
            players.setGanhoEnergiaEmDescanso(String.valueOf(ganhoEnergia(players)));
            players.setPosicaoActual(1);
            players.setVelocidade(velocidades(players));

            if (Integer.parseInt(jogador[0]) < 0) {
                error.setMessage("O ID tem de ser um valor que pertenca à gama esperada.");
                return error;
            }
            if (jogador[1] == null || jogador[1].isEmpty()) {
                error.setMessage("Os nomes dos jogadores. Não podem ser null nem estar vazios.");
                return error;
            }
            if (jogador[2].charAt(0) != 'L' && jogador[2].charAt(0) != 'T' && jogador[2].charAt(0) != 'Z' && jogador[2].charAt(0) != 'E' && jogador[2].charAt(0) != 'P') {
                error.setMessage("A espécie tem que ser uma das que foi retornada pela função getSpecies()");
                return error;
            }
            if (players.getIdEspecie() == 'Z') {
                contadorTarzan++;
            }
            if (contadorTarzan > 1) {
                error.setMessage("Não pode existir mais de 1 Tarzan no Jogo");
                return error;
            }
            minhaListaPlayers.put(Integer.parseInt(jogador[0]), players);
            meusJogadores.add(players);
            meusJogadores.sort(Comparator.comparing(MeuJogador::getIdentificador));
        }
        setJogadorActual(0);
        return null;
    }

    public int[] getPlayerIds(int squareNr) {
        if (squareNr <= 0 || squareNr > tamanhoMapa) {
            return new int[0];
        }
        ArrayList<Integer> arrayAuxiliar = new ArrayList<>();
        for (Player players : meusJogadores) {
            if (players.getPosicaoActual() == squareNr) {
                arrayAuxiliar.add(players.getIdentificador());
            }
        }
        int[] meuArray = new int[arrayAuxiliar.size()];
        if (arrayAuxiliar.size() > 0) {
            for (int i = 0; i < arrayAuxiliar.size(); i++) {
                meuArray[i] = arrayAuxiliar.get(i);
            }
        }
        return meuArray;
    }

    public String[] getSquareInfo(int squareNr) {

        String[] arrayRetornar = new String[3];

        if (squareNr < tamanhoMapa) {
            if (meuMapa.get(squareNr) == null) {
                arrayRetornar[0] = "blank.png";
                arrayRetornar[1] = "Vazio";
            } else if (squareNr == 1) {
                arrayRetornar[0] = "blank.png";
                arrayRetornar[1] = "Vazio";
                for (int contador = 0; contador < meusJogadores.size(); contador++) {
                    if (contador == meusJogadores.size() - 1) {
                        arrayRetornar[2] += meusJogadores.get(contador).getIdentificador();
                        break;
                    }
                    arrayRetornar[2] += meusJogadores.get(contador).getIdentificador() + ",";
                }
            } else {
                for (Alimentos meusAlimentos : meusAlimentos) {
                    if (meusAlimentos.getIdentificador() == meuMapa.get(squareNr).charAt(0)) {
                        arrayRetornar[0] = meusAlimentos.getIconAlimento();
                        if (meusAlimentos.getIdentificador() == 'e') {
                            arrayRetornar[1] = "Erva : +- 20 energia";
                        } else if (meusAlimentos.getIdentificador() == 'a') {
                            arrayRetornar[1] = "Agua : + 10U|20% energia";
                        } else if (meusAlimentos.getIdentificador() == 'c') {
                            if (jogadas <= 12) {
                                arrayRetornar[1] = "Carne : +- 50 energia : " + jogadas + " jogadas";
                            } else {
                                arrayRetornar[1] = "Carne toxica";
                            }
                        } else if (meusAlimentos.getIdentificador() == 'm') {
                            arrayRetornar[1] = "Cogumelo Magico: +- " + valorParaColgumelos + "% energia";
                        } else {
                            arrayRetornar[1] = meusAlimentos.getNomeAlimento();
                        }
                        arrayRetornar[2] = String.valueOf(meusAlimentos.getIdentificador());
                    }
                }
            }
        } else if (squareNr == tamanhoMapa) {
            arrayRetornar[0] = "finish.png";
            arrayRetornar[1] = "Meta";
        }
        return arrayRetornar;
    }

    public String[] getPlayerInfo(int playerId) {
        String[] meuJogadorRetornar = new String[5];
        for (Player jogador : meusJogadores) {
            if (jogador.getIdentificador() == playerId) {
                meuJogadorRetornar[0] = String.valueOf(jogador.getIdentificador());
                meuJogadorRetornar[1] = jogador.getNome();
                meuJogadorRetornar[2] = String.valueOf(jogador.getIdEspecie());
                meuJogadorRetornar[3] = String.valueOf(jogador.getEnergiaInicial());
                meuJogadorRetornar[4] = String.valueOf(jogador.getVelocidade());
                return meuJogadorRetornar;
            }
        }
        return null;
    }

    public String[] getCurrentPlayerInfo() {
        String[] informationPlayer = new String[5];
        for (Player meusPlayers : meusJogadores) {
            if (meusPlayers.getIdentificador() == getJogadorActual()) {
                informationPlayer[0] = String.valueOf(meusPlayers.getIdentificador());
                informationPlayer[1] = meusPlayers.getNome();
                informationPlayer[2] = String.valueOf(meusPlayers.getIdEspecie());
                informationPlayer[3] = String.valueOf(meusPlayers.getEnergiaInicial());
                informationPlayer[4] = meusPlayers.getVelocidade();
            }
        }
        return informationPlayer;
    }

    public String[] getCurrentPlayerEnergyInfo(int nrPositions) {
        String[] valueReturn = new String[2];
        int consumo;
        int ganhoEnergia;
        for (Player meuJogador : meusJogadores) {
            if (meuJogador.getIdentificador() == getJogadorActual()) {
                consumo = Integer.parseInt(meuJogador.getConsumoEnergia()) * nrPositions;
                valueReturn[0] = String.valueOf(consumo).replace("-", "");
                ganhoEnergia = Integer.parseInt(meuJogador.getGanhoEnergiaEmDescanso());
                valueReturn[1] = String.valueOf(ganhoEnergia);
                break;
            }
        }
        return valueReturn;
    }

    public String[][] getPlayersInfo() {
        int contador = 0;
        String[][] arrayRetornar = new String[meusJogadores.size()][5];
        for (Player jogador : meusJogadores) {
            arrayRetornar[contador][0] = String.valueOf(jogador.getIdentificador());
            arrayRetornar[contador][1] = jogador.getNome();
            arrayRetornar[contador][2] = String.valueOf(jogador.getIdEspecie());
            arrayRetornar[contador][3] = String.valueOf(jogador.getEnergiaInicial());
            arrayRetornar[contador][4] = jogador.getVelocidade();
            contador++;
        }
        return arrayRetornar;
    }

    MovementResult movimentoValido(int nrSquares) {
        MovementResultCode energia = MovementResultCode.NO_ENERGY;
        MovementResult energy = new MovementResult(energia, "");
        MovementResultCode movimentoValido = MovementResultCode.VALID_MOVEMENT;
        MovementResult validMoviment = new MovementResult(movimentoValido, "");
        int contador = 0;
        for (Player meusJogadore : meusJogadores) {
            if (meusJogadore.getIdentificador() == getJogadorActual()) {
                if (nrSquares == 0) {
                    int x = Integer.parseInt(meusJogadore.getGanhoEnergiaEmDescanso());
                    meusJogadore.setEnergiaInicial(meusJogadore.getEnergiaInicial() + x);
                } else {
                    if (meusJogadore.getEnergiaInicial() < nrSquares) {
                        return energy;
                    } else {
                        meusJogadore.mover(nrSquares, meusJogadore, getJogadorActual());
                        int consumo = Integer.parseInt(getCurrentPlayerEnergyInfo(nrSquares)[0]);
                        int enerigaInicial = meusJogadore.getEnergiaInicial();
                        meusJogadore.setEnergiaInicial(enerigaInicial - consumo);
                    }
                }
                if ((contador + 1) == meusJogadores.size()) {
                    setJogadorActual(0);
                } else {
                    setJogadorActual(contador + 1);
                }
                break;
            }
            contador++;
        }
        return validMoviment;
    }

    public MovementResult moveCurrentPlayer(int nrSquares, boolean bypassValidations) {
        int consumo = Integer.parseInt(getCurrentPlayerEnergyInfo(nrSquares)[0]);
        MovementResultCode movimentoInvalido = MovementResultCode.INVALID_MOVEMENT;
        MovementResultCode movimentoValido = MovementResultCode.VALID_MOVEMENT;
        MovementResultCode alimento = MovementResultCode.CAUGHT_FOOD;
        MovementResultCode energia = MovementResultCode.NO_ENERGY;
        MovementResult invalidMoviment = new MovementResult(movimentoInvalido, "");
        MovementResult validMoviment = new MovementResult(movimentoValido, "");
        MovementResult food = new MovementResult(alimento, "");
        MovementResult energy = new MovementResult(energia, "");
        if (!bypassValidations) {
            if (nrSquares >= -6 && nrSquares <= 6) {
                return movimentoValido(nrSquares);
            } else {
                return null;
            }
        } else {
            return movimentoValido(nrSquares);
        }
    }

    public String[] getWinnerInfo() {
        String[] winner = new String[5];
        for (int contaMapa = 0; contaMapa < getTamanhoMapa(); contaMapa++) {
            for (Player meusJogadore : meusJogadores) {
                if (meusJogadore.getPosicaoActual() >= getTamanhoMapa()) {
                    winner[0] = String.valueOf(meusJogadore.getIdentificador());
                    winner[1] = meusJogadore.getNome();
                    winner[2] = String.valueOf(meusJogadore.getIdEspecie());
                    winner[3] = String.valueOf(meusJogadore.getEnergiaInicial());
                    winner[4] = String.valueOf(meusJogadore.getVelocidade());
                    return winner;
                }
            }
        }
        return null;
    }

    public ArrayList<String> getGameResults() {
        meusJogadores.sort(Comparator.comparingInt((Player::getPosicaoActual)).reversed());
        ArrayList<String> resultadoPartida = new ArrayList<>();
        String formato = "";
        for (Player meusJogadore : meusJogadores) {
            formato = meusJogadore.getNome() + ", " + meusJogadore.getIdEspecie() + ", " + meusJogadore.getPosicaoActual();
            resultadoPartida.add(formato);
        }
        return resultadoPartida;
    }

    public JPanel getAuthorsPanel() {
        return null;
    }

    public String whoIsTaborda() {
        return "Wrestling";
    }

    public boolean saveGame(File file) {
        return false;
    }

    public boolean loadGame(File file) {
        return false;
    }
}