static Node deleteValue(Node head, int x) {

    if (head == null) {
        return null;
    }

    if (head.data == x) {
        return head.next;
    }

    Node temp = head;

    while (temp.next != null) {

        if (temp.next.data == x) {

            temp.next = temp.next.next;
            break;
        }

        temp = temp.next;
    }

    return head;
}