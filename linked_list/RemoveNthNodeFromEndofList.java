/**
 * @program: LeetcodeStudy
 * @description: 删除链表的倒数第n个节点
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 * @author: puLiangLu
 * @create: 2023-06-03 10:17
 **/
public class RemoveNthNodeFromEndofList {


    /**
     * 前后指针解法
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n){
        ListNode listNode = new ListNode(0);
        listNode.next = head;
        ListNode pre = listNode;
        ListNode cur = head;

        for (int i = 0; i < n; i++) {
            cur = cur.next;
        }

        while (cur != null){
            cur = cur.next;
            pre = pre.next;
        }

        cur = pre.next;
        pre.next = pre.next.next;
        cur = null;

        return listNode.next;
    }

    /**
     * 常规解法
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode listNode = new ListNode(0);
        listNode.next = head;
        int len = 0;
        ListNode temp = listNode.next;

        while (temp != null){
            len++;
            temp = temp.next;
        }

        if (n > len){
            return head;
        }
        temp = listNode.next;
        ListNode cur = listNode;
        int i = 1;
        while (temp != null){
            if (i == len - n + 1){
                cur.next = temp.next;
                temp.next = null;
                break;
            }
            cur = temp;
            temp = temp.next;
            i++;
        }
        return listNode.next;
    }


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


    public static void main(String[] args) {

        int[] b = new int[] {1,2,3,4,5};
        RemoveNthNodeFromEndofList a = new RemoveNthNodeFromEndofList();
        ListNode head =  a.arrayToList(b);
        a.removeNthFromEnd(head,2);
    }
}
