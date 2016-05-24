package com.joxad.easydatabindingsample;

import android.app.Activity;
import android.os.Bundle;

import com.joxad.easydatabinding.annotation.ExampleAnnotation;


/**
 * Example activity that uses @ExampleAnnotation to insert code into the bottom
 * of{@link #onCreate}.
 */
@ExampleAnnotation
public class YourActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.your_activity);
    }
}
