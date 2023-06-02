import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetcodeStudy
 * @description: 移除链表元素
 *  https://leetcode.cn/problems/remove-linked-list-elements/
 * @author: puLiangLu
 * @create: 2023-05-31 21:55
 **/
public class removeElements {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        int[] head = {1,2,6,3,4,5,6};


        removeElements a = new removeElements();

        ListNode h =a.arrayToList(head);
        ListNode listNode = a.removeElements(h, 6);


        Integer[] b = a.listToArray(listNode);

        System.out.println("====================");
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode h = head;
        ListNode current = head;
        ListNode last = head;

        while (current != null){
            if (current.val == val ){
                if (current == h){
                    h = current.next;
                }
                //移除当前节点
                last.next = current.next;
            }else {
                last = current;
            }

            current = current.next;
        }

        return h;
    }

    /**
     * 数组转有头节点的链表
     * @param array
     * @return
     */
    public ListNode arrayToList(int array[]){
        ListNode h = new ListNode();
        ListNode current = h;

        if (array.length == 0){
            h.val = 51;
            return h;
        }

        for (int i=0; i < array.length; i++){
            if (i == 0){
                h.val = array[i];
            }else {
                ListNode node = new ListNode();
                node.val = array[i];
                current.next = node;
                current = node;
            }
        }

        return h;
    }

    /**
     * 带头节点的链表转数组
     */
    public Integer[] listToArray(ListNode h){
        int length = h.val;
        if (h.val == 51){
            return new Integer[0];
        }
        List<Integer> array = new ArrayList<>();
        while (h.next != null){
            array.add(h.val);
            h = h.next;
        }
        return array.toArray(new Integer[0]);
    }

}
