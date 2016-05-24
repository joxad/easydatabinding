package com.joxad.easydatabinding.compiler;

import javax.lang.model.element.TypeElement;

class NoPackageNameException extends Exception {

  public NoPackageNameException(TypeElement typeElement) {
    super("The package of " + typeElement.getSimpleName() + " has no name");
  }
}