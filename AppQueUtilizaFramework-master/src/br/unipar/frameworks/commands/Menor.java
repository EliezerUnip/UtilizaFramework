package br.unipar.frameworks.commands;

import br.unipar.framework.miniframework.CommandHandler;
import br.unipar.framework.miniframework.Request;
import br.unipar.framework.miniframework.Response;

public class Menor implements CommandHandler {

    @Override
    public Response handle(Request request) {

        // Precisa de pelo menos 2 números
        if (request.getArgs().size() < 2) {
            return Response.badResquest("Uso: menor <num1> <num2> [num3] ...");
        }

        try {
            double menor = Double.parseDouble(request.getArgs().get(0));

            for (int i = 1; i < request.getArgs().size(); i++) {
                double numero = Double.parseDouble(request.getArgs().get(i));

                if (numero < menor) {
                    menor = numero;
                }
            }

            return Response.ok("Menor número: " + menor);

        } catch (NumberFormatException e) {
            return Response.badResquest("Todos os argumentos devem ser números.");
        }
    }
}