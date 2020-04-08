create table VisitCounter (
	counterId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	totalHitCounter INTEGER
);

create table VisitCounterDayLog (
	daylogId VARCHAR(75) not null primary key,
	companyId LONG,
	groupId LONG,
	hitCounter INTEGER
);

create table VisitCounterLog (
	visitorIp VARCHAR(75) not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	hitCounter INTEGER,
	lastAccessPageId LONG,
	lastAccessDate DATE null
);