create table ContentSharing (
	contentId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	contentSharing VARCHAR(75) null
);