# Bug

Ver issue 1

## Metodologia

### Reproduzir o bug

Configurar o projeto de forma a arrancar o visualizador e conseguir reproduzir o que acontece no vídeo do issue 1.

### Rastrear a execução (colocar "sondas")

Para descobrirmos que funções são chamadas pelo visualizador, temos que colocar "sondas" na API.

Vamos colocar printlns em todas as funções "public" da classe GameManager (dica: usar o atalho do Intellij soutm seguido de tab)

### Automatizar

Acrescentar um teste unitário à classe TestGameManager que reproduza o bug.

Para reproduzir o bug, o teste deve carregar o ficheiro de jogo 'bananas.txt', verificar a tooltip das 2 casas com bananas (getSquareInfo()),
movimentar o jogador para a casa 3 (moveCurrentPlayer()) e voltar a verificar a tooltip das 2 casas com bananas.

```
@Test
public void comerBanana() {
    GameManager gm = new GameManager();
    gm.loadGame(new File("bananas.txt"));

    assertEquals("Bananas : ? : + 40 energia", gm.getSquareInfo(...)[1]);
    assertEquals(..., gm.getSquareInfo(...)[1]);

    // apanhou comida?
    assertEquals(MovementResultCode.???, gm.moveCurrentPlayer(2, false).code());

    assertEquals(..., gm.getSquareInfo(...)[1]);
    assertEquals(..., gm.getSquareInfo(...)[1]);
}
```

### Rastrear a execução

#### Passo 1

Vamos agora correr em debug com um breakpoint na linha do `moveCurrentPlayer` até chegarmos a esta parte:
```
food = new MovementResult(comida, "Apanhou " + alimento.getValue().getNomeAlimento());
if (alimento.getValue().getIdentificador() == 'b') {
    alimento.getValue().setContaBananas();
}
```
Verificamos que, estranhamente, o alimento atualizou bem a sua variável contaBananas.

#### Passo 2

O objeto alimento afetado pelo moveCurrentPlayer é o mesmo que é retornado pelo getSquareInfo?

Vamos colocar esta linha após as linhas do passo 1:
```
System.out.println("alimento (moveCurrentPlayer) = " + alimento);
```

E vamos colocar as linhas entre inicio e fim no getSquareInfo:
```
for (Map.Entry<Character, Alimentos> alimento : refeicoes().entrySet()) {
    if (String.valueOf(alimento.getValue().getIdentificador()).equals(meuMapa.get(squareNr))) {
        // início
        if (squareNr == 3) {
            System.out.println("alimento (getSquareInfo) = " + alimento);
        }
        // fim
        arrayRetornar[0] = alimento.getValue().getIconAlimento();
        arrayRetornar[1] = alimento.getValue().getInfo(jogadas);
    }
}
```

Ao correr o teste, apercebemo-nos que o objeto Banana é sempre diferente. Devia ser o mesmo...

#### Passo 3

De onde vem esse objeto? É criado no método refeicoes(). De cada vez que chamamos o refeicoes(), são colocados novos objetos
no hashmap. Isso só devia ser feito uma vez. Vamos mudar o método reset() para inicializar o hashmap e o método refeicoes() para apenas retornar o hashmap.

Corremos novamente o teste e já deve passar o assert que falhava antes. No entanto, falha no assert seguinte. Aparentemente, 
já diminui a quantidade de bananas mas afeta as 2 casas.

Faz sentido pois já vimos que o hashmap guarda um único objeto.

#### Passo 4

Fica como exercício alterar o programa para que existam objetos "banana" diferentes consoante a casa onde estão.

