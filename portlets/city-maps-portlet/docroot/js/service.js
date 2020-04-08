Liferay.Service.register("Liferay.Service.citymaps", "com.portal_egov.portlet.citymaps.service", "city-maps-portlet");

Liferay.Service.registerClass(
	Liferay.Service.citymaps, "CityMapType",
	{
		getJSONMapType: true
	}
);