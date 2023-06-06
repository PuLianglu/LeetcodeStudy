import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: LeetcodeStudy
 * @description: 两个数组的交集
 * https://leetcode.cn/problems/intersection-of-two-arrays/
 * @author: puLiangLu
 * @create: 2023-06-06 14:50
 **/
public class IntersectionofTwoArrays {

    public Integer[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> a = new HashSet<Integer>();

        for (int i = 0; i < nums1.length; i++) {
            a.add(nums1[i]);
        }

        List<Integer> b = new ArrayList<>();

        for (int i = 0; i < nums2.length; i++) {
            if (a.contains(nums2[i])){
                b.add(nums2[i]);
                a.remove(nums2[i]);
            }
        }

        return b.stream().toArray(Integer[]::new);
    }


    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1}, nums2 = {2,2};

        IntersectionofTwoArrays a = new IntersectionofTwoArrays();
        Integer[] c = a.intersection(nums1,nums2);
        System.out.println("================");
    }
}
