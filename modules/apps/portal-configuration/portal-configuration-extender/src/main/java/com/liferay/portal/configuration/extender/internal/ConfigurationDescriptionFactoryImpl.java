/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.configuration.extender.internal;

import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMap;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMapFactory;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

/**
 * @author Carlos Sierra Andrés
 */
@Component(immediate = true, service = ConfigurationDescriptionFactory.class)
public class ConfigurationDescriptionFactoryImpl
	implements ConfigurationDescriptionFactory {

	@Override
	public ConfigurationDescription create(
		NamedConfigurationContent namedConfigurationContent) {

		if (!(namedConfigurationContent instanceof
				URLNamedConfigurationContent)) {

			return null;
		}

		URLNamedConfigurationContent urlFileNamedConfigurationContent =
			(URLNamedConfigurationContent)namedConfigurationContent;

		ConfigurationContentSupplierFactory
			configurationContentSupplierFactory =
				getConfigurationContentSupplierFactory(
					urlFileNamedConfigurationContent.getType());

		if (configurationContentSupplierFactory == null) {
			return null;
		}

		String factoryPid = null;
		String pid = null;

		String name = namedConfigurationContent.getName();

		int index = name.lastIndexOf('-');

		if (index > 0) {
			factoryPid = name.substring(0, index);
			pid = name.substring(index + 1);

			return new FactoryConfigurationDescription(
				factoryPid, pid,
				configurationContentSupplierFactory.create(
					namedConfigurationContent.getInputStream()));
		}
		else {
			pid = name;

			return new SingleConfigurationDescription(
				pid,
				configurationContentSupplierFactory.create(
					namedConfigurationContent.getInputStream()));
		}
	}

	@Activate
	protected void activate(BundleContext bundleContext) {
		_configurationContentSupplierFactoryServiceTrackerMap =
			ServiceTrackerMapFactory.openSingleValueMap(
				bundleContext, ConfigurationContentSupplierFactory.class,
				"type");
	}

	protected ConfigurationContentSupplierFactory
		getConfigurationContentSupplierFactory(String type) {

		return _configurationContentSupplierFactoryServiceTrackerMap.getService(
			type);
	}

	private ServiceTrackerMap<String, ConfigurationContentSupplierFactory>
		_configurationContentSupplierFactoryServiceTrackerMap;

}