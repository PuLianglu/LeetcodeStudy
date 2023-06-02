/**
 * @program: LeetcodeStudy
 * @description: 反转链表
 * https://leetcode.cn/problems/reverse-linked-list/
 * @author: puLiangLu
 * @create: 2023-06-02 09:27
 **/
public class ReverseLinkedList {

  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode reverseList(ListNode head) {

        ListNode first = null;
        ListNode second = head;

        while (second != null){
            ListNode temp = second.next;
            second.next = first;
            first = second;
            second = temp;
        }

        return first;
    }



}
