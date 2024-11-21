package common.domain;

/** 包含下一个节点为随机节点
 * @author wangyc
 * @date 2023/3/6
 */
public class RandomNode {

    private int val;
    private RandomNode next;
    // 随机节点
    private RandomNode randomNode;

    public RandomNode(int val) {
        this.val = val;
    }

    public RandomNode() {

    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public RandomNode getNext() {
        return next;
    }

    public void setNext(RandomNode next) {
        this.next = next;
    }

    public RandomNode getRandomNode() {
        return randomNode;
    }

    public void setRandomNode(RandomNode randomNode) {
        this.randomNode = randomNode;
    }
}
