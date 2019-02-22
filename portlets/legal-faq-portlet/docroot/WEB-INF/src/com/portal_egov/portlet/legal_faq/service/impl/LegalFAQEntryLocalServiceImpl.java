package com.portal_egov.portlet.legal_faq.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;
import com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException;
import com.portal_egov.portlet.legal_faq.model.LegalFAQEntry;
import com.portal_egov.portlet.legal_faq.service.base.LegalFAQEntryLocalServiceBaseImpl;
import com.portal_egov.portlet.legal_faq.service.persistence.LegalFAQEntryFinderUtil;
import com.portal_egov.portlet.legal_faq.util.LegalFAQConstants;


public class LegalFAQEntryLocalServiceImpl extends LegalFAQEntryLocalServiceBaseImpl {
	
	public int countAll() throws SystemException{
		return legalFAQEntryPersistence.countAll();
	}
	
	public int countByCompany(long companyId) throws SystemException{
		return legalFAQEntryPersistence.countByCompany(companyId);
	}
	
	public int countByGroup(long groupId) throws SystemException{
		return legalFAQEntryPersistence.countByGroup(groupId);
	}
	
	public int countByCategory(long groupId,long categoryId) throws SystemException{
		return legalFAQEntryPersistence.countByCategory(groupId, categoryId);
	}
	
	public int countByCategory(long groupId,long categoryId,int publishStatus,int status) throws SystemException{
		return legalFAQEntryPersistence.countByCategoryAndStatus(groupId, categoryId, publishStatus, status);
	}
	
	public int countByStatus(long companyId,int status) throws SystemException{
		return legalFAQEntryPersistence.countByStatus(companyId, status);
	}
	
	
	public int countByPublishStatus(long companyId,int publishStatus) throws SystemException{
		return legalFAQEntryPersistence.countByPublishStatus(companyId, publishStatus);
	}
	
	public List<LegalFAQEntry> findByCompany(long companyId) throws SystemException{
		return legalFAQEntryPersistence.findByCompany(companyId);
	}
	
	public List<LegalFAQEntry> findByCompany(long companyId,int start,int end) throws SystemException{
		return legalFAQEntryPersistence.findByCompany(companyId,start,end);
	}
	
	public List<LegalFAQEntry> findByGroup(long groupId) throws SystemException{
		return legalFAQEntryPersistence.findByGroup(groupId);
	}
	
	public List<LegalFAQEntry> findByGroup(long groupId,int start,int end) throws SystemException{
		return legalFAQEntryPersistence.findByGroup(groupId,start,end);
	}
	
	public List<LegalFAQEntry> findByCategory(long companyId,long categoryId) throws SystemException{
		return legalFAQEntryPersistence.findByCategory(companyId, categoryId);
	}
	
	public List<LegalFAQEntry> findByCategory(long groupId,long categoryId,int start,int end) throws SystemException{
		return legalFAQEntryPersistence.findByCategory(groupId, categoryId,start,end);
	}
	
	public List<LegalFAQEntry> findByStatus(long companyId,int status) throws SystemException{
		return legalFAQEntryPersistence.findByStatus(companyId, status);
	}
	
	public List<LegalFAQEntry> findByStatus(long companyId,int status,int start,int end) throws SystemException{
		return legalFAQEntryPersistence.findByStatus(companyId, status,start,end);
	}
	
	public List<LegalFAQEntry> findByPublishStatus(long companyId,int publishStatus) throws SystemException{
		return legalFAQEntryPersistence.findByPublishStatus(companyId, publishStatus);
	}
	
	public List<LegalFAQEntry> findByPublishStatus(long companyId,int publishStatus,int start,int end) throws SystemException{
		return legalFAQEntryPersistence.findByPublishStatus(companyId, publishStatus,start,end);
	}
	
	public List<LegalFAQEntry> findByKeyword(long groupId,long categoryId,String keyword,int start,int end,OrderByComparator obc){
		return LegalFAQEntryFinderUtil.findByKeyword(groupId, categoryId, keyword, start, end, obc);
	}
	
