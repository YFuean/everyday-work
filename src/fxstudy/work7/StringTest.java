package fxstudy.work7;

/**
 * String、StringBuffer、StringBuilder的比较
 * @author yuefan
 * 2019.3.16
 */
public class StringTest {
    //定义次数
    private static int time = 50000;
    public static void main(String[] args) {
        testString();
        testStringBuffer();
        testStringBuilder();
        test1String();
        test2String();
        testOptimalString();
    }
    //拼接String类型使用的时间
    public static void testString () {
        String s="";
        //获取以毫秒为单位的当前开始时间
        long begin = System.currentTimeMillis();
        //调用5000次String的拼接操作，每次都会发生新的String对象
        for(int i=0; i<time; i++){
            s += "java";
        }
        //获取以毫秒为单位的当前结束时间
        long over = System.currentTimeMillis();
        //求出实际消耗
        System.out.println("操作"+s.getClass().getName()+"类型使用的时间为："+(over-begin)+"毫秒");
    }
    //拼接StringBuffer类型使用的时间
    public static void testStringBuffer () {
        StringBuffer sb = new StringBuffer();
        long begin = System.currentTimeMillis();
        for(int i=0; i<time; i++){
            sb.append("java");
        }
        long over = System.currentTimeMillis();
        System.out.println("操作"+sb.getClass().getName()+"类型使用的时间为："+(over-begin)+"毫秒");
    }
    //拼接StringBuilder类型使用的时间
    public static void testStringBuilder () {
        StringBuilder sb = new StringBuilder();
        long begin = System.currentTimeMillis();
        for(int i=0; i<time; i++){
            sb.append("java");
        }
        long over = System.currentTimeMillis();
        System.out.println("操作"+sb.getClass().getName()+"类型使用的时间为："+(over-begin)+"毫秒");
    }
    //string字符串直接相加
    public static void test1String () {
        long begin = System.currentTimeMillis();
        for(int i=0; i<time; i++){
            String s = "I"+"love"+"java";
        }
        long over = System.currentTimeMillis();
        System.out.println("字符串直接相加操作："+(over-begin)+"毫秒");
    }
    //string字符串间接相加
    public static void test2String () {
        String s1 ="I";
        String s2 = "love";
        String s3 = "java";
        long begin = System.currentTimeMillis();
        for(int i=0; i<time; i++){
            String s = s1+s2+s3;
        }
        long over = System.currentTimeMillis();
        System.out.println("字符串间接相加操作："+(over-begin)+"毫秒");
    }
    //StringBuilder专String优化操作时间
    public static void testOptimalString () {
        String s="";
        long begin = System.currentTimeMillis();
        for(int i=0; i<time; i++){
            StringBuilder sb = new StringBuilder(s);
            sb.append("java");
            s=sb.toString();
        }
        long over = System.currentTimeMillis();
        System.out.println("模拟JVM优化操作的时间为："+(over-begin)+"毫秒");
    }

    //一般情况String、StringBuilder、StringBuffer三者的执行效率：StringBuilder > StringBuffer > String

    //当字符串相加操作或者改动较少的情况下，建议使用 String str=”hello”这种形式
    //当字符串相加操作较多的情况下，建议使用StringBuilder，如果采用了多线程，则使用StringBuffer。

}
