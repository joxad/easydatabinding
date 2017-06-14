package joxad.easydatabinding.sample.home;

import android.os.Bundle;

import com.joxad.easydatabinding.activity.ActivityBase;

import joxad.easydatabinding.sample.databinding.ActivityMainBinding;

import static joxad.easydatabinding.sample.BR.activityMainVM;
import static joxad.easydatabinding.sample.R.layout.activity_main;

/**
 * {@link ActivityMain} generate the code necessary to the data binding to work.
 *
 * @see ActivityMainWithoutEDB to see the difference
 */
public class ActivityMain extends ActivityBase<ActivityMainBinding, ActivityMainVM> {
    @Override
    public int data() {
        return activityMainVM;
    }

    @Override
    public int layoutResources() {
        return activity_main;
    }

    @Override
    public ActivityMainVM baseActivityVM(ActivityMainBinding binding, Bundle savedInstanceState) {
        return new ActivityMainVM(this, binding, savedInstanceState);
    }


}
