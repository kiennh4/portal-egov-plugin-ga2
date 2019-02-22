
package com.bkav.portal.portlet.license_manager;

import java.io.File;
import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMValidateContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.bkav.portal.portlet.license_manager.util.LicenseConstants;
import com.bkav.portal.portlet.license_manager.util.SimpleKeySelector;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class LicenseManagerPortlet
 */
public class LicenseManagerPortlet extends MVCPortlet {

	public void uploadLicenseFile(ActionRequest actionRequest, ActionResponse actionResponse) {

		try {

			UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);

			File file = uploadPortletRequest.getFile("licenseUploadFile");

			byte[] bytes = FileUtil.getBytes(file);

			if ((bytes == null) || (bytes.length == 0)) {
				SessionErrors.add(actionRequest, UploadException.class.getName());
				return;
			}

			String source = file.toString();

			if (verifyLicenseFileSign(source)) {

				FileUtil.copyFile(source, LicenseConstants.LICENSE_FILE_PATH);

			}

			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");

			if (Validator.isNotNull(redirectURL)) {
				actionResponse.sendRedirect(redirectURL);
			}
		}
		catch (IOException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
	}

	private static boolean verifyLicenseFileSign(String licenseFilePath)
		throws Exception {

		DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
		documentFactory.setNamespaceAware(true);
		documentFactory.setIgnoringComments(true);

		DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

		Document signedDocument = documentBuilder.parse(licenseFilePath);

		NodeList signatureNodeList =
			signedDocument.getElementsByTagNameNS(XMLSignature.XMLNS, LicenseConstants.SIGNATURE_ELEMENT_TAG_NAME);

		if (signatureNodeList.getLength() == 0) {
			throw new Exception("No digital signature found, document is discarded");
		}

		Node signatureNode = signatureNodeList.item(0);

		DOMValidateContext valContext = new DOMValidateContext(new SimpleKeySelector(), signatureNode);

		XMLSignatureFactory xmlSignatureFactory = XMLSignatureFactory.getInstance(LicenseConstants.SIGNATURE_MECHANISM_TYPE);
		XMLSignature signature = xmlSignatureFactory.unmarshalXMLSignature(valContext);

		return signature.validate(valContext);
	}

	private static Log _log = LogFactory.getLog(LicenseManagerPortlet.class);
}
