package com.joxad.easydatabinding.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by josh on 13/04/16.
 */
public interface IVM {

    /***
     * This method is used to instantiate the data of your viewmodel / its components
     */
    void onCreate(@Nullable Bundle savedInstance);

    void onResume();

    void onPause();

    void onDestroy();
}
