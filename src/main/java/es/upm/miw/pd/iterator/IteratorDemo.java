package es.upm.miw.pd.iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class IteratorDemo {
    private IteratorDemo() {
    }

    public static void main(String[] args) {
        Collection<String> lista = new ArrayList<String>();
        lista.add("uno");
        lista.add("");
        lista.add("dos");
        lista.add("tres");

        System.out.println("--------- for each------------");
        for (String item : lista) {
            System.out.println(item);
        }

        System.out.println("--------- Iterator------------");
        Iterator<String> it = lista.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if ("".equals(s)) {
                it.remove();
            } else {
                System.out.println(s);
            }
        }
    }

}
