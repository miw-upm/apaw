package es.upm.miw.pd.state.connection.solution;

import es.upm.miw.pd.state.connection.State;

public class Connection {

    private AbstractState abstractState;

    public Connection() {
        this.setAbstractState(new Closed());
    }

    protected void setAbstractState(AbstractState abstractState) {
        this.abstractState = abstractState;
    }

    public State getState() {
        return this.abstractState.state();
    }

    public void open() {
        this.abstractState.open(this);
    }

    public void close() {
        this.abstractState.close(this);
    }

    public void stop() {
        this.abstractState.stop(this);
    }

    public void start() {
        this.abstractState.start(this);
    }

    public void submit(String msg) {
        this.abstractState.submit(this, msg);
    }

    public void receive(int response) {
        this.abstractState.receive(this, response);
    }

}
