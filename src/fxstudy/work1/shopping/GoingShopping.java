package fxstudy.work1.shopping;

import fxstudy.shopping.WallMarket;

/**
 * 定义GongingShopping类
 * @author yuefan
 * 2019.3.10
 */
public class GoingShopping {
    public static void main(String[] args) {
        //使用派生类对象创建抽象类对象
        Market market = new WallMarket();
        market.name = "沃尔玛";
        market.goods ="七匹狼西服";
        market.shop();
        //使用派生类对象创建抽象类对象
        market = new TaobaoMarket();
        market.name = "淘宝";
        market.goods ="韩都衣舍花裙";
        market.shop();
    }
}
