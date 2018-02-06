package com.kz.po;

public class ContentWithBLOBs extends Content {
    private String content;

    private String keyword;

    private String staticurl;

    private String sourceurl;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public String getStaticurl() {
        return staticurl;
    }

    public void setStaticurl(String staticurl) {
        this.staticurl = staticurl == null ? null : staticurl.trim();
    }

    public String getSourceurl() {
        return sourceurl;
    }

    public void setSourceurl(String sourceurl) {
        this.sourceurl = sourceurl == null ? null : sourceurl.trim();
    }
}