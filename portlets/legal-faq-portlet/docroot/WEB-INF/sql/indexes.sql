create index IX_D9E9A6A7 on LegalFAQCategory (companyId);
create index IX_C1E2700 on LegalFAQCategory (companyId, parentId);
create index IX_3729AAE9 on LegalFAQCategory (groupId);

create index IX_CFFE5A0D on LegalFAQEntry (companyId);
create index IX_8DD5B8A on LegalFAQEntry (companyId, publishStatus, status);
create index IX_10BC3BF3 on LegalFAQEntry (companyId, status);
create index IX_697FFFCF on LegalFAQEntry (groupId);
create index IX_1996283C on LegalFAQEntry (groupId, categoryId);
create index IX_6AA7087B on LegalFAQEntry (groupId, categoryId, publishStatus, status);
create index IX_D5B1DEA2 on LegalFAQEntry (groupId, publishStatus);
create index IX_48805B88 on LegalFAQEntry (groupId, publishStatus, status);

create index IX_6A026FA5 on legalfaq_LegalFAQCategory (companyId);
create index IX_C4C64A7E on legalfaq_LegalFAQCategory (companyId, parentId);
create index IX_C03C9B67 on legalfaq_LegalFAQCategory (groupId);

create index IX_DCAC61CF on legalfaq_LegalFAQEntry (companyId);
create index IX_9C85B988 on legalfaq_LegalFAQEntry (companyId, publishStatus, status);
create index IX_CA4F61B5 on legalfaq_LegalFAQEntry (companyId, status);
create index IX_DE311011 on legalfaq_LegalFAQEntry (groupId);
create index IX_BAF6E57E on legalfaq_LegalFAQEntry (groupId, categoryId);
create index IX_5C2880F9 on legalfaq_LegalFAQEntry (groupId, categoryId, publishStatus, status);
create index IX_8E5A0220 on legalfaq_LegalFAQEntry (groupId, publishStatus);
create index IX_2E042106 on legalfaq_LegalFAQEntry (groupId, publishStatus, status);