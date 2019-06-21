package fxstudy.test;

public class FireWorksTest {
    public static void main(String[] args) {
        FireWorks fireWorks = new FireWorks();
        fireWorks.Discharge();

        class A implements Fire{
            @Override
            public void Discharge() {
                System.out.println("bu bu bu");
            }
        }
        A a  = new A();
        a.Discharge();
    }
}
