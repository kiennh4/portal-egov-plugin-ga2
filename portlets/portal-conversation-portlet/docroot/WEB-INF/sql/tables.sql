create table CO_Category (
	categoryId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	parentCategoryId LONG,
	categoryName VARCHAR(75) null,
	categoryDesc VARCHAR(75) null,
	threadCount INTEGER,
	createDate DATE null,
	modifiedDate DATE null
);

create table CO_Conversation (
	conversationId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	threadId LONG,
	title VARCHAR(75) null,
	askUserName VARCHAR(75) null,
	askUserInfo VARCHAR(75) null,
	askContent VARCHAR(75) null,
	answerUserName VARCHAR(75) null,
	answerUserInfo VARCHAR(75) null,
	answerContent VARCHAR(75) null,
	askDate DATE null,
	answerDate DATE null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusDate DATE null
);

create table CO_Thread (
	threadId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	parentThreadId LONG,
	categoryId LONG,
	threadName VARCHAR(75) null,
	departmentName VARCHAR(75) null,
	participants VARCHAR(75) null,
	threadDesc VARCHAR(75) null,
	startDate DATE null,
	endDate DATE null,
	createDate DATE null,
	modifiedDate DATE null,
	viewCount INTEGER,
	conversationCount INTEGER,
	status INTEGER,
	statusByUserId LONG,
	statusDate DATE null
);