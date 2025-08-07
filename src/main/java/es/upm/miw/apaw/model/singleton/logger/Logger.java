package es.upm.miw.apaw.model.singleton.logger;

import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
public final class Logger {

    private String logs;

    public Logger() {
        this.clear();
    }

    public void addLog(String log) {
        this.logs = this.logs + ">>> " + log + "\n";
    }

    public void clear() {
        this.logs = new Date() + "\n";
    }
}
