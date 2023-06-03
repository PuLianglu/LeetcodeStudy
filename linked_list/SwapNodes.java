import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @program: LeetcodeStudy
 * @description: 交换链表的节点
 * https://leetcode.cn/problems/swap-nodes-in-pairs/
 * @author: puLiangLu
 * @create: 2023-06-02 17:14
 **/



public class SwapNodes {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        while(temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }

    /**
     * 数组转链表，不带头节点
     * @return
     */
    ListNode arrayToList(int[] array){
        if (array.length == 0){
            return new ListNode(-1);
        }
        ListNode head = new ListNode();
        ListNode cur = new ListNode();
        for (int i = 0; i < array.length; i++) {
            if (i == 0){
                head.val = array[i];
                head.next = null;
                cur = head;
            }else {
                ListNode temp = new ListNode(array[i]);
                temp.next = null;
                cur.next = temp;
                cur = temp;
            }

        }


        return head;
    }

    /**
     * 链表转数组
     * @param
     */
    Integer[] listToArray(ListNode head){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        ListNode h = head;
        while (h != null){
            if (h.val != -1){
                arrayList.add(h.val);
            }
            h = h.next;
        }

        return arrayList.toArray(new Integer[arrayList.size()]);

    }


    public static void main(String[] args) {
        SwapNodes swapNodes = new SwapNodes();
        int[] head = new int[]{1,2,3,4};
        ListNode listNode = swapNodes.arrayToList(head);

        ListNode a =  swapNodes.swapPairs(listNode);
        Integer[] integers = swapNodes.listToArray(a);
        System.out.println("==============");
    }
}
