package joxad.easydatabinding.sample.people;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.joxad.easydatabinding.activity.ActivityBaseVM;

import joxad.easydatabinding.sample.core.Extra;
import joxad.easydatabinding.sample.core.model.Result;
import joxad.easydatabinding.sample.databinding.ActivityPeopleBinding;

/**
 * Created by Jocelyn on 11/11/2016.
 */
public class ActivityPeopleVM extends ActivityBaseVM<ActivityPeople, ActivityPeopleBinding> {

    public PeopleVM peopleVM;
    /***
     * @param activity
     * @param binding
     */
    public ActivityPeopleVM(ActivityPeople activity, ActivityPeopleBinding binding,@Nullable Bundle savedInstanceState) {
        super(activity, binding,savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        Result result = activity.getIntent().getParcelableExtra(Extra.PEOPLE);
        peopleVM = new PeopleVM(activity, result);
    }
}
