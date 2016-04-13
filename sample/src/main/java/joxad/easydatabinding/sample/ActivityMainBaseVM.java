package joxad.easydatabinding.sample;

import com.joxad.easydatabinding.activity.ActivityBaseVM;

import joxad.easydatabinding.sample.databinding.ActivityMainBinding;

/**
 * Created by josh on 13/04/16.
 */
public class ActivityMainBaseVM extends ActivityBaseVM<ActivityBaseMain, ActivityMainBinding> {
    /***
     * @param activity
     * @param binding
     */
    public ActivityMainBaseVM(ActivityBaseMain activity, ActivityMainBinding binding) {
        super(activity, binding);
    }

    @Override
    public void init() {

    }

    @Override
    public void destroy() {

    }
}
