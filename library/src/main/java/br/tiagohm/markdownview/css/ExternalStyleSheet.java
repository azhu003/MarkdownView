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

package br.tiagohm.markdownview.css;

import java.io.File;
import java.net.URL;

public class ExternalStyleSheet implements StyleSheet {
    private String mUrl;
    private String mMediaQuery;

    public ExternalStyleSheet(String url) {
        mUrl = url;
    }

    public ExternalStyleSheet(String url, String mediaQuery) {
        this(url);
        mMediaQuery = mediaQuery;
    }

    public static ExternalStyleSheet fromUrl(URL url, String mediaQuery) {
        return new ExternalStyleSheet(url.toString(), mediaQuery);
    }

    public static ExternalStyleSheet fromFile(File file, String mediaQuery) {
        return new ExternalStyleSheet(file.getAbsolutePath(), mediaQuery);
    }

    public static StyleSheet fromAsset(String path, String mediaQuery) {
        return new ExternalStyleSheet("file:///android_asset/" + path, mediaQuery);
    }

    public String getUrl() {
        return mUrl;
    }

    public String getMediaQuery() {
        return mMediaQuery;
    }

    @Override
    public String toString() {
        return getUrl();
    }

    @Override
    public String toHTML() {
        return String.format("<link rel=\"stylesheet\" type=\"text/css\" media=\"%s\" href=\"%s\" />\n",
                getMediaQuery() == null ? "" : getMediaQuery(),
                getUrl());
    }
}
