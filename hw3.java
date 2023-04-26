
class Solution {
  public ListNode reverseList(ListNode head) {

    ListNode prev = null;
    ListNode curNode = head;
    while (curNode != null) {
      ListNode nextTemp = curNode.next;
      curNode.next = prev;
      prev = curNode;
      curNode = nextTemp;
    }
    return prev;
  }
}

class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode current = head;
    while (current != null && current.next != null) {
      if (current.next.val == current.val) {
        current.next = current.next.next;
      } else {
        current = current.next;
      }
    }
    return head;
  }
}