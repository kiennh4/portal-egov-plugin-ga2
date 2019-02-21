create index IX_A186F858 on tthc_attribute (companyId, tthcEntryId);
create index IX_5EC0CF49 on tthc_attribute (companyId, tthcEntryId, attributeTypeId);
create index IX_18BAFA96 on tthc_attribute (groupId, tthcEntryId);
create index IX_7525D0CB on tthc_attribute (groupId, tthcEntryId, attributeTypeId);

create index IX_9BF336F9 on tthc_category (categoryTypeId, companyId);
create index IX_809F27BB on tthc_category (categoryTypeId, groupId);
create index IX_9F9F6A0 on tthc_category (companyId);
create index IX_38CFA522 on tthc_category (groupId);
create index IX_7EC3E1E7 on tthc_category (parentId, companyId);
create index IX_47D9B629 on tthc_category (parentId, groupId);

create index IX_495A9BE1 on tthc_entry (audienceId, companyId);
create index IX_92EAA6A3 on tthc_entry (audienceId, groupId);
create index IX_3F9335A7 on tthc_entry (categoryId, companyId);
create index IX_C7EAF9E9 on tthc_entry (categoryId, groupId);
create index IX_AF03B4B4 on tthc_entry (companyId);
create index IX_22F2E253 on tthc_entry (departmentId, companyId);
create index IX_5E65E195 on tthc_entry (departmentId, groupId);
create index IX_6799D836 on tthc_entry (groupId);
create index IX_52DC1E8D on tthc_entry (levelId, companyId);
create index IX_FA04E44F on tthc_entry (levelId, groupId);
create index IX_2292920E on tthc_entry (resultTypeId, companyId);
create index IX_10144410 on tthc_entry (resultTypeId, groupId);