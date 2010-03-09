/*
 * Copyright (C) 2010 Geometer Plus <contact@geometerplus.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 */

package org.geometerplus.fbreader.network.atom;

import org.geometerplus.zlibrary.core.xml.ZLStringMap;


abstract class ATOMCommonAttributes {
	public static final String XML_BASE = "xml:base";
	public static final String XML_LANG = "xml:lang";

	private ZLStringMap myAttributes;

	public void readAttributes(ZLStringMap source) {
		readAttribute(XML_BASE, source);
		readAttribute(XML_LANG, source);
	}

	protected final void readAttribute(String name, ZLStringMap source) {
		final String value = source.getValue(name);
		if (value != null && value.length() > 0) {
			if (myAttributes == null) {
				myAttributes = new ZLStringMap();
			}
			myAttributes.put(name, value);
		}
	}

	public final String getAttribute(String name) {
		if (myAttributes == null) {
			return null;
		}
		return myAttributes.getValue(name);
	}

	public final String getLang() {
		return getAttribute(XML_LANG);
	}

	public final String getBase() {
		return getAttribute(XML_BASE);
	}
}
