Liferay.Service.register("Liferay.Service.tourismmap", "com.portal_egov.portlet.tourism_map.service", "tourism-map-portlet");

Liferay.Service.registerClass(
	Liferay.Service.tourismmap, "TourismMapMarker",
	{
		getMarker: true,
		getJSONMarkersByGroup: true,
		getJSONMarkers: true,
		deleteMarker: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.tourismmap, "TourismMapMarkerGroup",
	{
		getJSONmarkerGroups: true,
		deleteMarkerGroup: true
	}
);