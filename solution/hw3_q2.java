/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode node = head;
        ListNode nodenext = head.next;
        while (node != null) {
            if (nodenext != null && node.val == nodenext.val){
                nodenext = nodenext.next;
            } else {
                node.next = nodenext;
                node = node.next;
                if (nodenext != null) {
                    nodenext = nodenext.next;
                }
            }
        }
        return head;
    }
}