package retrofit;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import org.jetbrains.annotations.Nullable;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import util.LogUtil;

/**
 * @Author yocn
 * @Date 2019/2/14 11:49 AM
 * @ClassName MyCallAdapter
 */
public class MyCallAdapter extends CallAdapter.Factory {
    @Nullable
    @Override
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        LogUtil.Companion.d("yocn MyCallAdapter->" + returnType.getTypeName() + " returnType->" + returnType);
        if (returnType == String.class) {
            return new StringCallAdapter();
        } else if (returnType == Weather.class) {
            Exception e = new Exception("this is a exception log for print");
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

    class WeatherCallAdapter implements CallAdapter<String, String> {

        @Override
        public Type responseType() {
            return String.class;
        }

        @Override
        public String adapt(Call<String> call) {
            try {
                LogUtil.Companion.d("yocn weather");
                return call.execute().body();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }
    }
}
