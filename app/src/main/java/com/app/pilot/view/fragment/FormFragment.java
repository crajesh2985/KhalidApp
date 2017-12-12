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


public class FormFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public static FormFragment newInstance() {
        FormFragment fragment = new FormFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
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

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(int step);
    }

    @OnClick(R.id.step_1_next_btn)
    public void nextButton(Button button) {
        if (mListener != null) {
            mListener.onFragmentInteraction(1);
        }
    }
}
