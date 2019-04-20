package com.xubi.inspectionreport.activity.fragments;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import com.xubi.inspectionreport.R;
import com.xubi.inspectionreport.dialog.DateDialog;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainContainerFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.report_date_tv)
    TextView reportDateTv;
    @BindView(R.id.tv_inspection_date)
    TextView inspectionDateTv;
    private DateDialog dialogFragment;
    private Calendar newDate;
    private String reportDateString, inspectionDateString;

    public MainContainerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_main_activity, container, false);
        ButterKnife.bind(this, v);
        setOnClickListener();
        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void setOnClickListener() {
        reportDateTv.setOnClickListener(this);
        inspectionDateTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.report_date_tv:
                dialogFragment = new DateDialog(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        newDate = Calendar.getInstance();
                        newDate.set(year, monthOfYear, dayOfMonth);

                        reportDateTv.setText("  " + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                        reportDateString = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;

                    }
                });
                if (getFragmentManager() != null) {
                    dialogFragment.show(getFragmentManager(), "Report Date");
                }
                break;
            case R.id.tv_inspection_date:
                dialogFragment = new DateDialog(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        newDate = Calendar.getInstance();
                        newDate.set(year, monthOfYear, dayOfMonth);

                        inspectionDateTv.setText("  " + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                        inspectionDateString = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;

                    }
                });
                if (getFragmentManager() != null) {
                    dialogFragment.show(getFragmentManager(), "Inspection Date");
                }
                break;
            default:
                break;
        }
    }

}
