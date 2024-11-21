package data_structure;

import java.util.Stack;

/** 使用两个栈实现队列
 * @author wangyc
 * @date 2022/5/3
 */
public class ImplQueue {

    Stack<Integer> one = null;
    Stack<Integer> two = null;

    public ImplQueue() {
        one = new Stack<Integer>();
        two = new Stack<Integer>();
    }

    public void appendTail(int value) {
        one.push(value);
    }

    public int deleteHead() {
        int i = 0;
        while (!one.isEmpty()) {
            i++;
            Integer pop = one.pop();
            two.push(pop);
        }
        if(i > 0) {
            Integer res = two.pop();
            while (!two.isEmpty()) {
                Integer tmp = two.pop();
                one.push(tmp);
            }
            return res;
        }

        return -1;
    }

    public static void main(String[] args) {
        String s = "1";
        char[] chars = s.toCharArray();
        new String(chars);
        ImplQueue implQueue = new ImplQueue();
        implQueue.appendTail(1);
        Integer d1 = implQueue.deleteHead();
        Integer d2 = implQueue.deleteHead();
        implQueue.appendTail(3);
        implQueue.appendTail(4);
        Integer d3 = implQueue.deleteHead();
        Integer d4 = implQueue.deleteHead();

        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
        System.out.println(d4);
    }
}
