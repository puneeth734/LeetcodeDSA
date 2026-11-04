/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode alist = headA;
        ListNode blist = headB;

        while(alist != blist){
            alist = (alist == null)? headB : alist.next;
            blist = (blist == null)? headA : blist.next;
        }
        return alist;
    }
}