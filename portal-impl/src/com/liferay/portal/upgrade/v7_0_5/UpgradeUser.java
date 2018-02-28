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

package com.liferay.portal.upgrade.v7_0_5;

import com.liferay.portal.kernel.security.pwd.PasswordEncryptorUtil;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.upgrade.v7_0_5.util.UserTable;
import com.liferay.portal.util.PropsValues;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Ugurcan Cetin
 */
public class UpgradeUser extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		alter(
			UserTable.class,
			new AlterColumnType("emailAddress", "VARCHAR(254) null"));

		upgradeEncryptedPassword();
	}

	protected void upgradeEncryptedPassword() throws Exception {
		if (!PropsValues.PASSWORDS_ENCRYPTION_ALGORITHM_LEGACY.equals(
				PasswordEncryptorUtil.TYPE_NONE)) {

			String sql =
				"select userId, password_ from User_ where password_ like " +
					"'{UFC-CRYPT}%'";

			PreparedStatement ps1 = connection.prepareStatement(sql);

			ResultSet rs = ps1.executeQuery();

			while (rs.next()) {
				long userId = rs.getLong("userId");
				String password = rs.getString("password_");

				String updatedPassword = password.replace(
					"{UFC-CRYPT}", "{CRYPT}");

				sql = "update User_ set password_ = ? where userId = ?";

				PreparedStatement ps2 = connection.prepareStatement(sql);

				ps2.setString(1, updatedPassword);
				ps2.setLong(2, userId);

				ps2.executeUpdate();
			}
		}
	}

}