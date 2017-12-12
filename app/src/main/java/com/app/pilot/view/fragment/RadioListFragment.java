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
import com.app.pilot.adapter.RadioTaskListAdapter;
import com.app.pilot.bean.TaskListBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class RadioListFragment extends Fragment {

    @BindView(R.id.list)
    RecyclerView list;

    ArrayList<TaskListBean> taskListBean;

    private OnRadioListFragmentInteractionListener mListener;

    public static RadioListFragment newInstance() {
        RadioListFragment fragment = new RadioListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_radio_list, container, false);
        ButterKnife.bind(this, view);

        init();
        list.setLayoutManager(new LinearLayoutManager(getActivity()));
        list.setHasFixedSize(true);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnRadioListFragmentInteractionListener) {
            mListener = (OnRadioListFragmentInteractionListener) context;
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

    public interface OnRadioListFragmentInteractionListener {
        void onRadioListFragmentInteraction(int step);
    }

    @OnClick(R.id.step_6_next_btn)
    public void nextButton(Button button) {
        if (mListener != null) {
            mListener.onRadioListFragmentInteraction(2);
        }
    }

    private void init() {
        taskListBean = new ArrayList<>();
        String taskList[] = getResources().getStringArray(R.array.radio_task_list_2_array);

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

        RadioTaskListAdapter adapter = new RadioTaskListAdapter(this.taskListBean);
        list.setAdapter(adapter);
    }
}
