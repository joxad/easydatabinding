package com.joxad.easydatabinding.processor;

import com.joxad.easydatabinding.AnnotatedClass;
import com.joxad.easydatabinding.utils.ClassValidator;
import com.joxad.easydatabinding.utils.NoPackageNameException;
import com.joxad.easydatabinding.utils.Utils;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;

import static com.squareup.javapoet.JavaFile.builder;
import static java.util.Collections.singleton;
import static javax.lang.model.SourceVersion.latestSupported;
import static javax.tools.Diagnostic.Kind.ERROR;

/**
 * Created by josh on 27/05/16.
 */
public abstract class BaseProcessor extends AbstractProcessor {

    private Messager messager;

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        ArrayList<AnnotatedClass> annotatedClasses = new ArrayList<>();
        for (Element annotatedElement : roundEnvironment.getElementsAnnotatedWith(annotation())) {
            TypeElement annotatedClass = (TypeElement) annotatedElement;
            if (!isValidClass(annotatedClass)) {
                return true;
            }
            try {
                annotatedClasses.add(buildAnnotatedClass(annotatedClass));
            } catch (NoPackageNameException | IOException e) {
                String message = String.format("Couldn't process class %s: %s", annotatedClass,
                        e.getMessage());
                messager.printMessage(ERROR, message, annotatedElement);
            }
        }
        try {
            generate(annotatedClasses);
        } catch (NoPackageNameException | IOException e) {
            messager.printMessage(ERROR, "Couldn't generate class");
        }
        return true;
    }

    private boolean isValidClass(TypeElement annotatedClass) {

        if (!ClassValidator.isPublic(annotatedClass)) {
            String message = String.format("Classes annotated with %s must be public.",
                    annotationName());
            messager.printMessage(ERROR, message, annotatedClass);
            return false;
        }

        if (ClassValidator.isAbstract(annotatedClass)) {
            String message = String.format("Classes annotated with %s must not be abstract.",
                    annotationName());
            messager.printMessage(ERROR, message, annotatedClass);
            return false;
        }

        return true;
    }

    private AnnotatedClass buildAnnotatedClass(TypeElement annotatedClass)
            throws NoPackageNameException, IOException {
        ArrayList<VariableElement> variableNames = new ArrayList<>();
        for (Element element : annotatedClass.getEnclosedElements()) {
            if (!(element instanceof VariableElement)) {
                continue;
            }
            VariableElement variableElement = (VariableElement) element;
            variableNames.add(variableElement);
        }
        return new AnnotatedClass(annotatedClass, variableNames);
    }

    /***
     * * @param annos
     *
     * @throws NoPackageNameException
     * @throws IOException
     */
    private void generate(List<AnnotatedClass> annos) throws NoPackageNameException, IOException {
        if (annos.size() == 0) {
            return;
        }
        for (AnnotatedClass annotatedClass : annos) {
            String packageName = Utils.getPackageName(processingEnv.getElementUtils(), annotatedClass.typeElement);

            JavaFile javaFile = builder(packageName, generateTypeSpec(packageName, annotatedClass)).build();
            javaFile.writeTo(processingEnv.getFiler());
        }

    }


    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        messager = processingEnv.getMessager();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return singleton(canonicalName());
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return latestSupported();
    }

    /**
     * Name of the annotation to handle
     *
     * @return
     */
    public abstract Class<? extends Annotation> annotation();

    public abstract String canonicalName();

    /***
     * Implements this method to generate the class your need according to the @Annotation that is handled
     *
     * @return
     * @param packageName
     * @param annotatedClass
     */
    public abstract TypeSpec generateTypeSpec(String packageName, AnnotatedClass annotatedClass);

    public String annotationName() {
        return "@" + annotation().getSimpleName();
    }

}
