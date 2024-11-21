package linkNode;

/**
 * @Author wangyc
 * @Description
 * @Date 2024/10/10 17:16
 */
public class ListNode {

    private int val;

    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode() {}

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
