package org.eclipselabs.damos.execution.engine.internal.providers;


import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.OpaqueBehaviorSpecification;
import org.eclipselabs.damos.execution.engine.IComponentSignaturePolicy;
import org.eclipselabs.damos.execution.engine.IComponentSignaturePolicyProvider;
import org.eclipselabs.damos.execution.engine.internal.policies.DeclarativeBlockSignaturePolicy;

public class DeclarativeBlockSignaturePolicyProvider implements IComponentSignaturePolicyProvider {

	public IComponentSignaturePolicy createPolicy(Component component) {
		if (component instanceof Block) {
			Block block = (Block) component;
			if (block.getType().getBehavior() instanceof OpaqueBehaviorSpecification) {
				return new DeclarativeBlockSignaturePolicy();
			}
		}
		return null;
	}

}
