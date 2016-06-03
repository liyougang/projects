package com.ligang.demo.web.util;

import java.io.PrintStream;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateUtil
{
  public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
  public static final String SIMPLE_DATE_FORMAT = "yyyy-MM-dd";

  public static String formatDateTime(Date date)
  {
    return formatDateTime("yyyy-MM-dd HH:mm:ss", date);
  }

  public static String formatDateTime(String pattern)
  {
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    String now = sdf.format(new Date());
    return now;
  }

  public static String formatDateTime(String pattern, Date date)
  {
    String strDate = null;
    String strFormat = pattern;
    SimpleDateFormat dateFormat = null;

    if (date == null) {
      return "";
    }
    dateFormat = new SimpleDateFormat(strFormat);
    strDate = dateFormat.format(date);

    return strDate;
  }

  public static String formatDateTime(String pattern, Date date, Locale locale)
  {
    String strDate = null;
    String strFormat = pattern;
    SimpleDateFormat dateFormat = null;

    if (date == null) {
      return "";
    }
    dateFormat = new SimpleDateFormat(strFormat, locale);
    strDate = dateFormat.format(date);

    return strDate;
  }

  public static Date parse(String pattern, String strDateTime)
  {
    Date date = null;
    if ((strDateTime == null) || (pattern == null))
      return null;
    try {
      SimpleDateFormat formatter = new SimpleDateFormat(pattern);
      formatter.setLenient(false);
      date = formatter.parse(strDateTime);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return date;
  }

  public static Date composeDate(Date date, Date time)
  {
    if ((date == null) || (time == null))
      return null;
    Calendar c1 = Calendar.getInstance();
    c1.setTime(date);
    Calendar c2 = Calendar.getInstance();
    c2.setTime(time);
    Calendar c3 = Calendar.getInstance();
    c3.set(c1.get(1), c1.get(2), c1
      .get(5), c2.get(11), c2
      .get(12), c2.get(13));
    return c3.getTime();
  }

  public static Date getTheDate(Date date)
  {
    if (date == null)
      return null;
    Calendar c1 = Calendar.getInstance();
    c1.setTime(date);
    Calendar c2 = Calendar.getInstance();
    c2.set(c1.get(1), c1.get(2), c1
      .get(5), 0, 0, 0);
    long millis = c2.getTimeInMillis();
    millis -= millis % 1000L;
    c2.setTimeInMillis(millis);
    return c2.getTime();
  }

  public static Date skipDateTime(Date d, int skipDay)
  {
    if (d == null)
      return null;
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(d);
    calendar.add(5, skipDay);
    return calendar.getTime();
  }

  public static String skipDateTime(String timeStr, int skipDay)
  {
    String pattern = "yyyy-MM-dd HH:mm:ss";
    Date d = parse(pattern, timeStr);
    Date date = skipDateTime(d, skipDay);
    return formatDateTime(pattern, date);
  }

  public static String skipDate(String dateStr, int skipDay)
  {
    String pattern = "yyyy-MM-dd";
    Date d = parse(pattern, dateStr);
    Date date = skipDateTime(d, skipDay);
    return formatDateTime(pattern, date);
  }

  public static String getTime(String timeStr, int skipDay, int skipHour, int skipMinute)
  {
    if (timeStr == null) {
      return null;
    }

    GregorianCalendar cal = new GregorianCalendar();
    cal.setTime(parse("yyyy-MM-dd HH:mm:ss", timeStr));

    cal.add(5, skipDay);
    cal.add(11, skipHour);
    cal.add(12, skipMinute);
    cal.get(8);

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    return dateFormat.format(cal.getTime());
  }

  public static boolean dateCompare(String str)
  {
    boolean bea = false;
    SimpleDateFormat sdf_d = new SimpleDateFormat("yyyy-MM-dd");
    String isDate = sdf_d.format(new Date());
    try
    {
      Date date1 = sdf_d.parse(str);
      Date date0 = sdf_d.parse(isDate);
      if (date0.after(date1))
        bea = true;
    }
    catch (ParseException e) {
      bea = false;
    }
    return bea;
  }

  public static boolean monthCompare(String str)
  {
    boolean bea = false;
    SimpleDateFormat sdf_m = new SimpleDateFormat("yyyy-MM");
    String isMonth = sdf_m.format(new Date());
    try
    {
      Date date1 = sdf_m.parse(str);
      Date date0 = sdf_m.parse(isMonth);
      if (date0.after(date1))
        bea = true;
    }
    catch (ParseException e) {
      bea = false;
    }
    return bea;
  }

  public static boolean secondCompare(String str)
  {
    boolean bea = false;
    SimpleDateFormat sdf_d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String isDate = sdf_d.format(new Date());
    try
    {
      Date date1 = sdf_d.parse(str);
      Date date0 = sdf_d.parse(isDate);
      if (date0.after(date1))
        bea = true;
    }
    catch (ParseException e) {
      bea = false;
    }
    return bea;
  }

  public static boolean secondCompare(String data1, String date2)
  {
    boolean bea = false;
    SimpleDateFormat sdf_d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try
    {
      Date date1 = sdf_d.parse(data1);
      Date date0 = sdf_d.parse(date2);
      if (date0.after(date1))
        bea = true;
    }
    catch (ParseException e) {
      bea = false;
    }
    return bea;
  }

  public static boolean isLeapYear(int year)
  {
    if (((year % 4 == 0) && (year % 100 != 0)) || ((year % 4 == 0) && 
      (year % 400 == 0))) {
      return true;
    }
    return false;
  }

  public static int getMonthsDays(int month, int year)
  {
    if ((isLeapYear(year)) && (month == 2))
      return 29;
    if ((!isLeapYear(year)) && (month == 2)) {
      return 28;
    }

    if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || 
      (month == 8) || (month == 10) || (month == 12)) {
      return 31;
    }
    return 30;
  }

  public static String getWeekDay(Date date)
  {
    DateFormatSymbols symboles = new DateFormatSymbols(Locale.getDefault());
    symboles.setShortWeekdays(new String[] { "", "7", "1", "2", "3", "4", 
      "5", "6" });
    SimpleDateFormat df = new SimpleDateFormat("E", symboles);
    return df.format(date);
  }

  public static String getWeekDay()
  {
    DateFormatSymbols symboles = new DateFormatSymbols(Locale.getDefault());
    symboles.setShortWeekdays(new String[] { "", "7", "1", "2", "3", "4", 
      "5", "6" });
    SimpleDateFormat date = new SimpleDateFormat("E", symboles);
    return date.format(new Date());
  }

  public static int getYear()
  {
    Calendar c = Calendar.getInstance();
    return c.get(1);
  }

  public static String getYearStr()
  {
    return formatDateTime("yyyy", new Date());
  }

  public static String getTheYearStr(Date date)
  {
    return formatDateTime("yyyy", date);
  }

  public static int getYearDays()
  {
    Calendar c = Calendar.getInstance();

    return c.getActualMaximum(6);
  }

  public static int getTheYearDays(int year)
  {
    Calendar c = Calendar.getInstance();
    c.set(year, 1, 1);
    return c.getActualMaximum(6);
  }

  public static int getMonth()
  {
    Calendar c = Calendar.getInstance();
    return c.get(2);
  }

  public static int getMonth(Date date)
  {
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    return c.get(2);
  }

  public static String getTheMonthStr(Date date)
  {
    return formatDateTime("MM", date);
  }

  public static String getCurrentMonthStr()
  {
    return formatDateTime("MM", new Date());
  }

  public static Date getThePreviousMonthLastDay(Date date)
  {
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    c.set(c.get(1), c.get(2) - 1, 1);
    int day = c.getActualMaximum(5);
    c.clear();
    c.setTime(date);
    c.set(c.get(1), c.get(2) - 1, day);
    return c.getTime();
  }

  public static Date getCurrentMonthLastDay(Date date)
  {
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    int day = c.getActualMaximum(5);
    c.set(c.get(1), c.get(2), day);
    return c.getTime();
  }

  public static Date getFirstDayOfWeek(Date date)
  {
    Calendar c = new GregorianCalendar();
    c.setFirstDayOfWeek(2);
    c.setTime(date);
    c.set(7, c.getFirstDayOfWeek());
    return c.getTime();
  }

  public static Date getLastDayOfWeek(Date date)
  {
    Calendar c = new GregorianCalendar();
    c.setFirstDayOfWeek(2);
    c.setTime(date);
    c.set(7, c.getFirstDayOfWeek() + 6);
    return c.getTime();
  }

  public static Date getFirstDayOfCurrYear(int year)
  {
    Calendar calendar = Calendar.getInstance();
    calendar.clear();
    calendar.set(1, year);
    Date currYearFirst = calendar.getTime();
    return currYearFirst;
  }

  public static Date getLastDayOfCurrYear(int year)
  {
    Calendar calendar = Calendar.getInstance();
    calendar.clear();
    calendar.set(1, year);
    calendar.roll(6, -1);
    Date currYearLast = calendar.getTime();

    return currYearLast;
  }

  public static Date getMiddDayOfYear(Date date)
  {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    int year = calendar.get(1);
    int month = calendar.get(2) + 1;
    String dateString = "";
    if (month <= 6)
      dateString = year + "-06-30";
    else {
      dateString = year + "-12-31";
    }
    return TimeUtil.parseDate(dateString);
  }

  public static Date getFirstDayOfSeason(Date date)
  {
    String dateString = "";

    Calendar calendar = Calendar.getInstance();
    calendar.clear();
    calendar.setTime(date);
    int year = calendar.get(1);
    int month = calendar.get(2) + 1;
    if ((month >= 1) && (month <= 3)) {
      dateString = year + "-" + "01" + "-" + "01";
    }
    if ((month >= 4) && (month <= 6)) {
      dateString = year + "-" + "04" + "-" + "01";
    }
    if ((month >= 7) && (month <= 9)) {
      dateString = year + "-" + "07" + "-" + "01";
    }
    if ((month >= 10) && (month <= 12)) {
      dateString = year + "-" + "10" + "-" + "01";
    }

    return TimeUtil.parseDate(dateString);
  }

  public static Date getLastDayOfSeason(Date date)
  {
    String dateString = "";

    Calendar calendar = Calendar.getInstance();
    calendar.clear();
    calendar.setTime(date);
    int year = calendar.get(1);
    int month = calendar.get(2) + 1;
    if ((month >= 1) && (month <= 3)) {
      dateString = year + "-" + "03" + "-" + "31";
    }
    if ((month >= 4) && (month <= 6)) {
      dateString = year + "-" + "06" + "-" + "30";
    }
    if ((month >= 7) && (month <= 9)) {
      dateString = year + "-" + "09" + "-" + "30";
    }
    if ((month >= 10) && (month <= 12)) {
      dateString = year + "-" + "12" + "-" + "31";
    }

    return TimeUtil.parseDate(dateString);
  }

  public static int getDay()
  {
    Calendar c = Calendar.getInstance();
    return c.get(5);
  }

  public static Date getDateOfYear(int year, int day)
  {
    Calendar c = Calendar.getInstance();
    c.set(1, year);
    c.set(6, day);
    c.set(9, 0);
    c.set(10, 0);
    c.set(12, 0);
    c.set(13, 0);
    c.set(14, 0);
    return c.getTime();
  }

  public static boolean isHolidy(String weekday)
  {
    if (("7".equals(weekday)) || ("6".equals(weekday))) {
      return true;
    }
    return false;
  }

  public static boolean isHolidy(Date date)
  {
    String weekday = getWeekDay(date);
    return isHolidy(weekday);
  }

  public static void main(String[] args) {
    Date date = parse("yyyy-MM-dd HH:mm:ss", 
      "2012-07-08 00:00:00");
    String weekDay = getWeekDay(date);
    System.out.println(weekDay);

    Calendar c = Calendar.getInstance();

    c.set(6, 1);

    System.out.println(c.getTime());

    System.out.println(getTheYearDays(2012));

    System.out.println(getDateOfYear(2012, 1));

    System.out.println(getThePreviousMonthLastDay(parse(
      "yyyy-MM-dd HH:mm:ss", "2012-01-01 00:00:00")));
  }
}