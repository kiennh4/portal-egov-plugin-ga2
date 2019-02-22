create table AudioPlayer_AlbumAudioMap (
	mapId LONG not null primary key,
	albumId LONG,
	audioId LONG
);

create table AudioPlayer_AudioAlbum (
	albumId LONG not null primary key,
	albumName VARCHAR(75) null,
	albumInfo VARCHAR(75) null,
	albumCoverId LONG,
	createDate DATE null,
	modifyDate DATE null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	viewCounter LONG
);

create table AudioPlayer_AudioFile (
	audioId LONG not null primary key,
	audioName VARCHAR(75) null,
	audioInfo VARCHAR(75) null,
	audioType VARCHAR(75) null,
	audioFileId LONG,
	createDate DATE null,
	modifyDate DATE null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	viewCounter LONG
);