package common.domain;

/**
 * @author wangyc
 * @date 2022/10/16
 */
public class Node {

    private int val;
    private Node next;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(Node next) {
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
