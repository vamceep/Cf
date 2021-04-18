import java.util.*;

import jdk.incubator.jpackage.main.Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.File;

class Solution2 {
    public static void main(String[] afsadr) throws IOException {

    }

    public Node findMiddle(Node head) {
        Node slow = head;
        Node fast = head;
        if(head == null) return head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Truck truck = new Truck();
        truck.travel();
        return slow;
    }
}

class Node {
    private int data;
    private Node next;

    public Node(int val) {
        data = val;
    }
}