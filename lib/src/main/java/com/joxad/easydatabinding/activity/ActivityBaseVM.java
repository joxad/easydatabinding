package com.joxad.easydatabinding.activity;


import android.databinding.BaseObservable;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.view.MenuItem;

import com.joxad.easydatabinding.base.IVM;

/**
 * Created by josh on 13/04/16.
 */
public abstract class ActivityBaseVM<A extends ActivityBase, B extends ViewDataBinding> extends BaseObservable implements IVM {

    /***
     *
     */
    protected A activity;
    /***
     *
     */
    protected B binding;

    /***
     * @param activity
     * @param binding
     */
    public ActivityBaseVM(A activity, B binding) {
        this.activity = activity;
        this.binding = binding;
        init();
    }

    /***
     * LifeCycle of the Activity
     */
    protected void onResume() {

    }

    /***
     * LifeCycle of the Activity
     */
    protected void onPause() {

    }

    /***
     * Manage the backpressed
     *
     * @return true if u want to call super
     */
    protected boolean onBackPressed() {
        return true;
    }

    /**
     * PostCreate
     *
     * @param savedInstanceState
     */
    public void onPostCreate(Bundle savedInstanceState) {
    }

    /**
     * Manage item
     *
     * @param item
     * @return
     */
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }
}