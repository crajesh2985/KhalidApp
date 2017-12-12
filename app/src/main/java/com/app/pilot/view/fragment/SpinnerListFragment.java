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
import com.app.pilot.adapter.TaskRVSpinnerListAdapter;
import com.app.pilot.bean.TaskRVSpinnerListBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class SpinnerListFragment extends Fragment {

    @BindView(R.id.list)
    RecyclerView rvSpinnerList;

    ArrayList<TaskRVSpinnerListBean> taskRVSpinnerListBeen;

    private OnSpinnerListFragmentInteractionListener mListener;

    public static SpinnerListFragment newInstance() {
        SpinnerListFragment fragment = new SpinnerListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_spinner_list, container, false);
        ButterKnife.bind(this, view);
        init();
        rvSpinnerList.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvSpinnerList.setHasFixedSize(true);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnSpinnerListFragmentInteractionListener) {
            mListener = (OnSpinnerListFragmentInteractionListener) context;
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

    public interface OnSpinnerListFragmentInteractionListener {
        void onSpinnerListFragmentInteraction(int step);
    }

    @OnClick(R.id.step_3_next_btn)
    public void nextButton(Button button) {
        if (mListener != null) {
            mListener.onSpinnerListFragmentInteraction(3);
        }
    }

    private void init() {
        taskRVSpinnerListBeen = new ArrayList<>();
        getResources().getStringArray(R.array.spinner_task_list_array);
        String taskList[] = getResources().getStringArray(R.array.spinner_task_list_array);

        for (int i = 0; i < taskList.length; i++) {
            TaskRVSpinnerListBean tRVSpinnerListBean = new TaskRVSpinnerListBean();
            tRVSpinnerListBean.setTask(taskList[i]);
            //List<String> statusList = new ArrayList<String>();
            List<String> statusList = null;
            if (i == 0) {
                statusList = Arrays.asList(getResources().getStringArray(R.array.acceleratorcheck_list_array));
            } else if (i == 1) {
                statusList = Arrays.asList(getResources().getStringArray(R.array.coppertubing_list_array));
            } else if (i == 2) {
                statusList = Arrays.asList(getResources().getStringArray(R.array.mufflerraincap_list_array));
            } else if (i == 3) {
                statusList = Arrays.asList(getResources().getStringArray(R.array.radiatorcap_list_array));
            } else if (i == 4) {
                statusList = Arrays.asList(getResources().getStringArray(R.array.alternator_list_array));
            } else if (i == 5) {
                statusList = Arrays.asList(getResources().getStringArray(R.array.coppertubingvalue_list_array));
            } else if (i == 6) {
                statusList = Arrays.asList(getResources().getStringArray(R.array.batterbox_list_array));
            } else if (i == 7) {
                statusList = Arrays.asList(getResources().getStringArray(R.array.turbo_charger_list_array));
            } else if (i == 8) {
                statusList = Arrays.asList(getResources().getStringArray(R.array.clutch_grease_hose_list_array));
            } else if (i == 9) {
                statusList = Arrays.asList(getResources().getStringArray(R.array.engine_skid_welded_list_array));
            } else if (i == 10) {
                statusList = Arrays.asList(getResources().getStringArray(R.array.access_way_job_location_list_array));
            }
            tRVSpinnerListBean.setCheckList(statusList);
            taskRVSpinnerListBeen.add(tRVSpinnerListBean);
        }

        TaskRVSpinnerListAdapter adapter = new TaskRVSpinnerListAdapter(
                getActivity(), this.taskRVSpinnerListBeen);
        rvSpinnerList.setAdapter(adapter);
    }
}
