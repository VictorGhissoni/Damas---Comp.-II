//Endpoint do jogo em si

package br.ufrj.dcc.damas;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;

@Path("/jogo")
public class HelloResource {
    @GET
    @Produces("text/html")
    public String jogo(){

        int tamanho = 8;
        //Cada pedra são dois valores consecutivos
        //Sendo [pos_x, pos_y]
        ArrayList<Integer> pedras_jogador1 = new ArrayList<>();
        ArrayList<Integer> pedras_jogador2 = new ArrayList<>();
        String html = "";

        //posições iniciais
        for(int j=0;j<tamanho;++j){
            for(int k=0;k<tamanho;++k){
                if (j < tamanho/2-1){
                    if (j % 2==0){ //linha começa sem peça
                        if (k % 2==1){
                            pedras_jogador1.add(j);
                            pedras_jogador1.add(k);
                        }
                    } else { //linha começa com peça
                        if (k % 2 == 0){
                            //System.out.println("Pedra adicionada em: " + i + ", " + j);
                            pedras_jogador1.add(j);
                            pedras_jogador1.add(k);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < tamanho; ++i) {
            for (int j = 0; j < tamanho; ++j) {
                if (i > tamanho / 2) {
                    if (i % 2 == 0) { //linha começa sem peça
                        if (j % 2 == 1) {
                            //System.out.println("Pedra adicionada em: " + i + ", " + j);
                            pedras_jogador2.add(i);
                            pedras_jogador2.add(j);
                        }
                    } else { //linha começa com peça
                        if (j % 2 == 0) {
                            //System.out.println("Pedra adicionada em: " + i + ", " + j);
                            pedras_jogador2.add(i);
                            pedras_jogador2.add(j);
                        }
                    }
                }
            }
        }



        return html;
    }


}