	public List<LegalFAQEntry> findByKeywordAndStatus(long groupId,long categoryId,String keyword,int start,int end){
		return LegalFAQEntryFinderUtil.findByKeywordAndStatus(groupId, categoryId, keyword, start, end);
	}
	
	public List<LegalFAQEntry> findByViewCount(long groupId,long categoryId,int start,int end){
		return LegalFAQEntryFinderUtil.findByViewCount(groupId, categoryId, start, end);
	}

	
	public List<LegalFAQEntry> findByCompanyAndStatus(long groupId,int entryPublishStatus,int entryStatus) throws SystemException{
		return legalFAQEntryPersistence.findByCompanyAndStatus(groupId, entryPublishStatus, entryStatus);
	}
	
	public List<LegalFAQEntry> findByCompanyAndStatus(long companyId,int entryPublishStatus,int entryStatus,int start,int end) throws SystemException{
		return legalFAQEntryPersistence.findByCompanyAndStatus(companyId, entryPublishStatus, entryStatus,start,end);
	}
	
	public List<LegalFAQEntry> findByGroupAndStatus(long groupId,int entryPublishStatus,int entryStatus) throws SystemException{
		return legalFAQEntryPersistence.findByGroupAndStatus(groupId, entryPublishStatus, entryStatus);
	}
	
	public List<LegalFAQEntry> findByGroupAndStatus(long groupId,int entryPublishStatus,int entryStatus,int start,int end) throws SystemException{
		return legalFAQEntryPersistence.findByGroupAndStatus(groupId, entryPublishStatus, entryStatus,start,end);
	}
	
	public List<LegalFAQEntry> findByCategoryAndStatus(long companyId,long categoryId,int entryPublishStatus,int entryStatus) throws SystemException{
		return legalFAQEntryPersistence.findByCategoryAndStatus(companyId, categoryId, entryPublishStatus, entryStatus);
	}
	
	public List<LegalFAQEntry> findByCategoryAndStatus(long companyId,long categoryId,int entryPublishStatus,int entryStatus,int start,int end)
						throws SystemException{
		return legalFAQEntryPersistence.findByCategoryAndStatus(companyId, categoryId, entryPublishStatus, entryStatus,start,end);
	}
	
	public LegalFAQEntry getEntry(long entryId) throws SystemException{
		return legalFAQEntryPersistence.fetchByPrimaryKey(entryId);
	}
	
