package com.joxad.easydatabinding.fragment;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by josh on 13/04/16.
 */
public abstract class FragmentBase<B extends ViewDataBinding, VM extends FragmentBaseVM> extends Fragment {

    protected B binding;
    protected VM vm;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, layoutResources(), container, false);
        binding.setVariable(data(), baseFragmentVM(binding));

        return binding.getRoot();
    }

    public abstract int data();

    @LayoutRes
    public abstract int layoutResources();

    public abstract VM baseFragmentVM(B binding);
}
