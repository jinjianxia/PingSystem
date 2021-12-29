public class FileOpr {
    public static String getFilePath(String s) {
        java.net.URL url = InitClass.class.getProtectionDomain().getCodeSource().getLocation();
        String filePath = null;
        try {
            filePath = java.net.URLDecoder.decode(url.getFile(), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filePath + s;
    }

}
