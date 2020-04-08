package com.bkav.portal.portlet.contentsharing;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bkav.portal.portlet.contentsharing.model.ContentSharing;
import com.bkav.portal.portlet.contentsharing.service.ContentSharingLocalServiceUtil;
import com.bkav.portal.portlet.contentsharing.util.ContentSharingAdminUtil;
import com.bkav.portal.portlet.contentsharing.util.vbpq.VBPQConstants;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Image;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetTag;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portlet.documentlibrary.DuplicateFileException;
import com.liferay.portlet.documentlibrary.DuplicateFolderNameException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalArticleResource;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalArticleResourceLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.portal_egov.portlet.tthc.model.TTHC_Attribute;
import com.portal_egov.portlet.tthc.model.TTHC_Category;
import com.portal_egov.portlet.tthc.model.TTHC_Entry;
import com.portal_egov.portlet.tthc.service.TTHC_AttributeLocalServiceUtil;
import com.portal_egov.portlet.tthc.service.TTHC_CategoryLocalServiceUtil;
import com.portal_egov.portlet.tthc.service.TTHC_EntryLocalServiceUtil;
import com.portal_egov.portlet.vbpq.model.VBPQ_Category;
import com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries;
import com.portal_egov.portlet.vbpq.model.VBPQ_Entry;
import com.portal_egov.portlet.vbpq.service.VBPQ_CategoryLocalServiceUtil;
import com.portal_egov.portlet.vbpq.service.VBPQ_DlFileEntriesLocalServiceUtil;
import com.portal_egov.portlet.vbpq.service.VBPQ_EntryLocalServiceUtil;

/**
 * Portlet implementation class ContentSharingAdmin
 */
public class ContentSharingAdmin extends MVCPortlet {

