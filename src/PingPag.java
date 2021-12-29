import java.io.*;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PingPag {
    public static Queue<String> ipQueue = new PriorityQueue<>();
    public static HashMap<String, PingSaveStru> saveinfoStru = new HashMap<String, PingSaveStru>();

    public static int threadNum = 0;

    public PingPag() {
    }

    public PingPag(Queue<String> ipQueue, int threadNum) {
    }

    public void addDataToHash(PingSaveStru pingSaveStru) {
        saveinfoStru.put(pingSaveStru.getIp(), pingSaveStru);
    }

    public Queue<String> getAllp() {
        return null;
    }

    public void initPingPackage() {
        File file = new File(FileOpr.getFilePath("ip.txt"));
        String argstr;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
            reader.readLine();
            while ((argstr = reader.readLine()) != null) {
                argstr = argstr.trim();
                ipQueue.add(argstr);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void pingAgain(PingPag PingPag) {
    }

    public void pingAllSetIp() {
    }

    public HashMap<String, PingSaveStru> getSaveinfoStru() {
        return saveinfoStru;
    }


    public void saveInfor(HashMap<String, PingSaveStru> hashMap, int i) {
        File Save = new File(FileOpr.getFilePath("saveInfor.txt"));
        File SaveNotPassInfor = new File(FileOpr.getFilePath("saveNotPassInfor.txt"));
        File SavaUnstable = new File(FileOpr.getFilePath("unstable.txt"));
        try {
            BufferedWriter save = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Save, true)));
            BufferedWriter saveNot = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(SaveNotPassInfor, true)));
            BufferedWriter saveUnstable = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(SavaUnstable, true)));
            save.write("第" + i + "次ping操作\r\n");
            saveNot.write("第" + i + "次ping操作\r\n");
            saveUnstable.write("第" + i + "次ping操作\r\n");
            for (String key : hashMap.keySet()) {
                if (hashMap.get(key).getPingState() == 2) {
                    save.write(key + "\t" + hashMap.get(key).getPingState() + "\t" + hashMap.get(key).getPingDate() + "\r\n");
                } else if ((hashMap.get(key).getPingState() == 1)) {
                    save.write(key + "\t" + hashMap.get(key).getPingState() + "\t" + hashMap.get(key).getPingDate() + "\r\n");
                } else if (hashMap.get(key).getPingState() == 0) {
                    saveNot.write(key + "\t" + hashMap.get(key).getPingState() + "\t" + hashMap.get(key).getPingDate() + "\r\n");
                }
            }
            save.close();
            saveNot.close();
            saveUnstable.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startOperation() {
        if (threadNum == 0) {
            threadNum = GlobalVar.pingThread;
        }
        ExecutorService executor = Executors.newScheduledThreadPool(threadNum);
        for (int i = 0; i < threadNum; i++) {
            executor.execute(new PingOperationRunner());
        }
        executor.shutdown();
        try {
            while (!executor.isTerminated()) {
                Thread.sleep(50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
