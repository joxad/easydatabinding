package com.joxad.easydatabinding;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import javax.lang.model.element.VariableElement;

/**
 *
 */
public final class BaseVMCodeGenerator {

    public static TypeSpec generateClass(String packageName, AnnotatedClass annotatedClass) {

        String generatedClassName = "UserVMObservable";
        //Get name for superclass and interface
        ClassName superClass = ClassName.get(packageName, "UserVM");

        TypeName context = ClassName.get("android.content", "Context");
        TypeName user = ClassName.get(packageName, "User");

        //Constructor for IronManClass
        MethodSpec constructor = MethodSpec.constructorBuilder()
                .addParameter(context, "context")
                .addParameter(user, "user")
                .addStatement("super($N,$N)", "context", "user")
                .addModifiers(Modifier.PUBLIC).build();
        //Building IronMan class
        TypeSpec.Builder builder = TypeSpec.classBuilder(generatedClassName)
                .addModifiers(Modifier.PUBLIC)
                .superclass(superClass)
                .addMethod(constructor);

        return builder.build();
    }


    public static TypeSpec generateActivityBaseClass(String packageName, AnnotatedClass annotatedClass) {

        //Building the VM class
        TypeSpec.Builder builder = TypeSpec.classBuilder("");
        return builder.build();
    }


    /****
     * @param packageName
     * @param annotatedClass
     * @return
     */
    public static TypeSpec generateBaseVMClass(String packageName, AnnotatedClass annotatedClass) {

        String generatedClassName = annotatedClass.annotatedClassName + "VM_";
        ClassName modelClass = ClassName.get(packageName, annotatedClass.annotatedClassName);
        String parameterModelClass = com.joxad.easydatabinding.utils.Utils.lowerCaseFirstLetter(modelClass.simpleName());
        ClassName baseVMClass = ClassName.get(String.format("%s.%s", com.joxad.easydatabinding.utils.AndroidUtils.PACKAGE_DATA_BINDING, com.joxad.easydatabinding.utils.AndroidUtils.PACKAGE_DATA_BINDING_BASE), com.joxad.easydatabinding.utils.AndroidUtils.CLASS_BASEVM);
        TypeName baseModelVM = ParameterizedTypeName.get(baseVMClass, modelClass);


        //Init Method
        MethodSpec init = MethodSpec.methodBuilder("init")
                .addAnnotation(Override.class)
                .addModifiers(Modifier.PUBLIC).build();

        //destroy Method
        MethodSpec destroy = MethodSpec.methodBuilder("destroy")
                .addAnnotation(Override.class)
                .addModifiers(Modifier.PUBLIC).build();

        //Building the VM class
        TypeSpec.Builder builder = TypeSpec.classBuilder(generatedClassName)
                .addModifiers(Modifier.PUBLIC)
                .superclass(baseModelVM)
                .addMethod(contextConstructor(ParameterSpec.builder(modelClass, parameterModelClass).build()))
                .addMethod(init)
                .addMethod(destroy);

        for (VariableElement variableElement : annotatedClass.variableNames) {

            String parameter = variableElement.getSimpleName().toString();
            String parameterUpperCase = com.joxad.easydatabinding.utils.Utils.upperCaseFirstLetter(parameter);

            MethodSpec get = MethodSpec.methodBuilder(String.format("get%s", parameterUpperCase))
                    .returns(com.joxad.easydatabinding.utils.Utils.getTypeName(variableElement.asType()))
                    .addStatement(String.format("return this.model.get%s()", parameterUpperCase))
                    .addAnnotation(annotationBindable())
                    .addModifiers(Modifier.PUBLIC).build();

            MethodSpec set = MethodSpec.methodBuilder(String.format("set%s", parameterUpperCase))
                    .addParameter(com.joxad.easydatabinding.utils.Utils.getTypeName(variableElement.asType()), variableElement.getSimpleName().toString())
                    .addStatement(String.format("this.model.set%s(%s)", parameterUpperCase, variableElement))
                    .addModifiers(Modifier.PUBLIC).build();
            builder.addMethod(get);
            builder.addMethod(set);
        }

        return builder.build();
    }


    private static MethodSpec contextConstructor(ParameterSpec modelParameter) {

        //Constructor for IronManClass
        MethodSpec constructor = MethodSpec.constructorBuilder()
                .addParameter(contextParameter())
                .addParameter(modelParameter)
                .addStatement("super($N,$N)", "context", modelParameter)
                .addModifiers(Modifier.PUBLIC).build();
        return constructor;
    }

    /***
     * Use this to get the @Bindable annotation
     *
     * @return
     */
    private static ClassName annotationBindable() {
        return ClassName.get(com.joxad.easydatabinding.utils.AndroidUtils.PACKAGE_ANDROID_DATA_BINDING, com.joxad.easydatabinding.utils.AndroidUtils.CLASS_BINDABLE);
    }


    private static ParameterSpec contextParameter() {
        return ParameterSpec.builder(com.joxad.easydatabinding.utils.AndroidUtils.PACKAGE_CONTEXT, com.joxad.easydatabinding.utils.AndroidUtils.CONTEXT).build();
    }
}
