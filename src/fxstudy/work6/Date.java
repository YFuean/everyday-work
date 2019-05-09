package fxstudy.work6;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.YEARS;

/**
 * JDK8的日期时间处理
 * @author yuefan
 * 2019.3.15
 */

public class Date {
    public static void main(String[] args) {
        //1.获取今天的日期
        LocalDate today = LocalDate.now();
        System.out.println("Today's Local date :" + today);
        //2.获取年、月、日信息
        int year = today.getYear();
        int mouth = today.getMonthValue();
        int day = today.getDayOfMonth();
        System.out.printf("Year : %d  Month : %d  day : %d %n", year, mouth, day);
        //3.处理特定日期
        LocalDate dateOfBirth = LocalDate.of(2000, 03, 23);
        System.out.println("Your Date of birth is : " + dateOfBirth);
        //4.判断两个日期是否相等
        LocalDate date1 = LocalDate.of(2019, 03, 23);
        if (date1.equals(today)) {
            System.out.printf("Today %s and date1 %s are same date %n", today, date1);
        }
        //5.检查像生日这种周期性事件
        LocalDate dateBirth = LocalDate.of(2000, 03, 23);
        MonthDay birthday = MonthDay.of(dateBirth.getMonth(), dateBirth.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.from(today);

        if (currentMonthDay.equals(birthday)) {
            System.out.println("Many Many happy returns of the day !!");
        } else {
            System.out.println("Sorry, today is not your birthday");
        }
        //6.获取当前时间
        LocalTime time = LocalTime.now();
        System.out.println("local time now : " + time);
        //7.在现有的时间上增加2小时
        LocalTime newTime = time.plusHours(2);
        System.out.println("Time after 2 hours : " + newTime);
        //8.计算一周后的日期
        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        System.out.println("Today is : " + today);
        System.out.println("Date after 1 week : " + nextWeek);
        //9.一年前或一年后的日期
        LocalDate previousYear = today.minus(1, YEARS);
        System.out.println("Date before 1 year : " + previousYear);

        LocalDate nextYear = today.plus(1, YEARS);
        System.out.println("Date after 1 year : " + nextYear);
        //10.使用Clock时钟类.
        // 返回基于系统时钟的当前时间，并设置为utc
        Clock clock = Clock.systemUTC();
        System.out.println("Clock : " + clock);
        //返回基于系统时钟区域的时间
        Clock defaultClock = Clock.systemDefaultZone();
        System.out.println("Clock : " + defaultClock);
        //11.判断日期是早于还是晚于另一个日期
        LocalDate tomorrow = LocalDate.of(2019, 3, 16);
        if (tomorrow.isAfter(today)) {
            System.out.println("Tomorrow comes after today");
        }

        LocalDate yesterday = today.minus(1, DAYS);

        if (yesterday.isBefore(today)) {
            System.out.println("Yesterday is day before today");
        }
        //12.处理时区
        ZoneId america = ZoneId.of("America/New_York");
        LocalDateTime localDateAndTime = LocalDateTime.now();
        ZonedDateTime dateAndTimeInNewYork  = ZonedDateTime.of(localDateAndTime, america );
        System.out.println("Current date and time in a particular timezone : " + dateAndTimeInNewYork);
        //13.YearMonth类，用于表示信用卡到期日、FD到期日、期货期权到期日等
        YearMonth currentYearMonth = YearMonth.now();
        System.out.printf("Days in month year %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth());
        YearMonth creditCardExpiry = YearMonth.of(2020, Month.FEBRUARY);
        System.out.printf("Your credit card expires on %s %n", creditCardExpiry);
        //14.检查闰年
        if(today.isLeapYear()){
            System.out.println("This year is Leap year");
        }else {
            System.out.println("2014 is not a Leap year");
        }
        //15.计算两个日期之间的天数和月数
        LocalDate oneDay = LocalDate.of(2019,Month.OCTOBER,1 );
        Period periodToNextJavaRelease = Period.between(today, oneDay);
        System.out.println("15   Months left between today and Java 8 release : "
                + periodToNextJavaRelease.getMonths() );
        //16.包含时差信息的日期和时间
        LocalDateTime datetime = LocalDateTime.of(2014, Month.JANUARY, 14, 19, 30);
        ZoneOffset offset = ZoneOffset.of("+05:30");
        OffsetDateTime date = OffsetDateTime.of(datetime, offset);
        System.out.println("16   Date and Time with timezone offset in Java : " + date);
        //17.获取当前的时间戳
        Instant timestamp = Instant.now();
        System.out.println("What is value of this instant " + timestamp);
        //18.使用预定义的格式化工具去解析或格式化日期
        String dayAfterTomorrow = "20190320";
        LocalDate formatted = LocalDate.parse(dayAfterTomorrow,
                DateTimeFormatter.BASIC_ISO_DATE);
        System.out.printf("Date generated from String %s is %s %n",
                dayAfterTomorrow, formatted);
        //19.使用自定义格式化工具解析日期
        String goodFriday = "Apr 18 2014";
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
            LocalDate holiday = LocalDate.parse(goodFriday, formatter);
            System.out.printf("Successfully parsed String %s, date is %s%n", goodFriday, holiday);
        } catch (DateTimeParseException ex) {
            System.out.printf("%s is not parsable!%n", goodFriday);
            ex.printStackTrace();
        }
        //20.把日期转换成字符串
        LocalDateTime arrivalDate  = LocalDateTime.now();
        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM dd yyyy  hh:mm a");
            String landing = arrivalDate.format(format);
            System.out.printf("Arriving at :  %s %n", landing);
        } catch (DateTimeException ex) {
            System.out.printf("%s can't be formatted!%n", arrivalDate);
            ex.printStackTrace();
        }
    }
}