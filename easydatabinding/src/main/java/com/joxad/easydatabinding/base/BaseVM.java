package com.joxad.easydatabinding.base;

import android.content.Context;
import android.databinding.BaseObservable;

import com.joxad.easydatabinding.base.VM;

/**
 * {@link T} is the class of your model for all your basics VI
 */
public abstract class BaseVM<T> extends BaseObservable implements VM {


    private final Context context;
    public T model;

    /***
     * @param context
     * @param model
     */
    public BaseVM(Context context, T model) {
        this.context = context;
        this.model = model;
        init();
    }
}
