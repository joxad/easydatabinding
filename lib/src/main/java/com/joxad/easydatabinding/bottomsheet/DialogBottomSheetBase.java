package com.joxad.easydatabinding.bottomsheet;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;

import com.joxad.easydatabinding.fragment.DialogFragmentBaseVM;

/***
 * @param <B>Class  that need to extends {@link ViewDataBinding}
 * @param <VM>Class that need to extends {@link DialogFragmentBaseVM}
 */
public abstract class DialogBottomSheetBase<B extends ViewDataBinding, VM extends DialogBottomSheetBaseVM> extends BottomSheetDialogFragment {

    /***
     * FragmentBinding used in this view
     */

    protected B binding;
    /***
     * The view model that will be used to handle this fragment
     */

    protected VM vm;

    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);

        binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), layoutResources(), null, false);
        vm = baseFragmentVM(binding);
        binding.setVariable(data(), vm);
        dialog.setContentView(binding.getRoot());

    }

    @Override
    public void onResume() {
        super.onResume();
        vm.onResume();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        vm.onAttach(context);
    }

    @Override
    public void onPause() {
        super.onPause();
        vm.onPause();
    }

    public abstract int data();

    public abstract int layoutResources();

    public abstract VM baseFragmentVM(B binding);
}