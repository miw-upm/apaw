package es.upm.miw.pd.observer.project_reactor.solution;

import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

import java.util.HashMap;
import java.util.Map;

public class StockFactoryPublisher {

    private Map<Integer, Integer> references;

    private EmitterProcessor<Integer> emitter;


    public StockFactoryPublisher() {
        this.references = new HashMap<>();
        this.emitter = EmitterProcessor.create();
    }

    public void sum(Integer articleRef, Integer amount) {
        references.merge(articleRef, amount, Integer::sum);
        if (references.get(articleRef) < 0) {
            this.emitter.onNext(articleRef);
        }
    }

    public Integer get(Integer articleRef) {
        return references.get(articleRef);
    }

    public Flux<Integer> publisher() {
        return this.emitter;
    }

}
