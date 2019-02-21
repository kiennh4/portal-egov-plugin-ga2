create table Complaints (
	complaintId LONG not null primary key,
	complaintNumber VARCHAR(75) null,
	signingDate DATE null,
	complaintName VARCHAR(1000) null,
	complaintDesc VARCHAR(2000) null,
	complaintContent TEXT null,
	replyDocument TEXT null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null
);

create table Complaints_DLFileEntries (
	id_ LONG not null primary key,
	complaintId LONG,
	fileEntryId LONG
);