package com.joxad.easydatabinding.processor;

import com.google.auto.service.AutoService;
import com.joxad.easydatabinding.AnnotatedClass;
import com.joxad.easydatabinding.BindableActivity;
import com.joxad.easydatabinding.CodeGenerator;
import com.squareup.javapoet.TypeSpec;

import java.lang.annotation.Annotation;

import javax.annotation.processing.Processor;

@AutoService(Processor.class)
public class BindableActivityProcessor extends BaseProcessor {

    @Override
    public Class<? extends Annotation> annotation() {
        return BindableActivity.class;
    }

    @Override
    public String canonicalName() {
        return BindableActivity.class.getCanonicalName();
    }

    @Override
    public TypeSpec generateTypeSpec(String packageName, AnnotatedClass annotatedClass) {
        return CodeGenerator.generateActivityBaseClass(packageName,annotatedClass);

    }
}

