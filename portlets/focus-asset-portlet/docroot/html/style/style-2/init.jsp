<%@include file="/html/init.jsp"%>

<%
	/**
	*	Style 2 config params
	**/
	
	String randomNameSpace = PortalUtil.generateRandomKey(request, "focus_assets") + StringPool.UNDERLINE;
	
	/**
	*	1st Tab Query Rules Parameters
	**/
	String firstTabTitle = preferences.getValue("firstTabTitle","tab1");
	
	boolean firstTabQueryContains = GetterUtil.getBoolean(preferences.getValue("firstTabQueryContains", null),true);
	
	boolean firstTabQueryAndOperator = GetterUtil.getBoolean(preferences.getValue("firstTabQueryAndOperator", null),false);
	
	String firstTabQueryName = preferences.getValue("firstTabQueryName","assetTags");
	
	String firstTabQueryValues = StringUtil.merge(preferences.getValues("firstTabQueryValues", new String[0]));
	
	if(Validator.equals(firstTabQueryName,"assetTags")){
		
		firstTabQueryValues = ParamUtil.getString(request, "firstTabSelectedTagsNames", firstTabQueryValues);
		
	}else {
		firstTabQueryValues = ParamUtil.getString(request, "firstTabSelectedCategoryIds", firstTabQueryValues);
	}
	
	int firstTabEntriesDisplay = GetterUtil.getInteger(preferences.getValue("firstTabEntriesDisplay", "6"));
	
	String firstTabOrderByColumn = preferences.getValue("firstTabOrderByColumn","publishDate");
	
	String firstTabOrderByType = preferences.getValue("firstTabOrderByType","DESC");
	
	/**
	*	2nd Tab Query Rules Parameters
	**/
	String secondTabTitle = preferences.getValue("secondTabTitle","tab2");
	
	boolean secondTabQueryContains = GetterUtil.getBoolean(preferences.getValue("secondTabQueryContains", null),true);
	
	boolean secondTabQueryAndOperator = GetterUtil.getBoolean(preferences.getValue("secondTabQueryAndOperator", null),false);
	
	String secondTabQueryName = preferences.getValue("secondTabQueryName","assetTags");
	
	String secondTabQueryValues = StringUtil.merge(preferences.getValues("secondTabQueryValues", new String[0]));
	
	if(Validator.equals(secondTabQueryName,"assetTags")){
		
		secondTabQueryValues = ParamUtil.getString(request, "secondTabSelectedTagsNames", secondTabQueryValues);
		
	}else {
		secondTabQueryValues = ParamUtil.getString(request, "secondTabSelectedCategoryIds", secondTabQueryValues);
	}
	
	int secondTabEntriesDisplay = GetterUtil.getInteger(preferences.getValue("secondTabEntriesDisplay", "6"));
	
	String secondTabOrderByColumn = preferences.getValue("secondTabOrderByColumn","publishDate");
	
	String secondTabOrderByType = preferences.getValue("secondTabOrderByType","DESC");
	
	/**
	*	3rd Tab Query Rules Parameters
	**/
	String thirdTabTitle = preferences.getValue("thirdTabTitle","tab3");
	
	boolean thirdTabQueryContains = GetterUtil.getBoolean(preferences.getValue("thirdTabQueryContains", null),true);
	
	boolean thirdTabQueryAndOperator = GetterUtil.getBoolean(preferences.getValue("thirdTabQueryAndOperator", null),false);
	
	String thirdTabQueryName = preferences.getValue("thirdTabQueryName","assetTags");
	
	String thirdTabQueryValues = StringUtil.merge(preferences.getValues("thirdTabQueryValues", new String[0]));
	
	if(Validator.equals(thirdTabQueryName,"assetTags")){
		
		thirdTabQueryValues = ParamUtil.getString(request, "thirdTabSelectedTagsNames", thirdTabQueryValues);
		
	}else {
		thirdTabQueryValues = ParamUtil.getString(request, "thirdTabSelectedCategoryIds", thirdTabQueryValues);
	}
	
	int thirdTabEntriesDisplay = GetterUtil.getInteger(preferences.getValue("thirdTabEntriesDisplay", "6"));
	
	String thirdTabOrderByColumn = preferences.getValue("thirdTabOrderByColumn","publishDate");
	
	String thirdTabOrderByType = preferences.getValue("thirdTabOrderByType","DESC");
	
%>















