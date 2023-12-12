package helpers;

import org.w3c.dom.Text;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/YYYY");
    private static final String month[] = new String[] {"Январь","Февраль","Март","Апрель","Май","Июнь","Июль","Август","Сентябрь","Октябрь","Ноябрь", "Декабрь"};
    private static final Locale ruLocale = new Locale("ru");


    public static int getCountDayOfMonth(int numberMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, numberMonth);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        return dayOfMonth;
    }

    public static String getCurrentDate() {
       return simpleDateFormat.format(Calendar.getInstance().getTime());
    }

    public static String getNameMonthOfNumber(int monthNumber) {
        DateFormatSymbols symbols = new DateFormatSymbols(Locale.getDefault());
        String[] monthNames = symbols.getMonths();
        return monthNames[monthNumber - 1];
    }
}
