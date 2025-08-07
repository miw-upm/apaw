package es.upm.miw.apaw.pd.state.connection.solution;

import es.upm.miw.apaw.pd.state.connection.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConnectionTest {

    private Connection connection;

    @BeforeEach
    void ini() {
        this.connection = new Connection();
    }

    @Test
    void testInitialState() {
        assertEquals(State.CLOSED, this.connection.getState());
    }

    @Test
    void testClosedOpen() {
        this.connection.open();
        assertEquals(State.READY, this.connection.getState());
    }

    @Test
    void testClosedClose() {
        this.connection.close();
        assertEquals(State.CLOSED, this.connection.getState());
    }

    @Test
    void testClosedNotSupportedStop() {
        assertThrows(UnsupportedOperationException.class, () -> this.connection.stop());
    }

    @Test
    void testClosedNotSupportedStart() {
        assertThrows(UnsupportedOperationException.class, () -> this.connection.start());
    }

    @Test
    void testClosedNotSupportedSubmit() {
        assertThrows(UnsupportedOperationException.class, () -> this.connection.submit(""));
    }

    @Test
    void testClosedNotSupportedReceive() {
        assertThrows(UnsupportedOperationException.class, () -> this.connection.receive(Waiting.ACK));
    }

    @Test
    void testReadyOpen() {
        this.connection.open();
        this.connection.open();
        assertEquals(State.READY, this.connection.getState());
    }

    @Test
    void testReadyClose() {
        this.connection.open();
        this.connection.close();
        assertEquals(State.CLOSED, this.connection.getState());
    }

    @Test
    void testReadyStop() {
        this.connection.open();
        this.connection.stop();
        assertEquals(State.STOPPED, this.connection.getState());
    }

    @Test
    void testReadyStart() {
        this.connection.open();
        this.connection.start();
        assertEquals(State.READY, this.connection.getState());
    }

    @Test
    void testReadySubmit() {
        this.connection.open();
        this.connection.submit("testReadySubmit");
        assertEquals(State.WAITING, this.connection.getState());
    }

    @Test
    void testReadyNotSupportedReceive() {
        this.connection.open();
        assertThrows(UnsupportedOperationException.class, () -> this.connection.receive(Waiting.ACK));
    }

    @Test
    void testStoppedNotSupportedOpen() {
        this.connection.open();
        this.connection.stop();
        assertThrows(UnsupportedOperationException.class, () -> this.connection.open());
    }

    @Test
    void testStoppedNotSupportedClose() {
        this.connection.open();
        this.connection.stop();
        assertThrows(UnsupportedOperationException.class, () -> this.connection.close());
    }

    @Test
    void testStoppedStop() {
        this.connection.open();
        this.connection.stop();
        this.connection.stop();
        assertEquals(State.STOPPED, this.connection.getState());
    }

    @Test
    void testStoppedStart() {
        this.connection.open();
        this.connection.stop();
        this.connection.start();
        assertEquals(State.READY, this.connection.getState());
    }

    @Test
    void testStoppedNotSupportedSubmit() {
        this.connection.open();
        this.connection.stop();
        assertThrows(UnsupportedOperationException.class, () -> this.connection.submit(""));
    }

    @Test
    void testStoppedNotSupportedReceive() {
        this.connection.open();
        this.connection.stop();
        assertThrows(UnsupportedOperationException.class, () -> this.connection.receive(Waiting.ACK));
    }

    @Test
    void testWaitingNotSupportedOpen() {
        this.connection.open();
        this.connection.submit("testWaitingNotSupportedOpen");
        assertThrows(UnsupportedOperationException.class, () -> this.connection.open());
    }

    @Test
    void testWaitingNotSupportedClose() {
        this.connection.open();
        this.connection.submit("testWaitingNotSupportedClose");
        assertThrows(UnsupportedOperationException.class, () -> this.connection.close());
    }

    @Test
    void testWaitingNotSupportedStop() {
        this.connection.open();
        this.connection.submit("testWaitingNotSupportedStop");
        assertThrows(UnsupportedOperationException.class, () -> this.connection.stop());
    }

    @Test
    void testWaitingNotSupportedStart() {
        this.connection.open();
        this.connection.submit("testWaitingNotSupportedStart");
        assertThrows(UnsupportedOperationException.class, () -> this.connection.start());
    }

    @Test
    void testWaitingNotSupportedSubmit() {
        this.connection.open();
        this.connection.submit("testWaitingNotSupportedSubmit");
        assertThrows(UnsupportedOperationException.class, () -> this.connection.submit(""));
    }

    @Test
    void testWaitingReceiveACK() {
        this.connection.open();
        this.connection.submit("testWaitingReceiveACK");
        this.connection.receive(Waiting.ACK);
        assertEquals(State.READY, this.connection.getState());
    }

    @Test
    void testWaitingReceiveError() {
        this.connection.open();
        this.connection.submit("testWaitingReceiveError");
        this.connection.receive(Waiting.ACK + 1);
        assertEquals(State.CLOSED, this.connection.getState());
    }

}
