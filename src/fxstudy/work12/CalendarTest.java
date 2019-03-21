package fxstudy.work12;

import java.util.Calendar;
import java.util.Date;

/**
 * Calendar类基础代码
 * @author yuefan
 * 2019.3.22
 */

public class CalendarTest {
    public static void main(String[] args) {
        //创建Calendar对象
        Calendar calendar = Calendar.getInstance();
        //获取年
        int year = calendar.get(Calendar.YEAR);
        //获取月，0表示1月份
        int month = calendar.get(Calendar.MONTH) + 1;
        //获取日
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        //获取小时
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        //获取分钟
        int minute = calendar.get(Calendar.MINUTE);
        //获取秒
        int second = calendar.get(Calendar.SECOND);

        System.out.println("当前时间：" + year + "-" + month + "-" + day + "  "
                + hour + ":" + minute + ":" + second);

        //将Calendar对象转换为Date对象
        Date date = calendar.getTime();
        //获取当前毫秒数
        Long time = calendar.getTimeInMillis();
        System.out.println("当前时间为：" + date);
        System.out.println("当前毫秒数：" + time);
    }
}
