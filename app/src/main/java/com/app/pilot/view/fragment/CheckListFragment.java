package com.app.pilot.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.app.pilot.R;
import com.app.pilot.adapter.TaskListAdapter;
import com.app.pilot.bean.TaskListBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class CheckListFragment extends Fragment {

    @BindView(R.id.list)
    RecyclerView list;

    ArrayList<TaskListBean> taskListBean;
    private OnCheckListFragmentInteractionListener mListener;

    public static CheckListFragment newInstance() {
        CheckListFragment fragment = new CheckListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_checkbox_list, container, false);
        ButterKnife.bind(this, view);
        init();
        list.setLayoutManager(new LinearLayoutManager(getActivity()));
        list.setHasFixedSize(true);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnCheckListFragmentInteractionListener) {
            mListener = (OnCheckListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnCheckListFragmentInteractionListener {
        void onCheckListFragmentInteraction(int step);
    }

    @OnClick(R.id.step_2_next_btn)
    public void nextButton(Button button) {
        if (mListener != null) {
            mListener.onCheckListFragmentInteraction(2);
        }
    }

    private void init() {
        taskListBean = new ArrayList<>();
        String taskList[] = getResources().getStringArray(R.array.checkbox_task_list_array);
        for (int i = 0; i < taskList.length; i++) {
            TaskListBean tListBean = new TaskListBean();
            tListBean.setTask(taskList[i]);
            tListBean.setAddStatus(false);
            tListBean.setChangeStatus(false);
            tListBean.setCheckStatus(true);
            tListBean.setCleanStatus(false);
            tListBean.setRechargeStatus(true);
            this.taskListBean.add(tListBean);
        }
        TaskListAdapter adapter = new TaskListAdapter(this.taskListBean);
        list.setAdapter(adapter);
    }
}
