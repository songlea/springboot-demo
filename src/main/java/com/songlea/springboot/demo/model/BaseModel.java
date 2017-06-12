package com.songlea.springboot.demo.model;

/**
 * 比对结果模型,对于要比对同步的所有表均继承
 *
 * @author Song Lea
 */
public class BaseModel {

    private Integer inmCompareStatus; // 比对结果标识 1增加  2修改 3删除
    private String inmSyncTime; // 同步时间
    private Integer inmCheckStatus; // 审核状态 1待审核 2已审核
    private String inmCheckUser; // 审核用户
    private String inmCheckTime; // 审核时间

    public Integer getInmCompareStatus() {
        return inmCompareStatus;
    }

    public void setInmCompareStatus(Integer inmCompareStatus) {
        this.inmCompareStatus = inmCompareStatus;
    }

    public String getInmSyncTime() {
        return inmSyncTime;
    }

    public void setInmSyncTime(String inmSyncTime) {
        this.inmSyncTime = inmSyncTime;
    }

    public Integer getInmCheckStatus() {
        return inmCheckStatus;
    }

    public void setInmCheckStatus(Integer inmCheckStatus) {
        this.inmCheckStatus = inmCheckStatus;
    }

    public String getInmCheckUser() {
        return inmCheckUser;
    }

    public void setInmCheckUser(String inmCheckUser) {
        this.inmCheckUser = inmCheckUser;
    }

    public String getInmCheckTime() {
        return inmCheckTime;
    }

    public void setInmCheckTime(String inmCheckTime) {
        this.inmCheckTime = inmCheckTime;
    }
}
