/**
 * @program: LeetcodeStudy
 * @description: 环形链表
 * https://leetcode.cn/problems/linked-list-cycle-ii/
 * @author: puLiangLu
 * @create: 2023-06-05 15:27
 **/
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null ){
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast){
                ListNode a = slow;
                ListNode b = head;

                while (a != b){
                    a = a .next;
                    b = b.next;
                }
                return a;
            }
        }

        return null;
    }
}
