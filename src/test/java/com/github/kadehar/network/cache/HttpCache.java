package com.github.kadehar.network.cache;

import com.github.kadehar.base.Constants;
import okhttp3.Cache;

import java.io.File;

public class HttpCache {
    public static Cache httpCache10MB() {
        return new Cache(
                new File("src/test/resources/cache/"),
                Constants.CACHE_SIZE_10_MB
        );
    }
}
