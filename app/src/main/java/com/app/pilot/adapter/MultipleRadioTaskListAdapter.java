package com.app.pilot.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class MultipleRadioTaskListAdapter extends RecyclerView.Adapter<MultipleRadioTaskListAdapter.ViewHolder> {

    ArrayList<TaskListBean> taskListBeen;

    public MultipleRadioTaskListAdapter(List<TaskListBean> taskListBeen) {
        this.taskListBeen = new ArrayList<>(taskListBeen);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_multiple_radio_list_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.bindData(taskListBeen.get(position));
    }

    @Override
    public int getItemCount() {
        return taskListBeen.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.tv_task)
        TextView taskTitle;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void bindData(TaskListBean taskListBean) {
            taskTitle.setText(taskListBean.getTask());

        }
    }
}