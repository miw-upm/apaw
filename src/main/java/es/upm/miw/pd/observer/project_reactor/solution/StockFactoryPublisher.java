package es.upm.miw.pd.observer.project_reactor.solution;

import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StockFactoryPublisher {

    private Map<Integer, Integer> references;

    private EmitterProcessor<Integer> negativeStockFlux;

    private Flux<List<Integer>> periodicFluxOfNegativeStock;

    private EmitterProcessor<Long> stockOf5NegativeReferences;


    public StockFactoryPublisher() {
        this.references = new HashMap<>();
        this.negativeStockFlux = EmitterProcessor.create();
        this.periodicFluxOfNegativeStock = Flux.interval(Duration.ofSeconds(2)).map(value ->
                this.references.entrySet().stream()
                        .filter(reference -> reference.getValue() < 0)
                        .map(reference -> reference.getKey())
                        .collect(Collectors.toList())
        ).take(5);
        this.stockOf5NegativeReferences = EmitterProcessor.create();
    }

    public void sum(Integer articleRef, Integer amount) {
        references.merge(articleRef, amount, Integer::sum);
        if (references.get(articleRef) < 0) {
            this.negativeStockFlux.onNext(articleRef);
        }
        long count = this.references.entrySet().stream().filter(reference -> reference.getValue() < 0).count();
        if (count > 4) {
            this.stockOf5NegativeReferences.onNext(count);
        }
    }

    public Integer get(Integer articleRef) {
        return references.get(articleRef);
    }

    public Flux<Integer> publisher() {
        return this.negativeStockFlux;
    }

    public Flux<List<Integer>> periodicFluxOfNegativeStockPublisher() {
        return this.periodicFluxOfNegativeStock;
    }

    public Flux<Long> stockOf5NegativeReferencesPublisher() {
        return this.stockOf5NegativeReferences;
    }


}
