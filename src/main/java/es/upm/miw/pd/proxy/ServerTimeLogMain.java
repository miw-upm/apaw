package es.upm.miw.pd.proxy;

public final class ServerTimeLogMain {
    private ServerTimeLogMain() {
    }

    public static void main(String[] args) {
        TimeLog stl = new TimeLog(new Server());
        for (int i = 0; i < 10; i++) {
            stl.service();
            System.out.println(stl.toString());
        }
    }

}
