create table AudioPlayer_UpdatePlugins (
	pluginId LONG not null primary key,
	pluginName VARCHAR(75) null,
	pluginCode VARCHAR(75) null,
	pluginType INTEGER,
	currentVersion DOUBLE,
	previousVersions VARCHAR(75) null,
	currentSize DOUBLE,
	createDate DATE null,
	modifyDate DATE null
);

create table AutoUpdate_UpdatePlugins (
	pluginId LONG not null primary key,
	pluginName VARCHAR(75) null,
	pluginCode VARCHAR(75) null,
	pluginType INTEGER,
	currentVersion DOUBLE,
	previousVersions VARCHAR(75) null,
	currentSize DOUBLE,
	createDate DATE null,
	modifyDate DATE null,
	serverCompanyId LONG
);