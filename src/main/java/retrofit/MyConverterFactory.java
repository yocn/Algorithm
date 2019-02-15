package retrofit;

import okhttp3.ResponseBody;
import org.jetbrains.annotations.Nullable;
import retrofit2.Converter;
import retrofit2.Retrofit;
import util.LogUtil;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * @Author yocn
 * @Date 2019/2/15 10:51 AM
 * @ClassName MyConverterFactory
 */
public class MyConverterFactory extends Converter.Factory {
    @Nullable
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        LogUtil.Companion.d("yocn MyConverterFactory type->" + type);

        if (type == String.class) {
            return new StringConverter();
        } else if (type == Weather.class) {
            return new WeatherConverter();
        }
        return super.responseBodyConverter(type, annotations, retrofit);
    }

    class StringConverter implements Converter<ResponseBody, String> {

        @Nullable
        @Override
        public String convert(ResponseBody value) throws IOException {
            return value.string();
        }
    }

    class WeatherConverter implements Converter<ResponseBody, Weather> {

        @Nullable
        @Override
        public Weather convert(ResponseBody value) throws IOException {
            Weather weather = new Weather();
            weather.setCount(100);
            weather.setStatus(999);
            weather.setInfo("I'm A Fake Weather create by MyConverterFactory!");
            Exception e = new Exception("this is a exception log for print");
            e.printStackTrace();
            return weather;
        }
    }
}

