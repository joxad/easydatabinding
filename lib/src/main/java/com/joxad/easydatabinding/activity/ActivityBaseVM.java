package com.joxad.easydatabinding.activity;


import android.databinding.BaseObservable;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;

import com.joxad.easydatabinding.base.IVM;

/**
 * Created by josh on 13/04/16.
 */
public abstract class ActivityBaseVM<A extends ActivityBase, B extends ViewDataBinding> extends BaseObservable implements IVM {

    protected final Handler uiHandler;
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
        this.uiHandler = new Handler(Looper.getMainLooper());
        onCreate();
    }


    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {

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
     * PostCreate to use if you need the savedInstanceState
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

    /**
     * Handle animation of sharedelement
     */
    public void onEnterAnimationComplete() {

    }
}