package fxstudy.work1;
/**
 * 使用接口相关知识绘制出特殊的平行四边形
 * @author yuefan\
 * 2019.3.10
 */

//定义“画图”接口
interface DrawImage {
    //定义抽象方法“画”
  public void draw();
}

//矩形类实现drawText接口
class Rectangle implements DrawImage{
    //矩形类实现draw()方法
    @Override
    public void draw () {
        System.out.println("画矩形");
    }
}

//正方形类类实现drawText接口
class Square implements DrawImage{
    //正方形类实现draw()方法
    @Override
    public void draw () {
        System.out.println("画正方形");
    }
}

//菱形类实现drawText接口
class Diamond implements DrawImage{
    //菱形类实现draw()方法
    @Override
    public void draw () {
        System.out.println("画菱形");
    }
}

//定义特殊的平行四边形类
public class SpecialParallelogram{
    public static void main (String[] args) {
        //接口可以进行向上转型操作
        DrawImage[] images={
                new Rectangle(),new Square(),new Diamond()};
        //遍历“画图形”接口类型的数组
        for (int i=0;i<images.length;i++){
            //调用draw()方法
            images[i].draw();
        }
    }
}