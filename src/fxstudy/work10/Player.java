package fxstudy.work10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 定义运动员类，实现比较器接口，按照跑步成绩降序
 * @author yuefan
 * 2019.3.20
 */
public class Player implements Comparable<Player>{
    private String name;
    private Double RunPerformance;
    public Player(){}

    public Player(String name, Double runPerformance) {
        this.name = name;
        this.RunPerformance = runPerformance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRunPerformance() {
        return RunPerformance;
    }

    public void setRunPerformance(Double runPerformance) {
        this.RunPerformance = runPerformance;
    }

    @Override
    public int compareTo(Player player) {
        //按跑步成绩降序,double返回为int
        return (int) (this.getRunPerformance()-player.getRunPerformance());
    }

    public static void main(String[] args) {
        //创建list对象，存入player对象
        List<Player> list = new ArrayList<>();
        list.add(new Player("程咬金",7.56));
        list.add(new Player("夏明珠",10.28));
        list.add(new Player("王昭君",9.34));
        list.add(new Player("猴子",6.43));
        list.add(new Player("鲁班",12.30));
        //调用Collections的sort方法，会自动调用之前写的compareTo方法进行排序
        Collections.sort(list);
        //用foreach循环遍历list
        for (Player player: list){
            System.out.println("姓名：" + player.getName()+ ",成绩：" + player.getRunPerformance());
        }
    }
}
