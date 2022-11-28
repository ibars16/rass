package com.example.tasca2;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class SelectDateFragment extends DialogFragment {

    private String date = "";

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance();
        int yy = calendar.get(Calendar.YEAR);
        int mm = calendar.get(Calendar.MONTH);
        int dd = calendar.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) getParentFragment(), yy, mm, dd);
    }

    public void populateSetDate(int year, int month, int day) {
        date = month + "/" + day + "/" + year;
    }

    public String getDate() {
        return date;
    }
}