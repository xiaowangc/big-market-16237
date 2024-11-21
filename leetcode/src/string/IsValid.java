package string;

import java.util.*;

/**
 * @author wangyc
 * @date 2023/2/27
 */
public class IsValid {
    private static Map<Character, Character> map = new HashMap<>();
    static {
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        LinkedList<Integer> list = new LinkedList<>();
        list.removeLast();
        list.removeFirst();
        list.add(1);
        list.getLast();
        char[] c = s.toCharArray();
        for (char i : c) {
            if (!stack.isEmpty() && stack.peek() == map.get(i)) {
                stack.pop();
                continue;
            }
            stack.push(i);
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "([{])[]";
        System.out.println(isValid(s));
        String s1 = UUID.randomUUID().toString();
        System.out.println(s1 + "/n" + s1.substring(s1.lastIndexOf('-') + 1));
    }
}
