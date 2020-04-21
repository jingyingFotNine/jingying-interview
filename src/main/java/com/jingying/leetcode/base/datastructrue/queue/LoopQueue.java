package com.jingying.leetcode.base.datastructrue.queue;

/**
 * 循环队列
 * 逻辑结构: 队列
 * 物理结构: 线性存储(数组)
 * 普通队列的问题:
 * 当频繁入队出队后，指针指向的位置并非队头
 * <p>
 * author by beijita@weilaicheng.com
 * 2020/4/21
 *
 * @author xiangzhi.meng
 */
public class LoopQueue {

    /**
     * 队头指针
     */
    int font;

    /**
     * 队尾指针
     */
    int rear;

    /**
     * 队列长度
     */
    int size;

    /**
     * 线性存储
     */
    int array[];

    public LoopQueue(int size) {
        this.size = size;
        this.array = new int[size];
        this.font = this.rear = 0;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return rear == font;
    }

    /**
     * 判断队满
     *
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % size == font;
    }

    /**
     * 入队操作
     *
     * @param
     */
    public void enqueue(int data) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("队列已满");
        }
        // 入队
        array[rear] = data;
        // 队尾指针加1
        rear = (rear + 1) % size;
    }

    /**
     * 出队
     *
     * @return
     */
    public int dequeue() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("队列已空");
        }
        int ret = array[font];
        font = (font + 1) % size;
        return ret;
    }

    /**
     * 获取队列现在的长度
     *
     * @return
     */
    public int getSize() {
        /**
         *  + size :
         *      防止 rear 比 font 小
         */
        return (rear - font + size) % size;
    }

    public static void main(String[] args) {
        LoopQueue loopQueue = new LoopQueue(10);
        loopQueue.enqueue(1);
        loopQueue.enqueue(2);
        loopQueue.enqueue(3);

        System.out.println(loopQueue.dequeue());
        System.out.println("队列的长度:" + loopQueue.getSize());

    }

}
