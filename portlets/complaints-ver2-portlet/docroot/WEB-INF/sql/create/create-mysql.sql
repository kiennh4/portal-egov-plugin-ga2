drop database if exists lportal;
create database lportal character set utf8;
use lportal;



create index IX_C844685A on Complaints (companyId);
create index IX_AC9F3D5C on Complaints (groupId);

create index IX_D81D501B on Complaints_DLFileEntries (complaintId);


