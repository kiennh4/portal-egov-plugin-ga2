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

package com.portal_egov.portlet.inquiry.service.persistence;

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

import com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException;
import com.portal_egov.portlet.inquiry.model.OnlineInquiry;
import com.portal_egov.portlet.inquiry.model.impl.OnlineInquiryImpl;
import com.portal_egov.portlet.inquiry.model.impl.OnlineInquiryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the online inquiry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see OnlineInquiryPersistence
 * @see OnlineInquiryUtil
 * @generated
 */
public class OnlineInquiryPersistenceImpl extends BasePersistenceImpl<OnlineInquiry>
	implements OnlineInquiryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OnlineInquiryUtil} to access the online inquiry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OnlineInquiryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(OnlineInquiryModelImpl.ENTITY_CACHE_ENABLED,
			OnlineInquiryModelImpl.FINDER_CACHE_ENABLED,
			OnlineInquiryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompany",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(OnlineInquiryModelImpl.ENTITY_CACHE_ENABLED,
			OnlineInquiryModelImpl.FINDER_CACHE_ENABLED,
			OnlineInquiryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCompany", new String[] { Long.class.getName() },
			OnlineInquiryModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(OnlineInquiryModelImpl.ENTITY_CACHE_ENABLED,
			OnlineInquiryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(OnlineInquiryModelImpl.ENTITY_CACHE_ENABLED,
			OnlineInquiryModelImpl.FINDER_CACHE_ENABLED,
			OnlineInquiryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(OnlineInquiryModelImpl.ENTITY_CACHE_ENABLED,
			OnlineInquiryModelImpl.FINDER_CACHE_ENABLED,
			OnlineInquiryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroup", new String[] { Long.class.getName() },
			OnlineInquiryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(OnlineInquiryModelImpl.ENTITY_CACHE_ENABLED,
			OnlineInquiryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OnlineInquiryModelImpl.ENTITY_CACHE_ENABLED,
			OnlineInquiryModelImpl.FINDER_CACHE_ENABLED,
			OnlineInquiryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OnlineInquiryModelImpl.ENTITY_CACHE_ENABLED,
			OnlineInquiryModelImpl.FINDER_CACHE_ENABLED,
			OnlineInquiryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OnlineInquiryModelImpl.ENTITY_CACHE_ENABLED,
			OnlineInquiryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the online inquiry in the entity cache if it is enabled.
	 *
	 * @param onlineInquiry the online inquiry
	 */
	public void cacheResult(OnlineInquiry onlineInquiry) {
		EntityCacheUtil.putResult(OnlineInquiryModelImpl.ENTITY_CACHE_ENABLED,
			OnlineInquiryImpl.class, onlineInquiry.getPrimaryKey(),
			onlineInquiry);

		onlineInquiry.resetOriginalValues();
	}

	/**
	 * Caches the online inquiries in the entity cache if it is enabled.
	 *
	 * @param onlineInquiries the online inquiries
	 */
	public void cacheResult(List<OnlineInquiry> onlineInquiries) {
		for (OnlineInquiry onlineInquiry : onlineInquiries) {
			if (EntityCacheUtil.getResult(
						OnlineInquiryModelImpl.ENTITY_CACHE_ENABLED,
						OnlineInquiryImpl.class, onlineInquiry.getPrimaryKey()) == null) {
				cacheResult(onlineInquiry);
			}
			else {
				onlineInquiry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all online inquiries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(OnlineInquiryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(OnlineInquiryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the online inquiry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OnlineInquiry onlineInquiry) {
		EntityCacheUtil.removeResult(OnlineInquiryModelImpl.ENTITY_CACHE_ENABLED,
			OnlineInquiryImpl.class, onlineInquiry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<OnlineInquiry> onlineInquiries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (OnlineInquiry onlineInquiry : onlineInquiries) {
			EntityCacheUtil.removeResult(OnlineInquiryModelImpl.ENTITY_CACHE_ENABLED,
				OnlineInquiryImpl.class, onlineInquiry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new online inquiry with the primary key. Does not add the online inquiry to the database.
	 *
	 * @param inquiryId the primary key for the new online inquiry
	 * @return the new online inquiry
	 */
	public OnlineInquiry create(long inquiryId) {
		OnlineInquiry onlineInquiry = new OnlineInquiryImpl();

		onlineInquiry.setNew(true);
		onlineInquiry.setPrimaryKey(inquiryId);

		return onlineInquiry;
	}

	/**
	 * Removes the online inquiry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param inquiryId the primary key of the online inquiry
	 * @return the online inquiry that was removed
	 * @throws com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException if a online inquiry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OnlineInquiry remove(long inquiryId)
		throws NoSuchOnlineInquiryException, SystemException {
		return remove(Long.valueOf(inquiryId));
	}

	/**
	 * Removes the online inquiry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the online inquiry
	 * @return the online inquiry that was removed
	 * @throws com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException if a online inquiry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OnlineInquiry remove(Serializable primaryKey)
		throws NoSuchOnlineInquiryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			OnlineInquiry onlineInquiry = (OnlineInquiry)session.get(OnlineInquiryImpl.class,
					primaryKey);

			if (onlineInquiry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOnlineInquiryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(onlineInquiry);
		}
		catch (NoSuchOnlineInquiryException nsee) {
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
	protected OnlineInquiry removeImpl(OnlineInquiry onlineInquiry)
		throws SystemException {
		onlineInquiry = toUnwrappedModel(onlineInquiry);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, onlineInquiry);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(onlineInquiry);

		return onlineInquiry;
	}

	@Override
	public OnlineInquiry updateImpl(
		com.portal_egov.portlet.inquiry.model.OnlineInquiry onlineInquiry,
		boolean merge) throws SystemException {
		onlineInquiry = toUnwrappedModel(onlineInquiry);

		boolean isNew = onlineInquiry.isNew();

		OnlineInquiryModelImpl onlineInquiryModelImpl = (OnlineInquiryModelImpl)onlineInquiry;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, onlineInquiry, merge);

			onlineInquiry.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !OnlineInquiryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((onlineInquiryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(onlineInquiryModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] {
						Long.valueOf(onlineInquiryModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((onlineInquiryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(onlineInquiryModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] {
						Long.valueOf(onlineInquiryModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(OnlineInquiryModelImpl.ENTITY_CACHE_ENABLED,
			OnlineInquiryImpl.class, onlineInquiry.getPrimaryKey(),
			onlineInquiry);

		return onlineInquiry;
	}

	protected OnlineInquiry toUnwrappedModel(OnlineInquiry onlineInquiry) {
		if (onlineInquiry instanceof OnlineInquiryImpl) {
			return onlineInquiry;
		}

		OnlineInquiryImpl onlineInquiryImpl = new OnlineInquiryImpl();

		onlineInquiryImpl.setNew(onlineInquiry.isNew());
		onlineInquiryImpl.setPrimaryKey(onlineInquiry.getPrimaryKey());

		onlineInquiryImpl.setInquiryId(onlineInquiry.getInquiryId());
		onlineInquiryImpl.setGroupId(onlineInquiry.getGroupId());
		onlineInquiryImpl.setCompanyId(onlineInquiry.getCompanyId());
		onlineInquiryImpl.setUserId(onlineInquiry.getUserId());
		onlineInquiryImpl.setUserName(onlineInquiry.getUserName());
		onlineInquiryImpl.setCreateDate(onlineInquiry.getCreateDate());
		onlineInquiryImpl.setModifiedDate(onlineInquiry.getModifiedDate());
		onlineInquiryImpl.setFullName(onlineInquiry.getFullName());
		onlineInquiryImpl.setPhoneNumbers(onlineInquiry.getPhoneNumbers());
		onlineInquiryImpl.setEmailAddress(onlineInquiry.getEmailAddress());
		onlineInquiryImpl.setInquiryContent(onlineInquiry.getInquiryContent());
		onlineInquiryImpl.setInquiryStatus(onlineInquiry.getInquiryStatus());

		return onlineInquiryImpl;
	}

	/**
	 * Returns the online inquiry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the online inquiry
	 * @return the online inquiry
	 * @throws com.liferay.portal.NoSuchModelException if a online inquiry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OnlineInquiry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the online inquiry with the primary key or throws a {@link com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException} if it could not be found.
	 *
	 * @param inquiryId the primary key of the online inquiry
	 * @return the online inquiry
	 * @throws com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException if a online inquiry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OnlineInquiry findByPrimaryKey(long inquiryId)
		throws NoSuchOnlineInquiryException, SystemException {
		OnlineInquiry onlineInquiry = fetchByPrimaryKey(inquiryId);

		if (onlineInquiry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + inquiryId);
			}

			throw new NoSuchOnlineInquiryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				inquiryId);
		}

		return onlineInquiry;
	}

	/**
	 * Returns the online inquiry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the online inquiry
	 * @return the online inquiry, or <code>null</code> if a online inquiry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OnlineInquiry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the online inquiry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param inquiryId the primary key of the online inquiry
	 * @return the online inquiry, or <code>null</code> if a online inquiry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OnlineInquiry fetchByPrimaryKey(long inquiryId)
		throws SystemException {
		OnlineInquiry onlineInquiry = (OnlineInquiry)EntityCacheUtil.getResult(OnlineInquiryModelImpl.ENTITY_CACHE_ENABLED,
				OnlineInquiryImpl.class, inquiryId);

		if (onlineInquiry == _nullOnlineInquiry) {
			return null;
		}

		if (onlineInquiry == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				onlineInquiry = (OnlineInquiry)session.get(OnlineInquiryImpl.class,
						Long.valueOf(inquiryId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (onlineInquiry != null) {
					cacheResult(onlineInquiry);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(OnlineInquiryModelImpl.ENTITY_CACHE_ENABLED,
						OnlineInquiryImpl.class, inquiryId, _nullOnlineInquiry);
				}

				closeSession(session);
			}
		}

		return onlineInquiry;
	}

	/**
	 * Returns all the online inquiries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching online inquiries
	 * @throws SystemException if a system exception occurred
	 */
	public List<OnlineInquiry> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the online inquiries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of online inquiries
	 * @param end the upper bound of the range of online inquiries (not inclusive)
	 * @return the range of matching online inquiries
	 * @throws SystemException if a system exception occurred
	 */
	public List<OnlineInquiry> findByCompany(long companyId, int start, int end)
		throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the online inquiries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of online inquiries
	 * @param end the upper bound of the range of online inquiries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching online inquiries
	 * @throws SystemException if a system exception occurred
	 */
	public List<OnlineInquiry> findByCompany(long companyId, int start,
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

		List<OnlineInquiry> list = (List<OnlineInquiry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (OnlineInquiry onlineInquiry : list) {
				if ((companyId != onlineInquiry.getCompanyId())) {
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

			query.append(_SQL_SELECT_ONLINEINQUIRY_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(OnlineInquiryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<OnlineInquiry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first online inquiry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching online inquiry
	 * @throws com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException if a matching online inquiry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OnlineInquiry findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchOnlineInquiryException, SystemException {
		OnlineInquiry onlineInquiry = fetchByCompany_First(companyId,
				orderByComparator);

		if (onlineInquiry != null) {
			return onlineInquiry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOnlineInquiryException(msg.toString());
	}

	/**
	 * Returns the first online inquiry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching online inquiry, or <code>null</code> if a matching online inquiry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OnlineInquiry fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<OnlineInquiry> list = findByCompany(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last online inquiry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching online inquiry
	 * @throws com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException if a matching online inquiry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OnlineInquiry findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchOnlineInquiryException, SystemException {
		OnlineInquiry onlineInquiry = fetchByCompany_Last(companyId,
				orderByComparator);

		if (onlineInquiry != null) {
			return onlineInquiry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOnlineInquiryException(msg.toString());
	}

	/**
	 * Returns the last online inquiry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching online inquiry, or <code>null</code> if a matching online inquiry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OnlineInquiry fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		List<OnlineInquiry> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the online inquiries before and after the current online inquiry in the ordered set where companyId = &#63;.
	 *
	 * @param inquiryId the primary key of the current online inquiry
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next online inquiry
	 * @throws com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException if a online inquiry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OnlineInquiry[] findByCompany_PrevAndNext(long inquiryId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchOnlineInquiryException, SystemException {
		OnlineInquiry onlineInquiry = findByPrimaryKey(inquiryId);

		Session session = null;

		try {
			session = openSession();

			OnlineInquiry[] array = new OnlineInquiryImpl[3];

			array[0] = getByCompany_PrevAndNext(session, onlineInquiry,
					companyId, orderByComparator, true);

			array[1] = onlineInquiry;

			array[2] = getByCompany_PrevAndNext(session, onlineInquiry,
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

	protected OnlineInquiry getByCompany_PrevAndNext(Session session,
		OnlineInquiry onlineInquiry, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ONLINEINQUIRY_WHERE);

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
			query.append(OnlineInquiryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(onlineInquiry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OnlineInquiry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the online inquiries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching online inquiries
	 * @throws SystemException if a system exception occurred
	 */
	public List<OnlineInquiry> findByGroup(long groupId)
		throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the online inquiries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of online inquiries
	 * @param end the upper bound of the range of online inquiries (not inclusive)
	 * @return the range of matching online inquiries
	 * @throws SystemException if a system exception occurred
	 */
	public List<OnlineInquiry> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the online inquiries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of online inquiries
	 * @param end the upper bound of the range of online inquiries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching online inquiries
	 * @throws SystemException if a system exception occurred
	 */
	public List<OnlineInquiry> findByGroup(long groupId, int start, int end,
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

		List<OnlineInquiry> list = (List<OnlineInquiry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (OnlineInquiry onlineInquiry : list) {
				if ((groupId != onlineInquiry.getGroupId())) {
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

			query.append(_SQL_SELECT_ONLINEINQUIRY_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(OnlineInquiryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<OnlineInquiry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first online inquiry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching online inquiry
	 * @throws com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException if a matching online inquiry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OnlineInquiry findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchOnlineInquiryException, SystemException {
		OnlineInquiry onlineInquiry = fetchByGroup_First(groupId,
				orderByComparator);

		if (onlineInquiry != null) {
			return onlineInquiry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOnlineInquiryException(msg.toString());
	}

	/**
	 * Returns the first online inquiry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching online inquiry, or <code>null</code> if a matching online inquiry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OnlineInquiry fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<OnlineInquiry> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last online inquiry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching online inquiry
	 * @throws com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException if a matching online inquiry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OnlineInquiry findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchOnlineInquiryException, SystemException {
		OnlineInquiry onlineInquiry = fetchByGroup_Last(groupId,
				orderByComparator);

		if (onlineInquiry != null) {
			return onlineInquiry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOnlineInquiryException(msg.toString());
	}

	/**
	 * Returns the last online inquiry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching online inquiry, or <code>null</code> if a matching online inquiry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OnlineInquiry fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<OnlineInquiry> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the online inquiries before and after the current online inquiry in the ordered set where groupId = &#63;.
	 *
	 * @param inquiryId the primary key of the current online inquiry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next online inquiry
	 * @throws com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException if a online inquiry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OnlineInquiry[] findByGroup_PrevAndNext(long inquiryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchOnlineInquiryException, SystemException {
		OnlineInquiry onlineInquiry = findByPrimaryKey(inquiryId);

		Session session = null;

		try {
			session = openSession();

			OnlineInquiry[] array = new OnlineInquiryImpl[3];

			array[0] = getByGroup_PrevAndNext(session, onlineInquiry, groupId,
					orderByComparator, true);

			array[1] = onlineInquiry;

			array[2] = getByGroup_PrevAndNext(session, onlineInquiry, groupId,
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

	protected OnlineInquiry getByGroup_PrevAndNext(Session session,
		OnlineInquiry onlineInquiry, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ONLINEINQUIRY_WHERE);

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
			query.append(OnlineInquiryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(onlineInquiry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OnlineInquiry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the online inquiries that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching online inquiries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<OnlineInquiry> filterFindByGroup(long groupId)
		throws SystemException {
		return filterFindByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the online inquiries that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of online inquiries
	 * @param end the upper bound of the range of online inquiries (not inclusive)
	 * @return the range of matching online inquiries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<OnlineInquiry> filterFindByGroup(long groupId, int start,
		int end) throws SystemException {
		return filterFindByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the online inquiries that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of online inquiries
	 * @param end the upper bound of the range of online inquiries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching online inquiries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<OnlineInquiry> filterFindByGroup(long groupId, int start,
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
			query.append(_FILTER_SQL_SELECT_ONLINEINQUIRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_ONLINEINQUIRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ONLINEINQUIRY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(OnlineInquiryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(OnlineInquiryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				OnlineInquiry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, OnlineInquiryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, OnlineInquiryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<OnlineInquiry>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the online inquiries before and after the current online inquiry in the ordered set of online inquiries that the user has permission to view where groupId = &#63;.
	 *
	 * @param inquiryId the primary key of the current online inquiry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next online inquiry
	 * @throws com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException if a online inquiry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OnlineInquiry[] filterFindByGroup_PrevAndNext(long inquiryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchOnlineInquiryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup_PrevAndNext(inquiryId, groupId, orderByComparator);
		}

		OnlineInquiry onlineInquiry = findByPrimaryKey(inquiryId);

		Session session = null;

		try {
			session = openSession();

			OnlineInquiry[] array = new OnlineInquiryImpl[3];

			array[0] = filterGetByGroup_PrevAndNext(session, onlineInquiry,
					groupId, orderByComparator, true);

			array[1] = onlineInquiry;

			array[2] = filterGetByGroup_PrevAndNext(session, onlineInquiry,
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

	protected OnlineInquiry filterGetByGroup_PrevAndNext(Session session,
		OnlineInquiry onlineInquiry, long groupId,
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
			query.append(_FILTER_SQL_SELECT_ONLINEINQUIRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_ONLINEINQUIRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ONLINEINQUIRY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(OnlineInquiryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(OnlineInquiryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				OnlineInquiry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, OnlineInquiryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, OnlineInquiryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(onlineInquiry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OnlineInquiry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the online inquiries.
	 *
	 * @return the online inquiries
	 * @throws SystemException if a system exception occurred
	 */
	public List<OnlineInquiry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the online inquiries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of online inquiries
	 * @param end the upper bound of the range of online inquiries (not inclusive)
	 * @return the range of online inquiries
	 * @throws SystemException if a system exception occurred
	 */
	public List<OnlineInquiry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the online inquiries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of online inquiries
	 * @param end the upper bound of the range of online inquiries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of online inquiries
	 * @throws SystemException if a system exception occurred
	 */
	public List<OnlineInquiry> findAll(int start, int end,
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

		List<OnlineInquiry> list = (List<OnlineInquiry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ONLINEINQUIRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ONLINEINQUIRY.concat(OnlineInquiryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<OnlineInquiry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<OnlineInquiry>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the online inquiries where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompany(long companyId) throws SystemException {
		for (OnlineInquiry onlineInquiry : findByCompany(companyId)) {
			remove(onlineInquiry);
		}
	}

	/**
	 * Removes all the online inquiries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (OnlineInquiry onlineInquiry : findByGroup(groupId)) {
			remove(onlineInquiry);
		}
	}

	/**
	 * Removes all the online inquiries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (OnlineInquiry onlineInquiry : findAll()) {
			remove(onlineInquiry);
		}
	}

	/**
	 * Returns the number of online inquiries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching online inquiries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompany(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ONLINEINQUIRY_WHERE);

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
	 * Returns the number of online inquiries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching online inquiries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ONLINEINQUIRY_WHERE);

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
	 * Returns the number of online inquiries that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching online inquiries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroup(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroup(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_ONLINEINQUIRY_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				OnlineInquiry.class.getName(),
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
	 * Returns the number of online inquiries.
	 *
	 * @return the number of online inquiries
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ONLINEINQUIRY);

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
	 * Initializes the online inquiry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.portal_egov.portlet.inquiry.model.OnlineInquiry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<OnlineInquiry>> listenersList = new ArrayList<ModelListener<OnlineInquiry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<OnlineInquiry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(OnlineInquiryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = OnlineInquiryPersistence.class)
	protected OnlineInquiryPersistence onlineInquiryPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_ONLINEINQUIRY = "SELECT onlineInquiry FROM OnlineInquiry onlineInquiry";
	private static final String _SQL_SELECT_ONLINEINQUIRY_WHERE = "SELECT onlineInquiry FROM OnlineInquiry onlineInquiry WHERE ";
	private static final String _SQL_COUNT_ONLINEINQUIRY = "SELECT COUNT(onlineInquiry) FROM OnlineInquiry onlineInquiry";
	private static final String _SQL_COUNT_ONLINEINQUIRY_WHERE = "SELECT COUNT(onlineInquiry) FROM OnlineInquiry onlineInquiry WHERE ";
	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "onlineInquiry.companyId = ?";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "onlineInquiry.groupId = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "onlineInquiry.inquiryId";
	private static final String _FILTER_SQL_SELECT_ONLINEINQUIRY_WHERE = "SELECT DISTINCT {onlineInquiry.*} FROM OnlineInquiry onlineInquiry WHERE ";
	private static final String _FILTER_SQL_SELECT_ONLINEINQUIRY_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {OnlineInquiry.*} FROM (SELECT DISTINCT onlineInquiry.inquiryId FROM OnlineInquiry onlineInquiry WHERE ";
	private static final String _FILTER_SQL_SELECT_ONLINEINQUIRY_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN OnlineInquiry ON TEMP_TABLE.inquiryId = OnlineInquiry.inquiryId";
	private static final String _FILTER_SQL_COUNT_ONLINEINQUIRY_WHERE = "SELECT COUNT(DISTINCT onlineInquiry.inquiryId) AS COUNT_VALUE FROM OnlineInquiry onlineInquiry WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "onlineInquiry";
	private static final String _FILTER_ENTITY_TABLE = "OnlineInquiry";
	private static final String _ORDER_BY_ENTITY_ALIAS = "onlineInquiry.";
	private static final String _ORDER_BY_ENTITY_TABLE = "OnlineInquiry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No OnlineInquiry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No OnlineInquiry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(OnlineInquiryPersistenceImpl.class);
	private static OnlineInquiry _nullOnlineInquiry = new OnlineInquiryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<OnlineInquiry> toCacheModel() {
				return _nullOnlineInquiryCacheModel;
			}
		};

	private static CacheModel<OnlineInquiry> _nullOnlineInquiryCacheModel = new CacheModel<OnlineInquiry>() {
			public OnlineInquiry toEntityModel() {
				return _nullOnlineInquiry;
			}
		};
}