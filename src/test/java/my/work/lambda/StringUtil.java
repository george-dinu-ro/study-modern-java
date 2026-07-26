package my.work.lambda;

public class StringUtil {

    public static String cleanAndGet(String str) {
        return str.strip().replace("\r\n", "\n");
    }

}
