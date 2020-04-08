create table Department (
	depId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	depName VARCHAR(75) null,
	depAddres VARCHAR(75) null,
	depPhone VARCHAR(75) null
);

create table Employee (
	emplId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	birthday DATE null,
	male VARCHAR(75) null,
	phone LONG,
	addres VARCHAR(75) null,
	email VARCHAR(75) null,
	postId LONG,
	depId LONG,
	sal LONG,
	breakDay INTEGER,
	addDay INTEGER,
	endDate VARCHAR(75) null
);

create table Post (
	postId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	postName VARCHAR(75) null
);