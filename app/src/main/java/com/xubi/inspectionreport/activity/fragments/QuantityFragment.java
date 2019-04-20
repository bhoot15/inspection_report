package com.xubi.inspectionreport.activity.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.xubi.inspectionreport.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuantityFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.radio_yes)
    RadioButton radioButtonYes;
    @BindView(R.id.radio_no)
    RadioButton radioButtonNo;

    public QuantityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_quantity, container, false);
        ButterKnife.bind(this, v);
        setOnClickListener();
        return v;
    }

    private void setOnClickListener() {
        radioButtonYes.setOnClickListener(this);
        radioButtonNo.setOnClickListener(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_yes:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.radio_no:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }
}
