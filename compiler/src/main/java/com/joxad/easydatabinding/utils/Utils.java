package com.joxad.easydatabinding.utils;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.TypeName;

import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.ErrorType;
import javax.lang.model.type.PrimitiveType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.SimpleTypeVisitor6;

public final class Utils {

    private Utils() {
        // no instances
    }

    public static String getPackageName(Elements elementUtils, TypeElement type)
            throws NoPackageNameException {
        PackageElement pkg = elementUtils.getPackageOf(type);
        if (pkg.isUnnamed()) {
            throw new NoPackageNameException(type);
        }
        return pkg.getQualifiedName().toString();
    }

    /***
     * Facility method to generate getter/setter
     *
     * @param str
     * @return
     */
    public static String upperCaseFirstLetter(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    /***
     * Facility method to generate getter/setter
     *
     * @param str
     * @return
     */
    public static String lowerCaseFirstLetter(String str) {
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }


    /**
     * Returns a string for {@code type}. Primitive types are always boxed.
     */
    public static TypeName getTypeName(TypeMirror type) {
        return type.accept(new SimpleTypeVisitor6<TypeName, Void>() {
            @Override
            public TypeName visitPrimitive(PrimitiveType primitiveType, Void v) {
                return box(primitiveType);
            }

            @Override
            public TypeName visitError(ErrorType errorType, Void v) {
                // Error type found, a type may not yet have been generated, but we need the type
                // so we can generate the correct code in anticipation of the type being available
                // to the compiler.

                // Paramterized types which don't exist are returned as an error type whose name is "<any>"
                if ("<any>".equals(errorType.toString())) {
                    try {
                        throw new Exception("");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


                return ClassName.bestGuess(errorType.toString());
            }

            @Override
            protected TypeName defaultAction(TypeMirror typeMirror, Void v) {
                return TypeName.get(typeMirror);
            }
        }, null);
    }


    public static TypeName box(PrimitiveType primitiveType) {
        switch (primitiveType.getKind()) {
            case BYTE:
                return ClassName.get(Byte.class);
            case SHORT:
                return ClassName.get(Short.class);
            case INT:
                return ClassName.get(Integer.class);
            case LONG:
                return ClassName.get(Long.class);
            case FLOAT:
                return ClassName.get(Float.class);
            case DOUBLE:
                return ClassName.get(Double.class);
            case BOOLEAN:
                return ClassName.get(Boolean.class);
            case CHAR:
                return ClassName.get(Character.class);
            case VOID:
                return ClassName.get(Void.class);
            default:
                throw new AssertionError();
        }
    }

}
