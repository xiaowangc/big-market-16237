package leetcode_100;

/**
 * 斐波那契数列
 *
 * @author wangyc
 * @date 2023/12/16
 */
public class LeetCode_126 {

    public int fib(int n) {
        if (n <= 1) {
            return 1;
        }
        int result = 1;
        int pre1 = 1;
        int pre2 = 0;
        for (int i = 2; i <= n; i++) {
            result = (pre1 + pre2) % 1000000007;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode_126 leetCode_126 = new LeetCode_126();
//        int[] a = {3, 45};
//        for (int i : a) {
//            int fib = leetCode_126.fib(i);
//            System.out.println(fib);
//        }

        String s = new String("1");
        String s2 = "1";
        s.intern();
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        String s4 = "11";
        s3.intern();
        System.out.println(s3 == s4);
    }
    //简单理解s和s2：（1）使用new String("1")会直接生成两个对象，一个是在常量池中的1，一个是new引用对象；
    //（2）接着调用intern方法：由于已经生成了常量，故变量的指向还是引用对象地址，而不是常量池的地址。
    //（3）String s2 = "1"; 直接声明指向常量池地址

    //解释s3和s4:(1)s3 创建了三个对象：分别为常量池1、常量池2、new引用对象
    //（2）接着调用intern方法：由于常量池中不存在12，则会在常量池中生成12，s3引用指向了常量池12，而不是引用对象地址,这个与s.intern()是有区别的
    //(3) s4 声明指向常量池12的引用地址，所以s3与s4都指向了常量池12



}
