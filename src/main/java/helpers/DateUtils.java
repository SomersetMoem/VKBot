package helpers;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/YYYY");
    private static final Locale ruLocale = new Locale("ru");


    private static int getCountDayOfMonth(int numberMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, numberMonth);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        return dayOfMonth;
    }

    public static String getCurrentDate() {
       return simpleDateFormat.format(Calendar.getInstance().getTime());
    }

    public static String getNameMonthOfNumber(int month) {
        return Month.of(month).getDisplayName(?? ,ruLocale);//У меня почему-то не класса TextDisplay
    }




}
