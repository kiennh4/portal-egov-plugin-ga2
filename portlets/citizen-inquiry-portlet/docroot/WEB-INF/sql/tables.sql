create table CitizenInquiry (
	inquiryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	categoryId LONG,
	citizenName VARCHAR(75) null,
	citizenPhone VARCHAR(75) null,
	citizenEmail VARCHAR(75) null,
	citizenAddress VARCHAR(75) null,
	inquiryTitle VARCHAR(75) null,
	inquiryContent VARCHAR(75) null,
	inquiryFeedback VARCHAR(75) null,
	inquiryFeedbackUser VARCHAR(75) null,
	inquiryFeedbackDate DATE null,
	inquiryStatus INTEGER,
	approved BOOLEAN
);

create table CitizenInquiryCategory (
	categoryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	categoryName VARCHAR(75) null,
	categoryDesc VARCHAR(75) null
);