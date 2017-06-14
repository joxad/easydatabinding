package joxad.easydatabinding.sample.home;

import android.content.Intent;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.joxad.easydatabinding.activity.ActivityBaseVM;

import joxad.easydatabinding.sample.core.Extra;
import joxad.easydatabinding.sample.core.StarWarsApi;
import joxad.easydatabinding.sample.core.model.PeopleResult;
import joxad.easydatabinding.sample.core.model.Result;
import joxad.easydatabinding.sample.databinding.ActivityMainBinding;
import joxad.easydatabinding.sample.people.ActivityPeople;
import joxad.easydatabinding.sample.people.PeopleVM;
import me.tatarka.bindingcollectionadapter2.ItemBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static joxad.easydatabinding.sample.BR.peopleVM;
import static joxad.easydatabinding.sample.R.layout.item_people;


/**
 *
 */
public class ActivityMainVM extends ActivityBaseVM<ActivityMain, ActivityMainBinding> {

    /***
     * This is the itemView view that will put the user in the
     */
    public ItemBinding<PeopleVM> itemView = ItemBinding.of(peopleVM, item_people);

    public ObservableArrayList<PeopleVM> items;

    /***
     * @param activity
     * @param binding
     */
    public ActivityMainVM(ActivityMain activity, ActivityMainBinding binding,@Nullable Bundle savedInstanceState) {
        super(activity, binding, savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        StarWarsApi.INSTANCE.init(activity);
        items = new ObservableArrayList<>();
        items.clear();
        StarWarsApi.INSTANCE.people().enqueue(new Callback<PeopleResult>() {
            @Override
            public void onResponse(Call<PeopleResult> call, Response<PeopleResult> response) {
                for (Result people : response.body().getResults()) {
                    items.add(new PeopleVM(activity, people).setOnSelected(new PeopleVM.OnSelected() {
                        @Override
                        public void people(Result people) {
                            goToActivityPeople(people);
                        }
                    }));
                }
            }

            @Override
            public void onFailure(Call<PeopleResult> call, Throwable t) {
                Log.d(ActivityMain.class.getSimpleName(), t.getLocalizedMessage());
            }
        });


    }


    private void goToActivityPeople(Result people) {
        activity.startActivity(new Intent(activity, ActivityPeople.class).putExtra(Extra.PEOPLE, people));
    }
}
