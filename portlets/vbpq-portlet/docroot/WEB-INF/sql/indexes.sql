create index IX_D826D95 on vbpq_category (active_, companyId);
create index IX_DA835557 on vbpq_category (active_, groupId);
create index IX_B10A0B52 on vbpq_category (companyId);
create index IX_DDE13E54 on vbpq_category (groupId);
create index IX_F6CF4019 on vbpq_category (parentId, companyId);
create index IX_4F2AF8DB on vbpq_category (parentId, groupId);
create index IX_412D9189 on vbpq_category (typeId, companyId);
create index IX_F2CEE64B on vbpq_category (typeId, groupId);

create index IX_C69FFBC1 on vbpq_dlfileentries (fileEntryId);
create index IX_3FF8F6B0 on vbpq_dlfileentries (vbpqEntryId);

create index IX_973A79A5 on vbpq_entry (active_, companyId);
create index IX_FEF2567 on vbpq_entry (active_, groupId);
create index IX_226A4935 on vbpq_entry (categoryId, companyId);
create index IX_E0ED98F7 on vbpq_entry (categoryId, groupId);
create index IX_DDA12D42 on vbpq_entry (companyId);
create index IX_AC534A61 on vbpq_entry (departmentId, companyId);
create index IX_413CF523 on vbpq_entry (departmentId, groupId);
create index IX_82439CF1 on vbpq_entry (docTypeId, companyId);
create index IX_940ABB3 on vbpq_entry (docTypeId, groupId);
create index IX_64B81C44 on vbpq_entry (groupId);
create index IX_ECE1EAF5 on vbpq_entry (neverExpired, companyId);
create index IX_B462AAB7 on vbpq_entry (neverExpired, groupId);