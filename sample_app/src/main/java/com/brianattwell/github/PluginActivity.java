package com.brianattwell.github;

import android.app.Activity;
import android.os.Bundle;

import com.brianattwell.annotation.ExampleAnnotation;

@ExampleAnnotation
public class PluginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plugin);
    }
}
