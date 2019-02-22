create table Asset_Topic (
	topicId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	topicName VARCHAR(75) null,
	categoryIds VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table topic_Topic (
	topicId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	topicName VARCHAR(75) null,
	categoryIds VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);