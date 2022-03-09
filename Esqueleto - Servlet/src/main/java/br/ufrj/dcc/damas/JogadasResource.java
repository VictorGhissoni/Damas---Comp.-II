//Guarda e apresenta as jogadas da partida atual
package br.ufrj.dcc.damas;

import javax.ws.rs.*;

@Path("/jogadas")
public class JogadasResource {
    @GET
    @Produces("text/html")
    public String hello() {
        return "Hello, World!";
    }
}