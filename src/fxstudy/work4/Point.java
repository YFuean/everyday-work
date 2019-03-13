package fxstudy.work4;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;

/**
 * 计算随机两点间距离
 * @author yuefan
 * 2019.3.13
 */

public class Point {

    private static int result;

    public static void main(String[] args) throws IOException {
        Random random = new Random();
        //生成A点的(x,y)坐标
        int x = random.nextInt(1024);
        int y = random.nextInt(768);
        //生成B点的（a,b）坐标
        int a = random.nextInt(1024);
        int b = random.nextInt(768);

        System.out.println("A点坐标（"+ x + "," + y + ")");
        System.out.println("B点坐标（"+ a + "," + b + ")");

        //计算两点间距离，保留两位小数
        Point.result = (x-a)*(x-a) + (y-b)*(y-b);
        System.out.printf("两点间距离为"+"%.2f",Math.sqrt(Point.result));

        //生成图片
        BufferedImage bufferedImage = new BufferedImage(1024,768,4);
        //获取画笔
        Graphics g = bufferedImage.getGraphics();
        //设置字体
        Font font=new Font("微软雅黑",Font.BOLD,50);
        g.setFont(font);
        //设置画笔颜色
        Color color = new Color(175,177,179);
        g.setColor(color);
        //开始绘制
        g.fillRect(0,0,1024,768);
        g.setColor(Color.BLACK);
        //绘制线条
        g.drawLine(x,y,a,b);
        //绘制文字
        g.setColor(Color.black);
        g.drawString("长度为"+Math.sqrt(Point.result),100,100);

        //输出图片
        File file = new File("D:/point.jpg");
        OutputStream outputStream = new FileOutputStream(file);
        ImageIO.write(bufferedImage,"jpg",outputStream);
        outputStream.close();
    }
}
