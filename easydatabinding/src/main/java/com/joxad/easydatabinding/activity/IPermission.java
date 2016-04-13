package com.joxad.easydatabinding.activity;

import android.support.annotation.NonNull;

/**
 * Created by josh on 13/04/16.
 */
public interface IPermission {
    /***
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults);
}
