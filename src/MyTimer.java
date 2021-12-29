import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyTimer {
    ScheduledThreadPoolExecutor stp;

    public void initTimer() {
        int times = 1;
        MyTest myTest = new MyTest();
        stp = new ScheduledThreadPoolExecutor(times);
        stp.scheduleWithFixedDelay(myTest, 0, times, TimeUnit.MINUTES);
    }
}
