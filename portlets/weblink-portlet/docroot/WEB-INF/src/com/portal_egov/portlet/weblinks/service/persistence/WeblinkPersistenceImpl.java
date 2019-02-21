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

package com.portal_egov.portlet.weblinks.service.persistence;

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

import com.portal_egov.portlet.weblinks.NoSuchWeblinkException;
import com.portal_egov.portlet.weblinks.model.Weblink;
import com.portal_egov.portlet.weblinks.model.impl.WeblinkImpl;
import com.portal_egov.portlet.weblinks.model.impl.WeblinkModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the weblink service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see WeblinkPersistence
 * @see WeblinkUtil
 * @generated
 */
public class WeblinkPersistenceImpl extends BasePersistenceImpl<Weblink>
	implements WeblinkPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WeblinkUtil} to access the weblink persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WeblinkImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(WeblinkModelImpl.ENTITY_CACHE_ENABLED,
			WeblinkModelImpl.FINDER_CACHE_ENABLED, WeblinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(WeblinkModelImpl.ENTITY_CACHE_ENABLED,
			WeblinkModelImpl.FINDER_CACHE_ENABLED, WeblinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			WeblinkModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(WeblinkModelImpl.ENTITY_CACHE_ENABLED,
			WeblinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(WeblinkModelImpl.ENTITY_CACHE_ENABLED,
			WeblinkModelImpl.FINDER_CACHE_ENABLED, WeblinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(WeblinkModelImpl.ENTITY_CACHE_ENABLED,
			WeblinkModelImpl.FINDER_CACHE_ENABLED, WeblinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			WeblinkModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(WeblinkModelImpl.ENTITY_CACHE_ENABLED,
			WeblinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORY = new FinderPath(WeblinkModelImpl.ENTITY_CACHE_ENABLED,
			WeblinkModelImpl.FINDER_CACHE_ENABLED, WeblinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategory",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY =
		new FinderPath(WeblinkModelImpl.ENTITY_CACHE_ENABLED,
			WeblinkModelImpl.FINDER_CACHE_ENABLED, WeblinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCategory",
			new String[] { Long.class.getName() },
			WeblinkModelImpl.WEBLINKCATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORY = new FinderPath(WeblinkModelImpl.ENTITY_CACHE_ENABLED,
			WeblinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategory",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WeblinkModelImpl.ENTITY_CACHE_ENABLED,
			WeblinkModelImpl.FINDER_CACHE_ENABLED, WeblinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WeblinkModelImpl.ENTITY_CACHE_ENABLED,
			WeblinkModelImpl.FINDER_CACHE_ENABLED, WeblinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WeblinkModelImpl.ENTITY_CACHE_ENABLED,
			WeblinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the weblink in the entity cache if it is enabled.
	 *
	 * @param weblink the weblink
	 */
	public void cacheResult(Weblink weblink) {
		EntityCacheUtil.putResult(WeblinkModelImpl.ENTITY_CACHE_ENABLED,
			WeblinkImpl.class, weblink.getPrimaryKey(), weblink);

		weblink.resetOriginalValues();
	}

	/**
	 * Caches the weblinks in the entity cache if it is enabled.
	 *
	 * @param weblinks the weblinks
	 */
	public void cacheResult(List<Weblink> weblinks) {
		for (Weblink weblink : weblinks) {
			if (EntityCacheUtil.getResult(
						WeblinkModelImpl.ENTITY_CACHE_ENABLED,
						WeblinkImpl.class, weblink.getPrimaryKey()) == null) {
				cacheResult(weblink);
			}
			else {
				weblink.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all weblinks.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(WeblinkImpl.class.getName());
		}

		EntityCacheUtil.clearCache(WeblinkImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the weblink.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Weblink weblink) {
		EntityCacheUtil.removeResult(WeblinkModelImpl.ENTITY_CACHE_ENABLED,
			WeblinkImpl.class, weblink.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Weblink> weblinks) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Weblink weblink : weblinks) {
			EntityCacheUtil.removeResult(WeblinkModelImpl.ENTITY_CACHE_ENABLED,
				WeblinkImpl.class, weblink.getPrimaryKey());
		}
	}

	/**
	 * Creates a new weblink with the primary key. Does not add the weblink to the database.
	 *
	 * @param weblinkId the primary key for the new weblink
	 * @return the new weblink
	 */
	public Weblink create(long weblinkId) {
		Weblink weblink = new WeblinkImpl();

		weblink.setNew(true);
		weblink.setPrimaryKey(weblinkId);

		return weblink;
	}

	/**
	 * Removes the weblink with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param weblinkId the primary key of the weblink
	 * @return the weblink that was removed
	 * @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkException if a weblink with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Weblink remove(long weblinkId)
		throws NoSuchWeblinkException, SystemException {
		return remove(Long.valueOf(weblinkId));
	}

	/**
	 * Removes the weblink with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the weblink
	 * @return the weblink that was removed
	 * @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkException if a weblink with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Weblink remove(Serializable primaryKey)
		throws NoSuchWeblinkException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Weblink weblink = (Weblink)session.get(WeblinkImpl.class, primaryKey);

			if (weblink == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWeblinkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(weblink);
		}
		catch (NoSuchWeblinkException nsee) {
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
	protected Weblink removeImpl(Weblink weblink) throws SystemException {
		weblink = toUnwrappedModel(weblink);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, weblink);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(weblink);

		return weblink;
	}

	@Override
	public Weblink updateImpl(
		com.portal_egov.portlet.weblinks.model.Weblink weblink, boolean merge)
		throws SystemException {
		weblink = toUnwrappedModel(weblink);

		boolean isNew = weblink.isNew();

		WeblinkModelImpl weblinkModelImpl = (WeblinkModelImpl)weblink;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, weblink, merge);

			weblink.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !WeblinkModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((weblinkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(weblinkModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] {
						Long.valueOf(weblinkModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((weblinkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(weblinkModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] { Long.valueOf(weblinkModelImpl.getGroupId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}

			if ((weblinkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(weblinkModelImpl.getOriginalWeblinkCategoryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
					args);

				args = new Object[] {
						Long.valueOf(weblinkModelImpl.getWeblinkCategoryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
					args);
			}
		}

		EntityCacheUtil.putResult(WeblinkModelImpl.ENTITY_CACHE_ENABLED,
			WeblinkImpl.class, weblink.getPrimaryKey(), weblink);

		return weblink;
	}

	protected Weblink toUnwrappedModel(Weblink weblink) {
		if (weblink instanceof WeblinkImpl) {
			return weblink;
		}

		WeblinkImpl weblinkImpl = new WeblinkImpl();

		weblinkImpl.setNew(weblink.isNew());
		weblinkImpl.setPrimaryKey(weblink.getPrimaryKey());

		weblinkImpl.setWeblinkId(weblink.getWeblinkId());
		weblinkImpl.setGroupId(weblink.getGroupId());
		weblinkImpl.setCompanyId(weblink.getCompanyId());
		weblinkImpl.setUserId(weblink.getUserId());
		weblinkImpl.setUserName(weblink.getUserName());
		weblinkImpl.setCreateDate(weblink.getCreateDate());
		weblinkImpl.setModifiedDate(weblink.getModifiedDate());
		weblinkImpl.setWeblinkCategoryId(weblink.getWeblinkCategoryId());
		weblinkImpl.setWeblinkName(weblink.getWeblinkName());
		weblinkImpl.setWeblinkDesc(weblink.getWeblinkDesc());
		weblinkImpl.setWeblinkURL(weblink.getWeblinkURL());
		weblinkImpl.setWeblinkIconId(weblink.getWeblinkIconId());

		return weblinkImpl;
	}

	/**
	 * Returns the weblink with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the weblink
	 * @return the weblink
	 * @throws com.liferay.portal.NoSuchModelException if a weblink with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Weblink findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the weblink with the primary key or throws a {@link com.portal_egov.portlet.weblinks.NoSuchWeblinkException} if it could not be found.
	 *
	 * @param weblinkId the primary key of the weblink
	 * @return the weblink
	 * @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkException if a weblink with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Weblink findByPrimaryKey(long weblinkId)
		throws NoSuchWeblinkException, SystemException {
		Weblink weblink = fetchByPrimaryKey(weblinkId);

		if (weblink == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + weblinkId);
			}

			throw new NoSuchWeblinkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				weblinkId);
		}

		return weblink;
	}

	/**
	 * Returns the weblink with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the weblink
	 * @return the weblink, or <code>null</code> if a weblink with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Weblink fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the weblink with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param weblinkId the primary key of the weblink
	 * @return the weblink, or <code>null</code> if a weblink with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Weblink fetchByPrimaryKey(long weblinkId) throws SystemException {
		Weblink weblink = (Weblink)EntityCacheUtil.getResult(WeblinkModelImpl.ENTITY_CACHE_ENABLED,
				WeblinkImpl.class, weblinkId);

		if (weblink == _nullWeblink) {
			return null;
		}

		if (weblink == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				weblink = (Weblink)session.get(WeblinkImpl.class,
						Long.valueOf(weblinkId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (weblink != null) {
					cacheResult(weblink);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(WeblinkModelImpl.ENTITY_CACHE_ENABLED,
						WeblinkImpl.class, weblinkId, _nullWeblink);
				}

				closeSession(session);
			}
		}

		return weblink;
	}

	/**
	 * Returns all the weblinks where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching weblinks
	 * @throws SystemException if a system exception occurred
	 */
	public List<Weblink> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the weblinks where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of weblinks
	 * @param end the upper bound of the range of weblinks (not inclusive)
	 * @return the range of matching weblinks
	 * @throws SystemException if a system exception occurred
	 */
	public List<Weblink> findByCompany(long companyId, int start, int end)
		throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the weblinks where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of weblinks
	 * @param end the upper bound of the range of weblinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching weblinks
	 * @throws SystemException if a system exception occurred
	 */
	public List<Weblink> findByCompany(long companyId, int start, int end,
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

		List<Weblink> list = (List<Weblink>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Weblink weblink : list) {
				if ((companyId != weblink.getCompanyId())) {
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

			query.append(_SQL_SELECT_WEBLINK_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(WeblinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<Weblink>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first weblink in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching weblink
	 * @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkException if a matching weblink could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Weblink findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchWeblinkException, SystemException {
		Weblink weblink = fetchByCompany_First(companyId, orderByComparator);

		if (weblink != null) {
			return weblink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWeblinkException(msg.toString());
	}

	/**
	 * Returns the first weblink in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching weblink, or <code>null</code> if a matching weblink could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Weblink fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Weblink> list = findByCompany(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last weblink in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching weblink
	 * @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkException if a matching weblink could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Weblink findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchWeblinkException, SystemException {
		Weblink weblink = fetchByCompany_Last(companyId, orderByComparator);

		if (weblink != null) {
			return weblink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWeblinkException(msg.toString());
	}

	/**
	 * Returns the last weblink in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching weblink, or <code>null</code> if a matching weblink could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Weblink fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		List<Weblink> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the weblinks before and after the current weblink in the ordered set where companyId = &#63;.
	 *
	 * @param weblinkId the primary key of the current weblink
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next weblink
	 * @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkException if a weblink with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Weblink[] findByCompany_PrevAndNext(long weblinkId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchWeblinkException, SystemException {
		Weblink weblink = findByPrimaryKey(weblinkId);

		Session session = null;

		try {
			session = openSession();

			Weblink[] array = new WeblinkImpl[3];

			array[0] = getByCompany_PrevAndNext(session, weblink, companyId,
					orderByComparator, true);

			array[1] = weblink;

			array[2] = getByCompany_PrevAndNext(session, weblink, companyId,
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

	protected Weblink getByCompany_PrevAndNext(Session session,
		Weblink weblink, long companyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WEBLINK_WHERE);

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
			query.append(WeblinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(weblink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Weblink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the weblinks where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching weblinks
	 * @throws SystemException if a system exception occurred
	 */
	public List<Weblink> findByGroup(long groupId) throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the weblinks where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of weblinks
	 * @param end the upper bound of the range of weblinks (not inclusive)
	 * @return the range of matching weblinks
	 * @throws SystemException if a system exception occurred
	 */
	public List<Weblink> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the weblinks where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of weblinks
	 * @param end the upper bound of the range of weblinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching weblinks
	 * @throws SystemException if a system exception occurred
	 */
	public List<Weblink> findByGroup(long groupId, int start, int end,
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

		List<Weblink> list = (List<Weblink>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Weblink weblink : list) {
				if ((groupId != weblink.getGroupId())) {
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

			query.append(_SQL_SELECT_WEBLINK_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(WeblinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<Weblink>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first weblink in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching weblink
	 * @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkException if a matching weblink could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Weblink findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchWeblinkException, SystemException {
		Weblink weblink = fetchByGroup_First(groupId, orderByComparator);

		if (weblink != null) {
			return weblink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWeblinkException(msg.toString());
	}

	/**
	 * Returns the first weblink in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching weblink, or <code>null</code> if a matching weblink could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Weblink fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Weblink> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last weblink in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching weblink
	 * @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkException if a matching weblink could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Weblink findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchWeblinkException, SystemException {
		Weblink weblink = fetchByGroup_Last(groupId, orderByComparator);

		if (weblink != null) {
			return weblink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWeblinkException(msg.toString());
	}

	/**
	 * Returns the last weblink in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching weblink, or <code>null</code> if a matching weblink could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Weblink fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<Weblink> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the weblinks before and after the current weblink in the ordered set where groupId = &#63;.
	 *
	 * @param weblinkId the primary key of the current weblink
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next weblink
	 * @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkException if a weblink with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Weblink[] findByGroup_PrevAndNext(long weblinkId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchWeblinkException, SystemException {
		Weblink weblink = findByPrimaryKey(weblinkId);

		Session session = null;

		try {
			session = openSession();

			Weblink[] array = new WeblinkImpl[3];

			array[0] = getByGroup_PrevAndNext(session, weblink, groupId,
					orderByComparator, true);

			array[1] = weblink;

			array[2] = getByGroup_PrevAndNext(session, weblink, groupId,
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

	protected Weblink getByGroup_PrevAndNext(Session session, Weblink weblink,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WEBLINK_WHERE);

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
			query.append(WeblinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(weblink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Weblink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the weblinks that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching weblinks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Weblink> filterFindByGroup(long groupId)
		throws SystemException {
		return filterFindByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the weblinks that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of weblinks
	 * @param end the upper bound of the range of weblinks (not inclusive)
	 * @return the range of matching weblinks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Weblink> filterFindByGroup(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the weblinks that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of weblinks
	 * @param end the upper bound of the range of weblinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching weblinks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Weblink> filterFindByGroup(long groupId, int start, int end,
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
			query.append(_FILTER_SQL_SELECT_WEBLINK_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_WEBLINK_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_WEBLINK_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(WeblinkModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(WeblinkModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Weblink.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, WeblinkImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, WeblinkImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<Weblink>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the weblinks before and after the current weblink in the ordered set of weblinks that the user has permission to view where groupId = &#63;.
	 *
	 * @param weblinkId the primary key of the current weblink
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next weblink
	 * @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkException if a weblink with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Weblink[] filterFindByGroup_PrevAndNext(long weblinkId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchWeblinkException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup_PrevAndNext(weblinkId, groupId, orderByComparator);
		}

		Weblink weblink = findByPrimaryKey(weblinkId);

		Session session = null;

		try {
			session = openSession();

			Weblink[] array = new WeblinkImpl[3];

			array[0] = filterGetByGroup_PrevAndNext(session, weblink, groupId,
					orderByComparator, true);

			array[1] = weblink;

			array[2] = filterGetByGroup_PrevAndNext(session, weblink, groupId,
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

	protected Weblink filterGetByGroup_PrevAndNext(Session session,
		Weblink weblink, long groupId, OrderByComparator orderByComparator,
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
			query.append(_FILTER_SQL_SELECT_WEBLINK_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_WEBLINK_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_WEBLINK_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(WeblinkModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(WeblinkModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Weblink.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, WeblinkImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, WeblinkImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(weblink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Weblink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the weblinks where weblinkCategoryId = &#63;.
	 *
	 * @param weblinkCategoryId the weblink category ID
	 * @return the matching weblinks
	 * @throws SystemException if a system exception occurred
	 */
	public List<Weblink> findByCategory(long weblinkCategoryId)
		throws SystemException {
		return findByCategory(weblinkCategoryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the weblinks where weblinkCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param weblinkCategoryId the weblink category ID
	 * @param start the lower bound of the range of weblinks
	 * @param end the upper bound of the range of weblinks (not inclusive)
	 * @return the range of matching weblinks
	 * @throws SystemException if a system exception occurred
	 */
	public List<Weblink> findByCategory(long weblinkCategoryId, int start,
		int end) throws SystemException {
		return findByCategory(weblinkCategoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the weblinks where weblinkCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param weblinkCategoryId the weblink category ID
	 * @param start the lower bound of the range of weblinks
	 * @param end the upper bound of the range of weblinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching weblinks
	 * @throws SystemException if a system exception occurred
	 */
	public List<Weblink> findByCategory(long weblinkCategoryId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY;
			finderArgs = new Object[] { weblinkCategoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORY;
			finderArgs = new Object[] {
					weblinkCategoryId,
					
					start, end, orderByComparator
				};
		}

		List<Weblink> list = (List<Weblink>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Weblink weblink : list) {
				if ((weblinkCategoryId != weblink.getWeblinkCategoryId())) {
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

			query.append(_SQL_SELECT_WEBLINK_WHERE);

			query.append(_FINDER_COLUMN_CATEGORY_WEBLINKCATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(WeblinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(weblinkCategoryId);

				list = (List<Weblink>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first weblink in the ordered set where weblinkCategoryId = &#63;.
	 *
	 * @param weblinkCategoryId the weblink category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching weblink
	 * @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkException if a matching weblink could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Weblink findByCategory_First(long weblinkCategoryId,
		OrderByComparator orderByComparator)
		throws NoSuchWeblinkException, SystemException {
		Weblink weblink = fetchByCategory_First(weblinkCategoryId,
				orderByComparator);

		if (weblink != null) {
			return weblink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("weblinkCategoryId=");
		msg.append(weblinkCategoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWeblinkException(msg.toString());
	}

	/**
	 * Returns the first weblink in the ordered set where weblinkCategoryId = &#63;.
	 *
	 * @param weblinkCategoryId the weblink category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching weblink, or <code>null</code> if a matching weblink could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Weblink fetchByCategory_First(long weblinkCategoryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Weblink> list = findByCategory(weblinkCategoryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last weblink in the ordered set where weblinkCategoryId = &#63;.
	 *
	 * @param weblinkCategoryId the weblink category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching weblink
	 * @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkException if a matching weblink could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Weblink findByCategory_Last(long weblinkCategoryId,
		OrderByComparator orderByComparator)
		throws NoSuchWeblinkException, SystemException {
		Weblink weblink = fetchByCategory_Last(weblinkCategoryId,
				orderByComparator);

		if (weblink != null) {
			return weblink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("weblinkCategoryId=");
		msg.append(weblinkCategoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWeblinkException(msg.toString());
	}

	/**
	 * Returns the last weblink in the ordered set where weblinkCategoryId = &#63;.
	 *
	 * @param weblinkCategoryId the weblink category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching weblink, or <code>null</code> if a matching weblink could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Weblink fetchByCategory_Last(long weblinkCategoryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCategory(weblinkCategoryId);

		List<Weblink> list = findByCategory(weblinkCategoryId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the weblinks before and after the current weblink in the ordered set where weblinkCategoryId = &#63;.
	 *
	 * @param weblinkId the primary key of the current weblink
	 * @param weblinkCategoryId the weblink category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next weblink
	 * @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkException if a weblink with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Weblink[] findByCategory_PrevAndNext(long weblinkId,
		long weblinkCategoryId, OrderByComparator orderByComparator)
		throws NoSuchWeblinkException, SystemException {
		Weblink weblink = findByPrimaryKey(weblinkId);

		Session session = null;

		try {
			session = openSession();

			Weblink[] array = new WeblinkImpl[3];

			array[0] = getByCategory_PrevAndNext(session, weblink,
					weblinkCategoryId, orderByComparator, true);

			array[1] = weblink;

			array[2] = getByCategory_PrevAndNext(session, weblink,
					weblinkCategoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Weblink getByCategory_PrevAndNext(Session session,
		Weblink weblink, long weblinkCategoryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WEBLINK_WHERE);

		query.append(_FINDER_COLUMN_CATEGORY_WEBLINKCATEGORYID_2);

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
			query.append(WeblinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(weblinkCategoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(weblink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Weblink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the weblinks.
	 *
	 * @return the weblinks
	 * @throws SystemException if a system exception occurred
	 */
	public List<Weblink> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the weblinks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of weblinks
	 * @param end the upper bound of the range of weblinks (not inclusive)
	 * @return the range of weblinks
	 * @throws SystemException if a system exception occurred
	 */
	public List<Weblink> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the weblinks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of weblinks
	 * @param end the upper bound of the range of weblinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of weblinks
	 * @throws SystemException if a system exception occurred
	 */
	public List<Weblink> findAll(int start, int end,
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

		List<Weblink> list = (List<Weblink>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_WEBLINK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WEBLINK.concat(WeblinkModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Weblink>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Weblink>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the weblinks where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompany(long companyId) throws SystemException {
		for (Weblink weblink : findByCompany(companyId)) {
			remove(weblink);
		}
	}

	/**
	 * Removes all the weblinks where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (Weblink weblink : findByGroup(groupId)) {
			remove(weblink);
		}
	}

	/**
	 * Removes all the weblinks where weblinkCategoryId = &#63; from the database.
	 *
	 * @param weblinkCategoryId the weblink category ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCategory(long weblinkCategoryId)
		throws SystemException {
		for (Weblink weblink : findByCategory(weblinkCategoryId)) {
			remove(weblink);
		}
	}

	/**
	 * Removes all the weblinks from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Weblink weblink : findAll()) {
			remove(weblink);
		}
	}

	/**
	 * Returns the number of weblinks where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching weblinks
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompany(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WEBLINK_WHERE);

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
	 * Returns the number of weblinks where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching weblinks
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WEBLINK_WHERE);

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
	 * Returns the number of weblinks that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching weblinks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroup(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroup(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_WEBLINK_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Weblink.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

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
	 * Returns the number of weblinks where weblinkCategoryId = &#63;.
	 *
	 * @param weblinkCategoryId the weblink category ID
	 * @return the number of matching weblinks
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCategory(long weblinkCategoryId)
		throws SystemException {
		Object[] finderArgs = new Object[] { weblinkCategoryId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CATEGORY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WEBLINK_WHERE);

			query.append(_FINDER_COLUMN_CATEGORY_WEBLINKCATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(weblinkCategoryId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CATEGORY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of weblinks.
	 *
	 * @return the number of weblinks
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WEBLINK);

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
	 * Initializes the weblink persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.portal_egov.portlet.weblinks.model.Weblink")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Weblink>> listenersList = new ArrayList<ModelListener<Weblink>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Weblink>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(WeblinkImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = WeblinkPersistence.class)
	protected WeblinkPersistence weblinkPersistence;
	@BeanReference(type = WeblinkCategoryPersistence.class)
	protected WeblinkCategoryPersistence weblinkCategoryPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_WEBLINK = "SELECT weblink FROM Weblink weblink";
	private static final String _SQL_SELECT_WEBLINK_WHERE = "SELECT weblink FROM Weblink weblink WHERE ";
	private static final String _SQL_COUNT_WEBLINK = "SELECT COUNT(weblink) FROM Weblink weblink";
	private static final String _SQL_COUNT_WEBLINK_WHERE = "SELECT COUNT(weblink) FROM Weblink weblink WHERE ";
	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "weblink.companyId = ?";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "weblink.groupId = ?";
	private static final String _FINDER_COLUMN_CATEGORY_WEBLINKCATEGORYID_2 = "weblink.weblinkCategoryId = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "weblink.weblinkId";
	private static final String _FILTER_SQL_SELECT_WEBLINK_WHERE = "SELECT DISTINCT {weblink.*} FROM Weblink weblink WHERE ";
	private static final String _FILTER_SQL_SELECT_WEBLINK_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {Weblink.*} FROM (SELECT DISTINCT weblink.weblinkId FROM Weblink weblink WHERE ";
	private static final String _FILTER_SQL_SELECT_WEBLINK_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN Weblink ON TEMP_TABLE.weblinkId = Weblink.weblinkId";
	private static final String _FILTER_SQL_COUNT_WEBLINK_WHERE = "SELECT COUNT(DISTINCT weblink.weblinkId) AS COUNT_VALUE FROM Weblink weblink WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "weblink";
	private static final String _FILTER_ENTITY_TABLE = "Weblink";
	private static final String _ORDER_BY_ENTITY_ALIAS = "weblink.";
	private static final String _ORDER_BY_ENTITY_TABLE = "Weblink.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Weblink exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Weblink exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(WeblinkPersistenceImpl.class);
	private static Weblink _nullWeblink = new WeblinkImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Weblink> toCacheModel() {
				return _nullWeblinkCacheModel;
			}
		};

	private static CacheModel<Weblink> _nullWeblinkCacheModel = new CacheModel<Weblink>() {
			public Weblink toEntityModel() {
				return _nullWeblink;
			}
		};
}