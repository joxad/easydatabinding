package com.joxad.easydatabinding.activity;

import android.content.Intent;

/**
 *
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
