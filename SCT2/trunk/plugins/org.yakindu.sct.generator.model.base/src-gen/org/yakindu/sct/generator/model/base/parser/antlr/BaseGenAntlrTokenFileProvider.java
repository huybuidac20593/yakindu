/*
* generated by Xtext
*/
package org.yakindu.sct.generator.model.base.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class BaseGenAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("org/yakindu/sct/generator/model/base/parser/antlr/internal/InternalBaseGen.tokens");
	}
}
