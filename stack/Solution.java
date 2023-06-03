import java.util.LinkedList;

/**
 * @program: LeetcodeStudy
 * @description:
 * @author: puLiangLu
 * @create: 2023-01-27 09:11
 **/

// Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> myStack = new LinkedList<>();
        while (head != null){
            myStack.push(head.val);
            head = head.next;
        }
        int[] men = new int[myStack.size()];
        for (int i = 0; i < men.length; ++i){
            men[i] = myStack.pop();
        }

        return men;
    }


    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(2);
        a.next = b;
        b.next = c;

        Solution solution = new Solution();
        System.out.println(solution.reversePrint(a));
    }
}
