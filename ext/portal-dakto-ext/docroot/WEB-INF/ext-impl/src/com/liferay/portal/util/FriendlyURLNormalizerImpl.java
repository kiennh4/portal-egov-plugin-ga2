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

package com.liferay.portal.util;

import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.FriendlyURLNormalizer;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.Normalizer;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @author Shuyang Zhou
 */
public class FriendlyURLNormalizerImpl implements FriendlyURLNormalizer {

	public String normalize(String friendlyURL) {
		return normalize(friendlyURL, null);
	}

	public String normalize(String friendlyURL, char[] replaceChars) {
		if (Validator.isNull(friendlyURL)) {
			return friendlyURL;
		}

		friendlyURL = GetterUtil.getString(friendlyURL);
		friendlyURL = friendlyURL.toLowerCase();
		friendlyURL = Normalizer.normalizeToAscii(friendlyURL);

		friendlyURL = replace(friendlyURL, _MS_WORD_UNICODE, _MS_WORD_HTML);
		
		StringBuilder sb = null;

		int index = 0;

		for (int i = 0; i < friendlyURL.length(); i++) {
			char c = friendlyURL.charAt(i);

			if ((Arrays.binarySearch(_REPLACE_CHARS, c) >= 0) ||
				((replaceChars != null) &&
				 ArrayUtil.contains(replaceChars, c))) {

				if (sb == null) {
					sb = new StringBuilder();
				}

				if (i > index) {
					sb.append(friendlyURL.substring(index, i));
				}

				sb.append(CharPool.DASH);

				index = i + 1;
			}
		}

		if (sb != null) {
			if (index < friendlyURL.length()) {
				sb.append(friendlyURL.substring(index));
			}

			friendlyURL = sb.toString();
		}

		while (friendlyURL.indexOf(StringPool.DOUBLE_DASH) >= 0) {
			friendlyURL = StringUtil.replace(
				friendlyURL, StringPool.DOUBLE_DASH, StringPool.DASH);
		}

		/*if (friendlyURL.startsWith(StringPool.DASH)) {
			friendlyURL = friendlyURL.substring(1);
		}

		if (friendlyURL.endsWith(StringPool.DASH)) {
			friendlyURL = friendlyURL.substring(0, friendlyURL.length() - 1);
		}*/

		return friendlyURL;
	}
	
	private static String replace(String s, String[] oldSubs, String[] newSubs) {
		if ((s == null) || (oldSubs == null) || (newSubs == null)) {
			return null;
		}

		if (oldSubs.length != newSubs.length) {
			return s;
		}

		for (int i = 0; i < oldSubs.length; i++) {
			s = replace(s, oldSubs[i], newSubs[i]);
		}

		return s;
	}

	private static String replace(String s, String oldSub, String newSub) {
		return replace(s, oldSub, newSub, 0);
	}
	
	private static String replace(String s, String oldSub, String newSub,
			int fromIndex) {

		if ((s == null) || (oldSub == null) || (newSub == null)) {
			return null;
		}

		int y = s.indexOf(oldSub, fromIndex);

		if (y >= 0) {

			// The number 5 is arbitrary and is used as extra padding to reduce
			// buffer expansion

			StringBuilder sb = new StringBuilder(s.length() + 5 * newSub.length());

			int length = oldSub.length();
			int x = 0;

			while (x <= y) {
				sb.append(s.substring(x, y));
				sb.append(newSub);

				x = y + length;
				y = s.indexOf(oldSub, x);
			}

			sb.append(s.substring(x));

			return sb.toString();
		} else {
			return s;
		}
	}
	private static final char[] _REPLACE_CHARS;

	static {
		char[] replaceChars = new char[] {
			' ', ',', '\\', '\'', '\"', '(', ')', '[', ']', '{', '}', '?', '#',
			'@', '+', '~', ';', '$', '%', '!', '=', ':', '&'
		};

		Arrays.sort(replaceChars);

		_REPLACE_CHARS = replaceChars;
	}

	private static final String[] _MS_WORD_UNICODE = new String[] {
		"\u00ae", "\u2019", "\u201c", "\u201d","\u0111"
	};

	private static final String[] _MS_WORD_HTML = new String[] {
		"&reg;", StringPool.APOSTROPHE, StringPool.QUOTE, StringPool.QUOTE,"d"
	};

}