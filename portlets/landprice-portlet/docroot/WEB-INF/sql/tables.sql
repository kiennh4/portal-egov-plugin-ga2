create table LandLocation (
	locationId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	parentLocationId LONG,
	locationName VARCHAR(300) null,
	locationInfo VARCHAR(1000) null
);

create table LandPrice (
	priceId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	locationId LONG,
	title VARCHAR(300) null,
	content STRING null,
	statisticYear INTEGER
);