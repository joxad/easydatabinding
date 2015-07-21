package com.brianattwell.annotation;

import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;

@Target(value = TYPE)
public @interface ExampleAnnotation {}