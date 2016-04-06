package com.kubadziworski;

import com.kubadziworski.antlr.EnkelLexer;
import com.kubadziworski.antlr.EnkelParser;
import com.kubadziworski.antlr.domain.global.CompilationUnit;
import com.kubadziworski.parsing.EnkelTreeWalkErrorListener;
import com.kubadziworski.visitor.CompilationUnitVisitor;
import org.antlr.v4.runtime.*;

import java.io.IOException;

/**
 * Created by kuba on 16.03.16.
 */
public class Parser {
    public CompilationUnit getCompilationUnit(String fileAbsolutePath) throws IOException {
        CharStream charStream = new ANTLRFileStream(fileAbsolutePath); //fileAbolutePath - file containing first enk code file
        EnkelLexer lexer = new EnkelLexer(charStream);  //create lexer (pass enk file to it)
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        EnkelParser parser = new EnkelParser(tokenStream);

        ANTLRErrorListener errorListener = new EnkelTreeWalkErrorListener(); //EnkelTreeWalkErrorListener - handles parse tree visiting error events
        parser.addErrorListener(errorListener);

        CompilationUnitVisitor compilationUnitVisitor = new CompilationUnitVisitor();
        return parser.compilationUnit().accept(compilationUnitVisitor);
    }
}
