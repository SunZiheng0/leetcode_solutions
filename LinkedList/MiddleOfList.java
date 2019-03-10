package leetcode.LinkedList;

public class MiddleOfList {
    public ListNode middleNode(ListNode head) {

        ListNode slow = head, fast = head;
        //退出循环的时候，已经slow多走了一格，在奇数的正中间，或者偶数的后半第一个
        //如果有2n个，则fast走 2n 进入 null， slow 走 n，在n+1位置
        //如果有2n+1个，则fast走2n 进入 2n+1, fast.next == null， slow在 n+1位置
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
