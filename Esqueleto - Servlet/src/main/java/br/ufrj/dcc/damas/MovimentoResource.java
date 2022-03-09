/*Valida o movimento escolhido pelo jogador
 *Ação de captura de peça
 *Obrigatoriedade de captura
 *Verificar se casas estão vazias
 *Transformar peças em damas
 *etc
 */

package br.ufrj.dcc.damas;

import javax.ws.rs.*;

@Path("/movimento")
public class MovimentoResource {
    @GET
    @Produces("text/html")
    public String validar(@QueryParam("") @DefaultValue("") ) {
        return "Hello, World!";
    }
}