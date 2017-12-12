package com.app.pilot.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.app.pilot.R;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class RemarkFormFragment extends Fragment {

    private OnRemarkFragmentInteractionListener mListener;

    public static RemarkFormFragment newInstance() {
        RemarkFormFragment fragment = new RemarkFormFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_remark_form, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnRemarkFragmentInteractionListener) {
            mListener = (OnRemarkFragmentInteractionListener) context;
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

    public interface OnRemarkFragmentInteractionListener {
        void onRemarkFragmentInteraction(int step);
    }

    @OnClick(R.id.step_7_next_btn)
    public void nextButton(Button button) {
        if (mListener != null) {
            mListener.onRemarkFragmentInteraction(1);
        }
    }
}
