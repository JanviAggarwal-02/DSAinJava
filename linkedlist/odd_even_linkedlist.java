class Solution {
    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {

            // connect odd nodes
            odd.next = even.next;
            odd = odd.next;

            // connect even nodes
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;

        return head;
    }
}