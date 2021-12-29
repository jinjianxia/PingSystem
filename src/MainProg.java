import java.util.HashMap;
import java.util.regex.Pattern;

public class MainProg {
    private static final HashMap<String, String> ipList = new HashMap<String, String>();

    public static void main(String[] args) {

        String arg = args[0];
        switch (arg) {
            case "i":
                init();
                break;
            case "r":
                runProg();
                break;
        }
    }

    public static void init() {
        System.out.println("init");
        InitClass initClass = new InitClass();
        initClass.fileRead();
        initClass.pingAll();
        initClass.startOperation();
        initClass.save();
    }


    public static void runProg() {
        System.out.println("run");
        MyTimer myTimer = new MyTimer();
        myTimer.initTimer();
    }

    public static Boolean isIp(String par) {
        boolean ret = false;
        String regex = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\." + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\." + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
        if (Pattern.compile(regex).matcher(par).find()) {
            ret = true;
        }
        return ret;
    }
}