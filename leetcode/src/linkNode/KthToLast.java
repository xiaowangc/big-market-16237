package linkNode;

/**
 * @Author wangyc
 * @Description 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * @Date 2024/10/10 17:17
 */
public class KthToLast {

    public int kthToLast(ListNode head, int k) {
        if (head == null) {
            return -1;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        int temp = k;
        while (temp-- > 0) {
            p1 = p1.next;
        }
        while(p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2.getVal();
    }

    public static void main(String[] args) {

    }


}
