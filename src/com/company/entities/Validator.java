package com.company.entities;

import java.util.Calendar;
import java.util.regex.Pattern;

public class Validator {

    private static boolean isContain(int[] array, int value){
        for(int arrayValue : array){
            if(arrayValue == value) return true;
        }
        return false;
    }

    private static boolean isDateExist(String[] splittedDate){
        int day = Integer.parseInt(splittedDate[2]);
        int month = Integer.parseInt(splittedDate[1]);
        int year = Integer.parseInt(splittedDate[0]);
        if(day <= 0 || day > 31) return false;
        if (isContain(new int[]{4, 6, 9, 11}, day) && day >= 31 ) return false;
        if(month <= 0 || month > 12) return false;
        if(month == 2){
            if((year % 4 == 0 || (year % 100 == 0 && year % 400 != 0)) && day >= 29) return false;
            else if(day > 29) return  false;
        }
        if(Calendar.getInstance().getWeekYear() < year) return false;
        return true;
    }

    /**
     * Check if given string contain only digits
     * @param number
     * @return
     */
    public static boolean isNumber(String number){
        return Pattern.compile("\\d+").matcher(number).find();
    }

    /**
     * Check if given string contain only lower and upper case letters
     * @param string
     * @return
     */
    public static boolean containOnlyCharacters(String string){
        return Pattern.compile("^[A-Za-z]+$").matcher(string).find();
    }

    /**
     * Is given string fit email format
     * @param email
     * @return
     */
    public static boolean isEmail(String email){
        return Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$").matcher(email).find();
    }


    /**
     * Is given data is valid
     * @param date
     * @return
     */
    public static boolean checkDate(String date){
        if(!Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$").matcher(date).find()) return false;
        if(!isDateExist(date.split(("-")))) return false;
        return true;
    }

    /**
     * Is given string fit 'XXX-XXX-XXXX' phone format
     * @param phoneNumber
     * @return
     */
    public static boolean isPhoneNumber(String phoneNumber){
        return Pattern.compile("^\\d{3}-\\d{3}-\\d{4}$").matcher(phoneNumber).find();
    }

}