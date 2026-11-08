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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next==null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode last = dummy;

        for(int i=0;i<left-1;i++){
            first = first.next;
        }
        for(int i=0;i<=right;i++){
            last = last.next;
        }

        ListNode end1 = first.next;
        ListNode prev = first.next;
        ListNode curr = prev.next;
        ListNode temp;

        while(curr != last){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        end1.next = last;
        first.next = prev;

        return dummy.next;
    }
}