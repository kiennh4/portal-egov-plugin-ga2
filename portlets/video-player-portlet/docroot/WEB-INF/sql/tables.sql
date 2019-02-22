create table VideoCategory (
	categoryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	categoryName VARCHAR(75) null
);

create table VideoCategoryMap (
	mapId LONG not null primary key,
	categoryId LONG,
	entryId LONG
);

create table VideoEntry (
	entryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(300) null,
	description VARCHAR(75) null,
	videoType VARCHAR(75) null,
	videoUrl VARCHAR(300) null,
	videoFileId LONG,
	thumbnailImage BOOLEAN,
	thumbnailImageId LONG
);