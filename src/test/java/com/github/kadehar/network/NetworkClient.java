package com.github.kadehar.network;

import com.github.kadehar.network.cache.HttpCache;
import com.github.kadehar.network.interceptors.AuthInterceptor;
import com.github.kadehar.network.interceptors.CacheControlInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class NetworkClient {
    public static OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder()
                .cache(HttpCache.httpCache10MB())
                .addInterceptor(loggingInterceptor())
                .addNetworkInterceptor(new AuthInterceptor())
                .addNetworkInterceptor(new CacheControlInterceptor())
                .build();
    }

    private static HttpLoggingInterceptor loggingInterceptor() {
        return new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);
    }
}
