public class PingSaveStru {
    private String ip;
    private String pingDate;
    private int pingState;

    public PingSaveStru() {
    }

    public PingSaveStru(String ip, String pingDate, int pingState) {
        this.ip = ip;
        this.pingDate = pingDate;
        this.pingState = pingState;
    }

    @Override
    public String toString() {
        return "PingSaveStru{" +
                "ip='" + ip + '\'' +
                ", pingDate='" + pingDate + '\'' +
                ", pingState=" + pingState +
                '}';
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPingDate() {
        return pingDate;
    }

    public void setPingDate(String pingDate) {
        this.pingDate = pingDate;
    }

    public int getPingState() {
        return pingState;
    }

    public void setPingState(int pingState) {
        this.pingState = pingState;
    }
}
