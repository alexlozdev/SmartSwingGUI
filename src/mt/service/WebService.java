/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mt.service;

/**
 *
 * @author John
 */
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class WebService {
    public static final String API_URL = "https://www.ugcesports.gg/";
    private static Retrofit mRetrofit = null;
    private static RestInterface mRestInterface = null;

    public static RestInterface getInstance() {
        if (mRetrofit == null) {
            OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .build();

            mRetrofit = new Retrofit.Builder().baseUrl(API_URL)
                                        .client(okHttpClient)
                                        .build();
        }

        if (mRestInterface == null) {
            mRestInterface = mRetrofit.create(RestInterface.class);
        }

        return mRestInterface;
    }

}

