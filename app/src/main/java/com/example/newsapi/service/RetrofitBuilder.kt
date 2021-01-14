package com.example.newsapi.service

import retrofit2.Call
import com.example.newsapi.model.ResponseNews
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers


object RetrofitBuilder {
    private val client = OkHttpClient.Builder().build()
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun getservice() = retrofit.create(TopHeadlines::class.java)
}

interface TopHeadlines{
    @Headers("Authorization: 463a5c88b0ab4c5eb0091d3bbd5f8849")
    @GET ("/v2/top-headlines?country=id")
    fun fetchHeadlines(): Call<ResponseNews>
}