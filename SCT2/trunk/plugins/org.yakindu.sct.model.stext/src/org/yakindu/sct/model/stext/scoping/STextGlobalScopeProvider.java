package org.yakindu.sct.model.stext.scoping;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.FilteringScope;
import org.eclipse.xtext.scoping.impl.ResourceSetGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.yakindu.sct.model.sgraph.SGraphPackage;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * This Global Scope provider exposes only Statecharts as global objects to
 * prevent crossreferencing of Events and Variables between Statecharts.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class STextGlobalScopeProvider extends ResourceSetGlobalScopeProvider {

	@Inject
	private DefaultGlobalScopeProvider delegate;

	public IScope getScope(Resource context, EReference reference,
			Predicate<IEObjectDescription> filter) {
		IScope scope = super.getScope(context, reference, filter);
		IScope globalScope = delegate.getScope(context, reference, filter);
		FilteringScope filteringScope = new FilteringScope(globalScope,
				new Predicate<IEObjectDescription>() {
					@Override
					public boolean apply(IEObjectDescription input) {
						return input.getEClass() == SGraphPackage.Literals.STATECHART;
					}
				});
		return new SimpleScope(Iterables.concat(scope.getAllElements(),
				filteringScope.getAllElements()));
	}
}
