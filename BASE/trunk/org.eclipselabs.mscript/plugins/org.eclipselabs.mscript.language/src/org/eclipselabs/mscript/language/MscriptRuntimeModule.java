/*
 * generated by Xtext
 */
package org.eclipselabs.mscript.language;

import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipselabs.mscript.language.conversion.MscriptTerminalConverters;
import org.eclipselabs.mscript.language.linking.MscriptLinker;
import org.eclipselabs.mscript.language.parser.EcoreElementFactory;
import org.eclipselabs.mscript.language.scoping.GlobalScopeProvider;

/**
 * Use this class to register components to be used within the IDE.
 */
public class MscriptRuntimeModule extends org.eclipselabs.mscript.language.AbstractMscriptRuntimeModule {

	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return MscriptTerminalConverters.class;
	}
	
	public Class<? extends org.eclipse.xtext.parser.IAstFactory> bindIAstFactory() {
		return EcoreElementFactory.class;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.AbstractMscriptRuntimeModule#bindIGlobalScopeProvider()
	 */
	@Override
	public Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return GlobalScopeProvider.class;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.service.DefaultRuntimeModule#bindILinker()
	 */
	@Override
	public Class<? extends ILinker> bindILinker() {
		return MscriptLinker.class;
	}

}
