package okhttp;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import util.LogUtil;

import java.io.IOException;

/**
 * Created by yocn on 2019/2/18.
 */
public class TestOKHttp {

    public static void test() {
        OKGetWeather();
    }

    public static void OKGetWeather() {
        OkHttpClient client = new OkHttpClient();
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
