class Main {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static boolean search(Node head, int key) {

        Node temp = head;

        while (temp != null) {

            if (temp.data == key) {
                return true;
            }

            temp = temp.next;
        }

        return false;
    }

    public static void main(String[] args) {

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        System.out.println(search(head, 30));
    }
}