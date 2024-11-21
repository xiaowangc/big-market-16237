package string;

import common.domain.TreeNode;

import java.util.*;

/**
 * 第一次只出现一次的字符
 *
 * @author wangyc
 * @date 2023/3/11
 */
public class FirstUniqChar {

    public static char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        list.add(0,2);
        list.add(0,3);
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(char c : s.toCharArray()) {
            if(map.get(c) == 1) {
                return c;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        String num = "2147483648";
        // q: 将num转化为int类型
        // a: 1. 使用Integer.parseInt()方法
        System.out.println(Long.parseLong(num));
        System.out.println(Long.MAX_VALUE);

    }
    // 编写一个二叉树的层序遍历




    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (isEquals(A, B) || isSubStructure(A.getLeft(), B) || isSubStructure(A.getRight(), B));
    }

    private static boolean isEquals(TreeNode a, TreeNode b) {
        if(b == null) {
            return true;
        }
        if(a == null || a.getVal() != b.getVal()) {
            return false;
        }
        return isEquals(a.getLeft(), b.getRight()) && isEquals(a.getRight(), b.getRight());
    }
}
