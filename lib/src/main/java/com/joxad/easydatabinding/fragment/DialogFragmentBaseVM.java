package com.joxad.easydatabinding.fragment;

import android.databinding.BaseObservable;
import android.databinding.ViewDataBinding;

import com.joxad.easydatabinding.base.IVM;


/**
 * Created by josh on 13/04/16.
 */
public abstract class DialogFragmentBaseVM<F extends DialogFragmentBase, B extends ViewDataBinding> extends BaseObservable implements IVM {

    /***
     * {@link F} is the fragment that use the current VM
     */
    protected F fragment;
    /**
     * {@link B} will be used to find the views inside the fragment
     */
    protected B binding;

    /***
     * @param
     * @param binding
     */
    public DialogFragmentBaseVM(F fragment, B binding) {
        this.fragment = fragment;
        this.binding = binding;
        init();
    }

    /***
     * LifeCycle of the Fragment
     */
    protected void onResume() {

    }

    /***
     * LifeCycle of the fragment
     */
    protected void onPause() {

    }

    public abstract void init();
}