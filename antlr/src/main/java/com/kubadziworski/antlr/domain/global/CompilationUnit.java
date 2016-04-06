package com.kubadziworski.antlr.domain.global;

import com.kubadziworski.antlr.EnkelParser.ClassDeclarationContext;
import com.kubadziworski.antlr.EnkelParser.CompilationUnitContext;
import com.kubadziworski.antlr.domain.global.ClassDeclaration;

/**
 * Created by kuba on 28.03.16.
 */
public class CompilationUnit {

    private ClassDeclaration classDeclaration;

    public CompilationUnit(ClassDeclaration classDeclaration) {
        this.classDeclaration = classDeclaration;
    }

    public ClassDeclaration getClassDeclaration() {
        return classDeclaration;
    }

    public String getClassName() {
        return classDeclaration.getName();
    }
}
