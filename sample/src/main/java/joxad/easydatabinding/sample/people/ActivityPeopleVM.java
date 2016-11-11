package joxad.easydatabinding.sample.people;

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
    public ActivityPeopleVM(ActivityPeople activity, ActivityPeopleBinding binding) {
        super(activity, binding);
    }

    @Override
    public void onCreate() {

        Result result = activity.getIntent().getParcelableExtra(Extra.PEOPLE);
        peopleVM = new PeopleVM(activity, result);
    }
}
