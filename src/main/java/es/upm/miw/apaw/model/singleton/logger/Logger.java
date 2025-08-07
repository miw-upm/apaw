package es.upm.miw.apaw.model.singleton.logger;

import java.util.Date;

public final class Logger {

    private String logs;

    public Logger() {
        this.clear();
    }

    public String getLogs() {
        return this.logs;
    }

    public void addLog(String log) {
        this.logs = this.logs + ">>> " + log + "\n";
    }

    public void clear() {
        this.logs = new Date() + "\n";
    }
}
