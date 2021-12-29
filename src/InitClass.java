import org.apache.log4j.Logger;

import java.io.*;
import java.util.HashMap;

public class InitClass extends PingPag {
    static Logger logger = Logger.getLogger(InitClass.class);
    private final HashMap<String, String> ipList = new HashMap<String, String>();

    public void fileRead() {
        File file = new File(FileOpr.getFilePath("ip.txt"));
        String tempString;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((tempString = reader.readLine()) != null) {
                ipList.put(tempString, tempString);
                logger.info("read " + tempString);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addDatatoHash(String s) {
        saveinfoStru.put(s, null);
    }

    public void pingAll() {
        String netCode = "172.16.21.";
        for (int i = 0; i < 256; i++) {
            String ip = netCode + i;
            ipQueue.add(ip);
        }
    }

    public void save() {
        File file = new File(FileOpr.getFilePath("ip.txt"));
        try {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
            for (String value : saveinfoStru.keySet()) {
                out.write(value + "\r\n");
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
