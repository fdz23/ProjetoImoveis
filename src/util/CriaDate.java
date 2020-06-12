/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/**
 *
 * @author fdz
 */
public class CriaDate {

    public static java.sql.Date geraSqlDate(String data) throws ParseException {

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        java.util.Date date = format.parse(data);
        java.sql.Date finalData = new java.sql.Date(date.getTime());

        return finalData;
        
    }
    
    public static String geraDataFormatada(java.util.Date data) {
        
        SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
        return formatData.format(data);
        
    }

}
