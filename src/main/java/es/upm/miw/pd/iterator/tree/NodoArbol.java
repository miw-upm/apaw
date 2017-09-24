package es.upm.miw.pd.iterator.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class NodoArbol {
    private int valor;

    private Collection<NodoArbol> subNodos;

    public NodoArbol() {
        this.subNodos = new ArrayList<NodoArbol>();
    }

    public NodoArbol(int valor) {
        this.valor = valor;
        this.subNodos = null;
    }

    public int getValor() {
        return this.valor;
    }

    public boolean isHoja() {
        return this.subNodos == null;
    }

    public void add(NodoArbol subNodo) {
        if (!this.isHoja()) {
            this.subNodos.add(subNodo);
        }
    }

    public void remove(NodoArbol subNodo) {
        if (!this.isHoja()) {
            this.subNodos.remove(subNodo);
        }
    }

    public int suma() {
        if (this.isHoja()) {
            return this.getValor();
        } else {
            int res = 0;
            for (NodoArbol subNodo : this.subNodos) {
                res += subNodo.suma();
            }
            return res;
        }

    }

    public Iterator<NodoArbol> iterator() {
        return new IteradorArbol(this);
    }

    public Iterator<NodoArbol> iteratorHijos() {
        return this.subNodos.iterator();
    }

}
