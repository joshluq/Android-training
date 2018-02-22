package com.example.adiosesr.androidtraining.util;

import com.example.adiosesr.androidtraining.network.RetrofitClient;
import com.example.adiosesr.androidtraining.network.Service;

public class ApiUtil {

    public  static final  String BASE_URL = "http://demo9600338.mockable.io/";

    public static Service getService()
    {
        return RetrofitClient.getClient(BASE_URL).create(Service.class);
    }
}
