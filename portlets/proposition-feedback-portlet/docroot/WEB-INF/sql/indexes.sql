create index IX_F1229AC on Proposition (companyId);
create index IX_D74F6E99 on Proposition (companyId, categoryId);
create index IX_A526047F on Proposition (companyId, categoryId, status);
create index IX_F911FC92 on Proposition (companyId, status);
create index IX_90312B2E on Proposition (groupId);
create index IX_437E3D1B on Proposition (groupId, categoryId);
create index IX_5F673101 on Proposition (groupId, categoryId, status);
create index IX_7A605C14 on Proposition (groupId, status);

create index IX_214B9F4E on PropositionCategory (companyId);
create index IX_25ACD095 on PropositionCategory (companyId, categoryTypeId);
create index IX_FC9ABAE7 on PropositionCategory (companyId, parentId);
create index IX_A82FA150 on PropositionCategory (groupId);
create index IX_59A08E97 on PropositionCategory (groupId, categoryTypeId);
create index IX_29ADA269 on PropositionCategory (groupId, parentId);

create index IX_8CC88427 on PropositionFeedback (companyId);
create index IX_57079BFA on PropositionFeedback (companyId, propositionId);
create index IX_224F40E0 on PropositionFeedback (companyId, propositionId, status);
create index IX_ACAFAC0D on PropositionFeedback (companyId, status);
create index IX_721E869 on PropositionFeedback (groupId);
create index IX_E1D4EB78 on PropositionFeedback (groupId, propositionId);
create index IX_A80C325E on PropositionFeedback (groupId, propositionId, status);
create index IX_B309AE4F on PropositionFeedback (groupId, status);