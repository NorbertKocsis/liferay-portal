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

package com.liferay.mobile.device.rules.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for MDRAction. This utility wraps
 * <code>com.liferay.mobile.device.rules.service.impl.MDRActionLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Edward C. Han
 * @see MDRActionLocalService
 * @generated
 */
public class MDRActionLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.mobile.device.rules.service.impl.MDRActionLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.mobile.device.rules.model.MDRAction addAction(
			long ruleGroupInstanceId,
			java.util.Map<java.util.Locale, String> nameMap,
			java.util.Map<java.util.Locale, String> descriptionMap, String type,
			String typeSettings,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addAction(
			ruleGroupInstanceId, nameMap, descriptionMap, type, typeSettings,
			serviceContext);
	}

	public static com.liferay.mobile.device.rules.model.MDRAction addAction(
			long ruleGroupInstanceId,
			java.util.Map<java.util.Locale, String> nameMap,
			java.util.Map<java.util.Locale, String> descriptionMap, String type,
			com.liferay.portal.kernel.util.UnicodeProperties
				typeSettingsUnicodeProperties,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addAction(
			ruleGroupInstanceId, nameMap, descriptionMap, type,
			typeSettingsUnicodeProperties, serviceContext);
	}

	/**
	 * Adds the mdr action to the database. Also notifies the appropriate model listeners.
	 *
	 * @param mdrAction the mdr action
	 * @return the mdr action that was added
	 */
	public static com.liferay.mobile.device.rules.model.MDRAction addMDRAction(
		com.liferay.mobile.device.rules.model.MDRAction mdrAction) {

		return getService().addMDRAction(mdrAction);
	}

	/**
	 * Creates a new mdr action with the primary key. Does not add the mdr action to the database.
	 *
	 * @param actionId the primary key for the new mdr action
	 * @return the new mdr action
	 */
	public static com.liferay.mobile.device.rules.model.MDRAction
		createMDRAction(long actionId) {

		return getService().createMDRAction(actionId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			createPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static void deleteAction(long actionId) {
		getService().deleteAction(actionId);
	}

	public static void deleteAction(
		com.liferay.mobile.device.rules.model.MDRAction action) {

		getService().deleteAction(action);
	}

	public static void deleteActions(long ruleGroupInstanceId) {
		getService().deleteActions(ruleGroupInstanceId);
	}

	/**
	 * Deletes the mdr action with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param actionId the primary key of the mdr action
	 * @return the mdr action that was removed
	 * @throws PortalException if a mdr action with the primary key could not be found
	 */
	public static com.liferay.mobile.device.rules.model.MDRAction
			deleteMDRAction(long actionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteMDRAction(actionId);
	}

	/**
	 * Deletes the mdr action from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mdrAction the mdr action
	 * @return the mdr action that was removed
	 */
	public static com.liferay.mobile.device.rules.model.MDRAction
		deleteMDRAction(
			com.liferay.mobile.device.rules.model.MDRAction mdrAction) {

		return getService().deleteMDRAction(mdrAction);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return getService().dslQuery(dslQuery);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.mobile.device.rules.model.impl.MDRActionModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.mobile.device.rules.model.impl.MDRActionModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.mobile.device.rules.model.MDRAction fetchAction(
		long actionId) {

		return getService().fetchAction(actionId);
	}

	public static com.liferay.mobile.device.rules.model.MDRAction
		fetchMDRAction(long actionId) {

		return getService().fetchMDRAction(actionId);
	}

	/**
	 * Returns the mdr action matching the UUID and group.
	 *
	 * @param uuid the mdr action's UUID
	 * @param groupId the primary key of the group
	 * @return the matching mdr action, or <code>null</code> if a matching mdr action could not be found
	 */
	public static com.liferay.mobile.device.rules.model.MDRAction
		fetchMDRActionByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchMDRActionByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.mobile.device.rules.model.MDRAction getAction(
			long actionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAction(actionId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List
		<com.liferay.mobile.device.rules.model.MDRAction> getActions(
			long ruleGroupInstanceId) {

		return getService().getActions(ruleGroupInstanceId);
	}

	public static java.util.List
		<com.liferay.mobile.device.rules.model.MDRAction> getActions(
			long ruleGroupInstanceId, int start, int end) {

		return getService().getActions(ruleGroupInstanceId, start, end);
	}

	public static java.util.List
		<com.liferay.mobile.device.rules.model.MDRAction> getActions(
			long ruleGroupInstanceId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.mobile.device.rules.model.MDRAction>
					orderByComparator) {

		return getService().getActions(
			ruleGroupInstanceId, start, end, orderByComparator);
	}

	public static int getActionsCount(long ruleGroupInstanceId) {
		return getService().getActionsCount(ruleGroupInstanceId);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the mdr action with the primary key.
	 *
	 * @param actionId the primary key of the mdr action
	 * @return the mdr action
	 * @throws PortalException if a mdr action with the primary key could not be found
	 */
	public static com.liferay.mobile.device.rules.model.MDRAction getMDRAction(
			long actionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getMDRAction(actionId);
	}

	/**
	 * Returns the mdr action matching the UUID and group.
	 *
	 * @param uuid the mdr action's UUID
	 * @param groupId the primary key of the group
	 * @return the matching mdr action
	 * @throws PortalException if a matching mdr action could not be found
	 */
	public static com.liferay.mobile.device.rules.model.MDRAction
			getMDRActionByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getMDRActionByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the mdr actions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.mobile.device.rules.model.impl.MDRActionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mdr actions
	 * @param end the upper bound of the range of mdr actions (not inclusive)
	 * @return the range of mdr actions
	 */
	public static java.util.List
		<com.liferay.mobile.device.rules.model.MDRAction> getMDRActions(
			int start, int end) {

		return getService().getMDRActions(start, end);
	}

	/**
	 * Returns all the mdr actions matching the UUID and company.
	 *
	 * @param uuid the UUID of the mdr actions
	 * @param companyId the primary key of the company
	 * @return the matching mdr actions, or an empty list if no matches were found
	 */
	public static java.util.List
		<com.liferay.mobile.device.rules.model.MDRAction>
			getMDRActionsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getMDRActionsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of mdr actions matching the UUID and company.
	 *
	 * @param uuid the UUID of the mdr actions
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of mdr actions
	 * @param end the upper bound of the range of mdr actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching mdr actions, or an empty list if no matches were found
	 */
	public static java.util.List
		<com.liferay.mobile.device.rules.model.MDRAction>
			getMDRActionsByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.liferay.mobile.device.rules.model.MDRAction>
						orderByComparator) {

		return getService().getMDRActionsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of mdr actions.
	 *
	 * @return the number of mdr actions
	 */
	public static int getMDRActionsCount() {
		return getService().getMDRActionsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static com.liferay.mobile.device.rules.model.MDRAction updateAction(
			long actionId, java.util.Map<java.util.Locale, String> nameMap,
			java.util.Map<java.util.Locale, String> descriptionMap, String type,
			String typeSettings,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateAction(
			actionId, nameMap, descriptionMap, type, typeSettings,
			serviceContext);
	}

	public static com.liferay.mobile.device.rules.model.MDRAction updateAction(
			long actionId, java.util.Map<java.util.Locale, String> nameMap,
			java.util.Map<java.util.Locale, String> descriptionMap, String type,
			com.liferay.portal.kernel.util.UnicodeProperties
				typeSettingsUnicodeProperties,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateAction(
			actionId, nameMap, descriptionMap, type,
			typeSettingsUnicodeProperties, serviceContext);
	}

	/**
	 * Updates the mdr action in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param mdrAction the mdr action
	 * @return the mdr action that was updated
	 */
	public static com.liferay.mobile.device.rules.model.MDRAction
		updateMDRAction(
			com.liferay.mobile.device.rules.model.MDRAction mdrAction) {

		return getService().updateMDRAction(mdrAction);
	}

	public static MDRActionLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MDRActionLocalService, MDRActionLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MDRActionLocalService.class);

		ServiceTracker<MDRActionLocalService, MDRActionLocalService>
			serviceTracker =
				new ServiceTracker
					<MDRActionLocalService, MDRActionLocalService>(
						bundle.getBundleContext(), MDRActionLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}