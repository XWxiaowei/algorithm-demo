package queue09;

/**
 * @author xiang.wei
 * @date 2019/12/4 21:09
 */
public class ArrayQueue2 {
    /**
     * 数组：items,数组大小：n
     */
    private String[] items;
    private int n = 0;
    /**
     * head表示队头下标，tail表示队尾下标
     */
    private int head = 0;
    private int tail = 0;

    /**
     * 申请一个大小为capacity的数组
     *
     * @param capacity
     */
    public ArrayQueue2(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    /**
     * 入队
     *
     * @param item
     * @return
     */
    public boolean enqueue(String item) {
        //如果tail==n 表示队列已满了
        if (tail == n) {
           //tail==n&&head==0，表示整个队列都占满了
            if (head == 0) {
                return false;
            }
            //数据搬移
            for (int i=head;i<tail;++i) {
                items[i - head] = items[i];
            }
            //搬迁完之后重新更新head和tail
            tail -= head;
            head = 0;
        }
        items[tail] = item;
        ++tail;
        return true;
    }


    /**
     * 出队
     *
     * @return
     */
    public String dequeue() {
        //如果head==tail表示队列为空
        if (head == tail) {
            return null;
        }
        String ret = items[head];
        ++head;
        return ret;
    }

    public static void main(String[] args) {
        ArrayQueue2 arrayQueue = new ArrayQueue2(10);
        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue("item" + i);
            System.out.println("item" + i+"入队");
        }
        for (int i=0;i<10;i++) {
            String dequeue = arrayQueue.dequeue();
            System.out.println(dequeue + "出队");
        }
    }
}
