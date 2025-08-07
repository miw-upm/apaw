package es.upm.miw.apaw.pd.state.connection.solution;

import es.upm.miw.apaw.pd.state.connection.State;
import org.apache.logging.log4j.LogManager;

public class Ready extends AbstractState {

    @Override
    public void open(Connection connection) {
        // Empty on purpose
    }

    @Override
    public void close(Connection connection) {
        connection.setAbstractState(new Closed());
    }

    @Override
    public void submit(Connection connection, String msg) {
        LogManager.getLogger(this.getClass()).info(msg);
        connection.setAbstractState(new Waiting());
    }

    @Override
    public void start(Connection connection) {
        // Empty on purpose
    }

    @Override
    public void stop(Connection connection) {
        connection.setAbstractState(new Stopped());
    }

    @Override
    public State state() {
        return State.READY;
    }

}
