package org.eclipselabs.damos.evaluation;

import org.eclipse.core.runtime.Plugin;
import org.eclipselabs.mscript.language.MscriptRuntimeModule;
import org.eclipselabs.mscript.language.parser.antlr.MscriptParser;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * The activator class controls the plug-in life cycle
 */
public class EvaluationPlugin extends Plugin {

	private MscriptParser mscriptParser;
	
	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipselabs.damos.evaluation";

	// The shared instance
	private static EvaluationPlugin plugin;
	
	/**
	 * The constructor
	 */
	public EvaluationPlugin() {
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
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		mscriptParser = null;

		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static EvaluationPlugin getDefault() {
		return plugin;
	}
	
	/**
	 * @return the mscriptParser
	 */
	public MscriptParser getMscriptParser() {
		return mscriptParser;
	}

}
