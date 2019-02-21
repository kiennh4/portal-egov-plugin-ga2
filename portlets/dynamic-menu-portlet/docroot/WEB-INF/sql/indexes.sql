create index IX_BBC016C6 on DynamicMenu (groupId);

create index IX_55C958B3 on DynamicMenuItem (groupId);
create index IX_C46D8D81 on DynamicMenuItem (groupId, menuId);
create index IX_323AC55A on DynamicMenuItem (groupId, menuId, parentId);
create index IX_7C3FBA0C on DynamicMenuItem (groupId, parentId);