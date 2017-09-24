package es.upm.miw.pd.memento;

public class Memento {
    private int valor;

    private String cadena;

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
