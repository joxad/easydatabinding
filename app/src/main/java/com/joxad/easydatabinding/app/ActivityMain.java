package com.joxad.easydatabinding.app;

import com.joxad.easydatabinding.BindableActivity;
import com.joxad.easydatabinding.activity.ActivityBase;
import com.joxad.easydatabinding.app.databinding.ActivityMainBinding;

/**
 * Created by josh on 13/04/16.
 */
@BindableActivity(layout = R.layout.activity_main, data = BR.activityMainVM)
public class ActivityMain extends ActivityBase<ActivityMainBinding, ActivityMainVM> {
/*
 @Override
    public int data() {
        return BR.activityMainVM;
    }

    @Override
    public int layoutResources() {
        return R.layout.activity_main;
    }

    @Override
    public ActivityMainVM baseActivityVM(ActivityMainBinding binding, Bundle savedInstanceState) {
        return new ActivityMainVM(this,binding);
    }
 */
}
