package com.utils.conversionformattingfunctions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String date = ConversionFormattingFunctions.getFormattedDateToStringFormat();

        System.out.println("date: "+date);

        String newDate = ConversionFormattingFunctions.getFormattedDateDMYHMADateZone(date);
        System.out.println("d: "+newDate);

        Date dateToDateFormat = ConversionFormattingFunctions.getFormattedStringDateToDateFormat(date);
        System.out.println("date format: "+dateToDateFormat);
    }
}