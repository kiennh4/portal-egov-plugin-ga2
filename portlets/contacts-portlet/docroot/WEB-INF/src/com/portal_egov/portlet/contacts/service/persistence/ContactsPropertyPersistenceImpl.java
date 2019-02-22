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

import com.portal_egov.portlet.contacts.NoSuchContactsPropertyException;
import com.portal_egov.portlet.contacts.model.ContactsProperty;
import com.portal_egov.portlet.contacts.model.impl.ContactsPropertyImpl;
import com.portal_egov.portlet.contacts.model.impl.ContactsPropertyModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the contacts property service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see ContactsPropertyPersistence
 * @see ContactsPropertyUtil
 * @generated
 */
public class ContactsPropertyPersistenceImpl extends BasePersistenceImpl<ContactsProperty>
	implements ContactsPropertyPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ContactsPropertyUtil} to access the contacts property persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ContactsPropertyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(ContactsPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ContactsPropertyModelImpl.FINDER_CACHE_ENABLED,
			ContactsPropertyImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompany",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(ContactsPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ContactsPropertyModelImpl.FINDER_CACHE_ENABLED,
			ContactsPropertyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			ContactsPropertyModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(ContactsPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ContactsPropertyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(ContactsPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ContactsPropertyModelImpl.FINDER_CACHE_ENABLED,
			ContactsPropertyImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(ContactsPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ContactsPropertyModelImpl.FINDER_CACHE_ENABLED,
			ContactsPropertyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			ContactsPropertyModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(ContactsPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ContactsPropertyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACT = new FinderPath(ContactsPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ContactsPropertyModelImpl.FINDER_CACHE_ENABLED,
			ContactsPropertyImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByContact",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACT =
		new FinderPath(ContactsPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ContactsPropertyModelImpl.FINDER_CACHE_ENABLED,
			ContactsPropertyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByContact",
			new String[] { Long.class.getName() },
			ContactsPropertyModelImpl.CONTACTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONTACT = new FinderPath(ContactsPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ContactsPropertyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByContact",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACTANDPROPERTYKEY =
		new FinderPath(ContactsPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ContactsPropertyModelImpl.FINDER_CACHE_ENABLED,
			ContactsPropertyImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByContactAndPropertyKey",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTANDPROPERTYKEY =
		new FinderPath(ContactsPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ContactsPropertyModelImpl.FINDER_CACHE_ENABLED,
			ContactsPropertyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByContactAndPropertyKey",
			new String[] { Long.class.getName(), String.class.getName() },
			ContactsPropertyModelImpl.CONTACTID_COLUMN_BITMASK |
			ContactsPropertyModelImpl.PROPERTYKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONTACTANDPROPERTYKEY = new FinderPath(ContactsPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ContactsPropertyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByContactAndPropertyKey",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ContactsPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ContactsPropertyModelImpl.FINDER_CACHE_ENABLED,
			ContactsPropertyImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ContactsPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ContactsPropertyModelImpl.FINDER_CACHE_ENABLED,
			ContactsPropertyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ContactsPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ContactsPropertyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the contacts property in the entity cache if it is enabled.
	 *
	 * @param contactsProperty the contacts property
	 */
	public void cacheResult(ContactsProperty contactsProperty) {
		EntityCacheUtil.putResult(ContactsPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ContactsPropertyImpl.class, contactsProperty.getPrimaryKey(),
			contactsProperty);

		contactsProperty.resetOriginalValues();
	}

	/**
	 * Caches the contacts properties in the entity cache if it is enabled.
	 *
	 * @param contactsProperties the contacts properties
	 */
	public void cacheResult(List<ContactsProperty> contactsProperties) {
		for (ContactsProperty contactsProperty : contactsProperties) {
			if (EntityCacheUtil.getResult(
						ContactsPropertyModelImpl.ENTITY_CACHE_ENABLED,
						ContactsPropertyImpl.class,
						contactsProperty.getPrimaryKey()) == null) {
				cacheResult(contactsProperty);
			}
			else {
				contactsProperty.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all contacts properties.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ContactsPropertyImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ContactsPropertyImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the contacts property.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ContactsProperty contactsProperty) {
		EntityCacheUtil.removeResult(ContactsPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ContactsPropertyImpl.class, contactsProperty.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ContactsProperty> contactsProperties) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ContactsProperty contactsProperty : contactsProperties) {
			EntityCacheUtil.removeResult(ContactsPropertyModelImpl.ENTITY_CACHE_ENABLED,
				ContactsPropertyImpl.class, contactsProperty.getPrimaryKey());
		}
	}

	/**
	 * Creates a new contacts property with the primary key. Does not add the contacts property to the database.
	 *
	 * @param propertyId the primary key for the new contacts property
	 * @return the new contacts property
	 */
	public ContactsProperty create(long propertyId) {
		ContactsProperty contactsProperty = new ContactsPropertyImpl();

		contactsProperty.setNew(true);
		contactsProperty.setPrimaryKey(propertyId);

		return contactsProperty;
	}

	/**
	 * Removes the contacts property with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param propertyId the primary key of the contacts property
	 * @return the contacts property that was removed
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsPropertyException if a contacts property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsProperty remove(long propertyId)
		throws NoSuchContactsPropertyException, SystemException {
		return remove(Long.valueOf(propertyId));
	}

	/**
	 * Removes the contacts property with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the contacts property
	 * @return the contacts property that was removed
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsPropertyException if a contacts property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactsProperty remove(Serializable primaryKey)
		throws NoSuchContactsPropertyException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ContactsProperty contactsProperty = (ContactsProperty)session.get(ContactsPropertyImpl.class,
					primaryKey);

			if (contactsProperty == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchContactsPropertyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(contactsProperty);
		}
		catch (NoSuchContactsPropertyException nsee) {
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
	protected ContactsProperty removeImpl(ContactsProperty contactsProperty)
		throws SystemException {
		contactsProperty = toUnwrappedModel(contactsProperty);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, contactsProperty);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(contactsProperty);

		return contactsProperty;
	}

	@Override
	public ContactsProperty updateImpl(
		com.portal_egov.portlet.contacts.model.ContactsProperty contactsProperty,
		boolean merge) throws SystemException {
		contactsProperty = toUnwrappedModel(contactsProperty);

		boolean isNew = contactsProperty.isNew();

		ContactsPropertyModelImpl contactsPropertyModelImpl = (ContactsPropertyModelImpl)contactsProperty;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, contactsProperty, merge);

			contactsProperty.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ContactsPropertyModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((contactsPropertyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(contactsPropertyModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] {
						Long.valueOf(contactsPropertyModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((contactsPropertyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(contactsPropertyModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] {
						Long.valueOf(contactsPropertyModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}

			if ((contactsPropertyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(contactsPropertyModelImpl.getOriginalContactId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACT,
					args);

				args = new Object[] {
						Long.valueOf(contactsPropertyModelImpl.getContactId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACT,
					args);
			}

			if ((contactsPropertyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTANDPROPERTYKEY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(contactsPropertyModelImpl.getOriginalContactId()),
						
						contactsPropertyModelImpl.getOriginalPropertyKey()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACTANDPROPERTYKEY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTANDPROPERTYKEY,
					args);

				args = new Object[] {
						Long.valueOf(contactsPropertyModelImpl.getContactId()),
						
						contactsPropertyModelImpl.getPropertyKey()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACTANDPROPERTYKEY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTANDPROPERTYKEY,
					args);
			}
		}

		EntityCacheUtil.putResult(ContactsPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ContactsPropertyImpl.class, contactsProperty.getPrimaryKey(),
			contactsProperty);

		return contactsProperty;
	}

	protected ContactsProperty toUnwrappedModel(
		ContactsProperty contactsProperty) {
		if (contactsProperty instanceof ContactsPropertyImpl) {
			return contactsProperty;
		}

		ContactsPropertyImpl contactsPropertyImpl = new ContactsPropertyImpl();

		contactsPropertyImpl.setNew(contactsProperty.isNew());
		contactsPropertyImpl.setPrimaryKey(contactsProperty.getPrimaryKey());

		contactsPropertyImpl.setPropertyId(contactsProperty.getPropertyId());
		contactsPropertyImpl.setGroupId(contactsProperty.getGroupId());
		contactsPropertyImpl.setCompanyId(contactsProperty.getCompanyId());
		contactsPropertyImpl.setUserId(contactsProperty.getUserId());
		contactsPropertyImpl.setUserName(contactsProperty.getUserName());
		contactsPropertyImpl.setCreateDate(contactsProperty.getCreateDate());
		contactsPropertyImpl.setModifiedDate(contactsProperty.getModifiedDate());
		contactsPropertyImpl.setContactId(contactsProperty.getContactId());
		contactsPropertyImpl.setPropertyKey(contactsProperty.getPropertyKey());
		contactsPropertyImpl.setPropertyValue(contactsProperty.getPropertyValue());
		contactsPropertyImpl.setPropertyType(contactsProperty.getPropertyType());

		return contactsPropertyImpl;
	}

	/**
	 * Returns the contacts property with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the contacts property
	 * @return the contacts property
	 * @throws com.liferay.portal.NoSuchModelException if a contacts property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactsProperty findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the contacts property with the primary key or throws a {@link com.portal_egov.portlet.contacts.NoSuchContactsPropertyException} if it could not be found.
	 *
	 * @param propertyId the primary key of the contacts property
	 * @return the contacts property
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsPropertyException if a contacts property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsProperty findByPrimaryKey(long propertyId)
		throws NoSuchContactsPropertyException, SystemException {
		ContactsProperty contactsProperty = fetchByPrimaryKey(propertyId);

		if (contactsProperty == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + propertyId);
			}

			throw new NoSuchContactsPropertyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				propertyId);
		}

		return contactsProperty;
	}

	/**
	 * Returns the contacts property with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the contacts property
	 * @return the contacts property, or <code>null</code> if a contacts property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactsProperty fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the contacts property with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param propertyId the primary key of the contacts property
	 * @return the contacts property, or <code>null</code> if a contacts property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsProperty fetchByPrimaryKey(long propertyId)
		throws SystemException {
		ContactsProperty contactsProperty = (ContactsProperty)EntityCacheUtil.getResult(ContactsPropertyModelImpl.ENTITY_CACHE_ENABLED,
				ContactsPropertyImpl.class, propertyId);

		if (contactsProperty == _nullContactsProperty) {
			return null;
		}

		if (contactsProperty == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				contactsProperty = (ContactsProperty)session.get(ContactsPropertyImpl.class,
						Long.valueOf(propertyId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (contactsProperty != null) {
					cacheResult(contactsProperty);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ContactsPropertyModelImpl.ENTITY_CACHE_ENABLED,
						ContactsPropertyImpl.class, propertyId,
						_nullContactsProperty);
				}

				closeSession(session);
			}
		}

		return contactsProperty;
	}

	/**
	 * Returns all the contacts properties where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching contacts properties
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsProperty> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the contacts properties where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of contacts properties
	 * @param end the upper bound of the range of contacts properties (not inclusive)
	 * @return the range of matching contacts properties
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsProperty> findByCompany(long companyId, int start,
		int end) throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contacts properties where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of contacts properties
	 * @param end the upper bound of the range of contacts properties (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contacts properties
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsProperty> findByCompany(long companyId, int start,
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

		List<ContactsProperty> list = (List<ContactsProperty>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ContactsProperty contactsProperty : list) {
				if ((companyId != contactsProperty.getCompanyId())) {
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

			query.append(_SQL_SELECT_CONTACTSPROPERTY_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ContactsPropertyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<ContactsProperty>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first contacts property in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts property
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsPropertyException if a matching contacts property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsProperty findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchContactsPropertyException, SystemException {
		ContactsProperty contactsProperty = fetchByCompany_First(companyId,
				orderByComparator);

		if (contactsProperty != null) {
			return contactsProperty;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsPropertyException(msg.toString());
	}

	/**
	 * Returns the first contacts property in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts property, or <code>null</code> if a matching contacts property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsProperty fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ContactsProperty> list = findByCompany(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contacts property in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts property
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsPropertyException if a matching contacts property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsProperty findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchContactsPropertyException, SystemException {
		ContactsProperty contactsProperty = fetchByCompany_Last(companyId,
				orderByComparator);

		if (contactsProperty != null) {
			return contactsProperty;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsPropertyException(msg.toString());
	}

	/**
	 * Returns the last contacts property in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts property, or <code>null</code> if a matching contacts property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsProperty fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		List<ContactsProperty> list = findByCompany(companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contacts properties before and after the current contacts property in the ordered set where companyId = &#63;.
	 *
	 * @param propertyId the primary key of the current contacts property
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contacts property
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsPropertyException if a contacts property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsProperty[] findByCompany_PrevAndNext(long propertyId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchContactsPropertyException, SystemException {
		ContactsProperty contactsProperty = findByPrimaryKey(propertyId);

		Session session = null;

		try {
			session = openSession();

			ContactsProperty[] array = new ContactsPropertyImpl[3];

			array[0] = getByCompany_PrevAndNext(session, contactsProperty,
					companyId, orderByComparator, true);

			array[1] = contactsProperty;

			array[2] = getByCompany_PrevAndNext(session, contactsProperty,
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

	protected ContactsProperty getByCompany_PrevAndNext(Session session,
		ContactsProperty contactsProperty, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTSPROPERTY_WHERE);

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
			query.append(ContactsPropertyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contactsProperty);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContactsProperty> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the contacts properties where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching contacts properties
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsProperty> findByGroup(long groupId)
		throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contacts properties where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of contacts properties
	 * @param end the upper bound of the range of contacts properties (not inclusive)
	 * @return the range of matching contacts properties
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsProperty> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contacts properties where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of contacts properties
	 * @param end the upper bound of the range of contacts properties (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contacts properties
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsProperty> findByGroup(long groupId, int start, int end,
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

		List<ContactsProperty> list = (List<ContactsProperty>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ContactsProperty contactsProperty : list) {
				if ((groupId != contactsProperty.getGroupId())) {
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

			query.append(_SQL_SELECT_CONTACTSPROPERTY_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ContactsPropertyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<ContactsProperty>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first contacts property in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts property
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsPropertyException if a matching contacts property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsProperty findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchContactsPropertyException, SystemException {
		ContactsProperty contactsProperty = fetchByGroup_First(groupId,
				orderByComparator);

		if (contactsProperty != null) {
			return contactsProperty;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsPropertyException(msg.toString());
	}

	/**
	 * Returns the first contacts property in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts property, or <code>null</code> if a matching contacts property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsProperty fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ContactsProperty> list = findByGroup(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contacts property in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts property
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsPropertyException if a matching contacts property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsProperty findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchContactsPropertyException, SystemException {
		ContactsProperty contactsProperty = fetchByGroup_Last(groupId,
				orderByComparator);

		if (contactsProperty != null) {
			return contactsProperty;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsPropertyException(msg.toString());
	}

	/**
	 * Returns the last contacts property in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts property, or <code>null</code> if a matching contacts property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsProperty fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<ContactsProperty> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contacts properties before and after the current contacts property in the ordered set where groupId = &#63;.
	 *
	 * @param propertyId the primary key of the current contacts property
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contacts property
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsPropertyException if a contacts property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsProperty[] findByGroup_PrevAndNext(long propertyId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchContactsPropertyException, SystemException {
		ContactsProperty contactsProperty = findByPrimaryKey(propertyId);

		Session session = null;

		try {
			session = openSession();

			ContactsProperty[] array = new ContactsPropertyImpl[3];

			array[0] = getByGroup_PrevAndNext(session, contactsProperty,
					groupId, orderByComparator, true);

			array[1] = contactsProperty;

			array[2] = getByGroup_PrevAndNext(session, contactsProperty,
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

	protected ContactsProperty getByGroup_PrevAndNext(Session session,
		ContactsProperty contactsProperty, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTSPROPERTY_WHERE);

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
			query.append(ContactsPropertyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contactsProperty);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContactsProperty> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the contacts properties that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching contacts properties that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsProperty> filterFindByGroup(long groupId)
		throws SystemException {
		return filterFindByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the contacts properties that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of contacts properties
	 * @param end the upper bound of the range of contacts properties (not inclusive)
	 * @return the range of matching contacts properties that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsProperty> filterFindByGroup(long groupId, int start,
		int end) throws SystemException {
		return filterFindByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contacts properties that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of contacts properties
	 * @param end the upper bound of the range of contacts properties (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contacts properties that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsProperty> filterFindByGroup(long groupId, int start,
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
			query.append(_FILTER_SQL_SELECT_CONTACTSPROPERTY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTACTSPROPERTY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CONTACTSPROPERTY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ContactsPropertyModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ContactsPropertyModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ContactsProperty.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, ContactsPropertyImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, ContactsPropertyImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<ContactsProperty>)QueryUtil.list(q, getDialect(),
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
	 * Returns the contacts properties before and after the current contacts property in the ordered set of contacts properties that the user has permission to view where groupId = &#63;.
	 *
	 * @param propertyId the primary key of the current contacts property
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contacts property
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsPropertyException if a contacts property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsProperty[] filterFindByGroup_PrevAndNext(long propertyId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchContactsPropertyException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup_PrevAndNext(propertyId, groupId,
				orderByComparator);
		}

		ContactsProperty contactsProperty = findByPrimaryKey(propertyId);

		Session session = null;

		try {
			session = openSession();

			ContactsProperty[] array = new ContactsPropertyImpl[3];

			array[0] = filterGetByGroup_PrevAndNext(session, contactsProperty,
					groupId, orderByComparator, true);

			array[1] = contactsProperty;

			array[2] = filterGetByGroup_PrevAndNext(session, contactsProperty,
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

	protected ContactsProperty filterGetByGroup_PrevAndNext(Session session,
		ContactsProperty contactsProperty, long groupId,
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
			query.append(_FILTER_SQL_SELECT_CONTACTSPROPERTY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTACTSPROPERTY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CONTACTSPROPERTY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ContactsPropertyModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ContactsPropertyModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ContactsProperty.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, ContactsPropertyImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, ContactsPropertyImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contactsProperty);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContactsProperty> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the contacts properties where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @return the matching contacts properties
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsProperty> findByContact(long contactId)
		throws SystemException {
		return findByContact(contactId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the contacts properties where contactId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param contactId the contact ID
	 * @param start the lower bound of the range of contacts properties
	 * @param end the upper bound of the range of contacts properties (not inclusive)
	 * @return the range of matching contacts properties
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsProperty> findByContact(long contactId, int start,
		int end) throws SystemException {
		return findByContact(contactId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contacts properties where contactId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param contactId the contact ID
	 * @param start the lower bound of the range of contacts properties
	 * @param end the upper bound of the range of contacts properties (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contacts properties
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsProperty> findByContact(long contactId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACT;
			finderArgs = new Object[] { contactId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACT;
			finderArgs = new Object[] { contactId, start, end, orderByComparator };
		}

		List<ContactsProperty> list = (List<ContactsProperty>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ContactsProperty contactsProperty : list) {
				if ((contactId != contactsProperty.getContactId())) {
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

			query.append(_SQL_SELECT_CONTACTSPROPERTY_WHERE);

			query.append(_FINDER_COLUMN_CONTACT_CONTACTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ContactsPropertyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(contactId);

				list = (List<ContactsProperty>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first contacts property in the ordered set where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts property
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsPropertyException if a matching contacts property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsProperty findByContact_First(long contactId,
		OrderByComparator orderByComparator)
		throws NoSuchContactsPropertyException, SystemException {
		ContactsProperty contactsProperty = fetchByContact_First(contactId,
				orderByComparator);

		if (contactsProperty != null) {
			return contactsProperty;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("contactId=");
		msg.append(contactId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsPropertyException(msg.toString());
	}

	/**
	 * Returns the first contacts property in the ordered set where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts property, or <code>null</code> if a matching contacts property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsProperty fetchByContact_First(long contactId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ContactsProperty> list = findByContact(contactId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contacts property in the ordered set where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts property
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsPropertyException if a matching contacts property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsProperty findByContact_Last(long contactId,
		OrderByComparator orderByComparator)
		throws NoSuchContactsPropertyException, SystemException {
		ContactsProperty contactsProperty = fetchByContact_Last(contactId,
				orderByComparator);

		if (contactsProperty != null) {
			return contactsProperty;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("contactId=");
		msg.append(contactId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsPropertyException(msg.toString());
	}

	/**
	 * Returns the last contacts property in the ordered set where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts property, or <code>null</code> if a matching contacts property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsProperty fetchByContact_Last(long contactId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByContact(contactId);

		List<ContactsProperty> list = findByContact(contactId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contacts properties before and after the current contacts property in the ordered set where contactId = &#63;.
	 *
	 * @param propertyId the primary key of the current contacts property
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contacts property
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsPropertyException if a contacts property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsProperty[] findByContact_PrevAndNext(long propertyId,
		long contactId, OrderByComparator orderByComparator)
		throws NoSuchContactsPropertyException, SystemException {
		ContactsProperty contactsProperty = findByPrimaryKey(propertyId);

		Session session = null;

		try {
			session = openSession();

			ContactsProperty[] array = new ContactsPropertyImpl[3];

			array[0] = getByContact_PrevAndNext(session, contactsProperty,
					contactId, orderByComparator, true);

			array[1] = contactsProperty;

			array[2] = getByContact_PrevAndNext(session, contactsProperty,
					contactId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ContactsProperty getByContact_PrevAndNext(Session session,
		ContactsProperty contactsProperty, long contactId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTSPROPERTY_WHERE);

		query.append(_FINDER_COLUMN_CONTACT_CONTACTID_2);

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
			query.append(ContactsPropertyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(contactId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contactsProperty);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContactsProperty> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the contacts properties where contactId = &#63; and propertyKey = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param propertyKey the property key
	 * @return the matching contacts properties
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsProperty> findByContactAndPropertyKey(long contactId,
		String propertyKey) throws SystemException {
		return findByContactAndPropertyKey(contactId, propertyKey,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contacts properties where contactId = &#63; and propertyKey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param contactId the contact ID
	 * @param propertyKey the property key
	 * @param start the lower bound of the range of contacts properties
	 * @param end the upper bound of the range of contacts properties (not inclusive)
	 * @return the range of matching contacts properties
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsProperty> findByContactAndPropertyKey(long contactId,
		String propertyKey, int start, int end) throws SystemException {
		return findByContactAndPropertyKey(contactId, propertyKey, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the contacts properties where contactId = &#63; and propertyKey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param contactId the contact ID
	 * @param propertyKey the property key
	 * @param start the lower bound of the range of contacts properties
	 * @param end the upper bound of the range of contacts properties (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contacts properties
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsProperty> findByContactAndPropertyKey(long contactId,
		String propertyKey, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTANDPROPERTYKEY;
			finderArgs = new Object[] { contactId, propertyKey };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACTANDPROPERTYKEY;
			finderArgs = new Object[] {
					contactId, propertyKey,
					
					start, end, orderByComparator
				};
		}

		List<ContactsProperty> list = (List<ContactsProperty>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ContactsProperty contactsProperty : list) {
				if ((contactId != contactsProperty.getContactId()) ||
						!Validator.equals(propertyKey,
							contactsProperty.getPropertyKey())) {
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

			query.append(_SQL_SELECT_CONTACTSPROPERTY_WHERE);

			query.append(_FINDER_COLUMN_CONTACTANDPROPERTYKEY_CONTACTID_2);

			if (propertyKey == null) {
				query.append(_FINDER_COLUMN_CONTACTANDPROPERTYKEY_PROPERTYKEY_1);
			}
			else {
				if (propertyKey.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_CONTACTANDPROPERTYKEY_PROPERTYKEY_3);
				}
				else {
					query.append(_FINDER_COLUMN_CONTACTANDPROPERTYKEY_PROPERTYKEY_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ContactsPropertyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(contactId);

				if (propertyKey != null) {
					qPos.add(propertyKey);
				}

				list = (List<ContactsProperty>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first contacts property in the ordered set where contactId = &#63; and propertyKey = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param propertyKey the property key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts property
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsPropertyException if a matching contacts property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsProperty findByContactAndPropertyKey_First(long contactId,
		String propertyKey, OrderByComparator orderByComparator)
		throws NoSuchContactsPropertyException, SystemException {
		ContactsProperty contactsProperty = fetchByContactAndPropertyKey_First(contactId,
				propertyKey, orderByComparator);

		if (contactsProperty != null) {
			return contactsProperty;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("contactId=");
		msg.append(contactId);

		msg.append(", propertyKey=");
		msg.append(propertyKey);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsPropertyException(msg.toString());
	}

	/**
	 * Returns the first contacts property in the ordered set where contactId = &#63; and propertyKey = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param propertyKey the property key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contacts property, or <code>null</code> if a matching contacts property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsProperty fetchByContactAndPropertyKey_First(long contactId,
		String propertyKey, OrderByComparator orderByComparator)
		throws SystemException {
		List<ContactsProperty> list = findByContactAndPropertyKey(contactId,
				propertyKey, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contacts property in the ordered set where contactId = &#63; and propertyKey = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param propertyKey the property key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts property
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsPropertyException if a matching contacts property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsProperty findByContactAndPropertyKey_Last(long contactId,
		String propertyKey, OrderByComparator orderByComparator)
		throws NoSuchContactsPropertyException, SystemException {
		ContactsProperty contactsProperty = fetchByContactAndPropertyKey_Last(contactId,
				propertyKey, orderByComparator);

		if (contactsProperty != null) {
			return contactsProperty;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("contactId=");
		msg.append(contactId);

		msg.append(", propertyKey=");
		msg.append(propertyKey);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactsPropertyException(msg.toString());
	}

	/**
	 * Returns the last contacts property in the ordered set where contactId = &#63; and propertyKey = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param propertyKey the property key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contacts property, or <code>null</code> if a matching contacts property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsProperty fetchByContactAndPropertyKey_Last(long contactId,
		String propertyKey, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByContactAndPropertyKey(contactId, propertyKey);

		List<ContactsProperty> list = findByContactAndPropertyKey(contactId,
				propertyKey, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contacts properties before and after the current contacts property in the ordered set where contactId = &#63; and propertyKey = &#63;.
	 *
	 * @param propertyId the primary key of the current contacts property
	 * @param contactId the contact ID
	 * @param propertyKey the property key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contacts property
	 * @throws com.portal_egov.portlet.contacts.NoSuchContactsPropertyException if a contacts property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsProperty[] findByContactAndPropertyKey_PrevAndNext(
		long propertyId, long contactId, String propertyKey,
		OrderByComparator orderByComparator)
		throws NoSuchContactsPropertyException, SystemException {
		ContactsProperty contactsProperty = findByPrimaryKey(propertyId);

		Session session = null;

		try {
			session = openSession();

			ContactsProperty[] array = new ContactsPropertyImpl[3];

			array[0] = getByContactAndPropertyKey_PrevAndNext(session,
					contactsProperty, contactId, propertyKey,
					orderByComparator, true);

			array[1] = contactsProperty;

			array[2] = getByContactAndPropertyKey_PrevAndNext(session,
					contactsProperty, contactId, propertyKey,
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

	protected ContactsProperty getByContactAndPropertyKey_PrevAndNext(
		Session session, ContactsProperty contactsProperty, long contactId,
		String propertyKey, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTSPROPERTY_WHERE);

		query.append(_FINDER_COLUMN_CONTACTANDPROPERTYKEY_CONTACTID_2);

		if (propertyKey == null) {
			query.append(_FINDER_COLUMN_CONTACTANDPROPERTYKEY_PROPERTYKEY_1);
		}
		else {
			if (propertyKey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CONTACTANDPROPERTYKEY_PROPERTYKEY_3);
			}
			else {
				query.append(_FINDER_COLUMN_CONTACTANDPROPERTYKEY_PROPERTYKEY_2);
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
			query.append(ContactsPropertyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(contactId);

		if (propertyKey != null) {
			qPos.add(propertyKey);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contactsProperty);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContactsProperty> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the contacts properties.
	 *
	 * @return the contacts properties
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsProperty> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contacts properties.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of contacts properties
	 * @param end the upper bound of the range of contacts properties (not inclusive)
	 * @return the range of contacts properties
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsProperty> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the contacts properties.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of contacts properties
	 * @param end the upper bound of the range of contacts properties (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of contacts properties
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsProperty> findAll(int start, int end,
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

		List<ContactsProperty> list = (List<ContactsProperty>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONTACTSPROPERTY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONTACTSPROPERTY.concat(ContactsPropertyModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ContactsProperty>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ContactsProperty>)QueryUtil.list(q,
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
	 * Removes all the contacts properties where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompany(long companyId) throws SystemException {
		for (ContactsProperty contactsProperty : findByCompany(companyId)) {
			remove(contactsProperty);
		}
	}

	/**
	 * Removes all the contacts properties where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (ContactsProperty contactsProperty : findByGroup(groupId)) {
			remove(contactsProperty);
		}
	}

	/**
	 * Removes all the contacts properties where contactId = &#63; from the database.
	 *
	 * @param contactId the contact ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByContact(long contactId) throws SystemException {
		for (ContactsProperty contactsProperty : findByContact(contactId)) {
			remove(contactsProperty);
		}
	}

	/**
	 * Removes all the contacts properties where contactId = &#63; and propertyKey = &#63; from the database.
	 *
	 * @param contactId the contact ID
	 * @param propertyKey the property key
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByContactAndPropertyKey(long contactId, String propertyKey)
		throws SystemException {
		for (ContactsProperty contactsProperty : findByContactAndPropertyKey(
				contactId, propertyKey)) {
			remove(contactsProperty);
		}
	}

	/**
	 * Removes all the contacts properties from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ContactsProperty contactsProperty : findAll()) {
			remove(contactsProperty);
		}
	}

	/**
	 * Returns the number of contacts properties where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching contacts properties
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompany(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONTACTSPROPERTY_WHERE);

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
	 * Returns the number of contacts properties where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching contacts properties
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONTACTSPROPERTY_WHERE);

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
	 * Returns the number of contacts properties that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching contacts properties that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroup(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroup(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_CONTACTSPROPERTY_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ContactsProperty.class.getName(),
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
	 * Returns the number of contacts properties where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @return the number of matching contacts properties
	 * @throws SystemException if a system exception occurred
	 */
	public int countByContact(long contactId) throws SystemException {
		Object[] finderArgs = new Object[] { contactId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CONTACT,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONTACTSPROPERTY_WHERE);

			query.append(_FINDER_COLUMN_CONTACT_CONTACTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(contactId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CONTACT,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of contacts properties where contactId = &#63; and propertyKey = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param propertyKey the property key
	 * @return the number of matching contacts properties
	 * @throws SystemException if a system exception occurred
	 */
	public int countByContactAndPropertyKey(long contactId, String propertyKey)
		throws SystemException {
		Object[] finderArgs = new Object[] { contactId, propertyKey };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CONTACTANDPROPERTYKEY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTACTSPROPERTY_WHERE);

			query.append(_FINDER_COLUMN_CONTACTANDPROPERTYKEY_CONTACTID_2);

			if (propertyKey == null) {
				query.append(_FINDER_COLUMN_CONTACTANDPROPERTYKEY_PROPERTYKEY_1);
			}
			else {
				if (propertyKey.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_CONTACTANDPROPERTYKEY_PROPERTYKEY_3);
				}
				else {
					query.append(_FINDER_COLUMN_CONTACTANDPROPERTYKEY_PROPERTYKEY_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(contactId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CONTACTANDPROPERTYKEY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of contacts properties.
	 *
	 * @return the number of contacts properties
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CONTACTSPROPERTY);

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
	 * Initializes the contacts property persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.portal_egov.portlet.contacts.model.ContactsProperty")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ContactsProperty>> listenersList = new ArrayList<ModelListener<ContactsProperty>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ContactsProperty>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ContactsPropertyImpl.class.getName());
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
	private static final String _SQL_SELECT_CONTACTSPROPERTY = "SELECT contactsProperty FROM ContactsProperty contactsProperty";
	private static final String _SQL_SELECT_CONTACTSPROPERTY_WHERE = "SELECT contactsProperty FROM ContactsProperty contactsProperty WHERE ";
	private static final String _SQL_COUNT_CONTACTSPROPERTY = "SELECT COUNT(contactsProperty) FROM ContactsProperty contactsProperty";
	private static final String _SQL_COUNT_CONTACTSPROPERTY_WHERE = "SELECT COUNT(contactsProperty) FROM ContactsProperty contactsProperty WHERE ";
	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "contactsProperty.companyId = ?";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "contactsProperty.groupId = ?";
	private static final String _FINDER_COLUMN_CONTACT_CONTACTID_2 = "contactsProperty.contactId = ?";
	private static final String _FINDER_COLUMN_CONTACTANDPROPERTYKEY_CONTACTID_2 =
		"contactsProperty.contactId = ? AND ";
	private static final String _FINDER_COLUMN_CONTACTANDPROPERTYKEY_PROPERTYKEY_1 =
		"contactsProperty.propertyKey IS NULL";
	private static final String _FINDER_COLUMN_CONTACTANDPROPERTYKEY_PROPERTYKEY_2 =
		"contactsProperty.propertyKey = ?";
	private static final String _FINDER_COLUMN_CONTACTANDPROPERTYKEY_PROPERTYKEY_3 =
		"(contactsProperty.propertyKey IS NULL OR contactsProperty.propertyKey = ?)";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "contactsProperty.propertyId";
	private static final String _FILTER_SQL_SELECT_CONTACTSPROPERTY_WHERE = "SELECT DISTINCT {contactsProperty.*} FROM ContactsProperty contactsProperty WHERE ";
	private static final String _FILTER_SQL_SELECT_CONTACTSPROPERTY_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {ContactsProperty.*} FROM (SELECT DISTINCT contactsProperty.propertyId FROM ContactsProperty contactsProperty WHERE ";
	private static final String _FILTER_SQL_SELECT_CONTACTSPROPERTY_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN ContactsProperty ON TEMP_TABLE.propertyId = ContactsProperty.propertyId";
	private static final String _FILTER_SQL_COUNT_CONTACTSPROPERTY_WHERE = "SELECT COUNT(DISTINCT contactsProperty.propertyId) AS COUNT_VALUE FROM ContactsProperty contactsProperty WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "contactsProperty";
	private static final String _FILTER_ENTITY_TABLE = "ContactsProperty";
	private static final String _ORDER_BY_ENTITY_ALIAS = "contactsProperty.";
	private static final String _ORDER_BY_ENTITY_TABLE = "ContactsProperty.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ContactsProperty exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ContactsProperty exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ContactsPropertyPersistenceImpl.class);
	private static ContactsProperty _nullContactsProperty = new ContactsPropertyImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ContactsProperty> toCacheModel() {
				return _nullContactsPropertyCacheModel;
			}
		};

	private static CacheModel<ContactsProperty> _nullContactsPropertyCacheModel = new CacheModel<ContactsProperty>() {
			public ContactsProperty toEntityModel() {
				return _nullContactsProperty;
			}
		};
}