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

import com.liferay.petra.string.StringPool;

import java.io.IOException;
import java.io.InputStream;

import java.net.URL;

/**
 * @author Carlos Sierra Andrés
 */
public final class URLNamedConfigurationContent
	implements NamedConfigurationContent {

	public URLNamedConfigurationContent(
		String name, String type, InputStream inputStream) {

		_name = name;
		_type = type;
		_inputStream = inputStream;
	}

	public URLNamedConfigurationContent(URL url) {
		String name = url.getFile();

		if (name.startsWith("/")) {
			name = name.substring(1);
		}

		int lastIndexOfSlash = name.lastIndexOf('/');

		if (lastIndexOfSlash > 0) {
			name = name.substring(lastIndexOfSlash + 1);
		}

		int lastIndexOfDot = name.lastIndexOf('.');

		if (lastIndexOfDot > -1) {
			_name = name.substring(0, lastIndexOfDot);
			_type = name.substring(lastIndexOfDot + 1);
		}
		else {
			_name = name;
			_type = StringPool.BLANK;
		}

		try {
			_inputStream = url.openStream();
		}
		catch (IOException ioe) {
			throw new RuntimeException(ioe);
		}
	}

	@Override
	public InputStream getInputStream() {
		return _inputStream;
	}

	@Override
	public String getName() {
		return _name;
	}

	public String getType() {
		return _type;
	}

	private final InputStream _inputStream;
	private final String _name;
	private final String _type;

}