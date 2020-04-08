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

package com.portal_egov.portlet.tthc.service.persistence;

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

import com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException;
import com.portal_egov.portlet.tthc.model.TTHC_Attribute;
import com.portal_egov.portlet.tthc.model.impl.TTHC_AttributeImpl;
import com.portal_egov.portlet.tthc.model.impl.TTHC_AttributeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the t t h c_ attribute service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see TTHC_AttributePersistence
 * @see TTHC_AttributeUtil
 * @generated
 */
public class TTHC_AttributePersistenceImpl extends BasePersistenceImpl<TTHC_Attribute>
	implements TTHC_AttributePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TTHC_AttributeUtil} to access the t t h c_ attribute persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TTHC_AttributeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TTHCENTRYANDCOMPANY =
		new FinderPath(TTHC_AttributeModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_AttributeModelImpl.FINDER_CACHE_ENABLED,
			TTHC_AttributeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTTHCEntryAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TTHCENTRYANDCOMPANY =
		new FinderPath(TTHC_AttributeModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_AttributeModelImpl.FINDER_CACHE_ENABLED,
			TTHC_AttributeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTTHCEntryAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() },
			TTHC_AttributeModelImpl.COMPANYID_COLUMN_BITMASK |
			TTHC_AttributeModelImpl.TTHCENTRYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TTHCENTRYANDCOMPANY = new FinderPath(TTHC_AttributeModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_AttributeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTTHCEntryAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TTHCENTRYANDGROUP =
		new FinderPath(TTHC_AttributeModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_AttributeModelImpl.FINDER_CACHE_ENABLED,
			TTHC_AttributeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTTHCEntryAndGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TTHCENTRYANDGROUP =
		new FinderPath(TTHC_AttributeModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_AttributeModelImpl.FINDER_CACHE_ENABLED,
			TTHC_AttributeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTTHCEntryAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			TTHC_AttributeModelImpl.GROUPID_COLUMN_BITMASK |
			TTHC_AttributeModelImpl.TTHCENTRYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TTHCENTRYANDGROUP = new FinderPath(TTHC_AttributeModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_AttributeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTTHCEntryAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TTHCENTRYANDATTRIBUTETYPEANDCOMPANY =
		new FinderPath(TTHC_AttributeModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_AttributeModelImpl.FINDER_CACHE_ENABLED,
			TTHC_AttributeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTTHCEntryAndAttributeTypeAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TTHCENTRYANDATTRIBUTETYPEANDCOMPANY =
		new FinderPath(TTHC_AttributeModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_AttributeModelImpl.FINDER_CACHE_ENABLED,
			TTHC_AttributeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTTHCEntryAndAttributeTypeAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			TTHC_AttributeModelImpl.COMPANYID_COLUMN_BITMASK |
			TTHC_AttributeModelImpl.TTHCENTRYID_COLUMN_BITMASK |
			TTHC_AttributeModelImpl.ATTRIBUTETYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TTHCENTRYANDATTRIBUTETYPEANDCOMPANY =
		new FinderPath(TTHC_AttributeModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_AttributeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTTHCEntryAndAttributeTypeAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TTHCENTRYANDATTRIBUTETYPEANDGROUP =
		new FinderPath(TTHC_AttributeModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_AttributeModelImpl.FINDER_CACHE_ENABLED,
			TTHC_AttributeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTTHCEntryAndAttributeTypeAndGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TTHCENTRYANDATTRIBUTETYPEANDGROUP =
		new FinderPath(TTHC_AttributeModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_AttributeModelImpl.FINDER_CACHE_ENABLED,
			TTHC_AttributeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTTHCEntryAndAttributeTypeAndGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			TTHC_AttributeModelImpl.GROUPID_COLUMN_BITMASK |
			TTHC_AttributeModelImpl.TTHCENTRYID_COLUMN_BITMASK |
			TTHC_AttributeModelImpl.ATTRIBUTETYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TTHCENTRYANDATTRIBUTETYPEANDGROUP =
		new FinderPath(TTHC_AttributeModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_AttributeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTTHCEntryAndAttributeTypeAndGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TTHC_AttributeModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_AttributeModelImpl.FINDER_CACHE_ENABLED,
			TTHC_AttributeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TTHC_AttributeModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_AttributeModelImpl.FINDER_CACHE_ENABLED,
			TTHC_AttributeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TTHC_AttributeModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_AttributeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the t t h c_ attribute in the entity cache if it is enabled.
	 *
	 * @param tthc_Attribute the t t h c_ attribute
	 */
	public void cacheResult(TTHC_Attribute tthc_Attribute) {
		EntityCacheUtil.putResult(TTHC_AttributeModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_AttributeImpl.class, tthc_Attribute.getPrimaryKey(),
			tthc_Attribute);

		tthc_Attribute.resetOriginalValues();
	}

	/**
	 * Caches the t t h c_ attributes in the entity cache if it is enabled.
	 *
	 * @param tthc_Attributes the t t h c_ attributes
	 */
	public void cacheResult(List<TTHC_Attribute> tthc_Attributes) {
		for (TTHC_Attribute tthc_Attribute : tthc_Attributes) {
			if (EntityCacheUtil.getResult(
						TTHC_AttributeModelImpl.ENTITY_CACHE_ENABLED,
						TTHC_AttributeImpl.class, tthc_Attribute.getPrimaryKey()) == null) {
				cacheResult(tthc_Attribute);
			}
			else {
				tthc_Attribute.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all t t h c_ attributes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TTHC_AttributeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TTHC_AttributeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the t t h c_ attribute.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TTHC_Attribute tthc_Attribute) {
		EntityCacheUtil.removeResult(TTHC_AttributeModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_AttributeImpl.class, tthc_Attribute.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TTHC_Attribute> tthc_Attributes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TTHC_Attribute tthc_Attribute : tthc_Attributes) {
			EntityCacheUtil.removeResult(TTHC_AttributeModelImpl.ENTITY_CACHE_ENABLED,
				TTHC_AttributeImpl.class, tthc_Attribute.getPrimaryKey());
		}
	}

	/**
	 * Creates a new t t h c_ attribute with the primary key. Does not add the t t h c_ attribute to the database.
	 *
	 * @param attributeId the primary key for the new t t h c_ attribute
	 * @return the new t t h c_ attribute
	 */
	public TTHC_Attribute create(long attributeId) {
		TTHC_Attribute tthc_Attribute = new TTHC_AttributeImpl();

		tthc_Attribute.setNew(true);
		tthc_Attribute.setPrimaryKey(attributeId);

		return tthc_Attribute;
	}

	/**
	 * Removes the t t h c_ attribute with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attributeId the primary key of the t t h c_ attribute
	 * @return the t t h c_ attribute that was removed
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException if a t t h c_ attribute with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Attribute remove(long attributeId)
		throws NoSuchTTHC_AttributeException, SystemException {
		return remove(Long.valueOf(attributeId));
	}

	/**
	 * Removes the t t h c_ attribute with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the t t h c_ attribute
	 * @return the t t h c_ attribute that was removed
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException if a t t h c_ attribute with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TTHC_Attribute remove(Serializable primaryKey)
		throws NoSuchTTHC_AttributeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TTHC_Attribute tthc_Attribute = (TTHC_Attribute)session.get(TTHC_AttributeImpl.class,
					primaryKey);

			if (tthc_Attribute == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTTHC_AttributeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tthc_Attribute);
		}
		catch (NoSuchTTHC_AttributeException nsee) {
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
	protected TTHC_Attribute removeImpl(TTHC_Attribute tthc_Attribute)
		throws SystemException {
		tthc_Attribute = toUnwrappedModel(tthc_Attribute);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, tthc_Attribute);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(tthc_Attribute);

		return tthc_Attribute;
	}

	@Override
	public TTHC_Attribute updateImpl(
		com.portal_egov.portlet.tthc.model.TTHC_Attribute tthc_Attribute,
		boolean merge) throws SystemException {
		tthc_Attribute = toUnwrappedModel(tthc_Attribute);

		boolean isNew = tthc_Attribute.isNew();

		TTHC_AttributeModelImpl tthc_AttributeModelImpl = (TTHC_AttributeModelImpl)tthc_Attribute;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, tthc_Attribute, merge);

			tthc_Attribute.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TTHC_AttributeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((tthc_AttributeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TTHCENTRYANDCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(tthc_AttributeModelImpl.getOriginalCompanyId()),
						Long.valueOf(tthc_AttributeModelImpl.getOriginalTthcEntryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TTHCENTRYANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TTHCENTRYANDCOMPANY,
					args);

				args = new Object[] {
						Long.valueOf(tthc_AttributeModelImpl.getCompanyId()),
						Long.valueOf(tthc_AttributeModelImpl.getTthcEntryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TTHCENTRYANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TTHCENTRYANDCOMPANY,
					args);
			}

			if ((tthc_AttributeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TTHCENTRYANDGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(tthc_AttributeModelImpl.getOriginalGroupId()),
						Long.valueOf(tthc_AttributeModelImpl.getOriginalTthcEntryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TTHCENTRYANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TTHCENTRYANDGROUP,
					args);

				args = new Object[] {
						Long.valueOf(tthc_AttributeModelImpl.getGroupId()),
						Long.valueOf(tthc_AttributeModelImpl.getTthcEntryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TTHCENTRYANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TTHCENTRYANDGROUP,
					args);
			}

			if ((tthc_AttributeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TTHCENTRYANDATTRIBUTETYPEANDCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(tthc_AttributeModelImpl.getOriginalCompanyId()),
						Long.valueOf(tthc_AttributeModelImpl.getOriginalTthcEntryId()),
						Integer.valueOf(tthc_AttributeModelImpl.getOriginalAttributeTypeId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TTHCENTRYANDATTRIBUTETYPEANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TTHCENTRYANDATTRIBUTETYPEANDCOMPANY,
					args);

				args = new Object[] {
						Long.valueOf(tthc_AttributeModelImpl.getCompanyId()),
						Long.valueOf(tthc_AttributeModelImpl.getTthcEntryId()),
						Integer.valueOf(tthc_AttributeModelImpl.getAttributeTypeId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TTHCENTRYANDATTRIBUTETYPEANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TTHCENTRYANDATTRIBUTETYPEANDCOMPANY,
					args);
			}

			if ((tthc_AttributeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TTHCENTRYANDATTRIBUTETYPEANDGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(tthc_AttributeModelImpl.getOriginalGroupId()),
						Long.valueOf(tthc_AttributeModelImpl.getOriginalTthcEntryId()),
						Integer.valueOf(tthc_AttributeModelImpl.getOriginalAttributeTypeId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TTHCENTRYANDATTRIBUTETYPEANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TTHCENTRYANDATTRIBUTETYPEANDGROUP,
					args);

				args = new Object[] {
						Long.valueOf(tthc_AttributeModelImpl.getGroupId()),
						Long.valueOf(tthc_AttributeModelImpl.getTthcEntryId()),
						Integer.valueOf(tthc_AttributeModelImpl.getAttributeTypeId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TTHCENTRYANDATTRIBUTETYPEANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TTHCENTRYANDATTRIBUTETYPEANDGROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(TTHC_AttributeModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_AttributeImpl.class, tthc_Attribute.getPrimaryKey(),
			tthc_Attribute);

		return tthc_Attribute;
	}

	protected TTHC_Attribute toUnwrappedModel(TTHC_Attribute tthc_Attribute) {
		if (tthc_Attribute instanceof TTHC_AttributeImpl) {
			return tthc_Attribute;
		}

		TTHC_AttributeImpl tthc_AttributeImpl = new TTHC_AttributeImpl();

		tthc_AttributeImpl.setNew(tthc_Attribute.isNew());
		tthc_AttributeImpl.setPrimaryKey(tthc_Attribute.getPrimaryKey());

		tthc_AttributeImpl.setAttributeId(tthc_Attribute.getAttributeId());
		tthc_AttributeImpl.setCompanyId(tthc_Attribute.getCompanyId());
		tthc_AttributeImpl.setGroupId(tthc_Attribute.getGroupId());
		tthc_AttributeImpl.setUserId(tthc_Attribute.getUserId());
		tthc_AttributeImpl.setTthcEntryId(tthc_Attribute.getTthcEntryId());
		tthc_AttributeImpl.setAttributeTypeId(tthc_Attribute.getAttributeTypeId());
		tthc_AttributeImpl.setAttributeIndex(tthc_Attribute.getAttributeIndex());
		tthc_AttributeImpl.setAttributeName(tthc_Attribute.getAttributeName());
		tthc_AttributeImpl.setAttributeValue(tthc_Attribute.getAttributeValue());
		tthc_AttributeImpl.setCreateDate(tthc_Attribute.getCreateDate());
		tthc_AttributeImpl.setModifiedDate(tthc_Attribute.getModifiedDate());

		return tthc_AttributeImpl;
	}

	/**
	 * Returns the t t h c_ attribute with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the t t h c_ attribute
	 * @return the t t h c_ attribute
	 * @throws com.liferay.portal.NoSuchModelException if a t t h c_ attribute with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TTHC_Attribute findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the t t h c_ attribute with the primary key or throws a {@link com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException} if it could not be found.
	 *
	 * @param attributeId the primary key of the t t h c_ attribute
	 * @return the t t h c_ attribute
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException if a t t h c_ attribute with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Attribute findByPrimaryKey(long attributeId)
		throws NoSuchTTHC_AttributeException, SystemException {
		TTHC_Attribute tthc_Attribute = fetchByPrimaryKey(attributeId);

		if (tthc_Attribute == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + attributeId);
			}

			throw new NoSuchTTHC_AttributeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				attributeId);
		}

		return tthc_Attribute;
	}

	/**
	 * Returns the t t h c_ attribute with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the t t h c_ attribute
	 * @return the t t h c_ attribute, or <code>null</code> if a t t h c_ attribute with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TTHC_Attribute fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the t t h c_ attribute with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param attributeId the primary key of the t t h c_ attribute
	 * @return the t t h c_ attribute, or <code>null</code> if a t t h c_ attribute with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Attribute fetchByPrimaryKey(long attributeId)
		throws SystemException {
		TTHC_Attribute tthc_Attribute = (TTHC_Attribute)EntityCacheUtil.getResult(TTHC_AttributeModelImpl.ENTITY_CACHE_ENABLED,
				TTHC_AttributeImpl.class, attributeId);

		if (tthc_Attribute == _nullTTHC_Attribute) {
			return null;
		}

		if (tthc_Attribute == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				tthc_Attribute = (TTHC_Attribute)session.get(TTHC_AttributeImpl.class,
						Long.valueOf(attributeId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (tthc_Attribute != null) {
					cacheResult(tthc_Attribute);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(TTHC_AttributeModelImpl.ENTITY_CACHE_ENABLED,
						TTHC_AttributeImpl.class, attributeId,
						_nullTTHC_Attribute);
				}

				closeSession(session);
			}
		}

		return tthc_Attribute;
	}

	/**
	 * Returns all the t t h c_ attributes where companyId = &#63; and tthcEntryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param tthcEntryId the tthc entry ID
	 * @return the matching t t h c_ attributes
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Attribute> findByTTHCEntryAndCompany(long companyId,
		long tthcEntryId) throws SystemException {
		return findByTTHCEntryAndCompany(companyId, tthcEntryId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t t h c_ attributes where companyId = &#63; and tthcEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param tthcEntryId the tthc entry ID
	 * @param start the lower bound of the range of t t h c_ attributes
	 * @param end the upper bound of the range of t t h c_ attributes (not inclusive)
	 * @return the range of matching t t h c_ attributes
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Attribute> findByTTHCEntryAndCompany(long companyId,
		long tthcEntryId, int start, int end) throws SystemException {
		return findByTTHCEntryAndCompany(companyId, tthcEntryId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the t t h c_ attributes where companyId = &#63; and tthcEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param tthcEntryId the tthc entry ID
	 * @param start the lower bound of the range of t t h c_ attributes
	 * @param end the upper bound of the range of t t h c_ attributes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t t h c_ attributes
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Attribute> findByTTHCEntryAndCompany(long companyId,
		long tthcEntryId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TTHCENTRYANDCOMPANY;
			finderArgs = new Object[] { companyId, tthcEntryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TTHCENTRYANDCOMPANY;
			finderArgs = new Object[] {
					companyId, tthcEntryId,
					
					start, end, orderByComparator
				};
		}

		List<TTHC_Attribute> list = (List<TTHC_Attribute>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TTHC_Attribute tthc_Attribute : list) {
				if ((companyId != tthc_Attribute.getCompanyId()) ||
						(tthcEntryId != tthc_Attribute.getTthcEntryId())) {
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

			query.append(_SQL_SELECT_TTHC_ATTRIBUTE_WHERE);

			query.append(_FINDER_COLUMN_TTHCENTRYANDCOMPANY_COMPANYID_2);

			query.append(_FINDER_COLUMN_TTHCENTRYANDCOMPANY_TTHCENTRYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TTHC_AttributeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(tthcEntryId);

				list = (List<TTHC_Attribute>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first t t h c_ attribute in the ordered set where companyId = &#63; and tthcEntryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param tthcEntryId the tthc entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ attribute
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException if a matching t t h c_ attribute could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Attribute findByTTHCEntryAndCompany_First(long companyId,
		long tthcEntryId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_AttributeException, SystemException {
		TTHC_Attribute tthc_Attribute = fetchByTTHCEntryAndCompany_First(companyId,
				tthcEntryId, orderByComparator);

		if (tthc_Attribute != null) {
			return tthc_Attribute;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", tthcEntryId=");
		msg.append(tthcEntryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_AttributeException(msg.toString());
	}

	/**
	 * Returns the first t t h c_ attribute in the ordered set where companyId = &#63; and tthcEntryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param tthcEntryId the tthc entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ attribute, or <code>null</code> if a matching t t h c_ attribute could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Attribute fetchByTTHCEntryAndCompany_First(long companyId,
		long tthcEntryId, OrderByComparator orderByComparator)
		throws SystemException {
		List<TTHC_Attribute> list = findByTTHCEntryAndCompany(companyId,
				tthcEntryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last t t h c_ attribute in the ordered set where companyId = &#63; and tthcEntryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param tthcEntryId the tthc entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ attribute
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException if a matching t t h c_ attribute could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Attribute findByTTHCEntryAndCompany_Last(long companyId,
		long tthcEntryId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_AttributeException, SystemException {
		TTHC_Attribute tthc_Attribute = fetchByTTHCEntryAndCompany_Last(companyId,
				tthcEntryId, orderByComparator);

		if (tthc_Attribute != null) {
			return tthc_Attribute;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", tthcEntryId=");
		msg.append(tthcEntryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_AttributeException(msg.toString());
	}

	/**
	 * Returns the last t t h c_ attribute in the ordered set where companyId = &#63; and tthcEntryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param tthcEntryId the tthc entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ attribute, or <code>null</code> if a matching t t h c_ attribute could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Attribute fetchByTTHCEntryAndCompany_Last(long companyId,
		long tthcEntryId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByTTHCEntryAndCompany(companyId, tthcEntryId);

		List<TTHC_Attribute> list = findByTTHCEntryAndCompany(companyId,
				tthcEntryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the t t h c_ attributes before and after the current t t h c_ attribute in the ordered set where companyId = &#63; and tthcEntryId = &#63;.
	 *
	 * @param attributeId the primary key of the current t t h c_ attribute
	 * @param companyId the company ID
	 * @param tthcEntryId the tthc entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t t h c_ attribute
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException if a t t h c_ attribute with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Attribute[] findByTTHCEntryAndCompany_PrevAndNext(
		long attributeId, long companyId, long tthcEntryId,
		OrderByComparator orderByComparator)
		throws NoSuchTTHC_AttributeException, SystemException {
		TTHC_Attribute tthc_Attribute = findByPrimaryKey(attributeId);

		Session session = null;

		try {
			session = openSession();

			TTHC_Attribute[] array = new TTHC_AttributeImpl[3];

			array[0] = getByTTHCEntryAndCompany_PrevAndNext(session,
					tthc_Attribute, companyId, tthcEntryId, orderByComparator,
					true);

			array[1] = tthc_Attribute;

			array[2] = getByTTHCEntryAndCompany_PrevAndNext(session,
					tthc_Attribute, companyId, tthcEntryId, orderByComparator,
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

	protected TTHC_Attribute getByTTHCEntryAndCompany_PrevAndNext(
		Session session, TTHC_Attribute tthc_Attribute, long companyId,
		long tthcEntryId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TTHC_ATTRIBUTE_WHERE);

		query.append(_FINDER_COLUMN_TTHCENTRYANDCOMPANY_COMPANYID_2);

		query.append(_FINDER_COLUMN_TTHCENTRYANDCOMPANY_TTHCENTRYID_2);

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
			query.append(TTHC_AttributeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(tthcEntryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tthc_Attribute);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTHC_Attribute> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t t h c_ attributes where groupId = &#63; and tthcEntryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param tthcEntryId the tthc entry ID
	 * @return the matching t t h c_ attributes
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Attribute> findByTTHCEntryAndGroup(long groupId,
		long tthcEntryId) throws SystemException {
		return findByTTHCEntryAndGroup(groupId, tthcEntryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t t h c_ attributes where groupId = &#63; and tthcEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param tthcEntryId the tthc entry ID
	 * @param start the lower bound of the range of t t h c_ attributes
	 * @param end the upper bound of the range of t t h c_ attributes (not inclusive)
	 * @return the range of matching t t h c_ attributes
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Attribute> findByTTHCEntryAndGroup(long groupId,
		long tthcEntryId, int start, int end) throws SystemException {
		return findByTTHCEntryAndGroup(groupId, tthcEntryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the t t h c_ attributes where groupId = &#63; and tthcEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param tthcEntryId the tthc entry ID
	 * @param start the lower bound of the range of t t h c_ attributes
	 * @param end the upper bound of the range of t t h c_ attributes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t t h c_ attributes
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Attribute> findByTTHCEntryAndGroup(long groupId,
		long tthcEntryId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TTHCENTRYANDGROUP;
			finderArgs = new Object[] { groupId, tthcEntryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TTHCENTRYANDGROUP;
			finderArgs = new Object[] {
					groupId, tthcEntryId,
					
					start, end, orderByComparator
				};
		}

		List<TTHC_Attribute> list = (List<TTHC_Attribute>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TTHC_Attribute tthc_Attribute : list) {
				if ((groupId != tthc_Attribute.getGroupId()) ||
						(tthcEntryId != tthc_Attribute.getTthcEntryId())) {
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

			query.append(_SQL_SELECT_TTHC_ATTRIBUTE_WHERE);

			query.append(_FINDER_COLUMN_TTHCENTRYANDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_TTHCENTRYANDGROUP_TTHCENTRYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TTHC_AttributeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(tthcEntryId);

				list = (List<TTHC_Attribute>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first t t h c_ attribute in the ordered set where groupId = &#63; and tthcEntryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param tthcEntryId the tthc entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ attribute
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException if a matching t t h c_ attribute could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Attribute findByTTHCEntryAndGroup_First(long groupId,
		long tthcEntryId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_AttributeException, SystemException {
		TTHC_Attribute tthc_Attribute = fetchByTTHCEntryAndGroup_First(groupId,
				tthcEntryId, orderByComparator);

		if (tthc_Attribute != null) {
			return tthc_Attribute;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", tthcEntryId=");
		msg.append(tthcEntryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_AttributeException(msg.toString());
	}

	/**
	 * Returns the first t t h c_ attribute in the ordered set where groupId = &#63; and tthcEntryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param tthcEntryId the tthc entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ attribute, or <code>null</code> if a matching t t h c_ attribute could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Attribute fetchByTTHCEntryAndGroup_First(long groupId,
		long tthcEntryId, OrderByComparator orderByComparator)
		throws SystemException {
		List<TTHC_Attribute> list = findByTTHCEntryAndGroup(groupId,
				tthcEntryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last t t h c_ attribute in the ordered set where groupId = &#63; and tthcEntryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param tthcEntryId the tthc entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ attribute
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException if a matching t t h c_ attribute could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Attribute findByTTHCEntryAndGroup_Last(long groupId,
		long tthcEntryId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_AttributeException, SystemException {
		TTHC_Attribute tthc_Attribute = fetchByTTHCEntryAndGroup_Last(groupId,
				tthcEntryId, orderByComparator);

		if (tthc_Attribute != null) {
			return tthc_Attribute;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", tthcEntryId=");
		msg.append(tthcEntryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_AttributeException(msg.toString());
	}

	/**
	 * Returns the last t t h c_ attribute in the ordered set where groupId = &#63; and tthcEntryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param tthcEntryId the tthc entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ attribute, or <code>null</code> if a matching t t h c_ attribute could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Attribute fetchByTTHCEntryAndGroup_Last(long groupId,
		long tthcEntryId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByTTHCEntryAndGroup(groupId, tthcEntryId);

		List<TTHC_Attribute> list = findByTTHCEntryAndGroup(groupId,
				tthcEntryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the t t h c_ attributes before and after the current t t h c_ attribute in the ordered set where groupId = &#63; and tthcEntryId = &#63;.
	 *
	 * @param attributeId the primary key of the current t t h c_ attribute
	 * @param groupId the group ID
	 * @param tthcEntryId the tthc entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t t h c_ attribute
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException if a t t h c_ attribute with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Attribute[] findByTTHCEntryAndGroup_PrevAndNext(
		long attributeId, long groupId, long tthcEntryId,
		OrderByComparator orderByComparator)
		throws NoSuchTTHC_AttributeException, SystemException {
		TTHC_Attribute tthc_Attribute = findByPrimaryKey(attributeId);

		Session session = null;

		try {
			session = openSession();

			TTHC_Attribute[] array = new TTHC_AttributeImpl[3];

			array[0] = getByTTHCEntryAndGroup_PrevAndNext(session,
					tthc_Attribute, groupId, tthcEntryId, orderByComparator,
					true);

			array[1] = tthc_Attribute;

			array[2] = getByTTHCEntryAndGroup_PrevAndNext(session,
					tthc_Attribute, groupId, tthcEntryId, orderByComparator,
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

	protected TTHC_Attribute getByTTHCEntryAndGroup_PrevAndNext(
		Session session, TTHC_Attribute tthc_Attribute, long groupId,
		long tthcEntryId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TTHC_ATTRIBUTE_WHERE);

		query.append(_FINDER_COLUMN_TTHCENTRYANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_TTHCENTRYANDGROUP_TTHCENTRYID_2);

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
			query.append(TTHC_AttributeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(tthcEntryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tthc_Attribute);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTHC_Attribute> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t t h c_ attributes that the user has permission to view where groupId = &#63; and tthcEntryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param tthcEntryId the tthc entry ID
	 * @return the matching t t h c_ attributes that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Attribute> filterFindByTTHCEntryAndGroup(long groupId,
		long tthcEntryId) throws SystemException {
		return filterFindByTTHCEntryAndGroup(groupId, tthcEntryId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t t h c_ attributes that the user has permission to view where groupId = &#63; and tthcEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param tthcEntryId the tthc entry ID
	 * @param start the lower bound of the range of t t h c_ attributes
	 * @param end the upper bound of the range of t t h c_ attributes (not inclusive)
	 * @return the range of matching t t h c_ attributes that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Attribute> filterFindByTTHCEntryAndGroup(long groupId,
		long tthcEntryId, int start, int end) throws SystemException {
		return filterFindByTTHCEntryAndGroup(groupId, tthcEntryId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the t t h c_ attributes that the user has permissions to view where groupId = &#63; and tthcEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param tthcEntryId the tthc entry ID
	 * @param start the lower bound of the range of t t h c_ attributes
	 * @param end the upper bound of the range of t t h c_ attributes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t t h c_ attributes that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Attribute> filterFindByTTHCEntryAndGroup(long groupId,
		long tthcEntryId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByTTHCEntryAndGroup(groupId, tthcEntryId, start, end,
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
			query.append(_FILTER_SQL_SELECT_TTHC_ATTRIBUTE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TTHC_ATTRIBUTE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_TTHCENTRYANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_TTHCENTRYANDGROUP_TTHCENTRYID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TTHC_ATTRIBUTE_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(TTHC_AttributeModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TTHC_AttributeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TTHC_Attribute.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, TTHC_AttributeImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, TTHC_AttributeImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(tthcEntryId);

			return (List<TTHC_Attribute>)QueryUtil.list(q, getDialect(), start,
				end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the t t h c_ attributes before and after the current t t h c_ attribute in the ordered set of t t h c_ attributes that the user has permission to view where groupId = &#63; and tthcEntryId = &#63;.
	 *
	 * @param attributeId the primary key of the current t t h c_ attribute
	 * @param groupId the group ID
	 * @param tthcEntryId the tthc entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t t h c_ attribute
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException if a t t h c_ attribute with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Attribute[] filterFindByTTHCEntryAndGroup_PrevAndNext(
		long attributeId, long groupId, long tthcEntryId,
		OrderByComparator orderByComparator)
		throws NoSuchTTHC_AttributeException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByTTHCEntryAndGroup_PrevAndNext(attributeId, groupId,
				tthcEntryId, orderByComparator);
		}

		TTHC_Attribute tthc_Attribute = findByPrimaryKey(attributeId);

		Session session = null;

		try {
			session = openSession();

			TTHC_Attribute[] array = new TTHC_AttributeImpl[3];

			array[0] = filterGetByTTHCEntryAndGroup_PrevAndNext(session,
					tthc_Attribute, groupId, tthcEntryId, orderByComparator,
					true);

			array[1] = tthc_Attribute;

			array[2] = filterGetByTTHCEntryAndGroup_PrevAndNext(session,
					tthc_Attribute, groupId, tthcEntryId, orderByComparator,
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

	protected TTHC_Attribute filterGetByTTHCEntryAndGroup_PrevAndNext(
		Session session, TTHC_Attribute tthc_Attribute, long groupId,
		long tthcEntryId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TTHC_ATTRIBUTE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TTHC_ATTRIBUTE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_TTHCENTRYANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_TTHCENTRYANDGROUP_TTHCENTRYID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TTHC_ATTRIBUTE_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(TTHC_AttributeModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TTHC_AttributeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TTHC_Attribute.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, TTHC_AttributeImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, TTHC_AttributeImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(tthcEntryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tthc_Attribute);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTHC_Attribute> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t t h c_ attributes where companyId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param tthcEntryId the tthc entry ID
	 * @param attributeTypeId the attribute type ID
	 * @return the matching t t h c_ attributes
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Attribute> findByTTHCEntryAndAttributeTypeAndCompany(
		long companyId, long tthcEntryId, int attributeTypeId)
		throws SystemException {
		return findByTTHCEntryAndAttributeTypeAndCompany(companyId,
			tthcEntryId, attributeTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the t t h c_ attributes where companyId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param tthcEntryId the tthc entry ID
	 * @param attributeTypeId the attribute type ID
	 * @param start the lower bound of the range of t t h c_ attributes
	 * @param end the upper bound of the range of t t h c_ attributes (not inclusive)
	 * @return the range of matching t t h c_ attributes
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Attribute> findByTTHCEntryAndAttributeTypeAndCompany(
		long companyId, long tthcEntryId, int attributeTypeId, int start,
		int end) throws SystemException {
		return findByTTHCEntryAndAttributeTypeAndCompany(companyId,
			tthcEntryId, attributeTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the t t h c_ attributes where companyId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param tthcEntryId the tthc entry ID
	 * @param attributeTypeId the attribute type ID
	 * @param start the lower bound of the range of t t h c_ attributes
	 * @param end the upper bound of the range of t t h c_ attributes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t t h c_ attributes
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Attribute> findByTTHCEntryAndAttributeTypeAndCompany(
		long companyId, long tthcEntryId, int attributeTypeId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TTHCENTRYANDATTRIBUTETYPEANDCOMPANY;
			finderArgs = new Object[] { companyId, tthcEntryId, attributeTypeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TTHCENTRYANDATTRIBUTETYPEANDCOMPANY;
			finderArgs = new Object[] {
					companyId, tthcEntryId, attributeTypeId,
					
					start, end, orderByComparator
				};
		}

		List<TTHC_Attribute> list = (List<TTHC_Attribute>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TTHC_Attribute tthc_Attribute : list) {
				if ((companyId != tthc_Attribute.getCompanyId()) ||
						(tthcEntryId != tthc_Attribute.getTthcEntryId()) ||
						(attributeTypeId != tthc_Attribute.getAttributeTypeId())) {
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

			query.append(_SQL_SELECT_TTHC_ATTRIBUTE_WHERE);

			query.append(_FINDER_COLUMN_TTHCENTRYANDATTRIBUTETYPEANDCOMPANY_COMPANYID_2);

			query.append(_FINDER_COLUMN_TTHCENTRYANDATTRIBUTETYPEANDCOMPANY_TTHCENTRYID_2);

			query.append(_FINDER_COLUMN_TTHCENTRYANDATTRIBUTETYPEANDCOMPANY_ATTRIBUTETYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TTHC_AttributeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(tthcEntryId);

				qPos.add(attributeTypeId);

				list = (List<TTHC_Attribute>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first t t h c_ attribute in the ordered set where companyId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param tthcEntryId the tthc entry ID
	 * @param attributeTypeId the attribute type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ attribute
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException if a matching t t h c_ attribute could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Attribute findByTTHCEntryAndAttributeTypeAndCompany_First(
		long companyId, long tthcEntryId, int attributeTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchTTHC_AttributeException, SystemException {
		TTHC_Attribute tthc_Attribute = fetchByTTHCEntryAndAttributeTypeAndCompany_First(companyId,
				tthcEntryId, attributeTypeId, orderByComparator);

		if (tthc_Attribute != null) {
			return tthc_Attribute;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", tthcEntryId=");
		msg.append(tthcEntryId);

		msg.append(", attributeTypeId=");
		msg.append(attributeTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_AttributeException(msg.toString());
	}

	/**
	 * Returns the first t t h c_ attribute in the ordered set where companyId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param tthcEntryId the tthc entry ID
	 * @param attributeTypeId the attribute type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ attribute, or <code>null</code> if a matching t t h c_ attribute could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Attribute fetchByTTHCEntryAndAttributeTypeAndCompany_First(
		long companyId, long tthcEntryId, int attributeTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TTHC_Attribute> list = findByTTHCEntryAndAttributeTypeAndCompany(companyId,
				tthcEntryId, attributeTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last t t h c_ attribute in the ordered set where companyId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param tthcEntryId the tthc entry ID
	 * @param attributeTypeId the attribute type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ attribute
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException if a matching t t h c_ attribute could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Attribute findByTTHCEntryAndAttributeTypeAndCompany_Last(
		long companyId, long tthcEntryId, int attributeTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchTTHC_AttributeException, SystemException {
		TTHC_Attribute tthc_Attribute = fetchByTTHCEntryAndAttributeTypeAndCompany_Last(companyId,
				tthcEntryId, attributeTypeId, orderByComparator);

		if (tthc_Attribute != null) {
			return tthc_Attribute;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", tthcEntryId=");
		msg.append(tthcEntryId);

		msg.append(", attributeTypeId=");
		msg.append(attributeTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_AttributeException(msg.toString());
	}

	/**
	 * Returns the last t t h c_ attribute in the ordered set where companyId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param tthcEntryId the tthc entry ID
	 * @param attributeTypeId the attribute type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ attribute, or <code>null</code> if a matching t t h c_ attribute could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Attribute fetchByTTHCEntryAndAttributeTypeAndCompany_Last(
		long companyId, long tthcEntryId, int attributeTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTTHCEntryAndAttributeTypeAndCompany(companyId,
				tthcEntryId, attributeTypeId);

		List<TTHC_Attribute> list = findByTTHCEntryAndAttributeTypeAndCompany(companyId,
				tthcEntryId, attributeTypeId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the t t h c_ attributes before and after the current t t h c_ attribute in the ordered set where companyId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	 *
	 * @param attributeId the primary key of the current t t h c_ attribute
	 * @param companyId the company ID
	 * @param tthcEntryId the tthc entry ID
	 * @param attributeTypeId the attribute type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t t h c_ attribute
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException if a t t h c_ attribute with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Attribute[] findByTTHCEntryAndAttributeTypeAndCompany_PrevAndNext(
		long attributeId, long companyId, long tthcEntryId,
		int attributeTypeId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_AttributeException, SystemException {
		TTHC_Attribute tthc_Attribute = findByPrimaryKey(attributeId);

		Session session = null;

		try {
			session = openSession();

			TTHC_Attribute[] array = new TTHC_AttributeImpl[3];

			array[0] = getByTTHCEntryAndAttributeTypeAndCompany_PrevAndNext(session,
					tthc_Attribute, companyId, tthcEntryId, attributeTypeId,
					orderByComparator, true);

			array[1] = tthc_Attribute;

			array[2] = getByTTHCEntryAndAttributeTypeAndCompany_PrevAndNext(session,
					tthc_Attribute, companyId, tthcEntryId, attributeTypeId,
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

	protected TTHC_Attribute getByTTHCEntryAndAttributeTypeAndCompany_PrevAndNext(
		Session session, TTHC_Attribute tthc_Attribute, long companyId,
		long tthcEntryId, int attributeTypeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TTHC_ATTRIBUTE_WHERE);

		query.append(_FINDER_COLUMN_TTHCENTRYANDATTRIBUTETYPEANDCOMPANY_COMPANYID_2);

		query.append(_FINDER_COLUMN_TTHCENTRYANDATTRIBUTETYPEANDCOMPANY_TTHCENTRYID_2);

		query.append(_FINDER_COLUMN_TTHCENTRYANDATTRIBUTETYPEANDCOMPANY_ATTRIBUTETYPEID_2);

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
			query.append(TTHC_AttributeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(tthcEntryId);

		qPos.add(attributeTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tthc_Attribute);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTHC_Attribute> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t t h c_ attributes where groupId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param tthcEntryId the tthc entry ID
	 * @param attributeTypeId the attribute type ID
	 * @return the matching t t h c_ attributes
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Attribute> findByTTHCEntryAndAttributeTypeAndGroup(
		long groupId, long tthcEntryId, int attributeTypeId)
		throws SystemException {
		return findByTTHCEntryAndAttributeTypeAndGroup(groupId, tthcEntryId,
			attributeTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t t h c_ attributes where groupId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param tthcEntryId the tthc entry ID
	 * @param attributeTypeId the attribute type ID
	 * @param start the lower bound of the range of t t h c_ attributes
	 * @param end the upper bound of the range of t t h c_ attributes (not inclusive)
	 * @return the range of matching t t h c_ attributes
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Attribute> findByTTHCEntryAndAttributeTypeAndGroup(
		long groupId, long tthcEntryId, int attributeTypeId, int start, int end)
		throws SystemException {
		return findByTTHCEntryAndAttributeTypeAndGroup(groupId, tthcEntryId,
			attributeTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the t t h c_ attributes where groupId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param tthcEntryId the tthc entry ID
	 * @param attributeTypeId the attribute type ID
	 * @param start the lower bound of the range of t t h c_ attributes
	 * @param end the upper bound of the range of t t h c_ attributes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t t h c_ attributes
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Attribute> findByTTHCEntryAndAttributeTypeAndGroup(
		long groupId, long tthcEntryId, int attributeTypeId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TTHCENTRYANDATTRIBUTETYPEANDGROUP;
			finderArgs = new Object[] { groupId, tthcEntryId, attributeTypeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TTHCENTRYANDATTRIBUTETYPEANDGROUP;
			finderArgs = new Object[] {
					groupId, tthcEntryId, attributeTypeId,
					
					start, end, orderByComparator
				};
		}

		List<TTHC_Attribute> list = (List<TTHC_Attribute>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TTHC_Attribute tthc_Attribute : list) {
				if ((groupId != tthc_Attribute.getGroupId()) ||
						(tthcEntryId != tthc_Attribute.getTthcEntryId()) ||
						(attributeTypeId != tthc_Attribute.getAttributeTypeId())) {
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

			query.append(_SQL_SELECT_TTHC_ATTRIBUTE_WHERE);

			query.append(_FINDER_COLUMN_TTHCENTRYANDATTRIBUTETYPEANDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_TTHCENTRYANDATTRIBUTETYPEANDGROUP_TTHCENTRYID_2);

			query.append(_FINDER_COLUMN_TTHCENTRYANDATTRIBUTETYPEANDGROUP_ATTRIBUTETYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TTHC_AttributeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(tthcEntryId);

				qPos.add(attributeTypeId);

				list = (List<TTHC_Attribute>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first t t h c_ attribute in the ordered set where groupId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param tthcEntryId the tthc entry ID
	 * @param attributeTypeId the attribute type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ attribute
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException if a matching t t h c_ attribute could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Attribute findByTTHCEntryAndAttributeTypeAndGroup_First(
		long groupId, long tthcEntryId, int attributeTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchTTHC_AttributeException, SystemException {
		TTHC_Attribute tthc_Attribute = fetchByTTHCEntryAndAttributeTypeAndGroup_First(groupId,
				tthcEntryId, attributeTypeId, orderByComparator);

		if (tthc_Attribute != null) {
			return tthc_Attribute;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", tthcEntryId=");
		msg.append(tthcEntryId);

		msg.append(", attributeTypeId=");
		msg.append(attributeTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_AttributeException(msg.toString());
	}

	/**
	 * Returns the first t t h c_ attribute in the ordered set where groupId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param tthcEntryId the tthc entry ID
	 * @param attributeTypeId the attribute type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ attribute, or <code>null</code> if a matching t t h c_ attribute could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Attribute fetchByTTHCEntryAndAttributeTypeAndGroup_First(
		long groupId, long tthcEntryId, int attributeTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TTHC_Attribute> list = findByTTHCEntryAndAttributeTypeAndGroup(groupId,
				tthcEntryId, attributeTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last t t h c_ attribute in the ordered set where groupId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param tthcEntryId the tthc entry ID
	 * @param attributeTypeId the attribute type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ attribute
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException if a matching t t h c_ attribute could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Attribute findByTTHCEntryAndAttributeTypeAndGroup_Last(
		long groupId, long tthcEntryId, int attributeTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchTTHC_AttributeException, SystemException {
		TTHC_Attribute tthc_Attribute = fetchByTTHCEntryAndAttributeTypeAndGroup_Last(groupId,
				tthcEntryId, attributeTypeId, orderByComparator);

		if (tthc_Attribute != null) {
			return tthc_Attribute;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", tthcEntryId=");
		msg.append(tthcEntryId);

		msg.append(", attributeTypeId=");
		msg.append(attributeTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_AttributeException(msg.toString());
	}

	/**
	 * Returns the last t t h c_ attribute in the ordered set where groupId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param tthcEntryId the tthc entry ID
	 * @param attributeTypeId the attribute type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ attribute, or <code>null</code> if a matching t t h c_ attribute could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Attribute fetchByTTHCEntryAndAttributeTypeAndGroup_Last(
		long groupId, long tthcEntryId, int attributeTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTTHCEntryAndAttributeTypeAndGroup(groupId,
				tthcEntryId, attributeTypeId);

		List<TTHC_Attribute> list = findByTTHCEntryAndAttributeTypeAndGroup(groupId,
				tthcEntryId, attributeTypeId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the t t h c_ attributes before and after the current t t h c_ attribute in the ordered set where groupId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	 *
	 * @param attributeId the primary key of the current t t h c_ attribute
	 * @param groupId the group ID
	 * @param tthcEntryId the tthc entry ID
	 * @param attributeTypeId the attribute type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t t h c_ attribute
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException if a t t h c_ attribute with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Attribute[] findByTTHCEntryAndAttributeTypeAndGroup_PrevAndNext(
		long attributeId, long groupId, long tthcEntryId, int attributeTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchTTHC_AttributeException, SystemException {
		TTHC_Attribute tthc_Attribute = findByPrimaryKey(attributeId);

		Session session = null;

		try {
			session = openSession();

			TTHC_Attribute[] array = new TTHC_AttributeImpl[3];

			array[0] = getByTTHCEntryAndAttributeTypeAndGroup_PrevAndNext(session,
					tthc_Attribute, groupId, tthcEntryId, attributeTypeId,
					orderByComparator, true);

			array[1] = tthc_Attribute;

			array[2] = getByTTHCEntryAndAttributeTypeAndGroup_PrevAndNext(session,
					tthc_Attribute, groupId, tthcEntryId, attributeTypeId,
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

	protected TTHC_Attribute getByTTHCEntryAndAttributeTypeAndGroup_PrevAndNext(
		Session session, TTHC_Attribute tthc_Attribute, long groupId,
		long tthcEntryId, int attributeTypeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TTHC_ATTRIBUTE_WHERE);

		query.append(_FINDER_COLUMN_TTHCENTRYANDATTRIBUTETYPEANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_TTHCENTRYANDATTRIBUTETYPEANDGROUP_TTHCENTRYID_2);

		query.append(_FINDER_COLUMN_TTHCENTRYANDATTRIBUTETYPEANDGROUP_ATTRIBUTETYPEID_2);

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
			query.append(TTHC_AttributeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(tthcEntryId);

		qPos.add(attributeTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tthc_Attribute);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTHC_Attribute> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t t h c_ attributes that the user has permission to view where groupId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param tthcEntryId the tthc entry ID
	 * @param attributeTypeId the attribute type ID
	 * @return the matching t t h c_ attributes that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Attribute> filterFindByTTHCEntryAndAttributeTypeAndGroup(
		long groupId, long tthcEntryId, int attributeTypeId)
		throws SystemException {
		return filterFindByTTHCEntryAndAttributeTypeAndGroup(groupId,
			tthcEntryId, attributeTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the t t h c_ attributes that the user has permission to view where groupId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param tthcEntryId the tthc entry ID
	 * @param attributeTypeId the attribute type ID
	 * @param start the lower bound of the range of t t h c_ attributes
	 * @param end the upper bound of the range of t t h c_ attributes (not inclusive)
	 * @return the range of matching t t h c_ attributes that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Attribute> filterFindByTTHCEntryAndAttributeTypeAndGroup(
		long groupId, long tthcEntryId, int attributeTypeId, int start, int end)
		throws SystemException {
		return filterFindByTTHCEntryAndAttributeTypeAndGroup(groupId,
			tthcEntryId, attributeTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the t t h c_ attributes that the user has permissions to view where groupId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param tthcEntryId the tthc entry ID
	 * @param attributeTypeId the attribute type ID
	 * @param start the lower bound of the range of t t h c_ attributes
	 * @param end the upper bound of the range of t t h c_ attributes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t t h c_ attributes that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Attribute> filterFindByTTHCEntryAndAttributeTypeAndGroup(
		long groupId, long tthcEntryId, int attributeTypeId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByTTHCEntryAndAttributeTypeAndGroup(groupId,
				tthcEntryId, attributeTypeId, start, end, orderByComparator);
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
			query.append(_FILTER_SQL_SELECT_TTHC_ATTRIBUTE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TTHC_ATTRIBUTE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_TTHCENTRYANDATTRIBUTETYPEANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_TTHCENTRYANDATTRIBUTETYPEANDGROUP_TTHCENTRYID_2);

		query.append(_FINDER_COLUMN_TTHCENTRYANDATTRIBUTETYPEANDGROUP_ATTRIBUTETYPEID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TTHC_ATTRIBUTE_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(TTHC_AttributeModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TTHC_AttributeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TTHC_Attribute.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, TTHC_AttributeImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, TTHC_AttributeImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(tthcEntryId);

			qPos.add(attributeTypeId);

			return (List<TTHC_Attribute>)QueryUtil.list(q, getDialect(), start,
				end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the t t h c_ attributes before and after the current t t h c_ attribute in the ordered set of t t h c_ attributes that the user has permission to view where groupId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	 *
	 * @param attributeId the primary key of the current t t h c_ attribute
	 * @param groupId the group ID
	 * @param tthcEntryId the tthc entry ID
	 * @param attributeTypeId the attribute type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t t h c_ attribute
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException if a t t h c_ attribute with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Attribute[] filterFindByTTHCEntryAndAttributeTypeAndGroup_PrevAndNext(
		long attributeId, long groupId, long tthcEntryId, int attributeTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchTTHC_AttributeException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByTTHCEntryAndAttributeTypeAndGroup_PrevAndNext(attributeId,
				groupId, tthcEntryId, attributeTypeId, orderByComparator);
		}

		TTHC_Attribute tthc_Attribute = findByPrimaryKey(attributeId);

		Session session = null;

		try {
			session = openSession();

			TTHC_Attribute[] array = new TTHC_AttributeImpl[3];

			array[0] = filterGetByTTHCEntryAndAttributeTypeAndGroup_PrevAndNext(session,
					tthc_Attribute, groupId, tthcEntryId, attributeTypeId,
					orderByComparator, true);

			array[1] = tthc_Attribute;

			array[2] = filterGetByTTHCEntryAndAttributeTypeAndGroup_PrevAndNext(session,
					tthc_Attribute, groupId, tthcEntryId, attributeTypeId,
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

	protected TTHC_Attribute filterGetByTTHCEntryAndAttributeTypeAndGroup_PrevAndNext(
		Session session, TTHC_Attribute tthc_Attribute, long groupId,
		long tthcEntryId, int attributeTypeId,
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
			query.append(_FILTER_SQL_SELECT_TTHC_ATTRIBUTE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TTHC_ATTRIBUTE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_TTHCENTRYANDATTRIBUTETYPEANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_TTHCENTRYANDATTRIBUTETYPEANDGROUP_TTHCENTRYID_2);

		query.append(_FINDER_COLUMN_TTHCENTRYANDATTRIBUTETYPEANDGROUP_ATTRIBUTETYPEID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TTHC_ATTRIBUTE_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(TTHC_AttributeModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TTHC_AttributeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TTHC_Attribute.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, TTHC_AttributeImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, TTHC_AttributeImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(tthcEntryId);

		qPos.add(attributeTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tthc_Attribute);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTHC_Attribute> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t t h c_ attributes.
	 *
	 * @return the t t h c_ attributes
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Attribute> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t t h c_ attributes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of t t h c_ attributes
	 * @param end the upper bound of the range of t t h c_ attributes (not inclusive)
	 * @return the range of t t h c_ attributes
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Attribute> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the t t h c_ attributes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of t t h c_ attributes
	 * @param end the upper bound of the range of t t h c_ attributes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of t t h c_ attributes
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Attribute> findAll(int start, int end,
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

		List<TTHC_Attribute> list = (List<TTHC_Attribute>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TTHC_ATTRIBUTE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TTHC_ATTRIBUTE.concat(TTHC_AttributeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<TTHC_Attribute>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<TTHC_Attribute>)QueryUtil.list(q,
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
	 * Removes all the t t h c_ attributes where companyId = &#63; and tthcEntryId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param tthcEntryId the tthc entry ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTTHCEntryAndCompany(long companyId, long tthcEntryId)
		throws SystemException {
		for (TTHC_Attribute tthc_Attribute : findByTTHCEntryAndCompany(
				companyId, tthcEntryId)) {
			remove(tthc_Attribute);
		}
	}

	/**
	 * Removes all the t t h c_ attributes where groupId = &#63; and tthcEntryId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param tthcEntryId the tthc entry ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTTHCEntryAndGroup(long groupId, long tthcEntryId)
		throws SystemException {
		for (TTHC_Attribute tthc_Attribute : findByTTHCEntryAndGroup(groupId,
				tthcEntryId)) {
			remove(tthc_Attribute);
		}
	}

	/**
	 * Removes all the t t h c_ attributes where companyId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param tthcEntryId the tthc entry ID
	 * @param attributeTypeId the attribute type ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTTHCEntryAndAttributeTypeAndCompany(long companyId,
		long tthcEntryId, int attributeTypeId) throws SystemException {
		for (TTHC_Attribute tthc_Attribute : findByTTHCEntryAndAttributeTypeAndCompany(
				companyId, tthcEntryId, attributeTypeId)) {
			remove(tthc_Attribute);
		}
	}

	/**
	 * Removes all the t t h c_ attributes where groupId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param tthcEntryId the tthc entry ID
	 * @param attributeTypeId the attribute type ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTTHCEntryAndAttributeTypeAndGroup(long groupId,
		long tthcEntryId, int attributeTypeId) throws SystemException {
		for (TTHC_Attribute tthc_Attribute : findByTTHCEntryAndAttributeTypeAndGroup(
				groupId, tthcEntryId, attributeTypeId)) {
			remove(tthc_Attribute);
		}
	}

	/**
	 * Removes all the t t h c_ attributes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (TTHC_Attribute tthc_Attribute : findAll()) {
			remove(tthc_Attribute);
		}
	}

	/**
	 * Returns the number of t t h c_ attributes where companyId = &#63; and tthcEntryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param tthcEntryId the tthc entry ID
	 * @return the number of matching t t h c_ attributes
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTTHCEntryAndCompany(long companyId, long tthcEntryId)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, tthcEntryId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TTHCENTRYANDCOMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TTHC_ATTRIBUTE_WHERE);

			query.append(_FINDER_COLUMN_TTHCENTRYANDCOMPANY_COMPANYID_2);

			query.append(_FINDER_COLUMN_TTHCENTRYANDCOMPANY_TTHCENTRYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(tthcEntryId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TTHCENTRYANDCOMPANY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of t t h c_ attributes where groupId = &#63; and tthcEntryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param tthcEntryId the tthc entry ID
	 * @return the number of matching t t h c_ attributes
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTTHCEntryAndGroup(long groupId, long tthcEntryId)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, tthcEntryId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TTHCENTRYANDGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TTHC_ATTRIBUTE_WHERE);

			query.append(_FINDER_COLUMN_TTHCENTRYANDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_TTHCENTRYANDGROUP_TTHCENTRYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(tthcEntryId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TTHCENTRYANDGROUP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of t t h c_ attributes that the user has permission to view where groupId = &#63; and tthcEntryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param tthcEntryId the tthc entry ID
	 * @return the number of matching t t h c_ attributes that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByTTHCEntryAndGroup(long groupId, long tthcEntryId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByTTHCEntryAndGroup(groupId, tthcEntryId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_TTHC_ATTRIBUTE_WHERE);

		query.append(_FINDER_COLUMN_TTHCENTRYANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_TTHCENTRYANDGROUP_TTHCENTRYID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TTHC_Attribute.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(tthcEntryId);

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
	 * Returns the number of t t h c_ attributes where companyId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param tthcEntryId the tthc entry ID
	 * @param attributeTypeId the attribute type ID
	 * @return the number of matching t t h c_ attributes
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTTHCEntryAndAttributeTypeAndCompany(long companyId,
		long tthcEntryId, int attributeTypeId) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, tthcEntryId, attributeTypeId
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TTHCENTRYANDATTRIBUTETYPEANDCOMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_TTHC_ATTRIBUTE_WHERE);

			query.append(_FINDER_COLUMN_TTHCENTRYANDATTRIBUTETYPEANDCOMPANY_COMPANYID_2);

			query.append(_FINDER_COLUMN_TTHCENTRYANDATTRIBUTETYPEANDCOMPANY_TTHCENTRYID_2);

			query.append(_FINDER_COLUMN_TTHCENTRYANDATTRIBUTETYPEANDCOMPANY_ATTRIBUTETYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(tthcEntryId);

				qPos.add(attributeTypeId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TTHCENTRYANDATTRIBUTETYPEANDCOMPANY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of t t h c_ attributes where groupId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param tthcEntryId the tthc entry ID
	 * @param attributeTypeId the attribute type ID
	 * @return the number of matching t t h c_ attributes
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTTHCEntryAndAttributeTypeAndGroup(long groupId,
		long tthcEntryId, int attributeTypeId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, tthcEntryId, attributeTypeId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TTHCENTRYANDATTRIBUTETYPEANDGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_TTHC_ATTRIBUTE_WHERE);

			query.append(_FINDER_COLUMN_TTHCENTRYANDATTRIBUTETYPEANDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_TTHCENTRYANDATTRIBUTETYPEANDGROUP_TTHCENTRYID_2);

			query.append(_FINDER_COLUMN_TTHCENTRYANDATTRIBUTETYPEANDGROUP_ATTRIBUTETYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(tthcEntryId);

				qPos.add(attributeTypeId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TTHCENTRYANDATTRIBUTETYPEANDGROUP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of t t h c_ attributes that the user has permission to view where groupId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param tthcEntryId the tthc entry ID
	 * @param attributeTypeId the attribute type ID
	 * @return the number of matching t t h c_ attributes that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByTTHCEntryAndAttributeTypeAndGroup(long groupId,
		long tthcEntryId, int attributeTypeId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByTTHCEntryAndAttributeTypeAndGroup(groupId,
				tthcEntryId, attributeTypeId);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_TTHC_ATTRIBUTE_WHERE);

		query.append(_FINDER_COLUMN_TTHCENTRYANDATTRIBUTETYPEANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_TTHCENTRYANDATTRIBUTETYPEANDGROUP_TTHCENTRYID_2);

		query.append(_FINDER_COLUMN_TTHCENTRYANDATTRIBUTETYPEANDGROUP_ATTRIBUTETYPEID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TTHC_Attribute.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(tthcEntryId);

			qPos.add(attributeTypeId);

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
	 * Returns the number of t t h c_ attributes.
	 *
	 * @return the number of t t h c_ attributes
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TTHC_ATTRIBUTE);

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
	 * Initializes the t t h c_ attribute persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.portal_egov.portlet.tthc.model.TTHC_Attribute")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TTHC_Attribute>> listenersList = new ArrayList<ModelListener<TTHC_Attribute>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TTHC_Attribute>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TTHC_AttributeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = TTHC_AttributePersistence.class)
	protected TTHC_AttributePersistence tthc_AttributePersistence;
	@BeanReference(type = TTHC_CategoryPersistence.class)
	protected TTHC_CategoryPersistence tthc_CategoryPersistence;
	@BeanReference(type = TTHC_EntryPersistence.class)
	protected TTHC_EntryPersistence tthc_EntryPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_TTHC_ATTRIBUTE = "SELECT tthc_Attribute FROM TTHC_Attribute tthc_Attribute";
	private static final String _SQL_SELECT_TTHC_ATTRIBUTE_WHERE = "SELECT tthc_Attribute FROM TTHC_Attribute tthc_Attribute WHERE ";
	private static final String _SQL_COUNT_TTHC_ATTRIBUTE = "SELECT COUNT(tthc_Attribute) FROM TTHC_Attribute tthc_Attribute";
	private static final String _SQL_COUNT_TTHC_ATTRIBUTE_WHERE = "SELECT COUNT(tthc_Attribute) FROM TTHC_Attribute tthc_Attribute WHERE ";
	private static final String _FINDER_COLUMN_TTHCENTRYANDCOMPANY_COMPANYID_2 = "tthc_Attribute.companyId = ? AND ";
	private static final String _FINDER_COLUMN_TTHCENTRYANDCOMPANY_TTHCENTRYID_2 =
		"tthc_Attribute.tthcEntryId = ?";
	private static final String _FINDER_COLUMN_TTHCENTRYANDGROUP_GROUPID_2 = "tthc_Attribute.groupId = ? AND ";
	private static final String _FINDER_COLUMN_TTHCENTRYANDGROUP_TTHCENTRYID_2 = "tthc_Attribute.tthcEntryId = ?";
	private static final String _FINDER_COLUMN_TTHCENTRYANDATTRIBUTETYPEANDCOMPANY_COMPANYID_2 =
		"tthc_Attribute.companyId = ? AND ";
	private static final String _FINDER_COLUMN_TTHCENTRYANDATTRIBUTETYPEANDCOMPANY_TTHCENTRYID_2 =
		"tthc_Attribute.tthcEntryId = ? AND ";
	private static final String _FINDER_COLUMN_TTHCENTRYANDATTRIBUTETYPEANDCOMPANY_ATTRIBUTETYPEID_2 =
		"tthc_Attribute.attributeTypeId = ?";
	private static final String _FINDER_COLUMN_TTHCENTRYANDATTRIBUTETYPEANDGROUP_GROUPID_2 =
		"tthc_Attribute.groupId = ? AND ";
	private static final String _FINDER_COLUMN_TTHCENTRYANDATTRIBUTETYPEANDGROUP_TTHCENTRYID_2 =
		"tthc_Attribute.tthcEntryId = ? AND ";
	private static final String _FINDER_COLUMN_TTHCENTRYANDATTRIBUTETYPEANDGROUP_ATTRIBUTETYPEID_2 =
		"tthc_Attribute.attributeTypeId = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "tthc_Attribute.attributeId";
	private static final String _FILTER_SQL_SELECT_TTHC_ATTRIBUTE_WHERE = "SELECT DISTINCT {tthc_Attribute.*} FROM tthc_attribute tthc_Attribute WHERE ";
	private static final String _FILTER_SQL_SELECT_TTHC_ATTRIBUTE_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {tthc_attribute.*} FROM (SELECT DISTINCT tthc_Attribute.attributeId FROM tthc_attribute tthc_Attribute WHERE ";
	private static final String _FILTER_SQL_SELECT_TTHC_ATTRIBUTE_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN tthc_attribute ON TEMP_TABLE.attributeId = tthc_attribute.attributeId";
	private static final String _FILTER_SQL_COUNT_TTHC_ATTRIBUTE_WHERE = "SELECT COUNT(DISTINCT tthc_Attribute.attributeId) AS COUNT_VALUE FROM tthc_attribute tthc_Attribute WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "tthc_Attribute";
	private static final String _FILTER_ENTITY_TABLE = "tthc_attribute";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tthc_Attribute.";
	private static final String _ORDER_BY_ENTITY_TABLE = "tthc_attribute.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TTHC_Attribute exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TTHC_Attribute exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TTHC_AttributePersistenceImpl.class);
	private static TTHC_Attribute _nullTTHC_Attribute = new TTHC_AttributeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TTHC_Attribute> toCacheModel() {
				return _nullTTHC_AttributeCacheModel;
			}
		};

	private static CacheModel<TTHC_Attribute> _nullTTHC_AttributeCacheModel = new CacheModel<TTHC_Attribute>() {
			public TTHC_Attribute toEntityModel() {
				return _nullTTHC_Attribute;
			}
		};
}