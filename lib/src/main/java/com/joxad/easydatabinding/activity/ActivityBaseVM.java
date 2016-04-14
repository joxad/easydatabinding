package com.joxad.easydatabinding.activity;


import android.databinding.BaseObservable;
import android.databinding.ViewDataBinding;

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
}