package com.example.adiosesr.androidtraining.network;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {

    @GET("books")
    Call<BookResponse> getBooks();

}