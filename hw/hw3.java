/*
leetcode 206 easy

Given the head of a singly linked list, reverse the list, and return the reversed list.

Input: head = [1,2,3,4,5]. 1->2->3->4->5
Output: [5,4,3,2,1]. 5->4->3->2->1

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

class Solution {
    public ListNode reverseList(ListNode head) {

    }
}


83
        Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

        Input: head = [1,1,2]
        Output: [1,2]

class Solution {
    public ListNode deleteDuplicates(ListNode head) {

    }
}

*/

public class hw3 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next;
      }
    }
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode nextNode=head.next;
        ListNode newHead=reverseList(nextNode);
        nextNode.next=head;
        head.next=null;
        return newHead;
    }
    /*
83
Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

Input: head = [1,1,2]
Output: [1,2]
*/
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(Integer. MIN_VALUE);
        dummy.next = head;
        ListNode cur = dummy;
        while(cur != null && cur.next != null){
            if(cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }return dummy.next;
    }
}


