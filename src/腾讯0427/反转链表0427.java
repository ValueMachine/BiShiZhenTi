package 腾讯0427;

import java.util.LinkedList;
import java.util.Scanner;

public class 反转链表0427 {
    static class Node {
        int val;
        Node next;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = new Node(sc.nextInt());
        Node node2 = new Node(sc.nextInt());
        Node node3 = new Node(sc.nextInt());
        Node node4 = new Node(sc.nextInt());
        Node node5 = new Node(sc.nextInt());
        sc.close();
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Node res = ReverseNode(head);
        for (int i = 0; i < 5; i++) {
            if (i==4) System.out.println(res.val);
            else {
                System.out.print(res.val + "->");
                res = res.next;
            }
        }
    }

    public static Node ReverseNode(Node head) {
        Node pre = null;
        Node cur = head;
        Node temp ;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
