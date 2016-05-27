package com.joxad.easydatabinding;

import java.util.List;

import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;

public class AnnotatedClass {
    public final String annotatedClassName;
    public final List<VariableElement> variableNames;
    public final TypeElement typeElement;

    public AnnotatedClass(TypeElement typeElement, List<VariableElement> variableNames) {
        this.annotatedClassName = typeElement.getSimpleName().toString();
        this.variableNames = variableNames;
        this.typeElement = typeElement;
    }

    public TypeMirror getType() {
        return typeElement.asType();
    }
}
