create index IX_826518B1 on CO_Category (companyId);
create index IX_7F9949A8 on CO_Category (companyId, parentCategoryId);
create index IX_470E1773 on CO_Category (groupId);
create index IX_525CDBEA on CO_Category (groupId, parentCategoryId);

create index IX_1EEB2ACC on CO_Conversation (companyId);
create index IX_9E97F44E on CO_Conversation (groupId);
create index IX_B6E5DC26 on CO_Conversation (status, companyId);
create index IX_7C633428 on CO_Conversation (status, groupId);
create index IX_3C255DB3 on CO_Conversation (threadId, companyId);
create index IX_57903999 on CO_Conversation (threadId, companyId, status);
create index IX_26BFB4F5 on CO_Conversation (threadId, groupId);
create index IX_83882EDB on CO_Conversation (threadId, groupId, status);

create index IX_374509D8 on CO_Thread (categoryId, companyId);
create index IX_2C27F0BE on CO_Thread (categoryId, companyId, status);
create index IX_5B6265A on CO_Thread (categoryId, groupId);
create index IX_C07D6B40 on CO_Thread (categoryId, groupId, status);
create index IX_7B358A65 on CO_Thread (companyId);
create index IX_14F76627 on CO_Thread (groupId);
create index IX_A4759F42 on CO_Thread (parentThreadId, companyId);
create index IX_A2497C28 on CO_Thread (parentThreadId, companyId, status);
create index IX_5A010E44 on CO_Thread (parentThreadId, groupId);
create index IX_717EC92A on CO_Thread (parentThreadId, groupId, status);
create index IX_2B4792BF on CO_Thread (status, companyId);
create index IX_6C3BD01 on CO_Thread (status, groupId);