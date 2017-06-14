package joxad.easydatabinding.sample.people;

import android.os.Bundle;

import com.android.databinding.library.baseAdapters.BR;
import com.joxad.easydatabinding.activity.ActivityBase;

import joxad.easydatabinding.sample.R;
import joxad.easydatabinding.sample.databinding.ActivityPeopleBinding;

/**
 * Created by Jocelyn on 11/11/2016.
 */

public class ActivityPeople extends ActivityBase<ActivityPeopleBinding, ActivityPeopleVM> {
    @Override
    public int data() {
        return BR.activityPeopleVM;
    }

    @Override
    public int layoutResources() {
        return R.layout.activity_people;
    }

    @Override
    public ActivityPeopleVM baseActivityVM(ActivityPeopleBinding binding, Bundle savedInstanceState) {
        return new ActivityPeopleVM(this,binding,savedInstanceState);
    }
}
