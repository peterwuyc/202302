public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode rest = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = rest;
            rest = head;
            head = tmp;
        }
        return rest;
  
    }
  }