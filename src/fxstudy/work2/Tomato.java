package fxstudy.work2;

import java.util.Scanner;

/**
 * 捕捉控制台输入商品单价后的异常
 * @author yuefan
 * 2019.3.11
 */
//创建西红柿类
public class Tomato {
    public static void main(String[] args) {
        //创建控制台输入对象
        Scanner sc = new Scanner(System.in);
        //控制台输入提示信息、
        System.out.println("今天的西红柿单价（单价格式为“3.00”）：");
        //把控制台输入的西红柿单价赋值给变量dayPrice
        String dayPrice = sc.next();
        //控制台输入的字符串长度为4时
        if (dayPrice.length() == 4){
            //把可能产生异常的java代码放在try中
            try {
                //西红柿的售价信息
                String message = "西红柿：" + dayPrice + "元/500克";
                //使用“：”拆分字符串
                String[] strArr = message.split(":");
                //截取西红柿单价2.99
                String unitPriceStr = strArr[2].substring(0,4);
                //顾客购买西红柿的重量
                double weight = 650;
                //将String类型的西红柿单价转化为double类型
                double unitPriceDou = Double.parseDouble(unitPriceStr);
                //顾客购买650克西红柿需要需要支付的金额
                System.out.println(message + ",顾客购买了" + weight + "克的西红柿，须支付"
                        + (float) (weight/500 * unitPriceDou) + "元");
            }//捕捉数组元素下标越界异常对象
            catch (ArrayIndexOutOfBoundsException aiobe){
                aiobe.printStackTrace();
            }//捕捉与已产生的异常类型相匹配的异常对象
            catch (Exception e){
                e.printStackTrace();
            }finally {
                sc.close();
                System.out.println("控制台输入对象被关闭。");
            }
        }else {
            System.out.println("违规操作：" +"输入西红柿单价时小数点后必须保留两位有效数字（如3.00）！");
        }
    }
}
