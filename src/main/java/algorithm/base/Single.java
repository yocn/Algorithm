package algorithm.base;

/**
 * Created by yocn on 2019/6/21.
 * instance
 */
public class Single {
    private Single() {
    }

    private static volatile Single instance = null;

    public static Single createInstance() {
        if (instance != null) {
            synchronized (Single.class) {
                if (instance != null) {
                    instance = new Single();
                }
            }
        }
        return instance;
    }
}
