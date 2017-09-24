package es.upm.miw.pd.iterator.tree;

import java.util.Iterator;

public final class MainArbol {
    private MainArbol() {
    }

    public static void main(String[] args) {
        NodoArbol n0 = new NodoArbol(0), n1 = new NodoArbol(1);
        NodoArbol n2 = new NodoArbol(2), n4 = new NodoArbol(4);
        n0.add(n1);
        n0.add(n2);
        n1.add(new NodoArbol(3));
        n1.add(n4);
        n2.add(new NodoArbol(7));
        n4.add(new NodoArbol(5));
        n4.add(new NodoArbol(6));
        Iterator<NodoArbol> i = n0.iterator();
        while (i.hasNext()) {
           System.out.println(i.next().getValor());
        }
    }
}
