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

package com.portal_egov.portlet.compaints.service.persistence;

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

import com.portal_egov.portlet.compaints.NoSuchComplaintException;
import com.portal_egov.portlet.compaints.model.Complaint;
import com.portal_egov.portlet.compaints.model.impl.ComplaintImpl;
import com.portal_egov.portlet.compaints.model.impl.ComplaintModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the complaint service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see ComplaintPersistence
 * @see ComplaintUtil
 * @generated
 */
public class ComplaintPersistenceImpl extends BasePersistenceImpl<Complaint>
	implements ComplaintPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ComplaintUtil} to access the complaint persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ComplaintImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(ComplaintModelImpl.ENTITY_CACHE_ENABLED,
			ComplaintModelImpl.FINDER_CACHE_ENABLED, ComplaintImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(ComplaintModelImpl.ENTITY_CACHE_ENABLED,
			ComplaintModelImpl.FINDER_CACHE_ENABLED, ComplaintImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			ComplaintModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(ComplaintModelImpl.ENTITY_CACHE_ENABLED,
			ComplaintModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(ComplaintModelImpl.ENTITY_CACHE_ENABLED,
			ComplaintModelImpl.FINDER_CACHE_ENABLED, ComplaintImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(ComplaintModelImpl.ENTITY_CACHE_ENABLED,
			ComplaintModelImpl.FINDER_CACHE_ENABLED, ComplaintImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			ComplaintModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(ComplaintModelImpl.ENTITY_CACHE_ENABLED,
			ComplaintModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ComplaintModelImpl.ENTITY_CACHE_ENABLED,
			ComplaintModelImpl.FINDER_CACHE_ENABLED, ComplaintImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ComplaintModelImpl.ENTITY_CACHE_ENABLED,
			ComplaintModelImpl.FINDER_CACHE_ENABLED, ComplaintImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ComplaintModelImpl.ENTITY_CACHE_ENABLED,
			ComplaintModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the complaint in the entity cache if it is enabled.
	 *
	 * @param complaint the complaint
	 */
	public void cacheResult(Complaint complaint) {
		EntityCacheUtil.putResult(ComplaintModelImpl.ENTITY_CACHE_ENABLED,
			ComplaintImpl.class, complaint.getPrimaryKey(), complaint);

		complaint.resetOriginalValues();
	}

	/**
	 * Caches the complaints in the entity cache if it is enabled.
	 *
	 * @param complaints the complaints
	 */
	public void cacheResult(List<Complaint> complaints) {
		for (Complaint complaint : complaints) {
			if (EntityCacheUtil.getResult(
						ComplaintModelImpl.ENTITY_CACHE_ENABLED,
						ComplaintImpl.class, complaint.getPrimaryKey()) == null) {
				cacheResult(complaint);
			}
			else {
				complaint.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all complaints.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ComplaintImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ComplaintImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the complaint.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Complaint complaint) {
		EntityCacheUtil.removeResult(ComplaintModelImpl.ENTITY_CACHE_ENABLED,
			ComplaintImpl.class, complaint.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Complaint> complaints) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Complaint complaint : complaints) {
			EntityCacheUtil.removeResult(ComplaintModelImpl.ENTITY_CACHE_ENABLED,
				ComplaintImpl.class, complaint.getPrimaryKey());
		}
	}

	/**
	 * Creates a new complaint with the primary key. Does not add the complaint to the database.
	 *
	 * @param complaintId the primary key for the new complaint
	 * @return the new complaint
	 */
	public Complaint create(long complaintId) {
		Complaint complaint = new ComplaintImpl();

		complaint.setNew(true);
		complaint.setPrimaryKey(complaintId);

		return complaint;
	}

	/**
	 * Removes the complaint with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param complaintId the primary key of the complaint
	 * @return the complaint that was removed
	 * @throws com.portal_egov.portlet.compaints.NoSuchComplaintException if a complaint with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaint remove(long complaintId)
		throws NoSuchComplaintException, SystemException {
		return remove(Long.valueOf(complaintId));
	}

	/**
	 * Removes the complaint with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the complaint
	 * @return the complaint that was removed
	 * @throws com.portal_egov.portlet.compaints.NoSuchComplaintException if a complaint with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Complaint remove(Serializable primaryKey)
		throws NoSuchComplaintException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Complaint complaint = (Complaint)session.get(ComplaintImpl.class,
					primaryKey);

			if (complaint == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchComplaintException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(complaint);
		}
		catch (NoSuchComplaintException nsee) {
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
	protected Complaint removeImpl(Complaint complaint)
		throws SystemException {
		complaint = toUnwrappedModel(complaint);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, complaint);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(complaint);

		return complaint;
	}

	@Override
	public Complaint updateImpl(
		com.portal_egov.portlet.compaints.model.Complaint complaint,
		boolean merge) throws SystemException {
		complaint = toUnwrappedModel(complaint);

		boolean isNew = complaint.isNew();

		ComplaintModelImpl complaintModelImpl = (ComplaintModelImpl)complaint;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, complaint, merge);

			complaint.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ComplaintModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((complaintModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(complaintModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] {
						Long.valueOf(complaintModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((complaintModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(complaintModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] {
						Long.valueOf(complaintModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(ComplaintModelImpl.ENTITY_CACHE_ENABLED,
			ComplaintImpl.class, complaint.getPrimaryKey(), complaint);

		return complaint;
	}

	protected Complaint toUnwrappedModel(Complaint complaint) {
		if (complaint instanceof ComplaintImpl) {
			return complaint;
		}

		ComplaintImpl complaintImpl = new ComplaintImpl();

		complaintImpl.setNew(complaint.isNew());
		complaintImpl.setPrimaryKey(complaint.getPrimaryKey());

		complaintImpl.setComplaintId(complaint.getComplaintId());
		complaintImpl.setGroupId(complaint.getGroupId());
		complaintImpl.setCompanyId(complaint.getCompanyId());
		complaintImpl.setUserId(complaint.getUserId());
		complaintImpl.setUserName(complaint.getUserName());
		complaintImpl.setCreateDate(complaint.getCreateDate());
		complaintImpl.setModifiedDate(complaint.getModifiedDate());
		complaintImpl.setComplaintTitle(complaint.getComplaintTitle());
		complaintImpl.setComplaintDescription(complaint.getComplaintDescription());
		complaintImpl.setComplaintContent(complaint.getComplaintContent());
		complaintImpl.setFileAttachmentURL(complaint.getFileAttachmentURL());
		complaintImpl.setComplaintStatus(complaint.getComplaintStatus());

		return complaintImpl;
	}

	/**
	 * Returns the complaint with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the complaint
	 * @return the complaint
	 * @throws com.liferay.portal.NoSuchModelException if a complaint with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Complaint findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the complaint with the primary key or throws a {@link com.portal_egov.portlet.compaints.NoSuchComplaintException} if it could not be found.
	 *
	 * @param complaintId the primary key of the complaint
	 * @return the complaint
	 * @throws com.portal_egov.portlet.compaints.NoSuchComplaintException if a complaint with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaint findByPrimaryKey(long complaintId)
		throws NoSuchComplaintException, SystemException {
		Complaint complaint = fetchByPrimaryKey(complaintId);

		if (complaint == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + complaintId);
			}

			throw new NoSuchComplaintException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				complaintId);
		}

		return complaint;
	}

	/**
	 * Returns the complaint with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the complaint
	 * @return the complaint, or <code>null</code> if a complaint with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Complaint fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the complaint with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param complaintId the primary key of the complaint
	 * @return the complaint, or <code>null</code> if a complaint with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaint fetchByPrimaryKey(long complaintId)
		throws SystemException {
		Complaint complaint = (Complaint)EntityCacheUtil.getResult(ComplaintModelImpl.ENTITY_CACHE_ENABLED,
				ComplaintImpl.class, complaintId);

		if (complaint == _nullComplaint) {
			return null;
		}

		if (complaint == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				complaint = (Complaint)session.get(ComplaintImpl.class,
						Long.valueOf(complaintId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (complaint != null) {
					cacheResult(complaint);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ComplaintModelImpl.ENTITY_CACHE_ENABLED,
						ComplaintImpl.class, complaintId, _nullComplaint);
				}

				closeSession(session);
			}
		}

		return complaint;
	}

	/**
	 * Returns all the complaints where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching complaints
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaint> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the complaints where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of complaints
	 * @param end the upper bound of the range of complaints (not inclusive)
	 * @return the range of matching complaints
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaint> findByCompany(long companyId, int start, int end)
		throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the complaints where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of complaints
	 * @param end the upper bound of the range of complaints (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching complaints
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaint> findByCompany(long companyId, int start, int end,
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

		List<Complaint> list = (List<Complaint>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Complaint complaint : list) {
				if ((companyId != complaint.getCompanyId())) {
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

			query.append(_SQL_SELECT_COMPLAINT_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ComplaintModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<Complaint>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first complaint in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching complaint
	 * @throws com.portal_egov.portlet.compaints.NoSuchComplaintException if a matching complaint could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaint findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchComplaintException, SystemException {
		Complaint complaint = fetchByCompany_First(companyId, orderByComparator);

		if (complaint != null) {
			return complaint;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchComplaintException(msg.toString());
	}

	/**
	 * Returns the first complaint in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching complaint, or <code>null</code> if a matching complaint could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaint fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Complaint> list = findByCompany(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last complaint in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching complaint
	 * @throws com.portal_egov.portlet.compaints.NoSuchComplaintException if a matching complaint could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaint findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchComplaintException, SystemException {
		Complaint complaint = fetchByCompany_Last(companyId, orderByComparator);

		if (complaint != null) {
			return complaint;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchComplaintException(msg.toString());
	}

	/**
	 * Returns the last complaint in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching complaint, or <code>null</code> if a matching complaint could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaint fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		List<Complaint> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the complaints before and after the current complaint in the ordered set where companyId = &#63;.
	 *
	 * @param complaintId the primary key of the current complaint
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next complaint
	 * @throws com.portal_egov.portlet.compaints.NoSuchComplaintException if a complaint with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaint[] findByCompany_PrevAndNext(long complaintId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchComplaintException, SystemException {
		Complaint complaint = findByPrimaryKey(complaintId);

		Session session = null;

		try {
			session = openSession();

			Complaint[] array = new ComplaintImpl[3];

			array[0] = getByCompany_PrevAndNext(session, complaint, companyId,
					orderByComparator, true);

			array[1] = complaint;

			array[2] = getByCompany_PrevAndNext(session, complaint, companyId,
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

	protected Complaint getByCompany_PrevAndNext(Session session,
		Complaint complaint, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COMPLAINT_WHERE);

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
			query.append(ComplaintModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(complaint);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Complaint> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the complaints where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching complaints
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaint> findByGroup(long groupId) throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the complaints where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of complaints
	 * @param end the upper bound of the range of complaints (not inclusive)
	 * @return the range of matching complaints
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaint> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the complaints where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of complaints
	 * @param end the upper bound of the range of complaints (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching complaints
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaint> findByGroup(long groupId, int start, int end,
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

		List<Complaint> list = (List<Complaint>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Complaint complaint : list) {
				if ((groupId != complaint.getGroupId())) {
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

			query.append(_SQL_SELECT_COMPLAINT_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ComplaintModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<Complaint>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first complaint in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching complaint
	 * @throws com.portal_egov.portlet.compaints.NoSuchComplaintException if a matching complaint could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaint findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchComplaintException, SystemException {
		Complaint complaint = fetchByGroup_First(groupId, orderByComparator);

		if (complaint != null) {
			return complaint;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchComplaintException(msg.toString());
	}

	/**
	 * Returns the first complaint in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching complaint, or <code>null</code> if a matching complaint could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaint fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Complaint> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last complaint in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching complaint
	 * @throws com.portal_egov.portlet.compaints.NoSuchComplaintException if a matching complaint could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaint findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchComplaintException, SystemException {
		Complaint complaint = fetchByGroup_Last(groupId, orderByComparator);

		if (complaint != null) {
			return complaint;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchComplaintException(msg.toString());
	}

	/**
	 * Returns the last complaint in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching complaint, or <code>null</code> if a matching complaint could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaint fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<Complaint> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the complaints before and after the current complaint in the ordered set where groupId = &#63;.
	 *
	 * @param complaintId the primary key of the current complaint
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next complaint
	 * @throws com.portal_egov.portlet.compaints.NoSuchComplaintException if a complaint with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaint[] findByGroup_PrevAndNext(long complaintId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchComplaintException, SystemException {
		Complaint complaint = findByPrimaryKey(complaintId);

		Session session = null;

		try {
			session = openSession();

			Complaint[] array = new ComplaintImpl[3];

			array[0] = getByGroup_PrevAndNext(session, complaint, groupId,
					orderByComparator, true);

			array[1] = complaint;

			array[2] = getByGroup_PrevAndNext(session, complaint, groupId,
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

	protected Complaint getByGroup_PrevAndNext(Session session,
		Complaint complaint, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COMPLAINT_WHERE);

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
			query.append(ComplaintModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(complaint);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Complaint> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the complaints that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching complaints that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaint> filterFindByGroup(long groupId)
		throws SystemException {
		return filterFindByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the complaints that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of complaints
	 * @param end the upper bound of the range of complaints (not inclusive)
	 * @return the range of matching complaints that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaint> filterFindByGroup(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the complaints that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of complaints
	 * @param end the upper bound of the range of complaints (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching complaints that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaint> filterFindByGroup(long groupId, int start, int end,
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
			query.append(_FILTER_SQL_SELECT_COMPLAINT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_COMPLAINT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_COMPLAINT_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ComplaintModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ComplaintModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Complaint.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, ComplaintImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, ComplaintImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<Complaint>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the complaints before and after the current complaint in the ordered set of complaints that the user has permission to view where groupId = &#63;.
	 *
	 * @param complaintId the primary key of the current complaint
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next complaint
	 * @throws com.portal_egov.portlet.compaints.NoSuchComplaintException if a complaint with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaint[] filterFindByGroup_PrevAndNext(long complaintId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchComplaintException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup_PrevAndNext(complaintId, groupId,
				orderByComparator);
		}

		Complaint complaint = findByPrimaryKey(complaintId);

		Session session = null;

		try {
			session = openSession();

			Complaint[] array = new ComplaintImpl[3];

			array[0] = filterGetByGroup_PrevAndNext(session, complaint,
					groupId, orderByComparator, true);

			array[1] = complaint;

			array[2] = filterGetByGroup_PrevAndNext(session, complaint,
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

	protected Complaint filterGetByGroup_PrevAndNext(Session session,
		Complaint complaint, long groupId, OrderByComparator orderByComparator,
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
			query.append(_FILTER_SQL_SELECT_COMPLAINT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_COMPLAINT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_COMPLAINT_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ComplaintModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ComplaintModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Complaint.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, ComplaintImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, ComplaintImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(complaint);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Complaint> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the complaints.
	 *
	 * @return the complaints
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaint> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the complaints.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of complaints
	 * @param end the upper bound of the range of complaints (not inclusive)
	 * @return the range of complaints
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaint> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the complaints.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of complaints
	 * @param end the upper bound of the range of complaints (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of complaints
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaint> findAll(int start, int end,
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

		List<Complaint> list = (List<Complaint>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COMPLAINT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COMPLAINT.concat(ComplaintModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Complaint>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Complaint>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the complaints where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompany(long companyId) throws SystemException {
		for (Complaint complaint : findByCompany(companyId)) {
			remove(complaint);
		}
	}

	/**
	 * Removes all the complaints where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (Complaint complaint : findByGroup(groupId)) {
			remove(complaint);
		}
	}

	/**
	 * Removes all the complaints from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Complaint complaint : findAll()) {
			remove(complaint);
		}
	}

	/**
	 * Returns the number of complaints where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching complaints
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompany(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMPLAINT_WHERE);

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
	 * Returns the number of complaints where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching complaints
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMPLAINT_WHERE);

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
	 * Returns the number of complaints that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching complaints that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroup(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroup(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_COMPLAINT_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Complaint.class.getName(),
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
	 * Returns the number of complaints.
	 *
	 * @return the number of complaints
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_COMPLAINT);

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
	 * Initializes the complaint persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.portal_egov.portlet.compaints.model.Complaint")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Complaint>> listenersList = new ArrayList<ModelListener<Complaint>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Complaint>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ComplaintImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = ComplaintPersistence.class)
	protected ComplaintPersistence complaintPersistence;
	@BeanReference(type = Complaint_DlFileEntriesPersistence.class)
	protected Complaint_DlFileEntriesPersistence complaint_DlFileEntriesPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_COMPLAINT = "SELECT complaint FROM Complaint complaint";
	private static final String _SQL_SELECT_COMPLAINT_WHERE = "SELECT complaint FROM Complaint complaint WHERE ";
	private static final String _SQL_COUNT_COMPLAINT = "SELECT COUNT(complaint) FROM Complaint complaint";
	private static final String _SQL_COUNT_COMPLAINT_WHERE = "SELECT COUNT(complaint) FROM Complaint complaint WHERE ";
	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "complaint.companyId = ?";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "complaint.groupId = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "complaint.complaintId";
	private static final String _FILTER_SQL_SELECT_COMPLAINT_WHERE = "SELECT DISTINCT {complaint.*} FROM Complaint complaint WHERE ";
	private static final String _FILTER_SQL_SELECT_COMPLAINT_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {Complaint.*} FROM (SELECT DISTINCT complaint.complaintId FROM Complaint complaint WHERE ";
	private static final String _FILTER_SQL_SELECT_COMPLAINT_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN Complaint ON TEMP_TABLE.complaintId = Complaint.complaintId";
	private static final String _FILTER_SQL_COUNT_COMPLAINT_WHERE = "SELECT COUNT(DISTINCT complaint.complaintId) AS COUNT_VALUE FROM Complaint complaint WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "complaint";
	private static final String _FILTER_ENTITY_TABLE = "Complaint";
	private static final String _ORDER_BY_ENTITY_ALIAS = "complaint.";
	private static final String _ORDER_BY_ENTITY_TABLE = "Complaint.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Complaint exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Complaint exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ComplaintPersistenceImpl.class);
	private static Complaint _nullComplaint = new ComplaintImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Complaint> toCacheModel() {
				return _nullComplaintCacheModel;
			}
		};

	private static CacheModel<Complaint> _nullComplaintCacheModel = new CacheModel<Complaint>() {
			public Complaint toEntityModel() {
				return _nullComplaint;
			}
		};
}