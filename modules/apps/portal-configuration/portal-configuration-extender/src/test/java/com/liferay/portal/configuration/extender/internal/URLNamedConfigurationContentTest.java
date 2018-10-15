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

import java.io.File;
import java.io.IOException;

import java.net.URI;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

/**
 * @author Carlos Sierra Andrés
 */
public class URLNamedConfigurationContentTest {

	@Test
	public void testInputStreamNamedConfigurationContentWithExtension()
		throws IOException {

		File fileWithoutExtension = temporaryFolder.newFile(
			"fileWith.extension");

		URI uri = fileWithoutExtension.toURI();

		URLNamedConfigurationContent inputStreamNamedConfigurationContent =
			new URLNamedConfigurationContent(uri.toURL());

		Assert.assertEquals(
			"fileWith", inputStreamNamedConfigurationContent.getName());
		Assert.assertEquals(
			"extension", inputStreamNamedConfigurationContent.getType());
	}

	@Test
	public void testInputStreamNamedConfigurationContentWithoutExtension()
		throws IOException {

		File fileWithoutExtension = temporaryFolder.newFile(
			"fileWithoutExtension");

		URI uri = fileWithoutExtension.toURI();

		URLNamedConfigurationContent inputStreamNamedConfigurationContent =
			new URLNamedConfigurationContent(uri.toURL());

		Assert.assertEquals(
			"fileWithoutExtension",
			inputStreamNamedConfigurationContent.getName());
		Assert.assertEquals("", inputStreamNamedConfigurationContent.getType());
	}

	@Rule
	public TemporaryFolder temporaryFolder = new TemporaryFolder();

}