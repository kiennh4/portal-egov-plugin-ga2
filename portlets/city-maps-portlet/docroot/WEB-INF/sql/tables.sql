create table CityMap (
	mapId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	mapTypeId LONG,
	mapImageId LONG,
	mapName VARCHAR(300) null,
	mapDesc VARCHAR(1000) null,
	mapSumary VARCHAR(75) null
);

create table CityMapType (
	typeId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	typeName VARCHAR(300) null,
	typeDesc VARCHAR(1000) null
);