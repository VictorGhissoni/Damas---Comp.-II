public class Pedra{
    public Jogador jogador;
    public Casa casa;
    public int sentido; //sentido próprio para usar na dama
    public Boolean dama;
    public Character simb;

    public Pedra(Jogador jogador, Casa casa, int sentido){
        this.jogador = jogador;
        this.casa = casa;
        casa.setPedra(this);
        this.sentido = sentido;
        this.dama = false;
        this.simb = this.jogador.cor == 0 ? 'w' : 'b';
    }

    public Boolean podeCapturar(Pedra pedra_alvo){
        return this.jogador.lista_pedras.contains(pedra_alvo);
    }

    public Boolean podeMoverPara(Casa casa){
        if(Partida.tabuleiro.contains(casa)){
            /*if(!this.dama){ //pedras movem apenas em um sentido e damas movem em ambos os sentidos
                if(!Partida.tabuleiro.contains(casa.col+this.sentido)){
                    return false;
                }
            }*/

            //casas a verificar
            //System.out.println(this.sentido);
            Casa casa1 = Partida.getCasa(this.casa.lin+this.sentido, this.casa.col+this.sentido);
            Casa casa2 = Partida.getCasa(this.casa.lin+this.sentido, this.casa.col-this.sentido);
            //System.out.println(this.casa.lin + " " + this.casa.col);
            //System.out.println("Casa: [" + casa.lin + ", " + casa.col + "]");
            //System.out.println("Casa1: [" + casa1.lin + ", " + casa1.col + "]");
            //System.out.println("Casa2: [" + casa2.lin + ", " + casa2.col + "]");
            if(!Partida.getCasa(casa.lin, casa.col).temPedra()){
                //System.out.println("AQUI0");
                if(this.dama){
                    return true;
                } else { //a casa é adjacente à essa pedra?
                    /*Uma peça comum pode mover, no máximo, duas linhas
                     *caso coma uma peça, caso contrário, pode apenas se mover
                     *uma coluna e uma linha no sentido definido*/
                    //verificação falhando!!!
                    //System.out.println("AQUI0.1");
                    if(casa == casa1 || casa == casa2){
                        //System.out.println("AQUI1");
                        return true;
                    } else {
                        //System.out.println("AQUI1.1");
                        return false;
                    }
                }
            } else {
                //System.out.println("AQUI3");
                return false;
            }
        } else {
            //System.out.println("AQUI4");
            return false;
        }
    }

    public Jogador getJogador(){
        return this.jogador;
    }

    public Boolean pedraDama(){
        return this.dama;
    }

    public void viraDama(){
        this.dama = true;
    }
}
