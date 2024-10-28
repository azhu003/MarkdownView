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

package br.tiagohm.markdownview.ext.mathjax.internal;

import com.vladsch.flexmark.html.HtmlWriter;
import com.vladsch.flexmark.html.renderer.NodeRenderer;
import com.vladsch.flexmark.html.renderer.NodeRendererContext;
import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
import com.vladsch.flexmark.util.data.DataHolder;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

import br.tiagohm.markdownview.ext.mathjax.MathJax;

public class MathJaxNodeRenderer implements NodeRenderer {

    public MathJaxNodeRenderer(DataHolder options) {
    }

    @Override
    public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
        HashSet<NodeRenderingHandler<?>> set = new HashSet<>();
        set.add(new NodeRenderingHandler<>(MathJax.class, MathJaxNodeRenderer.this::render));

        return set;
    }

    private void render(MathJax node, NodeRendererContext context, HtmlWriter html) {
        html.withAttr().attr("class", "math").tag("span");
        if (node.isInline()) {
            html.append("\\(");
        } else {
            html.append("$$");
        }
        context.renderChildren(node);
        if (node.isInline()) {
            html.append("\\)");
        } else {
            html.append("$$");
        }
        html.tag("/span");
    }

    public static class Factory implements NodeRendererFactory {
        @Override
        public @NotNull NodeRenderer apply(@NotNull DataHolder options) {
            return new MathJaxNodeRenderer(options);
        }
    }
}
