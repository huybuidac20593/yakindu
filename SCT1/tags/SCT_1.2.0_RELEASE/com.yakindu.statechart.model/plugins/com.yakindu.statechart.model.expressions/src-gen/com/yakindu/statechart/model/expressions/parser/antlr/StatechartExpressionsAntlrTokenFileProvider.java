/*
* generated by Xtext
*/
package com.yakindu.statechart.model.expressions.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class StatechartExpressionsAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("com/yakindu/statechart/model/expressions/parser/antlr/internal/InternalStatechartExpressions.tokens");
	}
}
