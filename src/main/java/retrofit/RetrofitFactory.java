package retrofit;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Author yocn
 * @Date 2019/2/14 11:59 AM
 * @ClassName RetrofitFactory
 */
public class RetrofitFactory {
    static Retrofit retrofit;
    static ApiService apiService;

    public static ApiService getInstance() {
        //https://restapi.amap.com/v3/weather/weatherInfo?key=5326a9f59587393b549f3cffefa0459b&city=110000&output=json&extensions=base
        if (apiService == null) {
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(new MyConverter())
                    .addCallAdapterFactory(new MyCallAdapter())
                    .baseUrl("https://restapi.amap.com/v3/weather/")
                    .build();
            apiService = retrofit.create(ApiService.class);
        }
        return apiService;
    }

}
