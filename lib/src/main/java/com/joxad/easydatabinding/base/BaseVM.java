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
    protected final Context context;
    /**
     * Class Model used in your IVM
     */

    protected T model;

    /***
     * @param context
     * @param model
     */
    public BaseVM(Context context, T model) {
        this.context = context;
        this.model = model;
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

    public T getModel() {
        return model;
    }
}
