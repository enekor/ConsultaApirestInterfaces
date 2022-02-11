package com.example.menulateral.rest;

import com.example.menulateral.Model.restmodel.Person;
import com.example.menulateral.Model.restmodel.Result;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CrudRest {

    @GET("/api")
    Call<Person> getPerson();
}
