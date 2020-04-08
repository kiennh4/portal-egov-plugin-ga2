create table TourismMapMarker (
	markerId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	markerGroupId LONG,
	markerTitle VARCHAR(300) null,
	markerInfo STRING null,
	markerAddress VARCHAR(1000) null,
	markerImageId LONG,
	markerLongitude VARCHAR(75) null,
	markerLatitude VARCHAR(75) null
);

create table TourismMapMarkerGroup (
	markerGroupId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	markerGroupName VARCHAR(300) null,
	markerGroupInfo VARCHAR(1000) null
);