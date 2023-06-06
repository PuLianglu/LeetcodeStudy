import javafx.scene.image.PixelFormat;

import java.util.ArrayList;

/**
 * @program: LeetcodeStudy
 * @description: 链表相交
 * https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/
 * @author: puLiangLu
 * @create: 2023-06-05 10:24
 **/
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA;
        ListNode pb = headB;
        int lenA = 0;
        int lenB = 0;
        //先遍历两个链表的全部长度
        while(pa != null){
            lenA++;
            pa = pa.next;
        }

        while (pb != null){
            lenB++;
            pb = pb.next;
        }


        int a = Math.abs(lenA - lenB);
        int len = 0;
        //让pa最长
        if (a < 0 ){
            pa = headB;
            pb = headA;
            len = lenB - a;
        }else {
            len = lenA - a;
            pa = headA;
            pb = headB;
        }

        while (a != 0){
            a--;
            pa = pa.next;
        }

        while (len != 0){
            if (pa != pb){
                pa = pa.next;
                pb = pb.next;
            }else {
                return pa;
            }

        }
        return null;
    }

    Integer[] listToArray(SwapNodes.ListNode head){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        SwapNodes.ListNode h = head;
        while (h != null){
            if (h.val != -1){
                arrayList.add(h.val);
            }
            h = h.next;
        }

        return arrayList.toArray(new Integer[arrayList.size()]);

    }


    public static void main(String[] args) {
        IntersectionOfTwoLinkedLists a = new IntersectionOfTwoLinkedLists();
        //a.listToArray()

    }
}
