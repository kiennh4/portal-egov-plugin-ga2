<%--
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
--%>

<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>

<%
String cssPath = ParamUtil.getString(request, "cssPath");
String cssClasses = ParamUtil.getString(request, "cssClasses");
String languageId = ParamUtil.getString(request, "languageId");
%>

CKEDITOR.plugins.addExternal('video', 'plugins/video/', 'plugin.js');


CKEDITOR.editorConfig = function( config )
{
	config.extraPlugins = 'video';
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
	
};

<!-- CKEDITOR.on( 'dialogDefinition', function( ev ) -->
<!-- 	{ -->
<!-- 		// Take the dialog name and its definition from the event data. -->
<!-- 		var dialogName = ev.data.name; -->
<!-- 		var dialogDefinition = ev.data.definition; -->
 
<!-- 		// Check if the definition is from the dialog window you are interested in (the "Link" dialog window). -->
<!-- 		if ( dialogName == 'image' ) -->
<!-- 		{ -->
<!-- 			// Get a reference to the "Link Info" tab. -->
<!-- 			var infoTab = dialogDefinition.getContents( 'info' ); -->
 
<!-- 			// Set the default value for the URL field. -->
<!-- 			var urlField = infoTab.get( 'txtWidth' ); -->
<!-- 			urlField['default'] = '500'; -->
			
<!-- 		} -->
<!-- 	}); -->

if (!CKEDITOR.stylesSet.get('liferayStyles')) {
	CKEDITOR.addStylesSet(
		'liferayStyles',
		[

		// Block Styles

		{name: 'Normal', element: 'p'},
		{name: 'Heading 1', element: 'h1'},
		{name: 'Heading 2', element: 'h2'},
		{name: 'Heading 3', element: 'h3'},
		{name: 'Heading 4', element: 'h4'},

		// Special classes

		{name: 'Preformatted Text', element:'pre'},
		{name: 'Cited Work', element:'cite'},
		{name: 'Computer Code', element:'code'},

		// Custom styles

		{name: 'Info Message', element: 'div', attributes: {'class': 'portlet-msg-info'}},
		{name: 'Alert Message', element: 'div', attributes: {'class': 'portlet-msg-alert'}},
		{name: 'Error Message', element: 'div', attributes: {'class': 'portlet-msg-error'}}
		]
	);
}

CKEDITOR.config.bodyClass = 'html-editor <%= cssClasses %>';

CKEDITOR.config.contentsCss = '<%= HtmlUtil.escape(cssPath) %>/main.css';

CKEDITOR.config.entities = false;

CKEDITOR.config.height = 150;

CKEDITOR.config.language = '<%= HtmlUtil.escape(languageId) %>';

CKEDITOR.config.stylesCombo_stylesSet = 'liferayStyles';

CKEDITOR.config.removeDialogTabs = 'image:advanced;link:advanced';

CKEDITOR.config.toolbar_editInPlace = [
	['Styles'],
	['Bold', 'Italic', 'Underline', 'Strike'],
	['Subscript', 'Superscript', 'SpecialChar'],
	['Undo', 'Redo'],
	['SpellChecker', 'Scayt'],
	['NumberedList', 'BulletedList', '-', 'Outdent', 'Indent'], ['Source', 'RemoveFormat'],
];

CKEDITOR.config.toolbar_email = [
	['FontSize', 'TextColor', 'BGColor', '-', 'Bold', 'Italic', 'Underline', 'Strike'],
	['JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock'],
	['SpellChecker', 'Scayt'],
	'/',
	['Undo', 'Redo', '-', 'Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'SelectAll', 'RemoveFormat'],
	['Source'],
	['Link', 'Unlink'],
	['Image']
];

CKEDITOR.config.toolbar_liferay = [
	['Styles', 'FontSize', '-', 'TextColor', 'BGColor'],
	['Bold', 'Italic', 'Underline', 'Strike'],
	['NumberedList', 'BulletedList'],
	['JustifyLeft', 'JustifyCenter', 'JustifyBlock'],
	['PasteText', 'PasteFromWord'],
	['Link','Image']
];

CKEDITOR.config.toolbar_liferayArticle = [
	['Styles', 'FontSize', '-', 'TextColor', 'BGColor'],
	['Bold', 'Italic', 'Underline', 'Strike'],
	['Subscript', 'Superscript'], ['Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord'],
	'/',
	['SelectAll', 'RemoveFormat'],
	['NumberedList','BulletedList'],
	['JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock'],
	['Source'],
	['Link', 'Unlink', 'Anchor'],
	['Image', 'Flash', 'Table', '-', 'Smiley', 'SpecialChar', 'Video', 'Oembed']
];
