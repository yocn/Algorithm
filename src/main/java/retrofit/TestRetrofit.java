package retrofit;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import util.LogUtil;

/**
 * @Author yocn
 * @Date 2019/2/14 2:22 PM
 * @ClassName TestRetrofit
 */
public class TestRetrofit {
    public static void test() {
        retrofitGetWeather();
    }

    public static void retrofitGetWeather() {
        //?key=5326a9f59587393b549f3cffefa0459b&city=110000&output=json&extensions=base
        Call<Weather> call = RetrofitFactory.getInstance().getWeather("5326a9f59587393b549f3cffefa0459b", "110000", "json", "base");
        call.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                LogUtil.Companion.d("" + response.body().toString());
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {

            }
        });

        Call<String> callString = RetrofitFactory.getInstance().getWeatherString("5326a9f59587393b549f3cffefa0459b", "110000", "json", "base");
        callString.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                LogUtil.Companion.d("sss->" + response.body().toString());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }

    public static void OKGetWeather() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("https://restapi.amap.com/v3/weather/weatherInfo?key=5326a9f59587393b549f3cffefa0459b&city=110000&output=json&extensions=base").build();
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
