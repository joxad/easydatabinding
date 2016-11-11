package joxad.easydatabinding.sample.people;

import android.content.Context;
import android.databinding.Bindable;
import android.view.View;
import android.view.ViewGroup;

import com.joxad.easydatabinding.base.BaseVM;

import joxad.easydatabinding.sample.core.endpoint.PeopleEndpoint;
import joxad.easydatabinding.sample.core.model.Result;

/**
 * Created by josh on 13/04/16.
 */
public class PeopleVM extends BaseVM<Result> {
    private OnSelected onSelected;

    /***
     * @param context
     * @param model
     */
    public PeopleVM(Context context, Result model) {
        super(context, model);
    }

    @Override
    public void onCreate() {

    }

    public void onClick(View view) {
        onSelected.people(model);
    }

    @Bindable
    public String getTransitionName() {
        return model.getUrl();
    }

    @Bindable
    public String getName() {
        return model.getName();
    }


    @Bindable
    public String getHeight() {
        return model.getHeight();
    }
    public PeopleVM setOnSelected(OnSelected onSelected) {
        this.onSelected = onSelected;
        return this;
    }

    public interface OnSelected {
        public void people(Result people);
    }
}
