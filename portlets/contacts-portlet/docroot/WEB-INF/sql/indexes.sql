create index IX_C28570F on Contacts (companyId);
create index IX_1CBB0573 on Contacts (companyId, contactStatus);
create index IX_960BAB90 on Contacts (companyId, departmentId);
create index IX_B7C5FED2 on Contacts (companyId, departmentId, contactStatus);
create index IX_4AA95551 on Contacts (groupId);
create index IX_EFF97AF1 on Contacts (groupId, contactStatus);
create index IX_52898E52 on Contacts (groupId, departmentId);
create index IX_8811FFD0 on Contacts (groupId, departmentId, contactStatus);

create index IX_14CCFC9D on ContactsDepartment (companyId);
create index IX_576BF935 on ContactsDepartment (companyId, departmentStatus);
create index IX_4A5F0176 on ContactsDepartment (companyId, parentId);
create index IX_63B6065F on ContactsDepartment (groupId);
create index IX_F6A2D677 on ContactsDepartment (groupId, departmentStatus);
create index IX_A9A040B8 on ContactsDepartment (groupId, parentId);

create index IX_AF0E25C8 on ContactsDepartmentProperty (companyId);
create index IX_215521 on ContactsDepartmentProperty (departmentId);
create index IX_BC52DA79 on ContactsDepartmentProperty (departmentId, propertyKey);
create index IX_FF57E4A on ContactsDepartmentProperty (groupId);

create index IX_30E8EE3A on ContactsProperty (companyId);
create index IX_51A64C5D on ContactsProperty (contactId);
create index IX_EED284BD on ContactsProperty (contactId, propertyKey);
create index IX_566BBB3C on ContactsProperty (groupId);