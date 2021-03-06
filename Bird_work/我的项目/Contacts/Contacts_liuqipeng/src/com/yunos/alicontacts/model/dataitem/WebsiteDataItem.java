/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.yunos.alicontacts.model.dataitem;

import android.content.ContentValues;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Website;

import com.yunos.alicontacts.model.RawContact;

/**
 * Represents a website data item, wrapping the columns in
 * {@link ContactsContract.CommonDataKinds.Website}.
 */
public class WebsiteDataItem extends DataItem {

    /* package */ WebsiteDataItem(RawContact rawContact, ContentValues values) {
        super(rawContact, values);
    }

    public String getUrl() {
        return getContentValues().getAsString(Website.URL);
    }

    /**
     * Value is one of Website.TYPE_*
     */
    public int getType() {
        return getContentValues().getAsInteger(Website.TYPE);
    }

    public String getLabel() {
        return getContentValues().getAsString(Website.LABEL);
    }
}
