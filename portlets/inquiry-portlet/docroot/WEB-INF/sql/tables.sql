create table OnlineInquiry (
	inquiryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	fullName VARCHAR(75) null,
	phoneNumbers VARCHAR(75) null,
	emailAddress VARCHAR(75) null,
	inquiryContent VARCHAR(75) null,
	inquiryStatus INTEGER
);