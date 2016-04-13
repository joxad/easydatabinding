package joxad.easydatabinding.sample;

import com.joxad.easydatabinding.activity.ActivityBase;
import com.joxad.easydatabinding.activity.ActivityBaseVM;

import joxad.easydatabinding.sample.databinding.ActivityMainBinding;



/**
 * Created by josh on 13/04/16.
 */
public class ActivityMain extends ActivityBase<ActivityMainBinding, ActivityMainVM> {
    @Override
    public int data() {
        return joxad.easydatabinding.sample.BR.activityMainVM;
    }

    @Override
    public int layoutResources() {
        return R.layout.activity_main;
    }

    @Override
    public ActivityMainVM baseActivityVM(ActivityMainBinding binding) {
        return new ActivityMainVM(this, binding);
    }
}
