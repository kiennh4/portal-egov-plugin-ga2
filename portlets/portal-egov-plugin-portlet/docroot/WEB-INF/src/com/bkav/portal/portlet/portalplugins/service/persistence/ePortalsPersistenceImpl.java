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

package com.bkav.portal.portlet.portalplugins.service.persistence;

import com.bkav.portal.portlet.portalplugins.NoSuchePortalsException;
import com.bkav.portal.portlet.portalplugins.model.ePortals;
import com.bkav.portal.portlet.portalplugins.model.impl.ePortalsImpl;
import com.bkav.portal.portlet.portalplugins.model.impl.ePortalsModelImpl;

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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e portals service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author AnhBDb
 * @see ePortalsPersistence
 * @see ePortalsUtil
 * @generated
 */
public class ePortalsPersistenceImpl extends BasePersistenceImpl<ePortals>
	implements ePortalsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ePortalsUtil} to access the e portals persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ePortalsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ePortalsModelImpl.ENTITY_CACHE_ENABLED,
			ePortalsModelImpl.FINDER_CACHE_ENABLED, ePortalsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ePortalsModelImpl.ENTITY_CACHE_ENABLED,
			ePortalsModelImpl.FINDER_CACHE_ENABLED, ePortalsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			ePortalsModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ePortalsModelImpl.ENTITY_CACHE_ENABLED,
			ePortalsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(ePortalsModelImpl.ENTITY_CACHE_ENABLED,
			ePortalsModelImpl.FINDER_CACHE_ENABLED, ePortalsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(ePortalsModelImpl.ENTITY_CACHE_ENABLED,
			ePortalsModelImpl.FINDER_CACHE_ENABLED, ePortalsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			ePortalsModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(ePortalsModelImpl.ENTITY_CACHE_ENABLED,
			ePortalsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_EPORTALCODE = new FinderPath(ePortalsModelImpl.ENTITY_CACHE_ENABLED,
			ePortalsModelImpl.FINDER_CACHE_ENABLED, ePortalsImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByePortalCode",
			new String[] { String.class.getName() },
			ePortalsModelImpl.EPORTALCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EPORTALCODE = new FinderPath(ePortalsModelImpl.ENTITY_CACHE_ENABLED,
			ePortalsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByePortalCode",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_EPORTALDOMAIN = new FinderPath(ePortalsModelImpl.ENTITY_CACHE_ENABLED,
			ePortalsModelImpl.FINDER_CACHE_ENABLED, ePortalsImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByePortalDomain",
			new String[] { String.class.getName(), Long.class.getName() },
			ePortalsModelImpl.EPORTALDOMAIN_COLUMN_BITMASK |
			ePortalsModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EPORTALDOMAIN = new FinderPath(ePortalsModelImpl.ENTITY_CACHE_ENABLED,
			ePortalsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByePortalDomain",
			new String[] { String.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ePortalsModelImpl.ENTITY_CACHE_ENABLED,
			ePortalsModelImpl.FINDER_CACHE_ENABLED, ePortalsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ePortalsModelImpl.ENTITY_CACHE_ENABLED,
			ePortalsModelImpl.FINDER_CACHE_ENABLED, ePortalsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ePortalsModelImpl.ENTITY_CACHE_ENABLED,
			ePortalsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the e portals in the entity cache if it is enabled.
	 *
	 * @param ePortals the e portals
	 */
	public void cacheResult(ePortals ePortals) {
		EntityCacheUtil.putResult(ePortalsModelImpl.ENTITY_CACHE_ENABLED,
			ePortalsImpl.class, ePortals.getPrimaryKey(), ePortals);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EPORTALCODE,
			new Object[] { ePortals.getEportalCode() }, ePortals);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EPORTALDOMAIN,
			new Object[] {
				ePortals.getEportalDomain(), Long.valueOf(ePortals.getGroupId())
			}, ePortals);

		ePortals.resetOriginalValues();
	}

	/**
	 * Caches the e portalses in the entity cache if it is enabled.
	 *
	 * @param ePortalses the e portalses
	 */
	public void cacheResult(List<ePortals> ePortalses) {
		for (ePortals ePortals : ePortalses) {
			if (EntityCacheUtil.getResult(
						ePortalsModelImpl.ENTITY_CACHE_ENABLED,
						ePortalsImpl.class, ePortals.getPrimaryKey()) == null) {
				cacheResult(ePortals);
			}
			else {
				ePortals.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e portalses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ePortalsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ePortalsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e portals.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ePortals ePortals) {
		EntityCacheUtil.removeResult(ePortalsModelImpl.ENTITY_CACHE_ENABLED,
			ePortalsImpl.class, ePortals.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(ePortals);
	}

	@Override
	public void clearCache(List<ePortals> ePortalses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ePortals ePortals : ePortalses) {
			EntityCacheUtil.removeResult(ePortalsModelImpl.ENTITY_CACHE_ENABLED,
				ePortalsImpl.class, ePortals.getPrimaryKey());

			clearUniqueFindersCache(ePortals);
		}
	}

	protected void clearUniqueFindersCache(ePortals ePortals) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EPORTALCODE,
			new Object[] { ePortals.getEportalCode() });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EPORTALDOMAIN,
			new Object[] {
				ePortals.getEportalDomain(), Long.valueOf(ePortals.getGroupId())
			});
	}

	/**
	 * Creates a new e portals with the primary key. Does not add the e portals to the database.
	 *
	 * @param eportalId the primary key for the new e portals
	 * @return the new e portals
	 */
	public ePortals create(long eportalId) {
		ePortals ePortals = new ePortalsImpl();

		ePortals.setNew(true);
		ePortals.setPrimaryKey(eportalId);

		return ePortals;
	}

	/**
	 * Removes the e portals with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eportalId the primary key of the e portals
	 * @return the e portals that was removed
	 * @throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException if a e portals with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ePortals remove(long eportalId)
		throws NoSuchePortalsException, SystemException {
		return remove(Long.valueOf(eportalId));
	}

	/**
	 * Removes the e portals with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e portals
	 * @return the e portals that was removed
	 * @throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException if a e portals with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ePortals remove(Serializable primaryKey)
		throws NoSuchePortalsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ePortals ePortals = (ePortals)session.get(ePortalsImpl.class,
					primaryKey);

			if (ePortals == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchePortalsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(ePortals);
		}
		catch (NoSuchePortalsException nsee) {
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
	protected ePortals removeImpl(ePortals ePortals) throws SystemException {
		ePortals = toUnwrappedModel(ePortals);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, ePortals);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(ePortals);

		return ePortals;
	}

	@Override
	public ePortals updateImpl(
		com.bkav.portal.portlet.portalplugins.model.ePortals ePortals,
		boolean merge) throws SystemException {
		ePortals = toUnwrappedModel(ePortals);

		boolean isNew = ePortals.isNew();

		ePortalsModelImpl ePortalsModelImpl = (ePortalsModelImpl)ePortals;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, ePortals, merge);

			ePortals.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ePortalsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((ePortalsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(ePortalsModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { Long.valueOf(ePortalsModelImpl.getGroupId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((ePortalsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(ePortalsModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] { Long.valueOf(ePortalsModelImpl.getGroupId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}
		}

		EntityCacheUtil.putResult(ePortalsModelImpl.ENTITY_CACHE_ENABLED,
			ePortalsImpl.class, ePortals.getPrimaryKey(), ePortals);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EPORTALCODE,
				new Object[] { ePortals.getEportalCode() }, ePortals);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EPORTALDOMAIN,
				new Object[] {
					ePortals.getEportalDomain(),
					Long.valueOf(ePortals.getGroupId())
				}, ePortals);
		}
		else {
			if ((ePortalsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_EPORTALCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ePortalsModelImpl.getOriginalEportalCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EPORTALCODE,
					args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EPORTALCODE,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EPORTALCODE,
					new Object[] { ePortals.getEportalCode() }, ePortals);
			}

			if ((ePortalsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_EPORTALDOMAIN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ePortalsModelImpl.getOriginalEportalDomain(),
						Long.valueOf(ePortalsModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EPORTALDOMAIN,
					args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EPORTALDOMAIN,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EPORTALDOMAIN,
					new Object[] {
						ePortals.getEportalDomain(),
						Long.valueOf(ePortals.getGroupId())
					}, ePortals);
			}
		}

		return ePortals;
	}

	protected ePortals toUnwrappedModel(ePortals ePortals) {
		if (ePortals instanceof ePortalsImpl) {
			return ePortals;
		}

		ePortalsImpl ePortalsImpl = new ePortalsImpl();

		ePortalsImpl.setNew(ePortals.isNew());
		ePortalsImpl.setPrimaryKey(ePortals.getPrimaryKey());

		ePortalsImpl.setEportalId(ePortals.getEportalId());
		ePortalsImpl.setEportalName(ePortals.getEportalName());
		ePortalsImpl.setEportalCode(ePortals.getEportalCode());
		ePortalsImpl.setEportalDomain(ePortals.getEportalDomain());
		ePortalsImpl.setEportalVersion(ePortals.getEportalVersion());
		ePortalsImpl.setCreateDate(ePortals.getCreateDate());
		ePortalsImpl.setModifyDate(ePortals.getModifyDate());
		ePortalsImpl.setGroupId(ePortals.getGroupId());
		ePortalsImpl.setCompanyId(ePortals.getCompanyId());
		ePortalsImpl.setUserId(ePortals.getUserId());
		ePortalsImpl.setUserName(ePortals.getUserName());

		return ePortalsImpl;
	}

	/**
	 * Returns the e portals with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e portals
	 * @return the e portals
	 * @throws com.liferay.portal.NoSuchModelException if a e portals with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ePortals findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the e portals with the primary key or throws a {@link com.bkav.portal.portlet.portalplugins.NoSuchePortalsException} if it could not be found.
	 *
	 * @param eportalId the primary key of the e portals
	 * @return the e portals
	 * @throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException if a e portals with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ePortals findByPrimaryKey(long eportalId)
		throws NoSuchePortalsException, SystemException {
		ePortals ePortals = fetchByPrimaryKey(eportalId);

		if (ePortals == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + eportalId);
			}

			throw new NoSuchePortalsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				eportalId);
		}

		return ePortals;
	}

	/**
	 * Returns the e portals with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e portals
	 * @return the e portals, or <code>null</code> if a e portals with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ePortals fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the e portals with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eportalId the primary key of the e portals
	 * @return the e portals, or <code>null</code> if a e portals with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ePortals fetchByPrimaryKey(long eportalId) throws SystemException {
		ePortals ePortals = (ePortals)EntityCacheUtil.getResult(ePortalsModelImpl.ENTITY_CACHE_ENABLED,
				ePortalsImpl.class, eportalId);

		if (ePortals == _nullePortals) {
			return null;
		}

		if (ePortals == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				ePortals = (ePortals)session.get(ePortalsImpl.class,
						Long.valueOf(eportalId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (ePortals != null) {
					cacheResult(ePortals);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ePortalsModelImpl.ENTITY_CACHE_ENABLED,
						ePortalsImpl.class, eportalId, _nullePortals);
				}

				closeSession(session);
			}
		}

		return ePortals;
	}

	/**
	 * Returns all the e portalses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching e portalses
	 * @throws SystemException if a system exception occurred
	 */
	public List<ePortals> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e portalses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e portalses
	 * @param end the upper bound of the range of e portalses (not inclusive)
	 * @return the range of matching e portalses
	 * @throws SystemException if a system exception occurred
	 */
	public List<ePortals> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e portalses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e portalses
	 * @param end the upper bound of the range of e portalses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e portalses
	 * @throws SystemException if a system exception occurred
	 */
	public List<ePortals> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<ePortals> list = (List<ePortals>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ePortals ePortals : list) {
				if ((groupId != ePortals.getGroupId())) {
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

			query.append(_SQL_SELECT_EPORTALS_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ePortalsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<ePortals>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first e portals in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e portals
	 * @throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException if a matching e portals could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ePortals findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchePortalsException, SystemException {
		ePortals ePortals = fetchByGroupId_First(groupId, orderByComparator);

		if (ePortals != null) {
			return ePortals;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchePortalsException(msg.toString());
	}

	/**
	 * Returns the first e portals in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e portals, or <code>null</code> if a matching e portals could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ePortals fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ePortals> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e portals in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e portals
	 * @throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException if a matching e portals could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ePortals findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchePortalsException, SystemException {
		ePortals ePortals = fetchByGroupId_Last(groupId, orderByComparator);

		if (ePortals != null) {
			return ePortals;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchePortalsException(msg.toString());
	}

	/**
	 * Returns the last e portals in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e portals, or <code>null</code> if a matching e portals could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ePortals fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		List<ePortals> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e portalses before and after the current e portals in the ordered set where groupId = &#63;.
	 *
	 * @param eportalId the primary key of the current e portals
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e portals
	 * @throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException if a e portals with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ePortals[] findByGroupId_PrevAndNext(long eportalId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchePortalsException, SystemException {
		ePortals ePortals = findByPrimaryKey(eportalId);

		Session session = null;

		try {
			session = openSession();

			ePortals[] array = new ePortalsImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, ePortals, groupId,
					orderByComparator, true);

			array[1] = ePortals;

			array[2] = getByGroupId_PrevAndNext(session, ePortals, groupId,
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

	protected ePortals getByGroupId_PrevAndNext(Session session,
		ePortals ePortals, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EPORTALS_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			query.append(ePortalsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ePortals);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ePortals> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the e portalses that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching e portalses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<ePortals> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e portalses that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e portalses
	 * @param end the upper bound of the range of e portalses (not inclusive)
	 * @return the range of matching e portalses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<ePortals> filterFindByGroupId(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e portalses that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e portalses
	 * @param end the upper bound of the range of e portalses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e portalses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<ePortals> filterFindByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
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
			query.append(_FILTER_SQL_SELECT_EPORTALS_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_EPORTALS_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_EPORTALS_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ePortalsModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ePortalsModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ePortals.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, ePortalsImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, ePortalsImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<ePortals>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the e portalses before and after the current e portals in the ordered set of e portalses that the user has permission to view where groupId = &#63;.
	 *
	 * @param eportalId the primary key of the current e portals
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e portals
	 * @throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException if a e portals with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ePortals[] filterFindByGroupId_PrevAndNext(long eportalId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchePortalsException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(eportalId, groupId,
				orderByComparator);
		}

		ePortals ePortals = findByPrimaryKey(eportalId);

		Session session = null;

		try {
			session = openSession();

			ePortals[] array = new ePortalsImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(session, ePortals,
					groupId, orderByComparator, true);

			array[1] = ePortals;

			array[2] = filterGetByGroupId_PrevAndNext(session, ePortals,
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

	protected ePortals filterGetByGroupId_PrevAndNext(Session session,
		ePortals ePortals, long groupId, OrderByComparator orderByComparator,
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
			query.append(_FILTER_SQL_SELECT_EPORTALS_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_EPORTALS_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_EPORTALS_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ePortalsModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ePortalsModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ePortals.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, ePortalsImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, ePortalsImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ePortals);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ePortals> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the e portalses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching e portalses
	 * @throws SystemException if a system exception occurred
	 */
	public List<ePortals> findByCompanyId(long groupId)
		throws SystemException {
		return findByCompanyId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e portalses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e portalses
	 * @param end the upper bound of the range of e portalses (not inclusive)
	 * @return the range of matching e portalses
	 * @throws SystemException if a system exception occurred
	 */
	public List<ePortals> findByCompanyId(long groupId, int start, int end)
		throws SystemException {
		return findByCompanyId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e portalses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e portalses
	 * @param end the upper bound of the range of e portalses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e portalses
	 * @throws SystemException if a system exception occurred
	 */
	public List<ePortals> findByCompanyId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<ePortals> list = (List<ePortals>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ePortals ePortals : list) {
				if ((groupId != ePortals.getGroupId())) {
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

			query.append(_SQL_SELECT_EPORTALS_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ePortalsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<ePortals>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first e portals in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e portals
	 * @throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException if a matching e portals could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ePortals findByCompanyId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchePortalsException, SystemException {
		ePortals ePortals = fetchByCompanyId_First(groupId, orderByComparator);

		if (ePortals != null) {
			return ePortals;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchePortalsException(msg.toString());
	}

	/**
	 * Returns the first e portals in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e portals, or <code>null</code> if a matching e portals could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ePortals fetchByCompanyId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ePortals> list = findByCompanyId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e portals in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e portals
	 * @throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException if a matching e portals could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ePortals findByCompanyId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchePortalsException, SystemException {
		ePortals ePortals = fetchByCompanyId_Last(groupId, orderByComparator);

		if (ePortals != null) {
			return ePortals;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchePortalsException(msg.toString());
	}

	/**
	 * Returns the last e portals in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e portals, or <code>null</code> if a matching e portals could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ePortals fetchByCompanyId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(groupId);

		List<ePortals> list = findByCompanyId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e portalses before and after the current e portals in the ordered set where groupId = &#63;.
	 *
	 * @param eportalId the primary key of the current e portals
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e portals
	 * @throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException if a e portals with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ePortals[] findByCompanyId_PrevAndNext(long eportalId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchePortalsException, SystemException {
		ePortals ePortals = findByPrimaryKey(eportalId);

		Session session = null;

		try {
			session = openSession();

			ePortals[] array = new ePortalsImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, ePortals, groupId,
					orderByComparator, true);

			array[1] = ePortals;

			array[2] = getByCompanyId_PrevAndNext(session, ePortals, groupId,
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

	protected ePortals getByCompanyId_PrevAndNext(Session session,
		ePortals ePortals, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EPORTALS_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_GROUPID_2);

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
			query.append(ePortalsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ePortals);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ePortals> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the e portalses that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching e portalses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<ePortals> filterFindByCompanyId(long groupId)
		throws SystemException {
		return filterFindByCompanyId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e portalses that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e portalses
	 * @param end the upper bound of the range of e portalses (not inclusive)
	 * @return the range of matching e portalses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<ePortals> filterFindByCompanyId(long groupId, int start, int end)
		throws SystemException {
		return filterFindByCompanyId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e portalses that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e portalses
	 * @param end the upper bound of the range of e portalses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e portalses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<ePortals> filterFindByCompanyId(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByCompanyId(groupId, start, end, orderByComparator);
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
			query.append(_FILTER_SQL_SELECT_EPORTALS_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_EPORTALS_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_COMPANYID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_EPORTALS_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ePortalsModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ePortalsModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ePortals.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, ePortalsImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, ePortalsImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<ePortals>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the e portalses before and after the current e portals in the ordered set of e portalses that the user has permission to view where groupId = &#63;.
	 *
	 * @param eportalId the primary key of the current e portals
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e portals
	 * @throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException if a e portals with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ePortals[] filterFindByCompanyId_PrevAndNext(long eportalId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchePortalsException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByCompanyId_PrevAndNext(eportalId, groupId,
				orderByComparator);
		}

		ePortals ePortals = findByPrimaryKey(eportalId);

		Session session = null;

		try {
			session = openSession();

			ePortals[] array = new ePortalsImpl[3];

			array[0] = filterGetByCompanyId_PrevAndNext(session, ePortals,
					groupId, orderByComparator, true);

			array[1] = ePortals;

			array[2] = filterGetByCompanyId_PrevAndNext(session, ePortals,
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

	protected ePortals filterGetByCompanyId_PrevAndNext(Session session,
		ePortals ePortals, long groupId, OrderByComparator orderByComparator,
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
			query.append(_FILTER_SQL_SELECT_EPORTALS_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_EPORTALS_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_COMPANYID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_EPORTALS_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ePortalsModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ePortalsModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ePortals.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, ePortalsImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, ePortalsImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ePortals);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ePortals> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the e portals where eportalCode = &#63; or throws a {@link com.bkav.portal.portlet.portalplugins.NoSuchePortalsException} if it could not be found.
	 *
	 * @param eportalCode the eportal code
	 * @return the matching e portals
	 * @throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException if a matching e portals could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ePortals findByePortalCode(String eportalCode)
		throws NoSuchePortalsException, SystemException {
		ePortals ePortals = fetchByePortalCode(eportalCode);

		if (ePortals == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("eportalCode=");
			msg.append(eportalCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchePortalsException(msg.toString());
		}

		return ePortals;
	}

	/**
	 * Returns the e portals where eportalCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param eportalCode the eportal code
	 * @return the matching e portals, or <code>null</code> if a matching e portals could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ePortals fetchByePortalCode(String eportalCode)
		throws SystemException {
		return fetchByePortalCode(eportalCode, true);
	}

	/**
	 * Returns the e portals where eportalCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param eportalCode the eportal code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e portals, or <code>null</code> if a matching e portals could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ePortals fetchByePortalCode(String eportalCode,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { eportalCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_EPORTALCODE,
					finderArgs, this);
		}

		if (result instanceof ePortals) {
			ePortals ePortals = (ePortals)result;

			if (!Validator.equals(eportalCode, ePortals.getEportalCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_EPORTALS_WHERE);

			if (eportalCode == null) {
				query.append(_FINDER_COLUMN_EPORTALCODE_EPORTALCODE_1);
			}
			else {
				if (eportalCode.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_EPORTALCODE_EPORTALCODE_3);
				}
				else {
					query.append(_FINDER_COLUMN_EPORTALCODE_EPORTALCODE_2);
				}
			}

			query.append(ePortalsModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (eportalCode != null) {
					qPos.add(eportalCode);
				}

				List<ePortals> list = q.list();

				result = list;

				ePortals ePortals = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EPORTALCODE,
						finderArgs, list);
				}
				else {
					ePortals = list.get(0);

					cacheResult(ePortals);

					if ((ePortals.getEportalCode() == null) ||
							!ePortals.getEportalCode().equals(eportalCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EPORTALCODE,
							finderArgs, ePortals);
					}
				}

				return ePortals;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EPORTALCODE,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (ePortals)result;
			}
		}
	}

	/**
	 * Returns the e portals where eportalDomain = &#63; and groupId = &#63; or throws a {@link com.bkav.portal.portlet.portalplugins.NoSuchePortalsException} if it could not be found.
	 *
	 * @param eportalDomain the eportal domain
	 * @param groupId the group ID
	 * @return the matching e portals
	 * @throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException if a matching e portals could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ePortals findByePortalDomain(String eportalDomain, long groupId)
		throws NoSuchePortalsException, SystemException {
		ePortals ePortals = fetchByePortalDomain(eportalDomain, groupId);

		if (ePortals == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("eportalDomain=");
			msg.append(eportalDomain);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchePortalsException(msg.toString());
		}

		return ePortals;
	}

	/**
	 * Returns the e portals where eportalDomain = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param eportalDomain the eportal domain
	 * @param groupId the group ID
	 * @return the matching e portals, or <code>null</code> if a matching e portals could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ePortals fetchByePortalDomain(String eportalDomain, long groupId)
		throws SystemException {
		return fetchByePortalDomain(eportalDomain, groupId, true);
	}

	/**
	 * Returns the e portals where eportalDomain = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param eportalDomain the eportal domain
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e portals, or <code>null</code> if a matching e portals could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ePortals fetchByePortalDomain(String eportalDomain, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { eportalDomain, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_EPORTALDOMAIN,
					finderArgs, this);
		}

		if (result instanceof ePortals) {
			ePortals ePortals = (ePortals)result;

			if (!Validator.equals(eportalDomain, ePortals.getEportalDomain()) ||
					(groupId != ePortals.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_EPORTALS_WHERE);

			if (eportalDomain == null) {
				query.append(_FINDER_COLUMN_EPORTALDOMAIN_EPORTALDOMAIN_1);
			}
			else {
				if (eportalDomain.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_EPORTALDOMAIN_EPORTALDOMAIN_3);
				}
				else {
					query.append(_FINDER_COLUMN_EPORTALDOMAIN_EPORTALDOMAIN_2);
				}
			}

			query.append(_FINDER_COLUMN_EPORTALDOMAIN_GROUPID_2);

			query.append(ePortalsModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (eportalDomain != null) {
					qPos.add(eportalDomain);
				}

				qPos.add(groupId);

				List<ePortals> list = q.list();

				result = list;

				ePortals ePortals = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EPORTALDOMAIN,
						finderArgs, list);
				}
				else {
					ePortals = list.get(0);

					cacheResult(ePortals);

					if ((ePortals.getEportalDomain() == null) ||
							!ePortals.getEportalDomain().equals(eportalDomain) ||
							(ePortals.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EPORTALDOMAIN,
							finderArgs, ePortals);
					}
				}

				return ePortals;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EPORTALDOMAIN,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (ePortals)result;
			}
		}
	}

	/**
	 * Returns all the e portalses.
	 *
	 * @return the e portalses
	 * @throws SystemException if a system exception occurred
	 */
	public List<ePortals> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e portalses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of e portalses
	 * @param end the upper bound of the range of e portalses (not inclusive)
	 * @return the range of e portalses
	 * @throws SystemException if a system exception occurred
	 */
	public List<ePortals> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e portalses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of e portalses
	 * @param end the upper bound of the range of e portalses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e portalses
	 * @throws SystemException if a system exception occurred
	 */
	public List<ePortals> findAll(int start, int end,
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

		List<ePortals> list = (List<ePortals>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EPORTALS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EPORTALS.concat(ePortalsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ePortals>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ePortals>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e portalses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (ePortals ePortals : findByGroupId(groupId)) {
			remove(ePortals);
		}
	}

	/**
	 * Removes all the e portalses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyId(long groupId) throws SystemException {
		for (ePortals ePortals : findByCompanyId(groupId)) {
			remove(ePortals);
		}
	}

	/**
	 * Removes the e portals where eportalCode = &#63; from the database.
	 *
	 * @param eportalCode the eportal code
	 * @return the e portals that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public ePortals removeByePortalCode(String eportalCode)
		throws NoSuchePortalsException, SystemException {
		ePortals ePortals = findByePortalCode(eportalCode);

		return remove(ePortals);
	}

	/**
	 * Removes the e portals where eportalDomain = &#63; and groupId = &#63; from the database.
	 *
	 * @param eportalDomain the eportal domain
	 * @param groupId the group ID
	 * @return the e portals that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public ePortals removeByePortalDomain(String eportalDomain, long groupId)
		throws NoSuchePortalsException, SystemException {
		ePortals ePortals = findByePortalDomain(eportalDomain, groupId);

		return remove(ePortals);
	}

	/**
	 * Removes all the e portalses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ePortals ePortals : findAll()) {
			remove(ePortals);
		}
	}

	/**
	 * Returns the number of e portalses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching e portalses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EPORTALS_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of e portalses that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching e portalses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_EPORTALS_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ePortals.class.getName(),
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
	 * Returns the number of e portalses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching e portalses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EPORTALS_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_GROUPID_2);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of e portalses that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching e portalses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByCompanyId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByCompanyId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_EPORTALS_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ePortals.class.getName(),
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
	 * Returns the number of e portalses where eportalCode = &#63;.
	 *
	 * @param eportalCode the eportal code
	 * @return the number of matching e portalses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByePortalCode(String eportalCode) throws SystemException {
		Object[] finderArgs = new Object[] { eportalCode };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_EPORTALCODE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EPORTALS_WHERE);

			if (eportalCode == null) {
				query.append(_FINDER_COLUMN_EPORTALCODE_EPORTALCODE_1);
			}
			else {
				if (eportalCode.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_EPORTALCODE_EPORTALCODE_3);
				}
				else {
					query.append(_FINDER_COLUMN_EPORTALCODE_EPORTALCODE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (eportalCode != null) {
					qPos.add(eportalCode);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EPORTALCODE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of e portalses where eportalDomain = &#63; and groupId = &#63;.
	 *
	 * @param eportalDomain the eportal domain
	 * @param groupId the group ID
	 * @return the number of matching e portalses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByePortalDomain(String eportalDomain, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { eportalDomain, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_EPORTALDOMAIN,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EPORTALS_WHERE);

			if (eportalDomain == null) {
				query.append(_FINDER_COLUMN_EPORTALDOMAIN_EPORTALDOMAIN_1);
			}
			else {
				if (eportalDomain.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_EPORTALDOMAIN_EPORTALDOMAIN_3);
				}
				else {
					query.append(_FINDER_COLUMN_EPORTALDOMAIN_EPORTALDOMAIN_2);
				}
			}

			query.append(_FINDER_COLUMN_EPORTALDOMAIN_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (eportalDomain != null) {
					qPos.add(eportalDomain);
				}

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EPORTALDOMAIN,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of e portalses.
	 *
	 * @return the number of e portalses
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EPORTALS);

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
	 * Initializes the e portals persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.bkav.portal.portlet.portalplugins.model.ePortals")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ePortals>> listenersList = new ArrayList<ModelListener<ePortals>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ePortals>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ePortalsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = ePortalsPersistence.class)
	protected ePortalsPersistence ePortalsPersistence;
	@BeanReference(type = PortalPluginsPersistence.class)
	protected PortalPluginsPersistence portalPluginsPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_EPORTALS = "SELECT ePortals FROM ePortals ePortals";
	private static final String _SQL_SELECT_EPORTALS_WHERE = "SELECT ePortals FROM ePortals ePortals WHERE ";
	private static final String _SQL_COUNT_EPORTALS = "SELECT COUNT(ePortals) FROM ePortals ePortals";
	private static final String _SQL_COUNT_EPORTALS_WHERE = "SELECT COUNT(ePortals) FROM ePortals ePortals WHERE ";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "ePortals.groupId = ?";
	private static final String _FINDER_COLUMN_COMPANYID_GROUPID_2 = "ePortals.groupId = ?";
	private static final String _FINDER_COLUMN_EPORTALCODE_EPORTALCODE_1 = "ePortals.eportalCode IS NULL";
	private static final String _FINDER_COLUMN_EPORTALCODE_EPORTALCODE_2 = "ePortals.eportalCode = ?";
	private static final String _FINDER_COLUMN_EPORTALCODE_EPORTALCODE_3 = "(ePortals.eportalCode IS NULL OR ePortals.eportalCode = ?)";
	private static final String _FINDER_COLUMN_EPORTALDOMAIN_EPORTALDOMAIN_1 = "ePortals.eportalDomain IS NULL AND ";
	private static final String _FINDER_COLUMN_EPORTALDOMAIN_EPORTALDOMAIN_2 = "ePortals.eportalDomain = ? AND ";
	private static final String _FINDER_COLUMN_EPORTALDOMAIN_EPORTALDOMAIN_3 = "(ePortals.eportalDomain IS NULL OR ePortals.eportalDomain = ?) AND ";
	private static final String _FINDER_COLUMN_EPORTALDOMAIN_GROUPID_2 = "ePortals.groupId = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "ePortals.eportalId";
	private static final String _FILTER_SQL_SELECT_EPORTALS_WHERE = "SELECT DISTINCT {ePortals.*} FROM ePortals ePortals WHERE ";
	private static final String _FILTER_SQL_SELECT_EPORTALS_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {ePortals.*} FROM (SELECT DISTINCT ePortals.eportalId FROM ePortals ePortals WHERE ";
	private static final String _FILTER_SQL_SELECT_EPORTALS_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN ePortals ON TEMP_TABLE.eportalId = ePortals.eportalId";
	private static final String _FILTER_SQL_COUNT_EPORTALS_WHERE = "SELECT COUNT(DISTINCT ePortals.eportalId) AS COUNT_VALUE FROM ePortals ePortals WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "ePortals";
	private static final String _FILTER_ENTITY_TABLE = "ePortals";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ePortals.";
	private static final String _ORDER_BY_ENTITY_TABLE = "ePortals.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ePortals exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ePortals exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ePortalsPersistenceImpl.class);
	private static ePortals _nullePortals = new ePortalsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ePortals> toCacheModel() {
				return _nullePortalsCacheModel;
			}
		};

	private static CacheModel<ePortals> _nullePortalsCacheModel = new CacheModel<ePortals>() {
			public ePortals toEntityModel() {
				return _nullePortals;
			}
		};
}