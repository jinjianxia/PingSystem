import java.time.LocalTime;
import java.util.TimerTask;

public class MyTest extends TimerTask {

    @Override
    public void run() {
        System.out.println("定时器MyTest启动" + LocalTime.now());
        PingPag PingPag = new PingPag();
        PingPag.initPingPackage();
        PingPag.startOperation();
        PingPag.saveInfor(PingPag.getSaveinfoStru(), ++GlobalVar.pingCountNo);
    }
}
