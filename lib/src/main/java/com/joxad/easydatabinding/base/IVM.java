package com.joxad.easydatabinding.base;

/**
 * Created by josh on 13/04/16.
 */
public interface IVM {

    /***
     * This method is used to instantiate the data of your viewmodel / its components
     */
    void init();

    /***
     * This method is called when you have o clear subscription when using Reactive for example
     */
    void destroy();
}
