package es.upm.miw.pd.proxy;

import org.apache.logging.log4j.LogManager;

import java.util.Random;

public class Server implements Service {
    private Random random;

    public Server() {
        this.random = new Random();
    }

    public void service() {
        try {
            Thread.sleep(Math.round(this.random.nextDouble() * 3000));
        } catch (InterruptedException ie) {
            LogManager.getLogger(this.getClass()).error("Sleep Interrupted");
        }
    }

}
