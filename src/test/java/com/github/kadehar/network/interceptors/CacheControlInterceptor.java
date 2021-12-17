package com.github.kadehar.network.interceptors;

import com.github.kadehar.base.Constants;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class CacheControlInterceptor implements Interceptor {
    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();
        Response original = chain.proceed(request);

        boolean shouldUseCache = !Objects.equals(
                request.header(Constants.CACHE_CONTROL_HEADER),
                Constants.CACHE_CONTROL_NO_CACHE
        );

        if (!shouldUseCache) {
            return original;
        }

        CacheControl cacheControl = new CacheControl.Builder()
                .maxAge(10, TimeUnit.MINUTES)
                .build();

        return original.newBuilder()
                .header(
                        Constants.CACHE_CONTROL_HEADER,
                        cacheControl.toString()
                )
                .build();
    }
}
