package com.joxad.easydatabinding.base;

import android.content.Context;
import android.databinding.BaseObservable;

/**
 * {@link T} is the class of your model for all your basics VI
 */
public abstract class BaseVM<T> extends BaseObservable implements IVM {

    /***
     *
     */
    private final Context context;
    /**
     * Class Model used in your IVM
     */
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
