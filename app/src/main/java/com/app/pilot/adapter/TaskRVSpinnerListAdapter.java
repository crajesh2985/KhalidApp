package com.app.pilot.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.app.pilot.R;
import com.app.pilot.bean.TaskRVSpinnerListBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 1407053 on 12/9/2017.
 */

public class TaskRVSpinnerListAdapter extends RecyclerView.Adapter<TaskRVSpinnerListAdapter.ViewHolder> {

    ArrayList<TaskRVSpinnerListBean> taskRVSpinnerListBean;
    Context context;

    public TaskRVSpinnerListAdapter(Context context, List<TaskRVSpinnerListBean> taskRVSpinnerListBean) {
        this.taskRVSpinnerListBean = new ArrayList<>(taskRVSpinnerListBean);
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_spinner_list_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.bindData(context, taskRVSpinnerListBean.get(position));
    }

    @Override
    public int getItemCount() {
        return taskRVSpinnerListBean.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        @Nullable
        @BindView(R.id.sp_status)
        Spinner spTaskStatus;
        @Nullable
        @BindView(R.id.tv_task)
        TextView taskTitle;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void bindData(Context context, TaskRVSpinnerListBean taskSpinnerListBean) {
            taskTitle.setText(taskSpinnerListBean.getTask());
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(context,
                    android.R.layout.simple_spinner_item, taskSpinnerListBean.getCheckList());
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spTaskStatus.setAdapter(dataAdapter);
        }
    }
}