package helpers;

import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Locale;

public class DateUtils {
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/YYYY");
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
        Month jan = Month.of(monthNumber);
        Locale loc = Locale.forLanguageTag("ru");
        String nameMonth = jan.getDisplayName(TextStyle.FULL_STANDALONE, loc);
        return nameMonth.substring(0, 1).toUpperCase() + nameMonth.substring(1).toLowerCase();
    }
}
