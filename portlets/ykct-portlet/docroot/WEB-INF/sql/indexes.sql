create index IX_54118C08 on YKCT_Category (companyId);
create index IX_DF1D748A on YKCT_Category (groupId);

create index IX_9D249749 on YKCT_Entry (categoryId);
create index IX_598A584C on YKCT_Entry (companyId);
create index IX_8A2481CE on YKCT_Entry (groupId);

create index IX_FC0D462B on ykct_dlfileentries (fileEntryId);
create index IX_D36D6484 on ykct_dlfileentries (ykctEntryId);