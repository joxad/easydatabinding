package joxad.easydatabinding.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.joxad.easydatabinding.activity.ActivityBase;

import joxad.easydatabinding.sample.databinding.ActivityMainBinding;

import static joxad.easydatabinding.sample.BR.activityMainVM;
import static joxad.easydatabinding.sample.R.layout.activity_main;

/**
 * Created by josh on 13/04/16.
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
        return new ActivityMainVM(this, binding);
    }


}
