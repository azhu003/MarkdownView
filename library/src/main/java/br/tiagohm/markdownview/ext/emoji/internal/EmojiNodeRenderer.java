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

package br.tiagohm.markdownview.ext.emoji.internal;

import com.vladsch.flexmark.html.HtmlWriter;
import com.vladsch.flexmark.html.renderer.LinkType;
import com.vladsch.flexmark.html.renderer.NodeRenderer;
import com.vladsch.flexmark.html.renderer.NodeRendererContext;
import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
import com.vladsch.flexmark.html.renderer.ResolvedLink;
import com.vladsch.flexmark.util.data.DataHolder;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

import br.tiagohm.markdownview.ext.emoji.Emoji;
import br.tiagohm.markdownview.ext.emoji.EmojiExtension;

public class EmojiNodeRenderer implements NodeRenderer {
    private final String rootImagePath;
    private final String attrImageSize;
    private final String attrAlign;
    private final String extImage;

    public EmojiNodeRenderer(DataHolder options) {
        this.rootImagePath = options.get(EmojiExtension.ROOT_IMAGE_PATH);
        this.attrImageSize = options.get(EmojiExtension.ATTR_IMAGE_SIZE);
        this.attrAlign = options.get(EmojiExtension.ATTR_ALIGN);
        this.extImage = options.get(EmojiExtension.IMAGE_EXT);
    }

    @Override
    public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
        HashSet<NodeRenderingHandler<?>> set = new HashSet<>();
        set.add(new NodeRenderingHandler<>(Emoji.class, new NodeRenderingHandler.CustomNodeRenderer<Emoji>() {
            @Override
            public void render(Emoji node, NodeRendererContext context, HtmlWriter html) {
                EmojiNodeRenderer.this.render(node, context, html);
            }
        }));
        return set;
    }

    private void render(Emoji node, NodeRendererContext context, HtmlWriter html) {
        Emoji emoji = node;
        EmojiCheatSheet.EmojiShortcut shortcut = EmojiCheatSheet.getImageShortcut(emoji.getText().toString());

        if (shortcut == null) {
            // output as text
            html.text(":");
            context.renderChildren(node);
            html.text(":");
        } else {
            ResolvedLink resolvedLink = context.resolveLink(LinkType.LINK, rootImagePath + shortcut.image + "." + extImage, null);

            html.attr("src", resolvedLink.getUrl());
            html.attr("alt", "emoji " + shortcut.category + ":" + shortcut.name);
            if (!attrImageSize.isEmpty())
                html.attr("height", attrImageSize).attr("width", attrImageSize);
            if (!attrAlign.isEmpty()) html.attr("align", attrAlign);
            html.withAttr(resolvedLink);
            html.tagVoid("img");
        }
    }

    public static class Factory implements NodeRendererFactory {

        @Override
        public @NotNull NodeRenderer apply(@NotNull DataHolder options) {
            return new EmojiNodeRenderer(options);
        }
    }
}
