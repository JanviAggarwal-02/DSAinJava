static Node insertBeginning(Node head, int x) {

    Node newNode = new Node(x);

    newNode.next = head;

    head = newNode;

    return head;
}