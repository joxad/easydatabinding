package joxad.easydatabinding.sample;

import com.joxad.easydatabinding.activity.ActivityBase;

import joxad.easydatabinding.sample.databinding.ActivityMainBinding;

/**
 *
 */
public class ActivityBaseMain extends ActivityBase<ActivityMainBinding,ActivityMainBaseVM> {

    @Override
    public int data() {
        return joxad.easydatabinding.sample.BR.mainActivityVM;
    }

    @Override
    public int layoutResources() {
        return R.layout.activity_main;
    }

    @Override
    public ActivityMainBaseVM baseActivityVM(ActivityMainBinding binding) {
        return new ActivityMainBaseVM(this, binding);
    }

}
