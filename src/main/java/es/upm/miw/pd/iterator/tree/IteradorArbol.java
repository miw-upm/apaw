package es.upm.miw.pd.iterator.tree;

import java.util.Iterator;

public class IteradorArbol implements Iterator<NodoArbol> {
    private NodoArbol actual;

    private Iterator<NodoArbol> subNodos, subIterators;

    public IteradorArbol(NodoArbol nodo) {
        this.actual = nodo;
        if (!this.actual.isHoja()) {
            this.subNodos = this.actual.iteratorHijos();
            this.subIterators = this.subNodos.next().iterator();
        }
    }

    @Override
    public boolean hasNext() {
        return this.actual != null;
    }

    @Override
    public NodoArbol next() {
        if (this.actual.isHoja()) {
            NodoArbol ant = this.actual;
            this.actual = null;
            return ant;
        } else {
            if (!this.subIterators.hasNext() && this.subNodos.hasNext()) {
                this.subIterators = this.subNodos.next().iterator();
            }
            if (this.subIterators.hasNext()) {
                return this.subIterators.next();
            } else {
                NodoArbol ant = this.actual;
                this.actual = null;
                return ant;
            }
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

}
