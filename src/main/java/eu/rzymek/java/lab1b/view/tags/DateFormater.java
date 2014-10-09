package eu.rzymek.java.lab1b.view.tags;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author psysiu
 */
public class
    DateFormater {

    public static String format(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.YYYY H:m:s");
        return format.format(date);
    }
    
    public static Date parse(String string) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.YYYY H:m:s");
        return format.parse(string);
    }
}
