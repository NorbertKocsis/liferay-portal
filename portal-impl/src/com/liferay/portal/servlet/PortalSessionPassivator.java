package com.liferay.portal.servlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.PortalSessionContext;
import com.liferay.portal.kernel.servlet.PortletSessionTracker;
import com.liferay.portal.kernel.util.BasePortalLifecycle;
import com.liferay.portal.util.PropsValues;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;

/**
 * Created by Kocsis Norbert on 5/24/2016.
 */
public class PortalSessionPassivator extends BasePortalLifecycle {
	public PortalSessionPassivator(HttpSessionEvent httpSessionEvent) {
		_httpSessionEvent = httpSessionEvent;

		registerPortalLifecycle(METHOD_INIT);
	}

	@Override
	protected void doPortalDestroy() {
	}

	@Override
	protected void doPortalInit() {
		if (PropsValues.SESSION_DISABLED) {
			return;
		}

		HttpSession session = _httpSessionEvent.getSession();

		try {
			PortalSessionContext.remove(session.getId());

			PortletSessionTracker.passivate(session.getId());
		}
		catch (IllegalStateException ise) {
			if (_log.isWarnEnabled()) {
				_log.warn(ise, ise);
			}
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		PortalSessionCreator.class);

	private final HttpSessionEvent _httpSessionEvent;
}
