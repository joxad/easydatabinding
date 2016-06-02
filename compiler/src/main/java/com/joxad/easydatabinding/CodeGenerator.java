package com.joxad.easydatabinding;

import com.joxad.easydatabinding.utils.AndroidUtils;
import com.joxad.easydatabinding.utils.Utils;
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
public final class CodeGenerator {

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
    /*    extends ActivityBase<ActivityMainBinding, ActivityMainVM> {
            @Override
            public int data() {
                return com.joxad.easydatabinding.app.BR.activityMainVM;
            }

            @Override
            public int layoutResources() {
                return R.layout.activity_main;
            }

            @Override
            public ActivityMainVM baseActivityVM(ActivityMainBinding
            binding, Bundle savedInstanceState) {
                return new ActivityMainVM(this, binding);
            }*/
        String generatedClassName = annotatedClass.annotatedClassName + "_";
        ClassName activityBinding = ClassName.get("com.joxad.easydatabinding.app.databinding", "ActivityMainBinding");
        ClassName activityVMClass = ClassName.get("com.joxad.easydatabinding.app", "ActivityMainVM");

        ClassName activityClass = ClassName.get(String.format("%s.%s", AndroidUtils.PACKAGE_DATA_BINDING,
                AndroidUtils.PACKAGE_DATA_BINDING_ACTIVITY), AndroidUtils.CLASS_BASEACTIVITY);

        TypeName baseModelVM = ParameterizedTypeName.get(activityClass, activityBinding, activityVMClass);

        //Init Method
        MethodSpec data = MethodSpec.methodBuilder("data")
                .addAnnotation(Override.class)
                .addModifiers(Modifier.PUBLIC)
                .addStatement(String.format("return %s.BR.activityMainVM", packageName))
                .returns(int.class).build();

        //destroy Method
        MethodSpec layoutResources = MethodSpec.methodBuilder("layoutResources")
                .addAnnotation(Override.class)
                .addModifiers(Modifier.PUBLIC)
                .addStatement(String.format("return %s.R.layout.activity_main",packageName))
                .returns(int.class).build();


        //destroy Method
       /* MethodSpec baseActivityVM = MethodSpec.methodBuilder("baseActivityVM")
                .addParameter(ParameterSpec.builder())
                .addAnnotation(Override.class)
                .addModifiers(Modifier.PUBLIC)
                .addStatement("return new ActivityMainVM(this, binding)", packageName)
                .returns(Integer.class).build();*/


        //Building the VM class
        TypeSpec.Builder builder = TypeSpec.classBuilder(generatedClassName)
                .addModifiers(Modifier.PUBLIC)
                .superclass(baseModelVM)
                .addMethod(data)
                .addMethod(layoutResources);

        for (VariableElement variableElement : annotatedClass.variableNames) {

            String parameter = variableElement.getSimpleName().toString();
            String parameterUpperCase = Utils.upperCaseFirstLetter(parameter);

            MethodSpec get = MethodSpec.methodBuilder(String.format("get%s", parameterUpperCase))
                    .returns(Utils.getTypeName(variableElement.asType()))
                    .addStatement(String.format("return this.model.get%s()", parameterUpperCase))
                    .addAnnotation(annotationBindable())
                    .addModifiers(Modifier.PUBLIC).build();

            MethodSpec set = MethodSpec.methodBuilder(String.format("set%s", parameterUpperCase))
                    .addParameter(Utils.getTypeName(variableElement.asType()), variableElement.getSimpleName().toString())
                    .addStatement(String.format("this.model.set%s(%s)", parameterUpperCase, variableElement))
                    .addModifiers(Modifier.PUBLIC).build();
            builder.addMethod(get);
            builder.addMethod(set);
        }

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

        String parameterModelClass = Utils.lowerCaseFirstLetter(modelClass.simpleName());
        ClassName baseVMClass = ClassName.get(String.format("%s.%s", AndroidUtils.PACKAGE_DATA_BINDING,
                AndroidUtils.PACKAGE_DATA_BINDING_BASE), AndroidUtils.CLASS_BASEVM);
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
            String parameterUpperCase = Utils.upperCaseFirstLetter(parameter);

            MethodSpec get = MethodSpec.methodBuilder(String.format("get%s", parameterUpperCase))
                    .returns(Utils.getTypeName(variableElement.asType()))
                    .addStatement(String.format("return this.model.get%s()", parameterUpperCase))
                    .addAnnotation(annotationBindable())
                    .addModifiers(Modifier.PUBLIC).build();

            MethodSpec set = MethodSpec.methodBuilder(String.format("set%s", parameterUpperCase))
                    .addParameter(Utils.getTypeName(variableElement.asType()), variableElement.getSimpleName().toString())
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
        return ClassName.get(AndroidUtils.PACKAGE_ANDROID_DATA_BINDING, AndroidUtils.CLASS_BINDABLE);
    }


    private static ParameterSpec contextParameter() {
        return ParameterSpec.builder(AndroidUtils.PACKAGE_CONTEXT, AndroidUtils.CONTEXT).build();
    }
}
