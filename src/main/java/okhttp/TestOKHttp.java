package okhttp;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import util.LogUtil;

import java.io.IOException;

/**
 * Created by yocn on 2019/2/18.
 */
public class TestOKHttp {
    /**
     * Call工厂是用来发送Http请求和解析Http回应的
     * OKHttpClient应该是共享的。OKHttpClient的正确用法应该是创建一个单例并且为所有的Http请求所用
     * 因为每个OKHttpClient都会维持自己的连接池和线程池。重用连接和线程为了降低时延并且节省内存。
     * 所以，为每个Request创建一个Client会浪费资源，因为池子总是在空闲状态。
     *
     * 使用new OkHttpClient()去创建使用默认设置的一个共享的实例
     *   // The singleton HTTP client.
     *   public final OkHttpClient client = new OkHttpClient();
     * 或者使用new OkHttpClient.Builder()去创建一个使用自定义设置的实例
     *   // The singleton HTTP client.
     *   public final OkHttpClient client = new OkHttpClient.Builder()
     *       .addInterceptor(new HttpLoggingInterceptor())
     *       .cache(new Cache(cacheDir, cacheSize))
     *       .build();
     * 你还可以用newBuilder()定制一个共享的OkHttpClient实例，这样创建的Client会共享相同的连接池、线程池和配置使用builder方法去配置
     * 衍生的client或者特殊的意图。
     * 这个例子展示了一个使用了500ms超时时间的call
     *   OkHttpClient eagerClient = client.newBuilder()
     *       .readTimeout(500, TimeUnit.MILLISECONDS)
     *       .build();
     *   Response response = eagerClient.newCall(request).execute();
     * Shutdown不是必要的
     * 持有的线程和连接如果一直空闲会自动被释放。但是如果你的application中需要强制释放掉不需要的资源你可以这样做
     *     client.dispatcher().executorService().shutdown();
     * 使用evictAll()清空连接池，注意连接池进程可能不会立刻退出
     *    client.connectionPool().evictAll();
     */
    private static OkHttpClient client;

    static {
        initOKHttp();
    }

    public static void test() {
        OKGetWeather();
    }

    private static void initOKHttp() {
        client = new OkHttpClient.Builder()
//                .addInterceptor(new HttpLoggingInterceptor())
//                .cache(new Cache(cacheDir, cacheSize))
                .build();
    }

    private static void OKGetWeather() {
        Request request = new Request.Builder()
                .url("https://restapi.amap.com/v3/weather/weatherInfo?key=5326a9f59587393b549f3cffefa0459b&city=110000&output=json&extensions=base")
                .tag("")
                .build();
        client.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {

            }

            @Override
            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                LogUtil.Companion.d("" + response.body().string());
            }
        });
    }
}
