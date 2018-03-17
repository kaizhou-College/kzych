package com.kz.po;

public class CommentWithBLOBs extends Comment {
    private String replay;

    private String content;

    public String getReplay() {
        return replay;
    }

    public void setReplay(String replay) {
        this.replay = replay == null ? null : replay.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}