<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<portlet:defineObjects />
<div class="container">
	<div class="sub-navigation">
		<div class="date_time">
			<span id="portal_egov_date"></span> <span id="portal_egov_clock"></span>
		</div>
		<div class="top_notify">
			<marquee direction="left" scrollamount="1" scrolldelay="40"
				width="460px">
				<span id="sloganContent"></span>
			</marquee>
		</div>
		<div class="global-search-wrapper">
			<form
				action="/trang-chu?p_p_id=3&amp;p_p_lifecycle=0&amp;p_p_state=maximized&amp;p_p_mode=view&amp;p_p_col_id=column-1&amp;_3_struts_action=%2Fsearch%2Fsearch&amp;_3_redirect=%2Fweb%2Fguest"
				method="get" name="dobr_3_fm"
				onsubmit="dobr_3_search(); return false;">
				<input name="p_p_id" type="hidden" value="3"><input
					name="p_p_lifecycle" type="hidden" value="0"><input
					name="p_p_state" type="hidden" value="maximized"><input
					name="p_p_mode" type="hidden" value="view"><input
					name="p_p_col_id" type="hidden" value="column-1"><input
					name="_3_struts_action" type="hidden" value="/search/search"><input
					name="_3_redirect" type="hidden" value="/web/guest"> <input
					name="_3_keywords" size="30" type="text" value=""> <select
					name="_3_groupId">
					<option value="0" selected="">All</option>
					<option value="19">This page</option>
				</select> <input align="absmiddle" border="0"
					src="/portal-dean2395-theme/images/common/search.png"
					title="Search" type="image">

			</form>
		</div>
		<div style="clear: both;"></div>
	</div>
</div>
