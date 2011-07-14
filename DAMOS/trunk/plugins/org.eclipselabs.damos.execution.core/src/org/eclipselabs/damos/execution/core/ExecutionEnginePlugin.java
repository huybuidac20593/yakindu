package org.eclipselabs.damos.execution.core;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.xtext.linking.ILinker;
import org.eclipselabs.mscript.language.MscriptRuntimeModule;
import org.eclipselabs.mscript.language.parser.antlr.MscriptParser;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * The activator class controls the plug-in life cycle
 */
public class ExecutionEnginePlugin extends Plugin {

	private MscriptParser mscriptParser;
	
	private ILinker linker;
	
	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipselabs.damos.execution.core";

	// The shared instance
	private static ExecutionEnginePlugin plugin;
	
	/**
	 * The constructor
	 */
	public ExecutionEnginePlugin() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;

		Injector injector = Guice.createInjector(new MscriptRuntimeModule());
		mscriptParser = injector.getInstance(MscriptParser.class);
		linker = injector.getInstance(ILinker.class);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		mscriptParser = null;
		linker = null;

		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static ExecutionEnginePlugin getDefault() {
		return plugin;
	}
	
	/**
	 * @return the mscriptParser
	 */
	public MscriptParser getMscriptParser() {
		return mscriptParser;
	}
	
	/**
	 * @return the linker
	 */
	public ILinker getLinker() {
		return linker;
	}

}
