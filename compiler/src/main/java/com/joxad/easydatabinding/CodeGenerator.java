package com.joxad.easydatabinding;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import java.io.File;
import java.io.IOException;

import javax.lang.model.element.Modifier;

import static com.squareup.javapoet.ClassName.get;
import static com.squareup.javapoet.JavaFile.builder;
import static com.squareup.javapoet.MethodSpec.methodBuilder;
import static javax.lang.model.element.Modifier.PUBLIC;

/**
 *
 */
final class CodeGenerator {

    public  static TypeSpec generateClass(String packageName, AnnotatedClass annotatedClass) {

        String generatedClassName = annotatedClass.getClass().getSimpleName() + "Observable";
        //Get name for superclass and interface
        ClassName superClass = ClassName.get(packageName, generatedClassName);

        TypeName context = ClassName.get("android.content", "Context");
        TypeName user = ClassName.get(packageName, "User");

        //Constructor for IronManClass
        MethodSpec constructor = MethodSpec.constructorBuilder()
                .addParameter(context, "context")
                .addParameter(user, "user")
                .addStatement("super($N,$N)", "context", "user")
                .addModifiers(Modifier.PUBLIC).build();
        //Building IronMan class
        TypeSpec typeSpec = TypeSpec.classBuilder(generatedClassName)
                .addModifiers(Modifier.PUBLIC)
                .superclass(superClass)
                .addMethod(constructor)
                .build();

        return typeSpec;
    }

    /**
     * @return a createString() method that takes annotatedClass's type as an input.
     */
    private static MethodSpec makeBindable(AnnotatedClass annotatedClass) {


        StringBuilder builder = new StringBuilder();

        for (String variableName : annotatedClass.variableNames) {
            builder.append("return instance.getModel().name");

        }
        return methodBuilder("getName")
                .addJavadoc("@return string suitable for {@param instance}'s toString()")
                .addModifiers(PUBLIC)
                .addParameter(get(annotatedClass.getType()), "instance")
                .addStatement(builder.toString())
                .returns(String.class)
                .build();
    }
}
