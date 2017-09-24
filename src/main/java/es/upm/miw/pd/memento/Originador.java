package es.upm.miw.pd.memento;

public class Originador implements Mementable<Memento> {
    private int id;

    private int valor;

    private String cadena;

    public Originador(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    @Override
    public Memento createMemento() {
        return new Memento(this.valor, this.cadena);
    }

    @Override
    public void restoreMemento(Memento memento) {
        this.setValor(memento.getValor());
        this.setCadena(memento.getCadena());
    }

    @Override
    public String toString() {
        return "Originador[" + id + "," + cadena + "," + valor + "]";
    }

}
