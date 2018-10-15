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

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import java.nio.charset.Charset;

import java.util.Dictionary;
import java.util.function.Supplier;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Carlos Sierra Andrés
 */
public class ConfigurationDescriptionFactoryImplTest {

	@Test
	public void testCreateFactoryConfiguration() {
		ConfigurationDescriptionFactory configurationDescriptionFactory =
			_getConfigurationDescriptionFactory();

		String configurationContent = "key=value\nanotherKey=anotherValue";

		ConfigurationDescription configurationDescription =
			configurationDescriptionFactory.create(
				new URLNamedConfigurationContent(
					"factory.pid-config.pid", "properties",
					new ByteArrayInputStream(
						configurationContent.getBytes(
							Charset.forName("UTF-8")))));

		Assert.assertTrue(
			configurationDescription instanceof
				FactoryConfigurationDescription);

		FactoryConfigurationDescription factoryConfigurationDescription =
			(FactoryConfigurationDescription)configurationDescription;

		Assert.assertEquals(
			"factory.pid", factoryConfigurationDescription.getFactoryPid());
		Assert.assertEquals(
			"config.pid", factoryConfigurationDescription.getPid());

		Supplier<Dictionary<String, Object>> propertiesSupplier =
			factoryConfigurationDescription.getPropertiesSupplier();

		Dictionary<String, Object> properties = propertiesSupplier.get();

		Assert.assertEquals("value", properties.get("key"));
		Assert.assertEquals("anotherValue", properties.get("anotherKey"));
	}

	@Test
	public void testCreateFactoryConfigurationWithConfigContent() {
		ConfigurationDescriptionFactory configurationDescriptionFactory =
			_getConfigurationDescriptionFactory();

		String configurationContent =
			"key=\"value\"\nanotherKey=\"anotherValue\"";

		ConfigurationDescription configurationDescription =
			configurationDescriptionFactory.create(
				new URLNamedConfigurationContent(
					"factory.pid-config.pid", "config",
					new ByteArrayInputStream(
						configurationContent.getBytes(
							Charset.forName("UTF-8")))));

		Assert.assertTrue(
			configurationDescription instanceof
				FactoryConfigurationDescription);

		FactoryConfigurationDescription factoryConfigurationDescription =
			(FactoryConfigurationDescription)configurationDescription;

		Assert.assertEquals(
			"factory.pid", factoryConfigurationDescription.getFactoryPid());
		Assert.assertEquals(
			"config.pid", factoryConfigurationDescription.getPid());

		Supplier<Dictionary<String, Object>> propertiesSupplier =
			factoryConfigurationDescription.getPropertiesSupplier();

		Dictionary<String, Object> properties = propertiesSupplier.get();

		Assert.assertEquals("value", properties.get("key"));
		Assert.assertEquals("anotherValue", properties.get("anotherKey"));
	}

	@Test
	public void testCreateReturnsNullWhenNotPropertiesFileNamedConfigurationContent() {
		ConfigurationDescriptionFactory configurationDescriptionFactory =
			_getConfigurationDescriptionFactory();

		ConfigurationDescription configurationDescription =
			configurationDescriptionFactory.create(
				new NamedConfigurationContent() {

					@Override
					public InputStream getInputStream() {
						return new ByteArrayInputStream(new byte[0]);
					}

					@Override
					public String getName() {
						return "aName";
					}

				});

		Assert.assertNull(configurationDescription);
	}

	@Test
	public void testCreateSingleConfiguration() {
		ConfigurationDescriptionFactory configurationDescriptionFactory =
			_getConfigurationDescriptionFactory();

		String configurationContent = "key=value\nanotherKey=anotherValue";

		ConfigurationDescription configurationDescription =
			configurationDescriptionFactory.create(
				new URLNamedConfigurationContent(
					"config.pid", "properties",
					new ByteArrayInputStream(
						configurationContent.getBytes(
							Charset.forName("UTF-8")))));

		Assert.assertTrue(
			configurationDescription instanceof SingleConfigurationDescription);

		SingleConfigurationDescription singleConfigurationDescription =
			(SingleConfigurationDescription)configurationDescription;

		Assert.assertEquals(
			"config.pid", singleConfigurationDescription.getPid());

		Supplier<Dictionary<String, Object>> propertiesSupplier =
			singleConfigurationDescription.getPropertiesSupplier();

		Dictionary<String, Object> properties = propertiesSupplier.get();

		Assert.assertEquals("value", properties.get("key"));
		Assert.assertEquals("anotherValue", properties.get("anotherKey"));
	}

	@Test
	public void testCreateSingleConfigurationWithConfigContent() {
		ConfigurationDescriptionFactory configurationDescriptionFactory =
			_getConfigurationDescriptionFactory();

		String configurationContent =
			"key=\"value\"\nanotherKey=\"anotherValue\"";

		ConfigurationDescription configurationDescription =
			configurationDescriptionFactory.create(
				new URLNamedConfigurationContent(
					"config.pid", "config",
					new ByteArrayInputStream(
						configurationContent.getBytes(
							Charset.forName("UTF-8")))));

		Assert.assertTrue(
			configurationDescription instanceof SingleConfigurationDescription);

		SingleConfigurationDescription singleConfigurationDescription =
			(SingleConfigurationDescription)configurationDescription;

		Assert.assertEquals(
			"config.pid", singleConfigurationDescription.getPid());

		Supplier<Dictionary<String, Object>> propertiesSupplier =
			singleConfigurationDescription.getPropertiesSupplier();

		Dictionary<String, Object> properties = propertiesSupplier.get();

		Assert.assertEquals("value", properties.get("key"));
		Assert.assertEquals("anotherValue", properties.get("anotherKey"));
	}

	private ConfigurationDescriptionFactory
		_getConfigurationDescriptionFactory() {

		return new ConfigurationDescriptionFactoryImpl() {

			@Override
			protected ConfigurationContentSupplierFactory
				getConfigurationContentSupplierFactory(String type) {

				if (type.equals("properties")) {
					return new PropertiesConfigurationContentSupplierFactory();
				}
				else if (type.equals("config")) {
					return new ConfigConfigurationContentSupplierFactory();
				}
				else {
					throw new IllegalArgumentException(
						type + " is wrong in this test");
				}
			}

		};
	}

}