Liferay.Service.register("Liferay.Service.banner", "com.portal_egov.portlet.banner.service", "banner-portlet");

Liferay.Service.registerClass(
	Liferay.Service.banner, "Banner",
	{
		getBanner: true,
		getAllBanners: true,
		getGroupBanners: true,
		findByKeyword: true,
		deleteBanner: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.banner, "BannerGroup",
	{
		getBannerGroups: true,
		deleteBannerGroup: true
	}
);