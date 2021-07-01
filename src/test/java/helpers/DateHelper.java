package helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {

    private static String dateFormat = "yyyy-MM-dd";

    public static String getDateAfter(int daysNo) throws ParseException {

        Date flightDate = new Date();
        String flightDateString = new SimpleDateFormat(dateFormat).format(flightDate);

        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        Calendar c = Calendar.getInstance();
        c.setTime(format.parse(flightDateString));
        c.add(Calendar.DATE, daysNo);  // number of days to add
        flightDateString = format.format(c.getTime());

        return flightDateString;
    }
}
