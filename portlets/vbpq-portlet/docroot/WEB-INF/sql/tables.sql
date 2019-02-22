create table vbpq_category (
	categoryId LONG not null primary key,
	parentId LONG,
	typeId INTEGER,
	companyId LONG,
	groupId LONG,
	userId LONG,
	categoryName VARCHAR(1000) null,
	categoryDesc VARCHAR(2000) null,
	createDate DATE null,
	modifiedDate DATE null,
	active_ BOOLEAN,
	displayPriority INTEGER
);

create table vbpq_dlfileentries (
	id_ LONG not null primary key,
	vbpqEntryId LONG,
	fileEntryId LONG
);

create table vbpq_entry (
	entryId LONG not null primary key,
	departmentId LONG,
	categoryId LONG,
	docTypeId LONG,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	entryName STRING null,
	entryCode VARCHAR(2000) null,
	entryDesc STRING null,
	fileAttachmentURL VARCHAR(2000) null,
	publicatorName VARCHAR(150) null,
	createDate DATE null,
	modifiedDate DATE null,
	publishDate DATE null,
	executeDate DATE null,
	expirationDate DATE null,
	neverExpired BOOLEAN,
	active_ BOOLEAN
);