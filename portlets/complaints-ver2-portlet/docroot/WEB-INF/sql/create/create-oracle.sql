drop user &1 cascade;
create user &1 identified by &2;
grant connect,resource to &1;
connect &1/&2;
set define off;



create index IX_C844685A on Complaints (companyId);
create index IX_AC9F3D5C on Complaints (groupId);

create index IX_D81D501B on Complaints_DLFileEntries (complaintId);



quit