	public void updateListContentSharingAdmin(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		try {

			String[] listContentSharing = ParamUtil.getParameterValues(
					actionRequest, "contentAllowedCheckbox");

			long companyId = ParamUtil.getLong(actionRequest, "companyId", 0);

			List<ContentSharing> listContentSharingRecord = ContentSharingLocalServiceUtil
					.findAll();

			long groupId = PortalUtil.getScopeGroupId(actionRequest);

			long userId = PortalUtil.getUserId(actionRequest);

			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL");

			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					ContentSharing.class.getName(), actionRequest);

			if ((companyId > 0) && (listContentSharing != null)
					&& (PortalUtil.isOmniadmin(userId))) {
				String contentSharingStr = ContentSharingAdminUtil
						.buildContentSharingString(listContentSharing);

				// Update record Compayny Id = 0, luu cau hinh chung content
				// sharing cho tat ca Sub Portal
				if (ContentSharingLocalServiceUtil.fetchContentSharing(0) != null) {
					ContentSharingLocalServiceUtil.updateContentSharing(0,
							companyId, groupId, userId, contentSharingStr);
				} else {
					ContentSharingLocalServiceUtil.addRootContentSharing(
							companyId, groupId, userId, contentSharingStr,
							serviceContext);
				}

				if (listContentSharingRecord.size() > 0) {
					for (ContentSharing content : listContentSharingRecord) {
						updateContentSharingForExistedCompany(
								content.getContentId(), content.getUserId(),
								content.getCompanyId(), content.getGroupId(),
								listContentSharing);
					}
				}

			}

			SessionMessages.add(actionRequest, "save-success");

			if (Validator.isNotNull(redirectURL)) {
				actionResponse.sendRedirect(redirectURL);
			}

		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, "save-error");
		}
	}

	public void updateListContentSharing(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		try {

			String[] listContentSharing = ParamUtil.getParameterValues(
					actionRequest, "contentAllowedCheckbox");

			long companyId = ParamUtil.getLong(actionRequest, "companyId", 0);

			long groupId = PortalUtil.getScopeGroupId(actionRequest);

			long userId = PortalUtil.getUserId(actionRequest);

			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL");

			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					ContentSharing.class.getName(), actionRequest);

			if ((companyId > 0) && (listContentSharing != null)) {
				String contentSharingStr = ContentSharingAdminUtil
						.buildContentSharingString(listContentSharing);

				if (ContentSharingAdminUtil.checkExistedCompany(companyId,
						groupId) > 0) {
					ContentSharingLocalServiceUtil.updateContentSharing(
							ContentSharingAdminUtil.checkExistedCompany(
									companyId, groupId), companyId, groupId,
							userId, contentSharingStr);
				} else {
					ContentSharingLocalServiceUtil.addContentSharing(companyId,
							groupId, userId, contentSharingStr, serviceContext);
				}
			}

			SessionMessages.add(actionRequest, "save-success");

			if (Validator.isNotNull(redirectURL)) {
				actionResponse.sendRedirect(redirectURL);
			}

		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, "save-error");
		}
	}

	public void updateContentSharingForExistedCompany(long contentId,
			long userId, long companyId, long groupId,
			String[] listContentSharing) {
		try {

			ContentSharing contentSharing = ContentSharingLocalServiceUtil
					.findByCompanyAndGroup(companyId, groupId);

			if (contentSharing != null) {
				String[] listContentSharingSaved = contentSharing
						.getContentSharing().split(StringPool.COMMA);

				StringBuilder sb = new StringBuilder();

				for (int i = 0; i < listContentSharing.length; i++) {
					boolean isExisted = false;

					for (String contentSharingSaved : listContentSharingSaved) {
						if (listContentSharing[i].equals(contentSharingSaved)) {
							isExisted = true;
							break;
						}
					}

					if (isExisted) {
						sb.append(listContentSharing[i]);
						sb.append(StringPool.COMMA);
					}
				}

				String results = sb.toString();

				if (results.endsWith(StringPool.COMMA)) {
					results = results.substring(0, results.length() - 1);
				}

				ContentSharingLocalServiceUtil.updateContentSharing(contentId,
						companyId, groupId, userId, results);

			}

		} catch (Exception e) {
			_log.error(e);
		}
	}

	public void copyRelativeContentArticle(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		try {
			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL");

			long groupId = PortalUtil.getScopeGroupId(actionRequest);

			String categoryIdsStr = ParamUtil.getString(actionRequest,
					"categoryIds");

			String tagIdsStr = ParamUtil.getString(actionRequest, "tagIds");

			String[] categoryIds = categoryIdsStr.split(StringPool.COMMA);

			String[] tagsName = tagIdsStr.split(StringPool.COMMA);

			long userId = PortalUtil.getUserId(actionRequest);

			long classPK = ParamUtil.getLong(actionRequest, "classPK", 0);

			List<AssetVocabulary> listVocalbury = AssetVocabularyLocalServiceUtil
					.getGroupVocabularies(groupId);

			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil
					.forClass(AssetCategory.class);

			dynamicQuery
					.add(PropertyFactoryUtil.forName("groupId").eq(groupId));

			@SuppressWarnings("unchecked")
			List<AssetCategory> listCategory = AssetCategoryLocalServiceUtil
					.dynamicQuery(dynamicQuery);

			long[] duplicateCategoryIds = new long[categoryIds.length];

			String[] duplicateTagsName = new String[tagsName.length];

			for (int i = 0; i < categoryIds.length; i++) {
				if (!categoryIds[i].equals(StringPool.BLANK)) {
					boolean isExistedVocabulary = false;

					long vocabularyId = 0L;

					AssetCategory originCategory = AssetCategoryLocalServiceUtil
							.fetchAssetCategory(Long.parseLong(categoryIds[i]));

					AssetVocabulary originVocabulary = AssetVocabularyLocalServiceUtil
							.fetchAssetVocabulary(originCategory
									.getVocabularyId());

					for (AssetVocabulary vocabulary : listVocalbury) {
						if (StringUtil
								.lowerCase(vocabulary.getName())
								.trim()
								.equals(StringUtil.lowerCase(
										originVocabulary.getName()).trim())) {
							vocabularyId = vocabulary.getVocabularyId();
							isExistedVocabulary = true;
							break;
						}
					}

					if (!isExistedVocabulary) {
						vocabularyId = duplicateVocabulary(originVocabulary,
								actionRequest);
					}

					duplicateCategoryIds[i] = checkAndHandleAssetCategory(
							listCategory, originCategory, vocabularyId,
							actionRequest);
				}
			}

			DynamicQuery dynamicTagsQuery = DynamicQueryFactoryUtil
					.forClass(AssetTag.class);

			dynamicTagsQuery.add(PropertyFactoryUtil.forName("groupId").eq(
					groupId));

			@SuppressWarnings("unchecked")
			List<AssetTag> listTags = AssetTagLocalServiceUtil
					.dynamicQuery(dynamicTagsQuery);

			for (int i = 0; i < tagsName.length; i++) {
				if (!tagsName[i].equals(StringPool.BLANK)) {
					boolean isTagsExisted = false;

					for (AssetTag tag : listTags) {
						if (StringUtil
								.lowerCase(tag.getName())
								.trim()
								.equals(StringUtil.lowerCase(tagsName[i])
										.trim())) {
							isTagsExisted = true;
							break;
						}
					}

					if (!isTagsExisted) {
						ServiceContext serviceContext = ServiceContextFactory
								.getInstance(AssetTag.class.getName(),
										actionRequest);

						AssetTagLocalServiceUtil.addTag(userId, tagsName[i],
								null, serviceContext);
					}
				}

				duplicateTagsName[i] = tagsName[i];

			}

			duplicateJournalArticle(classPK, duplicateCategoryIds,
					duplicateTagsName, actionRequest);

			SessionMessages.add(actionRequest, "copy-success");

			if (Validator.isNotNull(redirectURL)) {
				actionResponse.sendRedirect(redirectURL);
			}
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, "copy-error");

		}

	}

	@SuppressWarnings("deprecation")
	public void duplicateJournalArticle(long classPK, long[] categoryIds,
			String[] tagsIds, ActionRequest actionRequest) {

		try {

			JournalArticleResource articleResource = JournalArticleResourceLocalServiceUtil
					.getArticleResource(classPK);

			JournalArticle journalArticle = JournalArticleLocalServiceUtil
					.getLatestArticle(articleResource.getGroupId(),
							articleResource.getArticleId());

			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					JournalArticle.class.getName(), actionRequest);

			JournalArticle duplicateArticle = null;

			long groupId = PortalUtil.getScopeGroupId(actionRequest);

			long userId = PortalUtil.getUserId(actionRequest);

			serviceContext.setAssetCategoryIds(categoryIds);

			serviceContext.setAssetTagNames(tagsIds);

			if (journalArticle != null) {

				Image image = ImageLocalServiceUtil.fetchImage(journalArticle
						.getSmallImageId());

				File fileCopy = null;

				if (image != null) {
					fileCopy = ContentSharingAdminUtil
							.copySmallImageArticle(image);
				}

				duplicateArticle = JournalArticleLocalServiceUtil
						.addArticle(
								userId,
								groupId,
								journalArticle.getClassNameId(),
								journalArticle.getClassPK(),
								journalArticle.getArticleId(),
								true,
								1.0,
								journalArticle.getTitleMap(),
								journalArticle.getDescriptionMap(),
								journalArticle.getContent(),
								journalArticle.getType(),
								journalArticle.getStructureId(),
								journalArticle.getTemplateId(),
								journalArticle.getLayoutUuid(),
								(journalArticle.getDisplayDate() != null) ? journalArticle
										.getDisplayDate().getMonth() : null,
								(journalArticle.getDisplayDate() != null) ? journalArticle
										.getDisplayDate().getDate() : null,
								(journalArticle.getDisplayDate() != null) ? journalArticle
										.getDisplayDate().getYear() : null,
								(journalArticle.getDisplayDate() != null) ? journalArticle
										.getDisplayDate().getHours() : null,
								(journalArticle.getDisplayDate() != null) ? journalArticle
										.getDisplayDate().getMinutes() : null,
								(Validator.isNotNull(journalArticle
										.getExpirationDate())) ? journalArticle
										.getExpirationDate().getMonth() : 0,
								(Validator.isNotNull(journalArticle
										.getExpirationDate())) ? journalArticle
										.getExpirationDate().getDate() : 0,
								(Validator.isNotNull(journalArticle
										.getExpirationDate())) ? journalArticle
										.getExpirationDate().getYear() : 0,
								(Validator.isNotNull(journalArticle
										.getExpirationDate())) ? journalArticle
										.getExpirationDate().getHours() : 0,
								(Validator.isNotNull(journalArticle
										.getExpirationDate())) ? journalArticle
										.getExpirationDate().getMinutes() : 0,
								(Validator.isNotNull(journalArticle
										.getExpirationDate())) ? false : true,
								(journalArticle.getReviewDate() != null) ? journalArticle
										.getReviewDate().getMonth() : 0,
								(journalArticle.getReviewDate() != null) ? journalArticle
										.getReviewDate().getDate() : 0,
								(journalArticle.getReviewDate() != null) ? journalArticle
										.getReviewDate().getYear() : 0,
								(journalArticle.getReviewDate() != null) ? journalArticle
										.getReviewDate().getHours() : 0,
								(journalArticle.getReviewDate() != null) ? journalArticle
										.getReviewDate().getMinutes() : 0,
								(Validator.isNotNull(journalArticle
										.getReviewDate())) ? false : true,
								journalArticle.getIndexable(), journalArticle
										.getSmallImage(), journalArticle
										.getSmallImageURL(), fileCopy, null,
								StringPool.BLANK, serviceContext);

				if ((Validator.isNotNull(duplicateArticle))
						&& (fileCopy != null)) {
					fileCopy.delete();
				}

			}
		} catch (Exception e) {
			_log.error(e);
		}
	}

	public long checkAndHandleAssetCategory(List<AssetCategory> listCategory,
			AssetCategory originCategory, long vocabularyId,
			ActionRequest actionRequest) throws SystemException,
			PortalException {
		try {
			if (listCategory != null) {

				boolean isExisted = false;

				long existedCategory = 0L;

				for (AssetCategory category : listCategory) {
					if (StringUtil
							.lowerCase(category.getName())
							.trim()
							.equals(StringUtil.lowerCase(
									originCategory.getName()).trim())) {
						isExisted = true;
						existedCategory = category.getCategoryId();
						break;
					}
				}

				if (!isExisted) {
					return duplicateAssetCategory(listCategory, originCategory,
							vocabularyId, actionRequest);
				} else {
					return existedCategory;
				}
			} else {
				return duplicateAssetCategory(null, originCategory,
						vocabularyId, actionRequest);
			}
		} catch (Exception e) {
			_log.error(e);
			return 0;
		}
	}

	public long duplicateAssetCategory(List<AssetCategory> listCategory,
			AssetCategory originCategory, long vocabularyId,
			ActionRequest actionRequest) throws SystemException,
			PortalException {
		try {

			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					AssetVocabulary.class.getName(), actionRequest);

			long userId = PortalUtil.getUserId(actionRequest);

			long duplicateAssetCategoryId = 0L;

			AssetCategory parentOriginCategory = null;

			boolean parentCategoryExisted = false;

			long parentCategoryId = 0L;

			if ((Validator.isNotNull(originCategory.getParentCategoryId()))
					&& (originCategory.getParentCategoryId() > 0)) {
				parentOriginCategory = AssetCategoryLocalServiceUtil
						.fetchAssetCategory(originCategory
								.getParentCategoryId());
			}

			if (listCategory != null) {
				if (Validator.isNotNull(parentOriginCategory)) {
					for (AssetCategory assetCategory : listCategory) {
						if (StringUtil
								.lowerCase(assetCategory.getName())
								.trim()
								.equals(StringUtil.lowerCase(
										parentOriginCategory.getName()).trim())) {
							parentCategoryExisted = true;
							parentCategoryId = assetCategory.getCategoryId();
							break;
						}
					}

					if (!parentCategoryExisted) {
						parentCategoryId = duplicateAssetCategory(listCategory,
								parentOriginCategory, vocabularyId,
								actionRequest);
					}
				}

				AssetCategory duplicateAssetCategory = AssetCategoryLocalServiceUtil
						.addCategory(userId, parentCategoryId,
								originCategory.getTitleMap(),
								originCategory.getDescriptionMap(),
								vocabularyId, new String[] {}, serviceContext);

				if (Validator.isNotNull(duplicateAssetCategory)) {
					duplicateAssetCategoryId = duplicateAssetCategory
							.getCategoryId();
				}

				return duplicateAssetCategoryId;
			} else {
				if (Validator.isNotNull(parentOriginCategory)) {
					parentCategoryId = duplicateAssetCategory(listCategory,
							parentOriginCategory, vocabularyId, actionRequest);
				}

				AssetCategory duplicateAssetCategory = AssetCategoryLocalServiceUtil
						.addCategory(userId, parentCategoryId,
								originCategory.getTitleMap(),
								originCategory.getDescriptionMap(),
								vocabularyId, new String[] {}, serviceContext);

				if (Validator.isNotNull(duplicateAssetCategory)) {
					duplicateAssetCategoryId = duplicateAssetCategory
							.getCategoryId();
				}

				return duplicateAssetCategoryId;

			}
		} catch (Exception e) {
			_log.error(e);
			return 0;
		}
	}

	@SuppressWarnings("deprecation")
	public long duplicateVocabulary(AssetVocabulary originVocabulary,
			ActionRequest actionRequest) {
		try {

			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					AssetVocabulary.class.getName(), actionRequest);

			long userId = PortalUtil.getUserId(actionRequest);

			if (originVocabulary != null) {
				AssetVocabulary copyVocabulary = AssetVocabularyLocalServiceUtil
						.addVocabulary(userId, originVocabulary.getTitleMap(),
								originVocabulary.getDescriptionMap(),
								originVocabulary.getSettings(), serviceContext);

				if (copyVocabulary != null) {
					return copyVocabulary.getVocabularyId();
				} else {
					return 0;
				}

			} else {
				return 0;
			}

		} catch (Exception e) {
			_log.error(e);
			return 0;
		}

	}

	public void copyVbpq(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		try {
			Calendar calendar = CalendarFactoryUtil.getCalendar();

			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					VBPQ_Entry.class.getName(), actionRequest);

			long groupId = PortalUtil.getScopeGroupId(actionRequest);

			long userId = PortalUtil.getUserId(actionRequest);

			long companyId = PortalUtil.getCompanyId(actionRequest);

			long originVbpqEntryId = ParamUtil.getLong(actionRequest,
					"originVbpqEntryId");

			VBPQ_Entry originVbpq = VBPQ_EntryLocalServiceUtil
					.getVBPQ_Entry(originVbpqEntryId);

			List<VBPQ_DlFileEntries> listOriginDlFileEntries = VBPQ_DlFileEntriesLocalServiceUtil
					.findByVBPQEntry(originVbpqEntryId);

			long folderId = ParamUtil.getLong(actionRequest, "folderId");

			long departmentId = 0L;

			long categoryId = 0L;

			long docTypeId = 0L;

			if ((Validator.isNotNull(originVbpq.getCategoryId()))
					&& (originVbpq.getCategoryId() > 0L)) {
				categoryId = checkAndHandleVbpqCategory(actionRequest,
						originVbpq, VBPQConstants.CATEGORY_ID);
			}

			if ((Validator.isNotNull(originVbpq.getDepartmentId()))
					&& (originVbpq.getDepartmentId() > 0L)) {
				departmentId = checkAndHandleVbpqCategory(actionRequest,
						originVbpq, VBPQConstants.DEPARTMENT_ID);
			}

			if ((Validator.isNotNull(originVbpq.getDocTypeId()))
					&& (originVbpq.getDocTypeId() > 0L)) {
				docTypeId = checkAndHandleVbpqCategory(actionRequest,
						originVbpq, VBPQConstants.DOCUMENT_TYPE_ID);
			}

			VBPQ_Entry copyEntry = VBPQ_EntryLocalServiceUtil.addVBPQEntry(
					companyId,
					groupId,
					userId,
					departmentId,
					categoryId,
					docTypeId,
					originVbpq.getEntryName(),
					originVbpq.getEntryCode(),
					originVbpq.getEntryDesc(),
					originVbpq.getPublicatorName(),
					(originVbpq.getPublishDate() != null) ? originVbpq
							.getPublishDate() : calendar.getTime(),
					(originVbpq.getExecuteDate() != null) ? originVbpq
							.getExecuteDate() : calendar.getTime(),
					(originVbpq.getExpirationDate() != null) ? originVbpq
							.getExpirationDate() : calendar.getTime(),
					originVbpq.getNeverExpired(), serviceContext);

			if ((listOriginDlFileEntries != null)
					&& (listOriginDlFileEntries.size() > 0)) {
				duplicateDlFileEntries(actionRequest, listOriginDlFileEntries,
						copyEntry.getEntryId(), folderId);
			}

			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL", StringPool.BLANK);

			actionResponse.sendRedirect(redirectURL);
		} catch (Exception e) {
			_log.error(e);
		}
	}

	public void duplicateDlFileEntries(ActionRequest actionRequest,
			List<VBPQ_DlFileEntries> listOriginDlFileEntries, long entryId,
			long folderId) throws SystemException, PortalException, IOException {
		try {

			long repositoryId = PortalUtil.getScopeGroupId(actionRequest);

			SimpleDateFormat df = new SimpleDateFormat("ddMMYYYY");

			Date now = new Date();

			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					DLFileEntry.class.getName(), actionRequest);
			// Add quyen xem,download file cho Guest
			serviceContext
					.setGuestPermissions(new String[] { ActionKeys.VIEW });

			if (listOriginDlFileEntries != null) {
				for (VBPQ_DlFileEntries dlfile : listOriginDlFileEntries) {
					FileEntry fileEntry = DLAppServiceUtil.getFileEntry(dlfile
							.getFileEntryId());

					try {
						InputStream inputStream = fileEntry.getContentStream();

						FileEntry fileAttachment = DLAppServiceUtil
								.addFileEntry(
										repositoryId,
										folderId,
										df.format(now) + "_"
												+ fileEntry.getTitle(),
										fileEntry.getMimeType(),
										fileEntry.getTitle(), df.format(now)
												+ "_" + fileEntry.getTitle(),
										"content sharing", inputStream,
										fileEntry.getSize(), serviceContext);

						long vbpqDLfileEntryId = CounterLocalServiceUtil
								.increment();

						VBPQ_DlFileEntries vbpqDLfileEntry = VBPQ_DlFileEntriesLocalServiceUtil
								.createVBPQ_DlFileEntries(vbpqDLfileEntryId);

						if (fileAttachment != null)
							vbpqDLfileEntry.setFileEntryId(fileAttachment
									.getFileEntryId());

						vbpqDLfileEntry.setVbpqEntryId(entryId);

						VBPQ_DlFileEntriesLocalServiceUtil
								.updateVBPQ_DlFileEntries(vbpqDLfileEntry,
										false);
					} catch (DuplicateFileException e) {
						FileEntry fileAttachment = DLAppServiceUtil
								.getFileEntry(repositoryId, folderId,
										fileEntry.getTitle());

						long vbpqDLfileEntryId = CounterLocalServiceUtil
								.increment();

						VBPQ_DlFileEntries vbpqDLfileEntry = VBPQ_DlFileEntriesLocalServiceUtil
								.createVBPQ_DlFileEntries(vbpqDLfileEntryId);

						if (fileAttachment != null)
							vbpqDLfileEntry.setFileEntryId(fileAttachment
									.getFileEntryId());

						vbpqDLfileEntry.setVbpqEntryId(entryId);

						VBPQ_DlFileEntriesLocalServiceUtil
								.updateVBPQ_DlFileEntries(vbpqDLfileEntry,
										false);
					}
				}
			}

		} catch (DuplicateFileException e) {
			_log.error(e);
		} catch (Exception e) {
			_log.error(e);
		}
	}

	public long checkAndHandleVbpqCategory(ActionRequest actionRequest,
			VBPQ_Entry originVbpq, int categoryType) {
		long categoryId = 0L;

		try {
			long groupId = PortalUtil.getScopeGroupId(actionRequest);

			List<VBPQ_Category> listCategory = VBPQ_CategoryLocalServiceUtil
					.findByGroup(groupId);

			boolean categoryExisted = false;

			if (originVbpq != null) {

				long originCategoryId = 0;

				switch (categoryType) {
				case 1: {
					originCategoryId = originVbpq.getDepartmentId();

					break;
				}
				case 2: {
					originCategoryId = originVbpq.getCategoryId();

					break;
				}
				case 3: {
					originCategoryId = originVbpq.getDocTypeId();

					break;
				}
				}

				VBPQ_Category originCategory = VBPQ_CategoryLocalServiceUtil
						.getCategory(originCategoryId);

				if (listCategory != null) {

					for (VBPQ_Category category : listCategory) {
						if (StringUtil
								.lowerCase(category.getCategoryName())
								.trim()
								.equals(StringUtil.lowerCase(
										originCategory.getCategoryName())
										.trim())) {
							categoryExisted = true;
							categoryId = category.getCategoryId();
							break;
						}
					}

					if (!categoryExisted) {
						categoryId = duplicateVbpqCategory(originCategory,
								actionRequest);
					}
				} else {
					categoryId = duplicateVbpqCategory(originCategory,
							actionRequest);
				}
			}

			return categoryId;

		} catch (Exception e) {
			_log.error(e);
			return categoryId;
		}
	}

	public long duplicateVbpqCategory(VBPQ_Category originCategory,
			ActionRequest actionRequest) {
		long categoryId = 0;

		try {
			long groupId = PortalUtil.getScopeGroupId(actionRequest);

			long companyId = PortalUtil.getCompanyId(actionRequest);

			long userId = PortalUtil.getUserId(actionRequest);

			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					VBPQ_Category.class.getName(), actionRequest);

			VBPQ_Category category = VBPQ_CategoryLocalServiceUtil.addCategory(
					companyId, groupId, userId, 0, originCategory.getTypeId(),
					originCategory.getCategoryName(),
					originCategory.getCategoryDesc(),
					originCategory.getDisplayPriority(), serviceContext);

			return category.getCategoryId();

		} catch (Exception e) {
			_log.error(e);
			return categoryId;
		}

	}

	public void copyTTHC(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		try {
			long originTTHCEntryId = ParamUtil.getLong(actionRequest,
					"originTTHCId");

			TTHC_Entry originEntry = TTHC_EntryLocalServiceUtil
					.getTTHC_Entry(originTTHCEntryId);

			checkAndHandleTTHCEntry(actionRequest, originEntry);

		} catch (Exception e) {

		}
	}

	public void checkAndHandleTTHCEntry(ActionRequest actionRequest,
			TTHC_Entry originEntry) {
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					TTHC_Entry.class.getName(), actionRequest);

			long groupId = PortalUtil.getScopeGroupId(actionRequest);

			long companyId = PortalUtil.getCompanyId(actionRequest);

			long userId = PortalUtil.getUserId(actionRequest);

			long levelId = 0;

			long departmentId = 0;

			long categoryId = 0;

			long audienceId = 0;

			long resultTypeId = 0;

			if ((Validator.isNotNull(originEntry.getLevelId()))
					&& (originEntry.getLevelId() > 0)) {
				TTHC_Category originCategory = TTHC_CategoryLocalServiceUtil
						.getTTHC_Category(originEntry.getLevelId());

				if (Validator.isNotNull(originCategory)) {
					levelId = duplicateTTHCCategory(originCategory,
							actionRequest, TTHC_LEVEL_CATEGORY_TYPE_ID);
				}
			}

			if ((Validator.isNotNull(originEntry.getDepartmentId()))
					&& (originEntry.getDepartmentId() > 0)) {
				TTHC_Category originCategory = TTHC_CategoryLocalServiceUtil
						.getTTHC_Category(originEntry.getDepartmentId());

				if (Validator.isNotNull(originCategory)) {
					departmentId = duplicateTTHCCategory(originCategory,
							actionRequest, TTHC_DEPARTMENT_CATEGORY_TYPE_ID);
				}
			}

			if ((Validator.isNotNull(originEntry.getCategoryId()))
					&& (originEntry.getCategoryId() > 0)) {
				TTHC_Category originCategory = TTHC_CategoryLocalServiceUtil
						.getTTHC_Category(originEntry.getCategoryId());

				if (Validator.isNotNull(originCategory)) {
					categoryId = duplicateTTHCCategory(originCategory,
							actionRequest, TTHC_CATEGORY_CATEGORY_TYPE_ID);
				}
			}

			if ((Validator.isNotNull(originEntry.getAudienceId()))
					&& (originEntry.getAudienceId() > 0)) {
				TTHC_Category originCategory = TTHC_CategoryLocalServiceUtil
						.getTTHC_Category(originEntry.getAudienceId());

				if (Validator.isNotNull(originCategory)) {
					audienceId = duplicateTTHCCategory(originCategory,
							actionRequest, TTHC_AUDIENCE_CATEGORY_TYPE_ID);
				}
			}

			if ((Validator.isNotNull(originEntry.getResultTypeId()))
					&& (originEntry.getResultTypeId() > 0)) {
				TTHC_Category originCategory = TTHC_CategoryLocalServiceUtil
						.getTTHC_Category(originEntry.getResultTypeId());

				if (Validator.isNotNull(originCategory)) {
					resultTypeId = duplicateTTHCCategory(originCategory,
							actionRequest, TTHC_RESULT_TYPE_CATEGORY_TYPE_ID);
				}
			}

			List<TTHC_Attribute> listOriginAttribute = TTHC_AttributeLocalServiceUtil
					.findByTTHCEntryAndCompany(companyId,
							originEntry.getEntryId());

			TTHC_Entry copyTTHCEntry = TTHC_EntryLocalServiceUtil.addTTHCEntry(
					companyId, groupId, userId, levelId, departmentId,
					categoryId, audienceId, resultTypeId,
					originEntry.getEntryCode(), originEntry.getEntryName(),
					originEntry.getEntryDesc(), originEntry.getProcessType(),
					originEntry.getProcessGuide(),
					originEntry.getProcessTime(), originEntry.getProcessFee(),
					originEntry.getProcessRequirement(),
					originEntry.getProcessFoundationDocument(), serviceContext);

			if (Validator.isNotNull(listOriginAttribute)) {
				if (Validator.isNotNull(copyTTHCEntry)) {
					for (TTHC_Attribute attribute : listOriginAttribute) {
						duplicateAttribue(attribute, actionRequest,
								copyTTHCEntry.getEntryId());
					}
				}
			}

		} catch (Exception e) {
			_log.error(e);
		}
	}

	public void duplicateAttribue(TTHC_Attribute originAttribute,
			ActionRequest actionRequest, long copyEntryId) {
		try {
			int typeAttribue = originAttribute.getAttributeTypeId();

			long groupId = PortalUtil.getScopeGroupId(actionRequest);

			long companyId = PortalUtil.getCompanyId(actionRequest);

			long userId = PortalUtil.getUserId(actionRequest);

			long attributeValue = 0L;

			long folderId = ParamUtil.getLong(actionRequest, "folderId");

			switch (typeAttribue) {
			case VBPQ_ID_ATTRIBUTE_TYPE_ID: {
				long originVbpqId = Long.parseLong(originAttribute
						.getAttributeValue());

				if ((Validator.isNotNull(originVbpqId)) && (originVbpqId > 0)) {
					VBPQ_Entry originVbpq = VBPQ_EntryLocalServiceUtil
							.fetchVBPQ_Entry(originVbpqId);

					if (Validator.isNotNull(originVbpq)) {
						List<VBPQ_Entry> listVbpq = VBPQ_EntryLocalServiceUtil
								.findByCompany(companyId);

						for (VBPQ_Entry entry : listVbpq) {
							if (StringUtil
									.lowerCase(entry.getEntryName())
									.trim()
									.equals(StringUtil.lowerCase(
											originVbpq.getEntryName()).trim())) {
								attributeValue = entry.getEntryId();
							}
						}

						if (attributeValue <= 0L) {

						}

					}
				}

				break;
			}
			case REQUIRED_DOC_ATTRIBUTE_TYPE_ID: {

			}
			case FILE_ATTACHMENT_ATTRIBUTE_TYPE_ID: {
				long fileAttachmentId = Long.parseLong(originAttribute
						.getAttributeValue());

				SimpleDateFormat df = new SimpleDateFormat("ddMMYYYY");

				ServiceContext serviceContext = ServiceContextFactory
						.getInstance(DLFileEntry.class.getName(), actionRequest);

				Date now = new Date();

				DLFileEntry fileEntry = DLFileEntryLocalServiceUtil
						.fetchDLFileEntry(fileAttachmentId);

				InputStream inputStream = fileEntry.getContentStream();

				FileEntry fileAttachment = DLAppServiceUtil.addFileEntry(
						groupId, folderId,
						df.format(now) + "_" + fileEntry.getTitle(),
						fileEntry.getMimeType(), fileEntry.getTitle(),
						df.format(now) + "_" + fileEntry.getTitle(),
						"content sharing", inputStream, fileEntry.getSize(),
						serviceContext);

				attributeValue = fileAttachment.getFileEntryId();

				break;
			}
			}

			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					TTHC_Attribute.class.getName(), actionRequest);

			if (attributeValue > 0L) {
				TTHC_AttributeLocalServiceUtil.addTTHCAttribute(companyId,
						groupId, userId, copyEntryId,
						originAttribute.getAttributeTypeId(),
						originAttribute.getAttributeIndex(),
						originAttribute.getAttributeName(),
						StringUtil.valueOf(attributeValue), serviceContext);
			}

		} catch (Exception e) {

		}
	}

	public long duplicateTTHCCategory(TTHC_Category originCategory,
			ActionRequest actionRequest, int typeId) {
		long copyCategoryId = 0L;
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					TTHC_Category.class.getName(), actionRequest);

			long groupId = PortalUtil.getScopeGroupId(actionRequest);

			long companyId = PortalUtil.getCompanyId(actionRequest);

			long userId = PortalUtil.getUserId(actionRequest);

			long parentId = 0L;

			List<TTHC_Category> listCategory = TTHC_CategoryLocalServiceUtil
					.findByTypeAndCompany(typeId, companyId);

			if ((Validator.isNotNull(originCategory.getParentId()))
					&& (originCategory.getParentId() > 0)) {

				TTHC_Category originParentCategory = TTHC_CategoryLocalServiceUtil
						.getTTHC_Category(originCategory.getParentId());

				boolean isExisted = false;

				for (TTHC_Category category : listCategory) {
					if (StringUtil
							.lowerCase(category.getCategoryName())
							.trim()
							.equals(StringUtil.lowerCase(
									originParentCategory.getCategoryName())
									.trim())) {
						parentId = category.getCategoryId();
						isExisted = true;
						break;
					}
				}

				if (!isExisted) {
					parentId = duplicateTTHCCategory(originParentCategory,
							actionRequest, typeId);
				}
			}

			boolean isExistedCategory = false;

			for (TTHC_Category category : listCategory) {
				if (StringUtil
						.lowerCase(category.getCategoryName())
						.trim()
						.equals(StringUtil.lowerCase(
								originCategory.getCategoryName()).trim())) {
					copyCategoryId = category.getCategoryId();
					isExistedCategory = true;
					break;
				}
			}

			if (!isExistedCategory) {
				TTHC_Category copyCategory = TTHC_CategoryLocalServiceUtil
						.addTTHCCategory(companyId, groupId, userId, parentId,
								typeId, originCategory.getCategoryName(),
								originCategory.getCategoryDesc(),
								originCategory.getDisplayPriority(),
								serviceContext);

				if (Validator.isNotNull(copyCategory)) {
					copyCategoryId = copyCategory.getCategoryId();
				}

			}

			return copyCategoryId;
		} catch (Exception e) {
			_log.error(e);
			return copyCategoryId;
		}
	}

	public void addNewFolder(ActionRequest actionRequest,
			ActionResponse actionResponse) {

		try {

			long groupId = PortalUtil.getScopeGroupId(actionRequest);

			long userId = PortalUtil.getUserId(actionRequest);

			long parentFolderId = ParamUtil.getLong(actionRequest,
					"parentFolderId");

			String folderName = ParamUtil
					.getString(actionRequest, "folderName");

			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					DLFolder.class.getName(), actionRequest);

			serviceContext
					.setGroupPermissions(new String[] { ActionKeys.VIEW });
			serviceContext
					.setGuestPermissions(new String[] { ActionKeys.VIEW });

			DLFolderLocalServiceUtil.addFolder(userId, groupId, groupId, false,
					parentFolderId, folderName, StringPool.BLANK,
					serviceContext);

			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL");

			if (Validator.isNotNull(redirectURL)) {

				actionResponse.sendRedirect(redirectURL);
			}

		} catch (Exception e) {
			if (e instanceof DuplicateFolderNameException) {
				SessionErrors.add(actionRequest, e.getClass().getName());
			} else {
				_log.error(e);
			}
		}
	}

	private static Log _log = LogFactory.getLog(ContentSharingAdmin.class);

	// categoryType tuong ung voi Cap thuc hien TTHC
	public static final int TTHC_LEVEL_CATEGORY_TYPE_ID = 1;

	// categoryType tuong ung voi Cap thuc hien TTHC
	public static final int TTHC_DEPARTMENT_CATEGORY_TYPE_ID = 2;

	// categoryType tuong ung voi Cap thuc hien TTHC
	public static final int TTHC_CATEGORY_CATEGORY_TYPE_ID = 3;

	// categoryType tuong ung voi Cap thuc hien TTHC
	public static final int TTHC_AUDIENCE_CATEGORY_TYPE_ID = 4;

	// categoryType tuong ung voi Cap thuc hien TTHC
	public static final int TTHC_RESULT_TYPE_CATEGORY_TYPE_ID = 5;

	public static final int DEFAULT_CATEGORY_ID = 0;

	public static final int VBPQ_ID_ATTRIBUTE_TYPE_ID = 1;

	// attributeTypeId tuong ung voi Thanh phan ho so
	public static final int REQUIRED_DOC_ATTRIBUTE_TYPE_ID = 2;

	// attributeTypeId tuong ung voi Tai lieu,bieu mau dinh kem TTHC
	public static final int FILE_ATTACHMENT_ATTRIBUTE_TYPE_ID = 3;

	public static final int DEFAULT_ATTRIBUTE_TYPE_ID = 0;

	// Attribute name cua Van ban phap quy quy dinh thu tuc
	public static final String VBPQ_MAPPING_ID_ATTRIBUTE_NAME = "VBPQ_MAPPING_ID";

	// Attribute name cua Thanh phan ho so
	public static final String REQUIRED_DOCUMENT_ATTRIBUTE_NAME = "REQUIRED_DOCUMENT";

	// Attribute name cua Van ban dinh kem thu tuc
	public static final String FILE_ATTACHMENT_ATTRIBUTE_NAME = "FILE_ATTACHMENT";
}
