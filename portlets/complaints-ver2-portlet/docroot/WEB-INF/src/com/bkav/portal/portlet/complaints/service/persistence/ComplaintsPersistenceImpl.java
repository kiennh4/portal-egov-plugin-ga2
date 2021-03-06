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

package com.bkav.portal.portlet.complaints.service.persistence;

import com.bkav.portal.portlet.complaints.NoSuchComplaintsException;
import com.bkav.portal.portlet.complaints.model.Complaints;
import com.bkav.portal.portlet.complaints.model.impl.ComplaintsImpl;
import com.bkav.portal.portlet.complaints.model.impl.ComplaintsModelImpl;

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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the complaints service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author AnhBDb
 * @see ComplaintsPersistence
 * @see ComplaintsUtil
 * @generated
 */
public class ComplaintsPersistenceImpl extends BasePersistenceImpl<Complaints>
	implements ComplaintsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ComplaintsUtil} to access the complaints persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ComplaintsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ComplaintsModelImpl.ENTITY_CACHE_ENABLED,
			ComplaintsModelImpl.FINDER_CACHE_ENABLED, ComplaintsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ComplaintsModelImpl.ENTITY_CACHE_ENABLED,
			ComplaintsModelImpl.FINDER_CACHE_ENABLED, ComplaintsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			ComplaintsModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ComplaintsModelImpl.ENTITY_CACHE_ENABLED,
			ComplaintsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(ComplaintsModelImpl.ENTITY_CACHE_ENABLED,
			ComplaintsModelImpl.FINDER_CACHE_ENABLED, ComplaintsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(ComplaintsModelImpl.ENTITY_CACHE_ENABLED,
			ComplaintsModelImpl.FINDER_CACHE_ENABLED, ComplaintsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			ComplaintsModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(ComplaintsModelImpl.ENTITY_CACHE_ENABLED,
			ComplaintsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ComplaintsModelImpl.ENTITY_CACHE_ENABLED,
			ComplaintsModelImpl.FINDER_CACHE_ENABLED, ComplaintsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ComplaintsModelImpl.ENTITY_CACHE_ENABLED,
			ComplaintsModelImpl.FINDER_CACHE_ENABLED, ComplaintsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ComplaintsModelImpl.ENTITY_CACHE_ENABLED,
			ComplaintsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the complaints in the entity cache if it is enabled.
	 *
	 * @param complaints the complaints
	 */
	public void cacheResult(Complaints complaints) {
		EntityCacheUtil.putResult(ComplaintsModelImpl.ENTITY_CACHE_ENABLED,
			ComplaintsImpl.class, complaints.getPrimaryKey(), complaints);

		complaints.resetOriginalValues();
	}

	/**
	 * Caches the complaintses in the entity cache if it is enabled.
	 *
	 * @param complaintses the complaintses
	 */
	public void cacheResult(List<Complaints> complaintses) {
		for (Complaints complaints : complaintses) {
			if (EntityCacheUtil.getResult(
						ComplaintsModelImpl.ENTITY_CACHE_ENABLED,
						ComplaintsImpl.class, complaints.getPrimaryKey()) == null) {
				cacheResult(complaints);
			}
			else {
				complaints.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all complaintses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ComplaintsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ComplaintsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the complaints.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Complaints complaints) {
		EntityCacheUtil.removeResult(ComplaintsModelImpl.ENTITY_CACHE_ENABLED,
			ComplaintsImpl.class, complaints.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Complaints> complaintses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Complaints complaints : complaintses) {
			EntityCacheUtil.removeResult(ComplaintsModelImpl.ENTITY_CACHE_ENABLED,
				ComplaintsImpl.class, complaints.getPrimaryKey());
		}
	}

	/**
	 * Creates a new complaints with the primary key. Does not add the complaints to the database.
	 *
	 * @param complaintId the primary key for the new complaints
	 * @return the new complaints
	 */
	public Complaints create(long complaintId) {
		Complaints complaints = new ComplaintsImpl();

		complaints.setNew(true);
		complaints.setPrimaryKey(complaintId);

		return complaints;
	}

	/**
	 * Removes the complaints with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param complaintId the primary key of the complaints
	 * @return the complaints that was removed
	 * @throws com.bkav.portal.portlet.complaints.NoSuchComplaintsException if a complaints with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaints remove(long complaintId)
		throws NoSuchComplaintsException, SystemException {
		return remove(Long.valueOf(complaintId));
	}

	/**
	 * Removes the complaints with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the complaints
	 * @return the complaints that was removed
	 * @throws com.bkav.portal.portlet.complaints.NoSuchComplaintsException if a complaints with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Complaints remove(Serializable primaryKey)
		throws NoSuchComplaintsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Complaints complaints = (Complaints)session.get(ComplaintsImpl.class,
					primaryKey);

			if (complaints == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchComplaintsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(complaints);
		}
		catch (NoSuchComplaintsException nsee) {
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
	protected Complaints removeImpl(Complaints complaints)
		throws SystemException {
		complaints = toUnwrappedModel(complaints);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, complaints);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(complaints);

		return complaints;
	}

	@Override
	public Complaints updateImpl(
		com.bkav.portal.portlet.complaints.model.Complaints complaints,
		boolean merge) throws SystemException {
		complaints = toUnwrappedModel(complaints);

		boolean isNew = complaints.isNew();

		ComplaintsModelImpl complaintsModelImpl = (ComplaintsModelImpl)complaints;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, complaints, merge);

			complaints.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ComplaintsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((complaintsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(complaintsModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] {
						Long.valueOf(complaintsModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((complaintsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(complaintsModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] {
						Long.valueOf(complaintsModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}
		}

		EntityCacheUtil.putResult(ComplaintsModelImpl.ENTITY_CACHE_ENABLED,
			ComplaintsImpl.class, complaints.getPrimaryKey(), complaints);

		return complaints;
	}

	protected Complaints toUnwrappedModel(Complaints complaints) {
		if (complaints instanceof ComplaintsImpl) {
			return complaints;
		}

		ComplaintsImpl complaintsImpl = new ComplaintsImpl();

		complaintsImpl.setNew(complaints.isNew());
		complaintsImpl.setPrimaryKey(complaints.getPrimaryKey());

		complaintsImpl.setComplaintId(complaints.getComplaintId());
		complaintsImpl.setComplaintNumber(complaints.getComplaintNumber());
		complaintsImpl.setSigningDate(complaints.getSigningDate());
		complaintsImpl.setComplaintName(complaints.getComplaintName());
		complaintsImpl.setComplaintDesc(complaints.getComplaintDesc());
		complaintsImpl.setComplaintContent(complaints.getComplaintContent());
		complaintsImpl.setReplyDocument(complaints.getReplyDocument());
		complaintsImpl.setGroupId(complaints.getGroupId());
		complaintsImpl.setCompanyId(complaints.getCompanyId());
		complaintsImpl.setUserId(complaints.getUserId());
		complaintsImpl.setCreateDate(complaints.getCreateDate());
		complaintsImpl.setModifiedDate(complaints.getModifiedDate());

		return complaintsImpl;
	}

	/**
	 * Returns the complaints with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the complaints
	 * @return the complaints
	 * @throws com.liferay.portal.NoSuchModelException if a complaints with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Complaints findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the complaints with the primary key or throws a {@link com.bkav.portal.portlet.complaints.NoSuchComplaintsException} if it could not be found.
	 *
	 * @param complaintId the primary key of the complaints
	 * @return the complaints
	 * @throws com.bkav.portal.portlet.complaints.NoSuchComplaintsException if a complaints with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaints findByPrimaryKey(long complaintId)
		throws NoSuchComplaintsException, SystemException {
		Complaints complaints = fetchByPrimaryKey(complaintId);

		if (complaints == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + complaintId);
			}

			throw new NoSuchComplaintsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				complaintId);
		}

		return complaints;
	}

	/**
	 * Returns the complaints with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the complaints
	 * @return the complaints, or <code>null</code> if a complaints with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Complaints fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the complaints with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param complaintId the primary key of the complaints
	 * @return the complaints, or <code>null</code> if a complaints with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaints fetchByPrimaryKey(long complaintId)
		throws SystemException {
		Complaints complaints = (Complaints)EntityCacheUtil.getResult(ComplaintsModelImpl.ENTITY_CACHE_ENABLED,
				ComplaintsImpl.class, complaintId);

		if (complaints == _nullComplaints) {
			return null;
		}

		if (complaints == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				complaints = (Complaints)session.get(ComplaintsImpl.class,
						Long.valueOf(complaintId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (complaints != null) {
					cacheResult(complaints);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ComplaintsModelImpl.ENTITY_CACHE_ENABLED,
						ComplaintsImpl.class, complaintId, _nullComplaints);
				}

				closeSession(session);
			}
		}

		return complaints;
	}

	/**
	 * Returns all the complaintses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching complaintses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaints> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the complaintses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of complaintses
	 * @param end the upper bound of the range of complaintses (not inclusive)
	 * @return the range of matching complaintses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaints> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the complaintses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of complaintses
	 * @param end the upper bound of the range of complaintses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching complaintses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaints> findByGroupId(long groupId, int start, int end,
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

		List<Complaints> list = (List<Complaints>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Complaints complaints : list) {
				if ((groupId != complaints.getGroupId())) {
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

			query.append(_SQL_SELECT_COMPLAINTS_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ComplaintsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<Complaints>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first complaints in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching complaints
	 * @throws com.bkav.portal.portlet.complaints.NoSuchComplaintsException if a matching complaints could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaints findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchComplaintsException, SystemException {
		Complaints complaints = fetchByGroupId_First(groupId, orderByComparator);

		if (complaints != null) {
			return complaints;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchComplaintsException(msg.toString());
	}

	/**
	 * Returns the first complaints in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching complaints, or <code>null</code> if a matching complaints could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaints fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Complaints> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last complaints in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching complaints
	 * @throws com.bkav.portal.portlet.complaints.NoSuchComplaintsException if a matching complaints could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaints findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchComplaintsException, SystemException {
		Complaints complaints = fetchByGroupId_Last(groupId, orderByComparator);

		if (complaints != null) {
			return complaints;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchComplaintsException(msg.toString());
	}

	/**
	 * Returns the last complaints in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching complaints, or <code>null</code> if a matching complaints could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaints fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		List<Complaints> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the complaintses before and after the current complaints in the ordered set where groupId = &#63;.
	 *
	 * @param complaintId the primary key of the current complaints
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next complaints
	 * @throws com.bkav.portal.portlet.complaints.NoSuchComplaintsException if a complaints with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaints[] findByGroupId_PrevAndNext(long complaintId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchComplaintsException, SystemException {
		Complaints complaints = findByPrimaryKey(complaintId);

		Session session = null;

		try {
			session = openSession();

			Complaints[] array = new ComplaintsImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, complaints, groupId,
					orderByComparator, true);

			array[1] = complaints;

			array[2] = getByGroupId_PrevAndNext(session, complaints, groupId,
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

	protected Complaints getByGroupId_PrevAndNext(Session session,
		Complaints complaints, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COMPLAINTS_WHERE);

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
			query.append(ComplaintsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(complaints);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Complaints> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the complaintses that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching complaintses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaints> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the complaintses that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of complaintses
	 * @param end the upper bound of the range of complaintses (not inclusive)
	 * @return the range of matching complaintses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaints> filterFindByGroupId(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the complaintses that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of complaintses
	 * @param end the upper bound of the range of complaintses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching complaintses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaints> filterFindByGroupId(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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
			query.append(_FILTER_SQL_SELECT_COMPLAINTS_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_COMPLAINTS_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_COMPLAINTS_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ComplaintsModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ComplaintsModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Complaints.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, ComplaintsImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, ComplaintsImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<Complaints>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the complaintses before and after the current complaints in the ordered set of complaintses that the user has permission to view where groupId = &#63;.
	 *
	 * @param complaintId the primary key of the current complaints
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next complaints
	 * @throws com.bkav.portal.portlet.complaints.NoSuchComplaintsException if a complaints with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaints[] filterFindByGroupId_PrevAndNext(long complaintId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchComplaintsException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(complaintId, groupId,
				orderByComparator);
		}

		Complaints complaints = findByPrimaryKey(complaintId);

		Session session = null;

		try {
			session = openSession();

			Complaints[] array = new ComplaintsImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(session, complaints,
					groupId, orderByComparator, true);

			array[1] = complaints;

			array[2] = filterGetByGroupId_PrevAndNext(session, complaints,
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

	protected Complaints filterGetByGroupId_PrevAndNext(Session session,
		Complaints complaints, long groupId,
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
			query.append(_FILTER_SQL_SELECT_COMPLAINTS_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_COMPLAINTS_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_COMPLAINTS_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ComplaintsModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ComplaintsModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Complaints.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, ComplaintsImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, ComplaintsImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(complaints);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Complaints> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the complaintses where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching complaintses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaints> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the complaintses where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of complaintses
	 * @param end the upper bound of the range of complaintses (not inclusive)
	 * @return the range of matching complaintses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaints> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the complaintses where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of complaintses
	 * @param end the upper bound of the range of complaintses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching complaintses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaints> findByCompanyId(long companyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<Complaints> list = (List<Complaints>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Complaints complaints : list) {
				if ((companyId != complaints.getCompanyId())) {
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

			query.append(_SQL_SELECT_COMPLAINTS_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ComplaintsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<Complaints>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first complaints in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching complaints
	 * @throws com.bkav.portal.portlet.complaints.NoSuchComplaintsException if a matching complaints could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaints findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchComplaintsException, SystemException {
		Complaints complaints = fetchByCompanyId_First(companyId,
				orderByComparator);

		if (complaints != null) {
			return complaints;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchComplaintsException(msg.toString());
	}

	/**
	 * Returns the first complaints in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching complaints, or <code>null</code> if a matching complaints could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaints fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Complaints> list = findByCompanyId(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last complaints in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching complaints
	 * @throws com.bkav.portal.portlet.complaints.NoSuchComplaintsException if a matching complaints could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaints findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchComplaintsException, SystemException {
		Complaints complaints = fetchByCompanyId_Last(companyId,
				orderByComparator);

		if (complaints != null) {
			return complaints;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchComplaintsException(msg.toString());
	}

	/**
	 * Returns the last complaints in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching complaints, or <code>null</code> if a matching complaints could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaints fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		List<Complaints> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the complaintses before and after the current complaints in the ordered set where companyId = &#63;.
	 *
	 * @param complaintId the primary key of the current complaints
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next complaints
	 * @throws com.bkav.portal.portlet.complaints.NoSuchComplaintsException if a complaints with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaints[] findByCompanyId_PrevAndNext(long complaintId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchComplaintsException, SystemException {
		Complaints complaints = findByPrimaryKey(complaintId);

		Session session = null;

		try {
			session = openSession();

			Complaints[] array = new ComplaintsImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, complaints,
					companyId, orderByComparator, true);

			array[1] = complaints;

			array[2] = getByCompanyId_PrevAndNext(session, complaints,
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

	protected Complaints getByCompanyId_PrevAndNext(Session session,
		Complaints complaints, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COMPLAINTS_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

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
			query.append(ComplaintsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(complaints);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Complaints> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the complaintses.
	 *
	 * @return the complaintses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaints> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the complaintses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of complaintses
	 * @param end the upper bound of the range of complaintses (not inclusive)
	 * @return the range of complaintses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaints> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the complaintses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of complaintses
	 * @param end the upper bound of the range of complaintses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of complaintses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaints> findAll(int start, int end,
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

		List<Complaints> list = (List<Complaints>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COMPLAINTS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COMPLAINTS.concat(ComplaintsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Complaints>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Complaints>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the complaintses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (Complaints complaints : findByGroupId(groupId)) {
			remove(complaints);
		}
	}

	/**
	 * Removes all the complaintses where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyId(long companyId) throws SystemException {
		for (Complaints complaints : findByCompanyId(companyId)) {
			remove(complaints);
		}
	}

	/**
	 * Removes all the complaintses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Complaints complaints : findAll()) {
			remove(complaints);
		}
	}

	/**
	 * Returns the number of complaintses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching complaintses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMPLAINTS_WHERE);

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
	 * Returns the number of complaintses that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching complaintses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_COMPLAINTS_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Complaints.class.getName(),
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
	 * Returns the number of complaintses where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching complaintses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyId(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMPLAINTS_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of complaintses.
	 *
	 * @return the number of complaintses
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_COMPLAINTS);

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
	 * Initializes the complaints persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.bkav.portal.portlet.complaints.model.Complaints")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Complaints>> listenersList = new ArrayList<ModelListener<Complaints>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Complaints>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ComplaintsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = ComplaintsPersistence.class)
	protected ComplaintsPersistence complaintsPersistence;
	@BeanReference(type = Complaints_DLFileEntriesPersistence.class)
	protected Complaints_DLFileEntriesPersistence complaints_DLFileEntriesPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_COMPLAINTS = "SELECT complaints FROM Complaints complaints";
	private static final String _SQL_SELECT_COMPLAINTS_WHERE = "SELECT complaints FROM Complaints complaints WHERE ";
	private static final String _SQL_COUNT_COMPLAINTS = "SELECT COUNT(complaints) FROM Complaints complaints";
	private static final String _SQL_COUNT_COMPLAINTS_WHERE = "SELECT COUNT(complaints) FROM Complaints complaints WHERE ";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "complaints.groupId = ?";
	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "complaints.companyId = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "complaints.complaintId";
	private static final String _FILTER_SQL_SELECT_COMPLAINTS_WHERE = "SELECT DISTINCT {complaints.*} FROM Complaints complaints WHERE ";
	private static final String _FILTER_SQL_SELECT_COMPLAINTS_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {Complaints.*} FROM (SELECT DISTINCT complaints.complaintId FROM Complaints complaints WHERE ";
	private static final String _FILTER_SQL_SELECT_COMPLAINTS_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN Complaints ON TEMP_TABLE.complaintId = Complaints.complaintId";
	private static final String _FILTER_SQL_COUNT_COMPLAINTS_WHERE = "SELECT COUNT(DISTINCT complaints.complaintId) AS COUNT_VALUE FROM Complaints complaints WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "complaints";
	private static final String _FILTER_ENTITY_TABLE = "Complaints";
	private static final String _ORDER_BY_ENTITY_ALIAS = "complaints.";
	private static final String _ORDER_BY_ENTITY_TABLE = "Complaints.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Complaints exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Complaints exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ComplaintsPersistenceImpl.class);
	private static Complaints _nullComplaints = new ComplaintsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Complaints> toCacheModel() {
				return _nullComplaintsCacheModel;
			}
		};

	private static CacheModel<Complaints> _nullComplaintsCacheModel = new CacheModel<Complaints>() {
			public Complaints toEntityModel() {
				return _nullComplaints;
			}
		};
}