import java.util.ArrayList;

public class Movimento{
    public Casa origem, destino;
    public Pedra pedra_movida;
    public ArrayList<Pedra> pedras_capturadas;

    public Movimento(Integer[] origem, Integer[] destino){
        pedras_capturadas = new ArrayList<>();
        for(Casa casa : Partida.tabuleiro){
            if(casa.lin == origem[0] && casa.col == origem[1]){
                this.origem = casa;
            } else if(casa.lin == destino[0] && casa.col == destino[1]){
                this.destino = casa;
            }
        }

        //System.out.println(Partida.getCasa(origem[0], origem[1]) + " " + origem[0] + ", " + origem[1]);
        //System.out.println(">>> " + Partida.getCasa(origem[0], origem[1]).lin + " | " + Partida.getCasa(origem[0], origem[1]).col);
        this.pedra_movida = Partida.tabuleiro.get(Partida.tabuleiro.indexOf(this.origem)).pedra_ocupante;
        //System.out.println("Pedra a mover: " + this.pedra_movida.casa.lin + " | " + this.pedra_movida.casa.col);
    }

    private Boolean casaValida(Casa casa){
        return casa.temPedra();
    }
}