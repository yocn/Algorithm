import annotation.AnnoParser;
import proxy.IAlgoProxy;

/**
 * Created by yocn on 2018/12/4.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("asdadsa");
        AnnoParser parser = new AnnoParser();
        parser.parse(IAlgoProxy.class);
    }
}
