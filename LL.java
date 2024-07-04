public class LL {
    public static class LinkedList {
        private Node head;
        private Node tail;
        private int length;

        class Node {
            int value;
            Node next;

            Node(int value) { // constructor for Node class
                this.value = value;
                this.next = null;
            }
        }

        // constructor for linked List class
        LinkedList(int value) {
            Node newNode = new Node(value);
            head = newNode;
            tail = newNode;
            length = 1;
        }

        // print linked list
        public void printList() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.value + "-->");
                temp = temp.next;
            }
            System.out.println("null");
        }

        // add at last in a linked list
        public void append(int value) {
            Node newNode = new Node(value);
            if (length == 0) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            length++;
        }

        // add at first in a linked list
        public void prepend(int value) {
            Node newNode = new Node(value);
            if (length == 0) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }
            length++;
        }

        // remove last elemnet in a linked list
        public Node removeLast() {
            if (length == 0)
                return null;
            Node temp = head;
            Node prev = head;
            while (temp.next != null) {
                prev = temp;
                temp = temp.next;
            }
            tail = prev;
            tail.next = null;
            length--;
            if (length == 0) {
                head = null;
                tail = null;
            }
            return temp;
        }

        // remove first elemnet in a linked list
        public Node removeFirst() {
            if (length == 0)
                return null;
            Node temp = head;
            head = head.next;
            temp.next = null;
            length--;
            if (length == 0) {
                tail = null;
            }
            return temp;
        }

        public Node get(int index) {
            if (index < 0 || index >= length)
                return null;
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        }

        public boolean set(int index, int value) {
            Node temp = get(index);
            if (temp != null) {
                temp.value = value;
                return true;
            }
            return false;
        }

        public void reverse() {
            Node temp = head;
            head = tail;
            tail = temp;
            Node after = temp.next;
            Node before = null;
            for (int i = 0; i < length; i++) {
                after = temp.next;
                temp.next = before;
                before = temp;
                temp = after;
            }
        }

    }

    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList(4);
        myLinkedList.append(8);
        myLinkedList.prepend(1);
        myLinkedList.append(12);
        myLinkedList.prepend(0);
        myLinkedList.printList();
        System.out.println();
        System.out.println("Last Number in LinkedList : " + myLinkedList.removeLast().value);
        System.out.println("First Number in LinkedList : " + myLinkedList.removeFirst().value);
        myLinkedList.printList();
        System.out.println();
        System.out.println(myLinkedList.get(2).value);
        myLinkedList.set(1, 8);
        myLinkedList.printList();
        System.out.println();
        myLinkedList.set(2, 29);
        myLinkedList.printList();
        System.out.println();
        myLinkedList.append(18);
        myLinkedList.reverse();
        myLinkedList.printList();
    }
}