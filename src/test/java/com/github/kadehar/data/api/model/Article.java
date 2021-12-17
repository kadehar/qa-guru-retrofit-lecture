package com.github.kadehar.data.api.model;

import com.google.gson.annotations.SerializedName;

public class Article {
    @SerializedName("author")
    public String author;
    @SerializedName("title")
    public String title;
    @SerializedName("description")
    public String description;
    @SerializedName("url")
    public String url;
    @SerializedName("publishedAt")
    public String publishedAt;
}
