import java.util.ArrayList;
import java.util.Scanner;

public class Partida{
    public static ArrayList<Casa> tabuleiro;
    public static ArrayList<Jogador> jogadores;
    private Jogador jogador_ativo;
    private Jogador segundo_jogador;

    public Partida(Jogador jogador1, Jogador jogador2){
        tabuleiro = new ArrayList<>();
        for(int i=0;i<8;++i){
            for(int j=0;j<8;++j){
                tabuleiro.add(i, new Casa(i, j));
            }
        }
        jogadores = new ArrayList<>();
        addJogador(jogador1);
        addJogador(jogador2);
        for (Jogador jogador : jogadores){
            if(jogador.cor == 0) {
                jogador_ativo = jogador;
            } else segundo_jogador = jogador;
        }
    }

    public void addJogador(Jogador jogador){
        if(jogadores.size() == 0){
            if (jogador.sentido == 1) {
                jogador.setCor(0);
            } else {
                jogador.setCor(1);
            }
            jogadores.add(jogador);
        } else if(jogadores.size() == 1){
            if (jogador.sentido == 1) {
                jogador.setCor(0);
            } else {
                jogador.setCor(1);
            }
            jogadores.add(jogador);
        }
    }

    public void setTabuleiro(){
        for(int i=0;i<8;++i){//linha
            for(int j=0;j<8;++j){//coluna
                for(int k=0;k<2;++k){//jogador
                    for(int l=0;l<12;++l){//pedras
                        if(jogadores.get(k).lista_pedras.get(l).casa.lin == i && jogadores.get(k).lista_pedras.get(l).casa.col == j){
                            tabuleiro.get(i*8+j).setPedra(jogadores.get(k).lista_pedras.get(l));
                        }
                    }
                }
            }
        }
    }

    public Boolean fimPartida(){
        return jogadores.get(0).lista_pedras.size() == 0 || jogadores.get(1).lista_pedras.size() == 0;
    }

    public static Casa getCasa(Integer lin, Integer col){
        Casa casa_alvo = new Casa(0, 0);

        for (Casa casa : tabuleiro) {
            if (casa.lin == lin && casa.col == col) {
                casa_alvo = casa;
            }
        }

        return casa_alvo;
    }

    protected void executaMovimento(Movimento movimento){
        //trocar casa em pedra em lista_pedras em jogador
        //trocar pedra_ocupante em casa em tabuleiro
        if(movimentoPermitido(movimento)){
            //altera a casa da pedra movida
            jogador_ativo.lista_pedras.get(jogador_ativo.lista_pedras.indexOf(movimento.pedra_movida)).casa = movimento.destino;
            tabuleiro.get(movimento.origem.lin*8+movimento.origem.col).pedra_ocupante.casa = movimento.destino;
            //altera a pedra na casa destino
            tabuleiro.get(movimento.destino.lin*8+movimento.destino.col).setPedra(movimento.pedra_movida);
            tabuleiro.get(movimento.origem.lin*8+movimento.origem.col).setPedra(null);
            //retira qualquer peça que tenha sido capturada no movimento
            for(Pedra pedra : movimento.pedras_capturadas){
                if(segundo_jogador.lista_pedras.contains(pedra)){
                    segundo_jogador.lista_pedras.remove(pedra);
                    getCasa(pedra.casa.lin, pedra.casa.col).setPedra(null);
                }
            }
        }
    }

    protected Boolean movimentoPermitido(Movimento movimento){
        //[[PedraPlayer], [MovLegal], [CasasValidas]]
        Boolean[] condic = new Boolean[3];

        //condic 1
        if(this.jogador_ativo.lista_pedras.contains(movimento.pedra_movida)){
            //System.out.println("Pedra do jogador: " + jogador_ativo.cor);
            condic[0] = true;
        } else condic[0] = false;

        //condic 2
        condic[1] = movimento.pedra_movida.podeMoverPara(movimento.destino);

        //condic 3
        int aux = 0;
        for(Casa casa : tabuleiro){
            if(tabuleiro.get(tabuleiro.indexOf(casa)).lin == movimento.origem.lin && tabuleiro.get(tabuleiro.indexOf(casa)).col == movimento.origem.col){
                aux += 1;
            }

            if(tabuleiro.get(tabuleiro.indexOf(casa)).lin == movimento.destino.lin && tabuleiro.get(tabuleiro.indexOf(casa)).col == movimento.destino.col){
                aux += 1;
            }
        } condic[2] = aux == 2 ? true : false;

        int cont = 0;
        for (Boolean aBoolean : condic) {
            if (aBoolean == true) ++cont;
        }
        return (cont == condic.length) ? true : false;
    }

    protected void jogar(){
        Scanner sc = new Scanner(System.in);

        while(!fimPartida()){
            String cor_ativa = this.jogador_ativo.cor == 0 ? "brancas" : "pretas";
            System.out.println("Jogador " + cor_ativa + " joga.");
            System.out.println("Pedra a ser movida: ");
            Integer[] pedra_movida = new Integer[] {sc.nextInt(), sc.nextInt()};
            //System.out.println(pedra_movida[0] + " " + pedra_movida[1]);
            System.out.println("Casa alvo: ");
            Integer[] casa_destino = new Integer[] {sc.nextInt(), sc.nextInt()};
            Movimento jogada_ativa = new Movimento(pedra_movida, casa_destino);
            if(!movimentoPermitido(jogada_ativa)){
                System.out.println("Movimento inválido");
                continue;
            } executaMovimento(jogada_ativa);
            printTabuleiro();

            //terminar a implementação do método
            System.out.println("Jogada: ");
            trocaTurno();
        }
    }

    protected void trocaTurno(){
        Jogador j1 = jogador_ativo;
        jogador_ativo = segundo_jogador;
        segundo_jogador = j1;
    }

    public static void printTabuleiro(){
        System.out.println("  01234567");
        for(int i=0;i<8;++i){
            System.out.print(i + " ");
            for(int j=0;j<8;++j){
                System.out.print(tabuleiro.get(i*8+j).simb);
            } System.out.println();
        }
    }
}