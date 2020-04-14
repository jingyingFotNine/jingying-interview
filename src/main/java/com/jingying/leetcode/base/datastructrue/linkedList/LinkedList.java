package com.jingying.leetcode.base.datastructrue.linkedList;

import java.awt.*;

/**
 * author by beijita@weilaicheng.com
 * 2020/4/14
 *
 * @author xiangzhi.meng
 */
public class LinkedList {
    /**
     * 链表长度
     */
    private int size;

    /**
     * 链表头结点
     */
    private Node head;

    /**
     * 链表尾节点
     */
    private Node last;

    private static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * 插入节点
     *
     * @param val
     * @param index
     * @throws Exception
     */
    public void insert(int val, int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("链表范围超出！");
        }
        Node node = new Node(val);
        if (size == 0) {
            // 空链表
            head = node;
            last = node;
        } else if (index == 0) {
            // 头插
            node.next = head;
            head = node;

        } else if (index == size) {
            // 尾插
            last.next = node;
            last = node;
        } else {
            // 中间插入
            Node preNode = getByIndex(index - 1);
            node.next = preNode.next;
            preNode.next = node;

        }
        size++;
    }

    /**
     * 根据index 找Node
     *
     * @param index
     * @return
     */
    public Node getByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("链表范围超出!");
        }
        Node head = this.head;
        for (int i = 0; i < index; i++) {
            head = head.next;
        }
        return head;
    }

    /**
     * 删除节点
     *
     * @param index
     * @return
     * @throws Exception
     */
    public Node remove(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("链表范围超出!");
        }
        Node node = null;
        if (index == 0) {
            // 删除头结点
            node = head;
            head = head.next;
        } else if (index == size - 1) {
            // 删除尾节点
            Node preNode = getByIndex(index - 1);
            node = preNode.next;
            preNode.next = null;
            last = preNode;
        } else {
            // 删除中间节点
            Node preNode = getByIndex(index - 1);
            node = preNode.next;
            preNode.next = preNode.next.next;
        }
        size--;
        return node;
    }

    /**
     * 输出链表
     */
    public void out() {
        Node head = this.head;
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) throws Exception {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(1, 0);
        linkedList.insert(2, 1);
        linkedList.insert(3, 2);
        linkedList.insert(4, 3);
        linkedList.insert(5, 1);
        linkedList.remove(0);
        linkedList.out();
    }

}
