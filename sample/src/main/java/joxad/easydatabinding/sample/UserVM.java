package joxad.easydatabinding.sample;

import android.content.Context;
import android.databinding.Bindable;

import com.joxad.easydatabinding.base.BaseVM;

/**
 * Created by josh on 13/04/16.
 */
public class UserVM extends BaseVM<User> {
    /***
     * @param context
     * @param model
     */
    public UserVM(Context context, User model) {
        super(context, model);
    }

    @Override
    public void onCreate() {

    }

    @Bindable
    public String getName() {
        return model.name;
    }
}
