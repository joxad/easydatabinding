package com.joxad.easydatabinding.fragment;

import android.databinding.BaseObservable;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;

import com.joxad.easydatabinding.base.IVM;


/**
 * Created by josh on 13/04/16.
 */
public abstract class FragmentBaseVM<F extends FragmentBase, B extends ViewDataBinding> extends BaseObservable implements IVM {

    protected final Handler handler;
    protected final Handler uiHandler;
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
    public FragmentBaseVM(F fragment, B binding, @Nullable Bundle savedInstance) {
        this.fragment = fragment;
        this.binding = binding;
        this.handler = new Handler();
        this.uiHandler = new Handler(Looper.getMainLooper());
        onCreate(savedInstance);
    }


    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    /**
     * This is optionnal => use it if needed
     */
    @Override
    public void onDestroy() {

    }
}