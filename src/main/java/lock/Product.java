package lock;

/**
 * Created by yocn on 2019/1/17.
 */
public class Product {
    private String tag = "";

    public Product(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "{" +
                "tag='" + tag + '\'' +
                '}';
    }
}
