package com.utils.conversionformattingfunctions;

import android.telephony.PhoneNumberUtils;
import android.util.Base64;
import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConversionFormattingFunctions {

    //function to print any log
    public static void LOG(String msg){
        System.out.println("LOG: "+msg);
    }

    //to convert any String to Base64
    public static String convertStringToBase64(String password){
        byte[] data;
        String base64 = "" ;
        try {

            data = password.getBytes("UTF-8");

            base64 = Base64.encodeToString(data, Base64.DEFAULT);

            LOG(base64);

        } catch (UnsupportedEncodingException e) {

            Log.e("", "Received an exception " + e.getMessage() );

        }
        return base64;
    }

    //to convert any Base64 to String
    public static String convertBase64ToString(String base64)  {
        String key = "" ;
        try {
            byte[] data = Base64.decode(base64, Base64.DEFAULT);

            key = new String(data, "UTF-8");

        }catch (UnsupportedEncodingException e){
            Log.e("", "Received an exception " + e.getMessage() );

        }

        return key;
    }

    // to check password validation ex. First letter should be caps, it should have atleast one special character and numeric
    public static boolean isValidPassword(final String password) {
        Pattern pattern;
        Matcher matcher;

        final String PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*)(?=.*[@!#$%^&*()_+{}*-~])(?=\\S+$).{6,}$";

        pattern = Pattern.compile(PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();
    }

    //to get a current date in "yyyy-MM-dd" format
    public static String getCurrentDateYMD(){
        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        return date;
    }

    //to convert date from "dd MMM yyyy h:mm a" to "yyyy-MM-dd" format
    public static String getFormattedDateYMD(String date){
        DateFormat f = new SimpleDateFormat("dd MMM yyyy h:mm a", Locale.getDefault());
        Date d = null;
        try {
            d = f.parse(date);
        } catch (ParseException e) {
            Log.e("", "Received an Exception" + e.getMessage() );
        }
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String dateInStringFormat = simpleDateFormat.format(d);
        return dateInStringFormat;
    }

    //to convert date from "MM/dd/yyyy h:mm a" to "dd MMM yyyy h:mm a" format
    public static String getFormattedDateDMYHMA(String date){

        SimpleDateFormat inputFormat = new SimpleDateFormat("MM/dd/yyyy h:mm a", Locale.getDefault());
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMM yyyy h:mm a",Locale.getDefault());
        Date d = null;
        try {
            d = inputFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String formattedDate = outputFormat.format(d);
        return formattedDate;
    }

    //to convert date in string to "yyyy-MM-dd'T'HH:mm:ss'Z'" format
    public static String getFormattedDateToStringFormat() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Date date = new Date();
        String dateTime = dateFormat.format(date);
        return dateTime;
    }

    //to convert date in string to "yyyy-MM-dd'T'HH:mm:ss'Z'" format to dd MMM yyyy h:mm a
    public static String getFormattedDateDMYHMADateZone(String date){

        SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault());
        SimpleDateFormat outFormat = new SimpleDateFormat("dd MMM yyyy h:mm a",Locale.getDefault());
        Date newDate = null;
        try {
            newDate = inFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String formattedDateNew = outFormat.format(newDate);
        return formattedDateNew;
    }


    //to convert string date "yyyy-MM-dd'T'HH:mm:ss'Z'" to "Fri Feb 02 15:04:39 GMT+05:30 2024" date format
    public static Date getFormattedStringDateToDateFormat(String dateInStringFormat) {

        String dtStart = dateInStringFormat;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Date date = null;
        try {
            date = format.parse(dtStart);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    //to format mobile number in International US number
    public static String formatMobileNumber(String mobile_number){

        String formattedNumber =  PhoneNumberUtils.formatNumber(mobile_number,"US");

        return formattedNumber;
    }

    //to format amount in two decimal
    public static String formatToDecimal(String amount){
        String formattedAmount;
        DecimalFormat formatter = new DecimalFormat("0.00");
        formattedAmount = formatter.format(Double.valueOf(amount));
        return formattedAmount;
    }

    //to check characters (lowercase letters, uppercase letters, digits, underscores, and spaces)
    public static boolean isValidChar(String str)
    {
        boolean isValid = false;
        String expression = "^[a-z_A-Z0-9 ]*$";
        CharSequence inputStr = str;
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(inputStr);
        if(matcher.matches())
        {
            isValid = true;
        }
        return isValid;
    }


}
