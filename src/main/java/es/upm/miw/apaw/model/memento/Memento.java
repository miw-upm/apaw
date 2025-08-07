package es.upm.miw.apaw.model.memento;

public class Memento {
    private final int valor;

    private final String cadena;

    public Memento(int valor, String cadena) {
        this.valor = valor;
        this.cadena = cadena;
    }

    public int getValor() {
        return this.valor;
    }

    public String getCadena() {
        return this.cadena;
    }

}
