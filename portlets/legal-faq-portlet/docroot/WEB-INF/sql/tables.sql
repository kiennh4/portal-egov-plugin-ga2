create table LegalFAQCategory (
	categoryId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	parentId LONG,
	categoryName VARCHAR(300) null,
	categoryDesc VARCHAR(1000) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table LegalFAQEntry (
	entryId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	categoryId LONG,
	citizenName VARCHAR(75) null,
	citizenPhone VARCHAR(75) null,
	citizenEmail VARCHAR(75) null,
	citizenAddress VARCHAR(75) null,
	askDate DATE null,
	askTitle VARCHAR(300) null,
	askContent STRING null,
	answerDate DATE null,
	answerContent STRING null,
	createDate DATE null,
	modifiedDate DATE null,
	publishDate DATE null,
	viewCount INTEGER,
	publishStatus INTEGER,
	status INTEGER
);

create table legalfaq_LegalFAQCategory (
	categoryId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	parentId LONG,
	categoryName VARCHAR(75) null,
	categoryDesc VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table legalfaq_LegalFAQEntry (
	entryId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	categoryId LONG,
	citizenName VARCHAR(75) null,
	citizenPhone VARCHAR(75) null,
	citizenEmail VARCHAR(75) null,
	askDate DATE null,
	askTitle VARCHAR(75) null,
	askContent VARCHAR(75) null,
	answerDate DATE null,
	answerContent VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	publishDate DATE null,
	viewCount INTEGER,
	publishStatus INTEGER,
	status INTEGER
);