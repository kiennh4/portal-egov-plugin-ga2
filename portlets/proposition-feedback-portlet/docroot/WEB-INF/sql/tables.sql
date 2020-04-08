create table Proposition (
	propositionId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	categoryId LONG,
	compilationDepartmentId LONG,
	verificationDepartmentId LONG,
	propositionName VARCHAR(2000) null,
	propositionDesc STRING null,
	propositionContent TEXT null,
	documentFileId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	viewCount INTEGER,
	feedbackCount INTEGER,
	status INTEGER,
	statusByUserId LONG,
	statusDate DATE null
);

create table PropositionCategory (
	categoryId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	categoryTypeId INTEGER,
	parentId LONG,
	categoryName VARCHAR(2000) null,
	categoryDesc STRING null,
	propositionCount INTEGER,
	createDate DATE null,
	modifiedDate DATE null
);

create table PropositionFeedback (
	feedbackId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	propositionId LONG,
	feedbackFileAttId LONG,
	feedbackTitle STRING null,
	feedbackContent TEXT null,
	citizenName VARCHAR(300) null,
	citizenEmail VARCHAR(150) null,
	citizenPhone VARCHAR(75) null,
	citizenAddress VARCHAR(1000) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusDate DATE null
);