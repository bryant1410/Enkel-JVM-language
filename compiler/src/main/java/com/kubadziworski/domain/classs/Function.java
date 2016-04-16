package com.kubadziworski.domain.classs;

import com.kubadziworski.domain.expression.FunctionParameter;
import com.kubadziworski.domain.scope.FunctionSignature;
import com.kubadziworski.domain.type.Type;
import com.kubadziworski.domain.statement.Statement;

import java.util.Collections;
import java.util.List;

/**
 * Created by kuba on 28.03.16.
 */
public class Function {

    private final FunctionSignature functionSignature;
    private final Statement rootStatement;


    public Function(FunctionSignature functionSignature, Statement rootStatement) {
        this.functionSignature = functionSignature;
        this.rootStatement = rootStatement;
    }

    public String getName() {
        return functionSignature.getName();
    }

    public List<FunctionParameter> getParameter() {
        return Collections.unmodifiableList(functionSignature.getParameters());
    }

    public Statement getRootStatement() {
        return rootStatement;
    }

    public Type getReturnType() {
        return functionSignature.getReturnType();
    }
}
