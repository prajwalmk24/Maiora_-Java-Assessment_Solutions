package com.details.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentUtils {
	
	public static Date convertStringToDate(String dateString, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(dateString);
        } catch (ParseException e) {
            System.err.println("Error parsing date: " + e.getMessage());
            return null; // Or handle the error as needed
        }
    }
	
	

}
