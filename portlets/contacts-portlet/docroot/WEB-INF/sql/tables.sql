create table Contacts (
	contactId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	departmentId LONG,
	imageId LONG,
	contactName VARCHAR(150) null,
	jobTitle VARCHAR(150) null,
	phoneNumbers VARCHAR(75) null,
	homePhone VARCHAR(75) null,
	mobile VARCHAR(75) null,
	email VARCHAR(75) null,
	displayPriority INTEGER,
	contactStatus INTEGER
);

create table ContactsDepartment (
	departmentId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	parentId LONG,
	departmentName VARCHAR(500) null,
	departmentAddress VARCHAR(1000) null,
	departmentPhone VARCHAR(75) null,
	departmentWebsite VARCHAR(150) null,
	departmentEmail VARCHAR(75) null,
	displayPriority INTEGER,
	departmentStatus INTEGER
);

create table ContactsDepartmentProperty (
	propertyId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	departmentId LONG,
	propertyKey VARCHAR(150) null,
	propertyValue VARCHAR(1000) null,
	propertyType VARCHAR(75) null
);

create table ContactsProperty (
	propertyId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	contactId LONG,
	propertyKey VARCHAR(150) null,
	propertyValue VARCHAR(1000) null,
	propertyType VARCHAR(75) null
);