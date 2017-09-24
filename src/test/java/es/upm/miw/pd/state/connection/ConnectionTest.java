package es.upm.miw.pd.state.connection;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class ConnectionTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    private Connection connection;

    @Before
    public void ini() {
        this.connection = new Connection();
    }

    @Test
    public void testInitialState() {
        assertEquals(State.CLOSED, this.connection.getState());
    }

    @Test
    public void testClosedOpen() {
        this.connection.open();
        assertEquals(State.READY, this.connection.getState());
    }

    @Test
    public void testClosedClose() {
        this.connection.close();
        assertEquals(State.CLOSED, this.connection.getState());
    }

    @Test
    public void testClosedNotSupportedStop() {
        exception.expect(UnsupportedOperationException.class);
        this.connection.stop();
    }

    @Test
    public void testClosedNotSupportedStart() {
        exception.expect(UnsupportedOperationException.class);
        this.connection.start();
    }

    @Test
    public void testClosedNotSupportedSubmit() {
        exception.expect(UnsupportedOperationException.class);
        this.connection.submit("");
    }

    @Test
    public void testClosedNotSupportedReceive() {
        exception.expect(UnsupportedOperationException.class);
        this.connection.receive(Connection.ACK);
    }

    @Test
    public void testReadyOpen() {
        this.connection.open();
        this.connection.open();
        assertEquals(State.READY, this.connection.getState());
    }

    @Test
    public void testRadyClose() {
        this.connection.open();
        this.connection.close();
        assertEquals(State.CLOSED, this.connection.getState());
    }

    @Test
    public void testReadyStop() {
        this.connection.open();
        this.connection.stop();
        assertEquals(State.STOPPED, this.connection.getState());
    }

    @Test
    public void testReadyStart() {
        this.connection.open();
        this.connection.start();
        assertEquals(State.READY, this.connection.getState());
    }

    @Test
    public void testReadySubmit() {
        this.connection.open();
        this.connection.submit("testReadySubmit");
        assertEquals(State.WAITING, this.connection.getState());
    }

    @Test
    public void testReadyNotSupportedReceive() {
        exception.expect(UnsupportedOperationException.class);
        this.connection.open();
        this.connection.receive(Connection.ACK);
    }

    @Test
    public void testStopedNotSupportedOpen() {
        exception.expect(UnsupportedOperationException.class);
        this.connection.open();
        this.connection.stop();
        this.connection.open();
    }

    @Test
    public void testStopedNotSupportedClose() {
        exception.expect(UnsupportedOperationException.class);
        this.connection.open();
        this.connection.stop();
        this.connection.close();
    }

    @Test
    public void testStopedStop() {
        this.connection.open();
        this.connection.stop();
        this.connection.stop();
        assertEquals(State.STOPPED, this.connection.getState());
    }

    @Test
    public void testStopedStart() {
        this.connection.open();
        this.connection.stop();
        this.connection.start();
        assertEquals(State.READY, this.connection.getState());
    }

    @Test
    public void testStopedNotSupportedSubmit() {
        exception.expect(UnsupportedOperationException.class);
        this.connection.open();
        this.connection.stop();
        this.connection.submit("");
    }

    @Test
    public void testStopedNotSupportedReceive() {
        exception.expect(UnsupportedOperationException.class);
        this.connection.open();
        this.connection.stop();
        this.connection.receive(Connection.ACK);
    }

    @Test
    public void testWaitingNotSupportedOpen() {
        exception.expect(UnsupportedOperationException.class);
        this.connection.open();
        this.connection.submit("testWaitingNotSupportedOpen");
        this.connection.open();
    }

    @Test
    public void testWaitingNotSupportedClose() {
        exception.expect(UnsupportedOperationException.class);
        this.connection.open();
        this.connection.submit("testWaitingNotSupportedClose");
        this.connection.close();
    }

    @Test
    public void testWaitingNotSupportedStop() {
        exception.expect(UnsupportedOperationException.class);
        this.connection.open();
        this.connection.submit("testWaitingNotSupportedStop");
        this.connection.stop();
    }

    @Test
    public void testWaitingNotSupportedStart() {
        exception.expect(UnsupportedOperationException.class);
        this.connection.open();
        this.connection.submit("testWaitingNotSupportedStart");
        this.connection.start();
    }

    @Test
    public void testWaitingNotSupportedSubmit() {
        exception.expect(UnsupportedOperationException.class);
        this.connection.open();
        this.connection.submit("testWaitingNotSupportedSubmit");
        this.connection.submit("");
    }

    @Test
    public void testWaitingReceiveACK() {
        this.connection.open();
        this.connection.submit("testWaitingReceiveACK");
        this.connection.receive(Connection.ACK);
        assertEquals(State.READY, this.connection.getState());
    }

    @Test
    public void testWaitingReceiveError() {
        this.connection.open();
        this.connection.submit("testWaitingReceiveError");
        this.connection.receive(Connection.ACK + 1);
        assertEquals(State.CLOSED, this.connection.getState());
    }

}
