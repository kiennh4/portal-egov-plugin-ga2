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

package com.portal_egov.portlet.citizen_inquiry.service.persistence;

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

import com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryException;
import com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry;
import com.portal_egov.portlet.citizen_inquiry.model.impl.CitizenInquiryImpl;
import com.portal_egov.portlet.citizen_inquiry.model.impl.CitizenInquiryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the citizen inquiry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see CitizenInquiryPersistence
 * @see CitizenInquiryUtil
 * @generated
 */
public class CitizenInquiryPersistenceImpl extends BasePersistenceImpl<CitizenInquiry>
	implements CitizenInquiryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CitizenInquiryUtil} to access the citizen inquiry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CitizenInquiryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(CitizenInquiryModelImpl.ENTITY_CACHE_ENABLED,
			CitizenInquiryModelImpl.FINDER_CACHE_ENABLED,
			CitizenInquiryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompany",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(CitizenInquiryModelImpl.ENTITY_CACHE_ENABLED,
			CitizenInquiryModelImpl.FINDER_CACHE_ENABLED,
			CitizenInquiryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			CitizenInquiryModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(CitizenInquiryModelImpl.ENTITY_CACHE_ENABLED,
			CitizenInquiryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(CitizenInquiryModelImpl.ENTITY_CACHE_ENABLED,
			CitizenInquiryModelImpl.FINDER_CACHE_ENABLED,
			CitizenInquiryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(CitizenInquiryModelImpl.ENTITY_CACHE_ENABLED,
			CitizenInquiryModelImpl.FINDER_CACHE_ENABLED,
			CitizenInquiryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			CitizenInquiryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(CitizenInquiryModelImpl.ENTITY_CACHE_ENABLED,
			CitizenInquiryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORY = new FinderPath(CitizenInquiryModelImpl.ENTITY_CACHE_ENABLED,
			CitizenInquiryModelImpl.FINDER_CACHE_ENABLED,
			CitizenInquiryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCategory",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY =
		new FinderPath(CitizenInquiryModelImpl.ENTITY_CACHE_ENABLED,
			CitizenInquiryModelImpl.FINDER_CACHE_ENABLED,
			CitizenInquiryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCategory",
			new String[] { Long.class.getName() },
			CitizenInquiryModelImpl.CATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORY = new FinderPath(CitizenInquiryModelImpl.ENTITY_CACHE_ENABLED,
			CitizenInquiryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategory",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CitizenInquiryModelImpl.ENTITY_CACHE_ENABLED,
			CitizenInquiryModelImpl.FINDER_CACHE_ENABLED,
			CitizenInquiryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CitizenInquiryModelImpl.ENTITY_CACHE_ENABLED,
			CitizenInquiryModelImpl.FINDER_CACHE_ENABLED,
			CitizenInquiryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CitizenInquiryModelImpl.ENTITY_CACHE_ENABLED,
			CitizenInquiryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the citizen inquiry in the entity cache if it is enabled.
	 *
	 * @param citizenInquiry the citizen inquiry
	 */
	public void cacheResult(CitizenInquiry citizenInquiry) {
		EntityCacheUtil.putResult(CitizenInquiryModelImpl.ENTITY_CACHE_ENABLED,
			CitizenInquiryImpl.class, citizenInquiry.getPrimaryKey(),
			citizenInquiry);

		citizenInquiry.resetOriginalValues();
	}

	/**
	 * Caches the citizen inquiries in the entity cache if it is enabled.
	 *
	 * @param citizenInquiries the citizen inquiries
	 */
	public void cacheResult(List<CitizenInquiry> citizenInquiries) {
		for (CitizenInquiry citizenInquiry : citizenInquiries) {
			if (EntityCacheUtil.getResult(
						CitizenInquiryModelImpl.ENTITY_CACHE_ENABLED,
						CitizenInquiryImpl.class, citizenInquiry.getPrimaryKey()) == null) {
				cacheResult(citizenInquiry);
			}
			else {
				citizenInquiry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all citizen inquiries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CitizenInquiryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CitizenInquiryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the citizen inquiry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CitizenInquiry citizenInquiry) {
		EntityCacheUtil.removeResult(CitizenInquiryModelImpl.ENTITY_CACHE_ENABLED,
			CitizenInquiryImpl.class, citizenInquiry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CitizenInquiry> citizenInquiries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CitizenInquiry citizenInquiry : citizenInquiries) {
			EntityCacheUtil.removeResult(CitizenInquiryModelImpl.ENTITY_CACHE_ENABLED,
				CitizenInquiryImpl.class, citizenInquiry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new citizen inquiry with the primary key. Does not add the citizen inquiry to the database.
	 *
	 * @param inquiryId the primary key for the new citizen inquiry
	 * @return the new citizen inquiry
	 */
	public CitizenInquiry create(long inquiryId) {
		CitizenInquiry citizenInquiry = new CitizenInquiryImpl();

		citizenInquiry.setNew(true);
		citizenInquiry.setPrimaryKey(inquiryId);

		return citizenInquiry;
	}

	/**
	 * Removes the citizen inquiry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param inquiryId the primary key of the citizen inquiry
	 * @return the citizen inquiry that was removed
	 * @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryException if a citizen inquiry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CitizenInquiry remove(long inquiryId)
		throws NoSuchCitizenInquiryException, SystemException {
		return remove(Long.valueOf(inquiryId));
	}

	/**
	 * Removes the citizen inquiry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the citizen inquiry
	 * @return the citizen inquiry that was removed
	 * @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryException if a citizen inquiry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CitizenInquiry remove(Serializable primaryKey)
		throws NoSuchCitizenInquiryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CitizenInquiry citizenInquiry = (CitizenInquiry)session.get(CitizenInquiryImpl.class,
					primaryKey);

			if (citizenInquiry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCitizenInquiryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(citizenInquiry);
		}
		catch (NoSuchCitizenInquiryException nsee) {
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
	protected CitizenInquiry removeImpl(CitizenInquiry citizenInquiry)
		throws SystemException {
		citizenInquiry = toUnwrappedModel(citizenInquiry);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, citizenInquiry);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(citizenInquiry);

		return citizenInquiry;
	}

	@Override
	public CitizenInquiry updateImpl(
		com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry citizenInquiry,
		boolean merge) throws SystemException {
		citizenInquiry = toUnwrappedModel(citizenInquiry);

		boolean isNew = citizenInquiry.isNew();

		CitizenInquiryModelImpl citizenInquiryModelImpl = (CitizenInquiryModelImpl)citizenInquiry;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, citizenInquiry, merge);

			citizenInquiry.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CitizenInquiryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((citizenInquiryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(citizenInquiryModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] {
						Long.valueOf(citizenInquiryModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((citizenInquiryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(citizenInquiryModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] {
						Long.valueOf(citizenInquiryModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}

			if ((citizenInquiryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(citizenInquiryModelImpl.getOriginalCategoryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
					args);

				args = new Object[] {
						Long.valueOf(citizenInquiryModelImpl.getCategoryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
					args);
			}
		}

		EntityCacheUtil.putResult(CitizenInquiryModelImpl.ENTITY_CACHE_ENABLED,
			CitizenInquiryImpl.class, citizenInquiry.getPrimaryKey(),
			citizenInquiry);

		return citizenInquiry;
	}

	protected CitizenInquiry toUnwrappedModel(CitizenInquiry citizenInquiry) {
		if (citizenInquiry instanceof CitizenInquiryImpl) {
			return citizenInquiry;
		}

		CitizenInquiryImpl citizenInquiryImpl = new CitizenInquiryImpl();

		citizenInquiryImpl.setNew(citizenInquiry.isNew());
		citizenInquiryImpl.setPrimaryKey(citizenInquiry.getPrimaryKey());

		citizenInquiryImpl.setInquiryId(citizenInquiry.getInquiryId());
		citizenInquiryImpl.setGroupId(citizenInquiry.getGroupId());
		citizenInquiryImpl.setCompanyId(citizenInquiry.getCompanyId());
		citizenInquiryImpl.setUserId(citizenInquiry.getUserId());
		citizenInquiryImpl.setUserName(citizenInquiry.getUserName());
		citizenInquiryImpl.setCreateDate(citizenInquiry.getCreateDate());
		citizenInquiryImpl.setModifiedDate(citizenInquiry.getModifiedDate());
		citizenInquiryImpl.setCategoryId(citizenInquiry.getCategoryId());
		citizenInquiryImpl.setCitizenName(citizenInquiry.getCitizenName());
		citizenInquiryImpl.setCitizenPhone(citizenInquiry.getCitizenPhone());
		citizenInquiryImpl.setCitizenEmail(citizenInquiry.getCitizenEmail());
		citizenInquiryImpl.setCitizenAddress(citizenInquiry.getCitizenAddress());
		citizenInquiryImpl.setInquiryTitle(citizenInquiry.getInquiryTitle());
		citizenInquiryImpl.setInquiryContent(citizenInquiry.getInquiryContent());
		citizenInquiryImpl.setInquiryFeedback(citizenInquiry.getInquiryFeedback());
		citizenInquiryImpl.setInquiryFeedbackUser(citizenInquiry.getInquiryFeedbackUser());
		citizenInquiryImpl.setInquiryFeedbackDate(citizenInquiry.getInquiryFeedbackDate());
		citizenInquiryImpl.setInquiryStatus(citizenInquiry.getInquiryStatus());
		citizenInquiryImpl.setApproved(citizenInquiry.isApproved());

		return citizenInquiryImpl;
	}

	/**
	 * Returns the citizen inquiry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the citizen inquiry
	 * @return the citizen inquiry
	 * @throws com.liferay.portal.NoSuchModelException if a citizen inquiry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CitizenInquiry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the citizen inquiry with the primary key or throws a {@link com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryException} if it could not be found.
	 *
	 * @param inquiryId the primary key of the citizen inquiry
	 * @return the citizen inquiry
	 * @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryException if a citizen inquiry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CitizenInquiry findByPrimaryKey(long inquiryId)
		throws NoSuchCitizenInquiryException, SystemException {
		CitizenInquiry citizenInquiry = fetchByPrimaryKey(inquiryId);

		if (citizenInquiry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + inquiryId);
			}

			throw new NoSuchCitizenInquiryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				inquiryId);
		}

		return citizenInquiry;
	}

	/**
	 * Returns the citizen inquiry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the citizen inquiry
	 * @return the citizen inquiry, or <code>null</code> if a citizen inquiry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CitizenInquiry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the citizen inquiry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param inquiryId the primary key of the citizen inquiry
	 * @return the citizen inquiry, or <code>null</code> if a citizen inquiry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CitizenInquiry fetchByPrimaryKey(long inquiryId)
		throws SystemException {
		CitizenInquiry citizenInquiry = (CitizenInquiry)EntityCacheUtil.getResult(CitizenInquiryModelImpl.ENTITY_CACHE_ENABLED,
				CitizenInquiryImpl.class, inquiryId);

		if (citizenInquiry == _nullCitizenInquiry) {
			return null;
		}

		if (citizenInquiry == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				citizenInquiry = (CitizenInquiry)session.get(CitizenInquiryImpl.class,
						Long.valueOf(inquiryId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (citizenInquiry != null) {
					cacheResult(citizenInquiry);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CitizenInquiryModelImpl.ENTITY_CACHE_ENABLED,
						CitizenInquiryImpl.class, inquiryId, _nullCitizenInquiry);
				}

				closeSession(session);
			}
		}

		return citizenInquiry;
	}

	/**
	 * Returns all the citizen inquiries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching citizen inquiries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CitizenInquiry> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the citizen inquiries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of citizen inquiries
	 * @param end the upper bound of the range of citizen inquiries (not inclusive)
	 * @return the range of matching citizen inquiries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CitizenInquiry> findByCompany(long companyId, int start, int end)
		throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the citizen inquiries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of citizen inquiries
	 * @param end the upper bound of the range of citizen inquiries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching citizen inquiries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CitizenInquiry> findByCompany(long companyId, int start,
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

		List<CitizenInquiry> list = (List<CitizenInquiry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CitizenInquiry citizenInquiry : list) {
				if ((companyId != citizenInquiry.getCompanyId())) {
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

			query.append(_SQL_SELECT_CITIZENINQUIRY_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CitizenInquiryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<CitizenInquiry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first citizen inquiry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching citizen inquiry
	 * @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryException if a matching citizen inquiry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CitizenInquiry findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCitizenInquiryException, SystemException {
		CitizenInquiry citizenInquiry = fetchByCompany_First(companyId,
				orderByComparator);

		if (citizenInquiry != null) {
			return citizenInquiry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCitizenInquiryException(msg.toString());
	}

	/**
	 * Returns the first citizen inquiry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching citizen inquiry, or <code>null</code> if a matching citizen inquiry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CitizenInquiry fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CitizenInquiry> list = findByCompany(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last citizen inquiry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching citizen inquiry
	 * @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryException if a matching citizen inquiry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CitizenInquiry findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCitizenInquiryException, SystemException {
		CitizenInquiry citizenInquiry = fetchByCompany_Last(companyId,
				orderByComparator);

		if (citizenInquiry != null) {
			return citizenInquiry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCitizenInquiryException(msg.toString());
	}

	/**
	 * Returns the last citizen inquiry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching citizen inquiry, or <code>null</code> if a matching citizen inquiry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CitizenInquiry fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		List<CitizenInquiry> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the citizen inquiries before and after the current citizen inquiry in the ordered set where companyId = &#63;.
	 *
	 * @param inquiryId the primary key of the current citizen inquiry
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next citizen inquiry
	 * @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryException if a citizen inquiry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CitizenInquiry[] findByCompany_PrevAndNext(long inquiryId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchCitizenInquiryException, SystemException {
		CitizenInquiry citizenInquiry = findByPrimaryKey(inquiryId);

		Session session = null;

		try {
			session = openSession();

			CitizenInquiry[] array = new CitizenInquiryImpl[3];

			array[0] = getByCompany_PrevAndNext(session, citizenInquiry,
					companyId, orderByComparator, true);

			array[1] = citizenInquiry;

			array[2] = getByCompany_PrevAndNext(session, citizenInquiry,
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

	protected CitizenInquiry getByCompany_PrevAndNext(Session session,
		CitizenInquiry citizenInquiry, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CITIZENINQUIRY_WHERE);

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
			query.append(CitizenInquiryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(citizenInquiry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CitizenInquiry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the citizen inquiries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching citizen inquiries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CitizenInquiry> findByGroup(long groupId)
		throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the citizen inquiries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of citizen inquiries
	 * @param end the upper bound of the range of citizen inquiries (not inclusive)
	 * @return the range of matching citizen inquiries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CitizenInquiry> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the citizen inquiries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of citizen inquiries
	 * @param end the upper bound of the range of citizen inquiries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching citizen inquiries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CitizenInquiry> findByGroup(long groupId, int start, int end,
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

		List<CitizenInquiry> list = (List<CitizenInquiry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CitizenInquiry citizenInquiry : list) {
				if ((groupId != citizenInquiry.getGroupId())) {
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

			query.append(_SQL_SELECT_CITIZENINQUIRY_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CitizenInquiryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<CitizenInquiry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first citizen inquiry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching citizen inquiry
	 * @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryException if a matching citizen inquiry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CitizenInquiry findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCitizenInquiryException, SystemException {
		CitizenInquiry citizenInquiry = fetchByGroup_First(groupId,
				orderByComparator);

		if (citizenInquiry != null) {
			return citizenInquiry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCitizenInquiryException(msg.toString());
	}

	/**
	 * Returns the first citizen inquiry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching citizen inquiry, or <code>null</code> if a matching citizen inquiry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CitizenInquiry fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CitizenInquiry> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last citizen inquiry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching citizen inquiry
	 * @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryException if a matching citizen inquiry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CitizenInquiry findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCitizenInquiryException, SystemException {
		CitizenInquiry citizenInquiry = fetchByGroup_Last(groupId,
				orderByComparator);

		if (citizenInquiry != null) {
			return citizenInquiry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCitizenInquiryException(msg.toString());
	}

	/**
	 * Returns the last citizen inquiry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching citizen inquiry, or <code>null</code> if a matching citizen inquiry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CitizenInquiry fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<CitizenInquiry> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the citizen inquiries before and after the current citizen inquiry in the ordered set where groupId = &#63;.
	 *
	 * @param inquiryId the primary key of the current citizen inquiry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next citizen inquiry
	 * @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryException if a citizen inquiry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CitizenInquiry[] findByGroup_PrevAndNext(long inquiryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCitizenInquiryException, SystemException {
		CitizenInquiry citizenInquiry = findByPrimaryKey(inquiryId);

		Session session = null;

		try {
			session = openSession();

			CitizenInquiry[] array = new CitizenInquiryImpl[3];

			array[0] = getByGroup_PrevAndNext(session, citizenInquiry, groupId,
					orderByComparator, true);

			array[1] = citizenInquiry;

			array[2] = getByGroup_PrevAndNext(session, citizenInquiry, groupId,
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

	protected CitizenInquiry getByGroup_PrevAndNext(Session session,
		CitizenInquiry citizenInquiry, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CITIZENINQUIRY_WHERE);

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
			query.append(CitizenInquiryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(citizenInquiry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CitizenInquiry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the citizen inquiries that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching citizen inquiries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CitizenInquiry> filterFindByGroup(long groupId)
		throws SystemException {
		return filterFindByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the citizen inquiries that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of citizen inquiries
	 * @param end the upper bound of the range of citizen inquiries (not inclusive)
	 * @return the range of matching citizen inquiries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CitizenInquiry> filterFindByGroup(long groupId, int start,
		int end) throws SystemException {
		return filterFindByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the citizen inquiries that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of citizen inquiries
	 * @param end the upper bound of the range of citizen inquiries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching citizen inquiries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CitizenInquiry> filterFindByGroup(long groupId, int start,
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
			query.append(_FILTER_SQL_SELECT_CITIZENINQUIRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CITIZENINQUIRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CITIZENINQUIRY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CitizenInquiryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CitizenInquiryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CitizenInquiry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CitizenInquiryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CitizenInquiryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<CitizenInquiry>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the citizen inquiries before and after the current citizen inquiry in the ordered set of citizen inquiries that the user has permission to view where groupId = &#63;.
	 *
	 * @param inquiryId the primary key of the current citizen inquiry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next citizen inquiry
	 * @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryException if a citizen inquiry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CitizenInquiry[] filterFindByGroup_PrevAndNext(long inquiryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCitizenInquiryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup_PrevAndNext(inquiryId, groupId, orderByComparator);
		}

		CitizenInquiry citizenInquiry = findByPrimaryKey(inquiryId);

		Session session = null;

		try {
			session = openSession();

			CitizenInquiry[] array = new CitizenInquiryImpl[3];

			array[0] = filterGetByGroup_PrevAndNext(session, citizenInquiry,
					groupId, orderByComparator, true);

			array[1] = citizenInquiry;

			array[2] = filterGetByGroup_PrevAndNext(session, citizenInquiry,
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

	protected CitizenInquiry filterGetByGroup_PrevAndNext(Session session,
		CitizenInquiry citizenInquiry, long groupId,
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
			query.append(_FILTER_SQL_SELECT_CITIZENINQUIRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CITIZENINQUIRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CITIZENINQUIRY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CitizenInquiryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CitizenInquiryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CitizenInquiry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CitizenInquiryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CitizenInquiryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(citizenInquiry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CitizenInquiry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the citizen inquiries where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the matching citizen inquiries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CitizenInquiry> findByCategory(long categoryId)
		throws SystemException {
		return findByCategory(categoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the citizen inquiries where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of citizen inquiries
	 * @param end the upper bound of the range of citizen inquiries (not inclusive)
	 * @return the range of matching citizen inquiries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CitizenInquiry> findByCategory(long categoryId, int start,
		int end) throws SystemException {
		return findByCategory(categoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the citizen inquiries where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of citizen inquiries
	 * @param end the upper bound of the range of citizen inquiries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching citizen inquiries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CitizenInquiry> findByCategory(long categoryId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY;
			finderArgs = new Object[] { categoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORY;
			finderArgs = new Object[] { categoryId, start, end, orderByComparator };
		}

		List<CitizenInquiry> list = (List<CitizenInquiry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CitizenInquiry citizenInquiry : list) {
				if ((categoryId != citizenInquiry.getCategoryId())) {
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

			query.append(_SQL_SELECT_CITIZENINQUIRY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CitizenInquiryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				list = (List<CitizenInquiry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first citizen inquiry in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching citizen inquiry
	 * @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryException if a matching citizen inquiry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CitizenInquiry findByCategory_First(long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchCitizenInquiryException, SystemException {
		CitizenInquiry citizenInquiry = fetchByCategory_First(categoryId,
				orderByComparator);

		if (citizenInquiry != null) {
			return citizenInquiry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCitizenInquiryException(msg.toString());
	}

	/**
	 * Returns the first citizen inquiry in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching citizen inquiry, or <code>null</code> if a matching citizen inquiry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CitizenInquiry fetchByCategory_First(long categoryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CitizenInquiry> list = findByCategory(categoryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last citizen inquiry in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching citizen inquiry
	 * @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryException if a matching citizen inquiry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CitizenInquiry findByCategory_Last(long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchCitizenInquiryException, SystemException {
		CitizenInquiry citizenInquiry = fetchByCategory_Last(categoryId,
				orderByComparator);

		if (citizenInquiry != null) {
			return citizenInquiry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCitizenInquiryException(msg.toString());
	}

	/**
	 * Returns the last citizen inquiry in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching citizen inquiry, or <code>null</code> if a matching citizen inquiry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CitizenInquiry fetchByCategory_Last(long categoryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCategory(categoryId);

		List<CitizenInquiry> list = findByCategory(categoryId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the citizen inquiries before and after the current citizen inquiry in the ordered set where categoryId = &#63;.
	 *
	 * @param inquiryId the primary key of the current citizen inquiry
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next citizen inquiry
	 * @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryException if a citizen inquiry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CitizenInquiry[] findByCategory_PrevAndNext(long inquiryId,
		long categoryId, OrderByComparator orderByComparator)
		throws NoSuchCitizenInquiryException, SystemException {
		CitizenInquiry citizenInquiry = findByPrimaryKey(inquiryId);

		Session session = null;

		try {
			session = openSession();

			CitizenInquiry[] array = new CitizenInquiryImpl[3];

			array[0] = getByCategory_PrevAndNext(session, citizenInquiry,
					categoryId, orderByComparator, true);

			array[1] = citizenInquiry;

			array[2] = getByCategory_PrevAndNext(session, citizenInquiry,
					categoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CitizenInquiry getByCategory_PrevAndNext(Session session,
		CitizenInquiry citizenInquiry, long categoryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CITIZENINQUIRY_WHERE);

		query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

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
			query.append(CitizenInquiryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(citizenInquiry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CitizenInquiry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the citizen inquiries.
	 *
	 * @return the citizen inquiries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CitizenInquiry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the citizen inquiries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of citizen inquiries
	 * @param end the upper bound of the range of citizen inquiries (not inclusive)
	 * @return the range of citizen inquiries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CitizenInquiry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the citizen inquiries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of citizen inquiries
	 * @param end the upper bound of the range of citizen inquiries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of citizen inquiries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CitizenInquiry> findAll(int start, int end,
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

		List<CitizenInquiry> list = (List<CitizenInquiry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CITIZENINQUIRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CITIZENINQUIRY.concat(CitizenInquiryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<CitizenInquiry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CitizenInquiry>)QueryUtil.list(q,
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
	 * Removes all the citizen inquiries where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompany(long companyId) throws SystemException {
		for (CitizenInquiry citizenInquiry : findByCompany(companyId)) {
			remove(citizenInquiry);
		}
	}

	/**
	 * Removes all the citizen inquiries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (CitizenInquiry citizenInquiry : findByGroup(groupId)) {
			remove(citizenInquiry);
		}
	}

	/**
	 * Removes all the citizen inquiries where categoryId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCategory(long categoryId) throws SystemException {
		for (CitizenInquiry citizenInquiry : findByCategory(categoryId)) {
			remove(citizenInquiry);
		}
	}

	/**
	 * Removes all the citizen inquiries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (CitizenInquiry citizenInquiry : findAll()) {
			remove(citizenInquiry);
		}
	}

	/**
	 * Returns the number of citizen inquiries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching citizen inquiries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompany(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CITIZENINQUIRY_WHERE);

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
	 * Returns the number of citizen inquiries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching citizen inquiries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CITIZENINQUIRY_WHERE);

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
	 * Returns the number of citizen inquiries that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching citizen inquiries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroup(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroup(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_CITIZENINQUIRY_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CitizenInquiry.class.getName(),
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
	 * Returns the number of citizen inquiries where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the number of matching citizen inquiries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCategory(long categoryId) throws SystemException {
		Object[] finderArgs = new Object[] { categoryId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CATEGORY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CITIZENINQUIRY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

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
	 * Returns the number of citizen inquiries.
	 *
	 * @return the number of citizen inquiries
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CITIZENINQUIRY);

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
	 * Initializes the citizen inquiry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CitizenInquiry>> listenersList = new ArrayList<ModelListener<CitizenInquiry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CitizenInquiry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CitizenInquiryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CitizenInquiryPersistence.class)
	protected CitizenInquiryPersistence citizenInquiryPersistence;
	@BeanReference(type = CitizenInquiryCategoryPersistence.class)
	protected CitizenInquiryCategoryPersistence citizenInquiryCategoryPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_CITIZENINQUIRY = "SELECT citizenInquiry FROM CitizenInquiry citizenInquiry";
	private static final String _SQL_SELECT_CITIZENINQUIRY_WHERE = "SELECT citizenInquiry FROM CitizenInquiry citizenInquiry WHERE ";
	private static final String _SQL_COUNT_CITIZENINQUIRY = "SELECT COUNT(citizenInquiry) FROM CitizenInquiry citizenInquiry";
	private static final String _SQL_COUNT_CITIZENINQUIRY_WHERE = "SELECT COUNT(citizenInquiry) FROM CitizenInquiry citizenInquiry WHERE ";
	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "citizenInquiry.companyId = ?";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "citizenInquiry.groupId = ?";
	private static final String _FINDER_COLUMN_CATEGORY_CATEGORYID_2 = "citizenInquiry.categoryId = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "citizenInquiry.inquiryId";
	private static final String _FILTER_SQL_SELECT_CITIZENINQUIRY_WHERE = "SELECT DISTINCT {citizenInquiry.*} FROM CitizenInquiry citizenInquiry WHERE ";
	private static final String _FILTER_SQL_SELECT_CITIZENINQUIRY_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {CitizenInquiry.*} FROM (SELECT DISTINCT citizenInquiry.inquiryId FROM CitizenInquiry citizenInquiry WHERE ";
	private static final String _FILTER_SQL_SELECT_CITIZENINQUIRY_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN CitizenInquiry ON TEMP_TABLE.inquiryId = CitizenInquiry.inquiryId";
	private static final String _FILTER_SQL_COUNT_CITIZENINQUIRY_WHERE = "SELECT COUNT(DISTINCT citizenInquiry.inquiryId) AS COUNT_VALUE FROM CitizenInquiry citizenInquiry WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "citizenInquiry";
	private static final String _FILTER_ENTITY_TABLE = "CitizenInquiry";
	private static final String _ORDER_BY_ENTITY_ALIAS = "citizenInquiry.";
	private static final String _ORDER_BY_ENTITY_TABLE = "CitizenInquiry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CitizenInquiry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CitizenInquiry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CitizenInquiryPersistenceImpl.class);
	private static CitizenInquiry _nullCitizenInquiry = new CitizenInquiryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CitizenInquiry> toCacheModel() {
				return _nullCitizenInquiryCacheModel;
			}
		};

	private static CacheModel<CitizenInquiry> _nullCitizenInquiryCacheModel = new CacheModel<CitizenInquiry>() {
			public CitizenInquiry toEntityModel() {
				return _nullCitizenInquiry;
			}
		};
}