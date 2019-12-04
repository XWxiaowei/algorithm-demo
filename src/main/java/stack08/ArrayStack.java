package stack08;

/**
 * 基于数组实现的顺序栈
 *
 * @author xiang.wei
 * @date 2019/12/4 20:49
 */
public class ArrayStack {
    /**
     * 数组
     */
    private String[] items;
    /**
     * 栈中元素个数
     */
    private int count;
    /**
     * 栈的大小
     */
    private int n;

    /**
     * 初始化一个栈
     *
     * @param n
     */
    public ArrayStack(int n) {
        this.items = new String[n];
        this.n = n;
        this.count = 0;
    }

    /**
     * 入栈操作
     *
     * @param item
     * @return
     */
    public boolean push(String item) {
        //数组空间不够了，直接返回false，入栈失败
        if (count == n) {
            return false;
        }
        //将item放到下标为count的位置，并且count加一
        items[count] = item;
        ++count;
        return true;
    }

    /**
     * 出栈操作
     *
     * @return
     */
    public String pop() {
        if (count == 0) {
            return null;
        }
        //返回下标为count-1的数组元素，并且栈中的元素个数count减一
        String temp = items[count - 1];
        --count;
        return temp;
    }


    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(10);
        for (int i=0;i<10;i++) {
            System.out.println("item" + i + "入栈");
            arrayStack.push("item" + i);
        }
        for (int i = 0; i < 10; i++) {
            String pop = arrayStack.pop();
            System.out.println(pop+"出栈");
        }
    }
}
