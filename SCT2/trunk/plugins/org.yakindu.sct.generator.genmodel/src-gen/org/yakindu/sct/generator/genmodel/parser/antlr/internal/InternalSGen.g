/*
* generated by Xtext
*/
grammar InternalSGen;

options {
	superClass=AbstractInternalAntlrParser;
	
}

@lexer::header {
package org.yakindu.sct.generator.genmodel.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.yakindu.sct.generator.genmodel.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.yakindu.sct.generator.genmodel.services.SGenGrammarAccess;

}

@parser::members {

 	private SGenGrammarAccess grammarAccess;
 	
    public InternalSGenParser(TokenStream input, SGenGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "GeneratorModel";	
   	}
   	
   	@Override
   	protected SGenGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleGeneratorModel
entryRuleGeneratorModel returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getGeneratorModelRule()); }
	 iv_ruleGeneratorModel=ruleGeneratorModel 
	 { $current=$iv_ruleGeneratorModel.current; } 
	 EOF 
;

// Rule GeneratorModel
ruleGeneratorModel returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='GeneratorModel' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getGeneratorModelAccess().getGeneratorModelKeyword_0());
    }
	otherlv_1='for' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getGeneratorModelAccess().getForKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getGeneratorModelAccess().getGeneratorIdQIDParserRuleCall_2_0()); 
	    }
		lv_generatorId_2_0=ruleQID		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGeneratorModelRule());
	        }
       		set(
       			$current, 
       			"generatorId",
        		lv_generatorId_2_0, 
        		"QID");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_3='{' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getGeneratorModelAccess().getLeftCurlyBracketKeyword_3());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getGeneratorModelAccess().getEntriesGeneratorEntryParserRuleCall_4_0()); 
	    }
		lv_entries_4_0=ruleGeneratorEntry		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGeneratorModelRule());
	        }
       		add(
       			$current, 
       			"entries",
        		lv_entries_4_0, 
        		"GeneratorEntry");
	        afterParserOrEnumRuleCall();
	    }

)
)+	otherlv_5='}' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getGeneratorModelAccess().getRightCurlyBracketKeyword_5());
    }
)
;





// Entry rule entryRuleGeneratorEntry
entryRuleGeneratorEntry returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getGeneratorEntryRule()); }
	 iv_ruleGeneratorEntry=ruleGeneratorEntry 
	 { $current=$iv_ruleGeneratorEntry.current; } 
	 EOF 
;

// Rule GeneratorEntry
ruleGeneratorEntry returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='statechart' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getGeneratorEntryAccess().getStatechartKeyword_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getGeneratorEntryRule());
	        }
        }
	otherlv_1=RULE_ID
	{
		newLeafNode(otherlv_1, grammarAccess.getGeneratorEntryAccess().getStatechartStatechartCrossReference_1_0()); 
	}

)
)	otherlv_2='{' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getGeneratorEntryAccess().getLeftCurlyBracketKeyword_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getGeneratorEntryAccess().getFeaturesFeatureConfigurationParserRuleCall_3_0()); 
	    }
		lv_features_3_0=ruleFeatureConfiguration		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGeneratorEntryRule());
	        }
       		add(
       			$current, 
       			"features",
        		lv_features_3_0, 
        		"FeatureConfiguration");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_4='}' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getGeneratorEntryAccess().getRightCurlyBracketKeyword_4());
    }
)
;





// Entry rule entryRuleFeatureConfiguration
entryRuleFeatureConfiguration returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getFeatureConfigurationRule()); }
	 iv_ruleFeatureConfiguration=ruleFeatureConfiguration 
	 { $current=$iv_ruleFeatureConfiguration.current; } 
	 EOF 
;

// Rule FeatureConfiguration
ruleFeatureConfiguration returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getFeatureConfigurationAccess().getFeatureConfigurationAction_0(),
            $current);
    }
)(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getFeatureConfigurationRule());
	        }
        }
	otherlv_1=RULE_ID
	{
		newLeafNode(otherlv_1, grammarAccess.getFeatureConfigurationAccess().getTypeFeatureTypeCrossReference_1_0()); 
	}

)
)	otherlv_2='{' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getFeatureConfigurationAccess().getLeftCurlyBracketKeyword_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getFeatureConfigurationAccess().getParameterValuesFeatureParameterValueParserRuleCall_3_0()); 
	    }
		lv_parameterValues_3_0=ruleFeatureParameterValue		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getFeatureConfigurationRule());
	        }
       		add(
       			$current, 
       			"parameterValues",
        		lv_parameterValues_3_0, 
        		"FeatureParameterValue");
	        afterParserOrEnumRuleCall();
	    }

)
)+	otherlv_4='}' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getFeatureConfigurationAccess().getRightCurlyBracketKeyword_4());
    }
)
;





// Entry rule entryRuleFeatureParameterValue
entryRuleFeatureParameterValue returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getFeatureParameterValueRule()); }
	 iv_ruleFeatureParameterValue=ruleFeatureParameterValue 
	 { $current=$iv_ruleFeatureParameterValue.current; } 
	 EOF 
;

// Rule FeatureParameterValue
ruleFeatureParameterValue returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getFeatureParameterValueAccess().getFeatureParameterValueAction_0(),
            $current);
    }
)(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getFeatureParameterValueRule());
	        }
        }
	otherlv_1=RULE_ID
	{
		newLeafNode(otherlv_1, grammarAccess.getFeatureParameterValueAccess().getParameterFeatureParameterCrossReference_1_0()); 
	}

)
)	otherlv_2='=' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getFeatureParameterValueAccess().getEqualsSignKeyword_2());
    }
(
(
		lv_value_3_0=RULE_STRING
		{
			newLeafNode(lv_value_3_0, grammarAccess.getFeatureParameterValueAccess().getValueSTRINGTerminalRuleCall_3_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getFeatureParameterValueRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"value",
        		lv_value_3_0, 
        		"STRING");
	    }

)
))
;





// Entry rule entryRuleQID
entryRuleQID returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getQIDRule()); } 
	 iv_ruleQID=ruleQID 
	 { $current=$iv_ruleQID.current.getText(); }  
	 EOF 
;

// Rule QID
ruleQID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    { 
    newLeafNode(this_ID_0, grammarAccess.getQIDAccess().getIDTerminalRuleCall_0()); 
    }
((
	kw='::' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getQIDAccess().getColonColonKeyword_1_0_0()); 
    }

    |
	kw='.' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getQIDAccess().getFullStopKeyword_1_0_1()); 
    }
)    this_ID_3=RULE_ID    {
		$current.merge(this_ID_3);
    }

    { 
    newLeafNode(this_ID_3, grammarAccess.getQIDAccess().getIDTerminalRuleCall_1_1()); 
    }
)*)
    ;





RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


