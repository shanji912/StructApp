package com.saint.struct.practice;

import android.util.Log;

import com.saint.struct.bean.Node;

public class InterviewFunc {
    public void lightFunc() {
        boolean[] light = new boolean[100];
        for (int i = 0; i < 100; i++) {
            for (int j = i; j < 100; j = j + i + 1) {
                light[j] = !light[j];
            }
        }

        for (int i = 0; i < 100; i++) {
            if (light[i]) {
//                System.out.print(i + " ");
                Log.d("light", i + 1 + " ");
            }
        }
    }


    public int removeElement(int[] A, int elem) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int index = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != elem) {
                A[index++] = A[i];
            }
        }

        return index;
    }


    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int size = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != A[size]) {
                A[++size] = A[i];
            }
        }
        return size + 1;
    }

    /**
     * 链表翻转
     * @param node 头节点
     * @return
     */
    public Node reverseList(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node pre = null;
        Node next = null;
        while (node != null) {
            next = node.next;//保存下一个节点
            node.next = pre;//重置next
            pre = node;//保存当前节点
            node = next;//指向下个节点
        }

        return pre;
    }

    /**
     * 删除节点
     * @param node
     */
    public Node deleteNode(Node head, Node nodeToBeDel) {
        if (head == null ) {
            return null;
        }
        if (nodeToBeDel == null) {
            return head;
        }
        if (nodeToBeDel.next != null) {
            // 被删除的是中间节点
            nodeToBeDel.value = nodeToBeDel.next.value;
            nodeToBeDel.next = nodeToBeDel.next.next;
        } else if (head == nodeToBeDel) {
            // 被删除的是头节点
            head = null;
        }else {
            // 被删除的是尾部节点
            Node node = head;
            while (node.next != nodeToBeDel) {
                node = node.next;
            }
            node.next = null;
        }
        return head;
    }
}
