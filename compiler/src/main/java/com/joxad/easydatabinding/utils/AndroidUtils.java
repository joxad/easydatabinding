package com.joxad.easydatabinding.utils;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.TypeName;

/**
 * Created by josh on 27/05/16.
 */
public class AndroidUtils {

    public final static TypeName PACKAGE_CONTEXT = ClassName.get("android.content", "Context");
    public final static String CONTEXT = "context";


    public final static String PACKAGE_DATA_BINDING = "com.joxad.easydatabinding";
    public final static String PACKAGE_DATA_BINDING_BASE = "base";
    public final static String PACKAGE_DATA_BINDING_ACTIVITY = "activity";

    public final static String PACKAGE_ANDROID_DATA_BINDING = "android.databinding";
    public final static String CLASS_BINDABLE = "Bindable";


    public static final String CLASS_BASEVM = "BaseVM";
    public static final String CLASS_BASEACTIVITY = "ActivityBase";

}
