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

package com.portal_egov.portlet.banner.service.persistence;

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

import com.portal_egov.portlet.banner.NoSuchBannerGroupException;
import com.portal_egov.portlet.banner.model.BannerGroup;
import com.portal_egov.portlet.banner.model.impl.BannerGroupImpl;
import com.portal_egov.portlet.banner.model.impl.BannerGroupModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the banner group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see BannerGroupPersistence
 * @see BannerGroupUtil
 * @generated
 */
public class BannerGroupPersistenceImpl extends BasePersistenceImpl<BannerGroup>
	implements BannerGroupPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BannerGroupUtil} to access the banner group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BannerGroupImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(BannerGroupModelImpl.ENTITY_CACHE_ENABLED,
			BannerGroupModelImpl.FINDER_CACHE_ENABLED, BannerGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(BannerGroupModelImpl.ENTITY_CACHE_ENABLED,
			BannerGroupModelImpl.FINDER_CACHE_ENABLED, BannerGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			BannerGroupModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(BannerGroupModelImpl.ENTITY_CACHE_ENABLED,
			BannerGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(BannerGroupModelImpl.ENTITY_CACHE_ENABLED,
			BannerGroupModelImpl.FINDER_CACHE_ENABLED, BannerGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(BannerGroupModelImpl.ENTITY_CACHE_ENABLED,
			BannerGroupModelImpl.FINDER_CACHE_ENABLED, BannerGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			BannerGroupModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(BannerGroupModelImpl.ENTITY_CACHE_ENABLED,
			BannerGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BannerGroupModelImpl.ENTITY_CACHE_ENABLED,
			BannerGroupModelImpl.FINDER_CACHE_ENABLED, BannerGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BannerGroupModelImpl.ENTITY_CACHE_ENABLED,
			BannerGroupModelImpl.FINDER_CACHE_ENABLED, BannerGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BannerGroupModelImpl.ENTITY_CACHE_ENABLED,
			BannerGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the banner group in the entity cache if it is enabled.
	 *
	 * @param bannerGroup the banner group
	 */
	public void cacheResult(BannerGroup bannerGroup) {
		EntityCacheUtil.putResult(BannerGroupModelImpl.ENTITY_CACHE_ENABLED,
			BannerGroupImpl.class, bannerGroup.getPrimaryKey(), bannerGroup);

		bannerGroup.resetOriginalValues();
	}

	/**
	 * Caches the banner groups in the entity cache if it is enabled.
	 *
	 * @param bannerGroups the banner groups
	 */
	public void cacheResult(List<BannerGroup> bannerGroups) {
		for (BannerGroup bannerGroup : bannerGroups) {
			if (EntityCacheUtil.getResult(
						BannerGroupModelImpl.ENTITY_CACHE_ENABLED,
						BannerGroupImpl.class, bannerGroup.getPrimaryKey()) == null) {
				cacheResult(bannerGroup);
			}
			else {
				bannerGroup.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all banner groups.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BannerGroupImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BannerGroupImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the banner group.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BannerGroup bannerGroup) {
		EntityCacheUtil.removeResult(BannerGroupModelImpl.ENTITY_CACHE_ENABLED,
			BannerGroupImpl.class, bannerGroup.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BannerGroup> bannerGroups) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BannerGroup bannerGroup : bannerGroups) {
			EntityCacheUtil.removeResult(BannerGroupModelImpl.ENTITY_CACHE_ENABLED,
				BannerGroupImpl.class, bannerGroup.getPrimaryKey());
		}
	}

	/**
	 * Creates a new banner group with the primary key. Does not add the banner group to the database.
	 *
	 * @param bannerGroupId the primary key for the new banner group
	 * @return the new banner group
	 */
	public BannerGroup create(long bannerGroupId) {
		BannerGroup bannerGroup = new BannerGroupImpl();

		bannerGroup.setNew(true);
		bannerGroup.setPrimaryKey(bannerGroupId);

		return bannerGroup;
	}

	/**
	 * Removes the banner group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bannerGroupId the primary key of the banner group
	 * @return the banner group that was removed
	 * @throws com.portal_egov.portlet.banner.NoSuchBannerGroupException if a banner group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BannerGroup remove(long bannerGroupId)
		throws NoSuchBannerGroupException, SystemException {
		return remove(Long.valueOf(bannerGroupId));
	}

	/**
	 * Removes the banner group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the banner group
	 * @return the banner group that was removed
	 * @throws com.portal_egov.portlet.banner.NoSuchBannerGroupException if a banner group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BannerGroup remove(Serializable primaryKey)
		throws NoSuchBannerGroupException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BannerGroup bannerGroup = (BannerGroup)session.get(BannerGroupImpl.class,
					primaryKey);

			if (bannerGroup == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBannerGroupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(bannerGroup);
		}
		catch (NoSuchBannerGroupException nsee) {
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
	protected BannerGroup removeImpl(BannerGroup bannerGroup)
		throws SystemException {
		bannerGroup = toUnwrappedModel(bannerGroup);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, bannerGroup);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(bannerGroup);

		return bannerGroup;
	}

	@Override
	public BannerGroup updateImpl(
		com.portal_egov.portlet.banner.model.BannerGroup bannerGroup,
		boolean merge) throws SystemException {
		bannerGroup = toUnwrappedModel(bannerGroup);

		boolean isNew = bannerGroup.isNew();

		BannerGroupModelImpl bannerGroupModelImpl = (BannerGroupModelImpl)bannerGroup;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, bannerGroup, merge);

			bannerGroup.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BannerGroupModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((bannerGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(bannerGroupModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] {
						Long.valueOf(bannerGroupModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((bannerGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(bannerGroupModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] {
						Long.valueOf(bannerGroupModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(BannerGroupModelImpl.ENTITY_CACHE_ENABLED,
			BannerGroupImpl.class, bannerGroup.getPrimaryKey(), bannerGroup);

		return bannerGroup;
	}

	protected BannerGroup toUnwrappedModel(BannerGroup bannerGroup) {
		if (bannerGroup instanceof BannerGroupImpl) {
			return bannerGroup;
		}

		BannerGroupImpl bannerGroupImpl = new BannerGroupImpl();

		bannerGroupImpl.setNew(bannerGroup.isNew());
		bannerGroupImpl.setPrimaryKey(bannerGroup.getPrimaryKey());

		bannerGroupImpl.setBannerGroupId(bannerGroup.getBannerGroupId());
		bannerGroupImpl.setCompanyId(bannerGroup.getCompanyId());
		bannerGroupImpl.setGroupId(bannerGroup.getGroupId());
		bannerGroupImpl.setUserId(bannerGroup.getUserId());
		bannerGroupImpl.setUserName(bannerGroup.getUserName());
		bannerGroupImpl.setCreateDate(bannerGroup.getCreateDate());
		bannerGroupImpl.setModifiedDate(bannerGroup.getModifiedDate());
		bannerGroupImpl.setGroupName(bannerGroup.getGroupName());
		bannerGroupImpl.setGroupDesc(bannerGroup.getGroupDesc());

		return bannerGroupImpl;
	}

	/**
	 * Returns the banner group with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the banner group
	 * @return the banner group
	 * @throws com.liferay.portal.NoSuchModelException if a banner group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BannerGroup findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the banner group with the primary key or throws a {@link com.portal_egov.portlet.banner.NoSuchBannerGroupException} if it could not be found.
	 *
	 * @param bannerGroupId the primary key of the banner group
	 * @return the banner group
	 * @throws com.portal_egov.portlet.banner.NoSuchBannerGroupException if a banner group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BannerGroup findByPrimaryKey(long bannerGroupId)
		throws NoSuchBannerGroupException, SystemException {
		BannerGroup bannerGroup = fetchByPrimaryKey(bannerGroupId);

		if (bannerGroup == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + bannerGroupId);
			}

			throw new NoSuchBannerGroupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				bannerGroupId);
		}

		return bannerGroup;
	}

	/**
	 * Returns the banner group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the banner group
	 * @return the banner group, or <code>null</code> if a banner group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BannerGroup fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the banner group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bannerGroupId the primary key of the banner group
	 * @return the banner group, or <code>null</code> if a banner group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BannerGroup fetchByPrimaryKey(long bannerGroupId)
		throws SystemException {
		BannerGroup bannerGroup = (BannerGroup)EntityCacheUtil.getResult(BannerGroupModelImpl.ENTITY_CACHE_ENABLED,
				BannerGroupImpl.class, bannerGroupId);

		if (bannerGroup == _nullBannerGroup) {
			return null;
		}

		if (bannerGroup == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				bannerGroup = (BannerGroup)session.get(BannerGroupImpl.class,
						Long.valueOf(bannerGroupId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (bannerGroup != null) {
					cacheResult(bannerGroup);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(BannerGroupModelImpl.ENTITY_CACHE_ENABLED,
						BannerGroupImpl.class, bannerGroupId, _nullBannerGroup);
				}

				closeSession(session);
			}
		}

		return bannerGroup;
	}

	/**
	 * Returns all the banner groups where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching banner groups
	 * @throws SystemException if a system exception occurred
	 */
	public List<BannerGroup> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the banner groups where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of banner groups
	 * @param end the upper bound of the range of banner groups (not inclusive)
	 * @return the range of matching banner groups
	 * @throws SystemException if a system exception occurred
	 */
	public List<BannerGroup> findByCompany(long companyId, int start, int end)
		throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the banner groups where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of banner groups
	 * @param end the upper bound of the range of banner groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching banner groups
	 * @throws SystemException if a system exception occurred
	 */
	public List<BannerGroup> findByCompany(long companyId, int start, int end,
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

		List<BannerGroup> list = (List<BannerGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BannerGroup bannerGroup : list) {
				if ((companyId != bannerGroup.getCompanyId())) {
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

			query.append(_SQL_SELECT_BANNERGROUP_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(BannerGroupModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<BannerGroup>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first banner group in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner group
	 * @throws com.portal_egov.portlet.banner.NoSuchBannerGroupException if a matching banner group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BannerGroup findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchBannerGroupException, SystemException {
		BannerGroup bannerGroup = fetchByCompany_First(companyId,
				orderByComparator);

		if (bannerGroup != null) {
			return bannerGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBannerGroupException(msg.toString());
	}

	/**
	 * Returns the first banner group in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner group, or <code>null</code> if a matching banner group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BannerGroup fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<BannerGroup> list = findByCompany(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last banner group in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner group
	 * @throws com.portal_egov.portlet.banner.NoSuchBannerGroupException if a matching banner group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BannerGroup findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchBannerGroupException, SystemException {
		BannerGroup bannerGroup = fetchByCompany_Last(companyId,
				orderByComparator);

		if (bannerGroup != null) {
			return bannerGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBannerGroupException(msg.toString());
	}

	/**
	 * Returns the last banner group in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner group, or <code>null</code> if a matching banner group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BannerGroup fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		List<BannerGroup> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the banner groups before and after the current banner group in the ordered set where companyId = &#63;.
	 *
	 * @param bannerGroupId the primary key of the current banner group
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next banner group
	 * @throws com.portal_egov.portlet.banner.NoSuchBannerGroupException if a banner group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BannerGroup[] findByCompany_PrevAndNext(long bannerGroupId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchBannerGroupException, SystemException {
		BannerGroup bannerGroup = findByPrimaryKey(bannerGroupId);

		Session session = null;

		try {
			session = openSession();

			BannerGroup[] array = new BannerGroupImpl[3];

			array[0] = getByCompany_PrevAndNext(session, bannerGroup,
					companyId, orderByComparator, true);

			array[1] = bannerGroup;

			array[2] = getByCompany_PrevAndNext(session, bannerGroup,
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

	protected BannerGroup getByCompany_PrevAndNext(Session session,
		BannerGroup bannerGroup, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BANNERGROUP_WHERE);

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
			query.append(BannerGroupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(bannerGroup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BannerGroup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the banner groups where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching banner groups
	 * @throws SystemException if a system exception occurred
	 */
	public List<BannerGroup> findByGroup(long groupId)
		throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the banner groups where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of banner groups
	 * @param end the upper bound of the range of banner groups (not inclusive)
	 * @return the range of matching banner groups
	 * @throws SystemException if a system exception occurred
	 */
	public List<BannerGroup> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the banner groups where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of banner groups
	 * @param end the upper bound of the range of banner groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching banner groups
	 * @throws SystemException if a system exception occurred
	 */
	public List<BannerGroup> findByGroup(long groupId, int start, int end,
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

		List<BannerGroup> list = (List<BannerGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BannerGroup bannerGroup : list) {
				if ((groupId != bannerGroup.getGroupId())) {
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

			query.append(_SQL_SELECT_BANNERGROUP_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(BannerGroupModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<BannerGroup>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first banner group in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner group
	 * @throws com.portal_egov.portlet.banner.NoSuchBannerGroupException if a matching banner group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BannerGroup findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchBannerGroupException, SystemException {
		BannerGroup bannerGroup = fetchByGroup_First(groupId, orderByComparator);

		if (bannerGroup != null) {
			return bannerGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBannerGroupException(msg.toString());
	}

	/**
	 * Returns the first banner group in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner group, or <code>null</code> if a matching banner group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BannerGroup fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<BannerGroup> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last banner group in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner group
	 * @throws com.portal_egov.portlet.banner.NoSuchBannerGroupException if a matching banner group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BannerGroup findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchBannerGroupException, SystemException {
		BannerGroup bannerGroup = fetchByGroup_Last(groupId, orderByComparator);

		if (bannerGroup != null) {
			return bannerGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBannerGroupException(msg.toString());
	}

	/**
	 * Returns the last banner group in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner group, or <code>null</code> if a matching banner group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BannerGroup fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<BannerGroup> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the banner groups before and after the current banner group in the ordered set where groupId = &#63;.
	 *
	 * @param bannerGroupId the primary key of the current banner group
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next banner group
	 * @throws com.portal_egov.portlet.banner.NoSuchBannerGroupException if a banner group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BannerGroup[] findByGroup_PrevAndNext(long bannerGroupId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchBannerGroupException, SystemException {
		BannerGroup bannerGroup = findByPrimaryKey(bannerGroupId);

		Session session = null;

		try {
			session = openSession();

			BannerGroup[] array = new BannerGroupImpl[3];

			array[0] = getByGroup_PrevAndNext(session, bannerGroup, groupId,
					orderByComparator, true);

			array[1] = bannerGroup;

			array[2] = getByGroup_PrevAndNext(session, bannerGroup, groupId,
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

	protected BannerGroup getByGroup_PrevAndNext(Session session,
		BannerGroup bannerGroup, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BANNERGROUP_WHERE);

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
			query.append(BannerGroupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(bannerGroup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BannerGroup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the banner groups that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching banner groups that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<BannerGroup> filterFindByGroup(long groupId)
		throws SystemException {
		return filterFindByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the banner groups that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of banner groups
	 * @param end the upper bound of the range of banner groups (not inclusive)
	 * @return the range of matching banner groups that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<BannerGroup> filterFindByGroup(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the banner groups that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of banner groups
	 * @param end the upper bound of the range of banner groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching banner groups that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<BannerGroup> filterFindByGroup(long groupId, int start,
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
			query.append(_FILTER_SQL_SELECT_BANNERGROUP_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_BANNERGROUP_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_BANNERGROUP_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(BannerGroupModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(BannerGroupModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				BannerGroup.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, BannerGroupImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, BannerGroupImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<BannerGroup>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the banner groups before and after the current banner group in the ordered set of banner groups that the user has permission to view where groupId = &#63;.
	 *
	 * @param bannerGroupId the primary key of the current banner group
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next banner group
	 * @throws com.portal_egov.portlet.banner.NoSuchBannerGroupException if a banner group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BannerGroup[] filterFindByGroup_PrevAndNext(long bannerGroupId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchBannerGroupException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup_PrevAndNext(bannerGroupId, groupId,
				orderByComparator);
		}

		BannerGroup bannerGroup = findByPrimaryKey(bannerGroupId);

		Session session = null;

		try {
			session = openSession();

			BannerGroup[] array = new BannerGroupImpl[3];

			array[0] = filterGetByGroup_PrevAndNext(session, bannerGroup,
					groupId, orderByComparator, true);

			array[1] = bannerGroup;

			array[2] = filterGetByGroup_PrevAndNext(session, bannerGroup,
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

	protected BannerGroup filterGetByGroup_PrevAndNext(Session session,
		BannerGroup bannerGroup, long groupId,
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
			query.append(_FILTER_SQL_SELECT_BANNERGROUP_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_BANNERGROUP_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_BANNERGROUP_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(BannerGroupModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(BannerGroupModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				BannerGroup.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, BannerGroupImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, BannerGroupImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(bannerGroup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BannerGroup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the banner groups.
	 *
	 * @return the banner groups
	 * @throws SystemException if a system exception occurred
	 */
	public List<BannerGroup> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the banner groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of banner groups
	 * @param end the upper bound of the range of banner groups (not inclusive)
	 * @return the range of banner groups
	 * @throws SystemException if a system exception occurred
	 */
	public List<BannerGroup> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the banner groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of banner groups
	 * @param end the upper bound of the range of banner groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of banner groups
	 * @throws SystemException if a system exception occurred
	 */
	public List<BannerGroup> findAll(int start, int end,
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

		List<BannerGroup> list = (List<BannerGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BANNERGROUP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BANNERGROUP.concat(BannerGroupModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<BannerGroup>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<BannerGroup>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the banner groups where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompany(long companyId) throws SystemException {
		for (BannerGroup bannerGroup : findByCompany(companyId)) {
			remove(bannerGroup);
		}
	}

	/**
	 * Removes all the banner groups where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (BannerGroup bannerGroup : findByGroup(groupId)) {
			remove(bannerGroup);
		}
	}

	/**
	 * Removes all the banner groups from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (BannerGroup bannerGroup : findAll()) {
			remove(bannerGroup);
		}
	}

	/**
	 * Returns the number of banner groups where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching banner groups
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompany(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BANNERGROUP_WHERE);

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
	 * Returns the number of banner groups where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching banner groups
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BANNERGROUP_WHERE);

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
	 * Returns the number of banner groups that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching banner groups that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroup(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroup(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_BANNERGROUP_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				BannerGroup.class.getName(),
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
	 * Returns the number of banner groups.
	 *
	 * @return the number of banner groups
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BANNERGROUP);

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
	 * Initializes the banner group persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.portal_egov.portlet.banner.model.BannerGroup")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BannerGroup>> listenersList = new ArrayList<ModelListener<BannerGroup>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BannerGroup>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BannerGroupImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = BannerPersistence.class)
	protected BannerPersistence bannerPersistence;
	@BeanReference(type = BannerGroupPersistence.class)
	protected BannerGroupPersistence bannerGroupPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_BANNERGROUP = "SELECT bannerGroup FROM BannerGroup bannerGroup";
	private static final String _SQL_SELECT_BANNERGROUP_WHERE = "SELECT bannerGroup FROM BannerGroup bannerGroup WHERE ";
	private static final String _SQL_COUNT_BANNERGROUP = "SELECT COUNT(bannerGroup) FROM BannerGroup bannerGroup";
	private static final String _SQL_COUNT_BANNERGROUP_WHERE = "SELECT COUNT(bannerGroup) FROM BannerGroup bannerGroup WHERE ";
	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "bannerGroup.companyId = ?";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "bannerGroup.groupId = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "bannerGroup.bannerGroupId";
	private static final String _FILTER_SQL_SELECT_BANNERGROUP_WHERE = "SELECT DISTINCT {bannerGroup.*} FROM BannerGroup bannerGroup WHERE ";
	private static final String _FILTER_SQL_SELECT_BANNERGROUP_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {BannerGroup.*} FROM (SELECT DISTINCT bannerGroup.bannerGroupId FROM BannerGroup bannerGroup WHERE ";
	private static final String _FILTER_SQL_SELECT_BANNERGROUP_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN BannerGroup ON TEMP_TABLE.bannerGroupId = BannerGroup.bannerGroupId";
	private static final String _FILTER_SQL_COUNT_BANNERGROUP_WHERE = "SELECT COUNT(DISTINCT bannerGroup.bannerGroupId) AS COUNT_VALUE FROM BannerGroup bannerGroup WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "bannerGroup";
	private static final String _FILTER_ENTITY_TABLE = "BannerGroup";
	private static final String _ORDER_BY_ENTITY_ALIAS = "bannerGroup.";
	private static final String _ORDER_BY_ENTITY_TABLE = "BannerGroup.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BannerGroup exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BannerGroup exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BannerGroupPersistenceImpl.class);
	private static BannerGroup _nullBannerGroup = new BannerGroupImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BannerGroup> toCacheModel() {
				return _nullBannerGroupCacheModel;
			}
		};

	private static CacheModel<BannerGroup> _nullBannerGroupCacheModel = new CacheModel<BannerGroup>() {
			public BannerGroup toEntityModel() {
				return _nullBannerGroup;
			}
		};
}