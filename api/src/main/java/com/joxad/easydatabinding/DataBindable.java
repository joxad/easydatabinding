package com.joxad.easydatabinding;

import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;

/**
 * Create a function in {@link StringUtil} for creating strings.
 */
@Target(value = TYPE)
public @interface DataBindable {}