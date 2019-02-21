package com.bkav.portal.portlet.autoupdate.util;

import java.util.Date;

public class UpdatePluginsModel {
	public long getPlugninId() {

		return pluginId;
	}

	public void setPluginId(long pluginId) {

		this.pluginId = pluginId;
	}

	public String getPluginName() {

		return pluginName;
	}

	public void setPluginName(String pluginName) {

		this.pluginName = pluginName;
	}
	
	public String getPluginCode() {

		return pluginCode;
	}

	public void setPluginCode(String pluginCode) {

		this.pluginCode = pluginCode;
	}

	public int getPluginType() {

		return pluginType;
	}

	public void setPluginType(int pluginType) {

		this.pluginType = pluginType;
	}

	public double getCurrentVersion() {

		return currentVersion;
	}

	public void setCurrentVersion(double currentVersion) {

		this.currentVersion = currentVersion;
	}
	
	public double getCurrentSize() {

		return currentSize;
	}

	public void setCurrentSize(double currentSize) {

		this.currentSize = currentSize;
	}
	
	public long getServerCompanyId() {

		return serverCompanyId;
	}

	public void setServerCompanyId(long serverCompanyId) {

		this.serverCompanyId = serverCompanyId;
	}
	
	public Date getCreateDate() {

		return createDate;
	}

	public void setCreateDate(Date createDate) {

		this.createDate = createDate;
	}
	
	public Date getModifyDate() {

		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {

		this.modifyDate = modifyDate;
	}
	
	private long pluginId;
	private String pluginName;
	private String pluginCode;
	private int pluginType;
	private double currentVersion;
	private double currentSize;
	private long serverCompanyId;
	private Date createDate;
	private Date modifyDate;
}
