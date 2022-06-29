package spencerdepas.nycschools.api;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class API {

    public interface IAPI extends SchoolApi {

    }

    private static final String TAG = "API";
    private static final String SERVER_URL = "https://data.cityofnewyork.us";


    public static final Gson GSON = new GsonBuilder().create();

    public static JsonObject parseObjectToJson(Object o) {
        return new JsonParser().parse(GSON.toJson(o)).getAsJsonObject();
    }

    public static String parseObjectToJsonString(Object o) {
        return new JsonParser().parse(GSON.toJson(o)).toString();
    }

    private static IAPI api = null;

    public static IAPI get() {
        if (api == null) {

            HttpLoggingInterceptor interceptor =
                new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {

                    @Override
                    public void log(String msg) {
                        Log.d(TAG, msg);
                    }

                });

            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder b = new OkHttpClient.Builder();

            b.connectTimeout(15, TimeUnit.SECONDS);
            b.readTimeout(3, TimeUnit.MINUTES);
            b.retryOnConnectionFailure(true);
            b.cache(null);
            b.addInterceptor(interceptor);

            OkHttpClient okClient = b.build();
            Retrofit.Builder builder = new Retrofit.Builder();

            builder.baseUrl(SERVER_URL);
            builder.addConverterFactory(ScalarsConverterFactory.create());
            builder.addConverterFactory(GsonConverterFactory.create(GSON));
            builder.client(okClient);

            Retrofit retrofitApi = builder.build();

            api = retrofitApi.create(IAPI.class);
        }

        return api;
    }

}

