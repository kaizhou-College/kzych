package com.kz.po;

public class WxBindInfo {
    private Integer uid;

    private String wxUsername;

    private String token;

    private String tsecret;

    private Integer dateline;

    private Boolean synctowx;

    private Integer expiresIn;

    private String openid;

    private String refreshToken;

    private String unionid;

    private String pcOpenid;

    private String updRand;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getWxUsername() {
        return wxUsername;
    }

    public void setWxUsername(String wxUsername) {
        this.wxUsername = wxUsername == null ? null : wxUsername.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public String getTsecret() {
        return tsecret;
    }

    public void setTsecret(String tsecret) {
        this.tsecret = tsecret == null ? null : tsecret.trim();
    }

    public Integer getDateline() {
        return dateline;
    }

    public void setDateline(Integer dateline) {
        this.dateline = dateline;
    }

    public Boolean getSynctowx() {
        return synctowx;
    }

    public void setSynctowx(Boolean synctowx) {
        this.synctowx = synctowx;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken == null ? null : refreshToken.trim();
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
    }

    public String getPcOpenid() {
        return pcOpenid;
    }

    public void setPcOpenid(String pcOpenid) {
        this.pcOpenid = pcOpenid == null ? null : pcOpenid.trim();
    }

    public String getUpdRand() {
        return updRand;
    }

    public void setUpdRand(String updRand) {
        this.updRand = updRand == null ? null : updRand.trim();
    }
}