package com.joxad.easydatabinding.app;

import android.os.Bundle;

import com.joxad.easydatabinding.activity.ActivityBase;
import com.joxad.easydatabinding.app.databinding.ActivityMainBinding;


/**
 * Created by josh on 13/04/16.
 */
public class ActivityMain extends ActivityBase<ActivityMainBinding, ActivityMainVM> {
    @Override
    public int data() {
        return com.joxad.easydatabinding.app.BR.activityMainVM;
    }

    @Override
    public int layoutResources() {
        return R.layout.activity_main;
    }

    @Override
    public ActivityMainVM baseActivityVM(ActivityMainBinding binding, Bundle savedInstanceState) {
        return new ActivityMainVM(this, binding);
    }
}
