/*
 * generated by Xtext
 */
package org.eclipselabs.damos.mscript.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategyProvider;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipselabs.damos.mscript.ui.autoedit.MscriptAutoEditStrategyProvider;
import org.eclipselabs.damos.mscript.ui.syntaxcoloring.MscriptAntlrTokenToAttributeIdMapper;
import org.eclipselabs.damos.mscript.ui.syntaxcoloring.MscriptHighlightingConfiguration;
import org.eclipselabs.damos.mscript.ui.syntaxcoloring.MscriptSemanticHighlightingCalculator;

/**
 * Use this class to register components to be used within the IDE.
 */
public class MscriptUiModule extends org.eclipselabs.damos.mscript.ui.AbstractMscriptUiModule {

	public MscriptUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	public Class<? extends DefaultAntlrTokenToAttributeIdMapper> bindDefaultAntlrTokenToAttributeIdMapper() {
		return MscriptAntlrTokenToAttributeIdMapper.class;
	}
	
	public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
		return MscriptHighlightingConfiguration.class;
	}
	
	public Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
		return MscriptSemanticHighlightingCalculator.class;
	}

	@Override
	public Class<? extends AbstractEditStrategyProvider> bindAbstractEditStrategyProvider() {
		return MscriptAutoEditStrategyProvider.class;
	}

}
