package es.upm.miw.pd.state.connection.solution;

import es.upm.miw.pd.state.connection.State;

public class Closed extends AbstractState {

    @Override
    public void open(Connection connection) {
        connection.setAbstractState(new Ready());
    }

    @Override
    public void close(Connection connection) {
        // Empty on purpose
    }

    @Override
    public State state() {
        return State.CLOSED;
    }

}
