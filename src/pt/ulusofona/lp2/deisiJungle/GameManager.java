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

    HashMap<Character, Especies> minhasEspecies = new HashMap<>();
    HashMap<Character, String> minhasVelocidadePorIdEspecies = new HashMap<>();
    HashMap<Character, String> perdaEnergiaPorIdEspecies = new HashMap<>();
    HashMap<Character, String> ganhoEnergiaPorIdEspecie = new HashMap<>();

    HashMap<Character, String> minhasEnergiaPorIdEspecies = new HashMap<>();

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
        minhasVelocidadePorIdEspecies.put(especies[0][0].charAt(0), especies[0][6]);
        minhasEnergiaPorIdEspecies.put(especies[0][0].charAt(0), especies[0][3]);
        perdaEnergiaPorIdEspecies.put('E', especies[0][4]);
        ganhoEnergiaPorIdEspecie.put('E', especies[0][5]);

        especies[1][0] = "L";
        especies[1][1] = "Leão";
        especies[1][2] = "lion.png";
        especies[1][3] = "80";
        especies[1][4] = "2";
        especies[1][5] = "10";
        especies[1][6] = "4..6";
        Especies especies2 = new Especies();
        especies1.construtorSetando(especies[1][0].charAt(0), especies[1][1], Integer.parseInt(especies[1][3]));

        minhasEspecies.put('L', especies2);
        minhasVelocidadePorIdEspecies.put(especies[1][0].charAt(0), especies[1][6]);
        minhasEnergiaPorIdEspecies.put(especies[1][0].charAt(0), especies[1][3]);
        perdaEnergiaPorIdEspecies.put('L', especies[1][4]);
        ganhoEnergiaPorIdEspecie.put('L', especies[1][5]);

        especies[2][0] = "T";
        especies[2][1] = "Tartaruga";
        especies[2][2] = "turtle.png";
        especies[2][3] = "150";
        especies[2][4] = "1";
        especies[2][5] = "5";
        especies[2][6] = "1..3";
        Especies especies3 = new Especies();
        especies1.construtorSetando(especies[2][0].charAt(0), especies[2][1], Integer.parseInt(especies[2][3]));

        minhasEspecies.put('T', especies3);
        minhasVelocidadePorIdEspecies.put(especies[2][0].charAt(0), especies[2][6]);
        minhasEnergiaPorIdEspecies.put(especies[2][0].charAt(0), especies[2][3]);
        perdaEnergiaPorIdEspecies.put('T', especies[2][4]);
        ganhoEnergiaPorIdEspecie.put('T', especies[2][5]);

        especies[3][0] = "P";
        especies[3][1] = "Passaro";
        especies[3][2] = "bird.png";
        especies[3][3] = "70";
        especies[3][4] = "4";
        especies[3][5] = "50";
        especies[3][6] = "5..6";
        Especies especies4 = new Especies();
        especies1.construtorSetando(especies[3][0].charAt(0), especies[3][1], Integer.parseInt(especies[3][3]));

        minhasEspecies.put('P', especies4);
        minhasVelocidadePorIdEspecies.put(especies[3][0].charAt(0), especies[3][6]);
        minhasEnergiaPorIdEspecies.put(especies[3][0].charAt(0), especies[3][3]);
        perdaEnergiaPorIdEspecies.put('P', especies[3][4]);
        ganhoEnergiaPorIdEspecie.put('P', especies[3][5]);

        especies[4][0] = "Z";
        especies[4][1] = "Tarzan";
        especies[4][2] = "tarzan.png";
        especies[4][3] = "70";
        especies[4][4] = "2";
        especies[4][5] = "20";
        especies[4][6] = "1..6";
        Especies especies5 = new Especies();
        especies1.construtorSetando(especies[4][0].charAt(0), especies[4][1], Integer.parseInt(especies[4][3]));

        minhasEspecies.put('Z', especies5);
        minhasVelocidadePorIdEspecies.put(especies[4][0].charAt(0), especies[4][6]);
        minhasEnergiaPorIdEspecies.put(especies[4][0].charAt(0), especies[4][3]);
        perdaEnergiaPorIdEspecies.put('Z', especies[4][4]);
        ganhoEnergiaPorIdEspecie.put('Z', especies[4][5]);

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


        InitializationError error = new InitializationError();
        setTamanhoMapa(jungleSize);


        if (playersInfo.length < 2 || playersInfo.length > 4) {
            error.setMessage("Não Podemos Ter Menos de 2 Jogadores, Nem Mais de 4");
            return error;
        }
        if (jungleSize < playersInfo.length * 2) {
            error.setMessage("O Dobro do numero de jogadores não pode ser maior que o tamanho do Tabuleiro");
            return error;
        }
        int contadorTarzan = 0;
        for (String[] strings : playersInfo) {
            int id = Integer.parseInt(strings[0]);
            String nome = strings[1];
            char idEspecie = strings[2].charAt(0);

            Player first = new Player();
            first.setIdentificador(id);
            first.setNome(nome);
            first.setIdEspecie(idEspecie);
            first.setEnergiaInicial(Integer.parseInt(minhasEnergiaPorIdEspecies.get(first.getIdEspecie())));
            first.setPosicaoActual(1);
            first.setConsumoEnergia(perdaEnergiaPorIdEspecies.get(first.getIdEspecie()));
            first.setGanhoEnergiaEmDescanso(ganhoEnergiaPorIdEspecie.get(first.getIdEspecie()));
            first.setVelocidade(minhasVelocidadePorIdEspecies.get(first.getIdEspecie()));

            if (first.getNome() == null || first.getNome().isEmpty()) {
                error.setMessage("O Nome não pode ser null nem vazio");
                return error;
            }

            if (idEspecie != 'L' && idEspecie != 'Z' && idEspecie != 'T' && idEspecie != 'E' && idEspecie != 'P') {
                error.setMessage("O ID Da Espécie Não Pode Ser Diferente Daquelas Que A Função getEspecies() Retorna");
                return error;
            }
            if (first.getIdEspecie() == 'Z') {
                contadorTarzan++;
            }
            if (contadorTarzan > 1) {
                error.setMessage("Não pode existir mais de 1 Tarzan no Jogo");
                return error;
            }
            if (!minhaListaPlayers.containsKey(id)) {
                minhaListaPlayers.put(id, first);
                meusJogadores.add(first);
                meusJogadores.sort(Comparator.comparing(MeuJogador::getIdentificador));
            } else {
                error.setMessage("Não pode haver Jogadores com o mesmo ID");
                return error;
            }
        }

        setJogadorActual(0);
        String jogadoresNumaPosicao = "";
        for (int cont = 0; cont < playersInfo.length; cont++) {
            if (cont == playersInfo.length - 1) {
                jogadoresNumaPosicao += playersInfo[cont][0];
                break;
            }
            jogadoresNumaPosicao += playersInfo[cont][0] + ",";
        }
        meuMapa.put(1, jogadoresNumaPosicao);
        for (String[] value : foodsInfo) {
            if (minhasComidas.containsKey(value[0].charAt(0))) {
                meuMapa.put(Integer.parseInt(value[1]), value[0]);
            }
        }
        for (String[] strings : foodsInfo) {
            if (strings[0].charAt(0) != 'a' && strings[0].charAt(0) != 'c' && strings[0].charAt(0) != 'e' && strings[0].charAt(0) != 'b' && strings[0].charAt(0) != 'm') {
                error.setMessage("Os Alimentos devem ser os mesmos que a função getFoodTypes() retorna");
                return error;
            }
            if (Integer.parseInt(strings[1]) <= 1 && Integer.parseInt(strings[1]) >= tamanhoMapa) {
                error.setMessage("A Posição do alimento não pode ser inferior ou igual a 1, nem superior ou igual ao tamanho do Mapa");
                return error;
            }
        }

        return null;
    }

    public InitializationError createInitialJungle(int jungleSize, String[][] playersInfo) {
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
        if (squareNr <= 0 && squareNr > tamanhoMapa) {
            return null;
        }
        String[] arrayRetornar = new String[3];

        if (squareNr < tamanhoMapa) {
            if (meuMapa.get(squareNr) == null) {
                arrayRetornar[0] = "blank.png";
                arrayRetornar[1] = "Vazio";
            } else if (squareNr == 1) {
                arrayRetornar[0] = "blank.png";
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
        int consumo = 0;
        int ganhoEnergia = 0;

        for (Player meuJogador : meusJogadores) {
            if (meuJogador.getIdentificador() == getJogadorActual()) {
                for (int cont = 0; cont < nrPositions; cont++) {
                    if (meuJogador.getIdEspecie() == 'E') {
                        consumo += 4;
                    } else if (meuJogador.getIdEspecie() == 'L') {
                        consumo += 2;
                    } else if (meuJogador.getIdEspecie() == 'T') {
                        consumo += 1;
                    } else if (meuJogador.getIdEspecie() == 'P') {
                        consumo += 4;
                    } else if (meuJogador.getIdEspecie() == 'Z') {
                        consumo += 2;
                    }
                }
                if (meuJogador.getIdEspecie() == 'E') {
                    ganhoEnergia = 10;
                }
                if (meuJogador.getIdEspecie() == 'L') {
                    ganhoEnergia = 10;
                }
                if (meuJogador.getIdEspecie() == 'T') {
                    ganhoEnergia = 5;
                }
                if (meuJogador.getIdEspecie() == 'P') {
                    ganhoEnergia = 50;
                }
                if (meuJogador.getIdEspecie() == 'Z') {
                    ganhoEnergia = 20;
                }
            }
        }

        valueReturn[0] = String.valueOf(consumo);
        valueReturn[1] = String.valueOf(ganhoEnergia);

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

    public MovementResult moveCurrentPlayer(int nrSquares, boolean bypassValidations) {

        do {
            valorParaColgumelos = numerosAleatorios.nextInt(50);
        } while (valorParaColgumelos <= 10);


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
                for (int i = 0; i < meusJogadores.size(); i++) {
                    if ((meusJogadores.get(i).getPosicaoActual() + nrSquares) >= 1 && (meusJogadores.get(i).getPosicaoActual() + nrSquares) < tamanhoMapa) {
                        if (meusJogadores.get(i).getIdentificador() == getJogadorActual()) {
                            meusJogadores.get(i).setPosicaoActual(nrSquares);
                            if (nrSquares == 0) {
                                int energiaActual = meusJogadores.get(i).getEnergiaInicial() + Integer.parseInt(meusJogadores.get(i).getGanhoEnergiaEmDescanso());
                                meusJogadores.get(i).setEnergiaInicial(energiaActual);
                            }

                            if (meusJogadores.get(i).getEnergiaInicial() <= 0) {
                                return energy;
                            }

                            if (meuMapa.get(meusJogadores.get(i).getPosicaoActual()) != null) {
                                if (meuMapa.get(meusJogadores.get(i).getPosicaoActual()).equals("b")) {
                                    meuMapa.put(meusJogadores.get(i).getPosicaoActual(), null);
                                } else if (meuMapa.get(meusJogadores.get(i).getPosicaoActual()).equals("e")) {
                                    if (meusJogadores.get(i).getIdEspecie() == 'E' || meusJogadores.get(i).getIdEspecie() == 'T' || meusJogadores.get(i).getIdEspecie() == 'Z') {
                                        meusJogadores.get(i).setEnergiaInicial((meusJogadores.get(i).getEnergiaInicial() + 20));
                                    } else {
                                        meusJogadores.get(i).setEnergiaInicial((meusJogadores.get(i).getEnergiaInicial() - 20));
                                    }
                                    meuMapa.put(meusJogadores.get(i).getPosicaoActual(), null);
                                } else if (meuMapa.get(meusJogadores.get(i).getPosicaoActual()).equals("a")) {
                                    if (meusJogadores.get(i).getIdEspecie() == 'L' || meusJogadores.get(i).getIdEspecie() == 'P' || meusJogadores.get(i).getIdEspecie() == 'E') {
                                        meusJogadores.get(i).setEnergiaInicial((meusJogadores.get(i).getEnergiaInicial() + 15));
                                    } else {
                                        meusJogadores.get(i).setEnergiaInicial((int) (meusJogadores.get(i).getEnergiaInicial() + (meusJogadores.get(i).getEnergiaInicial() * (0.2))));
                                    }
                                    meuMapa.put(meusJogadores.get(i).getPosicaoActual(), null);
                                } else if (meuMapa.get(meusJogadores.get(i).getPosicaoActual()).equals("c")) {
                                    if (jogadas <= 12) {
                                        if (meusJogadores.get(i).getIdEspecie() == 'L' || meusJogadores.get(i).getIdEspecie() == 'Z' || meusJogadores.get(i).getIdEspecie() == 'T' || meusJogadores.get(i).getIdEspecie() == 'P') {
                                            meusJogadores.get(i).setEnergiaInicial((meusJogadores.get(i).getEnergiaInicial() + 50));
                                            meuMapa.put(meusJogadores.get(i).getPosicaoActual(), null);
                                        }
                                    } else {
                                        if (meusJogadores.get(i).getIdEspecie() == 'L' || meusJogadores.get(i).getIdEspecie() == 'Z' || meusJogadores.get(i).getIdEspecie() == 'T' || meusJogadores.get(i).getIdEspecie() == 'P') {
                                            meusJogadores.get(i).setEnergiaInicial((meusJogadores.get(i).getEnergiaInicial() / 2));
                                            meuMapa.put(meusJogadores.get(i).getPosicaoActual(), null);
                                        }
                                    }
                                } else if (meuMapa.get(meusJogadores.get(i).getPosicaoActual()).equals("m")) {
                                    if (nrSquares % 2 == 0) {
                                        meusJogadores.get(i).setEnergiaInicial(meusJogadores.get(i).getEnergiaInicial() + (meusJogadores.get(i).getEnergiaInicial() * (valorParaColgumelos / 100)));
                                    } else {
                                        meusJogadores.get(i).setEnergiaInicial(meusJogadores.get(i).getEnergiaInicial() - (meusJogadores.get(i).getEnergiaInicial() * (valorParaColgumelos / 100)));
                                    }

                                    meuMapa.put(meusJogadores.get(i).getPosicaoActual(), null);
                                }
                            }

                            int energiaActual = meusJogadores.get(i).getEnergiaInicial() - Integer.parseInt(meusJogadores.get(i).getConsumoEnergia()) * nrSquares;
                            meusJogadores.get(i).setEnergiaInicial(energiaActual);

                            if ((i + 1) == meusJogadores.size()) {
                                setJogadorActual(0);
                            } else {
                                setJogadorActual(i + 1);
                            }
                            jogadas++;
                            return validMoviment;
                        }

                    } else if ((meusJogadores.get(i).getPosicaoActual() + nrSquares) == tamanhoMapa) {
                        meusJogadores.get(i).setPosicaoActual(tamanhoMapa);
                    } else {
                        return invalidMoviment;
                    }
                }
            }
        }

        MovementResultCode m = MovementResultCode.NO_ENERGY;
        return new MovementResult(m, "");

    }

    public String[] getWinnerInfo() {
        String[] winner = new String[4];
        int cont = 0;
        for (Player meusJogadore : meusJogadores) {
            if (meusJogadore.getPosicaoActual() >= getTamanhoMapa()) {
                winner[0] = String.valueOf(meusJogadore.getIdentificador());
                winner[1] = meusJogadore.getNome();
                winner[2] = String.valueOf(meusJogadore.getIdEspecie());
                winner[3] = String.valueOf(meusJogadore.getEnergiaInicial());
                return winner;
            } else {
                cont++;
                if (cont == meusJogadores.size()) {
                    return null;
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