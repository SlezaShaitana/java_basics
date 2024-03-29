package org.example;

import java.util.concurrent.CopyOnWriteArrayList;

public class SiteMapNode {
    private volatile SiteMapNode parent;
    private volatile int depth;
    private final String url;
    private volatile CopyOnWriteArrayList<SiteMapNode> children;

    public SiteMapNode(String url) {
        depth = 0;
        this.url = url;
        parent = null;
        children = new CopyOnWriteArrayList<>();
    }

    private int calculateDepth() {
        int result = 0;
        if (parent == null) {
            return result;
        }
        result = 1 + parent.calculateDepth();
        return result;
    }

    public synchronized void addChild(SiteMapNode element) {
        SiteMapNode root = getRootElement();
        if (!root.contains(element.getUrl())) {
            element.setParent(this);
            children.add(element);
        }
    }

    private boolean contains(String url) {
        if (this.url.equals(url)) {
            return true;
        }
        for (SiteMapNode child : children) {
            if (child.contains(url))
                return true;
        }

        return false;
    }

    public String getUrl() {
        return url;
    }

    private void setParent(SiteMapNode sitemapNode) {
        synchronized (this) {
            this.parent = sitemapNode;
            this.depth = calculateDepth();
        }
    }

    public SiteMapNode getRootElement() {
        return parent == null ? this : parent.getRootElement();
    }

    public CopyOnWriteArrayList<SiteMapNode> getChildren() {
        return children;
    }
}
