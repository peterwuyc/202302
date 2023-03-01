package homework03;

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode cur = head;
        ListNode p = head.next;
        while(p != null){
            if (cur.val != p.val)
                cur = cur.next = p;
            p = p.next;
        }
        cur.next = null;
        return head;
    }
}
