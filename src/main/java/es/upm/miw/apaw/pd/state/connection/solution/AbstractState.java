package es.upm.miw.apaw.pd.state.connection.solution;

import es.upm.miw.apaw.pd.state.connection.State;

public abstract class AbstractState {

    private static final String UNSUPPORTED = "Acción no permitida... ";

    public abstract State state();

    public void open(Connection connection) {
        throw new UnsupportedOperationException(UNSUPPORTED);
    }

    public void close(Connection connection) {
        throw new UnsupportedOperationException(UNSUPPORTED);
    }

    public void stop(Connection connection) {
        throw new UnsupportedOperationException(UNSUPPORTED);
    }

    public void start(Connection connection) {
        throw new UnsupportedOperationException(UNSUPPORTED);
    }

    public void submit(Connection connection, String msg) {
        throw new UnsupportedOperationException(UNSUPPORTED);
    }

    public void receive(Connection connection, int response) {
        throw new UnsupportedOperationException(UNSUPPORTED);
    }
}
