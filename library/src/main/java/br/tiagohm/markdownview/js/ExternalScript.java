/*
 *
 *  *    Copyright 2017 tiagohm
 *  *
 *  *    Licensed under the Apache License, Version 2.0 (the "License");
 *  *    you may not use this file except in compliance with the License.
 *  *    You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *    Unless required by applicable law or agreed to in writing, software
 *  *    distributed under the License is distributed on an "AS IS" BASIS,
 *  *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *    See the License for the specific language governing permissions and
 *  *    limitations under the License.
 *
 */

package br.tiagohm.markdownview.js;

public class ExternalScript implements JavaScript {
    private final String mSrc;
    private final boolean mIsAync;
    private final boolean mIsDefer;
    private final String mType;

    public ExternalScript(String src, boolean isAync, boolean isDefer, String type) {
        mSrc = src;
        mIsAync = isAync;
        mIsDefer = isDefer;
        mType = type;
    }

    public ExternalScript(String url, boolean isAync, boolean isDefer) {
        this(url, isAync, isDefer, "text/javascript");
    }

    public String getSrc() {
        return mSrc;
    }

    public String getType() {
        return mType;
    }

    public boolean isAync() {
        return mIsAync;
    }

    public boolean isDefer() {
        return mIsDefer;
    }

    @Override
    public String toHTML() {
        return String.format("<script %s%ssrc='%s' type='%s'></script>\n",
                isAync() ? "async " : "",
                isDefer() ? "defer " : "",
                getSrc(),
                getType());
    }
}
