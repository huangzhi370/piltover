package com.piltover.user.entity;

import java.io.Serializable;
import java.util.Date;

public class MallUserLog implements Serializable {
    private Integer id;

    private String logInfo;

    private Date logTime;

    private String userId;

    public MallUserLog(Integer id, String logInfo, Date logTime, String userId) {
		super();
		this.id = id;
		this.logInfo = logInfo;
		this.logTime = logTime;
		this.userId = userId;
	}

	private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogInfo() {
        return logInfo;
    }

    public void setLogInfo(String logInfo) {
        this.logInfo = logInfo;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", logInfo=").append(logInfo);
        sb.append(", logTime=").append(logTime);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}