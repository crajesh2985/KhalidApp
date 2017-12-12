package com.app.pilot.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.app.pilot.R;
import com.app.pilot.bean.TaskListBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 1407053 on 12/9/2017.
 */

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.ViewHolder> {

    ArrayList<TaskListBean> taskListBeen;

    public TaskListAdapter(List<TaskListBean> taskListBeen) {
        this.taskListBeen = new ArrayList<>(taskListBeen);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_checkbox_list_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.bindData(taskListBeen.get(position));

        //in some cases, it will prevent unwanted situations
       /* holder.checkbox.setOnCheckedChangeListener(null);

        //if true, your checkbox will be selected, else unselected
        holder.checkbox.setChecked(numbers.get(position).isSelected());

        holder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                numbers.get(holder.getAdapterPosition()).setSelected(isChecked);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return taskListBeen.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cb_add)
        CheckBox cbAdd;
        @BindView(R.id.cb_change)
        CheckBox cbChange;
        @BindView(R.id.cb_check)
        CheckBox cbCheck;
        @BindView(R.id.cb_clean)
        CheckBox cbClean;
        @BindView(R.id.cb_recharge)
        CheckBox cbRecharge;
        @BindView(R.id.tv_task)
        TextView taskTitle;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void bindData(TaskListBean taskListBean) {
            taskTitle.setText(taskListBean.getTask());
            if (taskListBean.getTask().equalsIgnoreCase("Air Filter") ||
                    taskListBean.getTask().equalsIgnoreCase("C.V Breater filter")) {
                cbCheck.setEnabled(false);
                cbRecharge.setEnabled(false);
                cbAdd.setEnabled(false);
            } else {
                cbCheck.setEnabled(true);
                cbRecharge.setEnabled(true);
                cbAdd.setEnabled(true);
            }
            cbAdd.setChecked(taskListBean.isAddStatus());
            cbChange.setChecked(taskListBean.isChangeStatus());
            cbCheck.setChecked(taskListBean.isCheckStatus());
            cbClean.setChecked(taskListBean.isCleanStatus());
            cbRecharge.setChecked(taskListBean.isRechargeStatus());
        }
    }
}