/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.tallerjpa.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * fecha: 
 * @author Aprendiz
 */
public class ConversUtils {
    /**
     * Convierte una fecha a un string
     * @param date
     * @return
     */
    public static String dateToString (Date date)
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String result = dateFormat.format(date);
        return result;
    }
    /**
     * 
     * @param text
     * @return
     * @throws ParseException 
     */
    public static Date stringToDate(String text) throws ParseException
    {
        Date date = new SimpleDateFormat("HH:mm").parse(text);
        return date;
    }
    /**
     * 
     * @param date
     * @return 
     */
    public static String timeToString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        String result = dateFormat.format(date);
        return result;
    }
    /**
     * 
     * @param text
     * @return
     * @throws ParseException 
     */
    public static Date stringToTime(String text) throws ParseException
    {
        Date date = new SimpleDateFormat("HH:mm").parse(text);
        return date;
    }
    /**
     * convertir de LocalDate a Date 
     * @param localDate
     * @return
     */
    public static Date LocaldateToDate(LocalDate localDate){
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
     /**
     * convertir de LocalDate a Date 
     * @param localTime
     * @return
     */
    public static Date localTimeToDate(LocalTime localTime)
    {
        return  Date.from(LocalDate.now().atTime(localTime).atZone(ZoneId.systemDefault()).toInstant());
    }
    /**
     * convierte de Date a localDate
     * @param date
     * @return 
     */
    public static LocalDate datetoLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
