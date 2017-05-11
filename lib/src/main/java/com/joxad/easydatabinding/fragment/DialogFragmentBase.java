
package com.joxad.easydatabinding.fragment;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joxad.easydatabinding.activity.IPermission;
import com.joxad.easydatabinding.activity.IResult;


/***
 * @param <B>       Class  that need to extends {@link ViewDataBinding}
 * @param <VM>Class that need to extends {@link DialogFragmentBaseVM}
 */
public abstract class DialogFragmentBase<B extends ViewDataBinding, VM extends DialogFragmentBaseVM> extends DialogFragment {

    /***
     * FragmentBinding used in this view
     */
    protected B binding;

    /***
     * The view model that will be used to handle this fragment
     */
    protected VM vm;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, layoutResources(), container, false);
        vm = baseFragmentVM(binding);
        binding.setVariable(data(), vm);
        return binding.getRoot();
    }


    @Override
    public void onResume() {
        super.onResume();
        vm.onResume();
    }

    @Override
    public void onPause() {
        vm.onPause();
        super.onPause();
    }
    /***
     * Handle the permission and give it to the activity
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (vm instanceof IPermission)
            ((IPermission) vm).onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    /***
     * Handle the activity result if you need to use it inside the vm of the fragment
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (vm instanceof IResult)
            ((IResult) vm).onActivityResult(requestCode, resultCode, data);
    }

    /**
     * The int value found in the {@link com.joxad.easydatabinding.BR} class generated by DataBinding
     *
     * @return
     */
    public abstract int data();

    /***
     * @return your layout resources
     */
    @LayoutRes
    public abstract int layoutResources();

    /***
     * @param binding
     * @return the {@link VM} you want to use in this activity
     */
    public abstract VM baseFragmentVM(B binding);
}
