package com.ligang.demo.web.util;

import java.io.PrintStream;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class TimeUtil
{
  public static String getTime()
  {
    SimpleDateFormat dateFormat = new SimpleDateFormat(
      "yyyy-MM-dd HH:mm:ss");
    String sj_str = dateFormat.format(new Date());

    return sj_str;
  }

  public static String getDate()
  {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String sj_str = dateFormat.format(new Date());

    return sj_str;
  }

  public static String getDate(String formatstr)
  {
    SimpleDateFormat dateFormat = new SimpleDateFormat(formatstr);
    String sj_str = dateFormat.format(new Date());

    return sj_str;
  }

  public static String formatTime(String timeStr)
  {
    if (timeStr == null) {
      return null;
    }

    SimpleDateFormat dateFormat = new SimpleDateFormat(
      "yyyy-MM-dd HH:mm:ss");
    Date date = parseTime(timeStr);
    String sj_str = dateFormat.format(date);

    return sj_str;
  }

  public static String formatDate(String dateStr)
  {
    if (dateStr == null) {
      return null;
    }
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = parseDate(dateStr);
    String sj_str = dateFormat.format(date);

    return sj_str;
  }

  public static String formatDate(String pattern, String dateStr)
  {
    if (dateStr == null) {
      return null;
    }
    SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
    Date date = parseDate(dateStr);
    String sj_str = dateFormat.format(date);

    return sj_str;
  }

  public static Date parseDate(String dateStr)
  {
    if (dateStr == null) {
      return null;
    }
    Date date = null;

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    try
    {
      date = dateFormat.parse(dateStr);
    }
    catch (ParseException localParseException) {
    }
    return date;
  }

  public static Date parseDate(String pattern, String dateStr)
  {
    if (dateStr == null) {
      return null;
    }
    Date date = null;

    SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
    try
    {
      date = dateFormat.parse(dateStr);
    }
    catch (ParseException localParseException) {
    }
    return date;
  }

  public static Date parseTime(String timeStr)
  {
    if (timeStr == null) {
      return null;
    }

    Date date = null;

    SimpleDateFormat dateFormat = new SimpleDateFormat(
      "yyyy-MM-dd HH:mm:ss");
    try
    {
      date = dateFormat.parse(timeStr);
    }
    catch (ParseException localParseException) {
    }
    return date;
  }

  public static String getTime(int skipDay)
  {
    GregorianCalendar cal = new GregorianCalendar();
    cal.setTime(new Date());

    cal.add(5, skipDay);
    SimpleDateFormat dateFormat = new SimpleDateFormat(
      "yyyy-MM-dd HH:mm:ss");

    return dateFormat.format(cal.getTime());
  }

  public static String getTime(String timeStr, int skipDay)
  {
    GregorianCalendar cal = new GregorianCalendar();
    cal.setTime(parseTime(timeStr));

    cal.add(5, skipDay);
    SimpleDateFormat dateFormat = new SimpleDateFormat(
      "yyyy-MM-dd HH:mm:ss");

    return dateFormat.format(cal.getTime());
  }

  public static String getDate(int skipDay)
  {
    GregorianCalendar cal = new GregorianCalendar();
    cal.setTime(new Date());

    cal.add(5, skipDay);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    return dateFormat.format(cal.getTime());
  }

  public static String getDate(String dateStr, int skipDay)
  {
    if (dateStr == null) {
      return null;
    }

    GregorianCalendar cal = new GregorianCalendar();
    cal.setTime(parseDate(dateStr));

    cal.add(5, skipDay);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    return dateFormat.format(cal.getTime());
  }

  public static String getTime(int skipDay, int skipHour, int skipMinute)
  {
    GregorianCalendar cal = new GregorianCalendar();
    cal.setTime(new Date());

    cal.add(5, skipDay);
    cal.add(11, skipHour);
    cal.add(12, skipMinute);

    SimpleDateFormat dateFormat = new SimpleDateFormat(
      "yyyy-MM-dd HH:mm:ss");

    return dateFormat.format(cal.getTime());
  }

  public static String getTime(String timeStr, int skipDay, int skipHour, int skipMinute)
  {
    if (timeStr == null) {
      return null;
    }

    GregorianCalendar cal = new GregorianCalendar();
    cal.setTime(parseTime(timeStr));

    cal.add(5, skipDay);
    cal.add(11, skipHour);
    cal.add(12, skipMinute);
    cal.get(8);

    SimpleDateFormat dateFormat = new SimpleDateFormat(
      "yyyy-MM-dd HH:mm:ss");

    return dateFormat.format(cal.getTime());
  }

  public static long subtraction(Date minuend, Date subtrahend)
  {
    long daterange = minuend.getTime() - subtrahend.getTime();
    long time = 86400000L;

    return daterange % time == 0L ? daterange / time : 
      daterange / time + 1L;
  }

  public static long getM(Date date) {
    GregorianCalendar cal = new GregorianCalendar();
    cal.setTime(date);
    return cal.get(7);
  }

  public static String getLastDate(String temp) {
    if ((temp == null) || (temp.equals(""))) {
      temp = "1";
    }
    int i = Integer.parseInt(temp);
    DateFormat dateFormat = DateFormat.getDateInstance(2);
    Calendar grc = Calendar.getInstance();
    grc.add(5, -i);
    return dateFormat.format(grc.getTime());
  }

  public static String getLastYearDate()
  {
    Calendar c = Calendar.getInstance();
    int y = c.get(1);
    String year = String.valueOf(y - 1);
    return year;
  }

  public static String getLastMonthDate()
  {
    Calendar c = Calendar.getInstance();
    int y = c.get(1);
    int m = c.get(2) + 1;
    String month = null;
    String year = String.valueOf(y);
    if (m > 1) {
      if (m > 10)
        month = String.valueOf(m - 1);
      else
        month = "0" + String.valueOf(m - 1);
    }
    else {
      year = String.valueOf(y - 1);
      month = String.valueOf(12);
    }

    return year + "-" + month;
  }

  public static String getLastDayDate()
  {
    Calendar c = Calendar.getInstance();
    int y = c.get(1);
    int m = c.get(2) + 1;
    int d = c.get(5);
    int days = 0;
    if (m > 1)
      days = getMonthsDays(m - 1, y);
    else {
      days = 31;
    }
    String day = null;
    String month = null;
    String year = String.valueOf(y);
    if (d > 1) {
      day = String.valueOf(d - 1);
      if (m > 9)
        month = String.valueOf(m);
      else
        month = "0" + String.valueOf(m);
    }
    else if ((d < 2) && (m < 2)) {
      day = String.valueOf(31);
      month = String.valueOf(12);
      year = String.valueOf(y - 1);
    } else if ((d < 2) && (m > 2)) {
      day = String.valueOf(days);
      if (m > 10)
        month = String.valueOf(m - 1);
      else {
        month = "0" + String.valueOf(m - 1);
      }
    }

    return year + "-" + month + "-" + day;
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

  public static String getWeekDay() {
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

  public static int getMonth()
  {
    Calendar c = Calendar.getInstance();
    return c.get(2);
  }

  public static int getDay()
  {
    Calendar c = Calendar.getInstance();
    return c.get(5);
  }

  public static String getLastMonthDay(int lastmonths) {
    int month = getMonth() + 1;
    if (month - lastmonths > 0) {
      return String.valueOf(getYear()) + "-" + 
        String.valueOf(month - lastmonths) + "-1";
    }
    return String.valueOf(getYear() - 1) + "-" + 
      String.valueOf(12 + month - lastmonths) + "-1";
  }

  public static boolean isDateCross(Date fromDate1, Date toDate1, Date fromDate2, Date toDate2)
  {
    if ((subtraction(toDate1, fromDate1) >= 0L) && 
      (subtraction(fromDate1, toDate2) > 0L)) {
      return false;
    }
    if ((subtraction(toDate1, fromDate1) >= 0L) && 
      (subtraction(fromDate2, toDate1) > 0L)) {
      return false;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.print(parseDate("yyyyMMdd", "20061001"));
  }
}