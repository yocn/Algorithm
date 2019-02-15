package retrofit;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.jetbrains.annotations.Nullable;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import util.LogUtil;

/**
 * @Author yocn
 * @Date 2019/2/14 11:49 AM
 * @ClassName MyCallAdapterFactory
 */
public class MyCallAdapterFactory extends CallAdapter.Factory {
    @Nullable
    @Override
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        for (Annotation a : annotations) {
            LogUtil.Companion.d("Annotation->" + a.toString());
        }
        Type wrapperType = getParameterUpperBound(0, (ParameterizedType) returnType);
        LogUtil.Companion.d("yocn MyCallAdapterFactory->" + returnType
                + " getRawType->" + getRawType(returnType)
                + " Type->" + wrapperType);
        if (wrapperType == String.class) {
            return new StringCallAdapter();
        } else if (wrapperType == Weather.class) {
            Exception e = new Exception("call Weather print");
            e.printStackTrace();
            return new WeatherCallAdapter();
        }
        return null;
    }

    class StringCallAdapter implements CallAdapter<String, String> {

        @Override
        public Type responseType() {
            return String.class;
        }

        @Override
        public String adapt(Call<String> call) {
            try {
                return call.execute().body();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }
    }

    class WeatherCallAdapter implements CallAdapter<String, retrofit2.Call> {

        @Override
        public Type responseType() {
            return Weather.class;
        }

        @Override
        public retrofit2.Call adapt(Call<String> call) {
            LogUtil.Companion.d("yocn weather->" + call.request().toString());
            return call;
        }
    }
}
