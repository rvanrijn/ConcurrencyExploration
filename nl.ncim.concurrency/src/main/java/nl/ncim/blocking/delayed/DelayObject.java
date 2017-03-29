package nl.ncim.blocking.delayed;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayObject implements Delayed {

    private String data;

    private long startTime;


    public DelayObject(String data, long delay) {

        this.data = data;
        this.startTime = System.currentTimeMillis() + delay;
    }


    public long getDelay(TimeUnit unit) {

        long diff = startTime - System.currentTimeMillis();
        return unit.convert(diff, TimeUnit.MILLISECONDS);
    }


    public int compareTo(Delayed o) {
        if (this.startTime < ((DelayObject) o).startTime) {
            return -1;
        }

        if (this.startTime > ((DelayObject) o).startTime) {
            return 1;
        }
        return 0;
    }


    @Override
    public String toString() {
        return "{" +
                "data='" + data + '\'' +
                ", startTime=" + startTime +
                '}';
    }

}
