package fxstudy.work11;

/**
 * 枚举类型实例
 * @author yuefan
 * 2019.3.21
 */
enum Week{
    MONDAY("星期一"),TUESDAY("星期二"),WEDNESDAY("星期三"),THURSDAY("星期四"),
    FRIDAY("星期五"),SATURDAY("星期六"),SUNDAY("星期日");
    String weekName;
    Week(String weekName){
        this.weekName = weekName;
    }

    public String getWeekName(){
        return weekName;
    }

    //定义静态方法，根据一个简称得到完整的星期名称
    public static Week getResult(String input) {
        switch (input) {
            case "mon":
                return Week.MONDAY;
            case "tue":
                return Week.TUESDAY;
            case "wed":
                return Week.WEDNESDAY;
            case "thu":
                return Week.THURSDAY;
            case "fri":
                return Week.FRIDAY;
            case "sat":
                return Week.SATURDAY;
            case "sun":
                return Week.SUNDAY;
        }
        return null;
    }
}
public class EnumTest{
    public static void main(String[] args) {
        //访问某个枚举值
        System.out.println("访问某个枚举值");
        Week week = Week.getResult("sun");
        System.out.println(week + "——" + week.getWeekName());
        //遍历枚举
        System.out.println("遍历枚举");
        for (Week e:Week.values()) {
            System.out.println(e +"——" + e.getWeekName() );
        }
    }
}