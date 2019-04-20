package com.xubi.inspectionreport.dialog;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import java.util.Calendar;


public class DateDialog extends DialogFragment {

    DatePickerDialog.OnDateSetListener onDateSetListener;

    public DateDialog() {
    }

    @SuppressLint("ValidFragment")
    public DateDialog(DatePickerDialog.OnDateSetListener onDateSetListener) {
        this.onDateSetListener = onDateSetListener;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //Use the current date as the default date in the date picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        //Create a new DatePickerDialog instance and return it
        /*
            DatePickerDialog Public Constructors - Here we uses first one
            public DatePickerDialog (Context context, DatePickerDialog.OnDateSetListener callBack, int year, int monthOfYear, int dayOfMonth)
            public DatePickerDialog (Context context, int theme, DatePickerDialog.OnDateSetListener listener, int year, int monthOfYear, int dayOfMonth)
         */
        return new DatePickerDialog(getActivity(), onDateSetListener, year, month, day);
    }
//    public void onDateSet(DatePicker view, int year, int month, int day) {
//        //Do something with the date chosen by the user
//        TextView tv = (TextView) getActivity().findViewById(R.id.start_date);
//        tv.setText("Date changed...");
//        tv.setText(tv.getText() + "\nYear: " + year);
//        tv.setText(tv.getText() + "\nMonth: " + month);
//        tv.setText(tv.getText() + "\nDay of Month: " + day);
//
//        String stringOfDate = day + "/" + month + "/" + year;
//        tv.setText(tv.getText() + "\n\nFormatted date: " + stringOfDate);
//    }
}
