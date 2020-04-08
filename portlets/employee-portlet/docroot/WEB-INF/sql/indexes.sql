create index IX_E89E1270 on Department (companyId);
create index IX_1A6874F2 on Department (groupId);

create index IX_FAB33C94 on Employee (companyId);
create index IX_AFC17026 on Employee (depId);
create index IX_DF49D816 on Employee (groupId);
create index IX_3F6A11A3 on Employee (postId);

create index IX_9F34B3E2 on Post (companyId);
create index IX_14BCCAE4 on Post (groupId);