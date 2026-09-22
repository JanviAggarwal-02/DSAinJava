static Node moveMinMax(Node head) {

    if (head == null || head.next == null) {
        return head;
    }

    Node min = head;
    Node max = head;

    Node minPrev = null;
    Node maxPrev = null;

    Node prev = null;
    Node temp = head;

    while (temp != null) {

        if (temp.data < min.data) {
            min = temp;
            minPrev = prev;
        }

        if (temp.data > max.data) {
            max = temp;
            maxPrev = prev;
        }

        prev = temp;
        temp = temp.next;
    }

    // Remove minimum from its position
    if (minPrev != null) {
        minPrev.next = min.next;
    } else {
        head = min.next;
    }

    // If max was after min, its previous node may have changed
    if (max == head) {
        // handled below
    }

    // Find last node
    Node last = head;
    if (last == null) {
        min.next = null;
        return min;
    }

    while (last.next != null) {
        last = last.next;
    }

    last.next = min;
    min.next = null;

    return min;
}