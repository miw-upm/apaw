package es.upm.miw.rective;

import org.apache.logging.log4j.LogManager;
import reactor.core.publisher.Flux;

public class ReactiveComponent {

    public void endOfChain(Flux<Integer> flux) { //ONLY Angular Component !!!
        flux.subscribe(
                msg -> LogManager.getLogger(this.getClass()).info("Consumer: {}", msg), //onNext
                throwable -> LogManager.getLogger(this.getClass()).info("Error: {}", throwable.getMessage()), //onError
                () -> LogManager.getLogger(this.getClass()).info("Completed") //onComplete
        );
    }
}