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

package com.liferay.portal.kernel.servlet;

import com.liferay.portal.kernel.security.pacl.permission.PortalRuntimePermission;

import javax.servlet.http.HttpSessionEvent;

/**
 * @author Preston Crary
 */
public class PortalSessionCreatorDestroyerUtil {

	public static void createSession(HttpSessionEvent httpSessionEvent) {
		getPortalSessionCreatorDestroyer().createSession(httpSessionEvent);
	}

	public static void destroySession(HttpSessionEvent httpSessionEvent) {
		getPortalSessionCreatorDestroyer().destroySession(httpSessionEvent);
	}

	public static PortalSessionCreatorDestroyer getPortalSessionCreatorDestroyer() {
		PortalRuntimePermission.checkGetBeanProperty(
			PortalSessionCreatorDestroyerUtil.class);

		return _portalSessionCreatorDestroyer;
	}

	public static void setPortalSessionCreatorDestroyer(
		PortalSessionCreatorDestroyer portalSessionCreatorDestroyer) {

		PortalRuntimePermission.checkGetBeanProperty(
			PortalSessionCreatorDestroyerUtil.class);

		_portalSessionCreatorDestroyer = portalSessionCreatorDestroyer;
	}

	private static PortalSessionCreatorDestroyer _portalSessionCreatorDestroyer;

}