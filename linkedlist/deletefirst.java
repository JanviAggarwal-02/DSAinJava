static Node deleteFirst(Node head) {

    if (head == null) {
        return null;
    }

    return head.next;
}