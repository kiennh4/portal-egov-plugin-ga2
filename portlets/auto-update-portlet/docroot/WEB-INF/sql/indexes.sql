create index IX_79FB3A93 on AudioPlayer_UpdatePlugins (companyId);
create index IX_202749D5 on AudioPlayer_UpdatePlugins (groupId);
create index IX_BBA31929 on AudioPlayer_UpdatePlugins (pluginCode);
create index IX_5353A9FC on AudioPlayer_UpdatePlugins (pluginCode, currentVersion);

create index IX_F7442AEA on AutoUpdate_UpdatePlugins (pluginCode);
create index IX_44C319BD on AutoUpdate_UpdatePlugins (pluginCode, currentVersion);