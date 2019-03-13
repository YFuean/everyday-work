package fxstudy.work1.jingling;
/**
 * 创建类，实现两个接口
 * @author yuefan
 * 2019.3.10
 */
//创建“移动”接口
interface Move{
    public void move();
}

//创建“唱歌”接口
interface Sing{
    public void sing();
}

//创建精灵类实现移动，唱歌接口
class JingLing implements Move,Sing{
    public void move(){
        System.out.println("可移动");
    }
    public void sing(){
        System.out.println("可唱歌");
    }

    public static void main(String[] args) {
        JingLing jingLing = new JingLing();
        System.out.println("精灵");
        jingLing.move();
        jingLing.sing();
    }
}



