package com.joxad.easydatabinding.activity;

import android.content.Intent;

/**
 * Created by josh on 13/04/16.
 */
public interface IActivityVM {

    void onActivityResult(int requestCode, int resultCode, Intent data);

    void onNewIntent(Intent intent);
}
