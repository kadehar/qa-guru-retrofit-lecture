package com.github.kadehar.network.interceptors;

import com.github.kadehar.base.Constants;
import com.github.kadehar.config.ApiConfigHelper;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class AuthInterceptor implements Interceptor {
    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();
        Request auth = request.newBuilder()
                .header(
                        Constants.X_API_KEY_HEADER,
                        ApiConfigHelper.apiKey()
                )
                .build();
        return chain.proceed(auth);
    }
}
