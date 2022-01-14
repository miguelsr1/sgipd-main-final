package sv.gob.mined.projects.sgipd.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class CalendarUtil {
    public Date getCurrentDate() {
        return new Date();
    }

    public Calendar getCurrentCalendar() {
        Calendar ccalendar = Calendar.getInstance();
        ccalendar.setTime(getCurrentDate());
        return ccalendar;
    }

    public Calendar getCalendar(Date cdate) {
        Calendar ccalendar = Calendar.getInstance();
        ccalendar.setTime(cdate);
        return ccalendar;
    }

    public Integer getCurrentYear() {
        return getCurrentCalendar().get(Calendar.YEAR);
    }

    public Date getFirstDayOfCurrentYear() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, getCurrentYear());
        cal.set(Calendar.DAY_OF_YEAR, 1);
        return cal.getTime();
    }

    public Date getLastDayOfCurrentYear() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, getCurrentYear());
        cal.set(Calendar.MONTH, 11);
        cal.set(Calendar.DAY_OF_MONTH, 31);
        return cal.getTime();
    }

    public Date addMonthsToDate(Date date, int months) {
        Calendar ccalendar = Calendar.getInstance();
        ccalendar.setTime(date);
        ccalendar.add(Calendar.MONTH, months);
        return ccalendar.getTime();
    }

    public Date addDaysToDate(Date date, int days) {
        Calendar ccalendar = Calendar.getInstance();
        ccalendar.setTime(date);
        ccalendar.add(Calendar.DATE, days);
        return ccalendar.getTime();
    }

    public Date add23Hours59Minutes59Seconds(Date date) {
        Calendar ccalendar = Calendar.getInstance();
        ccalendar.setTime(date);
        ccalendar.add(Calendar.HOUR, 23);
        ccalendar.add(Calendar.MINUTE, 59);
        ccalendar.add(Calendar.SECOND, 59);
        return ccalendar.getTime();
    }

    public Date fromUnixTimestampToDate(String unixtimestamp, String timezone) {
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone(timezone));
        c.setTimeInMillis(Long.parseLong(unixtimestamp) * 1000L);
        return c.getTime();
    }

    public Date fromUnixTimestampToDefaultDate(String unixtimestamp) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(Long.parseLong(unixtimestamp) * 1000L);
        return c.getTime();
    }

    public Date fromUnixTimestampToNewYorkDate(String unixtimestamp) {
        return fromUnixTimestampToDate(unixtimestamp, "America/El_Salvador");
    }

    public Date fromUnixTimestampToCST(String unixtimestamp) {
        return fromUnixTimestampToDate(unixtimestamp, "CST");
    }

    static java.text.SimpleDateFormat SDF_SF = new java.text.SimpleDateFormat("MM/dd/yyyy hh:mm a");
    static java.text.SimpleDateFormat SDF_SGIPD = new java.text.SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

    java.util.Date parseSuccessFactorsConvertDate(String sfDate) {

        String replaceTZ = sfDate.replaceAll(" America\\/New York", "");
        java.util.Date d = null;
        try {
            d = SDF_SF.parse(replaceTZ);
        } catch (java.text.ParseException e) {
            System.out.println("Error converting " + sfDate);
        }
        return d;
    }

    public String formatSF(Date date) {
        return SDF_SF.format(date) + " America/New York";
    }

    public static String formatSGIPD(Date date){return SDF_SGIPD.format(date);}

}
