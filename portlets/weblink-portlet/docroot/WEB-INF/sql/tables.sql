create table Weblink (
	weblinkId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	weblinkCategoryId LONG,
	weblinkName VARCHAR(300) null,
	weblinkDesc VARCHAR(450) null,
	weblinkURL VARCHAR(300) null,
	weblinkIconId LONG
);

create table WeblinkCategory (
	categoryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	categoryName VARCHAR(300) null,
	categoryDesc VARCHAR(450) null,
	categoryIconId LONG
);