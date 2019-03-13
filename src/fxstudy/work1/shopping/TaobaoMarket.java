package fxstudy.work1.shopping;

/**
 * 定义TaobaoMarket类，继承自Market抽象类，
 * @author yuefan
 * 2019.3.10
 */
public class TaobaoMarket extends Market {
    //实现其中的shop()抽象方法
    public void shop() {
        System.out.println(name + "网购" + goods);
    }
}
