package com.joxad.easydatabinding.base;

/**
 * Created by josh on 13/04/16.
 */
public interface IVM {

    /***
     * This method is used to instantiate the data of your viewmodel / its components
     */
    void onCreate();

    void onResume();

    void onPause();

    void onDestroy();
}
