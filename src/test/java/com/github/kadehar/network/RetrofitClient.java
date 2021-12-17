package com.github.kadehar.network;

import com.github.kadehar.config.ApiConfigHelper;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(ApiConfigHelper.apiBaseUrl())
            .client(NetworkClient.okHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static <T> T createService(Class<T> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
