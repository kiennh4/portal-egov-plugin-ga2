create table tthc_attribute (
	attributeId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	tthcEntryId LONG,
	attributeTypeId INTEGER,
	attributeIndex INTEGER,
	attributeName VARCHAR(300) null,
	attributeValue VARCHAR(3000) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table tthc_category (
	categoryId LONG not null primary key,
	parentId LONG,
	categoryTypeId INTEGER,
	companyId LONG,
	groupId LONG,
	userId LONG,
	categoryName VARCHAR(300) null,
	categoryDesc VARCHAR(1000) null,
	createDate DATE null,
	modifiedDate DATE null,
	displayPriority INTEGER
);

create table tthc_entry (
	entryId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	levelId LONG,
	departmentId LONG,
	categoryId LONG,
	audienceId LONG,
	resultTypeId LONG,
	entryCode VARCHAR(300) null,
	entryName VARCHAR(3000) null,
	entryDesc STRING null,
	processGuide STRING null,
	processType STRING null,
	processTime STRING null,
	processFee STRING null,
	processRequirement STRING null,
	processFoundationDocument VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);