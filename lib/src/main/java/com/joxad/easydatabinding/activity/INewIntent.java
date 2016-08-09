package com.joxad.easydatabinding.activity;

import android.content.Intent;

/**
 * {@link INewIntent} is used for the activity VM that needs to handle newIntent from the activity
 */
public interface INewIntent {
    /**
     *
     * @param intent
     */
    void onNewIntent(Intent intent);
}
