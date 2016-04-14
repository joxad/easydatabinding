package joxad.easydatabinding.sample;

import android.databinding.ObservableArrayList;

import com.joxad.easydatabinding.activity.ActivityBaseVM;

import joxad.easydatabinding.sample.databinding.ActivityMainBinding;
import me.tatarka.bindingcollectionadapter.ItemView;

import static joxad.easydatabinding.sample.BR.userVM;
import static joxad.easydatabinding.sample.R.layout.item_user;


/**
 *
 */
public class ActivityMainVM extends ActivityBaseVM<ActivityMain, ActivityMainBinding> {

    /***
     * This is the itemView view that will put the user in the
     */
    public ItemView itemView = ItemView.of(userVM, item_user);

    public ObservableArrayList<UserVM> items;

    /***
     * @param activity
     * @param binding
     */
    public ActivityMainVM(ActivityMain activity, ActivityMainBinding binding) {
        super(activity, binding);
    }

    @Override
    public void init() {
        items = new ObservableArrayList<>();
        for (int i = 0; i < 10; i++) {
            items.add(new UserVM(activity, new User("User" + i)));
        }

    }

    @Override
    public void destroy() {

    }
}
