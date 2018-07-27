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

    private String gender;

    private String mobile;

    private String school;

    private String originplace;

    private String idcard;

    private String realname;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getOriginplace() {
        return originplace;
    }

    public void setOriginplace(String originplace) {
        this.originplace = originplace == null ? null : originplace.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

    
}