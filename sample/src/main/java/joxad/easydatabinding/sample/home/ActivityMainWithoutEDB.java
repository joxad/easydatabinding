package joxad.easydatabinding.sample.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import joxad.easydatabinding.sample.R;
import joxad.easydatabinding.sample.BR;
import joxad.easydatabinding.sample.databinding.ActivityMainBinding;

/**
 * Created by Jocelyn on 11/11/2016.
 */

public class ActivityMainWithoutEDB extends AppCompatActivity {


    private ActivityMainBinding binding;
    private ActivityMainVM activityMainVM;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setVariable(BR.activityMainVM, binding);
    }


    @Override
    protected void onResume() {
        super.onResume();
        activityMainVM.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        activityMainVM.onPause();
    }
}
