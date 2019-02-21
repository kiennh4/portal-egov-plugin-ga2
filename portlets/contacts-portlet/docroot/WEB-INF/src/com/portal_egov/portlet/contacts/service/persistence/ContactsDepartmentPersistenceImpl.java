/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.portal_egov.portlet.contacts.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException;
import com.portal_egov.portlet.contacts.model.ContactsDepartment;
import com.portal_egov.portlet.contacts.model.impl.ContactsDepartmentImpl;
import com.portal_egov.portlet.contacts.model.impl.ContactsDepartmentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the contacts department service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see ContactsDepartmentPersistence
 * @see ContactsDepartmentUtil
 * @generated
 */
public class ContactsDepartmentPersistenceImpl extends BasePersistenceImpl<ContactsDepartment>
	implements ContactsDepartmentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ContactsDepartmentUtil} to access the contacts department persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ContactsDepartmentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(ContactsDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentModelImpl.FINDER_CACHE_ENABLED,
			ContactsDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(ContactsDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentModelImpl.FINDER_CACHE_ENABLED,
			ContactsDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			ContactsDepartmentModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(ContactsDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(ContactsDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentModelImpl.FINDER_CACHE_ENABLED,
			ContactsDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(ContactsDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentModelImpl.FINDER_CACHE_ENABLED,
			ContactsDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			ContactsDepartmentModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(ContactsDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTANDCOMPANY =
		new FinderPath(ContactsDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentModelImpl.FINDER_CACHE_ENABLED,
			ContactsDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParentAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDCOMPANY =
		new FinderPath(ContactsDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentModelImpl.FINDER_CACHE_ENABLED,
			ContactsDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByParentAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() },
			ContactsDepartmentModelImpl.COMPANYID_COLUMN_BITMASK |
			ContactsDepartmentModelImpl.PARENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTANDCOMPANY = new FinderPath(ContactsDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByParentAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTANDGROUP =
		new FinderPath(ContactsDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentModelImpl.FINDER_CACHE_ENABLED,
			ContactsDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParentAndGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDGROUP =
		new FinderPath(ContactsDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentModelImpl.FINDER_CACHE_ENABLED,
			ContactsDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParentAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			ContactsDepartmentModelImpl.GROUPID_COLUMN_BITMASK |
			ContactsDepartmentModelImpl.PARENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTANDGROUP = new FinderPath(ContactsDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParentAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSANDCOMPANY =
		new FinderPath(ContactsDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentModelImpl.FINDER_CACHE_ENABLED,
			ContactsDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatusAndCompany",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDCOMPANY =
		new FinderPath(ContactsDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentModelImpl.FINDER_CACHE_ENABLED,
			ContactsDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByStatusAndCompany",
			new String[] { Long.class.getName(), Integer.class.getName() },
			ContactsDepartmentModelImpl.COMPANYID_COLUMN_BITMASK |
			ContactsDepartmentModelImpl.DEPARTMENTSTATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUSANDCOMPANY = new FinderPath(ContactsDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByStatusAndCompany",
			new String[] { Long.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSANDGROUP =
		new FinderPath(ContactsDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentModelImpl.FINDER_CACHE_ENABLED,
			ContactsDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatusAndGroup",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDGROUP =
		new FinderPath(ContactsDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentModelImpl.FINDER_CACHE_ENABLED,
			ContactsDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatusAndGroup",
			new String[] { Long.class.getName(), Integer.class.getName() },
			ContactsDepartmentModelImpl.GROUPID_COLUMN_BITMASK |
			ContactsDepartmentModelImpl.DEPARTMENTSTATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUSANDGROUP = new FinderPath(ContactsDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatusAndGroup",
			new String[] { Long.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ContactsDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentModelImpl.FINDER_CACHE_ENABLED,
			ContactsDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ContactsDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentModelImpl.FINDER_CACHE_ENABLED,
			ContactsDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ContactsDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the contacts department in the entity cache if it is enabled.
	 *
	 * @param contactsDepartment the contacts department
	 */
	public void cacheResult(ContactsDepartment contactsDepartment) {
		EntityCacheUtil.putResult(ContactsDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentImpl.class, contactsDepartment.getPrimaryKey(),
			contactsDepartment);

		contactsDepartment.resetOriginalValues();
	}

	/**
	 * Caches the contacts departments in the entity cache if it is enabled.
	 *
	 * @param contactsDepartments the contacts departments
	 */
	public void cacheResult(List<ContactsDepartment> contactsDepartments) {
		for (ContactsDepartment contactsDepartment : contactsDepartments) {
			if (EntityCacheUtil.getResult(
						ContactsDepartmentModelImpl.ENTITY_CACHE_ENABLED,
						ContactsDepartmentImpl.class,
						contactsDepartment.getPrimaryKey()) == null) {
				cacheResult(contactsDepartment);
			}
			else {
				contactsDepartment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all contacts departments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ContactsDepartmentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ContactsDepartmentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the contacts department.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ContactsDepartment contactsDepartment) {
		EntityCacheUtil.removeResult(ContactsDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentImpl.class, contactsDepartment.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ContactsDepartment> contactsDepartments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ContactsDepartment contactsDepartment : contactsDepartments) {
			EntityCacheUtil.removeResult(ContactsDepartmentModelImpl.ENTITY_CACHE_ENABLED,
				ContactsDepartmentImpl.class, contactsDepartment.getPrimaryKey());
		}
	}

	/**
	 * Creates a new contacts department with the primary key. Does not add the contacts department to the database.
	 *
	 * @param departmentId the primary key for the new contacts department
	 * @return the new contacts department
	 */
	public ContactsDepartment create(long departmentId) {
		ContactsDepartment contactsDepartment = new ContactsDepartmentImpl();

		contactsDepartment.setNew(true);
		contactsDepartment.setPrimaryKey(departmentId);

		return contactsDepartment;
	}

	/**
	 * Removes the contacts department with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param departmentId the primary key of the contacts department
	 * @return the contacts department that was removed
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a contacts department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartment remove(long departmentId)
		throws NoSuchContactsDepartmentException, SystemException {
		return remove(Long.valueOf(departmentId));
	}

	/**
	 * Removes the contacts department with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the contacts department
	 * @return the contacts department that was removed
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a contacts department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactsDepartment remove(Serializable primaryKey)
		throws NoSuchContactsDepartmentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ContactsDepartment contactsDepartment = (ContactsDepartment)session.get(ContactsDepartmentImpl.class,
					primaryKey);

			if (contactsDepartment == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchContactsDepartmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(contactsDepartment);
		}
		catch (NoSuchContactsDepartmentException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ContactsDepartment removeImpl(
		ContactsDepartment contactsDepartment) throws SystemException {
		contactsDepartment = toUnwrappedModel(contactsDepartment);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, contactsDepartment);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(contactsDepartment);

		return contactsDepartment;
	}

	@Override
	public ContactsDepartment updateImpl(
		com.portal_egov.portlet.contacts.model.ContactsDepartment contactsDepartment,
		boolean merge) throws SystemException {
		contactsDepartment = toUnwrappedModel(contactsDepartment);

		boolean isNew = contactsDepartment.isNew();

		ContactsDepartmentModelImpl contactsDepartmentModelImpl = (ContactsDepartmentModelImpl)contactsDepartment;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, contactsDepartment, merge);

			contactsDepartment.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ContactsDepartmentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((contactsDepartmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(contactsDepartmentModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] {
						Long.valueOf(contactsDepartmentModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((contactsDepartmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(contactsDepartmentModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] {
						Long.valueOf(contactsDepartmentModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}

			if ((contactsDepartmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(contactsDepartmentModelImpl.getOriginalCompanyId()),
						Long.valueOf(contactsDepartmentModelImpl.getOriginalParentId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDCOMPANY,
					args);

				args = new Object[] {
						Long.valueOf(contactsDepartmentModelImpl.getCompanyId()),
						Long.valueOf(contactsDepartmentModelImpl.getParentId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDCOMPANY,
					args);
			}

			if ((contactsDepartmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(contactsDepartmentModelImpl.getOriginalGroupId()),
						Long.valueOf(contactsDepartmentModelImpl.getOriginalParentId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDGROUP,
					args);

				args = new Object[] {
						Long.valueOf(contactsDepartmentModelImpl.getGroupId()),
						Long.valueOf(contactsDepartmentModelImpl.getParentId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDGROUP,
					args);
			}

			if ((contactsDepartmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(contactsDepartmentModelImpl.getOriginalCompanyId()),
						Integer.valueOf(contactsDepartmentModelImpl.getOriginalDepartmentStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDCOMPANY,
					args);

				args = new Object[] {
						Long.valueOf(contactsDepartmentModelImpl.getCompanyId()),
						Integer.valueOf(contactsDepartmentModelImpl.getDepartmentStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDCOMPANY,
					args);
			}

			if ((contactsDepartmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(contactsDepartmentModelImpl.getOriginalGroupId()),
						Integer.valueOf(contactsDepartmentModelImpl.getOriginalDepartmentStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDGROUP,
					args);

				args = new Object[] {
						Long.valueOf(contactsDepartmentModelImpl.getGroupId()),
						Integer.valueOf(contactsDepartmentModelImpl.getDepartmentStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDGROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(ContactsDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentImpl.class, contactsDepartment.getPrimaryKey(),
			contactsDepartment);

		return contactsDepartment;
	}

	protected ContactsDepartment toUnwrappedModel(
		ContactsDepartment contactsDepartment) {
		if (contactsDepartment instanceof ContactsDepartmentImpl) {
			return contactsDepartment;
		}

		ContactsDepartmentImpl contactsDepartmentImpl = new ContactsDepartmentImpl();

		contactsDepartmentImpl.setNew(contactsDepartment.isNew());
		contactsDepartmentImpl.setPrimaryKey(contactsDepartment.getPrimaryKey());

		contactsDepartmentImpl.setDepartmentId(contactsDepartment.getDepartmentId());
		contactsDepartmentImpl.setGroupId(contactsDepartment.getGroupId());
		contactsDepartmentImpl.setCompanyId(contactsDepartment.getCompanyId());
		contactsDepartmentImpl.setUserId(contactsDepartment.getUserId());
		contactsDepartmentImpl.setUserName(contactsDepartment.getUserName());
		contactsDepartmentImpl.setCreateDate(contactsDepartment.getCreateDate());
		contactsDepartmentImpl.setModifiedDate(contactsDepartment.getModifiedDate());
		contactsDepartmentImpl.setParentId(contactsDepartment.getParentId());
		contactsDepartmentImpl.setDepartmentName(contactsDepartment.getDepartmentName());
		contactsDepartmentImpl.setDepartmentAddress(contactsDepartment.getDepartmentAddress());
		contactsDepartmentImpl.setDepartmentPhone(contactsDepartment.getDepartmentPhone());
		contactsDepartmentImpl.setDepartmentWebsite(contactsDepartment.getDepartmentWebsite());
		contactsDepartmentImpl.setDepartmentEmail(contactsDepartment.getDepartmentEmail());
		contactsDepartmentImpl.setDisplayPriority(contactsDepartment.getDisplayPriority());
		contactsDepartmentImpl.setDepartmentStatus(contactsDepartment.getDepartmentStatus());

		return contactsDepartmentImpl;
	}

	/**
	 * Returns the contacts department with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the contacts department
	 * @return the contacts department
	 * @throws com.liferay.portal.NoSuchModelException if a contacts department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactsDepartment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the contacts department with the primary key or throws a {@link com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException} if it could not be found.
	 *
	 * @param departmentId the primary key of the contacts department
	 * @return the contacts department
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a contacts department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartment findByPrimaryKey(long departmentId)
		throws NoSuchContactsDepartmentException, SystemException {
		ContactsDepartment contactsDepartment = fetchByPrimaryKey(departmentId);

		if (contactsDepartment == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + departmentId);
			}

			throw new NoSuchContactsDepartmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				departmentId);
		}

		return contactsDepartment;
	}

	/**
	 * Returns the contacts department with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the contacts department
	 * @return the contacts department, or <code>null</code> if a contacts department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactsDepartment fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the contacts department with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param departmentId the primary key of the contacts department
	 * @return the contacts department, or <code>null</code> if a contacts department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartment fetchByPrimaryKey(long departmentId)
		throws SystemException {
		ContactsDepartment contactsDepartment = (ContactsDepartment)EntityCacheUtil.getResult(ContactsDepartmentModelImpl.ENTITY_CACHE_ENABLED,
				ContactsDepartmentImpl.class, departmentId);

		if (contactsDepartment == _nullContactsDepartment) {
			return null;
		}

		if (contactsDepartment == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				contactsDepartment = (ContactsDepartment)session.get(ContactsDepartmentImpl.class,
						Long.valueOf(departmentId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (contactsDepartment != null) {
					cacheResult(contactsDepartment);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ContactsDepartmentModelImpl.ENTITY_CACHE_ENABLED,
						ContactsDepartmentImpl.class, departmentId,
						_nullContactsDepartment);
				}

				closeSession(session);
			}
		}

		return contactsDepartment;
	}

	/**
	 * Returns all the contacts departments where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching contacts departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartment> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the contacts departments where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of contacts departments
	 * @param end the upper bound of the range of contacts departments (not inclusive)
	 * @return the range of matching contacts departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartment> findByCompany(long companyId, int start,
		int end) throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contacts departments where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of contacts departments
	 * @param end the upper bound of the range of contacts departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contacts departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartment> findByCompany(long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<ContactsDepartment> list = (List<ContactsDepartment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ContactsDepartment contactsDepartment : list) {
				if ((companyId != contactsDepartment.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CONTACTSDEPARTMENT_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ContactsDepartmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<ContactsDepartment>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first contacts department in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts department
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a matching contacts department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartment findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchContactsDepartmentException, SystemException {
		ContactsDepartment contactsDepartment = fetchByCompany_First(companyId,
				orderByComparator);

		if (contactsDepartment != null) {
			return contactsDepartment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsDepartmentException(msg.toString());
	}

	/**
	 * Returns the first contacts department in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts department, or <code>null</code> if a matching contacts department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartment fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ContactsDepartment> list = findByCompany(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contacts department in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts department
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a matching contacts department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartment findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchContactsDepartmentException, SystemException {
		ContactsDepartment contactsDepartment = fetchByCompany_Last(companyId,
				orderByComparator);

		if (contactsDepartment != null) {
			return contactsDepartment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsDepartmentException(msg.toString());
	}

	/**
	 * Returns the last contacts department in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts department, or <code>null</code> if a matching contacts department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartment fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		List<ContactsDepartment> list = findByCompany(companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contacts departments before and after the current contacts department in the ordered set where companyId = &#63;.
	 *
	 * @param departmentId the primary key of the current contacts department
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contacts department
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a contacts department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartment[] findByCompany_PrevAndNext(long departmentId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchContactsDepartmentException, SystemException {
		ContactsDepartment contactsDepartment = findByPrimaryKey(departmentId);

		Session session = null;

		try {
			session = openSession();

			ContactsDepartment[] array = new ContactsDepartmentImpl[3];

			array[0] = getByCompany_PrevAndNext(session, contactsDepartment,
					companyId, orderByComparator, true);

			array[1] = contactsDepartment;

			array[2] = getByCompany_PrevAndNext(session, contactsDepartment,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ContactsDepartment getByCompany_PrevAndNext(Session session,
		ContactsDepartment contactsDepartment, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTSDEPARTMENT_WHERE);

		query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ContactsDepartmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contactsDepartment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContactsDepartment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the contacts departments where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching contacts departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartment> findByGroup(long groupId)
		throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contacts departments where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of contacts departments
	 * @param end the upper bound of the range of contacts departments (not inclusive)
	 * @return the range of matching contacts departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartment> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contacts departments where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of contacts departments
	 * @param end the upper bound of the range of contacts departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contacts departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartment> findByGroup(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<ContactsDepartment> list = (List<ContactsDepartment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ContactsDepartment contactsDepartment : list) {
				if ((groupId != contactsDepartment.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CONTACTSDEPARTMENT_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ContactsDepartmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<ContactsDepartment>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first contacts department in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts department
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a matching contacts department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartment findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchContactsDepartmentException, SystemException {
		ContactsDepartment contactsDepartment = fetchByGroup_First(groupId,
				orderByComparator);

		if (contactsDepartment != null) {
			return contactsDepartment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsDepartmentException(msg.toString());
	}

	/**
	 * Returns the first contacts department in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts department, or <code>null</code> if a matching contacts department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartment fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ContactsDepartment> list = findByGroup(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contacts department in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts department
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a matching contacts department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartment findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchContactsDepartmentException, SystemException {
		ContactsDepartment contactsDepartment = fetchByGroup_Last(groupId,
				orderByComparator);

		if (contactsDepartment != null) {
			return contactsDepartment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsDepartmentException(msg.toString());
	}

	/**
	 * Returns the last contacts department in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts department, or <code>null</code> if a matching contacts department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartment fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<ContactsDepartment> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contacts departments before and after the current contacts department in the ordered set where groupId = &#63;.
	 *
	 * @param departmentId the primary key of the current contacts department
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contacts department
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a contacts department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartment[] findByGroup_PrevAndNext(long departmentId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchContactsDepartmentException, SystemException {
		ContactsDepartment contactsDepartment = findByPrimaryKey(departmentId);

		Session session = null;

		try {
			session = openSession();

			ContactsDepartment[] array = new ContactsDepartmentImpl[3];

			array[0] = getByGroup_PrevAndNext(session, contactsDepartment,
					groupId, orderByComparator, true);

			array[1] = contactsDepartment;

			array[2] = getByGroup_PrevAndNext(session, contactsDepartment,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ContactsDepartment getByGroup_PrevAndNext(Session session,
		ContactsDepartment contactsDepartment, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTSDEPARTMENT_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ContactsDepartmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contactsDepartment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContactsDepartment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the contacts departments that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching contacts departments that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartment> filterFindByGroup(long groupId)
		throws SystemException {
		return filterFindByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the contacts departments that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of contacts departments
	 * @param end the upper bound of the range of contacts departments (not inclusive)
	 * @return the range of matching contacts departments that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartment> filterFindByGroup(long groupId, int start,
		int end) throws SystemException {
		return filterFindByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contacts departments that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of contacts departments
	 * @param end the upper bound of the range of contacts departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contacts departments that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartment> filterFindByGroup(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup(groupId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CONTACTSDEPARTMENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTACTSDEPARTMENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CONTACTSDEPARTMENT_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator);
			}
		}

		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(ContactsDepartmentModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ContactsDepartmentModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ContactsDepartment.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, ContactsDepartmentImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, ContactsDepartmentImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<ContactsDepartment>)QueryUtil.list(q, getDialect(),
				start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the contacts departments before and after the current contacts department in the ordered set of contacts departments that the user has permission to view where groupId = &#63;.
	 *
	 * @param departmentId the primary key of the current contacts department
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contacts department
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a contacts department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartment[] filterFindByGroup_PrevAndNext(
		long departmentId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchContactsDepartmentException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup_PrevAndNext(departmentId, groupId,
				orderByComparator);
		}

		ContactsDepartment contactsDepartment = findByPrimaryKey(departmentId);

		Session session = null;

		try {
			session = openSession();

			ContactsDepartment[] array = new ContactsDepartmentImpl[3];

			array[0] = filterGetByGroup_PrevAndNext(session,
					contactsDepartment, groupId, orderByComparator, true);

			array[1] = contactsDepartment;

			array[2] = filterGetByGroup_PrevAndNext(session,
					contactsDepartment, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ContactsDepartment filterGetByGroup_PrevAndNext(Session session,
		ContactsDepartment contactsDepartment, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CONTACTSDEPARTMENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTACTSDEPARTMENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CONTACTSDEPARTMENT_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(ContactsDepartmentModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ContactsDepartmentModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ContactsDepartment.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, ContactsDepartmentImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, ContactsDepartmentImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contactsDepartment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContactsDepartment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the contacts departments where companyId = &#63; and parentId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @return the matching contacts departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartment> findByParentAndCompany(long companyId,
		long parentId) throws SystemException {
		return findByParentAndCompany(companyId, parentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contacts departments where companyId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of contacts departments
	 * @param end the upper bound of the range of contacts departments (not inclusive)
	 * @return the range of matching contacts departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartment> findByParentAndCompany(long companyId,
		long parentId, int start, int end) throws SystemException {
		return findByParentAndCompany(companyId, parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contacts departments where companyId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of contacts departments
	 * @param end the upper bound of the range of contacts departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contacts departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartment> findByParentAndCompany(long companyId,
		long parentId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDCOMPANY;
			finderArgs = new Object[] { companyId, parentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTANDCOMPANY;
			finderArgs = new Object[] {
					companyId, parentId,
					
					start, end, orderByComparator
				};
		}

		List<ContactsDepartment> list = (List<ContactsDepartment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ContactsDepartment contactsDepartment : list) {
				if ((companyId != contactsDepartment.getCompanyId()) ||
						(parentId != contactsDepartment.getParentId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_CONTACTSDEPARTMENT_WHERE);

			query.append(_FINDER_COLUMN_PARENTANDCOMPANY_COMPANYID_2);

			query.append(_FINDER_COLUMN_PARENTANDCOMPANY_PARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ContactsDepartmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(parentId);

				list = (List<ContactsDepartment>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first contacts department in the ordered set where companyId = &#63; and parentId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts department
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a matching contacts department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartment findByParentAndCompany_First(long companyId,
		long parentId, OrderByComparator orderByComparator)
		throws NoSuchContactsDepartmentException, SystemException {
		ContactsDepartment contactsDepartment = fetchByParentAndCompany_First(companyId,
				parentId, orderByComparator);

		if (contactsDepartment != null) {
			return contactsDepartment;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsDepartmentException(msg.toString());
	}

	/**
	 * Returns the first contacts department in the ordered set where companyId = &#63; and parentId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts department, or <code>null</code> if a matching contacts department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartment fetchByParentAndCompany_First(long companyId,
		long parentId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ContactsDepartment> list = findByParentAndCompany(companyId,
				parentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contacts department in the ordered set where companyId = &#63; and parentId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts department
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a matching contacts department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartment findByParentAndCompany_Last(long companyId,
		long parentId, OrderByComparator orderByComparator)
		throws NoSuchContactsDepartmentException, SystemException {
		ContactsDepartment contactsDepartment = fetchByParentAndCompany_Last(companyId,
				parentId, orderByComparator);

		if (contactsDepartment != null) {
			return contactsDepartment;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsDepartmentException(msg.toString());
	}

	/**
	 * Returns the last contacts department in the ordered set where companyId = &#63; and parentId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts department, or <code>null</code> if a matching contacts department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartment fetchByParentAndCompany_Last(long companyId,
		long parentId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByParentAndCompany(companyId, parentId);

		List<ContactsDepartment> list = findByParentAndCompany(companyId,
				parentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contacts departments before and after the current contacts department in the ordered set where companyId = &#63; and parentId = &#63;.
	 *
	 * @param departmentId the primary key of the current contacts department
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contacts department
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a contacts department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartment[] findByParentAndCompany_PrevAndNext(
		long departmentId, long companyId, long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchContactsDepartmentException, SystemException {
		ContactsDepartment contactsDepartment = findByPrimaryKey(departmentId);

		Session session = null;

		try {
			session = openSession();

			ContactsDepartment[] array = new ContactsDepartmentImpl[3];

			array[0] = getByParentAndCompany_PrevAndNext(session,
					contactsDepartment, companyId, parentId, orderByComparator,
					true);

			array[1] = contactsDepartment;

			array[2] = getByParentAndCompany_PrevAndNext(session,
					contactsDepartment, companyId, parentId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ContactsDepartment getByParentAndCompany_PrevAndNext(
		Session session, ContactsDepartment contactsDepartment, long companyId,
		long parentId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTSDEPARTMENT_WHERE);

		query.append(_FINDER_COLUMN_PARENTANDCOMPANY_COMPANYID_2);

		query.append(_FINDER_COLUMN_PARENTANDCOMPANY_PARENTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ContactsDepartmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(parentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contactsDepartment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContactsDepartment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the contacts departments where groupId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @return the matching contacts departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartment> findByParentAndGroup(long groupId,
		long parentId) throws SystemException {
		return findByParentAndGroup(groupId, parentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contacts departments where groupId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of contacts departments
	 * @param end the upper bound of the range of contacts departments (not inclusive)
	 * @return the range of matching contacts departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartment> findByParentAndGroup(long groupId,
		long parentId, int start, int end) throws SystemException {
		return findByParentAndGroup(groupId, parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contacts departments where groupId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of contacts departments
	 * @param end the upper bound of the range of contacts departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contacts departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartment> findByParentAndGroup(long groupId,
		long parentId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDGROUP;
			finderArgs = new Object[] { groupId, parentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTANDGROUP;
			finderArgs = new Object[] {
					groupId, parentId,
					
					start, end, orderByComparator
				};
		}

		List<ContactsDepartment> list = (List<ContactsDepartment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ContactsDepartment contactsDepartment : list) {
				if ((groupId != contactsDepartment.getGroupId()) ||
						(parentId != contactsDepartment.getParentId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_CONTACTSDEPARTMENT_WHERE);

			query.append(_FINDER_COLUMN_PARENTANDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_PARENTANDGROUP_PARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ContactsDepartmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(parentId);

				list = (List<ContactsDepartment>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first contacts department in the ordered set where groupId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts department
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a matching contacts department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartment findByParentAndGroup_First(long groupId,
		long parentId, OrderByComparator orderByComparator)
		throws NoSuchContactsDepartmentException, SystemException {
		ContactsDepartment contactsDepartment = fetchByParentAndGroup_First(groupId,
				parentId, orderByComparator);

		if (contactsDepartment != null) {
			return contactsDepartment;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsDepartmentException(msg.toString());
	}

	/**
	 * Returns the first contacts department in the ordered set where groupId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts department, or <code>null</code> if a matching contacts department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartment fetchByParentAndGroup_First(long groupId,
		long parentId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ContactsDepartment> list = findByParentAndGroup(groupId, parentId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contacts department in the ordered set where groupId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts department
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a matching contacts department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartment findByParentAndGroup_Last(long groupId,
		long parentId, OrderByComparator orderByComparator)
		throws NoSuchContactsDepartmentException, SystemException {
		ContactsDepartment contactsDepartment = fetchByParentAndGroup_Last(groupId,
				parentId, orderByComparator);

		if (contactsDepartment != null) {
			return contactsDepartment;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsDepartmentException(msg.toString());
	}

	/**
	 * Returns the last contacts department in the ordered set where groupId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts department, or <code>null</code> if a matching contacts department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartment fetchByParentAndGroup_Last(long groupId,
		long parentId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByParentAndGroup(groupId, parentId);

		List<ContactsDepartment> list = findByParentAndGroup(groupId, parentId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contacts departments before and after the current contacts department in the ordered set where groupId = &#63; and parentId = &#63;.
	 *
	 * @param departmentId the primary key of the current contacts department
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contacts department
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a contacts department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartment[] findByParentAndGroup_PrevAndNext(
		long departmentId, long groupId, long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchContactsDepartmentException, SystemException {
		ContactsDepartment contactsDepartment = findByPrimaryKey(departmentId);

		Session session = null;

		try {
			session = openSession();

			ContactsDepartment[] array = new ContactsDepartmentImpl[3];

			array[0] = getByParentAndGroup_PrevAndNext(session,
					contactsDepartment, groupId, parentId, orderByComparator,
					true);

			array[1] = contactsDepartment;

			array[2] = getByParentAndGroup_PrevAndNext(session,
					contactsDepartment, groupId, parentId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ContactsDepartment getByParentAndGroup_PrevAndNext(
		Session session, ContactsDepartment contactsDepartment, long groupId,
		long parentId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTSDEPARTMENT_WHERE);

		query.append(_FINDER_COLUMN_PARENTANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_PARENTANDGROUP_PARENTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ContactsDepartmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(parentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contactsDepartment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContactsDepartment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the contacts departments that the user has permission to view where groupId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @return the matching contacts departments that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartment> filterFindByParentAndGroup(long groupId,
		long parentId) throws SystemException {
		return filterFindByParentAndGroup(groupId, parentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contacts departments that the user has permission to view where groupId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of contacts departments
	 * @param end the upper bound of the range of contacts departments (not inclusive)
	 * @return the range of matching contacts departments that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartment> filterFindByParentAndGroup(long groupId,
		long parentId, int start, int end) throws SystemException {
		return filterFindByParentAndGroup(groupId, parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contacts departments that the user has permissions to view where groupId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of contacts departments
	 * @param end the upper bound of the range of contacts departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contacts departments that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartment> filterFindByParentAndGroup(long groupId,
		long parentId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByParentAndGroup(groupId, parentId, start, end,
				orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CONTACTSDEPARTMENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTACTSDEPARTMENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_PARENTANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_PARENTANDGROUP_PARENTID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CONTACTSDEPARTMENT_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator);
			}
		}

		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(ContactsDepartmentModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ContactsDepartmentModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ContactsDepartment.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, ContactsDepartmentImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, ContactsDepartmentImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(parentId);

			return (List<ContactsDepartment>)QueryUtil.list(q, getDialect(),
				start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the contacts departments before and after the current contacts department in the ordered set of contacts departments that the user has permission to view where groupId = &#63; and parentId = &#63;.
	 *
	 * @param departmentId the primary key of the current contacts department
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contacts department
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a contacts department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartment[] filterFindByParentAndGroup_PrevAndNext(
		long departmentId, long groupId, long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchContactsDepartmentException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByParentAndGroup_PrevAndNext(departmentId, groupId,
				parentId, orderByComparator);
		}

		ContactsDepartment contactsDepartment = findByPrimaryKey(departmentId);

		Session session = null;

		try {
			session = openSession();

			ContactsDepartment[] array = new ContactsDepartmentImpl[3];

			array[0] = filterGetByParentAndGroup_PrevAndNext(session,
					contactsDepartment, groupId, parentId, orderByComparator,
					true);

			array[1] = contactsDepartment;

			array[2] = filterGetByParentAndGroup_PrevAndNext(session,
					contactsDepartment, groupId, parentId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ContactsDepartment filterGetByParentAndGroup_PrevAndNext(
		Session session, ContactsDepartment contactsDepartment, long groupId,
		long parentId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CONTACTSDEPARTMENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTACTSDEPARTMENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_PARENTANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_PARENTANDGROUP_PARENTID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CONTACTSDEPARTMENT_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(ContactsDepartmentModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ContactsDepartmentModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ContactsDepartment.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, ContactsDepartmentImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, ContactsDepartmentImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(parentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contactsDepartment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContactsDepartment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the contacts departments where companyId = &#63; and departmentStatus = &#63;.
	 *
	 * @param companyId the company ID
	 * @param departmentStatus the department status
	 * @return the matching contacts departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartment> findByStatusAndCompany(long companyId,
		int departmentStatus) throws SystemException {
		return findByStatusAndCompany(companyId, departmentStatus,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contacts departments where companyId = &#63; and departmentStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param departmentStatus the department status
	 * @param start the lower bound of the range of contacts departments
	 * @param end the upper bound of the range of contacts departments (not inclusive)
	 * @return the range of matching contacts departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartment> findByStatusAndCompany(long companyId,
		int departmentStatus, int start, int end) throws SystemException {
		return findByStatusAndCompany(companyId, departmentStatus, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the contacts departments where companyId = &#63; and departmentStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param departmentStatus the department status
	 * @param start the lower bound of the range of contacts departments
	 * @param end the upper bound of the range of contacts departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contacts departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartment> findByStatusAndCompany(long companyId,
		int departmentStatus, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDCOMPANY;
			finderArgs = new Object[] { companyId, departmentStatus };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSANDCOMPANY;
			finderArgs = new Object[] {
					companyId, departmentStatus,
					
					start, end, orderByComparator
				};
		}

		List<ContactsDepartment> list = (List<ContactsDepartment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ContactsDepartment contactsDepartment : list) {
				if ((companyId != contactsDepartment.getCompanyId()) ||
						(departmentStatus != contactsDepartment.getDepartmentStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_CONTACTSDEPARTMENT_WHERE);

			query.append(_FINDER_COLUMN_STATUSANDCOMPANY_COMPANYID_2);

			query.append(_FINDER_COLUMN_STATUSANDCOMPANY_DEPARTMENTSTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ContactsDepartmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(departmentStatus);

				list = (List<ContactsDepartment>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first contacts department in the ordered set where companyId = &#63; and departmentStatus = &#63;.
	 *
	 * @param companyId the company ID
	 * @param departmentStatus the department status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts department
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a matching contacts department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartment findByStatusAndCompany_First(long companyId,
		int departmentStatus, OrderByComparator orderByComparator)
		throws NoSuchContactsDepartmentException, SystemException {
		ContactsDepartment contactsDepartment = fetchByStatusAndCompany_First(companyId,
				departmentStatus, orderByComparator);

		if (contactsDepartment != null) {
			return contactsDepartment;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", departmentStatus=");
		msg.append(departmentStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsDepartmentException(msg.toString());
	}

	/**
	 * Returns the first contacts department in the ordered set where companyId = &#63; and departmentStatus = &#63;.
	 *
	 * @param companyId the company ID
	 * @param departmentStatus the department status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts department, or <code>null</code> if a matching contacts department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartment fetchByStatusAndCompany_First(long companyId,
		int departmentStatus, OrderByComparator orderByComparator)
		throws SystemException {
		List<ContactsDepartment> list = findByStatusAndCompany(companyId,
				departmentStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contacts department in the ordered set where companyId = &#63; and departmentStatus = &#63;.
	 *
	 * @param companyId the company ID
	 * @param departmentStatus the department status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts department
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a matching contacts department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartment findByStatusAndCompany_Last(long companyId,
		int departmentStatus, OrderByComparator orderByComparator)
		throws NoSuchContactsDepartmentException, SystemException {
		ContactsDepartment contactsDepartment = fetchByStatusAndCompany_Last(companyId,
				departmentStatus, orderByComparator);

		if (contactsDepartment != null) {
			return contactsDepartment;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", departmentStatus=");
		msg.append(departmentStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsDepartmentException(msg.toString());
	}

	/**
	 * Returns the last contacts department in the ordered set where companyId = &#63; and departmentStatus = &#63;.
	 *
	 * @param companyId the company ID
	 * @param departmentStatus the department status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts department, or <code>null</code> if a matching contacts department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartment fetchByStatusAndCompany_Last(long companyId,
		int departmentStatus, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByStatusAndCompany(companyId, departmentStatus);

		List<ContactsDepartment> list = findByStatusAndCompany(companyId,
				departmentStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contacts departments before and after the current contacts department in the ordered set where companyId = &#63; and departmentStatus = &#63;.
	 *
	 * @param departmentId the primary key of the current contacts department
	 * @param companyId the company ID
	 * @param departmentStatus the department status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contacts department
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a contacts department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartment[] findByStatusAndCompany_PrevAndNext(
		long departmentId, long companyId, int departmentStatus,
		OrderByComparator orderByComparator)
		throws NoSuchContactsDepartmentException, SystemException {
		ContactsDepartment contactsDepartment = findByPrimaryKey(departmentId);

		Session session = null;

		try {
			session = openSession();

			ContactsDepartment[] array = new ContactsDepartmentImpl[3];

			array[0] = getByStatusAndCompany_PrevAndNext(session,
					contactsDepartment, companyId, departmentStatus,
					orderByComparator, true);

			array[1] = contactsDepartment;

			array[2] = getByStatusAndCompany_PrevAndNext(session,
					contactsDepartment, companyId, departmentStatus,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ContactsDepartment getByStatusAndCompany_PrevAndNext(
		Session session, ContactsDepartment contactsDepartment, long companyId,
		int departmentStatus, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTSDEPARTMENT_WHERE);

		query.append(_FINDER_COLUMN_STATUSANDCOMPANY_COMPANYID_2);

		query.append(_FINDER_COLUMN_STATUSANDCOMPANY_DEPARTMENTSTATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ContactsDepartmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(departmentStatus);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contactsDepartment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContactsDepartment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the contacts departments where groupId = &#63; and departmentStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param departmentStatus the department status
	 * @return the matching contacts departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartment> findByStatusAndGroup(long groupId,
		int departmentStatus) throws SystemException {
		return findByStatusAndGroup(groupId, departmentStatus,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contacts departments where groupId = &#63; and departmentStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param departmentStatus the department status
	 * @param start the lower bound of the range of contacts departments
	 * @param end the upper bound of the range of contacts departments (not inclusive)
	 * @return the range of matching contacts departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartment> findByStatusAndGroup(long groupId,
		int departmentStatus, int start, int end) throws SystemException {
		return findByStatusAndGroup(groupId, departmentStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contacts departments where groupId = &#63; and departmentStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param departmentStatus the department status
	 * @param start the lower bound of the range of contacts departments
	 * @param end the upper bound of the range of contacts departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contacts departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartment> findByStatusAndGroup(long groupId,
		int departmentStatus, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDGROUP;
			finderArgs = new Object[] { groupId, departmentStatus };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSANDGROUP;
			finderArgs = new Object[] {
					groupId, departmentStatus,
					
					start, end, orderByComparator
				};
		}

		List<ContactsDepartment> list = (List<ContactsDepartment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ContactsDepartment contactsDepartment : list) {
				if ((groupId != contactsDepartment.getGroupId()) ||
						(departmentStatus != contactsDepartment.getDepartmentStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_CONTACTSDEPARTMENT_WHERE);

			query.append(_FINDER_COLUMN_STATUSANDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_STATUSANDGROUP_DEPARTMENTSTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ContactsDepartmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(departmentStatus);

				list = (List<ContactsDepartment>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first contacts department in the ordered set where groupId = &#63; and departmentStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param departmentStatus the department status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts department
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a matching contacts department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartment findByStatusAndGroup_First(long groupId,
		int departmentStatus, OrderByComparator orderByComparator)
		throws NoSuchContactsDepartmentException, SystemException {
		ContactsDepartment contactsDepartment = fetchByStatusAndGroup_First(groupId,
				departmentStatus, orderByComparator);

		if (contactsDepartment != null) {
			return contactsDepartment;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", departmentStatus=");
		msg.append(departmentStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsDepartmentException(msg.toString());
	}

	/**
	 * Returns the first contacts department in the ordered set where groupId = &#63; and departmentStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param departmentStatus the department status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts department, or <code>null</code> if a matching contacts department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartment fetchByStatusAndGroup_First(long groupId,
		int departmentStatus, OrderByComparator orderByComparator)
		throws SystemException {
		List<ContactsDepartment> list = findByStatusAndGroup(groupId,
				departmentStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contacts department in the ordered set where groupId = &#63; and departmentStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param departmentStatus the department status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts department
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a matching contacts department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartment findByStatusAndGroup_Last(long groupId,
		int departmentStatus, OrderByComparator orderByComparator)
		throws NoSuchContactsDepartmentException, SystemException {
		ContactsDepartment contactsDepartment = fetchByStatusAndGroup_Last(groupId,
				departmentStatus, orderByComparator);

		if (contactsDepartment != null) {
			return contactsDepartment;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", departmentStatus=");
		msg.append(departmentStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsDepartmentException(msg.toString());
	}

	/**
	 * Returns the last contacts department in the ordered set where groupId = &#63; and departmentStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param departmentStatus the department status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts department, or <code>null</code> if a matching contacts department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartment fetchByStatusAndGroup_Last(long groupId,
		int departmentStatus, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByStatusAndGroup(groupId, departmentStatus);

		List<ContactsDepartment> list = findByStatusAndGroup(groupId,
				departmentStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contacts departments before and after the current contacts department in the ordered set where groupId = &#63; and departmentStatus = &#63;.
	 *
	 * @param departmentId the primary key of the current contacts department
	 * @param groupId the group ID
	 * @param departmentStatus the department status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contacts department
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a contacts department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartment[] findByStatusAndGroup_PrevAndNext(
		long departmentId, long groupId, int departmentStatus,
		OrderByComparator orderByComparator)
		throws NoSuchContactsDepartmentException, SystemException {
		ContactsDepartment contactsDepartment = findByPrimaryKey(departmentId);

		Session session = null;

		try {
			session = openSession();

			ContactsDepartment[] array = new ContactsDepartmentImpl[3];

			array[0] = getByStatusAndGroup_PrevAndNext(session,
					contactsDepartment, groupId, departmentStatus,
					orderByComparator, true);

			array[1] = contactsDepartment;

			array[2] = getByStatusAndGroup_PrevAndNext(session,
					contactsDepartment, groupId, departmentStatus,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ContactsDepartment getByStatusAndGroup_PrevAndNext(
		Session session, ContactsDepartment contactsDepartment, long groupId,
		int departmentStatus, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTSDEPARTMENT_WHERE);

		query.append(_FINDER_COLUMN_STATUSANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_STATUSANDGROUP_DEPARTMENTSTATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ContactsDepartmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(departmentStatus);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contactsDepartment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContactsDepartment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the contacts departments that the user has permission to view where groupId = &#63; and departmentStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param departmentStatus the department status
	 * @return the matching contacts departments that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartment> filterFindByStatusAndGroup(long groupId,
		int departmentStatus) throws SystemException {
		return filterFindByStatusAndGroup(groupId, departmentStatus,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contacts departments that the user has permission to view where groupId = &#63; and departmentStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param departmentStatus the department status
	 * @param start the lower bound of the range of contacts departments
	 * @param end the upper bound of the range of contacts departments (not inclusive)
	 * @return the range of matching contacts departments that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartment> filterFindByStatusAndGroup(long groupId,
		int departmentStatus, int start, int end) throws SystemException {
		return filterFindByStatusAndGroup(groupId, departmentStatus, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the contacts departments that the user has permissions to view where groupId = &#63; and departmentStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param departmentStatus the department status
	 * @param start the lower bound of the range of contacts departments
	 * @param end the upper bound of the range of contacts departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contacts departments that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartment> filterFindByStatusAndGroup(long groupId,
		int departmentStatus, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByStatusAndGroup(groupId, departmentStatus, start, end,
				orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CONTACTSDEPARTMENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTACTSDEPARTMENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_STATUSANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_STATUSANDGROUP_DEPARTMENTSTATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CONTACTSDEPARTMENT_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator);
			}
		}

		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(ContactsDepartmentModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ContactsDepartmentModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ContactsDepartment.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, ContactsDepartmentImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, ContactsDepartmentImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(departmentStatus);

			return (List<ContactsDepartment>)QueryUtil.list(q, getDialect(),
				start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the contacts departments before and after the current contacts department in the ordered set of contacts departments that the user has permission to view where groupId = &#63; and departmentStatus = &#63;.
	 *
	 * @param departmentId the primary key of the current contacts department
	 * @param groupId the group ID
	 * @param departmentStatus the department status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contacts department
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a contacts department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartment[] filterFindByStatusAndGroup_PrevAndNext(
		long departmentId, long groupId, int departmentStatus,
		OrderByComparator orderByComparator)
		throws NoSuchContactsDepartmentException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByStatusAndGroup_PrevAndNext(departmentId, groupId,
				departmentStatus, orderByComparator);
		}

		ContactsDepartment contactsDepartment = findByPrimaryKey(departmentId);

		Session session = null;

		try {
			session = openSession();

			ContactsDepartment[] array = new ContactsDepartmentImpl[3];

			array[0] = filterGetByStatusAndGroup_PrevAndNext(session,
					contactsDepartment, groupId, departmentStatus,
					orderByComparator, true);

			array[1] = contactsDepartment;

			array[2] = filterGetByStatusAndGroup_PrevAndNext(session,
					contactsDepartment, groupId, departmentStatus,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ContactsDepartment filterGetByStatusAndGroup_PrevAndNext(
		Session session, ContactsDepartment contactsDepartment, long groupId,
		int departmentStatus, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CONTACTSDEPARTMENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTACTSDEPARTMENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_STATUSANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_STATUSANDGROUP_DEPARTMENTSTATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CONTACTSDEPARTMENT_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(ContactsDepartmentModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ContactsDepartmentModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ContactsDepartment.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, ContactsDepartmentImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, ContactsDepartmentImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(departmentStatus);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contactsDepartment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContactsDepartment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the contacts departments.
	 *
	 * @return the contacts departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartment> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contacts departments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of contacts departments
	 * @param end the upper bound of the range of contacts departments (not inclusive)
	 * @return the range of contacts departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartment> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the contacts departments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of contacts departments
	 * @param end the upper bound of the range of contacts departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of contacts departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartment> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<ContactsDepartment> list = (List<ContactsDepartment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONTACTSDEPARTMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONTACTSDEPARTMENT.concat(ContactsDepartmentModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ContactsDepartment>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ContactsDepartment>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the contacts departments where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompany(long companyId) throws SystemException {
		for (ContactsDepartment contactsDepartment : findByCompany(companyId)) {
			remove(contactsDepartment);
		}
	}

	/**
	 * Removes all the contacts departments where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (ContactsDepartment contactsDepartment : findByGroup(groupId)) {
			remove(contactsDepartment);
		}
	}

	/**
	 * Removes all the contacts departments where companyId = &#63; and parentId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByParentAndCompany(long companyId, long parentId)
		throws SystemException {
		for (ContactsDepartment contactsDepartment : findByParentAndCompany(
				companyId, parentId)) {
			remove(contactsDepartment);
		}
	}

	/**
	 * Removes all the contacts departments where groupId = &#63; and parentId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByParentAndGroup(long groupId, long parentId)
		throws SystemException {
		for (ContactsDepartment contactsDepartment : findByParentAndGroup(
				groupId, parentId)) {
			remove(contactsDepartment);
		}
	}

	/**
	 * Removes all the contacts departments where companyId = &#63; and departmentStatus = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param departmentStatus the department status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByStatusAndCompany(long companyId, int departmentStatus)
		throws SystemException {
		for (ContactsDepartment contactsDepartment : findByStatusAndCompany(
				companyId, departmentStatus)) {
			remove(contactsDepartment);
		}
	}

	/**
	 * Removes all the contacts departments where groupId = &#63; and departmentStatus = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param departmentStatus the department status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByStatusAndGroup(long groupId, int departmentStatus)
		throws SystemException {
		for (ContactsDepartment contactsDepartment : findByStatusAndGroup(
				groupId, departmentStatus)) {
			remove(contactsDepartment);
		}
	}

	/**
	 * Removes all the contacts departments from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ContactsDepartment contactsDepartment : findAll()) {
			remove(contactsDepartment);
		}
	}

	/**
	 * Returns the number of contacts departments where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching contacts departments
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompany(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONTACTSDEPARTMENT_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of contacts departments where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching contacts departments
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONTACTSDEPARTMENT_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of contacts departments that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching contacts departments that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroup(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroup(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_CONTACTSDEPARTMENT_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ContactsDepartment.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the number of contacts departments where companyId = &#63; and parentId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @return the number of matching contacts departments
	 * @throws SystemException if a system exception occurred
	 */
	public int countByParentAndCompany(long companyId, long parentId)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, parentId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PARENTANDCOMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTACTSDEPARTMENT_WHERE);

			query.append(_FINDER_COLUMN_PARENTANDCOMPANY_COMPANYID_2);

			query.append(_FINDER_COLUMN_PARENTANDCOMPANY_PARENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(parentId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PARENTANDCOMPANY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of contacts departments where groupId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @return the number of matching contacts departments
	 * @throws SystemException if a system exception occurred
	 */
	public int countByParentAndGroup(long groupId, long parentId)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, parentId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PARENTANDGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTACTSDEPARTMENT_WHERE);

			query.append(_FINDER_COLUMN_PARENTANDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_PARENTANDGROUP_PARENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(parentId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PARENTANDGROUP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of contacts departments that the user has permission to view where groupId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @return the number of matching contacts departments that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByParentAndGroup(long groupId, long parentId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByParentAndGroup(groupId, parentId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_CONTACTSDEPARTMENT_WHERE);

		query.append(_FINDER_COLUMN_PARENTANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_PARENTANDGROUP_PARENTID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ContactsDepartment.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(parentId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the number of contacts departments where companyId = &#63; and departmentStatus = &#63;.
	 *
	 * @param companyId the company ID
	 * @param departmentStatus the department status
	 * @return the number of matching contacts departments
	 * @throws SystemException if a system exception occurred
	 */
	public int countByStatusAndCompany(long companyId, int departmentStatus)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, departmentStatus };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATUSANDCOMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTACTSDEPARTMENT_WHERE);

			query.append(_FINDER_COLUMN_STATUSANDCOMPANY_COMPANYID_2);

			query.append(_FINDER_COLUMN_STATUSANDCOMPANY_DEPARTMENTSTATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(departmentStatus);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATUSANDCOMPANY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of contacts departments where groupId = &#63; and departmentStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param departmentStatus the department status
	 * @return the number of matching contacts departments
	 * @throws SystemException if a system exception occurred
	 */
	public int countByStatusAndGroup(long groupId, int departmentStatus)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, departmentStatus };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATUSANDGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTACTSDEPARTMENT_WHERE);

			query.append(_FINDER_COLUMN_STATUSANDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_STATUSANDGROUP_DEPARTMENTSTATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(departmentStatus);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATUSANDGROUP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of contacts departments that the user has permission to view where groupId = &#63; and departmentStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param departmentStatus the department status
	 * @return the number of matching contacts departments that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByStatusAndGroup(long groupId, int departmentStatus)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByStatusAndGroup(groupId, departmentStatus);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_CONTACTSDEPARTMENT_WHERE);

		query.append(_FINDER_COLUMN_STATUSANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_STATUSANDGROUP_DEPARTMENTSTATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ContactsDepartment.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(departmentStatus);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the number of contacts departments.
	 *
	 * @return the number of contacts departments
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CONTACTSDEPARTMENT);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the contacts department persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.portal_egov.portlet.contacts.model.ContactsDepartment")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ContactsDepartment>> listenersList = new ArrayList<ModelListener<ContactsDepartment>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ContactsDepartment>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(ContactsDepartmentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = ContactsPersistence.class)
	protected ContactsPersistence contactsPersistence;
	@BeanReference(type = ContactsDepartmentPersistence.class)
	protected ContactsDepartmentPersistence contactsDepartmentPersistence;
	@BeanReference(type = ContactsDepartmentPropertyPersistence.class)
	protected ContactsDepartmentPropertyPersistence contactsDepartmentPropertyPersistence;
	@BeanReference(type = ContactsPropertyPersistence.class)
	protected ContactsPropertyPersistence contactsPropertyPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_CONTACTSDEPARTMENT = "SELECT contactsDepartment FROM ContactsDepartment contactsDepartment";
	private static final String _SQL_SELECT_CONTACTSDEPARTMENT_WHERE = "SELECT contactsDepartment FROM ContactsDepartment contactsDepartment WHERE ";
	private static final String _SQL_COUNT_CONTACTSDEPARTMENT = "SELECT COUNT(contactsDepartment) FROM ContactsDepartment contactsDepartment";
	private static final String _SQL_COUNT_CONTACTSDEPARTMENT_WHERE = "SELECT COUNT(contactsDepartment) FROM ContactsDepartment contactsDepartment WHERE ";
	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "contactsDepartment.companyId = ?";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "contactsDepartment.groupId = ?";
	private static final String _FINDER_COLUMN_PARENTANDCOMPANY_COMPANYID_2 = "contactsDepartment.companyId = ? AND ";
	private static final String _FINDER_COLUMN_PARENTANDCOMPANY_PARENTID_2 = "contactsDepartment.parentId = ?";
	private static final String _FINDER_COLUMN_PARENTANDGROUP_GROUPID_2 = "contactsDepartment.groupId = ? AND ";
	private static final String _FINDER_COLUMN_PARENTANDGROUP_PARENTID_2 = "contactsDepartment.parentId = ?";
	private static final String _FINDER_COLUMN_STATUSANDCOMPANY_COMPANYID_2 = "contactsDepartment.companyId = ? AND ";
	private static final String _FINDER_COLUMN_STATUSANDCOMPANY_DEPARTMENTSTATUS_2 =
		"contactsDepartment.departmentStatus = ?";
	private static final String _FINDER_COLUMN_STATUSANDGROUP_GROUPID_2 = "contactsDepartment.groupId = ? AND ";
	private static final String _FINDER_COLUMN_STATUSANDGROUP_DEPARTMENTSTATUS_2 =
		"contactsDepartment.departmentStatus = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "contactsDepartment.departmentId";
	private static final String _FILTER_SQL_SELECT_CONTACTSDEPARTMENT_WHERE = "SELECT DISTINCT {contactsDepartment.*} FROM ContactsDepartment contactsDepartment WHERE ";
	private static final String _FILTER_SQL_SELECT_CONTACTSDEPARTMENT_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {ContactsDepartment.*} FROM (SELECT DISTINCT contactsDepartment.departmentId FROM ContactsDepartment contactsDepartment WHERE ";
	private static final String _FILTER_SQL_SELECT_CONTACTSDEPARTMENT_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN ContactsDepartment ON TEMP_TABLE.departmentId = ContactsDepartment.departmentId";
	private static final String _FILTER_SQL_COUNT_CONTACTSDEPARTMENT_WHERE = "SELECT COUNT(DISTINCT contactsDepartment.departmentId) AS COUNT_VALUE FROM ContactsDepartment contactsDepartment WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "contactsDepartment";
	private static final String _FILTER_ENTITY_TABLE = "ContactsDepartment";
	private static final String _ORDER_BY_ENTITY_ALIAS = "contactsDepartment.";
	private static final String _ORDER_BY_ENTITY_TABLE = "ContactsDepartment.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ContactsDepartment exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ContactsDepartment exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ContactsDepartmentPersistenceImpl.class);
	private static ContactsDepartment _nullContactsDepartment = new ContactsDepartmentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ContactsDepartment> toCacheModel() {
				return _nullContactsDepartmentCacheModel;
			}
		};

	private static CacheModel<ContactsDepartment> _nullContactsDepartmentCacheModel =
		new CacheModel<ContactsDepartment>() {
			public ContactsDepartment toEntityModel() {
				return _nullContactsDepartment;
			}
		};
}