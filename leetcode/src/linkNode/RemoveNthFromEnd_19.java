package linkNode;

/**
 * @Author wangyc
 * @Description 删除链表的倒数第n个节点：给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * @Date 2024/10/10 17:56
 */
public class RemoveNthFromEnd_19 {

    //解题思路：1.设长度为l, 从链头遍历走n步；2.再增加一个节点p2从链头开始，遍历l - n步，此时p2所在的位置就是倒数第n个节点
    //3.删除倒数第n个节点，还需要考虑找出倒数第n+1个节点，和倒数节点的边界问题。
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        ListNode res = head;
        int temp = n;

        while (temp-- > 0) {
            p = p.next;
        }
        //边界处理：如果倒数第n个=第1个节点，则直接返回下个节点
        if (p == null) {
            return res.next;
        }

        ListNode p2 = head;
        // 记录倒数第n+1个节点
        ListNode p3 = head;

        while (p != null) {
            //边界处理：少一次移动
            if (p.next != null) {
                p3 = p3.next;
            }
            p = p.next;
            p2 = p2.next;
        }

        p3.next = p2.next;
        p2.next = null;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccba"));
        System.out.println(longestPalindrome("acbbcadcba"));
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        char[] charArray = s.toCharArray();
        if (charArray.length == 0) {
            return null;
        }

        int left = 0, right = charArray.length - 1;
        String res = "";
        while (left < charArray.length) {
            String substring = s.substring(left, right + 1);
            boolean huiWen = isHuiWen(substring);
            if (huiWen) {
                if(res.length() < substring.length()) {
                    res = substring;
                }
            }
            left++;
        }
        return res;
    }

    /**
     * 判断字符串是否满足回文串
     * @param subStr
     * @return
     */
    private static boolean isHuiWen(String subStr) {
        char[] charArray = subStr.toCharArray();
        if (charArray.length == 1) {
            return false;
        }
        int left = 0, right = charArray.length - 1;

        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }



}
