create table YKCT_Category (
	categoryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	categoryName VARCHAR(75) null,
	categoryDesc VARCHAR(75) null
);

create table YKCT_Entry (
	entryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	entryName VARCHAR(75) null,
	categoryId LONG,
	fileAttachmentURL VARCHAR(75) null
);

create table ykct_dlfileentries (
	id_ LONG not null primary key,
	ykctEntryId LONG,
	fileEntryId LONG
);