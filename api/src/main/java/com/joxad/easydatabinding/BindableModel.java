package com.joxad.easydatabinding;

import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;

/**
 */
@Target(value = TYPE)
public @interface BindableModel {}