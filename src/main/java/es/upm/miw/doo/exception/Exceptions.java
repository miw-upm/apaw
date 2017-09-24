package es.upm.miw.doo.exception;

import java.net.SocketException;

public class Exceptions {
    private Server server;

    public Exceptions(Server server) {
        this.server = server;
    }

    public void service() throws SocketException {
        if (!server.connected())
            throw new SocketException("");
        // ...
    }

    // Si es una clase abierta, disponible de forma pública
    public void parameter(int x) {
        if (x < 0)
            throw new IllegalArgumentException("x debe se >= 0");
    }

}
