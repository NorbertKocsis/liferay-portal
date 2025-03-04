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

import {usePrevious} from 'frontend-js-react-web';
import React, {useContext, useEffect, useState} from 'react';

import {AppContext} from '../../AppContext.es';
import ControlMenu from '../../components/control-menu/ControlMenu.es';
import {Loading} from '../../components/loading/Loading.es';
import useDataLayout from '../../hooks/useDataLayout.es';
import useQuery from '../../hooks/useQuery.es';
import {getItem} from '../../utils/client.es';
import {errorToast} from '../../utils/toast.es';
import {isEqualObjects} from '../../utils/utils.es';
import FieldPreview from './FieldPreview.es';
import ViewEntryUpperToolbar from './ViewEntryUpperToolbar.es';

export function ViewDataLayoutPageValues({
	dataDefinition,
	dataLayoutPage,
	dataRecordValues,
}) {
	const {dataLayoutRows} = dataLayoutPage;

	return dataLayoutRows
		.reduce(
			(fields, {dataLayoutColumns = []}) => [
				...fields,
				...dataLayoutColumns.reduce(
					(fields, {fieldNames = []}) => [...fields, ...fieldNames],
					[]
				),
			],
			[]
		)
		.map((fieldName) => (
			<FieldPreview
				dataDefinition={dataDefinition}
				dataRecordValues={dataRecordValues}
				fieldName={fieldName}
				key={fieldName}
			/>
		));
}

export default function ViewEntry({
	history,
	match: {
		params: {entryIndex},
	},
}) {
	const {dataDefinitionId, dataLayoutId} = useContext(AppContext);
	const {
		dataDefinition,
		dataLayout: {dataLayoutPages},
		isLoading,
	} = useDataLayout(dataLayoutId, dataDefinitionId);

	const [{dataRecord, isFetching, page, totalCount}, setState] = useState({
		dataRecord: {},
		isFetching: true,
		page: 1,
		totalCount: 0,
	});

	const {dataRecordValues = {}, id: dataRecordId} = dataRecord;

	const [query] = useQuery(history, {
		keywords: '',
		page: 1,
		sort: '',
	});

	const previousQuery = usePrevious(query);
	const previousIndex = usePrevious(entryIndex);

	useEffect(() => {
		if (
			!isEqualObjects(query, previousQuery) ||
			entryIndex !== previousIndex
		) {
			getItem(
				`/o/data-engine/v2.0/data-definitions/${dataDefinitionId}/data-records`,
				{...query, page: entryIndex, pageSize: 1}
			)
				.then(({items = [], ...response}) => {
					if (items.length > 0) {
						setState({
							dataRecord: items.pop(),
							isFetching: false,
							...response,
						});
					}
				})
				.catch(() => {
					setState((prevState) => ({
						...prevState,
						isFetching: false,
					}));

					errorToast();
				});
		}
		// eslint-disable-next-line react-hooks/exhaustive-deps
	}, [entryIndex, query]);

	return (
		<div className="view-entry">
			<ControlMenu
				backURL="../../"
				title={Liferay.Language.get('details-view')}
			/>

			<ViewEntryUpperToolbar
				dataRecordId={dataRecordId}
				page={page}
				totalCount={totalCount}
			/>

			<Loading isLoading={isLoading || isFetching}>
				<div className="container">
					<div className="justify-content-center row">
						<div className="col-lg-8">
							{dataLayoutPages &&
								dataRecordValues &&
								dataLayoutPages.map((dataLayoutPage, index) => (
									<div className="sheet" key={index}>
										<ViewDataLayoutPageValues
											dataDefinition={dataDefinition}
											dataLayoutPage={dataLayoutPage}
											dataRecordValues={dataRecordValues}
											key={index}
										/>
									</div>
								))}
						</div>
					</div>
				</div>
			</Loading>
		</div>
	);
}
