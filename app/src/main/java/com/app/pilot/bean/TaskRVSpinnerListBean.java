package com.app.pilot.bean;

import java.util.List;

/**
 * Created by 1407053 on 12/9/2017.
 */

public class TaskRVSpinnerListBean {
    private String task;
    private List<String> checkList;

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public List<String> getCheckList() {
        return checkList;
    }

    public void setCheckList(List<String> checkList) {
        this.checkList = checkList;
    }
}
