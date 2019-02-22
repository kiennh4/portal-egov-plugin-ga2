create index IX_93D74067 on AudioPlayer_AlbumAudioMap (albumId);
create index IX_9030524E on AudioPlayer_AlbumAudioMap (audioId);
create index IX_A434EA0C on AudioPlayer_AlbumAudioMap (audioId, albumId);

create index IX_11577EE1 on AudioPlayer_AudioAlbum (companyId);
create index IX_EAC449A3 on AudioPlayer_AudioAlbum (groupId);

create index IX_93F8D298 on AudioPlayer_AudioFile (companyId);
create index IX_4A451F1A on AudioPlayer_AudioFile (groupId);