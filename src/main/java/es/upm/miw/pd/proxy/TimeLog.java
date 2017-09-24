package es.upm.miw.pd.proxy;

import java.util.Date;

public class TimeLog implements Service {
    private double sum;

    private double lastTime;

    private int count;

    private Service service;

    public TimeLog(Service service) {
        this.service = service;
        this.sum = 0;
        this.count = 0;
        this.lastTime = 0;
    }

    public double getAverage() {
        return this.sum / this.count;
    }

    public int getCount() {
        return this.count;
    }

    public double getLastTime() {
        return this.lastTime;
    }

    @Override
    public void service() {
        Date time = new Date();
        this.service.service();
        this.lastTime = (new Date().getTime() - time.getTime()) / 1000.0;
        this.sum += this.lastTime;
        this.count++;
    }

    @Override
    public String toString() {
        return "ServerTimeLog[" + count + "(" + this.lastTime + "): average: " + this.getAverage()
                + "]";
    }

}
