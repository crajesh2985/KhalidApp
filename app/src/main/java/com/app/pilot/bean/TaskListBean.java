package com.app.pilot.bean;

/**
 * Created by 1407053 on 12/9/2017.
 */

public class TaskListBean {
    private String task;
    private boolean checkStatus;
    private boolean rechargeStatus;
    private boolean addStatus;
    private boolean changeStatus;
    private boolean cleanStatus;

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(boolean checkStatus) {
        this.checkStatus = checkStatus;
    }

    public boolean isRechargeStatus() {
        return rechargeStatus;
    }

    public void setRechargeStatus(boolean rechargeStatus) {
        this.rechargeStatus = rechargeStatus;
    }

    public boolean isAddStatus() {
        return addStatus;
    }

    public void setAddStatus(boolean addStatus) {
        this.addStatus = addStatus;
    }

    public boolean isChangeStatus() {
        return changeStatus;
    }

    public void setChangeStatus(boolean changeStatus) {
        this.changeStatus = changeStatus;
    }

    public boolean isCleanStatus() {
        return cleanStatus;
    }

    public void setCleanStatus(boolean cleanStatus) {
        this.cleanStatus = cleanStatus;
    }
}
