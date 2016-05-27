package com.joxad.easydatabinding;

import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;

/**
 * Created by josh on 27/05/16.
 */
@Target(value = TYPE)
public @interface BindableActivity {
    int layout();
    int data();
}
