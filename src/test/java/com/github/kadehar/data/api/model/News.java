package com.github.kadehar.data.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class News {
    @SerializedName("articles")
    public List<Article> articles;
}
