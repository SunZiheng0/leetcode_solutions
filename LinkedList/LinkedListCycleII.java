package leetcode.LinkedList;
/*
142. Linked List Cycle II
Medium

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.

Note: Do not modify the linked list.



Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.

Let's say slow loop n times and fast loop m times in a circle before meet.
2*(x1 + x2) + 2n*(x3 + x2) = (x1 + x2 + x3 + x2) + m*(x3 + x2)
If n=2 and m=3,
x1 + (x2 + x3) = x3
If n=2 and m=4,
x1 = x3
if n=2 and m=5,
x1 = x3 + (x2 + x3)
...
x1 = x3 + (x2 + x3) + (x2 + x3) .. (x2 + x3)
The key point is that (x3 + x2) is full circle size.
 */
public class LinkedListCycleII {

    //solution

    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                ListNode slow2 = head;
                while(slow != slow2){
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }
}
