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

import com.portal_egov.portlet.banner.NoSuchBannerException;
import com.portal_egov.portlet.banner.model.Banner;
import com.portal_egov.portlet.banner.model.impl.BannerImpl;
import com.portal_egov.portlet.banner.model.impl.BannerModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the banner service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see BannerPersistence
 * @see BannerUtil
 * @generated
 */
public class BannerPersistenceImpl extends BasePersistenceImpl<Banner>
	implements BannerPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BannerUtil} to access the banner persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BannerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerModelImpl.FINDER_CACHE_ENABLED, BannerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerModelImpl.FINDER_CACHE_ENABLED, BannerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			BannerModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerModelImpl.FINDER_CACHE_ENABLED, BannerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerModelImpl.FINDER_CACHE_ENABLED, BannerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			BannerModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BANNERGROUP =
		new FinderPath(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerModelImpl.FINDER_CACHE_ENABLED, BannerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBannerGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BANNERGROUP =
		new FinderPath(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerModelImpl.FINDER_CACHE_ENABLED, BannerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBannerGroup",
			new String[] { Long.class.getName() },
			BannerModelImpl.BANNERGROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BANNERGROUP = new FinderPath(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBannerGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerModelImpl.FINDER_CACHE_ENABLED, BannerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerModelImpl.FINDER_CACHE_ENABLED, BannerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the banner in the entity cache if it is enabled.
	 *
	 * @param banner the banner
	 */
	public void cacheResult(Banner banner) {
		EntityCacheUtil.putResult(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerImpl.class, banner.getPrimaryKey(), banner);

		banner.resetOriginalValues();
	}

	/**
	 * Caches the banners in the entity cache if it is enabled.
	 *
	 * @param banners the banners
	 */
	public void cacheResult(List<Banner> banners) {
		for (Banner banner : banners) {
			if (EntityCacheUtil.getResult(
						BannerModelImpl.ENTITY_CACHE_ENABLED, BannerImpl.class,
						banner.getPrimaryKey()) == null) {
				cacheResult(banner);
			}
			else {
				banner.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all banners.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BannerImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BannerImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the banner.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Banner banner) {
		EntityCacheUtil.removeResult(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerImpl.class, banner.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Banner> banners) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Banner banner : banners) {
			EntityCacheUtil.removeResult(BannerModelImpl.ENTITY_CACHE_ENABLED,
				BannerImpl.class, banner.getPrimaryKey());
		}
	}

	/**
	 * Creates a new banner with the primary key. Does not add the banner to the database.
	 *
	 * @param bannerId the primary key for the new banner
	 * @return the new banner
	 */
	public Banner create(long bannerId) {
		Banner banner = new BannerImpl();

		banner.setNew(true);
		banner.setPrimaryKey(bannerId);

		return banner;
	}

	/**
	 * Removes the banner with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bannerId the primary key of the banner
	 * @return the banner that was removed
	 * @throws com.portal_egov.portlet.banner.NoSuchBannerException if a banner with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Banner remove(long bannerId)
		throws NoSuchBannerException, SystemException {
		return remove(Long.valueOf(bannerId));
	}

	/**
	 * Removes the banner with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the banner
	 * @return the banner that was removed
	 * @throws com.portal_egov.portlet.banner.NoSuchBannerException if a banner with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Banner remove(Serializable primaryKey)
		throws NoSuchBannerException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Banner banner = (Banner)session.get(BannerImpl.class, primaryKey);

			if (banner == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBannerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(banner);
		}
		catch (NoSuchBannerException nsee) {
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
	protected Banner removeImpl(Banner banner) throws SystemException {
		banner = toUnwrappedModel(banner);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, banner);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(banner);

		return banner;
	}

	@Override
	public Banner updateImpl(
		com.portal_egov.portlet.banner.model.Banner banner, boolean merge)
		throws SystemException {
		banner = toUnwrappedModel(banner);

		boolean isNew = banner.isNew();

		BannerModelImpl bannerModelImpl = (BannerModelImpl)banner;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, banner, merge);

			banner.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BannerModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((bannerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(bannerModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] { Long.valueOf(bannerModelImpl.getCompanyId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((bannerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(bannerModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] { Long.valueOf(bannerModelImpl.getGroupId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}

			if ((bannerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BANNERGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(bannerModelImpl.getOriginalBannerGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BANNERGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BANNERGROUP,
					args);

				args = new Object[] {
						Long.valueOf(bannerModelImpl.getBannerGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BANNERGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BANNERGROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerImpl.class, banner.getPrimaryKey(), banner);

		return banner;
	}

	protected Banner toUnwrappedModel(Banner banner) {
		if (banner instanceof BannerImpl) {
			return banner;
		}

		BannerImpl bannerImpl = new BannerImpl();

		bannerImpl.setNew(banner.isNew());
		bannerImpl.setPrimaryKey(banner.getPrimaryKey());

		bannerImpl.setBannerId(banner.getBannerId());
		bannerImpl.setCompanyId(banner.getCompanyId());
		bannerImpl.setGroupId(banner.getGroupId());
		bannerImpl.setUserId(banner.getUserId());
		bannerImpl.setUserName(banner.getUserName());
		bannerImpl.setCreateDate(banner.getCreateDate());
		bannerImpl.setModifiedDate(banner.getModifiedDate());
		bannerImpl.setBannerGroupId(banner.getBannerGroupId());
		bannerImpl.setBannerTitle(banner.getBannerTitle());
		bannerImpl.setBannerLink(banner.getBannerLink());
		bannerImpl.setBannerImageId(banner.getBannerImageId());
		bannerImpl.setViewCounter(banner.getViewCounter());
		bannerImpl.setBannerStatus(banner.getBannerStatus());

		return bannerImpl;
	}

	/**
	 * Returns the banner with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the banner
	 * @return the banner
	 * @throws com.liferay.portal.NoSuchModelException if a banner with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Banner findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the banner with the primary key or throws a {@link com.portal_egov.portlet.banner.NoSuchBannerException} if it could not be found.
	 *
	 * @param bannerId the primary key of the banner
	 * @return the banner
	 * @throws com.portal_egov.portlet.banner.NoSuchBannerException if a banner with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Banner findByPrimaryKey(long bannerId)
		throws NoSuchBannerException, SystemException {
		Banner banner = fetchByPrimaryKey(bannerId);

		if (banner == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + bannerId);
			}

			throw new NoSuchBannerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				bannerId);
		}

		return banner;
	}

	/**
	 * Returns the banner with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the banner
	 * @return the banner, or <code>null</code> if a banner with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Banner fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the banner with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bannerId the primary key of the banner
	 * @return the banner, or <code>null</code> if a banner with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Banner fetchByPrimaryKey(long bannerId) throws SystemException {
		Banner banner = (Banner)EntityCacheUtil.getResult(BannerModelImpl.ENTITY_CACHE_ENABLED,
				BannerImpl.class, bannerId);

		if (banner == _nullBanner) {
			return null;
		}

		if (banner == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				banner = (Banner)session.get(BannerImpl.class,
						Long.valueOf(bannerId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (banner != null) {
					cacheResult(banner);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(BannerModelImpl.ENTITY_CACHE_ENABLED,
						BannerImpl.class, bannerId, _nullBanner);
				}

				closeSession(session);
			}
		}

		return banner;
	}

	/**
	 * Returns all the banners where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching banners
	 * @throws SystemException if a system exception occurred
	 */
	public List<Banner> findByCompany(long companyId) throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the banners where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of banners
	 * @param end the upper bound of the range of banners (not inclusive)
	 * @return the range of matching banners
	 * @throws SystemException if a system exception occurred
	 */
	public List<Banner> findByCompany(long companyId, int start, int end)
		throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the banners where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of banners
	 * @param end the upper bound of the range of banners (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching banners
	 * @throws SystemException if a system exception occurred
	 */
	public List<Banner> findByCompany(long companyId, int start, int end,
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

		List<Banner> list = (List<Banner>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Banner banner : list) {
				if ((companyId != banner.getCompanyId())) {
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

			query.append(_SQL_SELECT_BANNER_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(BannerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<Banner>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first banner in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner
	 * @throws com.portal_egov.portlet.banner.NoSuchBannerException if a matching banner could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Banner findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchBannerException, SystemException {
		Banner banner = fetchByCompany_First(companyId, orderByComparator);

		if (banner != null) {
			return banner;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBannerException(msg.toString());
	}

	/**
	 * Returns the first banner in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner, or <code>null</code> if a matching banner could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Banner fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Banner> list = findByCompany(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last banner in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner
	 * @throws com.portal_egov.portlet.banner.NoSuchBannerException if a matching banner could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Banner findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchBannerException, SystemException {
		Banner banner = fetchByCompany_Last(companyId, orderByComparator);

		if (banner != null) {
			return banner;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBannerException(msg.toString());
	}

	/**
	 * Returns the last banner in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner, or <code>null</code> if a matching banner could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Banner fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		List<Banner> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the banners before and after the current banner in the ordered set where companyId = &#63;.
	 *
	 * @param bannerId the primary key of the current banner
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next banner
	 * @throws com.portal_egov.portlet.banner.NoSuchBannerException if a banner with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Banner[] findByCompany_PrevAndNext(long bannerId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchBannerException, SystemException {
		Banner banner = findByPrimaryKey(bannerId);

		Session session = null;

		try {
			session = openSession();

			Banner[] array = new BannerImpl[3];

			array[0] = getByCompany_PrevAndNext(session, banner, companyId,
					orderByComparator, true);

			array[1] = banner;

			array[2] = getByCompany_PrevAndNext(session, banner, companyId,
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

	protected Banner getByCompany_PrevAndNext(Session session, Banner banner,
		long companyId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BANNER_WHERE);

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
			query.append(BannerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(banner);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Banner> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the banners where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching banners
	 * @throws SystemException if a system exception occurred
	 */
	public List<Banner> findByGroup(long groupId) throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the banners where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of banners
	 * @param end the upper bound of the range of banners (not inclusive)
	 * @return the range of matching banners
	 * @throws SystemException if a system exception occurred
	 */
	public List<Banner> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the banners where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of banners
	 * @param end the upper bound of the range of banners (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching banners
	 * @throws SystemException if a system exception occurred
	 */
	public List<Banner> findByGroup(long groupId, int start, int end,
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

		List<Banner> list = (List<Banner>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Banner banner : list) {
				if ((groupId != banner.getGroupId())) {
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

			query.append(_SQL_SELECT_BANNER_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(BannerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<Banner>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first banner in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner
	 * @throws com.portal_egov.portlet.banner.NoSuchBannerException if a matching banner could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Banner findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchBannerException, SystemException {
		Banner banner = fetchByGroup_First(groupId, orderByComparator);

		if (banner != null) {
			return banner;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBannerException(msg.toString());
	}

	/**
	 * Returns the first banner in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner, or <code>null</code> if a matching banner could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Banner fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Banner> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last banner in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner
	 * @throws com.portal_egov.portlet.banner.NoSuchBannerException if a matching banner could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Banner findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchBannerException, SystemException {
		Banner banner = fetchByGroup_Last(groupId, orderByComparator);

		if (banner != null) {
			return banner;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBannerException(msg.toString());
	}

	/**
	 * Returns the last banner in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner, or <code>null</code> if a matching banner could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Banner fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<Banner> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the banners before and after the current banner in the ordered set where groupId = &#63;.
	 *
	 * @param bannerId the primary key of the current banner
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next banner
	 * @throws com.portal_egov.portlet.banner.NoSuchBannerException if a banner with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Banner[] findByGroup_PrevAndNext(long bannerId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchBannerException, SystemException {
		Banner banner = findByPrimaryKey(bannerId);

		Session session = null;

		try {
			session = openSession();

			Banner[] array = new BannerImpl[3];

			array[0] = getByGroup_PrevAndNext(session, banner, groupId,
					orderByComparator, true);

			array[1] = banner;

			array[2] = getByGroup_PrevAndNext(session, banner, groupId,
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

	protected Banner getByGroup_PrevAndNext(Session session, Banner banner,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BANNER_WHERE);

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
			query.append(BannerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(banner);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Banner> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the banners that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching banners that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Banner> filterFindByGroup(long groupId)
		throws SystemException {
		return filterFindByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the banners that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of banners
	 * @param end the upper bound of the range of banners (not inclusive)
	 * @return the range of matching banners that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Banner> filterFindByGroup(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the banners that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of banners
	 * @param end the upper bound of the range of banners (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching banners that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Banner> filterFindByGroup(long groupId, int start, int end,
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
			query.append(_FILTER_SQL_SELECT_BANNER_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_BANNER_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_BANNER_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(BannerModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(BannerModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Banner.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, BannerImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, BannerImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<Banner>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the banners before and after the current banner in the ordered set of banners that the user has permission to view where groupId = &#63;.
	 *
	 * @param bannerId the primary key of the current banner
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next banner
	 * @throws com.portal_egov.portlet.banner.NoSuchBannerException if a banner with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Banner[] filterFindByGroup_PrevAndNext(long bannerId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchBannerException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup_PrevAndNext(bannerId, groupId, orderByComparator);
		}

		Banner banner = findByPrimaryKey(bannerId);

		Session session = null;

		try {
			session = openSession();

			Banner[] array = new BannerImpl[3];

			array[0] = filterGetByGroup_PrevAndNext(session, banner, groupId,
					orderByComparator, true);

			array[1] = banner;

			array[2] = filterGetByGroup_PrevAndNext(session, banner, groupId,
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

	protected Banner filterGetByGroup_PrevAndNext(Session session,
		Banner banner, long groupId, OrderByComparator orderByComparator,
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
			query.append(_FILTER_SQL_SELECT_BANNER_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_BANNER_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_BANNER_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(BannerModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(BannerModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Banner.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, BannerImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, BannerImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(banner);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Banner> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the banners where bannerGroupId = &#63;.
	 *
	 * @param bannerGroupId the banner group ID
	 * @return the matching banners
	 * @throws SystemException if a system exception occurred
	 */
	public List<Banner> findByBannerGroup(long bannerGroupId)
		throws SystemException {
		return findByBannerGroup(bannerGroupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the banners where bannerGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param bannerGroupId the banner group ID
	 * @param start the lower bound of the range of banners
	 * @param end the upper bound of the range of banners (not inclusive)
	 * @return the range of matching banners
	 * @throws SystemException if a system exception occurred
	 */
	public List<Banner> findByBannerGroup(long bannerGroupId, int start, int end)
		throws SystemException {
		return findByBannerGroup(bannerGroupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the banners where bannerGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param bannerGroupId the banner group ID
	 * @param start the lower bound of the range of banners
	 * @param end the upper bound of the range of banners (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching banners
	 * @throws SystemException if a system exception occurred
	 */
	public List<Banner> findByBannerGroup(long bannerGroupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BANNERGROUP;
			finderArgs = new Object[] { bannerGroupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BANNERGROUP;
			finderArgs = new Object[] {
					bannerGroupId,
					
					start, end, orderByComparator
				};
		}

		List<Banner> list = (List<Banner>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Banner banner : list) {
				if ((bannerGroupId != banner.getBannerGroupId())) {
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

			query.append(_SQL_SELECT_BANNER_WHERE);

			query.append(_FINDER_COLUMN_BANNERGROUP_BANNERGROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(BannerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(bannerGroupId);

				list = (List<Banner>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first banner in the ordered set where bannerGroupId = &#63;.
	 *
	 * @param bannerGroupId the banner group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner
	 * @throws com.portal_egov.portlet.banner.NoSuchBannerException if a matching banner could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Banner findByBannerGroup_First(long bannerGroupId,
		OrderByComparator orderByComparator)
		throws NoSuchBannerException, SystemException {
		Banner banner = fetchByBannerGroup_First(bannerGroupId,
				orderByComparator);

		if (banner != null) {
			return banner;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("bannerGroupId=");
		msg.append(bannerGroupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBannerException(msg.toString());
	}

	/**
	 * Returns the first banner in the ordered set where bannerGroupId = &#63;.
	 *
	 * @param bannerGroupId the banner group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner, or <code>null</code> if a matching banner could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Banner fetchByBannerGroup_First(long bannerGroupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Banner> list = findByBannerGroup(bannerGroupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last banner in the ordered set where bannerGroupId = &#63;.
	 *
	 * @param bannerGroupId the banner group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner
	 * @throws com.portal_egov.portlet.banner.NoSuchBannerException if a matching banner could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Banner findByBannerGroup_Last(long bannerGroupId,
		OrderByComparator orderByComparator)
		throws NoSuchBannerException, SystemException {
		Banner banner = fetchByBannerGroup_Last(bannerGroupId, orderByComparator);

		if (banner != null) {
			return banner;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("bannerGroupId=");
		msg.append(bannerGroupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBannerException(msg.toString());
	}

	/**
	 * Returns the last banner in the ordered set where bannerGroupId = &#63;.
	 *
	 * @param bannerGroupId the banner group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner, or <code>null</code> if a matching banner could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Banner fetchByBannerGroup_Last(long bannerGroupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByBannerGroup(bannerGroupId);

		List<Banner> list = findByBannerGroup(bannerGroupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the banners before and after the current banner in the ordered set where bannerGroupId = &#63;.
	 *
	 * @param bannerId the primary key of the current banner
	 * @param bannerGroupId the banner group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next banner
	 * @throws com.portal_egov.portlet.banner.NoSuchBannerException if a banner with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Banner[] findByBannerGroup_PrevAndNext(long bannerId,
		long bannerGroupId, OrderByComparator orderByComparator)
		throws NoSuchBannerException, SystemException {
		Banner banner = findByPrimaryKey(bannerId);

		Session session = null;

		try {
			session = openSession();

			Banner[] array = new BannerImpl[3];

			array[0] = getByBannerGroup_PrevAndNext(session, banner,
					bannerGroupId, orderByComparator, true);

			array[1] = banner;

			array[2] = getByBannerGroup_PrevAndNext(session, banner,
					bannerGroupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Banner getByBannerGroup_PrevAndNext(Session session,
		Banner banner, long bannerGroupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BANNER_WHERE);

		query.append(_FINDER_COLUMN_BANNERGROUP_BANNERGROUPID_2);

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
			query.append(BannerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(bannerGroupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(banner);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Banner> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the banners.
	 *
	 * @return the banners
	 * @throws SystemException if a system exception occurred
	 */
	public List<Banner> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the banners.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of banners
	 * @param end the upper bound of the range of banners (not inclusive)
	 * @return the range of banners
	 * @throws SystemException if a system exception occurred
	 */
	public List<Banner> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the banners.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of banners
	 * @param end the upper bound of the range of banners (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of banners
	 * @throws SystemException if a system exception occurred
	 */
	public List<Banner> findAll(int start, int end,
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

		List<Banner> list = (List<Banner>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BANNER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BANNER.concat(BannerModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Banner>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Banner>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the banners where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompany(long companyId) throws SystemException {
		for (Banner banner : findByCompany(companyId)) {
			remove(banner);
		}
	}

	/**
	 * Removes all the banners where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (Banner banner : findByGroup(groupId)) {
			remove(banner);
		}
	}

	/**
	 * Removes all the banners where bannerGroupId = &#63; from the database.
	 *
	 * @param bannerGroupId the banner group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByBannerGroup(long bannerGroupId)
		throws SystemException {
		for (Banner banner : findByBannerGroup(bannerGroupId)) {
			remove(banner);
		}
	}

	/**
	 * Removes all the banners from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Banner banner : findAll()) {
			remove(banner);
		}
	}

	/**
	 * Returns the number of banners where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching banners
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompany(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BANNER_WHERE);

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
	 * Returns the number of banners where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching banners
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BANNER_WHERE);

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
	 * Returns the number of banners that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching banners that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroup(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroup(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_BANNER_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Banner.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
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
	 * Returns the number of banners where bannerGroupId = &#63;.
	 *
	 * @param bannerGroupId the banner group ID
	 * @return the number of matching banners
	 * @throws SystemException if a system exception occurred
	 */
	public int countByBannerGroup(long bannerGroupId) throws SystemException {
		Object[] finderArgs = new Object[] { bannerGroupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_BANNERGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BANNER_WHERE);

			query.append(_FINDER_COLUMN_BANNERGROUP_BANNERGROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(bannerGroupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BANNERGROUP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of banners.
	 *
	 * @return the number of banners
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BANNER);

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
	 * Initializes the banner persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.portal_egov.portlet.banner.model.Banner")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Banner>> listenersList = new ArrayList<ModelListener<Banner>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Banner>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BannerImpl.class.getName());
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
	private static final String _SQL_SELECT_BANNER = "SELECT banner FROM Banner banner";
	private static final String _SQL_SELECT_BANNER_WHERE = "SELECT banner FROM Banner banner WHERE ";
	private static final String _SQL_COUNT_BANNER = "SELECT COUNT(banner) FROM Banner banner";
	private static final String _SQL_COUNT_BANNER_WHERE = "SELECT COUNT(banner) FROM Banner banner WHERE ";
	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "banner.companyId = ?";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "banner.groupId = ?";
	private static final String _FINDER_COLUMN_BANNERGROUP_BANNERGROUPID_2 = "banner.bannerGroupId = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "banner.bannerId";
	private static final String _FILTER_SQL_SELECT_BANNER_WHERE = "SELECT DISTINCT {banner.*} FROM Banner banner WHERE ";
	private static final String _FILTER_SQL_SELECT_BANNER_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {Banner.*} FROM (SELECT DISTINCT banner.bannerId FROM Banner banner WHERE ";
	private static final String _FILTER_SQL_SELECT_BANNER_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN Banner ON TEMP_TABLE.bannerId = Banner.bannerId";
	private static final String _FILTER_SQL_COUNT_BANNER_WHERE = "SELECT COUNT(DISTINCT banner.bannerId) AS COUNT_VALUE FROM Banner banner WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "banner";
	private static final String _FILTER_ENTITY_TABLE = "Banner";
	private static final String _ORDER_BY_ENTITY_ALIAS = "banner.";
	private static final String _ORDER_BY_ENTITY_TABLE = "Banner.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Banner exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Banner exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BannerPersistenceImpl.class);
	private static Banner _nullBanner = new BannerImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Banner> toCacheModel() {
				return _nullBannerCacheModel;
			}
		};

	private static CacheModel<Banner> _nullBannerCacheModel = new CacheModel<Banner>() {
			public Banner toEntityModel() {
				return _nullBanner;
			}
		};
}