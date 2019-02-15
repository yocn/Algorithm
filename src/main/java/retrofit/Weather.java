package retrofit;

/**
 * @Author yocn
 * @Date 2019/2/14 12:01 PM
 * @ClassName Weather
 */
public class Weather {
    private int status;
    private int count;
    private String info;

    public Weather() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "status=" + status +
                ", count=" + count +
                ", info='" + info + '\'' +
                '}';
    }
}
