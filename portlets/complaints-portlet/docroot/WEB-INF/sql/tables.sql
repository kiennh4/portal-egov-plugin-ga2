create table Complaint (
	complaintId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	complaintTitle STRING null,
	complaintDescription STRING null,
	complaintContent STRING null,
	fileAttachmentURL VARCHAR(75) null,
	complaintStatus INTEGER
);

create table Complaint_DlFileEntries (
	id_ LONG not null primary key,
	complaintId LONG,
	fileEntryId LONG
);