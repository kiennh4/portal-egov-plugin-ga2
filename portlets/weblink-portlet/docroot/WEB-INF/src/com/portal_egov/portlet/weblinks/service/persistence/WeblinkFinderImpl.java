/**
 * @author HUNGDX
 * @time 9:26:56 AM
 * @project contacts-portlet
 */
package com.portal_egov.portlet.weblinks.service.persistence;

import java.util.Collections;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.portal_egov.portlet.weblinks.model.Weblink;
import com.portal_egov.portlet.weblinks.model.impl.WeblinkImpl;

public class WeblinkFinderImpl extends BasePersistenceImpl<Weblink> implements
		WeblinkFinder {

	public List<Weblink> findByKeyword(long groupId, long categoryId,
			String keyword, int start, int end, OrderByComparator obc) {

		if (groupId > 0) {

			Session session = null;

			try {
				session = openSession();

				String sqlStr = CustomSQLUtil.get(FIND_BY_KEYWORD_SQL_STR_ID);

				if (categoryId <= 0L) {
					sqlStr = StringUtil.replace(sqlStr,
							"AND (weblink.weblinkCategoryId = ?)",
							StringPool.BLANK);
				}
				if (keyword == "") {
					sqlStr = StringUtil
							.replace(sqlStr,
									"AND (weblink.weblinkName LIKE ?) OR (weblink.weblinkURL LIKE ?)",
									StringPool.BLANK);
				}
				sqlStr = CustomSQLUtil.replaceOrderBy(sqlStr, obc);

				SQLQuery query = session.createSQLQuery(sqlStr);

				query.addEntity("Weblink", WeblinkImpl.class);

				QueryPos queryPost = QueryPos.getInstance(query);

				queryPost.add(groupId);

				if (categoryId > 0) {
					queryPost.add(categoryId);
				}

				if (keyword != "") {
					queryPost.add("%" + keyword + "%");
					queryPost.add("%" + keyword + "%");
				}

				if (start >= 0 && end >= 0) {

					return (List<Weblink>) QueryUtil.list(query, getDialect(),
							start, end);

				} else {

					return (List<Weblink>) query.list();
				}
			} catch (Exception e) {
				e.printStackTrace();
				return Collections.emptyList();
			} finally {
				closeSession(session);
			}

		} else {

			return Collections.emptyList();
		}
	}

	private static final String FIND_BY_KEYWORD_SQL_STR_ID = "com.portal_egov.portlet.weblinks.service.persistence.WeblinkFinder.findByKeyword";

}
