package es.upm.miw.pd.observer.project_reactor;

import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class StackPublisher {

    private EmitterProcessor<String> emitter;

    private List<String> values;

    public StackPublisher() {
        this.emitter = EmitterProcessor.create();
        this.values = new ArrayList<>();

    }

    public Flux<String> publisher() {
        return this.emitter;
    }

    public void add(String msg) {
        this.values.add(msg);
        this.emitter.onNext(msg);
    }

    public List<String> getValues() {
        return this.values;
    }

    public void reset() {
        this.values.clear();
    }
}
