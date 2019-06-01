package es.upm.miw.pd.observer.project_reactor;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

class ReactiveProgrammingTest {

    @Test
    void testMonoEmpty() {
        new ReactiveProgramming().monoEmpty().subscribe(
                msg -> LogManager.getLogger(this.getClass()).info("Consumer: " + msg), //onNext
                throwable -> LogManager.getLogger(this.getClass()).info("Error: " + throwable.getMessage()), //onError
                () -> LogManager.getLogger(this.getClass()).info("Completed") //onComplete
        );
    }

    @Test
    void testMonoEmptyBlock() {
        new ReactiveProgramming().monoEmpty().block();
        LogManager.getLogger(this.getClass()).info("Finish... testMonoEmptyBlock");
    }

    @Test
    void testMonoOne() {
        new ReactiveProgramming().monoOne().subscribe(
                msg -> LogManager.getLogger(this.getClass()).info("Consumer: " + msg)
        );
    }

    @Test
    void testMonoError() {
        new ReactiveProgramming().monoError().subscribe(
                msg -> LogManager.getLogger(this.getClass()).info("Consumer: " + msg),
                throwable -> LogManager.getLogger(this.getClass()).info("Error: " + throwable.getMessage()),
                () -> LogManager.getLogger(this.getClass()).info("Completed")
        );
    }

    @Test
    void testMonoDelay() throws InterruptedException {
        new ReactiveProgramming().monoDelay().subscribe(
                msg -> LogManager.getLogger(this.getClass()).info("Consumer: " + msg),
                throwable -> LogManager.getLogger(this.getClass()).info("Error: " + throwable.getMessage()),
                () -> LogManager.getLogger(this.getClass()).info("Completed")
        );
        LogManager.getLogger(this.getClass()).info("----------- Subscribed -------------sleep...");
        TimeUnit.SECONDS.sleep(5);
    }

    @Test
    void testFluxDemo() throws InterruptedException {
        new ReactiveProgramming().fluxDemo().subscribe(
                msg -> LogManager.getLogger(this.getClass()).info("Consumer: " + msg),
                throwable -> LogManager.getLogger(this.getClass()).info("Error: " + throwable.getMessage()),
                () -> LogManager.getLogger(this.getClass()).info("Completed")
        );
        TimeUnit.SECONDS.sleep(7);
    }

    @Test
    void testFluxDemoLimitByFlow() {
        new ReactiveProgramming().fluxLimitByFlow().subscribe(
                msg -> LogManager.getLogger(this.getClass()).info("Consumer: " + msg),
                throwable -> LogManager.getLogger(this.getClass()).info("Error: " + throwable.getMessage()),
                () -> LogManager.getLogger(this.getClass()).info("Completed")
        );
    }

    @Test
    void testFluxDelayLimitByTime() throws InterruptedException {
        new ReactiveProgramming().fluxLimitByTime().subscribe(
                msg -> LogManager.getLogger(this.getClass()).info("Consumer: " + msg),
                throwable -> LogManager.getLogger(this.getClass()).info("Error: " + throwable.getMessage()),
                () -> LogManager.getLogger(this.getClass()).info("Completed")
        );
        TimeUnit.SECONDS.sleep(5);

    }

    @Test
    void testFluxesMerge() throws InterruptedException {
        new ReactiveProgramming().fluxesMerge().subscribe(
                msg -> LogManager.getLogger(this.getClass()).info("Consumer: " + msg),
                throwable -> LogManager.getLogger(this.getClass()).info("Error: " + throwable.getMessage()),
                () -> LogManager.getLogger(this.getClass()).info("Completed")
        );
        TimeUnit.SECONDS.sleep(5);
    }

    @Test
    void testFluxesSyncBlock() {
        new ReactiveProgramming().fluxesSync().block(); // wait for finish
        LogManager.getLogger(this.getClass()).info("----------- Finish... ");
    }

    @Test
    void testFluxesSync() throws InterruptedException {
        new ReactiveProgramming().fluxesSync().subscribe(
                msg -> LogManager.getLogger(this.getClass()).info("Consumer: " + msg),
                throwable -> LogManager.getLogger(this.getClass()).info("Error: " + throwable.getMessage()),
                () -> LogManager.getLogger(this.getClass()).info("Completed")
        );
        LogManager.getLogger(this.getClass()).info("----------- Subscribed... sleep...");
        TimeUnit.SECONDS.sleep(5);
    }

}
