create index IX_5C5174C4 on LandLocation (groupId);
create index IX_FEC4C794 on LandLocation (parentLocationId);

create index IX_854EFAE6 on LandPrice (groupId);
create index IX_F3E51668 on LandPrice (locationId);
create index IX_36A0B859 on LandPrice (statisticYear);