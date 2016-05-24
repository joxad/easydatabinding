package joxad.easydatabinding.sample;

import com.joxad.easydatabinding.annotation.DataBindable;

/**
 * Created by josh on 13/04/16.
 */
@DataBindable
public class User {

    public String name;

    public User(String s) {
        name = s;
    }

    @Override
    public String toString() {
        return "";
    }
}
