import java.util.ArrayList;

public class Main{
    public static void main(String[] args){

        Jogador jogador1 = new Jogador((Math.random() * 10) == 0);
        Jogador jogador2 = new Jogador(jogador1.sentido != 1);

        Partida partida = new Partida(jogador1, jogador2); jogador1.setPartida(partida); jogador2.setPartida(partida);
        partida.setTabuleiro();

        System.out.println(Partida.jogadores.get(0).getListaPedras());
        System.out.println(Partida.jogadores.get(1).getListaPedras());

        Partida.printTabuleiro();
        partida.jogar();
    }
}
