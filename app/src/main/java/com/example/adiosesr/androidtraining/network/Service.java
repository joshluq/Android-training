package com.example.adiosesr.androidtraining.network;

import com.example.adiosesr.androidtraining.models.Body;
import com.example.adiosesr.androidtraining.models.Book;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {

    @GET("books")
    Call<BookResponse> getBooks();

}