package com.joxad.easydatabinding.fragment;

import android.databinding.BaseObservable;
import android.databinding.ViewDataBinding;
import android.os.Handler;
import android.os.Looper;

import com.joxad.easydatabinding.base.IVM;

/***
 * @param <F>      Class that need to extends {@link DialogFragmentBase}
 * @param <B>Class that need to extends {@link ViewDataBinding}
 */
public abstract class DialogFragmentBaseVM<F extends DialogFragmentBase, B extends ViewDataBinding> extends BaseObservable implements IVM {

    private final Handler uiHandler;
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
        this.uiHandler = new Handler(Looper.getMainLooper());
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