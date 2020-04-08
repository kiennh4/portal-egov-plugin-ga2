create table Banner (
	bannerId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	bannerGroupId LONG,
	bannerTitle VARCHAR(500) null,
	bannerLink VARCHAR(1000) null,
	bannerImageId LONG,
	viewCounter INTEGER,
	bannerStatus INTEGER
);

create table BannerGroup (
	bannerGroupId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	groupName VARCHAR(300) null,
	groupDesc VARCHAR(500) null
);