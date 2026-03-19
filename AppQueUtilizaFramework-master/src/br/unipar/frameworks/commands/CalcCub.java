package br.unipar.frameworks.commands;

import br.unipar.framework.miniframework.CommandHandler;
import br.unipar.framework.miniframework.Request;
import br.unipar.framework.miniframework.Response;



public class CalcCub implements CommandHandler {
    @Override
    public Response handle(Request request) {
        if (request.getArgs().size() != 1) {
            return Response.badResquest("Uso: volume-cubo <aresta>");
        }

        try {
            double aresta = Double.parseDouble(request.getArgs().get(0));

            double volume = Math.pow(aresta, 3);

            return Response.ok("Volume do cubo: " + volume);

        } catch (NumberFormatException e) {
            return Response.badResquest("O argumento deve ser um número.");
        }
    }
}
