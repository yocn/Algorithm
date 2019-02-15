package retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @Author yocn
 * @Date 2019/2/14 12:00 PM
 * @ClassName ApiService
 */
public interface ApiService {
    @GET("weatherInfo")
    Call<Weather> getWeather(@Query("key") String key, @Query("city") String city, @Query("output") String output, @Query("extensions") String extensions);

    @GET("weatherInfo")
    Call<String> getWeatherString(@Query("key") String key, @Query("city") String city, @Query("output") String output, @Query("extensions") String extensions);
}
