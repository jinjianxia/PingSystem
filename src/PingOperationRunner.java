import org.apache.log4j.Logger;

import java.net.InetAddress;

public class PingOperationRunner extends PingPag implements Runnable {
    static Logger logger = Logger.getLogger(PingOperationRunner.class);

    @Override
    public void run() {
        InetAddress address;
        boolean isAblePing;
        PingSaveStru pingSaveStru;
        String times;
        String taskIp;
        while ((taskIp = getOIDInfor()) != null) {
            try {
                address = InetAddress.getByName(taskIp);
                isAblePing = address.isReachable(3000);
                int isPing = 0;
                if (isAblePing) {
                    isPing = 2;
                } else {
                    Thread.sleep(3000);
                    isAblePing = address.isReachable(3000);
                    if (isAblePing)
                        isPing = 1;
                }
                times = new java.util.Date().toString();
                pingSaveStru = new PingSaveStru(taskIp, times, isPing);
                addDataToHash(pingSaveStru);
                logger.info(pingSaveStru);
            } catch (Exception e) {
                logger.info(taskIp + "异常");
            }
        }
    }

    public String getOIDInfor() {
        String ip;
        synchronized (PingPag.class) {
            ip = ipQueue.poll();
        }
        return ip;
    }
}
