class Main {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static void findMiddle(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println("Middle = " + slow.data);
    }

    public static void main(String[] args) {

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        findMiddle(head);
    }
}