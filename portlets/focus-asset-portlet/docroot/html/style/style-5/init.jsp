<%@include file="/html/init.jsp"%>

<%
	/**
	*	Style 5 config params
	**/
	
	String randomNameSpace = PortalUtil.generateRandomKey(request, "focus_assets") + StringPool.UNDERLINE;
	
	/**
	*	1st Tab Query Rules Parameters
	**/
	String firstTabTitle = preferences.getValue("firstFiveTabTitle","tab1");
	
	boolean firstTabQueryContains = GetterUtil.getBoolean(preferences.getValue("firstFiveTabQueryContains", null),true);
	
	boolean firstTabQueryAndOperator = GetterUtil.getBoolean(preferences.getValue("firstFiveTabQueryAndOperator", null),false);
	
	String firstTabQueryName = preferences.getValue("firstFiveTabQueryName","assetTags");
	
	String firstTabQueryValues = StringUtil.merge(preferences.getValues("firstFiveTabQueryValues", new String[0]));
	
	if(Validator.equals(firstTabQueryName,"assetTags")){
		
		firstTabQueryValues = ParamUtil.getString(request, "firstFiveTabSelectedTagsNames", firstTabQueryValues);
		
	}else {
		firstTabQueryValues = ParamUtil.getString(request, "firstFiveTabSelectedCategoryIds", firstTabQueryValues);
	}
	
	int firstTabEntriesDisplay = GetterUtil.getInteger(preferences.getValue("firstFiveTabEntriesDisplay", "6"));
	
	String firstTabOrderByColumn = preferences.getValue("firstFiveTabOrderByColumn","publishDate");
	
	String firstTabOrderByType = preferences.getValue("firstFiveTabOrderByType","DESC");
	
	/**
	*	2nd Tab Query Rules Parameters
	**/
	String secondTabTitle = preferences.getValue("secondFiveTabTitle","tab2");
	
	boolean secondTabQueryContains = GetterUtil.getBoolean(preferences.getValue("secondFiveTabQueryContains", null),true);
	
	boolean secondTabQueryAndOperator = GetterUtil.getBoolean(preferences.getValue("secondFiveTabQueryAndOperator", null),false);
	
	String secondTabQueryName = preferences.getValue("secondFiveTabQueryName","assetTags");
	
	String secondTabQueryValues = StringUtil.merge(preferences.getValues("secondFiveTabQueryValues", new String[0]));
	
	if(Validator.equals(secondTabQueryName,"assetTags")){
		
		secondTabQueryValues = ParamUtil.getString(request, "secondFiveTabSelectedTagsNames", secondTabQueryValues);
		
	}else {
		secondTabQueryValues = ParamUtil.getString(request, "secondFiveTabSelectedCategoryIds", secondTabQueryValues);
	}
	
	int secondTabEntriesDisplay = GetterUtil.getInteger(preferences.getValue("secondFiveTabEntriesDisplay", "6"));
	
	String secondTabOrderByColumn = preferences.getValue("secondFiveTabOrderByColumn","publishDate");
	
	String secondTabOrderByType = preferences.getValue("secondFiveTabOrderByType","DESC");
%>















