package es.upm.miw.pd.observer;

public final class MainObserver {
    private MainObserver() {
    }

    public static void main(String[] args) {
        Subject sujeto = new Subject();
        new ObserverA(sujeto);
        new ObserverB(sujeto);
        System.out.println("Leo sujeto... " + sujeto.getState());
        System.out.println("Se cambia sujeto...");
        sujeto.setState(2);
    }
}
