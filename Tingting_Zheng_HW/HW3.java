public class HW3 {
    // Leetcode 206. Reverse Linked List
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while(head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }
    
    // Leetcode 83. Remove Duplicates from Sorted List
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode res = head;
        while(head!=null && head.next != null){
            if(head.next.val != head.val){
                head = head.next;
            }else{
                head.next = head.next.next;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println("Pilot_HW3");
    } 
}

