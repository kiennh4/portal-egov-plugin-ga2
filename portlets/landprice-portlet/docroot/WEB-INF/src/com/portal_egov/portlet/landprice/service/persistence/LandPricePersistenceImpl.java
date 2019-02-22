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

package com.portal_egov.portlet.landprice.service.persistence;

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

import com.portal_egov.portlet.landprice.NoSuchLandPriceException;
import com.portal_egov.portlet.landprice.model.LandPrice;
import com.portal_egov.portlet.landprice.model.impl.LandPriceImpl;
import com.portal_egov.portlet.landprice.model.impl.LandPriceModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the land price service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see LandPricePersistence
 * @see LandPriceUtil
 * @generated
 */
public class LandPricePersistenceImpl extends BasePersistenceImpl<LandPrice>
	implements LandPricePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LandPriceUtil} to access the land price persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LandPriceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(LandPriceModelImpl.ENTITY_CACHE_ENABLED,
			LandPriceModelImpl.FINDER_CACHE_ENABLED, LandPriceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(LandPriceModelImpl.ENTITY_CACHE_ENABLED,
			LandPriceModelImpl.FINDER_CACHE_ENABLED, LandPriceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			LandPriceModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(LandPriceModelImpl.ENTITY_CACHE_ENABLED,
			LandPriceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LOCATION = new FinderPath(LandPriceModelImpl.ENTITY_CACHE_ENABLED,
			LandPriceModelImpl.FINDER_CACHE_ENABLED, LandPriceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLocation",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATION =
		new FinderPath(LandPriceModelImpl.ENTITY_CACHE_ENABLED,
			LandPriceModelImpl.FINDER_CACHE_ENABLED, LandPriceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLocation",
			new String[] { Long.class.getName() },
			LandPriceModelImpl.LOCATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LOCATION = new FinderPath(LandPriceModelImpl.ENTITY_CACHE_ENABLED,
			LandPriceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLocation",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATISTICYEAR =
		new FinderPath(LandPriceModelImpl.ENTITY_CACHE_ENABLED,
			LandPriceModelImpl.FINDER_CACHE_ENABLED, LandPriceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatisticYear",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATISTICYEAR =
		new FinderPath(LandPriceModelImpl.ENTITY_CACHE_ENABLED,
			LandPriceModelImpl.FINDER_CACHE_ENABLED, LandPriceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatisticYear",
			new String[] { Integer.class.getName() },
			LandPriceModelImpl.STATISTICYEAR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATISTICYEAR = new FinderPath(LandPriceModelImpl.ENTITY_CACHE_ENABLED,
			LandPriceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatisticYear",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LandPriceModelImpl.ENTITY_CACHE_ENABLED,
			LandPriceModelImpl.FINDER_CACHE_ENABLED, LandPriceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LandPriceModelImpl.ENTITY_CACHE_ENABLED,
			LandPriceModelImpl.FINDER_CACHE_ENABLED, LandPriceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LandPriceModelImpl.ENTITY_CACHE_ENABLED,
			LandPriceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the land price in the entity cache if it is enabled.
	 *
	 * @param landPrice the land price
	 */
	public void cacheResult(LandPrice landPrice) {
		EntityCacheUtil.putResult(LandPriceModelImpl.ENTITY_CACHE_ENABLED,
			LandPriceImpl.class, landPrice.getPrimaryKey(), landPrice);

		landPrice.resetOriginalValues();
	}

	/**
	 * Caches the land prices in the entity cache if it is enabled.
	 *
	 * @param landPrices the land prices
	 */
	public void cacheResult(List<LandPrice> landPrices) {
		for (LandPrice landPrice : landPrices) {
			if (EntityCacheUtil.getResult(
						LandPriceModelImpl.ENTITY_CACHE_ENABLED,
						LandPriceImpl.class, landPrice.getPrimaryKey()) == null) {
				cacheResult(landPrice);
			}
			else {
				landPrice.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all land prices.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LandPriceImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LandPriceImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the land price.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LandPrice landPrice) {
		EntityCacheUtil.removeResult(LandPriceModelImpl.ENTITY_CACHE_ENABLED,
			LandPriceImpl.class, landPrice.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LandPrice> landPrices) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LandPrice landPrice : landPrices) {
			EntityCacheUtil.removeResult(LandPriceModelImpl.ENTITY_CACHE_ENABLED,
				LandPriceImpl.class, landPrice.getPrimaryKey());
		}
	}

	/**
	 * Creates a new land price with the primary key. Does not add the land price to the database.
	 *
	 * @param priceId the primary key for the new land price
	 * @return the new land price
	 */
	public LandPrice create(long priceId) {
		LandPrice landPrice = new LandPriceImpl();

		landPrice.setNew(true);
		landPrice.setPrimaryKey(priceId);

		return landPrice;
	}

	/**
	 * Removes the land price with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param priceId the primary key of the land price
	 * @return the land price that was removed
	 * @throws com.portal_egov.portlet.landprice.NoSuchLandPriceException if a land price with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LandPrice remove(long priceId)
		throws NoSuchLandPriceException, SystemException {
		return remove(Long.valueOf(priceId));
	}

	/**
	 * Removes the land price with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the land price
	 * @return the land price that was removed
	 * @throws com.portal_egov.portlet.landprice.NoSuchLandPriceException if a land price with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LandPrice remove(Serializable primaryKey)
		throws NoSuchLandPriceException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LandPrice landPrice = (LandPrice)session.get(LandPriceImpl.class,
					primaryKey);

			if (landPrice == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLandPriceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(landPrice);
		}
		catch (NoSuchLandPriceException nsee) {
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
	protected LandPrice removeImpl(LandPrice landPrice)
		throws SystemException {
		landPrice = toUnwrappedModel(landPrice);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, landPrice);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(landPrice);

		return landPrice;
	}

	@Override
	public LandPrice updateImpl(
		com.portal_egov.portlet.landprice.model.LandPrice landPrice,
		boolean merge) throws SystemException {
		landPrice = toUnwrappedModel(landPrice);

		boolean isNew = landPrice.isNew();

		LandPriceModelImpl landPriceModelImpl = (LandPriceModelImpl)landPrice;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, landPrice, merge);

			landPrice.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LandPriceModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((landPriceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(landPriceModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] {
						Long.valueOf(landPriceModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}

			if ((landPriceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(landPriceModelImpl.getOriginalLocationId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOCATION, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATION,
					args);

				args = new Object[] {
						Long.valueOf(landPriceModelImpl.getLocationId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOCATION, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATION,
					args);
			}

			if ((landPriceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATISTICYEAR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(landPriceModelImpl.getOriginalStatisticYear())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATISTICYEAR,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATISTICYEAR,
					args);

				args = new Object[] {
						Integer.valueOf(landPriceModelImpl.getStatisticYear())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATISTICYEAR,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATISTICYEAR,
					args);
			}
		}

		EntityCacheUtil.putResult(LandPriceModelImpl.ENTITY_CACHE_ENABLED,
			LandPriceImpl.class, landPrice.getPrimaryKey(), landPrice);

		return landPrice;
	}

	protected LandPrice toUnwrappedModel(LandPrice landPrice) {
		if (landPrice instanceof LandPriceImpl) {
			return landPrice;
		}

		LandPriceImpl landPriceImpl = new LandPriceImpl();

		landPriceImpl.setNew(landPrice.isNew());
		landPriceImpl.setPrimaryKey(landPrice.getPrimaryKey());

		landPriceImpl.setPriceId(landPrice.getPriceId());
		landPriceImpl.setCompanyId(landPrice.getCompanyId());
		landPriceImpl.setGroupId(landPrice.getGroupId());
		landPriceImpl.setUserId(landPrice.getUserId());
		landPriceImpl.setUserName(landPrice.getUserName());
		landPriceImpl.setCreateDate(landPrice.getCreateDate());
		landPriceImpl.setModifiedDate(landPrice.getModifiedDate());
		landPriceImpl.setLocationId(landPrice.getLocationId());
		landPriceImpl.setTitle(landPrice.getTitle());
		landPriceImpl.setContent(landPrice.getContent());
		landPriceImpl.setStatisticYear(landPrice.getStatisticYear());

		return landPriceImpl;
	}

	/**
	 * Returns the land price with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the land price
	 * @return the land price
	 * @throws com.liferay.portal.NoSuchModelException if a land price with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LandPrice findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the land price with the primary key or throws a {@link com.portal_egov.portlet.landprice.NoSuchLandPriceException} if it could not be found.
	 *
	 * @param priceId the primary key of the land price
	 * @return the land price
	 * @throws com.portal_egov.portlet.landprice.NoSuchLandPriceException if a land price with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LandPrice findByPrimaryKey(long priceId)
		throws NoSuchLandPriceException, SystemException {
		LandPrice landPrice = fetchByPrimaryKey(priceId);

		if (landPrice == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + priceId);
			}

			throw new NoSuchLandPriceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				priceId);
		}

		return landPrice;
	}

	/**
	 * Returns the land price with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the land price
	 * @return the land price, or <code>null</code> if a land price with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LandPrice fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the land price with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param priceId the primary key of the land price
	 * @return the land price, or <code>null</code> if a land price with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LandPrice fetchByPrimaryKey(long priceId) throws SystemException {
		LandPrice landPrice = (LandPrice)EntityCacheUtil.getResult(LandPriceModelImpl.ENTITY_CACHE_ENABLED,
				LandPriceImpl.class, priceId);

		if (landPrice == _nullLandPrice) {
			return null;
		}

		if (landPrice == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				landPrice = (LandPrice)session.get(LandPriceImpl.class,
						Long.valueOf(priceId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (landPrice != null) {
					cacheResult(landPrice);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(LandPriceModelImpl.ENTITY_CACHE_ENABLED,
						LandPriceImpl.class, priceId, _nullLandPrice);
				}

				closeSession(session);
			}
		}

		return landPrice;
	}

	/**
	 * Returns all the land prices where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching land prices
	 * @throws SystemException if a system exception occurred
	 */
	public List<LandPrice> findByGroup(long groupId) throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the land prices where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of land prices
	 * @param end the upper bound of the range of land prices (not inclusive)
	 * @return the range of matching land prices
	 * @throws SystemException if a system exception occurred
	 */
	public List<LandPrice> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the land prices where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of land prices
	 * @param end the upper bound of the range of land prices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching land prices
	 * @throws SystemException if a system exception occurred
	 */
	public List<LandPrice> findByGroup(long groupId, int start, int end,
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

		List<LandPrice> list = (List<LandPrice>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LandPrice landPrice : list) {
				if ((groupId != landPrice.getGroupId())) {
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

			query.append(_SQL_SELECT_LANDPRICE_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(LandPriceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<LandPrice>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first land price in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching land price
	 * @throws com.portal_egov.portlet.landprice.NoSuchLandPriceException if a matching land price could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LandPrice findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLandPriceException, SystemException {
		LandPrice landPrice = fetchByGroup_First(groupId, orderByComparator);

		if (landPrice != null) {
			return landPrice;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLandPriceException(msg.toString());
	}

	/**
	 * Returns the first land price in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching land price, or <code>null</code> if a matching land price could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LandPrice fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LandPrice> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last land price in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching land price
	 * @throws com.portal_egov.portlet.landprice.NoSuchLandPriceException if a matching land price could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LandPrice findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLandPriceException, SystemException {
		LandPrice landPrice = fetchByGroup_Last(groupId, orderByComparator);

		if (landPrice != null) {
			return landPrice;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLandPriceException(msg.toString());
	}

	/**
	 * Returns the last land price in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching land price, or <code>null</code> if a matching land price could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LandPrice fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<LandPrice> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the land prices before and after the current land price in the ordered set where groupId = &#63;.
	 *
	 * @param priceId the primary key of the current land price
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next land price
	 * @throws com.portal_egov.portlet.landprice.NoSuchLandPriceException if a land price with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LandPrice[] findByGroup_PrevAndNext(long priceId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLandPriceException, SystemException {
		LandPrice landPrice = findByPrimaryKey(priceId);

		Session session = null;

		try {
			session = openSession();

			LandPrice[] array = new LandPriceImpl[3];

			array[0] = getByGroup_PrevAndNext(session, landPrice, groupId,
					orderByComparator, true);

			array[1] = landPrice;

			array[2] = getByGroup_PrevAndNext(session, landPrice, groupId,
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

	protected LandPrice getByGroup_PrevAndNext(Session session,
		LandPrice landPrice, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LANDPRICE_WHERE);

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
			query.append(LandPriceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(landPrice);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LandPrice> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the land prices that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching land prices that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<LandPrice> filterFindByGroup(long groupId)
		throws SystemException {
		return filterFindByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the land prices that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of land prices
	 * @param end the upper bound of the range of land prices (not inclusive)
	 * @return the range of matching land prices that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<LandPrice> filterFindByGroup(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the land prices that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of land prices
	 * @param end the upper bound of the range of land prices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching land prices that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<LandPrice> filterFindByGroup(long groupId, int start, int end,
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
			query.append(_FILTER_SQL_SELECT_LANDPRICE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_LANDPRICE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LANDPRICE_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(LandPriceModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(LandPriceModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				LandPrice.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, LandPriceImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, LandPriceImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<LandPrice>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the land prices before and after the current land price in the ordered set of land prices that the user has permission to view where groupId = &#63;.
	 *
	 * @param priceId the primary key of the current land price
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next land price
	 * @throws com.portal_egov.portlet.landprice.NoSuchLandPriceException if a land price with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LandPrice[] filterFindByGroup_PrevAndNext(long priceId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchLandPriceException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup_PrevAndNext(priceId, groupId, orderByComparator);
		}

		LandPrice landPrice = findByPrimaryKey(priceId);

		Session session = null;

		try {
			session = openSession();

			LandPrice[] array = new LandPriceImpl[3];

			array[0] = filterGetByGroup_PrevAndNext(session, landPrice,
					groupId, orderByComparator, true);

			array[1] = landPrice;

			array[2] = filterGetByGroup_PrevAndNext(session, landPrice,
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

	protected LandPrice filterGetByGroup_PrevAndNext(Session session,
		LandPrice landPrice, long groupId, OrderByComparator orderByComparator,
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
			query.append(_FILTER_SQL_SELECT_LANDPRICE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_LANDPRICE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LANDPRICE_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(LandPriceModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(LandPriceModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				LandPrice.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, LandPriceImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, LandPriceImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(landPrice);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LandPrice> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the land prices where locationId = &#63;.
	 *
	 * @param locationId the location ID
	 * @return the matching land prices
	 * @throws SystemException if a system exception occurred
	 */
	public List<LandPrice> findByLocation(long locationId)
		throws SystemException {
		return findByLocation(locationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the land prices where locationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param locationId the location ID
	 * @param start the lower bound of the range of land prices
	 * @param end the upper bound of the range of land prices (not inclusive)
	 * @return the range of matching land prices
	 * @throws SystemException if a system exception occurred
	 */
	public List<LandPrice> findByLocation(long locationId, int start, int end)
		throws SystemException {
		return findByLocation(locationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the land prices where locationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param locationId the location ID
	 * @param start the lower bound of the range of land prices
	 * @param end the upper bound of the range of land prices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching land prices
	 * @throws SystemException if a system exception occurred
	 */
	public List<LandPrice> findByLocation(long locationId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATION;
			finderArgs = new Object[] { locationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LOCATION;
			finderArgs = new Object[] { locationId, start, end, orderByComparator };
		}

		List<LandPrice> list = (List<LandPrice>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LandPrice landPrice : list) {
				if ((locationId != landPrice.getLocationId())) {
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

			query.append(_SQL_SELECT_LANDPRICE_WHERE);

			query.append(_FINDER_COLUMN_LOCATION_LOCATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(LandPriceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(locationId);

				list = (List<LandPrice>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first land price in the ordered set where locationId = &#63;.
	 *
	 * @param locationId the location ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching land price
	 * @throws com.portal_egov.portlet.landprice.NoSuchLandPriceException if a matching land price could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LandPrice findByLocation_First(long locationId,
		OrderByComparator orderByComparator)
		throws NoSuchLandPriceException, SystemException {
		LandPrice landPrice = fetchByLocation_First(locationId,
				orderByComparator);

		if (landPrice != null) {
			return landPrice;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("locationId=");
		msg.append(locationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLandPriceException(msg.toString());
	}

	/**
	 * Returns the first land price in the ordered set where locationId = &#63;.
	 *
	 * @param locationId the location ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching land price, or <code>null</code> if a matching land price could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LandPrice fetchByLocation_First(long locationId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LandPrice> list = findByLocation(locationId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last land price in the ordered set where locationId = &#63;.
	 *
	 * @param locationId the location ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching land price
	 * @throws com.portal_egov.portlet.landprice.NoSuchLandPriceException if a matching land price could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LandPrice findByLocation_Last(long locationId,
		OrderByComparator orderByComparator)
		throws NoSuchLandPriceException, SystemException {
		LandPrice landPrice = fetchByLocation_Last(locationId, orderByComparator);

		if (landPrice != null) {
			return landPrice;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("locationId=");
		msg.append(locationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLandPriceException(msg.toString());
	}

	/**
	 * Returns the last land price in the ordered set where locationId = &#63;.
	 *
	 * @param locationId the location ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching land price, or <code>null</code> if a matching land price could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LandPrice fetchByLocation_Last(long locationId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLocation(locationId);

		List<LandPrice> list = findByLocation(locationId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the land prices before and after the current land price in the ordered set where locationId = &#63;.
	 *
	 * @param priceId the primary key of the current land price
	 * @param locationId the location ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next land price
	 * @throws com.portal_egov.portlet.landprice.NoSuchLandPriceException if a land price with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LandPrice[] findByLocation_PrevAndNext(long priceId,
		long locationId, OrderByComparator orderByComparator)
		throws NoSuchLandPriceException, SystemException {
		LandPrice landPrice = findByPrimaryKey(priceId);

		Session session = null;

		try {
			session = openSession();

			LandPrice[] array = new LandPriceImpl[3];

			array[0] = getByLocation_PrevAndNext(session, landPrice,
					locationId, orderByComparator, true);

			array[1] = landPrice;

			array[2] = getByLocation_PrevAndNext(session, landPrice,
					locationId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LandPrice getByLocation_PrevAndNext(Session session,
		LandPrice landPrice, long locationId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LANDPRICE_WHERE);

		query.append(_FINDER_COLUMN_LOCATION_LOCATIONID_2);

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
			query.append(LandPriceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(locationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(landPrice);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LandPrice> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the land prices where statisticYear = &#63;.
	 *
	 * @param statisticYear the statistic year
	 * @return the matching land prices
	 * @throws SystemException if a system exception occurred
	 */
	public List<LandPrice> findByStatisticYear(int statisticYear)
		throws SystemException {
		return findByStatisticYear(statisticYear, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the land prices where statisticYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param statisticYear the statistic year
	 * @param start the lower bound of the range of land prices
	 * @param end the upper bound of the range of land prices (not inclusive)
	 * @return the range of matching land prices
	 * @throws SystemException if a system exception occurred
	 */
	public List<LandPrice> findByStatisticYear(int statisticYear, int start,
		int end) throws SystemException {
		return findByStatisticYear(statisticYear, start, end, null);
	}

	/**
	 * Returns an ordered range of all the land prices where statisticYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param statisticYear the statistic year
	 * @param start the lower bound of the range of land prices
	 * @param end the upper bound of the range of land prices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching land prices
	 * @throws SystemException if a system exception occurred
	 */
	public List<LandPrice> findByStatisticYear(int statisticYear, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATISTICYEAR;
			finderArgs = new Object[] { statisticYear };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATISTICYEAR;
			finderArgs = new Object[] {
					statisticYear,
					
					start, end, orderByComparator
				};
		}

		List<LandPrice> list = (List<LandPrice>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LandPrice landPrice : list) {
				if ((statisticYear != landPrice.getStatisticYear())) {
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

			query.append(_SQL_SELECT_LANDPRICE_WHERE);

			query.append(_FINDER_COLUMN_STATISTICYEAR_STATISTICYEAR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(LandPriceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(statisticYear);

				list = (List<LandPrice>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first land price in the ordered set where statisticYear = &#63;.
	 *
	 * @param statisticYear the statistic year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching land price
	 * @throws com.portal_egov.portlet.landprice.NoSuchLandPriceException if a matching land price could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LandPrice findByStatisticYear_First(int statisticYear,
		OrderByComparator orderByComparator)
		throws NoSuchLandPriceException, SystemException {
		LandPrice landPrice = fetchByStatisticYear_First(statisticYear,
				orderByComparator);

		if (landPrice != null) {
			return landPrice;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("statisticYear=");
		msg.append(statisticYear);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLandPriceException(msg.toString());
	}

	/**
	 * Returns the first land price in the ordered set where statisticYear = &#63;.
	 *
	 * @param statisticYear the statistic year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching land price, or <code>null</code> if a matching land price could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LandPrice fetchByStatisticYear_First(int statisticYear,
		OrderByComparator orderByComparator) throws SystemException {
		List<LandPrice> list = findByStatisticYear(statisticYear, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last land price in the ordered set where statisticYear = &#63;.
	 *
	 * @param statisticYear the statistic year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching land price
	 * @throws com.portal_egov.portlet.landprice.NoSuchLandPriceException if a matching land price could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LandPrice findByStatisticYear_Last(int statisticYear,
		OrderByComparator orderByComparator)
		throws NoSuchLandPriceException, SystemException {
		LandPrice landPrice = fetchByStatisticYear_Last(statisticYear,
				orderByComparator);

		if (landPrice != null) {
			return landPrice;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("statisticYear=");
		msg.append(statisticYear);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLandPriceException(msg.toString());
	}

	/**
	 * Returns the last land price in the ordered set where statisticYear = &#63;.
	 *
	 * @param statisticYear the statistic year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching land price, or <code>null</code> if a matching land price could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LandPrice fetchByStatisticYear_Last(int statisticYear,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStatisticYear(statisticYear);

		List<LandPrice> list = findByStatisticYear(statisticYear, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the land prices before and after the current land price in the ordered set where statisticYear = &#63;.
	 *
	 * @param priceId the primary key of the current land price
	 * @param statisticYear the statistic year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next land price
	 * @throws com.portal_egov.portlet.landprice.NoSuchLandPriceException if a land price with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LandPrice[] findByStatisticYear_PrevAndNext(long priceId,
		int statisticYear, OrderByComparator orderByComparator)
		throws NoSuchLandPriceException, SystemException {
		LandPrice landPrice = findByPrimaryKey(priceId);

		Session session = null;

		try {
			session = openSession();

			LandPrice[] array = new LandPriceImpl[3];

			array[0] = getByStatisticYear_PrevAndNext(session, landPrice,
					statisticYear, orderByComparator, true);

			array[1] = landPrice;

			array[2] = getByStatisticYear_PrevAndNext(session, landPrice,
					statisticYear, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LandPrice getByStatisticYear_PrevAndNext(Session session,
		LandPrice landPrice, int statisticYear,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LANDPRICE_WHERE);

		query.append(_FINDER_COLUMN_STATISTICYEAR_STATISTICYEAR_2);

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
			query.append(LandPriceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(statisticYear);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(landPrice);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LandPrice> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the land prices.
	 *
	 * @return the land prices
	 * @throws SystemException if a system exception occurred
	 */
	public List<LandPrice> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the land prices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of land prices
	 * @param end the upper bound of the range of land prices (not inclusive)
	 * @return the range of land prices
	 * @throws SystemException if a system exception occurred
	 */
	public List<LandPrice> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the land prices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of land prices
	 * @param end the upper bound of the range of land prices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of land prices
	 * @throws SystemException if a system exception occurred
	 */
	public List<LandPrice> findAll(int start, int end,
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

		List<LandPrice> list = (List<LandPrice>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LANDPRICE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LANDPRICE.concat(LandPriceModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<LandPrice>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LandPrice>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the land prices where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (LandPrice landPrice : findByGroup(groupId)) {
			remove(landPrice);
		}
	}

	/**
	 * Removes all the land prices where locationId = &#63; from the database.
	 *
	 * @param locationId the location ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByLocation(long locationId) throws SystemException {
		for (LandPrice landPrice : findByLocation(locationId)) {
			remove(landPrice);
		}
	}

	/**
	 * Removes all the land prices where statisticYear = &#63; from the database.
	 *
	 * @param statisticYear the statistic year
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByStatisticYear(int statisticYear)
		throws SystemException {
		for (LandPrice landPrice : findByStatisticYear(statisticYear)) {
			remove(landPrice);
		}
	}

	/**
	 * Removes all the land prices from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (LandPrice landPrice : findAll()) {
			remove(landPrice);
		}
	}

	/**
	 * Returns the number of land prices where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching land prices
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LANDPRICE_WHERE);

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
	 * Returns the number of land prices that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching land prices that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroup(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroup(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_LANDPRICE_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				LandPrice.class.getName(),
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
	 * Returns the number of land prices where locationId = &#63;.
	 *
	 * @param locationId the location ID
	 * @return the number of matching land prices
	 * @throws SystemException if a system exception occurred
	 */
	public int countByLocation(long locationId) throws SystemException {
		Object[] finderArgs = new Object[] { locationId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_LOCATION,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LANDPRICE_WHERE);

			query.append(_FINDER_COLUMN_LOCATION_LOCATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(locationId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LOCATION,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of land prices where statisticYear = &#63;.
	 *
	 * @param statisticYear the statistic year
	 * @return the number of matching land prices
	 * @throws SystemException if a system exception occurred
	 */
	public int countByStatisticYear(int statisticYear)
		throws SystemException {
		Object[] finderArgs = new Object[] { statisticYear };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATISTICYEAR,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LANDPRICE_WHERE);

			query.append(_FINDER_COLUMN_STATISTICYEAR_STATISTICYEAR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(statisticYear);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATISTICYEAR,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of land prices.
	 *
	 * @return the number of land prices
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LANDPRICE);

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
	 * Initializes the land price persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.portal_egov.portlet.landprice.model.LandPrice")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LandPrice>> listenersList = new ArrayList<ModelListener<LandPrice>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LandPrice>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LandPriceImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = LandLocationPersistence.class)
	protected LandLocationPersistence landLocationPersistence;
	@BeanReference(type = LandPricePersistence.class)
	protected LandPricePersistence landPricePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_LANDPRICE = "SELECT landPrice FROM LandPrice landPrice";
	private static final String _SQL_SELECT_LANDPRICE_WHERE = "SELECT landPrice FROM LandPrice landPrice WHERE ";
	private static final String _SQL_COUNT_LANDPRICE = "SELECT COUNT(landPrice) FROM LandPrice landPrice";
	private static final String _SQL_COUNT_LANDPRICE_WHERE = "SELECT COUNT(landPrice) FROM LandPrice landPrice WHERE ";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "landPrice.groupId = ?";
	private static final String _FINDER_COLUMN_LOCATION_LOCATIONID_2 = "landPrice.locationId = ?";
	private static final String _FINDER_COLUMN_STATISTICYEAR_STATISTICYEAR_2 = "landPrice.statisticYear = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "landPrice.priceId";
	private static final String _FILTER_SQL_SELECT_LANDPRICE_WHERE = "SELECT DISTINCT {landPrice.*} FROM LandPrice landPrice WHERE ";
	private static final String _FILTER_SQL_SELECT_LANDPRICE_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {LandPrice.*} FROM (SELECT DISTINCT landPrice.priceId FROM LandPrice landPrice WHERE ";
	private static final String _FILTER_SQL_SELECT_LANDPRICE_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN LandPrice ON TEMP_TABLE.priceId = LandPrice.priceId";
	private static final String _FILTER_SQL_COUNT_LANDPRICE_WHERE = "SELECT COUNT(DISTINCT landPrice.priceId) AS COUNT_VALUE FROM LandPrice landPrice WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "landPrice";
	private static final String _FILTER_ENTITY_TABLE = "LandPrice";
	private static final String _ORDER_BY_ENTITY_ALIAS = "landPrice.";
	private static final String _ORDER_BY_ENTITY_TABLE = "LandPrice.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LandPrice exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LandPrice exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LandPricePersistenceImpl.class);
	private static LandPrice _nullLandPrice = new LandPriceImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LandPrice> toCacheModel() {
				return _nullLandPriceCacheModel;
			}
		};

	private static CacheModel<LandPrice> _nullLandPriceCacheModel = new CacheModel<LandPrice>() {
			public LandPrice toEntityModel() {
				return _nullLandPrice;
			}
		};
}