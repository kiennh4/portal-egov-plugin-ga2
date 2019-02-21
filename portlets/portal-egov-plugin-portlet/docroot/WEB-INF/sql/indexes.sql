create index IX_F43FDFAE on PortalPlugins (companyId);
create index IX_579FFE62 on PortalPlugins (ePortalId);
create index IX_C9F879B0 on PortalPlugins (groupId);
create index IX_89F3176E on PortalPlugins (pluginCode);
create index IX_2AAAD8FC on PortalPlugins (pluginCode, groupId);
create index IX_25AA0023 on PortalPlugins (pluginCode, pluginVersion, groupId);

create index IX_4F8747A4 on ePortals (ePortalCode, groupId);
create index IX_56FB2A2D on ePortals (ePortalDomain, groupId);
create index IX_9EDCB7A6 on ePortals (eportalCode);
create index IX_E2A5F7C4 on ePortals (eportalCode, groupId);
create index IX_9D2E524D on ePortals (eportalDomain, groupId);
create index IX_CE9B2D02 on ePortals (groupId);

create index IX_DDC04919 on portalplugins_PortalPlugins (companyId);
create index IX_412067CD on portalplugins_PortalPlugins (ePortalId);
create index IX_20CA41DB on portalplugins_PortalPlugins (groupId);
create index IX_D07FDB63 on portalplugins_PortalPlugins (pluginCode);
create index IX_3D12B8A7 on portalplugins_PortalPlugins (pluginCode, groupId);
create index IX_4E4D2BD2 on portalplugins_PortalPlugins (pluginCode, pluginVersion);
create index IX_D5177518 on portalplugins_PortalPlugins (pluginCode, pluginVersion, groupId);

create index IX_B3B7123B on portalplugins_ePortals (ePortalCode);
create index IX_A38FB4CF on portalplugins_ePortals (ePortalCode, groupId);
create index IX_195DB852 on portalplugins_ePortals (ePortalDomain);
create index IX_CA9CF898 on portalplugins_ePortals (ePortalDomain, groupId);
create index IX_4AB1B5F7 on portalplugins_ePortals (groupId);