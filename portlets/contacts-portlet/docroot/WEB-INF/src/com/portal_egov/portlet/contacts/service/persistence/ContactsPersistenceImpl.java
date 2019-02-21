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

import com.portal_egov.portlet.contacts.NoSuchContactsException;
import com.portal_egov.portlet.contacts.model.Contacts;
import com.portal_egov.portlet.contacts.model.impl.ContactsImpl;
import com.portal_egov.portlet.contacts.model.impl.ContactsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the contacts service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see ContactsPersistence
 * @see ContactsUtil
 * @generated
 */
public class ContactsPersistenceImpl extends BasePersistenceImpl<Contacts>
	implements ContactsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ContactsUtil} to access the contacts persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ContactsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(ContactsModelImpl.ENTITY_CACHE_ENABLED,
			ContactsModelImpl.FINDER_CACHE_ENABLED, ContactsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(ContactsModelImpl.ENTITY_CACHE_ENABLED,
			ContactsModelImpl.FINDER_CACHE_ENABLED, ContactsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			ContactsModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(ContactsModelImpl.ENTITY_CACHE_ENABLED,
			ContactsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(ContactsModelImpl.ENTITY_CACHE_ENABLED,
			ContactsModelImpl.FINDER_CACHE_ENABLED, ContactsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(ContactsModelImpl.ENTITY_CACHE_ENABLED,
			ContactsModelImpl.FINDER_CACHE_ENABLED, ContactsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			ContactsModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(ContactsModelImpl.ENTITY_CACHE_ENABLED,
			ContactsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYANDSTATUS =
		new FinderPath(ContactsModelImpl.ENTITY_CACHE_ENABLED,
			ContactsModelImpl.FINDER_CACHE_ENABLED, ContactsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyAndStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYANDSTATUS =
		new FinderPath(ContactsModelImpl.ENTITY_CACHE_ENABLED,
			ContactsModelImpl.FINDER_CACHE_ENABLED, ContactsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCompanyAndStatus",
			new String[] { Long.class.getName(), Integer.class.getName() },
			ContactsModelImpl.COMPANYID_COLUMN_BITMASK |
			ContactsModelImpl.CONTACTSTATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYANDSTATUS = new FinderPath(ContactsModelImpl.ENTITY_CACHE_ENABLED,
			ContactsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCompanyAndStatus",
			new String[] { Long.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPANDSTATUS =
		new FinderPath(ContactsModelImpl.ENTITY_CACHE_ENABLED,
			ContactsModelImpl.FINDER_CACHE_ENABLED, ContactsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupAndStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDSTATUS =
		new FinderPath(ContactsModelImpl.ENTITY_CACHE_ENABLED,
			ContactsModelImpl.FINDER_CACHE_ENABLED, ContactsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupAndStatus",
			new String[] { Long.class.getName(), Integer.class.getName() },
			ContactsModelImpl.GROUPID_COLUMN_BITMASK |
			ContactsModelImpl.CONTACTSTATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPANDSTATUS = new FinderPath(ContactsModelImpl.ENTITY_CACHE_ENABLED,
			ContactsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupAndStatus",
			new String[] { Long.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPARTMENTANDCOMPANY =
		new FinderPath(ContactsModelImpl.ENTITY_CACHE_ENABLED,
			ContactsModelImpl.FINDER_CACHE_ENABLED, ContactsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDepartmentAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTANDCOMPANY =
		new FinderPath(ContactsModelImpl.ENTITY_CACHE_ENABLED,
			ContactsModelImpl.FINDER_CACHE_ENABLED, ContactsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDepartmentAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() },
			ContactsModelImpl.COMPANYID_COLUMN_BITMASK |
			ContactsModelImpl.DEPARTMENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DEPARTMENTANDCOMPANY = new FinderPath(ContactsModelImpl.ENTITY_CACHE_ENABLED,
			ContactsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDepartmentAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPARTMENTANDGROUP =
		new FinderPath(ContactsModelImpl.ENTITY_CACHE_ENABLED,
			ContactsModelImpl.FINDER_CACHE_ENABLED, ContactsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDepartmentAndGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTANDGROUP =
		new FinderPath(ContactsModelImpl.ENTITY_CACHE_ENABLED,
			ContactsModelImpl.FINDER_CACHE_ENABLED, ContactsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDepartmentAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			ContactsModelImpl.GROUPID_COLUMN_BITMASK |
			ContactsModelImpl.DEPARTMENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DEPARTMENTANDGROUP = new FinderPath(ContactsModelImpl.ENTITY_CACHE_ENABLED,
			ContactsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDepartmentAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYANDDEPARTMENTANDSTATUS =
		new FinderPath(ContactsModelImpl.ENTITY_CACHE_ENABLED,
			ContactsModelImpl.FINDER_CACHE_ENABLED, ContactsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompanyAndDepartmentAndStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYANDDEPARTMENTANDSTATUS =
		new FinderPath(ContactsModelImpl.ENTITY_CACHE_ENABLED,
			ContactsModelImpl.FINDER_CACHE_ENABLED, ContactsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCompanyAndDepartmentAndStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			ContactsModelImpl.COMPANYID_COLUMN_BITMASK |
			ContactsModelImpl.DEPARTMENTID_COLUMN_BITMASK |
			ContactsModelImpl.CONTACTSTATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYANDDEPARTMENTANDSTATUS =
		new FinderPath(ContactsModelImpl.ENTITY_CACHE_ENABLED,
			ContactsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCompanyAndDepartmentAndStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPANDDEPARTMENTANDSTATUS =
		new FinderPath(ContactsModelImpl.ENTITY_CACHE_ENABLED,
			ContactsModelImpl.FINDER_CACHE_ENABLED, ContactsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupAndDepartmentAndStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDDEPARTMENTANDSTATUS =
		new FinderPath(ContactsModelImpl.ENTITY_CACHE_ENABLED,
			ContactsModelImpl.FINDER_CACHE_ENABLED, ContactsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupAndDepartmentAndStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			ContactsModelImpl.GROUPID_COLUMN_BITMASK |
			ContactsModelImpl.DEPARTMENTID_COLUMN_BITMASK |
			ContactsModelImpl.CONTACTSTATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPANDDEPARTMENTANDSTATUS =
		new FinderPath(ContactsModelImpl.ENTITY_CACHE_ENABLED,
			ContactsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupAndDepartmentAndStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ContactsModelImpl.ENTITY_CACHE_ENABLED,
			ContactsModelImpl.FINDER_CACHE_ENABLED, ContactsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ContactsModelImpl.ENTITY_CACHE_ENABLED,
			ContactsModelImpl.FINDER_CACHE_ENABLED, ContactsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ContactsModelImpl.ENTITY_CACHE_ENABLED,
			ContactsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the contacts in the entity cache if it is enabled.
	 *
	 * @param contacts the contacts
	 */
	public void cacheResult(Contacts contacts) {
		EntityCacheUtil.putResult(ContactsModelImpl.ENTITY_CACHE_ENABLED,
			ContactsImpl.class, contacts.getPrimaryKey(), contacts);

		contacts.resetOriginalValues();
	}

	/**
	 * Caches the contactses in the entity cache if it is enabled.
	 *
	 * @param contactses the contactses
	 */
	public void cacheResult(List<Contacts> contactses) {
		for (Contacts contacts : contactses) {
			if (EntityCacheUtil.getResult(
						ContactsModelImpl.ENTITY_CACHE_ENABLED,
						ContactsImpl.class, contacts.getPrimaryKey()) == null) {
				cacheResult(contacts);
			}
			else {
				contacts.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all contactses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ContactsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ContactsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the contacts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Contacts contacts) {
		EntityCacheUtil.removeResult(ContactsModelImpl.ENTITY_CACHE_ENABLED,
			ContactsImpl.class, contacts.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Contacts> contactses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Contacts contacts : contactses) {
			EntityCacheUtil.removeResult(ContactsModelImpl.ENTITY_CACHE_ENABLED,
				ContactsImpl.class, contacts.getPrimaryKey());
		}
	}

	/**
	 * Creates a new contacts with the primary key. Does not add the contacts to the database.
	 *
	 * @param contactId the primary key for the new contacts
	 * @return the new contacts
	 */
	public Contacts create(long contactId) {
		Contacts contacts = new ContactsImpl();

		contacts.setNew(true);
		contacts.setPrimaryKey(contactId);

		return contacts;
	}

	/**
	 * Removes the contacts with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contactId the primary key of the contacts
	 * @return the contacts that was removed
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a contacts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts remove(long contactId)
		throws NoSuchContactsException, SystemException {
		return remove(Long.valueOf(contactId));
	}

	/**
	 * Removes the contacts with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the contacts
	 * @return the contacts that was removed
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a contacts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contacts remove(Serializable primaryKey)
		throws NoSuchContactsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Contacts contacts = (Contacts)session.get(ContactsImpl.class,
					primaryKey);

			if (contacts == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchContactsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(contacts);
		}
		catch (NoSuchContactsException nsee) {
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
	protected Contacts removeImpl(Contacts contacts) throws SystemException {
		contacts = toUnwrappedModel(contacts);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, contacts);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(contacts);

		return contacts;
	}

	@Override
	public Contacts updateImpl(
		com.portal_egov.portlet.contacts.model.Contacts contacts, boolean merge)
		throws SystemException {
		contacts = toUnwrappedModel(contacts);

		boolean isNew = contacts.isNew();

		ContactsModelImpl contactsModelImpl = (ContactsModelImpl)contacts;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, contacts, merge);

			contacts.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ContactsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((contactsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(contactsModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] {
						Long.valueOf(contactsModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((contactsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(contactsModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] { Long.valueOf(contactsModelImpl.getGroupId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}

			if ((contactsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYANDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(contactsModelImpl.getOriginalCompanyId()),
						Integer.valueOf(contactsModelImpl.getOriginalContactStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYANDSTATUS,
					args);

				args = new Object[] {
						Long.valueOf(contactsModelImpl.getCompanyId()),
						Integer.valueOf(contactsModelImpl.getContactStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYANDSTATUS,
					args);
			}

			if ((contactsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(contactsModelImpl.getOriginalGroupId()),
						Integer.valueOf(contactsModelImpl.getOriginalContactStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDSTATUS,
					args);

				args = new Object[] {
						Long.valueOf(contactsModelImpl.getGroupId()),
						Integer.valueOf(contactsModelImpl.getContactStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDSTATUS,
					args);
			}

			if ((contactsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTANDCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(contactsModelImpl.getOriginalCompanyId()),
						Long.valueOf(contactsModelImpl.getOriginalDepartmentId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPARTMENTANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTANDCOMPANY,
					args);

				args = new Object[] {
						Long.valueOf(contactsModelImpl.getCompanyId()),
						Long.valueOf(contactsModelImpl.getDepartmentId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPARTMENTANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTANDCOMPANY,
					args);
			}

			if ((contactsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTANDGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(contactsModelImpl.getOriginalGroupId()),
						Long.valueOf(contactsModelImpl.getOriginalDepartmentId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPARTMENTANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTANDGROUP,
					args);

				args = new Object[] {
						Long.valueOf(contactsModelImpl.getGroupId()),
						Long.valueOf(contactsModelImpl.getDepartmentId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPARTMENTANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTANDGROUP,
					args);
			}

			if ((contactsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYANDDEPARTMENTANDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(contactsModelImpl.getOriginalCompanyId()),
						Long.valueOf(contactsModelImpl.getOriginalDepartmentId()),
						Integer.valueOf(contactsModelImpl.getOriginalContactStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYANDDEPARTMENTANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYANDDEPARTMENTANDSTATUS,
					args);

				args = new Object[] {
						Long.valueOf(contactsModelImpl.getCompanyId()),
						Long.valueOf(contactsModelImpl.getDepartmentId()),
						Integer.valueOf(contactsModelImpl.getContactStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYANDDEPARTMENTANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYANDDEPARTMENTANDSTATUS,
					args);
			}

			if ((contactsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDDEPARTMENTANDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(contactsModelImpl.getOriginalGroupId()),
						Long.valueOf(contactsModelImpl.getOriginalDepartmentId()),
						Integer.valueOf(contactsModelImpl.getOriginalContactStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPANDDEPARTMENTANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDDEPARTMENTANDSTATUS,
					args);

				args = new Object[] {
						Long.valueOf(contactsModelImpl.getGroupId()),
						Long.valueOf(contactsModelImpl.getDepartmentId()),
						Integer.valueOf(contactsModelImpl.getContactStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPANDDEPARTMENTANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDDEPARTMENTANDSTATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(ContactsModelImpl.ENTITY_CACHE_ENABLED,
			ContactsImpl.class, contacts.getPrimaryKey(), contacts);

		return contacts;
	}

	protected Contacts toUnwrappedModel(Contacts contacts) {
		if (contacts instanceof ContactsImpl) {
			return contacts;
		}

		ContactsImpl contactsImpl = new ContactsImpl();

		contactsImpl.setNew(contacts.isNew());
		contactsImpl.setPrimaryKey(contacts.getPrimaryKey());

		contactsImpl.setContactId(contacts.getContactId());
		contactsImpl.setGroupId(contacts.getGroupId());
		contactsImpl.setCompanyId(contacts.getCompanyId());
		contactsImpl.setUserId(contacts.getUserId());
		contactsImpl.setUserName(contacts.getUserName());
		contactsImpl.setCreateDate(contacts.getCreateDate());
		contactsImpl.setModifiedDate(contacts.getModifiedDate());
		contactsImpl.setDepartmentId(contacts.getDepartmentId());
		contactsImpl.setImageId(contacts.getImageId());
		contactsImpl.setContactName(contacts.getContactName());
		contactsImpl.setJobTitle(contacts.getJobTitle());
		contactsImpl.setPhoneNumbers(contacts.getPhoneNumbers());
		contactsImpl.setHomePhone(contacts.getHomePhone());
		contactsImpl.setMobile(contacts.getMobile());
		contactsImpl.setEmail(contacts.getEmail());
		contactsImpl.setDisplayPriority(contacts.getDisplayPriority());
		contactsImpl.setContactStatus(contacts.getContactStatus());

		return contactsImpl;
	}

	/**
	 * Returns the contacts with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the contacts
	 * @return the contacts
	 * @throws com.liferay.portal.NoSuchModelException if a contacts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contacts findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the contacts with the primary key or throws a {@link com.portal_egov.portlet.contacts.NoSuchContactsException} if it could not be found.
	 *
	 * @param contactId the primary key of the contacts
	 * @return the contacts
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a contacts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts findByPrimaryKey(long contactId)
		throws NoSuchContactsException, SystemException {
		Contacts contacts = fetchByPrimaryKey(contactId);

		if (contacts == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + contactId);
			}

			throw new NoSuchContactsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				contactId);
		}

		return contacts;
	}

	/**
	 * Returns the contacts with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the contacts
	 * @return the contacts, or <code>null</code> if a contacts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contacts fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the contacts with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contactId the primary key of the contacts
	 * @return the contacts, or <code>null</code> if a contacts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts fetchByPrimaryKey(long contactId) throws SystemException {
		Contacts contacts = (Contacts)EntityCacheUtil.getResult(ContactsModelImpl.ENTITY_CACHE_ENABLED,
				ContactsImpl.class, contactId);

		if (contacts == _nullContacts) {
			return null;
		}

		if (contacts == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				contacts = (Contacts)session.get(ContactsImpl.class,
						Long.valueOf(contactId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (contacts != null) {
					cacheResult(contacts);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ContactsModelImpl.ENTITY_CACHE_ENABLED,
						ContactsImpl.class, contactId, _nullContacts);
				}

				closeSession(session);
			}
		}

		return contacts;
	}

	/**
	 * Returns all the contactses where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching contactses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contacts> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the contactses where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of contactses
	 * @param end the upper bound of the range of contactses (not inclusive)
	 * @return the range of matching contactses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contacts> findByCompany(long companyId, int start, int end)
		throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contactses where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of contactses
	 * @param end the upper bound of the range of contactses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contactses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contacts> findByCompany(long companyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<Contacts> list = (List<Contacts>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Contacts contacts : list) {
				if ((companyId != contacts.getCompanyId())) {
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

			query.append(_SQL_SELECT_CONTACTS_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ContactsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<Contacts>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first contacts in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a matching contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchContactsException, SystemException {
		Contacts contacts = fetchByCompany_First(companyId, orderByComparator);

		if (contacts != null) {
			return contacts;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsException(msg.toString());
	}

	/**
	 * Returns the first contacts in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts, or <code>null</code> if a matching contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Contacts> list = findByCompany(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contacts in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a matching contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchContactsException, SystemException {
		Contacts contacts = fetchByCompany_Last(companyId, orderByComparator);

		if (contacts != null) {
			return contacts;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsException(msg.toString());
	}

	/**
	 * Returns the last contacts in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts, or <code>null</code> if a matching contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		List<Contacts> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contactses before and after the current contacts in the ordered set where companyId = &#63;.
	 *
	 * @param contactId the primary key of the current contacts
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contacts
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a contacts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts[] findByCompany_PrevAndNext(long contactId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchContactsException, SystemException {
		Contacts contacts = findByPrimaryKey(contactId);

		Session session = null;

		try {
			session = openSession();

			Contacts[] array = new ContactsImpl[3];

			array[0] = getByCompany_PrevAndNext(session, contacts, companyId,
					orderByComparator, true);

			array[1] = contacts;

			array[2] = getByCompany_PrevAndNext(session, contacts, companyId,
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

	protected Contacts getByCompany_PrevAndNext(Session session,
		Contacts contacts, long companyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTS_WHERE);

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
			query.append(ContactsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contacts);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Contacts> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the contactses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching contactses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contacts> findByGroup(long groupId) throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contactses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of contactses
	 * @param end the upper bound of the range of contactses (not inclusive)
	 * @return the range of matching contactses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contacts> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contactses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of contactses
	 * @param end the upper bound of the range of contactses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contactses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contacts> findByGroup(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<Contacts> list = (List<Contacts>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Contacts contacts : list) {
				if ((groupId != contacts.getGroupId())) {
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

			query.append(_SQL_SELECT_CONTACTS_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ContactsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<Contacts>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first contacts in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a matching contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchContactsException, SystemException {
		Contacts contacts = fetchByGroup_First(groupId, orderByComparator);

		if (contacts != null) {
			return contacts;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsException(msg.toString());
	}

	/**
	 * Returns the first contacts in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts, or <code>null</code> if a matching contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Contacts> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contacts in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a matching contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchContactsException, SystemException {
		Contacts contacts = fetchByGroup_Last(groupId, orderByComparator);

		if (contacts != null) {
			return contacts;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsException(msg.toString());
	}

	/**
	 * Returns the last contacts in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts, or <code>null</code> if a matching contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<Contacts> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contactses before and after the current contacts in the ordered set where groupId = &#63;.
	 *
	 * @param contactId the primary key of the current contacts
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contacts
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a contacts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts[] findByGroup_PrevAndNext(long contactId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchContactsException, SystemException {
		Contacts contacts = findByPrimaryKey(contactId);

		Session session = null;

		try {
			session = openSession();

			Contacts[] array = new ContactsImpl[3];

			array[0] = getByGroup_PrevAndNext(session, contacts, groupId,
					orderByComparator, true);

			array[1] = contacts;

			array[2] = getByGroup_PrevAndNext(session, contacts, groupId,
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

	protected Contacts getByGroup_PrevAndNext(Session session,
		Contacts contacts, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTS_WHERE);

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
			query.append(ContactsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contacts);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Contacts> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the contactses that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching contactses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contacts> filterFindByGroup(long groupId)
		throws SystemException {
		return filterFindByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the contactses that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of contactses
	 * @param end the upper bound of the range of contactses (not inclusive)
	 * @return the range of matching contactses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contacts> filterFindByGroup(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contactses that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of contactses
	 * @param end the upper bound of the range of contactses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contactses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contacts> filterFindByGroup(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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
			query.append(_FILTER_SQL_SELECT_CONTACTS_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTACTS_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CONTACTS_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ContactsModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ContactsModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Contacts.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, ContactsImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, ContactsImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<Contacts>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the contactses before and after the current contacts in the ordered set of contactses that the user has permission to view where groupId = &#63;.
	 *
	 * @param contactId the primary key of the current contacts
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contacts
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a contacts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts[] filterFindByGroup_PrevAndNext(long contactId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchContactsException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup_PrevAndNext(contactId, groupId, orderByComparator);
		}

		Contacts contacts = findByPrimaryKey(contactId);

		Session session = null;

		try {
			session = openSession();

			Contacts[] array = new ContactsImpl[3];

			array[0] = filterGetByGroup_PrevAndNext(session, contacts, groupId,
					orderByComparator, true);

			array[1] = contacts;

			array[2] = filterGetByGroup_PrevAndNext(session, contacts, groupId,
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

	protected Contacts filterGetByGroup_PrevAndNext(Session session,
		Contacts contacts, long groupId, OrderByComparator orderByComparator,
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
			query.append(_FILTER_SQL_SELECT_CONTACTS_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTACTS_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CONTACTS_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ContactsModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ContactsModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Contacts.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, ContactsImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, ContactsImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contacts);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Contacts> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the contactses where companyId = &#63; and contactStatus = &#63;.
	 *
	 * @param companyId the company ID
	 * @param contactStatus the contact status
	 * @return the matching contactses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contacts> findByCompanyAndStatus(long companyId,
		int contactStatus) throws SystemException {
		return findByCompanyAndStatus(companyId, contactStatus,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contactses where companyId = &#63; and contactStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param contactStatus the contact status
	 * @param start the lower bound of the range of contactses
	 * @param end the upper bound of the range of contactses (not inclusive)
	 * @return the range of matching contactses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contacts> findByCompanyAndStatus(long companyId,
		int contactStatus, int start, int end) throws SystemException {
		return findByCompanyAndStatus(companyId, contactStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contactses where companyId = &#63; and contactStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param contactStatus the contact status
	 * @param start the lower bound of the range of contactses
	 * @param end the upper bound of the range of contactses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contactses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contacts> findByCompanyAndStatus(long companyId,
		int contactStatus, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYANDSTATUS;
			finderArgs = new Object[] { companyId, contactStatus };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYANDSTATUS;
			finderArgs = new Object[] {
					companyId, contactStatus,
					
					start, end, orderByComparator
				};
		}

		List<Contacts> list = (List<Contacts>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Contacts contacts : list) {
				if ((companyId != contacts.getCompanyId()) ||
						(contactStatus != contacts.getContactStatus())) {
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

			query.append(_SQL_SELECT_CONTACTS_WHERE);

			query.append(_FINDER_COLUMN_COMPANYANDSTATUS_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYANDSTATUS_CONTACTSTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ContactsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(contactStatus);

				list = (List<Contacts>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first contacts in the ordered set where companyId = &#63; and contactStatus = &#63;.
	 *
	 * @param companyId the company ID
	 * @param contactStatus the contact status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a matching contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts findByCompanyAndStatus_First(long companyId,
		int contactStatus, OrderByComparator orderByComparator)
		throws NoSuchContactsException, SystemException {
		Contacts contacts = fetchByCompanyAndStatus_First(companyId,
				contactStatus, orderByComparator);

		if (contacts != null) {
			return contacts;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", contactStatus=");
		msg.append(contactStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsException(msg.toString());
	}

	/**
	 * Returns the first contacts in the ordered set where companyId = &#63; and contactStatus = &#63;.
	 *
	 * @param companyId the company ID
	 * @param contactStatus the contact status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts, or <code>null</code> if a matching contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts fetchByCompanyAndStatus_First(long companyId,
		int contactStatus, OrderByComparator orderByComparator)
		throws SystemException {
		List<Contacts> list = findByCompanyAndStatus(companyId, contactStatus,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contacts in the ordered set where companyId = &#63; and contactStatus = &#63;.
	 *
	 * @param companyId the company ID
	 * @param contactStatus the contact status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a matching contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts findByCompanyAndStatus_Last(long companyId,
		int contactStatus, OrderByComparator orderByComparator)
		throws NoSuchContactsException, SystemException {
		Contacts contacts = fetchByCompanyAndStatus_Last(companyId,
				contactStatus, orderByComparator);

		if (contacts != null) {
			return contacts;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", contactStatus=");
		msg.append(contactStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsException(msg.toString());
	}

	/**
	 * Returns the last contacts in the ordered set where companyId = &#63; and contactStatus = &#63;.
	 *
	 * @param companyId the company ID
	 * @param contactStatus the contact status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts, or <code>null</code> if a matching contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts fetchByCompanyAndStatus_Last(long companyId,
		int contactStatus, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCompanyAndStatus(companyId, contactStatus);

		List<Contacts> list = findByCompanyAndStatus(companyId, contactStatus,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contactses before and after the current contacts in the ordered set where companyId = &#63; and contactStatus = &#63;.
	 *
	 * @param contactId the primary key of the current contacts
	 * @param companyId the company ID
	 * @param contactStatus the contact status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contacts
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a contacts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts[] findByCompanyAndStatus_PrevAndNext(long contactId,
		long companyId, int contactStatus, OrderByComparator orderByComparator)
		throws NoSuchContactsException, SystemException {
		Contacts contacts = findByPrimaryKey(contactId);

		Session session = null;

		try {
			session = openSession();

			Contacts[] array = new ContactsImpl[3];

			array[0] = getByCompanyAndStatus_PrevAndNext(session, contacts,
					companyId, contactStatus, orderByComparator, true);

			array[1] = contacts;

			array[2] = getByCompanyAndStatus_PrevAndNext(session, contacts,
					companyId, contactStatus, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Contacts getByCompanyAndStatus_PrevAndNext(Session session,
		Contacts contacts, long companyId, int contactStatus,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTS_WHERE);

		query.append(_FINDER_COLUMN_COMPANYANDSTATUS_COMPANYID_2);

		query.append(_FINDER_COLUMN_COMPANYANDSTATUS_CONTACTSTATUS_2);

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
			query.append(ContactsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(contactStatus);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contacts);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Contacts> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the contactses where groupId = &#63; and contactStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contactStatus the contact status
	 * @return the matching contactses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contacts> findByGroupAndStatus(long groupId, int contactStatus)
		throws SystemException {
		return findByGroupAndStatus(groupId, contactStatus, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contactses where groupId = &#63; and contactStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param contactStatus the contact status
	 * @param start the lower bound of the range of contactses
	 * @param end the upper bound of the range of contactses (not inclusive)
	 * @return the range of matching contactses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contacts> findByGroupAndStatus(long groupId, int contactStatus,
		int start, int end) throws SystemException {
		return findByGroupAndStatus(groupId, contactStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contactses where groupId = &#63; and contactStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param contactStatus the contact status
	 * @param start the lower bound of the range of contactses
	 * @param end the upper bound of the range of contactses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contactses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contacts> findByGroupAndStatus(long groupId, int contactStatus,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDSTATUS;
			finderArgs = new Object[] { groupId, contactStatus };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPANDSTATUS;
			finderArgs = new Object[] {
					groupId, contactStatus,
					
					start, end, orderByComparator
				};
		}

		List<Contacts> list = (List<Contacts>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Contacts contacts : list) {
				if ((groupId != contacts.getGroupId()) ||
						(contactStatus != contacts.getContactStatus())) {
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

			query.append(_SQL_SELECT_CONTACTS_WHERE);

			query.append(_FINDER_COLUMN_GROUPANDSTATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPANDSTATUS_CONTACTSTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ContactsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(contactStatus);

				list = (List<Contacts>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first contacts in the ordered set where groupId = &#63; and contactStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contactStatus the contact status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a matching contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts findByGroupAndStatus_First(long groupId, int contactStatus,
		OrderByComparator orderByComparator)
		throws NoSuchContactsException, SystemException {
		Contacts contacts = fetchByGroupAndStatus_First(groupId, contactStatus,
				orderByComparator);

		if (contacts != null) {
			return contacts;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", contactStatus=");
		msg.append(contactStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsException(msg.toString());
	}

	/**
	 * Returns the first contacts in the ordered set where groupId = &#63; and contactStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contactStatus the contact status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts, or <code>null</code> if a matching contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts fetchByGroupAndStatus_First(long groupId,
		int contactStatus, OrderByComparator orderByComparator)
		throws SystemException {
		List<Contacts> list = findByGroupAndStatus(groupId, contactStatus, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contacts in the ordered set where groupId = &#63; and contactStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contactStatus the contact status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a matching contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts findByGroupAndStatus_Last(long groupId, int contactStatus,
		OrderByComparator orderByComparator)
		throws NoSuchContactsException, SystemException {
		Contacts contacts = fetchByGroupAndStatus_Last(groupId, contactStatus,
				orderByComparator);

		if (contacts != null) {
			return contacts;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", contactStatus=");
		msg.append(contactStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsException(msg.toString());
	}

	/**
	 * Returns the last contacts in the ordered set where groupId = &#63; and contactStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contactStatus the contact status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts, or <code>null</code> if a matching contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts fetchByGroupAndStatus_Last(long groupId, int contactStatus,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupAndStatus(groupId, contactStatus);

		List<Contacts> list = findByGroupAndStatus(groupId, contactStatus,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contactses before and after the current contacts in the ordered set where groupId = &#63; and contactStatus = &#63;.
	 *
	 * @param contactId the primary key of the current contacts
	 * @param groupId the group ID
	 * @param contactStatus the contact status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contacts
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a contacts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts[] findByGroupAndStatus_PrevAndNext(long contactId,
		long groupId, int contactStatus, OrderByComparator orderByComparator)
		throws NoSuchContactsException, SystemException {
		Contacts contacts = findByPrimaryKey(contactId);

		Session session = null;

		try {
			session = openSession();

			Contacts[] array = new ContactsImpl[3];

			array[0] = getByGroupAndStatus_PrevAndNext(session, contacts,
					groupId, contactStatus, orderByComparator, true);

			array[1] = contacts;

			array[2] = getByGroupAndStatus_PrevAndNext(session, contacts,
					groupId, contactStatus, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Contacts getByGroupAndStatus_PrevAndNext(Session session,
		Contacts contacts, long groupId, int contactStatus,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTS_WHERE);

		query.append(_FINDER_COLUMN_GROUPANDSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPANDSTATUS_CONTACTSTATUS_2);

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
			query.append(ContactsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(contactStatus);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contacts);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Contacts> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the contactses that the user has permission to view where groupId = &#63; and contactStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contactStatus the contact status
	 * @return the matching contactses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contacts> filterFindByGroupAndStatus(long groupId,
		int contactStatus) throws SystemException {
		return filterFindByGroupAndStatus(groupId, contactStatus,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contactses that the user has permission to view where groupId = &#63; and contactStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param contactStatus the contact status
	 * @param start the lower bound of the range of contactses
	 * @param end the upper bound of the range of contactses (not inclusive)
	 * @return the range of matching contactses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contacts> filterFindByGroupAndStatus(long groupId,
		int contactStatus, int start, int end) throws SystemException {
		return filterFindByGroupAndStatus(groupId, contactStatus, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the contactses that the user has permissions to view where groupId = &#63; and contactStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param contactStatus the contact status
	 * @param start the lower bound of the range of contactses
	 * @param end the upper bound of the range of contactses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contactses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contacts> filterFindByGroupAndStatus(long groupId,
		int contactStatus, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupAndStatus(groupId, contactStatus, start, end,
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
			query.append(_FILTER_SQL_SELECT_CONTACTS_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTACTS_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPANDSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPANDSTATUS_CONTACTSTATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CONTACTS_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ContactsModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ContactsModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Contacts.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, ContactsImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, ContactsImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(contactStatus);

			return (List<Contacts>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the contactses before and after the current contacts in the ordered set of contactses that the user has permission to view where groupId = &#63; and contactStatus = &#63;.
	 *
	 * @param contactId the primary key of the current contacts
	 * @param groupId the group ID
	 * @param contactStatus the contact status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contacts
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a contacts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts[] filterFindByGroupAndStatus_PrevAndNext(long contactId,
		long groupId, int contactStatus, OrderByComparator orderByComparator)
		throws NoSuchContactsException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupAndStatus_PrevAndNext(contactId, groupId,
				contactStatus, orderByComparator);
		}

		Contacts contacts = findByPrimaryKey(contactId);

		Session session = null;

		try {
			session = openSession();

			Contacts[] array = new ContactsImpl[3];

			array[0] = filterGetByGroupAndStatus_PrevAndNext(session, contacts,
					groupId, contactStatus, orderByComparator, true);

			array[1] = contacts;

			array[2] = filterGetByGroupAndStatus_PrevAndNext(session, contacts,
					groupId, contactStatus, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Contacts filterGetByGroupAndStatus_PrevAndNext(Session session,
		Contacts contacts, long groupId, int contactStatus,
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
			query.append(_FILTER_SQL_SELECT_CONTACTS_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTACTS_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPANDSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPANDSTATUS_CONTACTSTATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CONTACTS_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ContactsModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ContactsModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Contacts.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, ContactsImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, ContactsImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(contactStatus);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contacts);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Contacts> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the contactses where companyId = &#63; and departmentId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param departmentId the department ID
	 * @return the matching contactses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contacts> findByDepartmentAndCompany(long companyId,
		long departmentId) throws SystemException {
		return findByDepartmentAndCompany(companyId, departmentId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contactses where companyId = &#63; and departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of contactses
	 * @param end the upper bound of the range of contactses (not inclusive)
	 * @return the range of matching contactses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contacts> findByDepartmentAndCompany(long companyId,
		long departmentId, int start, int end) throws SystemException {
		return findByDepartmentAndCompany(companyId, departmentId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the contactses where companyId = &#63; and departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of contactses
	 * @param end the upper bound of the range of contactses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contactses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contacts> findByDepartmentAndCompany(long companyId,
		long departmentId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTANDCOMPANY;
			finderArgs = new Object[] { companyId, departmentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPARTMENTANDCOMPANY;
			finderArgs = new Object[] {
					companyId, departmentId,
					
					start, end, orderByComparator
				};
		}

		List<Contacts> list = (List<Contacts>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Contacts contacts : list) {
				if ((companyId != contacts.getCompanyId()) ||
						(departmentId != contacts.getDepartmentId())) {
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

			query.append(_SQL_SELECT_CONTACTS_WHERE);

			query.append(_FINDER_COLUMN_DEPARTMENTANDCOMPANY_COMPANYID_2);

			query.append(_FINDER_COLUMN_DEPARTMENTANDCOMPANY_DEPARTMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ContactsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(departmentId);

				list = (List<Contacts>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first contacts in the ordered set where companyId = &#63; and departmentId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a matching contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts findByDepartmentAndCompany_First(long companyId,
		long departmentId, OrderByComparator orderByComparator)
		throws NoSuchContactsException, SystemException {
		Contacts contacts = fetchByDepartmentAndCompany_First(companyId,
				departmentId, orderByComparator);

		if (contacts != null) {
			return contacts;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", departmentId=");
		msg.append(departmentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsException(msg.toString());
	}

	/**
	 * Returns the first contacts in the ordered set where companyId = &#63; and departmentId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts, or <code>null</code> if a matching contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts fetchByDepartmentAndCompany_First(long companyId,
		long departmentId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Contacts> list = findByDepartmentAndCompany(companyId,
				departmentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contacts in the ordered set where companyId = &#63; and departmentId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a matching contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts findByDepartmentAndCompany_Last(long companyId,
		long departmentId, OrderByComparator orderByComparator)
		throws NoSuchContactsException, SystemException {
		Contacts contacts = fetchByDepartmentAndCompany_Last(companyId,
				departmentId, orderByComparator);

		if (contacts != null) {
			return contacts;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", departmentId=");
		msg.append(departmentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsException(msg.toString());
	}

	/**
	 * Returns the last contacts in the ordered set where companyId = &#63; and departmentId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts, or <code>null</code> if a matching contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts fetchByDepartmentAndCompany_Last(long companyId,
		long departmentId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByDepartmentAndCompany(companyId, departmentId);

		List<Contacts> list = findByDepartmentAndCompany(companyId,
				departmentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contactses before and after the current contacts in the ordered set where companyId = &#63; and departmentId = &#63;.
	 *
	 * @param contactId the primary key of the current contacts
	 * @param companyId the company ID
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contacts
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a contacts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts[] findByDepartmentAndCompany_PrevAndNext(long contactId,
		long companyId, long departmentId, OrderByComparator orderByComparator)
		throws NoSuchContactsException, SystemException {
		Contacts contacts = findByPrimaryKey(contactId);

		Session session = null;

		try {
			session = openSession();

			Contacts[] array = new ContactsImpl[3];

			array[0] = getByDepartmentAndCompany_PrevAndNext(session, contacts,
					companyId, departmentId, orderByComparator, true);

			array[1] = contacts;

			array[2] = getByDepartmentAndCompany_PrevAndNext(session, contacts,
					companyId, departmentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Contacts getByDepartmentAndCompany_PrevAndNext(Session session,
		Contacts contacts, long companyId, long departmentId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTS_WHERE);

		query.append(_FINDER_COLUMN_DEPARTMENTANDCOMPANY_COMPANYID_2);

		query.append(_FINDER_COLUMN_DEPARTMENTANDCOMPANY_DEPARTMENTID_2);

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
			query.append(ContactsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(departmentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contacts);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Contacts> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the contactses where groupId = &#63; and departmentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param departmentId the department ID
	 * @return the matching contactses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contacts> findByDepartmentAndGroup(long groupId,
		long departmentId) throws SystemException {
		return findByDepartmentAndGroup(groupId, departmentId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contactses where groupId = &#63; and departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of contactses
	 * @param end the upper bound of the range of contactses (not inclusive)
	 * @return the range of matching contactses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contacts> findByDepartmentAndGroup(long groupId,
		long departmentId, int start, int end) throws SystemException {
		return findByDepartmentAndGroup(groupId, departmentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contactses where groupId = &#63; and departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of contactses
	 * @param end the upper bound of the range of contactses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contactses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contacts> findByDepartmentAndGroup(long groupId,
		long departmentId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTANDGROUP;
			finderArgs = new Object[] { groupId, departmentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPARTMENTANDGROUP;
			finderArgs = new Object[] {
					groupId, departmentId,
					
					start, end, orderByComparator
				};
		}

		List<Contacts> list = (List<Contacts>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Contacts contacts : list) {
				if ((groupId != contacts.getGroupId()) ||
						(departmentId != contacts.getDepartmentId())) {
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

			query.append(_SQL_SELECT_CONTACTS_WHERE);

			query.append(_FINDER_COLUMN_DEPARTMENTANDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_DEPARTMENTANDGROUP_DEPARTMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ContactsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(departmentId);

				list = (List<Contacts>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first contacts in the ordered set where groupId = &#63; and departmentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a matching contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts findByDepartmentAndGroup_First(long groupId,
		long departmentId, OrderByComparator orderByComparator)
		throws NoSuchContactsException, SystemException {
		Contacts contacts = fetchByDepartmentAndGroup_First(groupId,
				departmentId, orderByComparator);

		if (contacts != null) {
			return contacts;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", departmentId=");
		msg.append(departmentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsException(msg.toString());
	}

	/**
	 * Returns the first contacts in the ordered set where groupId = &#63; and departmentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts, or <code>null</code> if a matching contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts fetchByDepartmentAndGroup_First(long groupId,
		long departmentId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Contacts> list = findByDepartmentAndGroup(groupId, departmentId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contacts in the ordered set where groupId = &#63; and departmentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a matching contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts findByDepartmentAndGroup_Last(long groupId,
		long departmentId, OrderByComparator orderByComparator)
		throws NoSuchContactsException, SystemException {
		Contacts contacts = fetchByDepartmentAndGroup_Last(groupId,
				departmentId, orderByComparator);

		if (contacts != null) {
			return contacts;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", departmentId=");
		msg.append(departmentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsException(msg.toString());
	}

	/**
	 * Returns the last contacts in the ordered set where groupId = &#63; and departmentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts, or <code>null</code> if a matching contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts fetchByDepartmentAndGroup_Last(long groupId,
		long departmentId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByDepartmentAndGroup(groupId, departmentId);

		List<Contacts> list = findByDepartmentAndGroup(groupId, departmentId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contactses before and after the current contacts in the ordered set where groupId = &#63; and departmentId = &#63;.
	 *
	 * @param contactId the primary key of the current contacts
	 * @param groupId the group ID
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contacts
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a contacts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts[] findByDepartmentAndGroup_PrevAndNext(long contactId,
		long groupId, long departmentId, OrderByComparator orderByComparator)
		throws NoSuchContactsException, SystemException {
		Contacts contacts = findByPrimaryKey(contactId);

		Session session = null;

		try {
			session = openSession();

			Contacts[] array = new ContactsImpl[3];

			array[0] = getByDepartmentAndGroup_PrevAndNext(session, contacts,
					groupId, departmentId, orderByComparator, true);

			array[1] = contacts;

			array[2] = getByDepartmentAndGroup_PrevAndNext(session, contacts,
					groupId, departmentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Contacts getByDepartmentAndGroup_PrevAndNext(Session session,
		Contacts contacts, long groupId, long departmentId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTS_WHERE);

		query.append(_FINDER_COLUMN_DEPARTMENTANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_DEPARTMENTANDGROUP_DEPARTMENTID_2);

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
			query.append(ContactsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(departmentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contacts);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Contacts> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the contactses that the user has permission to view where groupId = &#63; and departmentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param departmentId the department ID
	 * @return the matching contactses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contacts> filterFindByDepartmentAndGroup(long groupId,
		long departmentId) throws SystemException {
		return filterFindByDepartmentAndGroup(groupId, departmentId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contactses that the user has permission to view where groupId = &#63; and departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of contactses
	 * @param end the upper bound of the range of contactses (not inclusive)
	 * @return the range of matching contactses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contacts> filterFindByDepartmentAndGroup(long groupId,
		long departmentId, int start, int end) throws SystemException {
		return filterFindByDepartmentAndGroup(groupId, departmentId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the contactses that the user has permissions to view where groupId = &#63; and departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of contactses
	 * @param end the upper bound of the range of contactses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contactses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contacts> filterFindByDepartmentAndGroup(long groupId,
		long departmentId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByDepartmentAndGroup(groupId, departmentId, start, end,
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
			query.append(_FILTER_SQL_SELECT_CONTACTS_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTACTS_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_DEPARTMENTANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_DEPARTMENTANDGROUP_DEPARTMENTID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CONTACTS_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ContactsModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ContactsModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Contacts.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, ContactsImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, ContactsImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(departmentId);

			return (List<Contacts>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the contactses before and after the current contacts in the ordered set of contactses that the user has permission to view where groupId = &#63; and departmentId = &#63;.
	 *
	 * @param contactId the primary key of the current contacts
	 * @param groupId the group ID
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contacts
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a contacts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts[] filterFindByDepartmentAndGroup_PrevAndNext(
		long contactId, long groupId, long departmentId,
		OrderByComparator orderByComparator)
		throws NoSuchContactsException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByDepartmentAndGroup_PrevAndNext(contactId, groupId,
				departmentId, orderByComparator);
		}

		Contacts contacts = findByPrimaryKey(contactId);

		Session session = null;

		try {
			session = openSession();

			Contacts[] array = new ContactsImpl[3];

			array[0] = filterGetByDepartmentAndGroup_PrevAndNext(session,
					contacts, groupId, departmentId, orderByComparator, true);

			array[1] = contacts;

			array[2] = filterGetByDepartmentAndGroup_PrevAndNext(session,
					contacts, groupId, departmentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Contacts filterGetByDepartmentAndGroup_PrevAndNext(
		Session session, Contacts contacts, long groupId, long departmentId,
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
			query.append(_FILTER_SQL_SELECT_CONTACTS_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTACTS_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_DEPARTMENTANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_DEPARTMENTANDGROUP_DEPARTMENTID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CONTACTS_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ContactsModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ContactsModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Contacts.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, ContactsImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, ContactsImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(departmentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contacts);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Contacts> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the contactses where companyId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	 *
	 * @param companyId the company ID
	 * @param departmentId the department ID
	 * @param contactStatus the contact status
	 * @return the matching contactses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contacts> findByCompanyAndDepartmentAndStatus(long companyId,
		long departmentId, int contactStatus) throws SystemException {
		return findByCompanyAndDepartmentAndStatus(companyId, departmentId,
			contactStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contactses where companyId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param departmentId the department ID
	 * @param contactStatus the contact status
	 * @param start the lower bound of the range of contactses
	 * @param end the upper bound of the range of contactses (not inclusive)
	 * @return the range of matching contactses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contacts> findByCompanyAndDepartmentAndStatus(long companyId,
		long departmentId, int contactStatus, int start, int end)
		throws SystemException {
		return findByCompanyAndDepartmentAndStatus(companyId, departmentId,
			contactStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contactses where companyId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param departmentId the department ID
	 * @param contactStatus the contact status
	 * @param start the lower bound of the range of contactses
	 * @param end the upper bound of the range of contactses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contactses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contacts> findByCompanyAndDepartmentAndStatus(long companyId,
		long departmentId, int contactStatus, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYANDDEPARTMENTANDSTATUS;
			finderArgs = new Object[] { companyId, departmentId, contactStatus };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYANDDEPARTMENTANDSTATUS;
			finderArgs = new Object[] {
					companyId, departmentId, contactStatus,
					
					start, end, orderByComparator
				};
		}

		List<Contacts> list = (List<Contacts>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Contacts contacts : list) {
				if ((companyId != contacts.getCompanyId()) ||
						(departmentId != contacts.getDepartmentId()) ||
						(contactStatus != contacts.getContactStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_CONTACTS_WHERE);

			query.append(_FINDER_COLUMN_COMPANYANDDEPARTMENTANDSTATUS_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYANDDEPARTMENTANDSTATUS_DEPARTMENTID_2);

			query.append(_FINDER_COLUMN_COMPANYANDDEPARTMENTANDSTATUS_CONTACTSTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ContactsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(departmentId);

				qPos.add(contactStatus);

				list = (List<Contacts>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first contacts in the ordered set where companyId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	 *
	 * @param companyId the company ID
	 * @param departmentId the department ID
	 * @param contactStatus the contact status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a matching contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts findByCompanyAndDepartmentAndStatus_First(long companyId,
		long departmentId, int contactStatus,
		OrderByComparator orderByComparator)
		throws NoSuchContactsException, SystemException {
		Contacts contacts = fetchByCompanyAndDepartmentAndStatus_First(companyId,
				departmentId, contactStatus, orderByComparator);

		if (contacts != null) {
			return contacts;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", departmentId=");
		msg.append(departmentId);

		msg.append(", contactStatus=");
		msg.append(contactStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsException(msg.toString());
	}

	/**
	 * Returns the first contacts in the ordered set where companyId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	 *
	 * @param companyId the company ID
	 * @param departmentId the department ID
	 * @param contactStatus the contact status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts, or <code>null</code> if a matching contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts fetchByCompanyAndDepartmentAndStatus_First(long companyId,
		long departmentId, int contactStatus,
		OrderByComparator orderByComparator) throws SystemException {
		List<Contacts> list = findByCompanyAndDepartmentAndStatus(companyId,
				departmentId, contactStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contacts in the ordered set where companyId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	 *
	 * @param companyId the company ID
	 * @param departmentId the department ID
	 * @param contactStatus the contact status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a matching contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts findByCompanyAndDepartmentAndStatus_Last(long companyId,
		long departmentId, int contactStatus,
		OrderByComparator orderByComparator)
		throws NoSuchContactsException, SystemException {
		Contacts contacts = fetchByCompanyAndDepartmentAndStatus_Last(companyId,
				departmentId, contactStatus, orderByComparator);

		if (contacts != null) {
			return contacts;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", departmentId=");
		msg.append(departmentId);

		msg.append(", contactStatus=");
		msg.append(contactStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsException(msg.toString());
	}

	/**
	 * Returns the last contacts in the ordered set where companyId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	 *
	 * @param companyId the company ID
	 * @param departmentId the department ID
	 * @param contactStatus the contact status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts, or <code>null</code> if a matching contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts fetchByCompanyAndDepartmentAndStatus_Last(long companyId,
		long departmentId, int contactStatus,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyAndDepartmentAndStatus(companyId,
				departmentId, contactStatus);

		List<Contacts> list = findByCompanyAndDepartmentAndStatus(companyId,
				departmentId, contactStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contactses before and after the current contacts in the ordered set where companyId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	 *
	 * @param contactId the primary key of the current contacts
	 * @param companyId the company ID
	 * @param departmentId the department ID
	 * @param contactStatus the contact status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contacts
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a contacts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts[] findByCompanyAndDepartmentAndStatus_PrevAndNext(
		long contactId, long companyId, long departmentId, int contactStatus,
		OrderByComparator orderByComparator)
		throws NoSuchContactsException, SystemException {
		Contacts contacts = findByPrimaryKey(contactId);

		Session session = null;

		try {
			session = openSession();

			Contacts[] array = new ContactsImpl[3];

			array[0] = getByCompanyAndDepartmentAndStatus_PrevAndNext(session,
					contacts, companyId, departmentId, contactStatus,
					orderByComparator, true);

			array[1] = contacts;

			array[2] = getByCompanyAndDepartmentAndStatus_PrevAndNext(session,
					contacts, companyId, departmentId, contactStatus,
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

	protected Contacts getByCompanyAndDepartmentAndStatus_PrevAndNext(
		Session session, Contacts contacts, long companyId, long departmentId,
		int contactStatus, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTS_WHERE);

		query.append(_FINDER_COLUMN_COMPANYANDDEPARTMENTANDSTATUS_COMPANYID_2);

		query.append(_FINDER_COLUMN_COMPANYANDDEPARTMENTANDSTATUS_DEPARTMENTID_2);

		query.append(_FINDER_COLUMN_COMPANYANDDEPARTMENTANDSTATUS_CONTACTSTATUS_2);

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
			query.append(ContactsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(departmentId);

		qPos.add(contactStatus);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contacts);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Contacts> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the contactses where groupId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param departmentId the department ID
	 * @param contactStatus the contact status
	 * @return the matching contactses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contacts> findByGroupAndDepartmentAndStatus(long groupId,
		long departmentId, int contactStatus) throws SystemException {
		return findByGroupAndDepartmentAndStatus(groupId, departmentId,
			contactStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contactses where groupId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param departmentId the department ID
	 * @param contactStatus the contact status
	 * @param start the lower bound of the range of contactses
	 * @param end the upper bound of the range of contactses (not inclusive)
	 * @return the range of matching contactses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contacts> findByGroupAndDepartmentAndStatus(long groupId,
		long departmentId, int contactStatus, int start, int end)
		throws SystemException {
		return findByGroupAndDepartmentAndStatus(groupId, departmentId,
			contactStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contactses where groupId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param departmentId the department ID
	 * @param contactStatus the contact status
	 * @param start the lower bound of the range of contactses
	 * @param end the upper bound of the range of contactses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contactses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contacts> findByGroupAndDepartmentAndStatus(long groupId,
		long departmentId, int contactStatus, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDDEPARTMENTANDSTATUS;
			finderArgs = new Object[] { groupId, departmentId, contactStatus };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPANDDEPARTMENTANDSTATUS;
			finderArgs = new Object[] {
					groupId, departmentId, contactStatus,
					
					start, end, orderByComparator
				};
		}

		List<Contacts> list = (List<Contacts>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Contacts contacts : list) {
				if ((groupId != contacts.getGroupId()) ||
						(departmentId != contacts.getDepartmentId()) ||
						(contactStatus != contacts.getContactStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_CONTACTS_WHERE);

			query.append(_FINDER_COLUMN_GROUPANDDEPARTMENTANDSTATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPANDDEPARTMENTANDSTATUS_DEPARTMENTID_2);

			query.append(_FINDER_COLUMN_GROUPANDDEPARTMENTANDSTATUS_CONTACTSTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ContactsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(departmentId);

				qPos.add(contactStatus);

				list = (List<Contacts>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first contacts in the ordered set where groupId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param departmentId the department ID
	 * @param contactStatus the contact status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a matching contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts findByGroupAndDepartmentAndStatus_First(long groupId,
		long departmentId, int contactStatus,
		OrderByComparator orderByComparator)
		throws NoSuchContactsException, SystemException {
		Contacts contacts = fetchByGroupAndDepartmentAndStatus_First(groupId,
				departmentId, contactStatus, orderByComparator);

		if (contacts != null) {
			return contacts;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", departmentId=");
		msg.append(departmentId);

		msg.append(", contactStatus=");
		msg.append(contactStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsException(msg.toString());
	}

	/**
	 * Returns the first contacts in the ordered set where groupId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param departmentId the department ID
	 * @param contactStatus the contact status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts, or <code>null</code> if a matching contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts fetchByGroupAndDepartmentAndStatus_First(long groupId,
		long departmentId, int contactStatus,
		OrderByComparator orderByComparator) throws SystemException {
		List<Contacts> list = findByGroupAndDepartmentAndStatus(groupId,
				departmentId, contactStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contacts in the ordered set where groupId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param departmentId the department ID
	 * @param contactStatus the contact status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a matching contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts findByGroupAndDepartmentAndStatus_Last(long groupId,
		long departmentId, int contactStatus,
		OrderByComparator orderByComparator)
		throws NoSuchContactsException, SystemException {
		Contacts contacts = fetchByGroupAndDepartmentAndStatus_Last(groupId,
				departmentId, contactStatus, orderByComparator);

		if (contacts != null) {
			return contacts;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", departmentId=");
		msg.append(departmentId);

		msg.append(", contactStatus=");
		msg.append(contactStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsException(msg.toString());
	}

	/**
	 * Returns the last contacts in the ordered set where groupId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param departmentId the department ID
	 * @param contactStatus the contact status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts, or <code>null</code> if a matching contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts fetchByGroupAndDepartmentAndStatus_Last(long groupId,
		long departmentId, int contactStatus,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupAndDepartmentAndStatus(groupId, departmentId,
				contactStatus);

		List<Contacts> list = findByGroupAndDepartmentAndStatus(groupId,
				departmentId, contactStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contactses before and after the current contacts in the ordered set where groupId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	 *
	 * @param contactId the primary key of the current contacts
	 * @param groupId the group ID
	 * @param departmentId the department ID
	 * @param contactStatus the contact status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contacts
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a contacts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts[] findByGroupAndDepartmentAndStatus_PrevAndNext(
		long contactId, long groupId, long departmentId, int contactStatus,
		OrderByComparator orderByComparator)
		throws NoSuchContactsException, SystemException {
		Contacts contacts = findByPrimaryKey(contactId);

		Session session = null;

		try {
			session = openSession();

			Contacts[] array = new ContactsImpl[3];

			array[0] = getByGroupAndDepartmentAndStatus_PrevAndNext(session,
					contacts, groupId, departmentId, contactStatus,
					orderByComparator, true);

			array[1] = contacts;

			array[2] = getByGroupAndDepartmentAndStatus_PrevAndNext(session,
					contacts, groupId, departmentId, contactStatus,
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

	protected Contacts getByGroupAndDepartmentAndStatus_PrevAndNext(
		Session session, Contacts contacts, long groupId, long departmentId,
		int contactStatus, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTS_WHERE);

		query.append(_FINDER_COLUMN_GROUPANDDEPARTMENTANDSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPANDDEPARTMENTANDSTATUS_DEPARTMENTID_2);

		query.append(_FINDER_COLUMN_GROUPANDDEPARTMENTANDSTATUS_CONTACTSTATUS_2);

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
			query.append(ContactsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(departmentId);

		qPos.add(contactStatus);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contacts);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Contacts> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the contactses that the user has permission to view where groupId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param departmentId the department ID
	 * @param contactStatus the contact status
	 * @return the matching contactses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contacts> filterFindByGroupAndDepartmentAndStatus(
		long groupId, long departmentId, int contactStatus)
		throws SystemException {
		return filterFindByGroupAndDepartmentAndStatus(groupId, departmentId,
			contactStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contactses that the user has permission to view where groupId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param departmentId the department ID
	 * @param contactStatus the contact status
	 * @param start the lower bound of the range of contactses
	 * @param end the upper bound of the range of contactses (not inclusive)
	 * @return the range of matching contactses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contacts> filterFindByGroupAndDepartmentAndStatus(
		long groupId, long departmentId, int contactStatus, int start, int end)
		throws SystemException {
		return filterFindByGroupAndDepartmentAndStatus(groupId, departmentId,
			contactStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contactses that the user has permissions to view where groupId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param departmentId the department ID
	 * @param contactStatus the contact status
	 * @param start the lower bound of the range of contactses
	 * @param end the upper bound of the range of contactses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contactses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contacts> filterFindByGroupAndDepartmentAndStatus(
		long groupId, long departmentId, int contactStatus, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupAndDepartmentAndStatus(groupId, departmentId,
				contactStatus, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CONTACTS_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTACTS_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPANDDEPARTMENTANDSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPANDDEPARTMENTANDSTATUS_DEPARTMENTID_2);

		query.append(_FINDER_COLUMN_GROUPANDDEPARTMENTANDSTATUS_CONTACTSTATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CONTACTS_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ContactsModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ContactsModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Contacts.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, ContactsImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, ContactsImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(departmentId);

			qPos.add(contactStatus);

			return (List<Contacts>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the contactses before and after the current contacts in the ordered set of contactses that the user has permission to view where groupId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	 *
	 * @param contactId the primary key of the current contacts
	 * @param groupId the group ID
	 * @param departmentId the department ID
	 * @param contactStatus the contact status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contacts
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a contacts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contacts[] filterFindByGroupAndDepartmentAndStatus_PrevAndNext(
		long contactId, long groupId, long departmentId, int contactStatus,
		OrderByComparator orderByComparator)
		throws NoSuchContactsException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupAndDepartmentAndStatus_PrevAndNext(contactId,
				groupId, departmentId, contactStatus, orderByComparator);
		}

		Contacts contacts = findByPrimaryKey(contactId);

		Session session = null;

		try {
			session = openSession();

			Contacts[] array = new ContactsImpl[3];

			array[0] = filterGetByGroupAndDepartmentAndStatus_PrevAndNext(session,
					contacts, groupId, departmentId, contactStatus,
					orderByComparator, true);

			array[1] = contacts;

			array[2] = filterGetByGroupAndDepartmentAndStatus_PrevAndNext(session,
					contacts, groupId, departmentId, contactStatus,
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

	protected Contacts filterGetByGroupAndDepartmentAndStatus_PrevAndNext(
		Session session, Contacts contacts, long groupId, long departmentId,
		int contactStatus, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CONTACTS_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTACTS_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPANDDEPARTMENTANDSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPANDDEPARTMENTANDSTATUS_DEPARTMENTID_2);

		query.append(_FINDER_COLUMN_GROUPANDDEPARTMENTANDSTATUS_CONTACTSTATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CONTACTS_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ContactsModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ContactsModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Contacts.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, ContactsImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, ContactsImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(departmentId);

		qPos.add(contactStatus);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contacts);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Contacts> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the contactses.
	 *
	 * @return the contactses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contacts> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contactses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of contactses
	 * @param end the upper bound of the range of contactses (not inclusive)
	 * @return the range of contactses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contacts> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the contactses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of contactses
	 * @param end the upper bound of the range of contactses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of contactses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contacts> findAll(int start, int end,
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

		List<Contacts> list = (List<Contacts>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONTACTS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONTACTS.concat(ContactsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Contacts>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Contacts>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the contactses where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompany(long companyId) throws SystemException {
		for (Contacts contacts : findByCompany(companyId)) {
			remove(contacts);
		}
	}

	/**
	 * Removes all the contactses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (Contacts contacts : findByGroup(groupId)) {
			remove(contacts);
		}
	}

	/**
	 * Removes all the contactses where companyId = &#63; and contactStatus = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param contactStatus the contact status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyAndStatus(long companyId, int contactStatus)
		throws SystemException {
		for (Contacts contacts : findByCompanyAndStatus(companyId, contactStatus)) {
			remove(contacts);
		}
	}

	/**
	 * Removes all the contactses where groupId = &#63; and contactStatus = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param contactStatus the contact status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupAndStatus(long groupId, int contactStatus)
		throws SystemException {
		for (Contacts contacts : findByGroupAndStatus(groupId, contactStatus)) {
			remove(contacts);
		}
	}

	/**
	 * Removes all the contactses where companyId = &#63; and departmentId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param departmentId the department ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByDepartmentAndCompany(long companyId, long departmentId)
		throws SystemException {
		for (Contacts contacts : findByDepartmentAndCompany(companyId,
				departmentId)) {
			remove(contacts);
		}
	}

	/**
	 * Removes all the contactses where groupId = &#63; and departmentId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param departmentId the department ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByDepartmentAndGroup(long groupId, long departmentId)
		throws SystemException {
		for (Contacts contacts : findByDepartmentAndGroup(groupId, departmentId)) {
			remove(contacts);
		}
	}

	/**
	 * Removes all the contactses where companyId = &#63; and departmentId = &#63; and contactStatus = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param departmentId the department ID
	 * @param contactStatus the contact status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyAndDepartmentAndStatus(long companyId,
		long departmentId, int contactStatus) throws SystemException {
		for (Contacts contacts : findByCompanyAndDepartmentAndStatus(
				companyId, departmentId, contactStatus)) {
			remove(contacts);
		}
	}

	/**
	 * Removes all the contactses where groupId = &#63; and departmentId = &#63; and contactStatus = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param departmentId the department ID
	 * @param contactStatus the contact status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupAndDepartmentAndStatus(long groupId,
		long departmentId, int contactStatus) throws SystemException {
		for (Contacts contacts : findByGroupAndDepartmentAndStatus(groupId,
				departmentId, contactStatus)) {
			remove(contacts);
		}
	}

	/**
	 * Removes all the contactses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Contacts contacts : findAll()) {
			remove(contacts);
		}
	}

	/**
	 * Returns the number of contactses where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching contactses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompany(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONTACTS_WHERE);

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
	 * Returns the number of contactses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching contactses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONTACTS_WHERE);

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
	 * Returns the number of contactses that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching contactses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroup(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroup(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_CONTACTS_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Contacts.class.getName(),
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
	 * Returns the number of contactses where companyId = &#63; and contactStatus = &#63;.
	 *
	 * @param companyId the company ID
	 * @param contactStatus the contact status
	 * @return the number of matching contactses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyAndStatus(long companyId, int contactStatus)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, contactStatus };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYANDSTATUS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTACTS_WHERE);

			query.append(_FINDER_COLUMN_COMPANYANDSTATUS_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYANDSTATUS_CONTACTSTATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(contactStatus);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYANDSTATUS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of contactses where groupId = &#63; and contactStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contactStatus the contact status
	 * @return the number of matching contactses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupAndStatus(long groupId, int contactStatus)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, contactStatus };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPANDSTATUS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTACTS_WHERE);

			query.append(_FINDER_COLUMN_GROUPANDSTATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPANDSTATUS_CONTACTSTATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(contactStatus);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPANDSTATUS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of contactses that the user has permission to view where groupId = &#63; and contactStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contactStatus the contact status
	 * @return the number of matching contactses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroupAndStatus(long groupId, int contactStatus)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupAndStatus(groupId, contactStatus);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_CONTACTS_WHERE);

		query.append(_FINDER_COLUMN_GROUPANDSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPANDSTATUS_CONTACTSTATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Contacts.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(contactStatus);

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
	 * Returns the number of contactses where companyId = &#63; and departmentId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param departmentId the department ID
	 * @return the number of matching contactses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByDepartmentAndCompany(long companyId, long departmentId)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, departmentId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DEPARTMENTANDCOMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTACTS_WHERE);

			query.append(_FINDER_COLUMN_DEPARTMENTANDCOMPANY_COMPANYID_2);

			query.append(_FINDER_COLUMN_DEPARTMENTANDCOMPANY_DEPARTMENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(departmentId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DEPARTMENTANDCOMPANY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of contactses where groupId = &#63; and departmentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param departmentId the department ID
	 * @return the number of matching contactses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByDepartmentAndGroup(long groupId, long departmentId)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, departmentId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DEPARTMENTANDGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTACTS_WHERE);

			query.append(_FINDER_COLUMN_DEPARTMENTANDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_DEPARTMENTANDGROUP_DEPARTMENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(departmentId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DEPARTMENTANDGROUP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of contactses that the user has permission to view where groupId = &#63; and departmentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param departmentId the department ID
	 * @return the number of matching contactses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByDepartmentAndGroup(long groupId, long departmentId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByDepartmentAndGroup(groupId, departmentId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_CONTACTS_WHERE);

		query.append(_FINDER_COLUMN_DEPARTMENTANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_DEPARTMENTANDGROUP_DEPARTMENTID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Contacts.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(departmentId);

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
	 * Returns the number of contactses where companyId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	 *
	 * @param companyId the company ID
	 * @param departmentId the department ID
	 * @param contactStatus the contact status
	 * @return the number of matching contactses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyAndDepartmentAndStatus(long companyId,
		long departmentId, int contactStatus) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, departmentId, contactStatus
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYANDDEPARTMENTANDSTATUS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CONTACTS_WHERE);

			query.append(_FINDER_COLUMN_COMPANYANDDEPARTMENTANDSTATUS_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYANDDEPARTMENTANDSTATUS_DEPARTMENTID_2);

			query.append(_FINDER_COLUMN_COMPANYANDDEPARTMENTANDSTATUS_CONTACTSTATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(departmentId);

				qPos.add(contactStatus);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYANDDEPARTMENTANDSTATUS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of contactses where groupId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param departmentId the department ID
	 * @param contactStatus the contact status
	 * @return the number of matching contactses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupAndDepartmentAndStatus(long groupId,
		long departmentId, int contactStatus) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, departmentId, contactStatus };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPANDDEPARTMENTANDSTATUS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CONTACTS_WHERE);

			query.append(_FINDER_COLUMN_GROUPANDDEPARTMENTANDSTATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPANDDEPARTMENTANDSTATUS_DEPARTMENTID_2);

			query.append(_FINDER_COLUMN_GROUPANDDEPARTMENTANDSTATUS_CONTACTSTATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(departmentId);

				qPos.add(contactStatus);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPANDDEPARTMENTANDSTATUS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of contactses that the user has permission to view where groupId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param departmentId the department ID
	 * @param contactStatus the contact status
	 * @return the number of matching contactses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroupAndDepartmentAndStatus(long groupId,
		long departmentId, int contactStatus) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupAndDepartmentAndStatus(groupId, departmentId,
				contactStatus);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_CONTACTS_WHERE);

		query.append(_FINDER_COLUMN_GROUPANDDEPARTMENTANDSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPANDDEPARTMENTANDSTATUS_DEPARTMENTID_2);

		query.append(_FINDER_COLUMN_GROUPANDDEPARTMENTANDSTATUS_CONTACTSTATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Contacts.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(departmentId);

			qPos.add(contactStatus);

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
	 * Returns the number of contactses.
	 *
	 * @return the number of contactses
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CONTACTS);

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
	 * Initializes the contacts persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.portal_egov.portlet.contacts.model.Contacts")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Contacts>> listenersList = new ArrayList<ModelListener<Contacts>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Contacts>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ContactsImpl.class.getName());
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
	private static final String _SQL_SELECT_CONTACTS = "SELECT contacts FROM Contacts contacts";
	private static final String _SQL_SELECT_CONTACTS_WHERE = "SELECT contacts FROM Contacts contacts WHERE ";
	private static final String _SQL_COUNT_CONTACTS = "SELECT COUNT(contacts) FROM Contacts contacts";
	private static final String _SQL_COUNT_CONTACTS_WHERE = "SELECT COUNT(contacts) FROM Contacts contacts WHERE ";
	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "contacts.companyId = ?";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "contacts.groupId = ?";
	private static final String _FINDER_COLUMN_COMPANYANDSTATUS_COMPANYID_2 = "contacts.companyId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYANDSTATUS_CONTACTSTATUS_2 = "contacts.contactStatus = ?";
	private static final String _FINDER_COLUMN_GROUPANDSTATUS_GROUPID_2 = "contacts.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPANDSTATUS_CONTACTSTATUS_2 = "contacts.contactStatus = ?";
	private static final String _FINDER_COLUMN_DEPARTMENTANDCOMPANY_COMPANYID_2 = "contacts.companyId = ? AND ";
	private static final String _FINDER_COLUMN_DEPARTMENTANDCOMPANY_DEPARTMENTID_2 =
		"contacts.departmentId = ?";
	private static final String _FINDER_COLUMN_DEPARTMENTANDGROUP_GROUPID_2 = "contacts.groupId = ? AND ";
	private static final String _FINDER_COLUMN_DEPARTMENTANDGROUP_DEPARTMENTID_2 =
		"contacts.departmentId = ?";
	private static final String _FINDER_COLUMN_COMPANYANDDEPARTMENTANDSTATUS_COMPANYID_2 =
		"contacts.companyId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYANDDEPARTMENTANDSTATUS_DEPARTMENTID_2 =
		"contacts.departmentId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYANDDEPARTMENTANDSTATUS_CONTACTSTATUS_2 =
		"contacts.contactStatus = ?";
	private static final String _FINDER_COLUMN_GROUPANDDEPARTMENTANDSTATUS_GROUPID_2 =
		"contacts.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPANDDEPARTMENTANDSTATUS_DEPARTMENTID_2 =
		"contacts.departmentId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPANDDEPARTMENTANDSTATUS_CONTACTSTATUS_2 =
		"contacts.contactStatus = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "contacts.contactId";
	private static final String _FILTER_SQL_SELECT_CONTACTS_WHERE = "SELECT DISTINCT {contacts.*} FROM Contacts contacts WHERE ";
	private static final String _FILTER_SQL_SELECT_CONTACTS_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {Contacts.*} FROM (SELECT DISTINCT contacts.contactId FROM Contacts contacts WHERE ";
	private static final String _FILTER_SQL_SELECT_CONTACTS_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN Contacts ON TEMP_TABLE.contactId = Contacts.contactId";
	private static final String _FILTER_SQL_COUNT_CONTACTS_WHERE = "SELECT COUNT(DISTINCT contacts.contactId) AS COUNT_VALUE FROM Contacts contacts WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "contacts";
	private static final String _FILTER_ENTITY_TABLE = "Contacts";
	private static final String _ORDER_BY_ENTITY_ALIAS = "contacts.";
	private static final String _ORDER_BY_ENTITY_TABLE = "Contacts.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Contacts exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Contacts exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ContactsPersistenceImpl.class);
	private static Contacts _nullContacts = new ContactsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Contacts> toCacheModel() {
				return _nullContactsCacheModel;
			}
		};

	private static CacheModel<Contacts> _nullContactsCacheModel = new CacheModel<Contacts>() {
			public Contacts toEntityModel() {
				return _nullContacts;
			}
		};
}