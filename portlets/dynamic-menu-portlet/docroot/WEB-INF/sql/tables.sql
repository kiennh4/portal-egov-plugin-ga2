create table DynamicMenu (
	menuId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	itemCount INTEGER
);

create table DynamicMenuItem (
	itemId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	menuId LONG,
	parentId LONG,
	name VARCHAR(75) null,
	url VARCHAR(75) null,
	urlType VARCHAR(75) null,
	position INTEGER
);