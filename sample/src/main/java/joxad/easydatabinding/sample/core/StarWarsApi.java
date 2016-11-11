package joxad.easydatabinding.sample.core;

import android.content.Context;

import java.util.List;

import joxad.easydatabinding.sample.core.endpoint.PeopleEndpoint;
import joxad.easydatabinding.sample.core.model.PeopleResult;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jocelyn on 11/11/2016.
 */

public enum  StarWarsApi {

    INSTANCE;
    public Retrofit retrofit;
    PeopleEndpoint peopleEndpoint;
    private final String baseUrl = "http://swapi.co/api/";

    public void init(Context context) {
        retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        peopleEndpoint = retrofit.create(PeopleEndpoint.class);
    }


    public Call<PeopleResult> people() {
        return peopleEndpoint.people();
    }
}
