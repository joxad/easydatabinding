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

    protected final Handler uiHandler;
    protected final Handler handler;
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
        this.handler = new Handler();

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

    public abstract void onCreate();
}