/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.dml.internal.registry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Platform;
import org.eclipselabs.damos.common.registry.AbstractRegistryReader;
import org.eclipselabs.damos.common.registry.IRegistryConstants;
import org.eclipselabs.damos.dml.DMLPlugin;
import org.eclipselabs.damos.dml.registry.BlockGroupRegistry;

/**
 * @author Andreas Unger
 *
 */
public class BlockGroupRegistryReader extends AbstractRegistryReader {

	private static final String EXTENSION_POINT_NAME = "blockGroups";

	private static final String TAG_GROUP = "group";
	private static final String ATT_SUPERGROUP = "supergroup";
	
	private BlockGroupRegistry registry;
	
	private Map<String, BlockGroupDescriptor> blockGroups = new HashMap<String, BlockGroupDescriptor>();

	private List<SupergroupMapping> supergroupMappings = new ArrayList<SupergroupMapping>();
	
	public void registerBlockGroups(BlockGroupRegistry registry) {
		this.registry = registry;
		
		readRegistry(Platform.getExtensionRegistry(), EXTENSION_POINT_NAME);

		for (SupergroupMapping supergroupMapping : supergroupMappings) {
			BlockGroupDescriptor supergroup = blockGroups.get(supergroupMapping.supergroupId);
			if (supergroup == null) {
				logError(supergroupMapping.element, "Supergroup '" + supergroupMapping.supergroupId + "' not found");
			}
			supergroupMapping.group.setSupergroup(supergroup);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.common.registry.AbstractRegistryReader#getPluginId()
	 */
	@Override
	protected String getPluginId() {
		return DMLPlugin.PLUGIN_ID;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.common.registry.AbstractRegistryReader#getLog()
	 */
	@Override
	protected ILog getLog() {
		return DMLPlugin.getPlugin().getLog();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.common.registry.AbstractRegistryReader#readElement(org.eclipse.core.runtime.IConfigurationElement)
	 */
	@Override
	protected boolean readElement(IConfigurationElement element) {
        if (!element.getName().equals(TAG_GROUP)) {
			return false;
		}

        String id = getRequiredAttribute(element, IRegistryConstants.ATT_ID);
		String name = getRequiredAttribute(element, IRegistryConstants.ATT_NAME);
		String supergroupId = element.getAttribute(ATT_SUPERGROUP);
		
		BlockGroupDescriptor blockGroup = new BlockGroupDescriptor();
		blockGroup.setId(id);
		blockGroup.setName(name);
		if (supergroupId != null && supergroupId.length() > 0) {
			SupergroupMapping supergroupMapping = new SupergroupMapping();
			supergroupMapping.group = blockGroup;
			supergroupMapping.supergroupId = supergroupId;
			supergroupMapping.element = element;
			supergroupMappings.add(supergroupMapping);
		}
		
		blockGroups.put(id, blockGroup);
		registry.register(blockGroup);

		return true;
	}
	
	private static class SupergroupMapping {
		
		public BlockGroupDescriptor group;
		public String supergroupId;
		public IConfigurationElement element;
		
	}

}
