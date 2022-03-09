//Endpoint que cuida da atualização da interface da página

package br.ufrj.dcc.damas;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class HelloApplication extends Application {
    public String homepage(){
        String html = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "    <head>\n" +
                "        <meta charset=\"utf-8\">\n" +
                "        <title>Damas | Jogo</title>\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <center>\n" +
                "            <h2>Jogo de Damas</h2>\n" +
                "            <h3>Comp. II - 21.2</h3>\n" +
                "            <img src=\"https://c.tenor.com/6t7aGuUTjPgAAAAd/playing-checkers-young-rog.gif\">\n" +
                "            <a href=\"\"><img src=\"button1.png\" alt=\"2 Jogadores\" width=\"150\" height=\"auto\"></a>\n" +
                "            <a href=\"\"><img src=\"button2.png\" alt=\"VS. Computador\" width=\"150\" height=\"auto\"></a>\n" +
                "        </center>\n" +
                "    </body>\n" +
                "</html>";
        return html;
    }
}