Liferay.Service.register("Liferay.Service.portalplugins", "com.bkav.portal.portlet.portalplugins.service", "portal-egov-plugin-portlet");

Liferay.Service.registerClass(
	Liferay.Service.portalplugins, "PortalPlugins",
	{
		findByGroupId: true,
		findByEportalCode: true
	}
);