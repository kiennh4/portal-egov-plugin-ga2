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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException;
import com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty;
import com.portal_egov.portlet.contacts.model.impl.ContactsDepartmentPropertyImpl;
import com.portal_egov.portlet.contacts.model.impl.ContactsDepartmentPropertyModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the contacts department property service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see ContactsDepartmentPropertyPersistence
 * @see ContactsDepartmentPropertyUtil
 * @generated
 */
public class ContactsDepartmentPropertyPersistenceImpl
	extends BasePersistenceImpl<ContactsDepartmentProperty>
	implements ContactsDepartmentPropertyPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ContactsDepartmentPropertyUtil} to access the contacts department property persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ContactsDepartmentPropertyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(ContactsDepartmentPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentPropertyModelImpl.FINDER_CACHE_ENABLED,
			ContactsDepartmentPropertyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(ContactsDepartmentPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentPropertyModelImpl.FINDER_CACHE_ENABLED,
			ContactsDepartmentPropertyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			ContactsDepartmentPropertyModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(ContactsDepartmentPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentPropertyModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCompany", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(ContactsDepartmentPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentPropertyModelImpl.FINDER_CACHE_ENABLED,
			ContactsDepartmentPropertyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(ContactsDepartmentPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentPropertyModelImpl.FINDER_CACHE_ENABLED,
			ContactsDepartmentPropertyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			ContactsDepartmentPropertyModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(ContactsDepartmentPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentPropertyModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroup", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACTSDEPARTMENT =
		new FinderPath(ContactsDepartmentPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentPropertyModelImpl.FINDER_CACHE_ENABLED,
			ContactsDepartmentPropertyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByContactsDepartment",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTSDEPARTMENT =
		new FinderPath(ContactsDepartmentPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentPropertyModelImpl.FINDER_CACHE_ENABLED,
			ContactsDepartmentPropertyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByContactsDepartment", new String[] { Long.class.getName() },
			ContactsDepartmentPropertyModelImpl.DEPARTMENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONTACTSDEPARTMENT = new FinderPath(ContactsDepartmentPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentPropertyModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByContactsDepartment", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACTSDEPARTMENTANDKEY =
		new FinderPath(ContactsDepartmentPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentPropertyModelImpl.FINDER_CACHE_ENABLED,
			ContactsDepartmentPropertyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByContactsDepartmentAndKey",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTSDEPARTMENTANDKEY =
		new FinderPath(ContactsDepartmentPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentPropertyModelImpl.FINDER_CACHE_ENABLED,
			ContactsDepartmentPropertyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByContactsDepartmentAndKey",
			new String[] { Long.class.getName(), String.class.getName() },
			ContactsDepartmentPropertyModelImpl.DEPARTMENTID_COLUMN_BITMASK |
			ContactsDepartmentPropertyModelImpl.PROPERTYKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONTACTSDEPARTMENTANDKEY =
		new FinderPath(ContactsDepartmentPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentPropertyModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByContactsDepartmentAndKey",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ContactsDepartmentPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentPropertyModelImpl.FINDER_CACHE_ENABLED,
			ContactsDepartmentPropertyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ContactsDepartmentPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentPropertyModelImpl.FINDER_CACHE_ENABLED,
			ContactsDepartmentPropertyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ContactsDepartmentPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentPropertyModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

	/**
	 * Caches the contacts department property in the entity cache if it is enabled.
	 *
	 * @param contactsDepartmentProperty the contacts department property
	 */
	public void cacheResult(
		ContactsDepartmentProperty contactsDepartmentProperty) {
		EntityCacheUtil.putResult(ContactsDepartmentPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentPropertyImpl.class,
			contactsDepartmentProperty.getPrimaryKey(),
			contactsDepartmentProperty);

		contactsDepartmentProperty.resetOriginalValues();
	}

	/**
	 * Caches the contacts department properties in the entity cache if it is enabled.
	 *
	 * @param contactsDepartmentProperties the contacts department properties
	 */
	public void cacheResult(
		List<ContactsDepartmentProperty> contactsDepartmentProperties) {
		for (ContactsDepartmentProperty contactsDepartmentProperty : contactsDepartmentProperties) {
			if (EntityCacheUtil.getResult(
						ContactsDepartmentPropertyModelImpl.ENTITY_CACHE_ENABLED,
						ContactsDepartmentPropertyImpl.class,
						contactsDepartmentProperty.getPrimaryKey()) == null) {
				cacheResult(contactsDepartmentProperty);
			}
			else {
				contactsDepartmentProperty.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all contacts department properties.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ContactsDepartmentPropertyImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ContactsDepartmentPropertyImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the contacts department property.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		ContactsDepartmentProperty contactsDepartmentProperty) {
		EntityCacheUtil.removeResult(ContactsDepartmentPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentPropertyImpl.class,
			contactsDepartmentProperty.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<ContactsDepartmentProperty> contactsDepartmentProperties) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ContactsDepartmentProperty contactsDepartmentProperty : contactsDepartmentProperties) {
			EntityCacheUtil.removeResult(ContactsDepartmentPropertyModelImpl.ENTITY_CACHE_ENABLED,
				ContactsDepartmentPropertyImpl.class,
				contactsDepartmentProperty.getPrimaryKey());
		}
	}

	/**
	 * Creates a new contacts department property with the primary key. Does not add the contacts department property to the database.
	 *
	 * @param propertyId the primary key for the new contacts department property
	 * @return the new contacts department property
	 */
	public ContactsDepartmentProperty create(long propertyId) {
		ContactsDepartmentProperty contactsDepartmentProperty = new ContactsDepartmentPropertyImpl();

		contactsDepartmentProperty.setNew(true);
		contactsDepartmentProperty.setPrimaryKey(propertyId);

		return contactsDepartmentProperty;
	}

	/**
	 * Removes the contacts department property with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param propertyId the primary key of the contacts department property
	 * @return the contacts department property that was removed
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException if a contacts department property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartmentProperty remove(long propertyId)
		throws NoSuchContactsDepartmentPropertyException, SystemException {
		return remove(Long.valueOf(propertyId));
	}

	/**
	 * Removes the contacts department property with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the contacts department property
	 * @return the contacts department property that was removed
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException if a contacts department property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactsDepartmentProperty remove(Serializable primaryKey)
		throws NoSuchContactsDepartmentPropertyException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ContactsDepartmentProperty contactsDepartmentProperty = (ContactsDepartmentProperty)session.get(ContactsDepartmentPropertyImpl.class,
					primaryKey);

			if (contactsDepartmentProperty == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchContactsDepartmentPropertyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(contactsDepartmentProperty);
		}
		catch (NoSuchContactsDepartmentPropertyException nsee) {
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
	protected ContactsDepartmentProperty removeImpl(
		ContactsDepartmentProperty contactsDepartmentProperty)
		throws SystemException {
		contactsDepartmentProperty = toUnwrappedModel(contactsDepartmentProperty);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, contactsDepartmentProperty);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(contactsDepartmentProperty);

		return contactsDepartmentProperty;
	}

	@Override
	public ContactsDepartmentProperty updateImpl(
		com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty contactsDepartmentProperty,
		boolean merge) throws SystemException {
		contactsDepartmentProperty = toUnwrappedModel(contactsDepartmentProperty);

		boolean isNew = contactsDepartmentProperty.isNew();

		ContactsDepartmentPropertyModelImpl contactsDepartmentPropertyModelImpl = (ContactsDepartmentPropertyModelImpl)contactsDepartmentProperty;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, contactsDepartmentProperty, merge);

			contactsDepartmentProperty.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew ||
				!ContactsDepartmentPropertyModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((contactsDepartmentPropertyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(contactsDepartmentPropertyModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] {
						Long.valueOf(contactsDepartmentPropertyModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((contactsDepartmentPropertyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(contactsDepartmentPropertyModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] {
						Long.valueOf(contactsDepartmentPropertyModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}

			if ((contactsDepartmentPropertyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTSDEPARTMENT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(contactsDepartmentPropertyModelImpl.getOriginalDepartmentId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACTSDEPARTMENT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTSDEPARTMENT,
					args);

				args = new Object[] {
						Long.valueOf(contactsDepartmentPropertyModelImpl.getDepartmentId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACTSDEPARTMENT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTSDEPARTMENT,
					args);
			}

			if ((contactsDepartmentPropertyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTSDEPARTMENTANDKEY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(contactsDepartmentPropertyModelImpl.getOriginalDepartmentId()),
						
						contactsDepartmentPropertyModelImpl.getOriginalPropertyKey()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACTSDEPARTMENTANDKEY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTSDEPARTMENTANDKEY,
					args);

				args = new Object[] {
						Long.valueOf(contactsDepartmentPropertyModelImpl.getDepartmentId()),
						
						contactsDepartmentPropertyModelImpl.getPropertyKey()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACTSDEPARTMENTANDKEY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTSDEPARTMENTANDKEY,
					args);
			}
		}

		EntityCacheUtil.putResult(ContactsDepartmentPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ContactsDepartmentPropertyImpl.class,
			contactsDepartmentProperty.getPrimaryKey(),
			contactsDepartmentProperty);

		return contactsDepartmentProperty;
	}

	protected ContactsDepartmentProperty toUnwrappedModel(
		ContactsDepartmentProperty contactsDepartmentProperty) {
		if (contactsDepartmentProperty instanceof ContactsDepartmentPropertyImpl) {
			return contactsDepartmentProperty;
		}

		ContactsDepartmentPropertyImpl contactsDepartmentPropertyImpl = new ContactsDepartmentPropertyImpl();

		contactsDepartmentPropertyImpl.setNew(contactsDepartmentProperty.isNew());
		contactsDepartmentPropertyImpl.setPrimaryKey(contactsDepartmentProperty.getPrimaryKey());

		contactsDepartmentPropertyImpl.setPropertyId(contactsDepartmentProperty.getPropertyId());
		contactsDepartmentPropertyImpl.setGroupId(contactsDepartmentProperty.getGroupId());
		contactsDepartmentPropertyImpl.setCompanyId(contactsDepartmentProperty.getCompanyId());
		contactsDepartmentPropertyImpl.setUserId(contactsDepartmentProperty.getUserId());
		contactsDepartmentPropertyImpl.setUserName(contactsDepartmentProperty.getUserName());
		contactsDepartmentPropertyImpl.setCreateDate(contactsDepartmentProperty.getCreateDate());
		contactsDepartmentPropertyImpl.setModifiedDate(contactsDepartmentProperty.getModifiedDate());
		contactsDepartmentPropertyImpl.setDepartmentId(contactsDepartmentProperty.getDepartmentId());
		contactsDepartmentPropertyImpl.setPropertyKey(contactsDepartmentProperty.getPropertyKey());
		contactsDepartmentPropertyImpl.setPropertyValue(contactsDepartmentProperty.getPropertyValue());
		contactsDepartmentPropertyImpl.setPropertyType(contactsDepartmentProperty.getPropertyType());

		return contactsDepartmentPropertyImpl;
	}

	/**
	 * Returns the contacts department property with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the contacts department property
	 * @return the contacts department property
	 * @throws com.liferay.portal.NoSuchModelException if a contacts department property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactsDepartmentProperty findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the contacts department property with the primary key or throws a {@link com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException} if it could not be found.
	 *
	 * @param propertyId the primary key of the contacts department property
	 * @return the contacts department property
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException if a contacts department property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartmentProperty findByPrimaryKey(long propertyId)
		throws NoSuchContactsDepartmentPropertyException, SystemException {
		ContactsDepartmentProperty contactsDepartmentProperty = fetchByPrimaryKey(propertyId);

		if (contactsDepartmentProperty == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + propertyId);
			}

			throw new NoSuchContactsDepartmentPropertyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				propertyId);
		}

		return contactsDepartmentProperty;
	}

	/**
	 * Returns the contacts department property with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the contacts department property
	 * @return the contacts department property, or <code>null</code> if a contacts department property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactsDepartmentProperty fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the contacts department property with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param propertyId the primary key of the contacts department property
	 * @return the contacts department property, or <code>null</code> if a contacts department property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartmentProperty fetchByPrimaryKey(long propertyId)
		throws SystemException {
		ContactsDepartmentProperty contactsDepartmentProperty = (ContactsDepartmentProperty)EntityCacheUtil.getResult(ContactsDepartmentPropertyModelImpl.ENTITY_CACHE_ENABLED,
				ContactsDepartmentPropertyImpl.class, propertyId);

		if (contactsDepartmentProperty == _nullContactsDepartmentProperty) {
			return null;
		}

		if (contactsDepartmentProperty == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				contactsDepartmentProperty = (ContactsDepartmentProperty)session.get(ContactsDepartmentPropertyImpl.class,
						Long.valueOf(propertyId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (contactsDepartmentProperty != null) {
					cacheResult(contactsDepartmentProperty);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ContactsDepartmentPropertyModelImpl.ENTITY_CACHE_ENABLED,
						ContactsDepartmentPropertyImpl.class, propertyId,
						_nullContactsDepartmentProperty);
				}

				closeSession(session);
			}
		}

		return contactsDepartmentProperty;
	}

	/**
	 * Returns all the contacts department properties where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching contacts department properties
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartmentProperty> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the contacts department properties where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of contacts department properties
	 * @param end the upper bound of the range of contacts department properties (not inclusive)
	 * @return the range of matching contacts department properties
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartmentProperty> findByCompany(long companyId,
		int start, int end) throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contacts department properties where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of contacts department properties
	 * @param end the upper bound of the range of contacts department properties (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contacts department properties
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartmentProperty> findByCompany(long companyId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<ContactsDepartmentProperty> list = (List<ContactsDepartmentProperty>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ContactsDepartmentProperty contactsDepartmentProperty : list) {
				if ((companyId != contactsDepartmentProperty.getCompanyId())) {
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

			query.append(_SQL_SELECT_CONTACTSDEPARTMENTPROPERTY_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ContactsDepartmentPropertyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<ContactsDepartmentProperty>)QueryUtil.list(q,
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
	 * Returns the first contacts department property in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts department property
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException if a matching contacts department property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartmentProperty findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchContactsDepartmentPropertyException, SystemException {
		ContactsDepartmentProperty contactsDepartmentProperty = fetchByCompany_First(companyId,
				orderByComparator);

		if (contactsDepartmentProperty != null) {
			return contactsDepartmentProperty;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsDepartmentPropertyException(msg.toString());
	}

	/**
	 * Returns the first contacts department property in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts department property, or <code>null</code> if a matching contacts department property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartmentProperty fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ContactsDepartmentProperty> list = findByCompany(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contacts department property in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts department property
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException if a matching contacts department property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartmentProperty findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchContactsDepartmentPropertyException, SystemException {
		ContactsDepartmentProperty contactsDepartmentProperty = fetchByCompany_Last(companyId,
				orderByComparator);

		if (contactsDepartmentProperty != null) {
			return contactsDepartmentProperty;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsDepartmentPropertyException(msg.toString());
	}

	/**
	 * Returns the last contacts department property in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts department property, or <code>null</code> if a matching contacts department property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartmentProperty fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		List<ContactsDepartmentProperty> list = findByCompany(companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contacts department properties before and after the current contacts department property in the ordered set where companyId = &#63;.
	 *
	 * @param propertyId the primary key of the current contacts department property
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contacts department property
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException if a contacts department property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartmentProperty[] findByCompany_PrevAndNext(
		long propertyId, long companyId, OrderByComparator orderByComparator)
		throws NoSuchContactsDepartmentPropertyException, SystemException {
		ContactsDepartmentProperty contactsDepartmentProperty = findByPrimaryKey(propertyId);

		Session session = null;

		try {
			session = openSession();

			ContactsDepartmentProperty[] array = new ContactsDepartmentPropertyImpl[3];

			array[0] = getByCompany_PrevAndNext(session,
					contactsDepartmentProperty, companyId, orderByComparator,
					true);

			array[1] = contactsDepartmentProperty;

			array[2] = getByCompany_PrevAndNext(session,
					contactsDepartmentProperty, companyId, orderByComparator,
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

	protected ContactsDepartmentProperty getByCompany_PrevAndNext(
		Session session, ContactsDepartmentProperty contactsDepartmentProperty,
		long companyId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTSDEPARTMENTPROPERTY_WHERE);

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
			query.append(ContactsDepartmentPropertyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contactsDepartmentProperty);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContactsDepartmentProperty> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the contacts department properties where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching contacts department properties
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartmentProperty> findByGroup(long groupId)
		throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contacts department properties where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of contacts department properties
	 * @param end the upper bound of the range of contacts department properties (not inclusive)
	 * @return the range of matching contacts department properties
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartmentProperty> findByGroup(long groupId,
		int start, int end) throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contacts department properties where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of contacts department properties
	 * @param end the upper bound of the range of contacts department properties (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contacts department properties
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartmentProperty> findByGroup(long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<ContactsDepartmentProperty> list = (List<ContactsDepartmentProperty>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ContactsDepartmentProperty contactsDepartmentProperty : list) {
				if ((groupId != contactsDepartmentProperty.getGroupId())) {
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

			query.append(_SQL_SELECT_CONTACTSDEPARTMENTPROPERTY_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ContactsDepartmentPropertyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<ContactsDepartmentProperty>)QueryUtil.list(q,
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
	 * Returns the first contacts department property in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts department property
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException if a matching contacts department property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartmentProperty findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchContactsDepartmentPropertyException, SystemException {
		ContactsDepartmentProperty contactsDepartmentProperty = fetchByGroup_First(groupId,
				orderByComparator);

		if (contactsDepartmentProperty != null) {
			return contactsDepartmentProperty;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsDepartmentPropertyException(msg.toString());
	}

	/**
	 * Returns the first contacts department property in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts department property, or <code>null</code> if a matching contacts department property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartmentProperty fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ContactsDepartmentProperty> list = findByGroup(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contacts department property in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts department property
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException if a matching contacts department property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartmentProperty findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchContactsDepartmentPropertyException, SystemException {
		ContactsDepartmentProperty contactsDepartmentProperty = fetchByGroup_Last(groupId,
				orderByComparator);

		if (contactsDepartmentProperty != null) {
			return contactsDepartmentProperty;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsDepartmentPropertyException(msg.toString());
	}

	/**
	 * Returns the last contacts department property in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts department property, or <code>null</code> if a matching contacts department property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartmentProperty fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<ContactsDepartmentProperty> list = findByGroup(groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contacts department properties before and after the current contacts department property in the ordered set where groupId = &#63;.
	 *
	 * @param propertyId the primary key of the current contacts department property
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contacts department property
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException if a contacts department property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartmentProperty[] findByGroup_PrevAndNext(
		long propertyId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchContactsDepartmentPropertyException, SystemException {
		ContactsDepartmentProperty contactsDepartmentProperty = findByPrimaryKey(propertyId);

		Session session = null;

		try {
			session = openSession();

			ContactsDepartmentProperty[] array = new ContactsDepartmentPropertyImpl[3];

			array[0] = getByGroup_PrevAndNext(session,
					contactsDepartmentProperty, groupId, orderByComparator, true);

			array[1] = contactsDepartmentProperty;

			array[2] = getByGroup_PrevAndNext(session,
					contactsDepartmentProperty, groupId, orderByComparator,
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

	protected ContactsDepartmentProperty getByGroup_PrevAndNext(
		Session session, ContactsDepartmentProperty contactsDepartmentProperty,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTSDEPARTMENTPROPERTY_WHERE);

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
			query.append(ContactsDepartmentPropertyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contactsDepartmentProperty);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContactsDepartmentProperty> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the contacts department properties that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching contacts department properties that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartmentProperty> filterFindByGroup(long groupId)
		throws SystemException {
		return filterFindByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the contacts department properties that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of contacts department properties
	 * @param end the upper bound of the range of contacts department properties (not inclusive)
	 * @return the range of matching contacts department properties that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartmentProperty> filterFindByGroup(long groupId,
		int start, int end) throws SystemException {
		return filterFindByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contacts department properties that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of contacts department properties
	 * @param end the upper bound of the range of contacts department properties (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contacts department properties that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartmentProperty> filterFindByGroup(long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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
			query.append(_FILTER_SQL_SELECT_CONTACTSDEPARTMENTPROPERTY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTACTSDEPARTMENTPROPERTY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CONTACTSDEPARTMENTPROPERTY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ContactsDepartmentPropertyModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ContactsDepartmentPropertyModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ContactsDepartmentProperty.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS,
					ContactsDepartmentPropertyImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE,
					ContactsDepartmentPropertyImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<ContactsDepartmentProperty>)QueryUtil.list(q,
				getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the contacts department properties before and after the current contacts department property in the ordered set of contacts department properties that the user has permission to view where groupId = &#63;.
	 *
	 * @param propertyId the primary key of the current contacts department property
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contacts department property
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException if a contacts department property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartmentProperty[] filterFindByGroup_PrevAndNext(
		long propertyId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchContactsDepartmentPropertyException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup_PrevAndNext(propertyId, groupId,
				orderByComparator);
		}

		ContactsDepartmentProperty contactsDepartmentProperty = findByPrimaryKey(propertyId);

		Session session = null;

		try {
			session = openSession();

			ContactsDepartmentProperty[] array = new ContactsDepartmentPropertyImpl[3];

			array[0] = filterGetByGroup_PrevAndNext(session,
					contactsDepartmentProperty, groupId, orderByComparator, true);

			array[1] = contactsDepartmentProperty;

			array[2] = filterGetByGroup_PrevAndNext(session,
					contactsDepartmentProperty, groupId, orderByComparator,
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

	protected ContactsDepartmentProperty filterGetByGroup_PrevAndNext(
		Session session, ContactsDepartmentProperty contactsDepartmentProperty,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CONTACTSDEPARTMENTPROPERTY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTACTSDEPARTMENTPROPERTY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CONTACTSDEPARTMENTPROPERTY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ContactsDepartmentPropertyModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ContactsDepartmentPropertyModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ContactsDepartmentProperty.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS,
				ContactsDepartmentPropertyImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE,
				ContactsDepartmentPropertyImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contactsDepartmentProperty);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContactsDepartmentProperty> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the contacts department properties where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @return the matching contacts department properties
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartmentProperty> findByContactsDepartment(
		long departmentId) throws SystemException {
		return findByContactsDepartment(departmentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contacts department properties where departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of contacts department properties
	 * @param end the upper bound of the range of contacts department properties (not inclusive)
	 * @return the range of matching contacts department properties
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartmentProperty> findByContactsDepartment(
		long departmentId, int start, int end) throws SystemException {
		return findByContactsDepartment(departmentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contacts department properties where departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of contacts department properties
	 * @param end the upper bound of the range of contacts department properties (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contacts department properties
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartmentProperty> findByContactsDepartment(
		long departmentId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTSDEPARTMENT;
			finderArgs = new Object[] { departmentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACTSDEPARTMENT;
			finderArgs = new Object[] {
					departmentId,
					
					start, end, orderByComparator
				};
		}

		List<ContactsDepartmentProperty> list = (List<ContactsDepartmentProperty>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ContactsDepartmentProperty contactsDepartmentProperty : list) {
				if ((departmentId != contactsDepartmentProperty.getDepartmentId())) {
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

			query.append(_SQL_SELECT_CONTACTSDEPARTMENTPROPERTY_WHERE);

			query.append(_FINDER_COLUMN_CONTACTSDEPARTMENT_DEPARTMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ContactsDepartmentPropertyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(departmentId);

				list = (List<ContactsDepartmentProperty>)QueryUtil.list(q,
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
	 * Returns the first contacts department property in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts department property
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException if a matching contacts department property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartmentProperty findByContactsDepartment_First(
		long departmentId, OrderByComparator orderByComparator)
		throws NoSuchContactsDepartmentPropertyException, SystemException {
		ContactsDepartmentProperty contactsDepartmentProperty = fetchByContactsDepartment_First(departmentId,
				orderByComparator);

		if (contactsDepartmentProperty != null) {
			return contactsDepartmentProperty;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("departmentId=");
		msg.append(departmentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsDepartmentPropertyException(msg.toString());
	}

	/**
	 * Returns the first contacts department property in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts department property, or <code>null</code> if a matching contacts department property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartmentProperty fetchByContactsDepartment_First(
		long departmentId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ContactsDepartmentProperty> list = findByContactsDepartment(departmentId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contacts department property in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts department property
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException if a matching contacts department property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartmentProperty findByContactsDepartment_Last(
		long departmentId, OrderByComparator orderByComparator)
		throws NoSuchContactsDepartmentPropertyException, SystemException {
		ContactsDepartmentProperty contactsDepartmentProperty = fetchByContactsDepartment_Last(departmentId,
				orderByComparator);

		if (contactsDepartmentProperty != null) {
			return contactsDepartmentProperty;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("departmentId=");
		msg.append(departmentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsDepartmentPropertyException(msg.toString());
	}

	/**
	 * Returns the last contacts department property in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts department property, or <code>null</code> if a matching contacts department property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartmentProperty fetchByContactsDepartment_Last(
		long departmentId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByContactsDepartment(departmentId);

		List<ContactsDepartmentProperty> list = findByContactsDepartment(departmentId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contacts department properties before and after the current contacts department property in the ordered set where departmentId = &#63;.
	 *
	 * @param propertyId the primary key of the current contacts department property
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contacts department property
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException if a contacts department property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartmentProperty[] findByContactsDepartment_PrevAndNext(
		long propertyId, long departmentId, OrderByComparator orderByComparator)
		throws NoSuchContactsDepartmentPropertyException, SystemException {
		ContactsDepartmentProperty contactsDepartmentProperty = findByPrimaryKey(propertyId);

		Session session = null;

		try {
			session = openSession();

			ContactsDepartmentProperty[] array = new ContactsDepartmentPropertyImpl[3];

			array[0] = getByContactsDepartment_PrevAndNext(session,
					contactsDepartmentProperty, departmentId,
					orderByComparator, true);

			array[1] = contactsDepartmentProperty;

			array[2] = getByContactsDepartment_PrevAndNext(session,
					contactsDepartmentProperty, departmentId,
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

	protected ContactsDepartmentProperty getByContactsDepartment_PrevAndNext(
		Session session, ContactsDepartmentProperty contactsDepartmentProperty,
		long departmentId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTSDEPARTMENTPROPERTY_WHERE);

		query.append(_FINDER_COLUMN_CONTACTSDEPARTMENT_DEPARTMENTID_2);

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
			query.append(ContactsDepartmentPropertyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(departmentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contactsDepartmentProperty);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContactsDepartmentProperty> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the contacts department properties where departmentId = &#63; and propertyKey = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param propertyKey the property key
	 * @return the matching contacts department properties
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartmentProperty> findByContactsDepartmentAndKey(
		long departmentId, String propertyKey) throws SystemException {
		return findByContactsDepartmentAndKey(departmentId, propertyKey,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contacts department properties where departmentId = &#63; and propertyKey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param propertyKey the property key
	 * @param start the lower bound of the range of contacts department properties
	 * @param end the upper bound of the range of contacts department properties (not inclusive)
	 * @return the range of matching contacts department properties
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartmentProperty> findByContactsDepartmentAndKey(
		long departmentId, String propertyKey, int start, int end)
		throws SystemException {
		return findByContactsDepartmentAndKey(departmentId, propertyKey, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the contacts department properties where departmentId = &#63; and propertyKey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param propertyKey the property key
	 * @param start the lower bound of the range of contacts department properties
	 * @param end the upper bound of the range of contacts department properties (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contacts department properties
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartmentProperty> findByContactsDepartmentAndKey(
		long departmentId, String propertyKey, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTSDEPARTMENTANDKEY;
			finderArgs = new Object[] { departmentId, propertyKey };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACTSDEPARTMENTANDKEY;
			finderArgs = new Object[] {
					departmentId, propertyKey,
					
					start, end, orderByComparator
				};
		}

		List<ContactsDepartmentProperty> list = (List<ContactsDepartmentProperty>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ContactsDepartmentProperty contactsDepartmentProperty : list) {
				if ((departmentId != contactsDepartmentProperty.getDepartmentId()) ||
						!Validator.equals(propertyKey,
							contactsDepartmentProperty.getPropertyKey())) {
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

			query.append(_SQL_SELECT_CONTACTSDEPARTMENTPROPERTY_WHERE);

			query.append(_FINDER_COLUMN_CONTACTSDEPARTMENTANDKEY_DEPARTMENTID_2);

			if (propertyKey == null) {
				query.append(_FINDER_COLUMN_CONTACTSDEPARTMENTANDKEY_PROPERTYKEY_1);
			}
			else {
				if (propertyKey.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_CONTACTSDEPARTMENTANDKEY_PROPERTYKEY_3);
				}
				else {
					query.append(_FINDER_COLUMN_CONTACTSDEPARTMENTANDKEY_PROPERTYKEY_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ContactsDepartmentPropertyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(departmentId);

				if (propertyKey != null) {
					qPos.add(propertyKey);
				}

				list = (List<ContactsDepartmentProperty>)QueryUtil.list(q,
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
	 * Returns the first contacts department property in the ordered set where departmentId = &#63; and propertyKey = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param propertyKey the property key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts department property
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException if a matching contacts department property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartmentProperty findByContactsDepartmentAndKey_First(
		long departmentId, String propertyKey,
		OrderByComparator orderByComparator)
		throws NoSuchContactsDepartmentPropertyException, SystemException {
		ContactsDepartmentProperty contactsDepartmentProperty = fetchByContactsDepartmentAndKey_First(departmentId,
				propertyKey, orderByComparator);

		if (contactsDepartmentProperty != null) {
			return contactsDepartmentProperty;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("departmentId=");
		msg.append(departmentId);

		msg.append(", propertyKey=");
		msg.append(propertyKey);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsDepartmentPropertyException(msg.toString());
	}

	/**
	 * Returns the first contacts department property in the ordered set where departmentId = &#63; and propertyKey = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param propertyKey the property key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts department property, or <code>null</code> if a matching contacts department property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartmentProperty fetchByContactsDepartmentAndKey_First(
		long departmentId, String propertyKey,
		OrderByComparator orderByComparator) throws SystemException {
		List<ContactsDepartmentProperty> list = findByContactsDepartmentAndKey(departmentId,
				propertyKey, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contacts department property in the ordered set where departmentId = &#63; and propertyKey = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param propertyKey the property key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts department property
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException if a matching contacts department property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartmentProperty findByContactsDepartmentAndKey_Last(
		long departmentId, String propertyKey,
		OrderByComparator orderByComparator)
		throws NoSuchContactsDepartmentPropertyException, SystemException {
		ContactsDepartmentProperty contactsDepartmentProperty = fetchByContactsDepartmentAndKey_Last(departmentId,
				propertyKey, orderByComparator);

		if (contactsDepartmentProperty != null) {
			return contactsDepartmentProperty;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("departmentId=");
		msg.append(departmentId);

		msg.append(", propertyKey=");
		msg.append(propertyKey);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsDepartmentPropertyException(msg.toString());
	}

	/**
	 * Returns the last contacts department property in the ordered set where departmentId = &#63; and propertyKey = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param propertyKey the property key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts department property, or <code>null</code> if a matching contacts department property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartmentProperty fetchByContactsDepartmentAndKey_Last(
		long departmentId, String propertyKey,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByContactsDepartmentAndKey(departmentId, propertyKey);

		List<ContactsDepartmentProperty> list = findByContactsDepartmentAndKey(departmentId,
				propertyKey, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contacts department properties before and after the current contacts department property in the ordered set where departmentId = &#63; and propertyKey = &#63;.
	 *
	 * @param propertyId the primary key of the current contacts department property
	 * @param departmentId the department ID
	 * @param propertyKey the property key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contacts department property
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException if a contacts department property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartmentProperty[] findByContactsDepartmentAndKey_PrevAndNext(
		long propertyId, long departmentId, String propertyKey,
		OrderByComparator orderByComparator)
		throws NoSuchContactsDepartmentPropertyException, SystemException {
		ContactsDepartmentProperty contactsDepartmentProperty = findByPrimaryKey(propertyId);

		Session session = null;

		try {
			session = openSession();

			ContactsDepartmentProperty[] array = new ContactsDepartmentPropertyImpl[3];

			array[0] = getByContactsDepartmentAndKey_PrevAndNext(session,
					contactsDepartmentProperty, departmentId, propertyKey,
					orderByComparator, true);

			array[1] = contactsDepartmentProperty;

			array[2] = getByContactsDepartmentAndKey_PrevAndNext(session,
					contactsDepartmentProperty, departmentId, propertyKey,
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

	protected ContactsDepartmentProperty getByContactsDepartmentAndKey_PrevAndNext(
		Session session, ContactsDepartmentProperty contactsDepartmentProperty,
		long departmentId, String propertyKey,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTSDEPARTMENTPROPERTY_WHERE);

		query.append(_FINDER_COLUMN_CONTACTSDEPARTMENTANDKEY_DEPARTMENTID_2);

		if (propertyKey == null) {
			query.append(_FINDER_COLUMN_CONTACTSDEPARTMENTANDKEY_PROPERTYKEY_1);
		}
		else {
			if (propertyKey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CONTACTSDEPARTMENTANDKEY_PROPERTYKEY_3);
			}
			else {
				query.append(_FINDER_COLUMN_CONTACTSDEPARTMENTANDKEY_PROPERTYKEY_2);
			}
		}

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
			query.append(ContactsDepartmentPropertyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(departmentId);

		if (propertyKey != null) {
			qPos.add(propertyKey);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contactsDepartmentProperty);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContactsDepartmentProperty> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the contacts department properties.
	 *
	 * @return the contacts department properties
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartmentProperty> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contacts department properties.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of contacts department properties
	 * @param end the upper bound of the range of contacts department properties (not inclusive)
	 * @return the range of contacts department properties
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartmentProperty> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the contacts department properties.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of contacts department properties
	 * @param end the upper bound of the range of contacts department properties (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of contacts department properties
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartmentProperty> findAll(int start, int end,
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

		List<ContactsDepartmentProperty> list = (List<ContactsDepartmentProperty>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONTACTSDEPARTMENTPROPERTY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONTACTSDEPARTMENTPROPERTY.concat(ContactsDepartmentPropertyModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ContactsDepartmentProperty>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ContactsDepartmentProperty>)QueryUtil.list(q,
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
	 * Removes all the contacts department properties where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompany(long companyId) throws SystemException {
		for (ContactsDepartmentProperty contactsDepartmentProperty : findByCompany(
				companyId)) {
			remove(contactsDepartmentProperty);
		}
	}

	/**
	 * Removes all the contacts department properties where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (ContactsDepartmentProperty contactsDepartmentProperty : findByGroup(
				groupId)) {
			remove(contactsDepartmentProperty);
		}
	}

	/**
	 * Removes all the contacts department properties where departmentId = &#63; from the database.
	 *
	 * @param departmentId the department ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByContactsDepartment(long departmentId)
		throws SystemException {
		for (ContactsDepartmentProperty contactsDepartmentProperty : findByContactsDepartment(
				departmentId)) {
			remove(contactsDepartmentProperty);
		}
	}

	/**
	 * Removes all the contacts department properties where departmentId = &#63; and propertyKey = &#63; from the database.
	 *
	 * @param departmentId the department ID
	 * @param propertyKey the property key
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByContactsDepartmentAndKey(long departmentId,
		String propertyKey) throws SystemException {
		for (ContactsDepartmentProperty contactsDepartmentProperty : findByContactsDepartmentAndKey(
				departmentId, propertyKey)) {
			remove(contactsDepartmentProperty);
		}
	}

	/**
	 * Removes all the contacts department properties from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ContactsDepartmentProperty contactsDepartmentProperty : findAll()) {
			remove(contactsDepartmentProperty);
		}
	}

	/**
	 * Returns the number of contacts department properties where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching contacts department properties
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompany(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONTACTSDEPARTMENTPROPERTY_WHERE);

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
	 * Returns the number of contacts department properties where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching contacts department properties
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONTACTSDEPARTMENTPROPERTY_WHERE);

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
	 * Returns the number of contacts department properties that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching contacts department properties that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroup(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroup(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_CONTACTSDEPARTMENTPROPERTY_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ContactsDepartmentProperty.class.getName(),
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
	 * Returns the number of contacts department properties where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @return the number of matching contacts department properties
	 * @throws SystemException if a system exception occurred
	 */
	public int countByContactsDepartment(long departmentId)
		throws SystemException {
		Object[] finderArgs = new Object[] { departmentId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CONTACTSDEPARTMENT,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONTACTSDEPARTMENTPROPERTY_WHERE);

			query.append(_FINDER_COLUMN_CONTACTSDEPARTMENT_DEPARTMENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CONTACTSDEPARTMENT,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of contacts department properties where departmentId = &#63; and propertyKey = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param propertyKey the property key
	 * @return the number of matching contacts department properties
	 * @throws SystemException if a system exception occurred
	 */
	public int countByContactsDepartmentAndKey(long departmentId,
		String propertyKey) throws SystemException {
		Object[] finderArgs = new Object[] { departmentId, propertyKey };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CONTACTSDEPARTMENTANDKEY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTACTSDEPARTMENTPROPERTY_WHERE);

			query.append(_FINDER_COLUMN_CONTACTSDEPARTMENTANDKEY_DEPARTMENTID_2);

			if (propertyKey == null) {
				query.append(_FINDER_COLUMN_CONTACTSDEPARTMENTANDKEY_PROPERTYKEY_1);
			}
			else {
				if (propertyKey.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_CONTACTSDEPARTMENTANDKEY_PROPERTYKEY_3);
				}
				else {
					query.append(_FINDER_COLUMN_CONTACTSDEPARTMENTANDKEY_PROPERTYKEY_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(departmentId);

				if (propertyKey != null) {
					qPos.add(propertyKey);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CONTACTSDEPARTMENTANDKEY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of contacts department properties.
	 *
	 * @return the number of contacts department properties
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CONTACTSDEPARTMENTPROPERTY);

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
	 * Initializes the contacts department property persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ContactsDepartmentProperty>> listenersList = new ArrayList<ModelListener<ContactsDepartmentProperty>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ContactsDepartmentProperty>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ContactsDepartmentPropertyImpl.class.getName());
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
	private static final String _SQL_SELECT_CONTACTSDEPARTMENTPROPERTY = "SELECT contactsDepartmentProperty FROM ContactsDepartmentProperty contactsDepartmentProperty";
	private static final String _SQL_SELECT_CONTACTSDEPARTMENTPROPERTY_WHERE = "SELECT contactsDepartmentProperty FROM ContactsDepartmentProperty contactsDepartmentProperty WHERE ";
	private static final String _SQL_COUNT_CONTACTSDEPARTMENTPROPERTY = "SELECT COUNT(contactsDepartmentProperty) FROM ContactsDepartmentProperty contactsDepartmentProperty";
	private static final String _SQL_COUNT_CONTACTSDEPARTMENTPROPERTY_WHERE = "SELECT COUNT(contactsDepartmentProperty) FROM ContactsDepartmentProperty contactsDepartmentProperty WHERE ";
	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "contactsDepartmentProperty.companyId = ?";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "contactsDepartmentProperty.groupId = ?";
	private static final String _FINDER_COLUMN_CONTACTSDEPARTMENT_DEPARTMENTID_2 =
		"contactsDepartmentProperty.departmentId = ?";
	private static final String _FINDER_COLUMN_CONTACTSDEPARTMENTANDKEY_DEPARTMENTID_2 =
		"contactsDepartmentProperty.departmentId = ? AND ";
	private static final String _FINDER_COLUMN_CONTACTSDEPARTMENTANDKEY_PROPERTYKEY_1 =
		"contactsDepartmentProperty.propertyKey IS NULL";
	private static final String _FINDER_COLUMN_CONTACTSDEPARTMENTANDKEY_PROPERTYKEY_2 =
		"contactsDepartmentProperty.propertyKey = ?";
	private static final String _FINDER_COLUMN_CONTACTSDEPARTMENTANDKEY_PROPERTYKEY_3 =
		"(contactsDepartmentProperty.propertyKey IS NULL OR contactsDepartmentProperty.propertyKey = ?)";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "contactsDepartmentProperty.propertyId";
	private static final String _FILTER_SQL_SELECT_CONTACTSDEPARTMENTPROPERTY_WHERE =
		"SELECT DISTINCT {contactsDepartmentProperty.*} FROM ContactsDepartmentProperty contactsDepartmentProperty WHERE ";
	private static final String _FILTER_SQL_SELECT_CONTACTSDEPARTMENTPROPERTY_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {ContactsDepartmentProperty.*} FROM (SELECT DISTINCT contactsDepartmentProperty.propertyId FROM ContactsDepartmentProperty contactsDepartmentProperty WHERE ";
	private static final String _FILTER_SQL_SELECT_CONTACTSDEPARTMENTPROPERTY_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN ContactsDepartmentProperty ON TEMP_TABLE.propertyId = ContactsDepartmentProperty.propertyId";
	private static final String _FILTER_SQL_COUNT_CONTACTSDEPARTMENTPROPERTY_WHERE =
		"SELECT COUNT(DISTINCT contactsDepartmentProperty.propertyId) AS COUNT_VALUE FROM ContactsDepartmentProperty contactsDepartmentProperty WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "contactsDepartmentProperty";
	private static final String _FILTER_ENTITY_TABLE = "ContactsDepartmentProperty";
	private static final String _ORDER_BY_ENTITY_ALIAS = "contactsDepartmentProperty.";
	private static final String _ORDER_BY_ENTITY_TABLE = "ContactsDepartmentProperty.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ContactsDepartmentProperty exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ContactsDepartmentProperty exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ContactsDepartmentPropertyPersistenceImpl.class);
	private static ContactsDepartmentProperty _nullContactsDepartmentProperty = new ContactsDepartmentPropertyImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ContactsDepartmentProperty> toCacheModel() {
				return _nullContactsDepartmentPropertyCacheModel;
			}
		};

	private static CacheModel<ContactsDepartmentProperty> _nullContactsDepartmentPropertyCacheModel =
		new CacheModel<ContactsDepartmentProperty>() {
			public ContactsDepartmentProperty toEntityModel() {
				return _nullContactsDepartmentProperty;
			}
		};
}