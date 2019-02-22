database sysmaster;
drop database lportal;
create database lportal WITH LOG;

create procedure 'lportal'.isnull(test_string varchar)
returning boolean;
IF test_string IS NULL THEN
	RETURN 't';
ELSE
	RETURN 'f';
END IF
end procedure;




create index IX_C844685A on Complaints (companyId);
create index IX_AC9F3D5C on Complaints (groupId);

create index IX_D81D501B on Complaints_DLFileEntries (complaintId);


