package com.joxad.easydatabinding.fragment;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.ViewDataBinding;

import com.joxad.easydatabinding.base.IVM;


/**
 * Created by josh on 13/04/16.
 */
public abstract class FragmentBaseVM<B extends ViewDataBinding> extends BaseObservable implements IVM {


    protected final Context context;
    protected B binding;

    /***
     * @param context
     * @param binding
     */
    public FragmentBaseVM(Context context, B binding) {
        this.context = context;
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

    public abstract void init();
}