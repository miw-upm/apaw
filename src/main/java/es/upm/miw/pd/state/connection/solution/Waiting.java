package es.upm.miw.pd.state.connection.solution;

import es.upm.miw.pd.state.connection.State;

public class Waiting extends AbstractState {

    static final int ACK = 0;

    @Override
    public State state() {
        return State.WAITING;
    }

    @Override
    public void receive(Connection connection, int response) {
        if (response == ACK) {
            connection.setAbstractState(new Ready());
        } else {
            connection.setAbstractState(new Closed());
        }
    }
}
