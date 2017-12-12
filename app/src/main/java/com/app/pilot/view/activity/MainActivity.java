package com.app.pilot.view.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.app.pilot.R;
import com.app.pilot.view.fragment.CheckListFragment;
import com.app.pilot.view.fragment.DesialFormFragment;
import com.app.pilot.view.fragment.FormFragment;
import com.app.pilot.view.fragment.MultipleRadioListFragment;
import com.app.pilot.view.fragment.RadioListFragment;
import com.app.pilot.view.fragment.RemarkFormFragment;
import com.app.pilot.view.fragment.SpinnerListFragment;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements FormFragment.OnFragmentInteractionListener,
        CheckListFragment.OnCheckListFragmentInteractionListener, SpinnerListFragment.OnSpinnerListFragmentInteractionListener, RadioListFragment.OnRadioListFragmentInteractionListener,
        MultipleRadioListFragment.OnMultipleRadioListFragmentInteractionListener, DesialFormFragment.OnDesialFormFragmentInteractionListener, RemarkFormFragment.OnRemarkFragmentInteractionListener {

    @BindView(R.id.tv_step1)
    TextView tvStep1;
    @BindView(R.id.tv_step2)
    TextView tvStep2;
    @BindView(R.id.tv_step3)
    TextView tvStep3;
    @BindView(R.id.tv_step4)
    TextView tvStep4;
    @BindView(R.id.tv_step5)
    TextView tvStep5;
    @BindView(R.id.tv_step6)
    TextView tvStep6;
    @BindView(R.id.tv_step7)
    TextView tvStep7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_g);
        ButterKnife.bind(this);
        tvStep1.setBackground(ContextCompat.getDrawable(this, R.drawable.circle));
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        FormFragment formFragment = new FormFragment();
        ft.add(R.id.frame_container, formFragment);
        ft.commit();
    }

    @Override
    public void onFragmentInteraction(int step) {
        tvStep2.setBackground(ContextCompat.getDrawable(this, R.drawable.circle));
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        CheckListFragment checkListFragment = new CheckListFragment();
        ft.replace(R.id.frame_container, checkListFragment);
        ft.commit();
    }

    @Override
    public void onCheckListFragmentInteraction(int step) {
        tvStep3.setBackground(ContextCompat.getDrawable(this, R.drawable.circle));
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        SpinnerListFragment spinnerListFragment = new SpinnerListFragment();
        ft.replace(R.id.frame_container, spinnerListFragment);
        ft.commit();
    }

    @Override
    public void onSpinnerListFragmentInteraction(int step) {
        tvStep4.setBackground(ContextCompat.getDrawable(this, R.drawable.circle));
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        DesialFormFragment desialFormFragment = new DesialFormFragment();
        ft.replace(R.id.frame_container, desialFormFragment);
        ft.commit();
    }

    @Override
    public void onRadioListFragmentInteraction(int step) {
        tvStep7.setBackground(ContextCompat.getDrawable(this, R.drawable.circle));
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        RemarkFormFragment remarkFormFragment = new RemarkFormFragment();
        ft.replace(R.id.frame_container, remarkFormFragment);
        ft.commit();
    }

    @Override
    public void onMultipleRadioListFragmentInteraction(int step) {
        tvStep6.setBackground(ContextCompat.getDrawable(this, R.drawable.circle));
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        RadioListFragment radioListFragment = new RadioListFragment();
        ft.replace(R.id.frame_container, radioListFragment);
        ft.commit();
    }

    @Override
    public void onDesialFormFragmentInteraction(int step) {
        tvStep5.setBackground(ContextCompat.getDrawable(this, R.drawable.circle));
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        MultipleRadioListFragment multipleRadioListFragment = new MultipleRadioListFragment();
        ft.replace(R.id.frame_container, multipleRadioListFragment);
        ft.commit();
    }

    @Override
    public void onRemarkFragmentInteraction(int step) {

    }
}