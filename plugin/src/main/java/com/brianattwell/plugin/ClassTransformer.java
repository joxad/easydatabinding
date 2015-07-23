package com.brianattwell.plugin;

import com.brianattwell.annotation.ExampleAnnotation;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.build.IClassTransformer;
import javassist.build.JavassistBuildException;

import static com.github.stephanenicolas.morpheus.commons.JavassistUtils.isActivity;

public class ClassTransformer implements IClassTransformer {

    @Override
    public void applyTransformations(CtClass ctClass) throws JavassistBuildException {
        System.out.println(":plugin:applyTransformations on " + ctClass.getName());
        try {
            CtMethod[] methods = getOnCreateMethod(ctClass);
            for (CtMethod method : methods) {
                method.insertAfter("android.util.Log.d(\"MOO\", \"I am inserted code!\");");
            }
        } catch (Exception e) {
            throw new JavassistBuildException(e);
        }
    }

    @Override
    public boolean shouldTransform(CtClass candidateClass) throws JavassistBuildException {
        try {
            return candidateClass.hasAnnotation(ExampleAnnotation.class)
                    && isAnActivity(candidateClass);
        } catch (Exception e) {
            throw new JavassistBuildException(e);
        }
    }

    private static boolean isAnActivity(CtClass candidateClass) throws NotFoundException {
        // TODO: handle support activity
        return isActivity(candidateClass);
    }

    private CtMethod[] getOnCreateMethod(CtClass ctClass)
            throws NotFoundException {
        String className = ctClass.getName();
        ClassPool pool = ctClass.getClassPool();

        CtMethod c1 = pool.get(className).getMethod("onCreate",
                "(Landroid/os/Bundle;Landroid/os/PersistableBundle;)V");
        CtMethod c2 = pool.get(className).getMethod("onCreate",
                "(Landroid/os/Bundle;)V");
        return new CtMethod[] {c1, c2};
    }
}


