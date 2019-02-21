
package com.liferay.portlet.assetpublisher.util;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetTag;

public class AssetEntryCache implements Serializable {

	public long getEntryId() {

		return entryId;
	}

	public void setEntryId(long entryId) {

		this.entryId = entryId;
	}

	public String getTitle() {

		return title;
	}

	public void setTitle(String title) {

		this.title = title;
	}

	public long getClassNameId() {

		return classNameId;
	}

	public void setClassNameId(long classNameId) {

		this.classNameId = classNameId;
	}

	public long getClassPK() {

		return classPK;
	}

	public void setClassPK(long classPK) {

		this.classPK = classPK;
	}

	public Date getPublishDate() {

		return publishDate;
	}

	public void setPublishDate(Date publishDate) {

		this.publishDate = publishDate;
	}
	
	public Date getCreateDate() {

		return createDate;
	}

	public void setCreateDate(Date createDate) {

		this.createDate = createDate;
	}
	
	public Date getModifiedDate() {

		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {

		this.modifiedDate = modifiedDate;
	}
	
	public Date getExpirationDate() {

		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {

		this.expirationDate = expirationDate;
	}
	
	public double getPriority() {

		return priority;
	}

	public void setPriority(double priority) {

		this.priority = priority;
	}
	
	public int getViewCount() {

		return viewCount;
	}

	public void setViewCount(int viewCount) {

		this.viewCount = viewCount;
	}
	
	public List<AssetCategory> getCategories() {

		return categories;
	}

	public void setCategories(List<AssetCategory> categories) {

		this.categories = categories;
	}
	
	public List<AssetTag> getTags() {

		return tags;
	}

	public void setTags(List<AssetTag> tags) {

		this.tags = tags;
	}
	
	public String getClassName() {

		return className;
	}

	public void setClassName(String className) {

		this.className = className;
	}
	
	private long entryId;
	private long classNameId;
	private long classPK;
	private String title;
	private Date publishDate;
	private Date createDate;
	private Date modifiedDate;
	private Date expirationDate;
	private double priority;
	private int viewCount;
	private List<AssetCategory> categories;
	private List<AssetTag> tags;
	private String className;
	
}