	public LegalFAQEntry addFAQEntry(long companyId,long groupId,long userId,long categoryId,String citizenName,String citizenPhone,
			String citizenEmail, String citizenAddress,Date askDate,String askTitle,String askContent,Date answerDate,String answerContent,
			int publishStatus,int entryStatus,ServiceContext serviceContext) throws SystemException, PortalException{
		
		Date now = new Date();
		
		String userName = "";
		
		if(userId > 0){
			User user = userLocalService.getUser(userId);
			
			if(user != null){
				userName = user.getFullName();
			}
		}
		long entryId = counterLocalService.increment();
		
		LegalFAQEntry legalFAQEntry = legalFAQEntryPersistence.create(entryId);
		
		legalFAQEntry.setCompanyId(companyId);
		legalFAQEntry.setGroupId(groupId);
		legalFAQEntry.setUserId(userId);
		legalFAQEntry.setUserName(userName);
		legalFAQEntry.setCategoryId(categoryId);
		legalFAQEntry.setCitizenName(citizenName);
		legalFAQEntry.setCitizenPhone(citizenPhone);
		legalFAQEntry.setCitizenEmail(citizenEmail);
		legalFAQEntry.setCitizenAddress(citizenAddress);
		legalFAQEntry.setAskDate(askDate);
		legalFAQEntry.setAskTitle(askTitle);
		legalFAQEntry.setAskContent(askContent);
		legalFAQEntry.setAnswerDate(answerDate);
		legalFAQEntry.setAnswerContent(answerContent);
		legalFAQEntry.setCreateDate(now);
		legalFAQEntry.setModifiedDate(now);
		legalFAQEntry.setViewCount(LegalFAQConstants.LEGAL_FAQ_ENTRY_STARTED_VIEW_COUNT_VALUE);
		legalFAQEntry.setPublishStatus(publishStatus);
		legalFAQEntry.setStatus(entryStatus);
		
		legalFAQEntryPersistence.update(legalFAQEntry, false);
		
		if(serviceContext.isAddGroupPermissions()
			|| serviceContext.isAddGuestPermissions()){
		
			addLegalFAQEntryResources(legalFAQEntry, serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
		}else{
			
			addLegalFAQEntryResources(legalFAQEntry, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		}
		
		//Lucene Indexer
		Indexer indexer = IndexerRegistryUtil.getIndexer(LegalFAQEntry.class);
		
		if(indexer != null){
			indexer.reindex(legalFAQEntry);
		}
		
		return legalFAQEntry;
	}
	
	public LegalFAQEntry updateFAQEntry(long entryId,long companyId,long groupId,long userId,long categoryId,String citizenName,String citizenPhone,
			String citizenEmail,Date askDate,String askTitle,String askContent,
			Date answerDate,String answerContent,int publishStatus,int entryStatus) throws SystemException, PortalException{
		
		Date now = new Date();
		
		String userName = "";
		
		if(userId > 0){
			User user = userLocalService.getUser(userId);
			
			if(user != null){
				userName = user.getFullName();
			}
		}
		LegalFAQEntry legalFAQEntry = legalFAQEntryPersistence.fetchByPrimaryKey(entryId);
		
		legalFAQEntry.setCompanyId(companyId);
		legalFAQEntry.setGroupId(groupId);
		legalFAQEntry.setUserId(userId);
		legalFAQEntry.setUserName(userName);
		legalFAQEntry.setCategoryId(categoryId);
		legalFAQEntry.setCitizenName(citizenName);
		legalFAQEntry.setCitizenPhone(citizenPhone);
		legalFAQEntry.setCitizenEmail(citizenEmail);
		legalFAQEntry.setAskDate(askDate);
		legalFAQEntry.setAskTitle(askTitle);
		legalFAQEntry.setAskContent(askContent);
		legalFAQEntry.setAnswerDate(answerDate);
		legalFAQEntry.setAnswerContent(answerContent);
		legalFAQEntry.setModifiedDate(now);
		
		legalFAQEntry.setStatus(entryStatus);
		
		int oldPublishStatus = legalFAQEntry.getPublishStatus();
		
		if(oldPublishStatus == 0 && publishStatus == 1){
			legalFAQEntry.setPublishDate(now);
		}
		
		legalFAQEntry.setPublishStatus(publishStatus);
		
		legalFAQEntryPersistence.update(legalFAQEntry, false);
		
		//Lucene Indexer
		Indexer indexer = IndexerRegistryUtil.getIndexer(LegalFAQEntry.class);
		
		if(indexer != null){
			indexer.reindex(legalFAQEntry);
		}
		
		return legalFAQEntry;
	}
		
	/**
	 * 
	 * @todo CAP NHAT CAU TRA LOI
	 * @author HungDX	
	 * @date Jul 7, 2012
	 * @return LegalFAQEntry
	 * @param entryId
	 * @param answerContent
	 * @return
	 * @throws SystemException 
	 */
	public void updateAnswerContent(long entryId,Date answerDate,String answerContent,boolean publishEntry) throws SystemException{
		
		LegalFAQEntry legalFAQEntry = legalFAQEntryPersistence.fetchByPrimaryKey(entryId);
		
		if(legalFAQEntry != null){
			Date now = new Date();
			
			legalFAQEntry.setAnswerDate(answerDate);
			//Cap nhat noi dung cau tra loi
			legalFAQEntry.setAnswerContent(answerContent);
			//Cap nhat ngay chinh sua gan nhat
			legalFAQEntry.setModifiedDate(now);
			//Cap nhat trang thai
			legalFAQEntry.setStatus(LegalFAQConstants.LEGAL_FAQ_ENTRY_ANSWERED_STATUS_VALUE);
			
			if(publishEntry){
				
				//Cap nhat trang thai publish cua FAQ entry
				legalFAQEntry.setPublishStatus(LegalFAQConstants.LEGAL_FAQ_ENTRY_PUBLISH_STATUS_VALUE);
			}
			
			legalFAQEntryPersistence.update(legalFAQEntry, false);
		}
	}
	
	/**
	 * 
	 * @todo PUBLISH FAQ ENTRY
	 * @author HungDX	
	 * @date Jul 7, 2012
	 * @return void
	 * @param entryId
	 * @throws SystemException 
	 */
	public void publishFAQEntry(long entryId) throws SystemException{
		
		LegalFAQEntry legalFAQEntry = legalFAQEntryPersistence.fetchByPrimaryKey(entryId);
		
		if(legalFAQEntry != null){
			
			Date now = new Date();

			//Cap nhat ngay chinh sua gan nhat
			legalFAQEntry.setModifiedDate(now);

			legalFAQEntry.setPublishStatus(LegalFAQConstants.LEGAL_FAQ_ENTRY_PUBLISH_STATUS_VALUE);
			
			legalFAQEntryPersistence.update(legalFAQEntry, false);
		}
	}
	
	/**
	 * 
	 * @todo TODO
	 * @author HungDX	
	 * @date Jul 7, 2012
	 * @return void
	 * @param entryId
	 * @throws SystemException
	 */
	public void unPublishFAQEntry(long entryId) throws SystemException{
		
		LegalFAQEntry legalFAQEntry = legalFAQEntryPersistence.fetchByPrimaryKey(entryId);
		
		if(legalFAQEntry != null){
			
			Date now = new Date();

			//Cap nhat ngay chinh sua gan nhat
			legalFAQEntry.setModifiedDate(now);

			legalFAQEntry.setPublishStatus(LegalFAQConstants.LEGAL_FAQ_ENTRY_UNPUBLISH_STATUS_VALUE);
			
			legalFAQEntryPersistence.update(legalFAQEntry, false);
		}
	}
	
	public void deleteFAQEntry(long entryId) throws SystemException, PortalException{
		
		LegalFAQEntry legalFAQEntry = legalFAQEntryPersistence.fetchByPrimaryKey(entryId);
		
		if(legalFAQEntry != null){
			legalFAQEntryPersistence.remove(legalFAQEntry);
			resourceLocalService.deleteResource(legalFAQEntry.getCompanyId(), LegalFAQEntry.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, legalFAQEntry.getEntryId());
			
			//Expando
			ExpandoValueLocalServiceUtil.deleteValues(LegalFAQEntry.class.getName(), entryId);
			
			// Indexer
			Indexer indexer = IndexerRegistryUtil.getIndexer(LegalFAQEntry.class);
			
			if(indexer != null){
				indexer.delete(legalFAQEntry);
			}
		}
	}
	
	public LegalFAQEntry incrementViewCounter(long legalFAQEntryId){
		
		try {
			
			LegalFAQEntry legalFAQEntry = getEntry(legalFAQEntryId);
			
			if(legalFAQEntry != null){
				
				int oldViewCountValue = legalFAQEntry.getViewCount();
				
				legalFAQEntry.setViewCount(oldViewCountValue + 1);
				
				legalFAQEntryPersistence.update(legalFAQEntry, false);
			}
			
			return legalFAQEntry;
		}
		catch (Exception e) {
			if(e instanceof NoSuchLegalFAQEntryException){
				
			}else{
				e.printStackTrace();
			}
			return null;
		}
	}
	
	private void addLegalFAQEntryResources(LegalFAQEntry legalFAQEntry,boolean addGroupPermissions,boolean addGuestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addResources(legalFAQEntry.getCompanyId(), legalFAQEntry.getGroupId(), 
			legalFAQEntry.getUserId(), LegalFAQEntry.class.getName(),
			legalFAQEntry.getEntryId(), false, addGroupPermissions, addGuestPermissions);
	}
		
	private void addLegalFAQEntryResources(LegalFAQEntry legalFAQEntry,String[] groupPermissions,String[] guestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addModelResources(legalFAQEntry.getCompanyId(), legalFAQEntry.getGroupId(),
			legalFAQEntry.getUserId(), LegalFAQEntry.class.getName(),
			legalFAQEntry.getEntryId(), groupPermissions, guestPermissions);
	}
}
