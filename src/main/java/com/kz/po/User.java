package com.kz.po;

import java.util.Date;

public class User {
    private Long uuid;

    private String realName;

    private String username;

    private String password;

    private String cellphone;

    private String sex;

    private String idcard;

    private String originPlace;

    private String school;

    private String signMessage;

    private String profile;
    /*角色0-普通用户,1-管理员',3-学生*/
    private Integer userType;

    private Date createTime;

    private Date lastloginTime;
    
    private String userAvatar;

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone == null ? null : cellphone.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getOriginPlace() {
        return originPlace;
    }

    public void setOriginPlace(String originPlace) {
        this.originPlace = originPlace == null ? null : originPlace.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getSignMessage() {
        return signMessage;
    }

    public void setSignMessage(String signMessage) {
        this.signMessage = signMessage == null ? null : signMessage.trim();
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile == null ? null : profile.trim();
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastloginTime() {
        return lastloginTime;
    }

    public void setLastloginTime(Date lastloginTime) {
        this.lastloginTime = lastloginTime;
    }

	public String getUserAvatar() {
		return userAvatar;
	}

	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}

	@Override
	public String toString() {
		return "User [uuid=" + uuid + ", realName=" + realName + ", username=" + username + ", password=" + password
				+ ", cellphone=" + cellphone + ", sex=" + sex + ", idcard=" + idcard + ", originPlace=" + originPlace
				+ ", school=" + school + ", signMessage=" + signMessage + ", profile=" + profile + ", userType="
				+ userType + ", createTime=" + createTime + ", lastloginTime=" + lastloginTime + ", userAvatar="
				+ userAvatar + "]";
	}


    
}