package com.joxad.easydatabinding.activity;

import android.content.Intent;

/**
 * {@link IResult} will handle the onActivityResult from the activity
 */
public interface IResult {

    /**
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    void onActivityResult(int requestCode, int resultCode, Intent data);


}
