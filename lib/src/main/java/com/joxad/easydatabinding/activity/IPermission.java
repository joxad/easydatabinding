package com.joxad.easydatabinding.activity;

import android.support.annotation.NonNull;

/**
 * {@link IPermission} will handle the permission result from the activity
 */
public interface IPermission {
    /***
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults);
}
