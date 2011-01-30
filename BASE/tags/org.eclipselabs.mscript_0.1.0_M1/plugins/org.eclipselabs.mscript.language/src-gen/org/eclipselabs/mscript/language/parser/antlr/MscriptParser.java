/*
* generated by Xtext
*/
package org.eclipselabs.mscript.language.parser.antlr;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

import com.google.inject.Inject;

import org.eclipselabs.mscript.language.services.MscriptGrammarAccess;

public class MscriptParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private MscriptGrammarAccess grammarAccess;
	
	@Override
	protected IParseResult parse(String ruleName, CharStream in) {
		TokenSource tokenSource = createLexer(in);
		XtextTokenStream tokenStream = createTokenStream(tokenSource);
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
		org.eclipselabs.mscript.language.parser.antlr.internal.InternalMscriptParser parser = createParser(tokenStream);
		parser.setTokenTypeMap(getTokenDefProvider().getTokenDefMap());
		parser.setSyntaxErrorProvider(getSyntaxErrorProvider());
		parser.setUnorderedGroupHelper(getUnorderedGroupHelper().get());
		try {
			if(ruleName != null)
				return parser.parse(ruleName);
			return parser.parse();
		} catch (Exception re) {
			throw new ParseException(re.getMessage(),re);
		}
	}
	
	protected org.eclipselabs.mscript.language.parser.antlr.internal.InternalMscriptParser createParser(XtextTokenStream stream) {
		return new org.eclipselabs.mscript.language.parser.antlr.internal.InternalMscriptParser(stream, getElementFactory(), getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "Module";
	}
	
	public MscriptGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(MscriptGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
