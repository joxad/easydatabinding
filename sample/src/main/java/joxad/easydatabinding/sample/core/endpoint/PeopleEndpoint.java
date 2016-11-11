package joxad.easydatabinding.sample.core.endpoint;

import java.util.List;

import joxad.easydatabinding.sample.core.model.PeopleResult;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Jocelyn on 11/11/2016.
 */

public interface PeopleEndpoint {

    @GET("people")
    Call<PeopleResult> people();
}
