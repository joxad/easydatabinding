package com.joxad.easydatabinding.bottomsheet;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.ViewDataBinding;
import android.os.Handler;
import android.os.Looper;

import com.joxad.easydatabinding.base.IVM;
import com.joxad.easydatabinding.fragment.DialogFragmentBase;


/***
 * @param <F> Class that need to extends {@link DialogFragmentBase}
 * @param <B> Class that need to extends {@link ViewDataBinding}
 */
public abstract class DialogBottomSheetBaseVM<F extends DialogBottomSheetBase, B extends ViewDataBinding> extends BaseObservable implements IVM {

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
    public DialogBottomSheetBaseVM(F fragment, B binding) {
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