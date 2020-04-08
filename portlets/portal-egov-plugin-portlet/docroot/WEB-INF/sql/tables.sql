create table PortalPlugins (
	pluginId LONG not null primary key,
	pluginName VARCHAR(75) null,
	pluginCode VARCHAR(75) null,
	pluginVersion DOUBLE,
	pluginType INTEGER,
	ePortalId LONG,
	isImportant INTEGER,
	pluginDescription TEXT null,
	pluginUpdateInfo TEXT null,
	pluginSize DOUBLE,
	warFileId LONG,
	signFileId LONG,
	createDate DATE null,
	modifyDate DATE null,
	groupId LONG,
	userId LONG,
	companyId LONG,
	userName VARCHAR(75) null
);

create table ePortals (
	eportalId LONG not null primary key,
	eportalName VARCHAR(75) null,
	eportalCode VARCHAR(75) null,
	eportalDomain VARCHAR(75) null,
	eportalVersion VARCHAR(75) null,
	createDate DATE null,
	modifyDate DATE null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null
);

create table portalplugins_PortalPlugins (
	pluginId LONG not null primary key,
	pluginName VARCHAR(75) null,
	pluginCode VARCHAR(75) null,
	pluginVersion DOUBLE,
	pluginType INTEGER,
	ePortalId LONG,
	isImportant INTEGER,
	pluginDescription VARCHAR(75) null,
	pluginUpdateInfo VARCHAR(75) null,
	pluginSize DOUBLE,
	warFileId LONG,
	signFileId LONG,
	createDate DATE null,
	modifyDate DATE null,
	groupId LONG,
	userId LONG,
	companyId LONG,
	userName VARCHAR(75) null
);

create table portalplugins_ePortals (
	ePortalId LONG not null primary key,
	ePortalName VARCHAR(75) null,
	ePortalCode VARCHAR(75) null,
	ePortalDomain VARCHAR(75) null,
	createDate DATE null,
	modifyDate DATE null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName LONG
);