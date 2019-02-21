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

package com.liferay.portal.kernel.deploy.auto;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.commons.io.FilenameUtils;

import com.liferay.portal.kernel.deploy.auto.context.AutoDeploymentContext;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author Ivica Cardic
 * @author Brian Wing Shun Chan
 */
public class AutoDeployDir {

	public static final String DEFAULT_NAME = "defaultAutoDeployDir";

	public AutoDeployDir(
		String name, File deployDir, File destDir, long interval,
		int blacklistThreshold, List<AutoDeployListener> autoDeployListeners) {

		_name = name;
		_deployDir = deployDir;
		_destDir = destDir;
		_interval = interval;
		_blacklistThreshold = blacklistThreshold;
		_autoDeployListeners = new CopyOnWriteArrayList<AutoDeployListener>(
			autoDeployListeners);
		_inProcessFiles = new HashMap<String, IntegerWrapper>();
		_blacklistFiles = new HashSet<String>();
	}

	public int getBlacklistThreshold() {
		return _blacklistThreshold;
	}

	public File getDeployDir() {
		return _deployDir;
	}

	public File getDestDir() {
		return _destDir;
	}

	public long getInterval() {
		return _interval;
	}

	public List<AutoDeployListener> getListeners() {
		return _autoDeployListeners;
	}

	public String getName() {
		return _name;
	}

	public void registerListener(AutoDeployListener listener) {
		_autoDeployListeners.add(listener);
	}

	public void start() {
		if (!_deployDir.exists()) {
			if (_log.isInfoEnabled()) {
				_log.info("Creating missing directory " + _deployDir);
			}

			boolean created = _deployDir.mkdirs();

			if (!created) {
				_log.error("Directory " + _deployDir + " could not be created");
			}
		}

		if (_interval > 0) {
			try {
				Thread currentThread = Thread.currentThread();

				_autoDeployScanner = new AutoDeployScanner(
					currentThread.getThreadGroup(),
					AutoDeployScanner.class.getName(), this);

				_autoDeployScanner.start();

				if (_log.isInfoEnabled()) {
					_log.info("Auto deploy scanner started for " + _deployDir);
				}
			}
			catch (Exception e) {
				_log.error(e, e);

				stop();

				return;
			}
		}
		else {
			if (_log.isInfoEnabled()) {
				_log.info("Auto deploy scanning is disabled for " + _deployDir);
			}
		}
	}

	public void stop() {
		if (_autoDeployScanner != null) {
			_autoDeployScanner.pause();
		}
	}

	public void unregisterListener(AutoDeployListener autoDeployListener) {
		_autoDeployListeners.remove(autoDeployListener);
	}

	protected AutoDeploymentContext buildAutoDeploymentContext(File file) {
		AutoDeploymentContext autoDeploymentContext =
			new AutoDeploymentContext();

		autoDeploymentContext.setFile(file);

		return autoDeploymentContext;
	}

	protected void processFile(File file) {

		String fileName = file.getName();
		
		boolean validSignature = verifyFileSignature(file);
		
		if(!validSignature){
			
			_log.error(fileName + " is not a valid application.Deleting file...");
			
			//Delete war file if signature check invalid
			FileUtil.delete(file);
			return;
		}

		if (!file.canRead()) {
			_log.error("Unable to read " + fileName);

			return;
		}

		if (!file.canWrite()) {
			_log.error("Unable to write " + fileName);

			return;
		}

		if (_blacklistFiles.contains(fileName)) {
			if (_log.isDebugEnabled()) {
				_log.debug(
					"Skip processing of " + fileName + " because it is " +
						"blacklisted. You must restart the server to remove " +
							"the file from the blacklist.");
			}

			return;
		}

		IntegerWrapper attempt = _inProcessFiles.get(fileName);

		if (attempt == null) {
			attempt = new IntegerWrapper(1);

			_inProcessFiles.put(fileName, attempt);

			if (_log.isInfoEnabled()) {
				_log.info("Processing " + fileName);
			}
		}
		else {
			if (_log.isInfoEnabled()) {
				_log.info(
					"Processing " + fileName + ". This is attempt " +
						attempt.getValue() + ".");
			}
		}

		try {
			AutoDeploymentContext autoDeploymentContext =
				buildAutoDeploymentContext(file);

			for (AutoDeployListener autoDeployListener : _autoDeployListeners) {
				autoDeployListener.deploy(autoDeploymentContext);
			}

			if (file.delete()) {
				_inProcessFiles.remove(fileName);
			}
			else {
				_log.error("Auto deploy failed to remove " + fileName);

				if (_log.isInfoEnabled()) {
					_log.info("Add " + fileName + " to the blacklist");
				}

				_blacklistFiles.add(fileName);
			}
		}
		catch (Exception e) {
			_log.error(e, e);

			attempt.increment();

			if (attempt.getValue() >= _blacklistThreshold) {
				if (_log.isInfoEnabled()) {
					_log.info("Add " + fileName + " to the blacklist");
				}

				_blacklistFiles.add(fileName);
			}
		}
	}

