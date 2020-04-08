<%@include file="/html/init.jsp"%>

<%
	/**
	*	Style 1 config params
	**/
	
	String styleTitle = preferences.getValue("styleTitle", LanguageUtil.get(locale, "title"));
	
	boolean showPublishDate = GetterUtil.getBoolean(preferences.getValue("showPublishDate", null),false);
	
	boolean queryContains = GetterUtil.getBoolean(preferences.getValue("queryContains", null),true);
	
	boolean queryAndOperator = GetterUtil.getBoolean(preferences.getValue("queryAndOperator", null),false);
	
	String queryName = preferences.getValue("queryName","assetTags");
	
	String queryValues = StringUtil.merge(preferences.getValues("queryValues", new String[0]));
	
	String[] queryValuesArray = preferences.getValues("queryValues", new String[0]);
	
	long[] allAssetCategoryIds = new long[0];
	
	String[] allAssetTagNames = new String[0];
	
	if(Validator.equals(queryName,"assetTags")){
		
		queryValues = ParamUtil.getString(request, "selectedTagsNames", queryValues);
		
		allAssetTagNames = new String[queryValuesArray.length];
		
		allAssetTagNames = queryValuesArray;
	}else {
		
		queryValues = ParamUtil.getString(request, "selectedCategoryIds", queryValues);
		
		allAssetCategoryIds = new long[queryValuesArray.length];
		
		for(int i = 0;i < queryValuesArray.length; i++){
			allAssetCategoryIds[i] = Long.parseLong(queryValuesArray[i]);
		}
	}
	
	int numbersOfEntriesDisplay = GetterUtil.getInteger(preferences.getValue("numbersOfEntriesDisplay", "8"));
	
	String orderByColumn = preferences.getValue("orderByColumn","publishDate");
	
	String orderByType = preferences.getValue("orderByType","DESC");
%>















