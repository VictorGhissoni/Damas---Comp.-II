//Guarda o número de vitórias dos usuários e do computador

package br.ufrj.dcc.damas;

import javax.ws.rs.*;

@Path("/ranking")
public class RankingResource {
    @GET
    @Produces("text/html")
    public String hello() {
        return "Hello, World!";
    }
}