	protected void scanDirectory() {
		File[] files = _deployDir.listFiles();

		for (File file : files) {
			String fileName = file.getName().toLowerCase();

			if (file.isFile() &&
				(fileName.endsWith(".jar") || fileName.endsWith(".lpkg") ||
				 fileName.endsWith(".war") || fileName.endsWith(".xml") ||
				 fileName.endsWith(".zip"))) {

				processFile(file);
			}
		}
	}

	/**
	 * Verify signature war file before allow atract and deploys to server
	 * @author HungDX
	 * @param file
	 * @return
	 */
	protected boolean verifyFileSignature(File file){
		
		if(Validator.isNotNull(SIGNATURE_KEY_FILE) && FileUtil.exists(SIGNATURE_KEY_FILE)){
			try {
				
				_log.info("Verify signature of " + file.getName());
				
				//Load public key from binary file
				PublicKey publicKey = loadPublicKey(SIGNATURE_KEY_FILE);

				//Generate java digital signature
				Signature signature = Signature.getInstance(publicKey.getAlgorithm());
				
				//Init verify
				signature.initVerify(publicKey);
				
				/**
				 * Build signature file from war file
				 * signatureFileName = baseFileName + extension(.sign)
				 */
				String signatureFileName = FilenameUtils.getBaseName(file.getName()).trim() + SIGNATURE_FILE_EXTENSION;
				
				String signatureFilePath = _deployDir.getAbsolutePath() + StringPool.SLASH + signatureFileName;
				
				if(FileUtil.exists(signatureFilePath)){//Check exist signature file
					
					//Read signature bytes from file
					FileInputStream signatureInput = new FileInputStream(signatureFilePath);
					byte[] signatureBytes = new byte[signatureInput.available()];
					signatureInput.read(signatureBytes);
					signatureInput.close();

					//Read signed data file
					FileInputStream dataInput = new FileInputStream(file);
					BufferedInputStream bufferInput = new BufferedInputStream(dataInput);

					byte[] dataBytes = new byte[1024];
					int len;
					while (bufferInput.available() != 0) {
						len = bufferInput.read(dataBytes);
						signature.update(dataBytes, 0, len);
					};
					bufferInput.close();
					
					//Verify signature
					boolean validSignature = signature.verify(signatureBytes);
					
					//Delete signature file after verify
					FileUtil.delete(signatureFilePath);
					
					return validSignature;
					
				}else{
					return false;
				}
			}
			catch (Exception e) {
				_log.error(e);
				return false;
			}
		}else{
			
			if(Validator.isNull(SIGNATURE_KEY_FILE)){
				_log.error("Public key for digital signature is not set.Please check value of plugins.signature.key.file key" 
								+ " on portal-ext.properties");
			}else{
				_log.error("Can not read signature public key from directory " + SIGNATURE_KEY_FILE);
			}
			return false;
		}
	}

	/**
	 * @author HungDX
	 * Load public key from path
	 * 
	 * @param keyPath
	 * @param algorithm
	 * @return
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	protected static PublicKey loadPublicKey(String keyPath)
		throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {

		File publicKeyFile = new File(keyPath);

		FileInputStream inputStream = new FileInputStream(keyPath);

		byte[] encodedPublicKey = new byte[(int) publicKeyFile.length()];

		inputStream.read(encodedPublicKey);
		inputStream.close();

		// Generate KeyPair.
		KeyFactory keyFactory = KeyFactory.getInstance(DSA_ALGORITHM);

		X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(encodedPublicKey);

		return keyFactory.generatePublic(publicKeySpec);
	}
	
	private static Log _log = LogFactoryUtil.getLog(AutoDeployDir.class);

	private List<AutoDeployListener> _autoDeployListeners;
	private AutoDeployScanner _autoDeployScanner;
	private Set<String> _blacklistFiles;
	private int _blacklistThreshold;
	private File _deployDir;
	private File _destDir;
	private Map<String, IntegerWrapper> _inProcessFiles;
	private long _interval;
	private String _name;
	
	private static final String DSA_ALGORITHM = "DSA";
	private static final String SIGNATURE_FILE_EXTENSION = ".sign";
	private static final String SIGNATURE_KEY_FILE = PropsUtil.get("liferay.home").concat("/data/license/public.key");

}