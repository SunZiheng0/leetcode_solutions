package leetcode.LinkedList;
/*
61. Rotate List
Medium

Given a linked list, rotate the list to the right by k places, where k is non-negative.
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        int length = 0;
        ListNode fast = head;
        while(fast != null){
            length++;
            fast = fast.next;
        }
        k = k % length; //考虑null ，否则length为零
        ListNode slow = head;
        fast = head;
        while(k-- > 0) fast = fast.next;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = head;       //考虑k = 0, 要先接上fast，否则result = null
        ListNode result = slow.next;
        slow.next = null;      //要记得切断slow
        return result;
    }
}
